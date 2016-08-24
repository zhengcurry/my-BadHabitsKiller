package com.curry.bhk.bhk.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.curry.bhk.bhk.R;
import com.curry.bhk.bhk.activity.BaseActivity;
import com.curry.bhk.bhk.adapter.NewListitemAdapter;
import com.curry.bhk.bhk.bean.EventBean;
import com.curry.bhk.bhk.sqlite.EventdbOperator;

import java.util.List;

/**
 * Created by Curry on 2016/8/19.
 */
public class OnHoldFragment extends Fragment {

    private List<EventBean> mEventBeanList;
    private ListView mListView;

    private EventdbOperator eventdbOperator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onhold_fragment, null);
        mListView = (ListView) view.findViewById(R.id.onHoldListView);
        dataInit();
        return view;
    }

    private void dataInit(){
        TextView tv = (TextView)getActivity().findViewById(R.id.title_bar_name);
        tv.setText("On Hold");

        EventBean eventBean = new EventBean();
        eventBean.setStatus(2);
        eventBean.setResolvedby(BaseActivity.mUsername);

        eventdbOperator = new EventdbOperator(getActivity());
        mEventBeanList = eventdbOperator.queryEvent(5, eventBean);

        NewListitemAdapter newListitemAdapter = new NewListitemAdapter(getActivity(), mEventBeanList);
        mListView.setAdapter(newListitemAdapter);

        newListitemAdapter.notifyDataSetChanged();

    }

}
