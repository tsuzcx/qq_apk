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
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.plugin.webview.ui.tools.j.a;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  public WeakReference<j> Jaq = null;
  
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
      if (d.oD(29))
      {
        PendingIntent.getActivity(paramActivity, 0, paramString, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
        {
          public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(211025);
            Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            AppMethodBeat.o(211025);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(79107);
    return;
    label216:
    paramActivity.startActivityForResult(b.a(paramActivity, paramString, str), 6);
    AppMethodBeat.o(79107);
  }
  
  public final boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
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
        u.gmF();
        paramIntent = (r)u.A(0, null);
        if (!paramIntent.bdn((String)localObject)) {
          break label343;
        }
        if (!paramIntent.in(paramActivity)) {
          break label150;
        }
        paramIntent.cg(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label313;
        }
        h.CyF.a(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
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
          if (!d.oD(29)) {
            break label246;
          }
          paramIntent = PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728);
          try
          {
            paramIntent.send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(211026);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(211026);
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        label313:
        h.CyF.a(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label343:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage((String)localObject);
        paramIntent.addFlags(524288);
        try
        {
          if (d.oD(29)) {
            PendingIntent.getActivity(paramActivity, 0, paramIntent, 134217728).send(paramActivity, 1, null, new PendingIntent.OnFinished()
            {
              public final void onSendFinished(PendingIntent paramAnonymousPendingIntent, Intent paramAnonymousIntent, int paramAnonymousInt, String paramAnonymousString, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(211027);
                Log.i("MicroMsg.BrowserChooserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
                AppMethodBeat.o(211027);
              }
            }, null);
          }
          for (;;)
          {
            h.CyF.a(10998, new Object[] { Integer.valueOf(5) });
            if (!bool) {
              break label555;
            }
            h.CyF.a(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
            break;
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramActivity.startActivity((Intent)paramIntent.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            Log.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          label555:
          h.CyF.a(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
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
          if ((this.Jaq != null) && (this.Jaq.get() != null) && (paramIntent != null) && (paramInt1 == 1))
          {
            paramActivity = (j)this.Jaq.get();
            localObject = new j.a();
            if (((j.a)localObject).JgL == null) {
              ((j.a)localObject).JgL = new Bundle();
            }
            if (paramIntent.getExtras() != null) {
              ((j.a)localObject).JgL.putAll(paramIntent.getExtras());
            }
            paramActivity.Jgo.put(Integer.valueOf(((j.a)localObject).nfG), localObject);
            paramActivity.cpD();
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
            if ((paramInt1 == 0) || (this.Jaq == null) || (this.Jaq.get() == null)) {
              break label852;
            }
            Log.i("MicroMsg.BrowserChooserHelper", "alvinluo chooseBrowser cancel and show webview menu");
            ((j)this.Jaq.get()).cpD();
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