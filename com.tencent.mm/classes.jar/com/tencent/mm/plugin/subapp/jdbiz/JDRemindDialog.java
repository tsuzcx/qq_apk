package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public class JDRemindDialog
  extends MMBaseActivity
{
  private e pjp = null;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(28862);
    Intent localIntent = new Intent(paramContext, JDRemindDialog.class);
    localIntent.putExtra("alertcontent", paramString1);
    localIntent.putExtra("alertconfirm", paramString2);
    localIntent.putExtra("alert_cancel", paramString3);
    localIntent.putExtra("alertjumpurl", paramString4);
    localIntent.putExtra("alert_activityid", paramString5);
    localIntent.addFlags(805306368);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/subapp/jdbiz/JDRemindDialog", "showAlert", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/subapp/jdbiz/JDRemindDialog", "showAlert", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(28862);
  }
  
  private void cZS()
  {
    AppMethodBeat.i(28861);
    if (getIntent() == null)
    {
      AppMethodBeat.o(28861);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      AppMethodBeat.o(28861);
      return;
    }
    e.a locala = new e.a(this);
    locala.bDv("");
    locala.bDw(localBundle.getString("alertcontent"));
    locala.bDC(localBundle.getString("alertconfirm")).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(28855);
        Object localObject2 = null;
        String str = "";
        Object localObject1 = str;
        paramAnonymousDialogInterface = localObject2;
        if (JDRemindDialog.this.getIntent() != null)
        {
          localObject1 = str;
          paramAnonymousDialogInterface = localObject2;
          if (JDRemindDialog.this.getIntent().getExtras() != null)
          {
            paramAnonymousDialogInterface = JDRemindDialog.this.getIntent().getExtras().getString("alertjumpurl");
            localObject1 = JDRemindDialog.this.getIntent().getExtras().getString("alert_activityid");
          }
        }
        if (((String)localObject1).equals(d.hAI().hAN().rBJ))
        {
          d.hAI();
          if (d.hAJ())
          {
            d.hAI();
            d.hAM();
            d.hAI();
            d.hAL();
          }
        }
        if (!Util.isNullOrNil(paramAnonymousDialogInterface))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramAnonymousDialogInterface);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          com.tencent.mm.br.c.b(JDRemindDialog.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          h.OAn.b(11179, new Object[] { paramAnonymousDialogInterface, d.hAI().hAN().rBJ, Integer.valueOf(5) });
        }
        JDRemindDialog.this.finish();
        AppMethodBeat.o(28855);
      }
    });
    locala.bDD(localBundle.getString("alert_cancel")).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(28856);
        JDRemindDialog.this.finish();
        AppMethodBeat.o(28856);
      }
    });
    this.pjp = locala.jHH();
    this.pjp.setCanceledOnTouchOutside(false);
    this.pjp.show();
    AppMethodBeat.o(28861);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28857);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    cZS();
    AppMethodBeat.o(28857);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(28859);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.pjp != null)
    {
      this.pjp.dismiss();
      this.pjp = null;
    }
    cZS();
    AppMethodBeat.o(28859);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28860);
    super.onPause();
    ag.activateBroadcast(false);
    AppMethodBeat.o(28860);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28858);
    super.onResume();
    ag.activateBroadcast(true);
    AppMethodBeat.o(28858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog
 * JD-Core Version:    0.7.0.1
 */