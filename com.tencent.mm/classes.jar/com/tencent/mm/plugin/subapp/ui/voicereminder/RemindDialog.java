package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class RemindDialog
  extends Activity
{
  private static boolean coy;
  private static List<String> sZV;
  private c gwf;
  private ak handler;
  private List<String> sZU;
  private ao.d sZW;
  private String talker;
  
  static
  {
    AppMethodBeat.i(25571);
    sZV = new ArrayList();
    coy = false;
    AppMethodBeat.o(25571);
  }
  
  public RemindDialog()
  {
    AppMethodBeat.i(25564);
    this.talker = "";
    this.sZU = new ArrayList();
    this.handler = new ak();
    this.sZW = new RemindDialog.1(this);
    AppMethodBeat.o(25564);
  }
  
  private void cHc()
  {
    AppMethodBeat.i(25566);
    this.handler.post(new RemindDialog.5(this));
    AppMethodBeat.o(25566);
  }
  
  public static void y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(25569);
    ab.d("MicroMsg.RemindDialog", "show " + coy + " remind " + paramString2);
    if (coy)
    {
      sZV.add(paramString2);
      AppMethodBeat.o(25569);
      return;
    }
    sZV.clear();
    coy = true;
    if (aw.Rc().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(25569);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(25569);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25565);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new c.a(this);
    paramBundle.Rb(2131304587);
    paramBundle.avn(" ");
    paramBundle.Ri(2131304584).a(new RemindDialog.2(this));
    paramBundle.Rj(2131304586).b(new RemindDialog.3(this));
    paramBundle.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25562);
        RemindDialog.this.finish();
        AppMethodBeat.o(25562);
      }
    });
    this.talker = getIntent().getStringExtra("_RemindDialog_User");
    Object localObject = getIntent().getStringExtra("_RemindDialog_Remind");
    this.sZU.clear();
    this.sZU.add(localObject);
    localObject = sZV.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.sZU.add(str);
    }
    this.gwf = paramBundle.aLZ();
    this.gwf.setCanceledOnTouchOutside(false);
    this.gwf.show();
    cHc();
    AppMethodBeat.o(25565);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25568);
    coy = false;
    d locald = d.cGS();
    if (locald != null) {
      locald.b(this.sZW);
    }
    super.onPause();
    AppMethodBeat.o(25568);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25567);
    coy = true;
    d locald = d.cGS();
    if (locald != null) {
      locald.a(this.sZW);
    }
    super.onResume();
    AppMethodBeat.o(25567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog
 * JD-Core Version:    0.7.0.1
 */