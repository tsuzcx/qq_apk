package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;

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
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
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
        ac.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { str });
        t.eKN();
        paramIntent = (q)t.z(0, null);
        if (!paramIntent.aFV(str)) {
          break label266;
        }
        if (!paramIntent.hi(paramActivity)) {
          break label141;
        }
        q.bH(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label236;
        }
        h.wUl.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        AppMethodBeat.o(79109);
        return true;
        label141:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.aeD(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        label236:
        h.wUl.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label266:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        try
        {
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.aeD(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramIntent.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.wUl.f(10998, new Object[] { Integer.valueOf(5) });
          if (bool) {
            h.wUl.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            ac.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          h.wUl.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    AppMethodBeat.o(79109);
    return false;
  }
  
  public static void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(79107);
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (bs.isNullOrNil(paramString)))
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
      if ((bs.ja(paramActivity)) || (i.eUv()))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.aeD(), "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/webview/modeltools/BrowserChooserHelper", "showAndOpenInBrowser", "(Landroid/app/Activity;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79107);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      ac.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(79107);
      return;
    }
    paramActivity.startActivityForResult(a(paramActivity, paramString, str), 2);
    AppMethodBeat.o(79107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.a
 * JD-Core Version:    0.7.0.1
 */