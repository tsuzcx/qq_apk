package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class a
{
  public static Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(6911);
    Bundle localBundle = new Bundle();
    localBundle.putString("targeturl", paramString);
    localBundle.putParcelable("targetintent", paramIntent);
    paramString = new Intent();
    paramString.setClass(paramActivity, AppChooserUI.class);
    paramString.putExtra("scene", 4);
    paramString.putExtra("type", 0);
    paramString.putExtra("title", paramActivity.getString(2131298353));
    paramString.putExtra("targetintent", paramIntent);
    paramString.putExtra("transferback", localBundle);
    AppMethodBeat.o(6911);
    return paramString;
  }
  
  public static boolean d(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6912);
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
        ab.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[] { str });
        r.dlm();
        paramIntent = (o)r.B(0, null);
        if (!paramIntent.alg(str)) {
          break label213;
        }
        if (!paramIntent.fL(paramActivity)) {
          break label143;
        }
        o.bt(paramActivity, localBundle.getString("targeturl"));
        if (!bool) {
          break label183;
        }
        h.qsU.e(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
      }
      for (;;)
      {
        AppMethodBeat.o(6912);
        return true;
        label143:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        paramActivity.startActivity(paramIntent);
        break;
        label183:
        h.qsU.e(10998, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
        continue;
        label213:
        paramIntent = new Intent((Intent)localBundle.getParcelable("targetintent"));
        paramIntent.setPackage(str);
        paramIntent.addFlags(524288);
        try
        {
          paramActivity.startActivity(paramIntent);
          h.qsU.e(10998, new Object[] { Integer.valueOf(5) });
          if (bool) {
            h.qsU.e(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
          }
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            ab.w("MicroMsg.BrowserChooserHelper", "onActivityResult err:%s", new Object[] { paramActivity.getMessage() });
          }
          h.qsU.e(10998, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
        }
      }
    }
    AppMethodBeat.o(6912);
    return false;
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(6910);
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(6910);
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
      if ((bo.hl(paramActivity)) || (g.dsn()))
      {
        paramActivity.startActivity(paramString);
        AppMethodBeat.o(6910);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      ab.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(6910);
      return;
    }
    paramActivity.startActivityForResult(a(paramActivity, paramString, str), 2);
    AppMethodBeat.o(6910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.a
 * JD-Core Version:    0.7.0.1
 */