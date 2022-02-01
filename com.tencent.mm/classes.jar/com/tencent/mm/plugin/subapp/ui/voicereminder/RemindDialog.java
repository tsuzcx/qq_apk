package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.subapp.modelvoiceremind.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemindDialog
  extends HellActivity
{
  private static List<String> SIV;
  private static boolean hBY;
  private List<String> SIU;
  private az.d SIW;
  private MMHandler handler;
  private e pRv;
  private String talker;
  
  static
  {
    AppMethodBeat.i(29261);
    SIV = new ArrayList();
    hBY = false;
    AppMethodBeat.o(29261);
  }
  
  public RemindDialog()
  {
    AppMethodBeat.i(29254);
    this.talker = "";
    this.SIU = new ArrayList();
    this.handler = new MMHandler();
    this.SIW = new az.d()
    {
      public final void C(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(29249);
        Log.d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(paramAnonymousString)));
        RemindDialog.a(RemindDialog.this).add(paramAnonymousString);
        RemindDialog.b(RemindDialog.this);
        AppMethodBeat.o(29249);
      }
    };
    AppMethodBeat.o(29254);
  }
  
  public static void T(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(29259);
    Log.d("MicroMsg.RemindDialog", "show " + hBY + " remind " + paramString2);
    if (hBY)
    {
      SIV.add(paramString2);
      AppMethodBeat.o(29259);
      return;
    }
    SIV.clear();
    hBY = true;
    if (bh.aZW().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29259);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29259);
  }
  
  private void deo()
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
          if (Util.isNullOrNil(str)) {
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
    paramBundle = new e.a(this);
    paramBundle.aEK(R.l.gYr);
    paramBundle.bDw(" ");
    paramBundle.aER(R.l.gYo).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29250);
        paramAnonymousDialogInterface = d.hAY();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.JC(RemindDialog.c(RemindDialog.this));
        }
        if (au.bwn(bh.getNotification().aKU()))
        {
          RemindDialog.this.finish();
          AppMethodBeat.o(29250);
          return;
        }
        com.tencent.mm.plugin.subapp.a.pFn.d(new Intent().putExtra("Chat_User", RemindDialog.c(RemindDialog.this)), RemindDialog.this);
        RemindDialog.this.finish();
        AppMethodBeat.o(29250);
      }
    });
    paramBundle.aES(R.l.gYq).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29251);
        paramAnonymousDialogInterface = d.hAY();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.JC(RemindDialog.c(RemindDialog.this));
        }
        RemindDialog.this.finish();
        AppMethodBeat.o(29251);
      }
    });
    paramBundle.c(new DialogInterface.OnDismissListener()
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
    this.SIU.clear();
    this.SIU.add(localObject);
    localObject = SIV.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.SIU.add(str);
    }
    this.pRv = paramBundle.jHH();
    this.pRv.setCanceledOnTouchOutside(false);
    this.pRv.show();
    deo();
    AppMethodBeat.o(29255);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29258);
    hBY = false;
    d locald = d.hAY();
    if (locald != null) {
      locald.b(this.SIW);
    }
    super.onPause();
    AppMethodBeat.o(29258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29257);
    hBY = true;
    d locald = d.hAY();
    if (locald != null) {
      locald.a(this.SIW);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog
 * JD-Core Version:    0.7.0.1
 */