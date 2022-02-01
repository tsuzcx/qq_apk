package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.R.id;
import com.tencent.sqlitelint.R.layout;
import com.tencent.sqlitelint.R.string;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity
  extends SQLiteLintBaseActivity
{
  public static final String KEY_ISSUE = "issue";
  private static final String TAG = "MicroMsg.IssueDetailActivity";
  
  private void initView(final SQLiteLintIssue paramSQLiteLintIssue)
  {
    AppMethodBeat.i(52909);
    if (paramSQLiteLintIssue == null)
    {
      AppMethodBeat.o(52909);
      return;
    }
    setTitle(getString(R.string.diagnosis_detail_title));
    Object localObject = (TextView)findViewById(R.id.time_tv);
    TextView localTextView = (TextView)findViewById(R.id.diagnosis_level_tv);
    ((TextView)localObject).setText(SQLiteLintUtil.formatTime("yyyy-MM-dd HH:mm", paramSQLiteLintIssue.createTime));
    localTextView.setText(SQLiteLintIssue.getLevelText(paramSQLiteLintIssue.level, getBaseContext()));
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.desc))
    {
      localObject = (LinearLayout)findViewById(R.id.desc_layout);
      ((TextView)findViewById(R.id.desc_tv)).setText(paramSQLiteLintIssue.desc);
      ((LinearLayout)localObject).setVisibility(0);
      ((LinearLayout)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(52906);
          SLog.v("MicroMsg.IssueDetailActivity", paramSQLiteLintIssue.desc.replace("%", "###"), new Object[0]);
          AppMethodBeat.o(52906);
        }
      });
    }
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.detail))
    {
      localObject = (LinearLayout)findViewById(R.id.detail_layout);
      localTextView = (TextView)findViewById(R.id.detail_tv);
      localTextView.setText(paramSQLiteLintIssue.detail);
      ((LinearLayout)localObject).setVisibility(0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(52907);
          SLog.v("MicroMsg.IssueDetailActivity", paramSQLiteLintIssue.detail.replace("%", "###"), new Object[0]);
          AppMethodBeat.o(52907);
        }
      });
    }
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.advice))
    {
      localObject = (LinearLayout)findViewById(R.id.advice_layout);
      ((TextView)findViewById(R.id.advice_tv)).setText(paramSQLiteLintIssue.advice);
      ((LinearLayout)localObject).setVisibility(0);
    }
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.extInfo))
    {
      localObject = (LinearLayout)findViewById(R.id.ext_info_layout);
      ((TextView)findViewById(R.id.ext_info_tv)).setText(getString(R.string.diagnosis_ext_info_title, new Object[] { paramSQLiteLintIssue.extInfo }));
      ((LinearLayout)localObject).setVisibility(0);
    }
    AppMethodBeat.o(52909);
  }
  
  protected int getLayoutId()
  {
    return R.layout.activity_diagnosis_detail;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52908);
    super.onCreate(paramBundle);
    initView((SQLiteLintIssue)getIntent().getParcelableExtra("issue"));
    AppMethodBeat.o(52908);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.IssueDetailActivity
 * JD-Core Version:    0.7.0.1
 */