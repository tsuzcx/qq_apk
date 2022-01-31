package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMBaseActivity;

public class InviteRemindDialog
  extends MMBaseActivity
{
  private TextView gui;
  private TextView tBS;
  private String talker = "";
  private int type = 0;
  
  public static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(4774);
    Intent localIntent = new Intent(paramContext, InviteRemindDialog.class);
    localIntent.putExtra("InviteRemindDialog_User", paramString);
    localIntent.putExtra("InviteRemindDialog_Type", paramInt);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(4774);
  }
  
  public void finish()
  {
    AppMethodBeat.i(4773);
    super.finish();
    AppMethodBeat.o(4773);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(4772);
    super.onCreate(paramBundle);
    setContentView(2130970281);
    this.gui = ((TextView)findViewById(2131824645));
    this.tBS = ((TextView)findViewById(2131824646));
    this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
    this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
    if (this.type == 0)
    {
      this.gui.setText(getString(2131304733));
      this.tBS.setText(getString(2131304697));
    }
    for (;;)
    {
      findViewById(2131822981).setOnClickListener(new InviteRemindDialog.1(this));
      findViewById(2131822980).setOnClickListener(new InviteRemindDialog.2(this));
      AppMethodBeat.o(4772);
      return;
      if (this.type == 1)
      {
        this.gui.setText(getString(2131304765));
        this.tBS.setText(getString(2131304756));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.InviteRemindDialog
 * JD-Core Version:    0.7.0.1
 */