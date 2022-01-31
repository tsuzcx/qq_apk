package com.tencent.sqlitelint.behaviour.alert;

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
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.a.a;
import com.tencent.sqlitelint.d.b;
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckResultActivity
  extends SQLiteLintBaseActivity
{
  private String wRk;
  private List<SQLiteLintIssue> wRl;
  private a wRm;
  
  private void cLz()
  {
    List localList = a.afZ(this.wRk);
    if (this.wRl == null) {
      this.wRl = localList;
    }
    for (;;)
    {
      SLog.d("MpApp.CheckResultActivity", "refreshData size %d", new Object[] { Integer.valueOf(this.wRl.size()) });
      this.wRm.notifyDataSetChanged();
      return;
      this.wRl.clear();
      this.wRl.addAll(localList);
    }
  }
  
  protected final int getLayoutId()
  {
    return d.c.activity_check_result;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.wRk = getIntent().getStringExtra("db_label");
    paramBundle = SQLiteLintUtil.agb(this.wRk);
    setTitle(getString(d.d.check_result_title, new Object[] { paramBundle }));
    paramBundle = (ListView)findViewById(d.b.list);
    this.wRm = new a();
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (SQLiteLintIssue)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("issue", paramAnonymousAdapterView);
        paramAnonymousView.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
        CheckResultActivity.this.startActivity(paramAnonymousView);
      }
    });
    paramBundle.setAdapter(this.wRm);
    this.wRm.notifyDataSetChanged();
    cLz();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    cLz();
  }
  
  final class a
    extends BaseAdapter
  {
    private final LayoutInflater Lu = LayoutInflater.from(CheckResultActivity.this);
    
    a() {}
    
    private SQLiteLintIssue Jv(int paramInt)
    {
      return (SQLiteLintIssue)CheckResultActivity.a(CheckResultActivity.this).get(paramInt);
    }
    
    public final int getCount()
    {
      if (CheckResultActivity.a(CheckResultActivity.this) == null) {
        return 0;
      }
      return CheckResultActivity.a(CheckResultActivity.this).size();
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.Lu.inflate(d.c.view_check_result_item, paramViewGroup, false);
        paramViewGroup = new CheckResultActivity.b();
        paramViewGroup.wRo = ((TextView)paramView.findViewById(d.b.result_tv));
        paramViewGroup.wRp = ((TextView)paramView.findViewById(d.b.diagnosis_level_tv));
        paramViewGroup.igx = ((TextView)paramView.findViewById(d.b.time_tv));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        SQLiteLintIssue localSQLiteLintIssue = Jv(paramInt);
        paramViewGroup.wRo.setText(String.format("%d、%s", new Object[] { Integer.valueOf(paramInt + 1), localSQLiteLintIssue.desc }));
        paramViewGroup.igx.setText(SQLiteLintUtil.g("yyyy-MM-dd HH:mm", localSQLiteLintIssue.createTime));
        paramViewGroup.wRp.setText(SQLiteLintIssue.getLevelText(localSQLiteLintIssue.level, CheckResultActivity.this.getBaseContext()));
        return paramView;
        paramViewGroup = (CheckResultActivity.b)paramView.getTag();
      }
    }
  }
  
  static final class b
  {
    public TextView igx;
    public TextView wRo;
    public TextView wRp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckResultActivity
 * JD-Core Version:    0.7.0.1
 */