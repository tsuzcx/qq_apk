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
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemindDialog
  extends HellActivity
{
  private static List<String> Mhy;
  private static boolean fxt;
  private List<String> Mhx;
  private az.d Mhz;
  private MMHandler handler;
  private com.tencent.mm.ui.widget.a.d mUO;
  private String talker;
  
  static
  {
    AppMethodBeat.i(29261);
    Mhy = new ArrayList();
    fxt = false;
    AppMethodBeat.o(29261);
  }
  
  public RemindDialog()
  {
    AppMethodBeat.i(29254);
    this.talker = "";
    this.Mhx = new ArrayList();
    this.handler = new MMHandler();
    this.Mhz = new az.d()
    {
      public final void y(String paramAnonymousString, long paramAnonymousLong)
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
  
  public static void S(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(29259);
    Log.d("MicroMsg.RemindDialog", "show " + fxt + " remind " + paramString2);
    if (fxt)
    {
      Mhy.add(paramString2);
      AppMethodBeat.o(29259);
      return;
    }
    Mhy.clear();
    fxt = true;
    if (bh.aGY().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29259);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29259);
  }
  
  private void cBf()
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
    paramBundle = new d.a(this);
    paramBundle.ayc(R.l.eVn);
    paramBundle.bBd(" ");
    paramBundle.ayj(R.l.eVk).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29250);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.ghF();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.RE(RemindDialog.c(RemindDialog.this));
        }
        if (ab.QJ(bh.getNotification().aqX()))
        {
          RemindDialog.this.finish();
          AppMethodBeat.o(29250);
          return;
        }
        b.mIG.d(new Intent().putExtra("Chat_User", RemindDialog.c(RemindDialog.this)), RemindDialog.this);
        RemindDialog.this.finish();
        AppMethodBeat.o(29250);
      }
    });
    paramBundle.ayk(R.l.eVm).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29251);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.ghF();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.RE(RemindDialog.c(RemindDialog.this));
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
    this.Mhx.clear();
    this.Mhx.add(localObject);
    localObject = Mhy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.Mhx.add(str);
    }
    this.mUO = paramBundle.icu();
    this.mUO.setCanceledOnTouchOutside(false);
    this.mUO.show();
    cBf();
    AppMethodBeat.o(29255);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29258);
    fxt = false;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.ghF();
    if (locald != null) {
      locald.b(this.Mhz);
    }
    super.onPause();
    AppMethodBeat.o(29258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29257);
    fxt = true;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.ghF();
    if (locald != null) {
      locald.a(this.Mhz);
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