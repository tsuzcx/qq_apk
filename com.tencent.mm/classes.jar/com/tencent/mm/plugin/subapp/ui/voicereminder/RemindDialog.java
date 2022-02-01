package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemindDialog
  extends HellActivity
{
  private static List<String> Blm;
  private static boolean dmo;
  private List<String> Bll;
  private as.d Bln;
  private ap handler;
  private com.tencent.mm.ui.widget.a.d jcs;
  private String talker;
  
  static
  {
    AppMethodBeat.i(29261);
    Blm = new ArrayList();
    dmo = false;
    AppMethodBeat.o(29261);
  }
  
  public RemindDialog()
  {
    AppMethodBeat.i(29254);
    this.talker = "";
    this.Bll = new ArrayList();
    this.handler = new ap();
    this.Bln = new as.d()
    {
      public final void A(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(29249);
        ad.d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(paramAnonymousString)));
        RemindDialog.a(RemindDialog.this).add(paramAnonymousString);
        RemindDialog.b(RemindDialog.this);
        AppMethodBeat.o(29249);
      }
    };
    AppMethodBeat.o(29254);
  }
  
  public static void H(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(29259);
    ad.d("MicroMsg.RemindDialog", "show " + dmo + " remind " + paramString2);
    if (dmo)
    {
      Blm.add(paramString2);
      AppMethodBeat.o(29259);
      return;
    }
    Blm.clear();
    dmo = true;
    if (ba.aiU().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29259);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29259);
  }
  
  private void enn()
  {
    AppMethodBeat.i(29256);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29253);
        StringBuffer localStringBuffer = new StringBuffer();
        Iterator localIterator = RemindDialog.a(RemindDialog.this).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (bt.isNullOrNil(str)) {
            localStringBuffer.append("\n\n");
          } else {
            localStringBuffer.append(str + "\n\n");
          }
        }
        if (RemindDialog.d(RemindDialog.this) != null) {
          RemindDialog.d(RemindDialog.this).setMessage(localStringBuffer);
        }
        AppMethodBeat.o(29253);
      }
    });
    AppMethodBeat.o(29256);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29255);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new d.a(this);
    paramBundle.afe(2131764760);
    paramBundle.aXG(" ");
    paramBundle.afl(2131764757).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29250);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.emY();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.Bd(RemindDialog.c(RemindDialog.this));
        }
        if (w.Ab(ba.getNotification().Xf()))
        {
          RemindDialog.this.finish();
          AppMethodBeat.o(29250);
          return;
        }
        b.iRG.d(new Intent().putExtra("Chat_User", RemindDialog.c(RemindDialog.this)), RemindDialog.this);
        RemindDialog.this.finish();
        AppMethodBeat.o(29250);
      }
    });
    paramBundle.afm(2131764759).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29251);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.emY();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.Bd(RemindDialog.c(RemindDialog.this));
        }
        RemindDialog.this.finish();
        AppMethodBeat.o(29251);
      }
    });
    paramBundle.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29252);
        RemindDialog.this.finish();
        AppMethodBeat.o(29252);
      }
    });
    this.talker = getIntent().getStringExtra("_RemindDialog_User");
    Object localObject = getIntent().getStringExtra("_RemindDialog_Remind");
    this.Bll.clear();
    this.Bll.add(localObject);
    localObject = Blm.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.Bll.add(str);
    }
    this.jcs = paramBundle.fMb();
    this.jcs.setCanceledOnTouchOutside(false);
    this.jcs.show();
    enn();
    AppMethodBeat.o(29255);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29258);
    dmo = false;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.emY();
    if (locald != null) {
      locald.b(this.Bln);
    }
    super.onPause();
    AppMethodBeat.o(29258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29257);
    dmo = true;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.emY();
    if (locald != null) {
      locald.a(this.Bln);
    }
    super.onResume();
    AppMethodBeat.o(29257);
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