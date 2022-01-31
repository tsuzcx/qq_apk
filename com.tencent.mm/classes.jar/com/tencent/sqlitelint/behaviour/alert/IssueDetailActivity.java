package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.d.b;
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity
  extends SQLiteLintBaseActivity
{
  protected final int getLayoutId()
  {
    return d.c.activity_diagnosis_detail;
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (SQLiteLintIssue)getIntent().getParcelableExtra("issue");
    if (paramBundle != null)
    {
      setTitle(getString(d.d.diagnosis_detail_title));
      Object localObject = (TextView)findViewById(d.b.time_tv);
      TextView localTextView = (TextView)findViewById(d.b.diagnosis_level_tv);
      ((TextView)localObject).setText(SQLiteLintUtil.g("yyyy-MM-dd HH:mm", paramBundle.createTime));
      localTextView.setText(SQLiteLintIssue.getLevelText(paramBundle.level, getBaseContext()));
      if (!SQLiteLintUtil.bl(paramBundle.desc))
      {
        localObject = (LinearLayout)findViewById(d.b.desc_layout);
        ((TextView)findViewById(d.b.desc_tv)).setText(paramBundle.desc);
        ((LinearLayout)localObject).setVisibility(0);
        ((LinearLayout)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            SLog.v("MicroMsg.IssueDetailActivity", paramBundle.desc.replace("%", "###"), new Object[0]);
          }
        });
      }
      if (!SQLiteLintUtil.bl(paramBundle.detail))
      {
        localObject = (LinearLayout)findViewById(d.b.detail_layout);
        localTextView = (TextView)findViewById(d.b.detail_tv);
        localTextView.setText(paramBundle.detail);
        ((LinearLayout)localObject).setVisibility(0);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            SLog.v("MicroMsg.IssueDetailActivity", paramBundle.detail.replace("%", "###"), new Object[0]);
          }
        });
      }
      if (!SQLiteLintUtil.bl(paramBundle.advice))
      {
        localObject = (LinearLayout)findViewById(d.b.advice_layout);
        ((TextView)findViewById(d.b.advice_tv)).setText(paramBundle.advice);
        ((LinearLayout)localObject).setVisibility(0);
      }
      if (!SQLiteLintUtil.bl(paramBundle.extInfo))
      {
        localObject = (LinearLayout)findViewById(d.b.ext_info_layout);
        ((TextView)findViewById(d.b.ext_info_tv)).setText(getString(d.d.diagnosis_ext_info_title, new Object[] { paramBundle.extInfo }));
        ((LinearLayout)localObject).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.IssueDetailActivity
 * JD-Core Version:    0.7.0.1
 */