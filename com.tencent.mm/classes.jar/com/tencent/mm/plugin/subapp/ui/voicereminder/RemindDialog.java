package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class RemindDialog
  extends Activity
{
  private static boolean bHj = false;
  private static List<String> pyh = new ArrayList();
  private c few;
  private ah handler = new ah();
  private List<String> pyg = new ArrayList();
  private am.d pyi = new am.d()
  {
    public final void n(String paramAnonymousString, long paramAnonymousLong)
    {
      y.d("MicroMsg.RemindDialog", "onVoiceRemind " + paramAnonymousString);
      RemindDialog.a(RemindDialog.this).add(paramAnonymousString);
      RemindDialog.b(RemindDialog.this);
    }
  };
  private String talker = "";
  
  private void bMe()
  {
    this.handler.post(new RemindDialog.5(this));
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    y.d("MicroMsg.RemindDialog", "show " + bHj + " remind " + paramString2);
    if (bHj)
    {
      pyh.add(paramString2);
      return;
    }
    pyh.clear();
    bHj = true;
    if (au.Dk().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new c.a(this);
    paramBundle.Ip(R.l.voice_reminder_dialog_title);
    paramBundle.aeA(" ");
    paramBundle.Is(R.l.voice_reminder_dialog_check).a(new RemindDialog.2(this));
    paramBundle.It(R.l.voice_reminder_dialog_ignore).b(new RemindDialog.3(this));
    paramBundle.a(new RemindDialog.4(this));
    this.talker = getIntent().getStringExtra("_RemindDialog_User");
    Object localObject = getIntent().getStringExtra("_RemindDialog_Remind");
    this.pyg.clear();
    this.pyg.add(localObject);
    localObject = pyh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.pyg.add(str);
    }
    this.few = paramBundle.aoP();
    this.few.setCanceledOnTouchOutside(false);
    this.few.show();
    bMe();
  }
  
  public void onPause()
  {
    bHj = false;
    d locald = d.bLW();
    if (locald != null) {
      locald.b(this.pyi);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    bHj = true;
    d locald = d.bLW();
    if (locald != null) {
      locald.a(this.pyi);
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog
 * JD-Core Version:    0.7.0.1
 */