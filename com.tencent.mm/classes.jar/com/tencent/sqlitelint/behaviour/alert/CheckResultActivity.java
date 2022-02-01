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
import com.tencent.sqlitelint.R.id;
import com.tencent.sqlitelint.R.layout;
import com.tencent.sqlitelint.R.string;
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
    AppMethodBeat.i(52889);
    Object localObject = SQLiteLintUtil.extractDbName(this.mDbLabel);
    setTitle(getString(R.string.check_result_title, new Object[] { localObject }));
    localObject = (ListView)findViewById(R.id.list);
    this.mAdapter = new CheckResultListAdapter();
    ((ListView)localObject).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(52880);
        paramAnonymousView = (SQLiteLintIssue)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("issue", paramAnonymousView);
        paramAnonymousAdapterView.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
        paramAnonymousView = CheckResultActivity.this;
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aFh(), "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(52880);
      }
    });
    ((ListView)localObject).setAdapter(this.mAdapter);
    this.mAdapter.notifyDataSetChanged();
    AppMethodBeat.o(52889);
  }
  
  private void refreshData()
  {
    AppMethodBeat.i(52888);
    List localList = IssueStorage.getIssueListByDb(this.mDbLabel);
    if (this.mCheckResultList == null) {
      this.mCheckResultList = localList;
    }
    for (;;)
    {
      SLog.d("MpApp.CheckResultActivity", "refreshData size %d", new Object[] { Integer.valueOf(this.mCheckResultList.size()) });
      this.mAdapter.notifyDataSetChanged();
      AppMethodBeat.o(52888);
      return;
      this.mCheckResultList.clear();
      this.mCheckResultList.addAll(localList);
    }
  }
  
  protected int getLayoutId()
  {
    return R.layout.activity_check_result;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52886);
    super.onCreate(paramBundle);
    this.mDbLabel = getIntent().getStringExtra("db_label");
    initView();
    refreshData();
    AppMethodBeat.o(52886);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(52887);
    super.onNewIntent(paramIntent);
    refreshData();
    AppMethodBeat.o(52887);
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
      AppMethodBeat.i(52881);
      this.mInflater = LayoutInflater.from(CheckResultActivity.this);
      AppMethodBeat.o(52881);
    }
    
    public int getCount()
    {
      AppMethodBeat.i(52882);
      if (CheckResultActivity.this.mCheckResultList == null)
      {
        AppMethodBeat.o(52882);
        return 0;
      }
      int i = CheckResultActivity.this.mCheckResultList.size();
      AppMethodBeat.o(52882);
      return i;
    }
    
    public SQLiteLintIssue getItem(int paramInt)
    {
      AppMethodBeat.i(52883);
      SQLiteLintIssue localSQLiteLintIssue = (SQLiteLintIssue)CheckResultActivity.this.mCheckResultList.get(paramInt);
      AppMethodBeat.o(52883);
      return localSQLiteLintIssue;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(52884);
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(R.layout.view_check_result_item, paramViewGroup, false);
        paramViewGroup = new CheckResultActivity.ViewHolder();
        paramViewGroup.checkResultTv = ((TextView)paramView.findViewById(R.id.result_tv));
        paramViewGroup.diagnosisLevelTv = ((TextView)paramView.findViewById(R.id.diagnosis_level_tv));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(R.id.time_tv));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        SQLiteLintIssue localSQLiteLintIssue = getItem(paramInt);
        paramViewGroup.checkResultTv.setText(String.format("%d、%s", new Object[] { Integer.valueOf(paramInt + 1), localSQLiteLintIssue.desc }));
        paramViewGroup.timeTv.setText(SQLiteLintUtil.formatTime("yyyy-MM-dd HH:mm", localSQLiteLintIssue.createTime));
        paramViewGroup.diagnosisLevelTv.setText(SQLiteLintIssue.getLevelText(localSQLiteLintIssue.level, CheckResultActivity.this.getBaseContext()));
        AppMethodBeat.o(52884);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckResultActivity
 * JD-Core Version:    0.7.0.1
 */