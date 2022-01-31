package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class JDRemindDialog
  extends MMBaseActivity
{
  private c eQV = null;
  
  private void UF()
  {
    if (getIntent() == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = getIntent().getExtras();
    } while (localBundle == null);
    c.a locala = new c.a(this);
    locala.aez("");
    locala.aeA(localBundle.getString("alertcontent"));
    locala.aeD(localBundle.getString("alertconfirm")).a(new JDRemindDialog.1(this));
    locala.aeE(localBundle.getString("alert_cancel")).b(new JDRemindDialog.2(this));
    this.eQV = locala.aoP();
    this.eQV.setCanceledOnTouchOutside(false);
    this.eQV.show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent(paramContext, JDRemindDialog.class);
    localIntent.putExtra("alertcontent", paramString1);
    localIntent.putExtra("alertconfirm", paramString2);
    localIntent.putExtra("alert_cancel", paramString3);
    localIntent.putExtra("alertjumpurl", paramString4);
    localIntent.putExtra("alert_activityid", paramString5);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    UF();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.eQV != null)
    {
      this.eQV.dismiss();
      this.eQV = null;
    }
    UF();
  }
  
  protected void onPause()
  {
    super.onPause();
    x.b(false, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    x.b(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog
 * JD-Core Version:    0.7.0.1
 */