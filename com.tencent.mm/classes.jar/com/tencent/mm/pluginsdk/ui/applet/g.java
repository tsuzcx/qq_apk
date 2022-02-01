package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g
{
  private static boolean Dqg;
  public static final g Dqh;
  
  static
  {
    AppMethodBeat.i(124863);
    Dqh = new g();
    eNm();
    AppMethodBeat.o(124863);
  }
  
  public static boolean WS(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((com.tencent.mm.api.b.IC()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean WT(int paramInt)
  {
    return (Dqg) && (paramInt == 1);
  }
  
  public static boolean aHh(String paramString)
  {
    AppMethodBeat.i(124854);
    k.h(paramString, "url");
    if ((com.tencent.mm.api.b.IC()) && (com.tencent.mm.api.b.dB(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean aHi(String paramString)
  {
    AppMethodBeat.i(124856);
    k.h(paramString, "url");
    if ((q.aFE()) && (com.tencent.mm.api.b.dz(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean aHj(String paramString)
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
  
  public static int aHk(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (aHj(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (avm(paramString))
    {
      AppMethodBeat.o(124859);
      return 2;
    }
    AppMethodBeat.o(124859);
    return 0;
  }
  
  private static boolean avm(String paramString)
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
  
  public static final void eNm()
  {
    AppMethodBeat.i(124853);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUM, 0);
    boolean bool;
    if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
      bool = true;
    }
    for (;;)
    {
      Dqg = bool;
      ac.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(Dqg) });
      AppMethodBeat.o(124853);
      return;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String hu(Context paramContext)
  {
    AppMethodBeat.i(124861);
    if (!ax.isConnected(paramContext))
    {
      AppMethodBeat.o(124861);
      return "unknow";
    }
    if (ax.is4G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "4G";
    }
    if (ax.isWifi(paramContext))
    {
      AppMethodBeat.o(124861);
      return "WiFi";
    }
    if (ax.is3G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "3G";
    }
    if (ax.is2G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "2G";
    }
    AppMethodBeat.o(124861);
    return "other";
  }
  
  public static boolean kY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    k.h(paramString1, "url");
    if ((q.aFE()) && (avm(paramString2)) && (com.tencent.mm.api.b.dz(paramString1)))
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