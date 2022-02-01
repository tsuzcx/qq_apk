package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"})
public final class g
{
  private static boolean FnE;
  public static final g FnF;
  
  static
  {
    AppMethodBeat.i(124863);
    FnF = new g();
    ffZ();
    AppMethodBeat.o(124863);
  }
  
  public static boolean Zu(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((com.tencent.mm.api.b.Kk()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean Zv(int paramInt)
  {
    return (FnE) && (paramInt == 1);
  }
  
  private static boolean aBK(String paramString)
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
  
  public static boolean aOg(String paramString)
  {
    AppMethodBeat.i(124854);
    p.h(paramString, "url");
    if ((com.tencent.mm.api.b.Kk()) && (com.tencent.mm.api.b.eC(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean aOh(String paramString)
  {
    AppMethodBeat.i(124856);
    p.h(paramString, "url");
    if ((t.aJf()) && (com.tencent.mm.api.b.eA(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean aOi(String paramString)
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
  
  public static int aOj(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (aOi(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (aBK(paramString))
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
  
  public static final void ffZ()
  {
    AppMethodBeat.i(124853);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGy, 0);
    boolean bool;
    if ((j.IS_FLAVOR_RED) || (j.DEBUG)) {
      bool = true;
    }
    for (;;)
    {
      FnE = bool;
      ae.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(FnE) });
      AppMethodBeat.o(124853);
      return;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static String hF(Context paramContext)
  {
    AppMethodBeat.i(124861);
    if (!az.isConnected(paramContext))
    {
      AppMethodBeat.o(124861);
      return "unknow";
    }
    if (az.is4G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "4G";
    }
    if (az.is5G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "5G";
    }
    if (az.isWifi(paramContext))
    {
      AppMethodBeat.o(124861);
      return "WiFi";
    }
    if (az.is3G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "3G";
    }
    if (az.is2G(paramContext))
    {
      AppMethodBeat.o(124861);
      return "2G";
    }
    AppMethodBeat.o(124861);
    return "other";
  }
  
  public static boolean lC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    p.h(paramString1, "url");
    if ((t.aJf()) && (aBK(paramString2)) && (com.tencent.mm.api.b.eA(paramString1)))
    {
      AppMethodBeat.o(124855);
      return true;
    }
    AppMethodBeat.o(124855);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g
 * JD-Core Version:    0.7.0.1
 */