package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;

public final class a
{
  public static Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(79108);
    Bundle localBundle = new Bundle();
    localBundle.putString("targeturl", paramString);
    localBundle.putParcelable("targetintent", paramIntent);
    paramString = new Intent();
    paramString.setClass(paramActivity, AppChooserUI.class);
    paramString.putExtra("scene", 4);
    paramString.putExtra("type", 0);
    paramString.putExtra("title", paramActivity.getString(2131757346));
    paramString.putExtra("targetintent", paramIntent);
    paramString.putExtra("transferback", localBundle);
    AppMethodBeat.o(79108);
    return paramString;
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(79107);
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(79107);
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://"))
    {
      str = paramString;
      if (!paramString.startsWith("https://")) {
        str = "http://".concat(String.valueOf(paramString));
      }
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(str));
    try
    {
      if ((!bu.jq(paramActivity)) && (!k.fnT())) {
        break label216;
      }
      if (d.lA(29))
      {
        PendingIntent.getActivity(paramActivity, 0, paramString, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
        {
          public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(198165);
            ae.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            AppMethodBeat.o(198165);
          }
        }, null);
        AppMethodBeat.o(79107);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      ae.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(79107);
      return;
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.ahE(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(79107);
    return;
    label216:
    paramActivity.startActivityForResult(a(paramActivity, paramString, str), 2);
    AppMethodBeat.o(79107);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79109);
    if (2 == paramInt1)
    {
      String str;
      Bundle localBundle;
      boolean bool;
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        str = paramIntent.getStringExtra("selectpkg");
        localBundle = paramIntent.getBundleExtra("transferback");
        bool = paramIntent.getBooleanExtra("isalways", false);
        ae.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { str });
        t.fdv();
        paramIntent = (q)t.A(0, null);
        if (!paramIntent.aMR(str)) {
          break label348;
        }
        if (!paramIntent.ht(paramActivity)) {
          break label150;
        }
        paramIntent.bM(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label318;
        }
        g.yxI.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(79109);
          return true;
          label150:
          paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
          paramIntent.setPackage(str);
          paramIntent.addFlags(524288);
          if (!d.lA(29)) {
            break label247;
          }
          paramIntent = PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728);
          try
          {
            paramIntent.send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(198166);
                ae.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(198166);
              }
            }, null);
          }
          catch (Exception paramActivity)
          {
            ae.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
          }
        }
        break;
        label247:
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.ahE(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramIntent.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        label318:
        g.yxI.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label348:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        try
        {
          if (d.lA(29)) {
            PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(198167);
                ae.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(198167);
              }
            }, null);
          }
          for (;;)
          {
            g.yxI.f(10998, new Object[] { Integer.valueOf(5) });
            if (!bool) {
              break label565;
            }
            g.yxI.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
            break;
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.ahE(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            ae.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          label565:
          g.yxI.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    AppMethodBeat.o(79109);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.a
 * JD-Core Version:    0.7.0.1
 */