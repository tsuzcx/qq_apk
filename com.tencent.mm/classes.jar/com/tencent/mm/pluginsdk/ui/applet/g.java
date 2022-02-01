package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g
{
  private static boolean EVj;
  public static final g EVk;
  
  static
  {
    AppMethodBeat.i(124863);
    EVk = new g();
    fcl();
    AppMethodBeat.o(124863);
  }
  
  public static boolean YO(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((com.tencent.mm.api.b.Kc()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean YP(int paramInt)
  {
    return (EVj) && (paramInt == 1);
  }
  
  private static boolean aAt(String paramString)
  {
    AppMethodBeat.i(124858);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (p.i(paramString, "image/webp")); i = 0)
    {
      AppMethodBeat.o(124858);
      return true;
    }
    AppMethodBeat.o(124858);
    return false;
  }
  
  public static boolean aMK(String paramString)
  {
    AppMethodBeat.i(124854);
    p.h(paramString, "url");
    if ((com.tencent.mm.api.b.Kc()) && (com.tencent.mm.api.b.ex(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean aML(String paramString)
  {
    AppMethodBeat.i(124856);
    p.h(paramString, "url");
    if ((t.aIN()) && (com.tencent.mm.api.b.ev(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean aMM(String paramString)
  {
    AppMethodBeat.i(124857);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (p.i(paramString, "image/wxpic")); i = 0)
    {
      AppMethodBeat.o(124857);
      return true;
    }
    AppMethodBeat.o(124857);
    return false;
  }
  
  public static int aMN(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (aMM(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (aAt(paramString))
    {
      AppMethodBeat.o(124859);
      return 2;
    }
    AppMethodBeat.o(124859);
    return 0;
  }
  
  public static String c(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(124862);
    p.h(paramUri, "uri");
    p.h(paramString, "key");
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((p.i(str, paramString) ^ true)) {
        localBuilder.appendQueryParameter(str, paramUri.getQueryParameter(str));
      }
    }
    paramUri = URLDecoder.decode(localBuilder.build().toString(), "utf-8");
    p.g(paramUri, "URLDecoder.decode(newUri…ld().toString(), \"utf-8\")");
    AppMethodBeat.o(124862);
    return paramUri;
  }
  
  public static final void fcl()
  {
    AppMethodBeat.i(124853);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzs, 0);
    boolean bool;
    if ((i.IS_FLAVOR_RED) || (i.DEBUG)) {
      bool = true;
    }
    for (;;)
    {
      EVj = bool;
      ad.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(EVj) });
      AppMethodBeat.o(124853);
      return;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String hz(Context paramContext)
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
    if (ay.is5G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "5G";
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
  
  public static boolean lv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    p.h(paramString1, "url");
    if ((t.aIN()) && (aAt(paramString2)) && (com.tencent.mm.api.b.ev(paramString1)))
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