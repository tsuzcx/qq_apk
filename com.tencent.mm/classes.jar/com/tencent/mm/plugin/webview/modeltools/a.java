package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.browser.b;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.plugin.webview.ui.tools.o.c;
import com.tencent.mm.pluginsdk.model.aa;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  public WeakReference<o> WNn = null;
  
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
      if (d.rb(29))
      {
        PendingIntent.getActivity(paramActivity, 0, paramString, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
        {
          public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(295846);
            Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            AppMethodBeat.o(295846);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aYi(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(79107);
    return;
    label216:
    paramString = b.a(paramActivity, paramString, str);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(205, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString).aYi(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(79107);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79109);
    Object localObject;
    boolean bool;
    if (202 == paramInt1)
    {
      Bundle localBundle;
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("selectpkg");
        localBundle = paramIntent.getBundleExtra("transferback");
        bool = paramIntent.getBooleanExtra("isalways", false);
        Log.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { localObject });
        aa.iIe();
        paramIntent = (x)aa.F(0, null);
        if (!paramIntent.bpt((String)localObject)) {
          break label350;
        }
        if (!paramIntent.ln(paramActivity)) {
          break label152;
        }
        paramIntent.cD(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label320;
        }
        h.OAn.b(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(79109);
          return true;
          label152:
          paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
          paramIntent.setPackage((String)localObject);
          paramIntent.addFlags(524288);
          if (!d.rb(29)) {
            break label249;
          }
          paramIntent = PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728);
          try
          {
            paramIntent.send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(295832);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(295832);
              }
            }, null);
          }
          catch (Exception paramActivity)
          {
            Log.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
          }
        }
        break;
        label249:
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        label320:
        h.OAn.b(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label350:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage((String)localObject);
        paramIntent.addFlags(524288);
        try
        {
          if (d.rb(29)) {
            PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(295834);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(295834);
              }
            }, null);
          }
          for (;;)
          {
            h.OAn.b(10998, new Object[] { Integer.valueOf(5) });
            if (!bool) {
              break label567;
            }
            h.OAn.b(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
            break;
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            Log.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          label567:
          h.OAn.b(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    if (paramInt1 == 205)
    {
      if (paramInt2 == -1) {
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getIntExtra("browser_setting_result", 0);
          if (paramIntent == null) {
            break label788;
          }
          bool = true;
          label632:
          Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser onActivityResult resultCode: %d, data != null: %b, settingResult: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          if ((this.WNn != null) && (this.WNn.get() != null) && (paramIntent != null) && (paramInt1 == 1))
          {
            paramActivity = (o)this.WNn.get();
            localObject = new o.c();
            if (((o.c)localObject).WVT == null) {
              ((o.c)localObject).WVT = new Bundle();
            }
            if (paramIntent.getExtras() != null) {
              ((o.c)localObject).WVT.putAll(paramIntent.getExtras());
            }
            paramActivity.WVm.put(Integer.valueOf(((o.c)localObject).tlb), localObject);
            paramActivity.ixS();
          }
        }
      }
      label788:
      label865:
      for (;;)
      {
        AppMethodBeat.o(79109);
        return true;
        paramInt1 = 0;
        break;
        bool = false;
        break label632;
        if (paramInt2 == 0)
        {
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("show_webview_menu", false))) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if ((paramInt1 == 0) || (this.WNn == null) || (this.WNn.get() == null)) {
              break label865;
            }
            Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser cancel and show webview menu");
            ((o)this.WNn.get()).ixS();
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