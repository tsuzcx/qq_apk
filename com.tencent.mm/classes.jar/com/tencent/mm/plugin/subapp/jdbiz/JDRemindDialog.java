package com.tencent.mm.plugin.subapp.jdbiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public class JDRemindDialog
  extends MMBaseActivity
{
  private c giQ = null;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(25186);
    Intent localIntent = new Intent(paramContext, JDRemindDialog.class);
    localIntent.putExtra("alertcontent", paramString1);
    localIntent.putExtra("alertconfirm", paramString2);
    localIntent.putExtra("alert_cancel", paramString3);
    localIntent.putExtra("alertjumpurl", paramString4);
    localIntent.putExtra("alert_activityid", paramString5);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(25186);
  }
  
  private void aVD()
  {
    AppMethodBeat.i(25185);
    if (getIntent() == null)
    {
      AppMethodBeat.o(25185);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      AppMethodBeat.o(25185);
      return;
    }
    c.a locala = new c.a(this);
    locala.avm("");
    locala.avn(localBundle.getString("alertcontent"));
    locala.avs(localBundle.getString("alertconfirm")).a(new JDRemindDialog.1(this));
    locala.avt(localBundle.getString("alert_cancel")).b(new JDRemindDialog.2(this));
    this.giQ = locala.aLZ();
    this.giQ.setCanceledOnTouchOutside(false);
    this.giQ.show();
    AppMethodBeat.o(25185);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25181);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    aVD();
    AppMethodBeat.o(25181);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(25183);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.giQ != null)
    {
      this.giQ.dismiss();
      this.giQ = null;
    }
    aVD();
    AppMethodBeat.o(25183);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25184);
    super.onPause();
    y.activateBroadcast(false);
    AppMethodBeat.o(25184);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25182);
    super.onResume();
    y.activateBroadcast(true);
    AppMethodBeat.o(25182);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog
 * JD-Core Version:    0.7.0.1
 */