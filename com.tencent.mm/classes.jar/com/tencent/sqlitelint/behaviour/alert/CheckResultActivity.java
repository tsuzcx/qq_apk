package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckResultActivity
  extends SQLiteLintBaseActivity
{
  public static final String KEY_DB_LABEL = "db_label";
  private static final String TAG = "MpApp.CheckResultActivity";
  private CheckResultListAdapter mAdapter;
  private List<SQLiteLintIssue> mCheckResultList;
  private String mDbLabel;
  
  private void initView()
  {
    AppMethodBeat.i(94045);
    setTitle(getString(2131306136, new Object[] { SQLiteLintUtil.extractDbName(this.mDbLabel) }));
    ListView localListView = (ListView)findViewById(2131821002);
    this.mAdapter = new CheckResultListAdapter();
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(94036);
        paramAnonymousAdapterView = (SQLiteLintIssue)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("issue", paramAnonymousAdapterView);
        paramAnonymousView.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
        CheckResultActivity.this.startActivity(paramAnonymousView);
        AppMethodBeat.o(94036);
      }
    });
    localListView.setAdapter(this.mAdapter);
    this.mAdapter.notifyDataSetChanged();
    AppMethodBeat.o(94045);
  }
  
  private void refreshData()
  {
    AppMethodBeat.i(94044);
    List localList = IssueStorage.getIssueListByDb(this.mDbLabel);
    if (this.mCheckResultList == null) {
      this.mCheckResultList = localList;
    }
    for (;;)
    {
      SLog.d("MpApp.CheckResultActivity", "refreshData size %d", new Object[] { Integer.valueOf(this.mCheckResultList.size()) });
      this.mAdapter.notifyDataSetChanged();
      AppMethodBeat.o(94044);
      return;
      this.mCheckResultList.clear();
      this.mCheckResultList.addAll(localList);
    }
  }
  
  protected int getLayoutId()
  {
    return 2130968622;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94042);
    super.onCreate(paramBundle);
    this.mDbLabel = getIntent().getStringExtra("db_label");
    initView();
    refreshData();
    AppMethodBeat.o(94042);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(94043);
    super.onNewIntent(paramIntent);
    refreshData();
    AppMethodBeat.o(94043);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  class CheckResultListAdapter
    extends BaseAdapter
  {
    private final LayoutInflater mInflater;
    
    CheckResultListAdapter()
    {
      AppMethodBeat.i(94037);
      this.mInflater = LayoutInflater.from(CheckResultActivity.this);
      AppMethodBeat.o(94037);
    }
    
    public int getCount()
    {
      AppMethodBeat.i(94038);
      if (CheckResultActivity.this.mCheckResultList == null)
      {
        AppMethodBeat.o(94038);
        return 0;
      }
      int i = CheckResultActivity.this.mCheckResultList.size();
      AppMethodBeat.o(94038);
      return i;
    }
    
    public SQLiteLintIssue getItem(int paramInt)
    {
      AppMethodBeat.i(94039);
      SQLiteLintIssue localSQLiteLintIssue = (SQLiteLintIssue)CheckResultActivity.this.mCheckResultList.get(paramInt);
      AppMethodBeat.o(94039);
      return localSQLiteLintIssue;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(94040);
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2130971077, paramViewGroup, false);
        paramViewGroup = new CheckResultActivity.ViewHolder();
        paramViewGroup.checkResultTv = ((TextView)paramView.findViewById(2131828214));
        paramViewGroup.diagnosisLevelTv = ((TextView)paramView.findViewById(2131821005));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131821004));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        SQLiteLintIssue localSQLiteLintIssue = getItem(paramInt);
        paramViewGroup.checkResultTv.setText(String.format("%d、%s", new Object[] { Integer.valueOf(paramInt + 1), localSQLiteLintIssue.desc }));
        paramViewGroup.timeTv.setText(SQLiteLintUtil.formatTime("yyyy-MM-dd HH:mm", localSQLiteLintIssue.createTime));
        paramViewGroup.diagnosisLevelTv.setText(SQLiteLintIssue.getLevelText(localSQLiteLintIssue.level, CheckResultActivity.this.getBaseContext()));
        AppMethodBeat.o(94040);
        return paramView;
        paramViewGroup = (CheckResultActivity.ViewHolder)paramView.getTag();
      }
    }
  }
  
  static class ViewHolder
  {
    public TextView checkResultTv;
    public TextView diagnosisLevelTv;
    public TextView timeTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckResultActivity
 * JD-Core Version:    0.7.0.1
 */