package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.ui.MMBaseActivity;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView fcy;
  private TextView pWp;
  private String talker = "";
  private int type = 0;
  
  public static void j(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.c.mm_voip_invite_alert);
    this.fcy = ((TextView)findViewById(a.b.mm_alert_msg_title));
    this.pWp = ((TextView)findViewById(a.b.mm_alert_msg_content));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.fcy.setText(getString(a.e.voip_send_request_title));
      this.pWp.setText(getString(a.e.voip_invite_remind_tip));
    }
    for (;;)
    {
      findViewById(a.b.mm_alert_ok_btn).setOnClickListener(new InviteRemindDialog.1(this));
      findViewById(a.b.mm_alert_cancel_btn).setOnClickListener(new InviteRemindDialog.2(this));
      return;
      if (this.type == 1)
      {
        this.fcy.setText(getString(a.e.voip_voice_send_request_title));
        this.pWp.setText(getString(a.e.voip_voice_invite_remind_tip));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.InviteRemindDialog
 * JD-Core Version:    0.7.0.1
 */