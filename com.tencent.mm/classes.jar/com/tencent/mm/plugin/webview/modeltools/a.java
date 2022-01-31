package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("targeturl", paramString);
    localBundle.putParcelable("targetintent", paramIntent);
    paramString = new Intent();
    paramString.setClass(paramActivity, AppChooserUI.class);
    paramString.putExtra("scene", 4);
    paramString.putExtra("type", 0);
    paramString.putExtra("title", paramActivity.getString(R.l.choose_browser));
    paramString.putExtra("targetintent", paramIntent);
    paramString.putExtra("transferback", localBundle);
    return paramString;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
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
        y.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { str });
        s.ckE();
        paramIntent = (o)s.u(0, null);
        if (!paramIntent.VJ(str)) {
          break label201;
        }
        if (!paramIntent.eL(paramActivity)) {
          break label131;
        }
        o.bh(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label171;
        }
        h.nFQ.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        return true;
        label131:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        paramActivity.startActivity(paramIntent);
        break;
        label171:
        h.nFQ.f(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label201:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        paramActivity.startActivity(paramIntent);
        h.nFQ.f(10998, new Object[] { Integer.valueOf(5) });
        if (bool) {
          h.nFQ.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
        } else {
          h.nFQ.f(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    return false;
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (bk.bl(paramString))) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://"))
    {
      str = paramString;
      if (!paramString.startsWith("https://")) {
        str = "http://" + paramString;
      }
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(str));
    try
    {
      if (bk.fV(paramActivity))
      {
        paramActivity.startActivity(paramString);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      y.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
      return;
    }
    paramActivity.startActivityForResult(a(paramActivity, paramString, str), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.a
 * JD-Core Version:    0.7.0.1
 */