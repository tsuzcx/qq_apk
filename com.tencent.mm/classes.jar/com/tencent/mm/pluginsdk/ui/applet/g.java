package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g
{
  private static boolean BXP;
  public static final g BXQ;
  
  static
  {
    AppMethodBeat.i(124863);
    BXQ = new g();
    exS();
    AppMethodBeat.o(124863);
  }
  
  public static boolean UI(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((com.tencent.mm.api.b.IT()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean UJ(int paramInt)
  {
    return (BXP) && (paramInt == 1);
  }
  
  public static boolean aBP(String paramString)
  {
    AppMethodBeat.i(124854);
    k.h(paramString, "url");
    if ((com.tencent.mm.api.b.IT()) && (com.tencent.mm.api.b.dM(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean aBQ(String paramString)
  {
    AppMethodBeat.i(124856);
    k.h(paramString, "url");
    if ((q.ayM()) && (com.tencent.mm.api.b.dK(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean aBR(String paramString)
  {
    AppMethodBeat.i(124857);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (k.g(paramString, "image/wxpic")); i = 0)
    {
      AppMethodBeat.o(124857);
      return true;
    }
    AppMethodBeat.o(124857);
    return false;
  }
  
  public static int aBS(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (aBR(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (aqd(paramString))
    {
      AppMethodBeat.o(124859);
      return 2;
    }
    AppMethodBeat.o(124859);
    return 0;
  }
  
  private static boolean aqd(String paramString)
  {
    AppMethodBeat.i(124858);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (k.g(paramString, "image/webp")); i = 0)
    {
      AppMethodBeat.o(124858);
      return true;
    }
    AppMethodBeat.o(124858);
    return false;
  }
  
  public static String c(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(124862);
    k.h(paramUri, "uri");
    k.h(paramString, "key");
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((k.g(str, paramString) ^ true)) {
        localBuilder.appendQueryParameter(str, paramUri.getQueryParameter(str));
      }
    }
    paramUri = URLDecoder.decode(localBuilder.build().toString(), "utf-8");
    k.g(paramUri, "URLDecoder.decode(newUri…ld().toString(), \"utf-8\")");
    AppMethodBeat.o(124862);
    return paramUri;
  }
  
  public static final void exS()
  {
    AppMethodBeat.i(124853);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqZ, 0);
    boolean bool;
    if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
      bool = true;
    }
    for (;;)
    {
      BXP = bool;
      ad.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(BXP) });
      AppMethodBeat.o(124853);
      return;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String hj(Context paramContext)
  {
    AppMethodBeat.i(124861);
    if (!ay.isConnected(paramContext))
    {
      AppMethodBeat.o(124861);
      return "unknow";
    }
    if (ay.is4G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "4G";
    }
    if (ay.isWifi(paramContext))
    {
      AppMethodBeat.o(124861);
      return "WiFi";
    }
    if (ay.is3G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "3G";
    }
    if (ay.is2G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "2G";
    }
    AppMethodBeat.o(124861);
    return "other";
  }
  
  public static boolean kB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    k.h(paramString1, "url");
    if ((q.ayM()) && (aqd(paramString2)) && (com.tencent.mm.api.b.dK(paramString1)))
    {
      AppMethodBeat.o(124855);
      return true;
    }
    AppMethodBeat.o(124855);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g
 * JD-Core Version:    0.7.0.1
 */