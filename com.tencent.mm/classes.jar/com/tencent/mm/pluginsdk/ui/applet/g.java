package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g
{
  private static boolean Rfi;
  public static final g Rfj;
  
  static
  {
    AppMethodBeat.i(124863);
    Rfj = new g();
    hkg();
    AppMethodBeat.o(124863);
  }
  
  public static String a(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(124862);
    p.k(paramUri, "uri");
    p.k(paramString, "key");
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((p.h(str, paramString) ^ true)) {
        localBuilder.appendQueryParameter(str, paramUri.getQueryParameter(str));
      }
    }
    paramUri = URLDecoder.decode(localBuilder.build().toString(), "utf-8");
    p.j(paramUri, "URLDecoder.decode(newUri…ld().toString(), \"utf-8\")");
    AppMethodBeat.o(124862);
    return paramUri;
  }
  
  public static boolean aqh(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((com.tencent.mm.api.b.YL()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean aqi(int paramInt)
  {
    return (Rfi) && (paramInt == 1);
  }
  
  private static boolean bbF(String paramString)
  {
    AppMethodBeat.i(124858);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (p.h(paramString, "image/webp")); i = 0)
    {
      AppMethodBeat.o(124858);
      return true;
    }
    AppMethodBeat.o(124858);
    return false;
  }
  
  public static boolean bre(String paramString)
  {
    AppMethodBeat.i(124854);
    p.k(paramString, "url");
    if ((com.tencent.mm.api.b.YL()) && (com.tencent.mm.api.b.fZ(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean brf(String paramString)
  {
    AppMethodBeat.i(124856);
    p.k(paramString, "url");
    if ((t.bmq()) && (com.tencent.mm.api.b.fX(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean brg(String paramString)
  {
    AppMethodBeat.i(124857);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (p.h(paramString, "image/wxpic")); i = 0)
    {
      AppMethodBeat.o(124857);
      return true;
    }
    AppMethodBeat.o(124857);
    return false;
  }
  
  public static int brh(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (brg(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (bbF(paramString))
    {
      AppMethodBeat.o(124859);
      return 2;
    }
    AppMethodBeat.o(124859);
    return 0;
  }
  
  public static final void hkg()
  {
    AppMethodBeat.i(124853);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGP, 0);
    boolean bool;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
      bool = true;
    }
    for (;;)
    {
      Rfi = bool;
      Log.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(Rfi) });
      AppMethodBeat.o(124853);
      return;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String jC(Context paramContext)
  {
    AppMethodBeat.i(124861);
    if (!NetStatusUtil.isConnected(paramContext))
    {
      AppMethodBeat.o(124861);
      return "unknow";
    }
    if (NetStatusUtil.is4G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "4G";
    }
    if (NetStatusUtil.is5G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "5G";
    }
    if (NetStatusUtil.isWifi(paramContext))
    {
      AppMethodBeat.o(124861);
      return "WiFi";
    }
    if (NetStatusUtil.is3G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "3G";
    }
    if (NetStatusUtil.is2G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "2G";
    }
    AppMethodBeat.o(124861);
    return "other";
  }
  
  public static boolean nq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    p.k(paramString1, "url");
    if ((t.bmq()) && (bbF(paramString2)) && (com.tencent.mm.api.b.fX(paramString1)))
    {
      AppMethodBeat.o(124855);
      return true;
    }
    AppMethodBeat.o(124855);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g
 * JD-Core Version:    0.7.0.1
 */