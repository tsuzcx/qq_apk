package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class as
{
  public static Intent a(Bitmap paramBitmap, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(79043);
    ad.i("MicroMsg.WebViewShortcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      ad.e("MicroMsg.WebViewShortcutManager", "no bmp");
      AppMethodBeat.o(79043);
      return null;
    }
    Object localObject;
    if (paramBoolean) {
      localObject = "com.android.launcher.action.INSTALL_SHORTCUT";
    }
    for (;;)
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", paramString2);
      ((Intent)localObject).putExtra("duplicate", false);
      paramString2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      paramString2.putExtra("type", 4);
      try
      {
        paramString2.putExtra("ext_info", URLEncoder.encode(paramString1, "utf-8"));
        label113:
        paramString2.setPackage(aj.getPackageName());
        paramString2.addFlags(67108864);
        ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", paramString2);
        if (paramBitmap != null)
        {
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
          ((Intent)localObject).putExtra("shortcut_is_adaptive_icon", true);
        }
        AppMethodBeat.o(79043);
        return localObject;
        localObject = "com.android.launcher.action.UNINSTALL_SHORTCUT";
      }
      catch (UnsupportedEncodingException paramString1)
      {
        break label113;
      }
    }
  }
  
  public static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(79042);
    if (parama != null) {
      parama.tm(paramBoolean);
    }
    AppMethodBeat.o(79042);
  }
  
  public static abstract interface a
  {
    public abstract void tm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as
 * JD-Core Version:    0.7.0.1
 */