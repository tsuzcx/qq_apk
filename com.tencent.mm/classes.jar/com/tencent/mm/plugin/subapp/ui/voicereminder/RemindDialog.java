package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ay.d;
import com.tencent.mm.model.bg;
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
  private static List<String> FNx;
  private static boolean dEF;
  private List<String> FNw;
  private ay.d FNy;
  private MMHandler handler;
  private com.tencent.mm.ui.widget.a.d kdo;
  private String talker;
  
  static
  {
    AppMethodBeat.i(29261);
    FNx = new ArrayList();
    dEF = false;
    AppMethodBeat.o(29261);
  }
  
  public RemindDialog()
  {
    AppMethodBeat.i(29254);
    this.talker = "";
    this.FNw = new ArrayList();
    this.handler = new MMHandler();
    this.FNy = new ay.d()
    {
      public final void B(String paramAnonymousString, long paramAnonymousLong)
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
  
  public static void L(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(29259);
    Log.d("MicroMsg.RemindDialog", "show " + dEF + " remind " + paramString2);
    if (dEF)
    {
      FNx.add(paramString2);
      AppMethodBeat.o(29259);
      return;
    }
    FNx.clear();
    dEF = true;
    if (bg.azz().foreground)
    {
      localIntent = new Intent(paramContext, RemindDialog.class);
      localIntent.putExtra("_RemindDialog_User", paramString1);
      localIntent.putExtra("_RemindDialog_Remind", paramString2);
      localIntent.setFlags(603979776);
      localIntent.addFlags(268435456);
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29259);
      return;
    }
    Intent localIntent = new Intent(paramContext, RemindDialog.class);
    localIntent.putExtra("_RemindDialog_User", paramString1);
    localIntent.putExtra("_RemindDialog_Remind", paramString2);
    localIntent.setFlags(604012544);
    localIntent.addFlags(268435456);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29259);
  }
  
  private void dGH()
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
    paramBundle.aoO(2131767197);
    paramBundle.boo(" ");
    paramBundle.aoV(2131767194).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29250);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.ftg();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.Kl(RemindDialog.c(RemindDialog.this));
        }
        if (ab.Jq(bg.getNotification().ala()))
        {
          RemindDialog.this.finish();
          AppMethodBeat.o(29250);
          return;
        }
        b.jRt.d(new Intent().putExtra("Chat_User", RemindDialog.c(RemindDialog.this)), RemindDialog.this);
        RemindDialog.this.finish();
        AppMethodBeat.o(29250);
      }
    });
    paramBundle.aoW(2131767196).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29251);
        paramAnonymousDialogInterface = com.tencent.mm.plugin.subapp.d.d.ftg();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.Kl(RemindDialog.c(RemindDialog.this));
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
    this.FNw.clear();
    this.FNw.add(localObject);
    localObject = FNx.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.FNw.add(str);
    }
    this.kdo = paramBundle.hbn();
    this.kdo.setCanceledOnTouchOutside(false);
    this.kdo.show();
    dGH();
    AppMethodBeat.o(29255);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29258);
    dEF = false;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.ftg();
    if (locald != null) {
      locald.b(this.FNy);
    }
    super.onPause();
    AppMethodBeat.o(29258);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29257);
    dEF = true;
    com.tencent.mm.plugin.subapp.d.d locald = com.tencent.mm.plugin.subapp.d.d.ftg();
    if (locald != null) {
      locald.a(this.FNy);
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