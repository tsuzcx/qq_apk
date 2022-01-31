package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import com.jg.JgClassChecked;
import com.tencent.luggage.a.e;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.z;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class u
{
  private static az gjF;
  private static q.a wgc;
  private static final Pattern wgd;
  
  static
  {
    AppMethodBeat.i(80489);
    wgc = null;
    gjF = null;
    wgd = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    AppMethodBeat.o(80489);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(80471);
    if (gjF == null) {
      gjF = new az(1, "webview-save-image", 1);
    }
    gjF.e(new u.c(paramContext, paramString1, paramString2, paramBoolean));
    AppMethodBeat.o(80471);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, u.a parama)
  {
    AppMethodBeat.i(80472);
    if (gjF == null) {
      gjF = new az(1, "webview-save-image", 1);
    }
    gjF.e(new u.c(paramContext, paramString1, paramString2, paramBoolean, 1, parama));
    AppMethodBeat.o(80472);
  }
  
  private static void a(u.b paramb)
  {
    AppMethodBeat.i(80474);
    ab.d("MicroMsg.WebViewUtil", "initIFrame");
    al.d(new u.2(paramb));
    AppMethodBeat.o(80474);
  }
  
  private static void a(u.b paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(80477);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(80477);
      return;
    }
    ab.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    a(paramb);
    al.d(new u.4(paramBoolean, paramb, paramString1, paramString2));
    AppMethodBeat.o(80477);
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(80476);
    if (paramWebView == null)
    {
      AppMethodBeat.o(80476);
      return;
    }
    a(new u.3(paramWebView), paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(80476);
  }
  
  public static final String aS(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(80479);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((!bo.isNullOrNil(str)) && (localObject != null) && ((!(localObject instanceof String)) || (!bo.isNullOrNil((String)localObject))))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(str);
        localStringBuilder.append("=");
        localStringBuilder.append(localObject);
      }
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(80479);
    return paramMap;
  }
  
  public static String agP(String paramString)
  {
    AppMethodBeat.i(80488);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80488);
      return paramString;
    }
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(80488);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(80488);
    return paramString;
  }
  
  public static boolean amS(String paramString)
  {
    AppMethodBeat.i(80468);
    if (paramString == null)
    {
      AppMethodBeat.o(80468);
      return false;
    }
    boolean bool = paramString.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    AppMethodBeat.o(80468);
    return bool;
  }
  
  public static final String amT(String paramString)
  {
    AppMethodBeat.i(80480);
    if (!bo.isNullOrNil(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        AppMethodBeat.o(80480);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ab.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    AppMethodBeat.o(80480);
    return paramString;
  }
  
  public static final String amU(String paramString)
  {
    AppMethodBeat.i(80481);
    if (!bo.isNullOrNil(paramString))
    {
      try
      {
        byte[] arrayOfByte = paramString.getBytes("utf-8");
        paramString = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          paramString = paramString.getBytes();
          ab.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      paramString = Base64.encodeToString(paramString, 2);
      AppMethodBeat.o(80481);
      return paramString;
    }
    AppMethodBeat.o(80481);
    return paramString;
  }
  
  public static String amV(String paramString)
  {
    AppMethodBeat.i(80484);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(80484);
      return null;
    }
    if (!wgd.matcher(paramString).matches())
    {
      AppMethodBeat.o(80484);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(80484);
    return paramString;
  }
  
  public static String amW(String paramString)
  {
    AppMethodBeat.i(80486);
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.startsWith("Refused to frame"))
      {
        paramString = paramString.split("'");
        str1 = str2;
        if (paramString.length > 2) {
          str1 = paramString[1];
        }
      }
    }
    AppMethodBeat.o(80486);
    return str1;
  }
  
  @Deprecated
  public static String amX(String paramString)
  {
    AppMethodBeat.i(80487);
    paramString = c.amX(paramString);
    AppMethodBeat.o(80487);
    return paramString;
  }
  
  public static void b(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(80475);
    a(paramWebView, paramString1, paramString2, true);
    AppMethodBeat.o(80475);
  }
  
  @Deprecated
  public static String bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(80467);
    paramContext = q.a(paramContext, paramString, (q.a)e.q(q.a.class));
    AppMethodBeat.o(80467);
    return paramContext;
  }
  
  public static String bQm()
  {
    i = 0;
    AppMethodBeat.i(80483);
    try
    {
      int j = z.LZ();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[] { localException1 });
      }
      if (i != 1) {
        break label68;
      }
      Object localObject1 = gb(ah.getContext());
      AppMethodBeat.o(80483);
      return localObject1;
      InetAddress localInetAddress;
      try
      {
        do
        {
          localObject1 = NetworkInterface.getNetworkInterfaces();
          Object localObject2;
          while (!((Enumeration)localObject2).hasMoreElements())
          {
            do
            {
              if (!((Enumeration)localObject1).hasMoreElements()) {
                break;
              }
              localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
            } while (localObject2 == null);
            localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          }
          localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
        } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        if (bo.isNullOrNil(localInetAddress.getHostAddress()))
        {
          AppMethodBeat.o(80483);
          return "127.0.0.1";
        }
      }
      catch (Exception localException2)
      {
        AppMethodBeat.o(80483);
        return "127.0.0.1";
      }
      String str = localInetAddress.getHostAddress();
      AppMethodBeat.o(80483);
      return str;
    }
    if (i == 0)
    {
      AppMethodBeat.o(80483);
      return "127.0.0.1";
    }
  }
  
  public static void d(WebView paramWebView)
  {
    AppMethodBeat.i(80473);
    if (paramWebView == null)
    {
      AppMethodBeat.o(80473);
      return;
    }
    a(new u.1(paramWebView));
    AppMethodBeat.o(80473);
  }
  
  public static String dcf()
  {
    AppMethodBeat.i(80485);
    Object localObject = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(80485);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(80485);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(80485);
      return "WIFI";
    }
    ab.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(80485);
      return localObject;
    }
    AppMethodBeat.o(80485);
    return "no";
  }
  
  private static String gb(Context paramContext)
  {
    AppMethodBeat.i(80482);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(80482);
        return "127.0.0.1";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      int i = paramContext.getIpAddress();
      paramContext = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
      AppMethodBeat.o(80482);
    }
    return paramContext;
  }
  
  @Deprecated
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(80470);
    paramContext = b.getPackageInfo(paramContext, paramString);
    AppMethodBeat.o(80470);
    return paramContext;
  }
  
  public static String hZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80478);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(80478);
      return null;
    }
    ab.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    paramString1 = "document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2;
    AppMethodBeat.o(80478);
    return paramString1;
  }
  
  public static boolean x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80469);
    boolean bool = h.x(paramString1, paramString2);
    AppMethodBeat.o(80469);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */