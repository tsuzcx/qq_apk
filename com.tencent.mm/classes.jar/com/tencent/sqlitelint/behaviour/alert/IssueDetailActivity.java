package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    setTitle(getString(2131758064));
    Object localObject = (TextView)findViewById(2131305822);
    TextView localTextView = (TextView)findViewById(2131299094);
    ((TextView)localObject).setText(SQLiteLintUtil.formatTime("yyyy-MM-dd HH:mm", paramSQLiteLintIssue.createTime));
    localTextView.setText(SQLiteLintIssue.getLevelText(paramSQLiteLintIssue.level, getBaseContext()));
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.desc))
    {
      localObject = (LinearLayout)findViewById(2131299005);
      ((TextView)findViewById(2131299008)).setText(paramSQLiteLintIssue.desc);
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
      localObject = (LinearLayout)findViewById(2131299048);
      localTextView = (TextView)findViewById(2131299061);
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
      localObject = (LinearLayout)findViewById(2131296511);
      ((TextView)findViewById(2131296512)).setText(paramSQLiteLintIssue.advice);
      ((LinearLayout)localObject).setVisibility(0);
    }
    if (!SQLiteLintUtil.isNullOrNil(paramSQLiteLintIssue.extInfo))
    {
      localObject = (LinearLayout)findViewById(2131299618);
      ((TextView)findViewById(2131299619)).setText(getString(2131758065, new Object[] { paramSQLiteLintIssue.extInfo }));
      ((LinearLayout)localObject).setVisibility(0);
    }
    AppMethodBeat.o(52909);
  }
  
  protected int getLayoutId()
  {
    return 2131492932;
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