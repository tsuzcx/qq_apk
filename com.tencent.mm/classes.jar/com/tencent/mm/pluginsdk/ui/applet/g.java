package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.modelimage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadUtil;", "", "()V", "TAG", "", "enableImageBlankReport", "", "canReport", "scene", "", "canReportBlank", "getFormattedNetType", "context", "Landroid/content/Context;", "getImageTypeByContentType", "contentType", "getRequestImageTypeByUrl", "url", "isJpeg", "isRequestJpeg", "isRequestWebp", "isRequestWxPic", "isResponseWebp", "isResponseWxPic", "isWebp", "isWxPic", "removeQueryParameter", "uri", "Landroid/net/Uri;", "key", "updateEnableImageBlankReport", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g Ybp;
  private static boolean Ybq;
  
  static
  {
    AppMethodBeat.i(124863);
    Ybp = new g();
    iKY();
    AppMethodBeat.o(124863);
  }
  
  public static boolean awl(int paramInt)
  {
    AppMethodBeat.i(124860);
    if ((b.aAF()) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)))
    {
      AppMethodBeat.o(124860);
      return true;
    }
    AppMethodBeat.o(124860);
    return false;
  }
  
  public static boolean awm(int paramInt)
  {
    return (Ybq) && (paramInt == 1);
  }
  
  public static String b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(124862);
    s.u(paramUri, "uri");
    s.u(paramString, "key");
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!s.p(str, paramString)) {
        localBuilder.appendQueryParameter(str, paramUri.getQueryParameter(str));
      }
    }
    paramUri = URLDecoder.decode(localBuilder.build().toString(), "utf-8");
    s.s(paramUri, "decode(newUri.build().toString(), \"utf-8\")");
    AppMethodBeat.o(124862);
    return paramUri;
  }
  
  private static boolean bam(String paramString)
  {
    AppMethodBeat.i(124858);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (s.p(paramString, "image/webp")); i = 0)
    {
      AppMethodBeat.o(124858);
      return true;
    }
    AppMethodBeat.o(124858);
    return false;
  }
  
  public static boolean bqS(String paramString)
  {
    AppMethodBeat.i(124854);
    s.u(paramString, "url");
    if ((b.aAF()) && (b.hC(paramString)))
    {
      AppMethodBeat.o(124854);
      return true;
    }
    AppMethodBeat.o(124854);
    return false;
  }
  
  public static boolean bqT(String paramString)
  {
    AppMethodBeat.i(124856);
    s.u(paramString, "url");
    if ((u.bKj()) && (b.hA(paramString)))
    {
      AppMethodBeat.o(124856);
      return true;
    }
    AppMethodBeat.o(124856);
    return false;
  }
  
  public static boolean bqU(String paramString)
  {
    AppMethodBeat.i(124857);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (s.p(paramString, "image/wxpic")); i = 0)
    {
      AppMethodBeat.o(124857);
      return true;
    }
    AppMethodBeat.o(124857);
    return false;
  }
  
  public static int bqV(String paramString)
  {
    AppMethodBeat.i(124859);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124859);
      return -1;
    }
    if (bqU(paramString))
    {
      AppMethodBeat.o(124859);
      return 1;
    }
    if (bam(paramString))
    {
      AppMethodBeat.o(124859);
      return 2;
    }
    AppMethodBeat.o(124859);
    return 0;
  }
  
  public static final void iKY()
  {
    AppMethodBeat.i(124853);
    Ybq = true;
    Log.i("MicroMsg.BizImageDownloadUtil", "alvinluo updateEnableImageBlankReport %b", new Object[] { Boolean.valueOf(Ybq) });
    AppMethodBeat.o(124853);
  }
  
  public static String lB(Context paramContext)
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
  
  public static boolean pl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124855);
    s.u(paramString1, "url");
    if ((u.bKj()) && (bam(paramString2)) && (b.hA(paramString1)))
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