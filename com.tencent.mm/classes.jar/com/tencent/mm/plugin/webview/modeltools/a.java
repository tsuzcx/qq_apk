package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.browser.b;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.k.c;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  public WeakReference<k> PWI = null;
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(79107);
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (Util.isNullOrNil(paramString)))
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
      if ((!Util.isOverseasUser(paramActivity)) && (!ChannelUtil.isGPVersion())) {
        break label216;
      }
      if (d.qV(29))
      {
        PendingIntent.getActivity(paramActivity, 0, paramString, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
        {
          public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(215579);
            Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            AppMethodBeat.o(215579);
          }
        }, null);
        AppMethodBeat.o(79107);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(79107);
      return;
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aFh(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(79107);
    return;
    label216:
    paramActivity.startActivityForResult(b.a(paramActivity, paramString, str), 6);
    AppMethodBeat.o(79107);
  }
  
  public final boolean c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79109);
    Object localObject;
    boolean bool;
    if (2 == paramInt1)
    {
      Bundle localBundle;
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("selectpkg");
        localBundle = paramIntent.getBundleExtra("transferback");
        bool = paramIntent.getBooleanExtra("isalways", false);
        Log.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { localObject });
        y.hhf();
        paramIntent = (v)y.C(0, null);
        if (!paramIntent.bpD((String)localObject)) {
          break label343;
        }
        if (!paramIntent.jq(paramActivity)) {
          break label150;
        }
        paramIntent.cs(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label313;
        }
        h.IzE.a(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(79109);
          return true;
          label150:
          paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
          paramIntent.setPackage((String)localObject);
          paramIntent.addFlags(524288);
          if (!d.qV(29)) {
            break label246;
          }
          paramIntent = PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728);
          try
          {
            paramIntent.send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(251280);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(251280);
              }
            }, null);
          }
          catch (Exception paramActivity)
          {
            Log.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
          }
        }
        break;
        label246:
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        label313:
        h.IzE.a(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label343:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage((String)localObject);
        paramIntent.addFlags(524288);
        try
        {
          if (d.qV(29)) {
            PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(228271);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(228271);
              }
            }, null);
          }
          for (;;)
          {
            h.IzE.a(10998, new Object[] { Integer.valueOf(5) });
            if (!bool) {
              break label555;
            }
            h.IzE.a(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
            break;
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            Log.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          label555:
          h.IzE.a(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    if (paramInt1 == 6)
    {
      if (paramInt2 == -1) {
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getIntExtra("browser_setting_result", 0);
          if (paramIntent == null) {
            break label775;
          }
          bool = true;
          label619:
          Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser onActivityResult resultCode: %d, data != null: %b, settingResult: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          if ((this.PWI != null) && (this.PWI.get() != null) && (paramIntent != null) && (paramInt1 == 1))
          {
            paramActivity = (k)this.PWI.get();
            localObject = new k.c();
            if (((k.c)localObject).QdY == null) {
              ((k.c)localObject).QdY = new Bundle();
            }
            if (paramIntent.getExtras() != null) {
              ((k.c)localObject).QdY.putAll(paramIntent.getExtras());
            }
            paramActivity.Qdy.put(Integer.valueOf(((k.c)localObject).qgq), localObject);
            paramActivity.gXW();
          }
        }
      }
      label775:
      label852:
      for (;;)
      {
        AppMethodBeat.o(79109);
        return true;
        paramInt1 = 0;
        break;
        bool = false;
        break label619;
        if (paramInt2 == 0)
        {
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("show_webview_menu", false))) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if ((paramInt1 == 0) || (this.PWI == null) || (this.PWI.get() == null)) {
              break label852;
            }
            Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser cancel and show webview menu");
            ((k)this.PWI.get()).gXW();
            break;
          }
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