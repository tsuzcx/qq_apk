package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.al;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class x
{
  private static p.a FDO;
  private static final Pattern FDP;
  private static int FDQ;
  private static int FDR;
  private static int FDS;
  private static bf iQt;
  
  static
  {
    AppMethodBeat.i(103177);
    FDO = null;
    iQt = null;
    FDP = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    FDQ = -1;
    FDR = -1;
    FDS = -1;
    AppMethodBeat.o(103177);
  }
  
  public static boolean C(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103157);
    boolean bool = k.C(paramString1, paramString2);
    AppMethodBeat.o(103157);
    return bool;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(103160);
    if (iQt == null) {
      iQt = new bf(1, "webview-save-image", 1);
    }
    iQt.c(new x.c(paramContext, paramString1, paramString2, paramBoolean, 1, parama));
    AppMethodBeat.o(103160);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(103162);
    ae.d("MicroMsg.WebViewUtil", "initIFrame");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213842);
        this.FDW.cC("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
        AppMethodBeat.o(213842);
      }
    });
    AppMethodBeat.o(103162);
  }
  
  private static void a(final b paramb, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(103165);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103165);
      return;
    }
    ae.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    a(paramb);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213844);
        if (this.FDX)
        {
          paramb.cC("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2);
          AppMethodBeat.o(213844);
          return;
        }
        paramb.cC("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")");
        AppMethodBeat.o(213844);
      }
    });
    AppMethodBeat.o(103165);
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103163);
    a(paramWebView, paramString1, paramString2, true);
    AppMethodBeat.o(103163);
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(103164);
    if (paramWebView == null)
    {
      AppMethodBeat.o(103164);
      return;
    }
    a(new b()
    {
      public final void cC(String paramAnonymousString)
      {
        AppMethodBeat.i(213843);
        this.FDV.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(213843);
      }
    }, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(103164);
  }
  
  public static String aIw(String paramString)
  {
    AppMethodBeat.i(103176);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103176);
      return paramString;
    }
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(103176);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(103176);
    return paramString;
  }
  
  public static boolean aPb(String paramString)
  {
    AppMethodBeat.i(103156);
    if (paramString == null)
    {
      AppMethodBeat.o(103156);
      return false;
    }
    boolean bool = paramString.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    AppMethodBeat.o(103156);
    return bool;
  }
  
  public static final String aPc(String paramString)
  {
    AppMethodBeat.i(103168);
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        AppMethodBeat.o(103168);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ae.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    AppMethodBeat.o(103168);
    return paramString;
  }
  
  public static final String aPd(String paramString)
  {
    AppMethodBeat.i(103169);
    if (!bu.isNullOrNil(paramString))
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
          ae.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      paramString = Base64.encodeToString(paramString, 2);
      AppMethodBeat.o(103169);
      return paramString;
    }
    AppMethodBeat.o(103169);
    return paramString;
  }
  
  public static String aPe(String paramString)
  {
    AppMethodBeat.i(103172);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103172);
      return null;
    }
    if (!FDP.matcher(paramString).matches())
    {
      AppMethodBeat.o(103172);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(103172);
    return paramString;
  }
  
  public static String aPf(String paramString)
  {
    AppMethodBeat.i(103174);
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
    AppMethodBeat.o(103174);
    return str1;
  }
  
  @Deprecated
  public static String aPg(String paramString)
  {
    AppMethodBeat.i(103175);
    paramString = d.aPg(paramString);
    AppMethodBeat.o(103175);
    return paramString;
  }
  
  public static String aPh(String paramString)
  {
    AppMethodBeat.i(213846);
    paramString = String.format("preverify://url=%s", new Object[] { URLEncoder.encode(aIw(bu.nullAsNil(paramString))) });
    AppMethodBeat.o(213846);
    return paramString;
  }
  
  public static String aPi(String paramString)
  {
    AppMethodBeat.i(184503);
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (al.isDarkMode())
        {
          paramString = paramString.optString("dark");
          AppMethodBeat.o(184503);
          return paramString;
        }
        paramString = paramString.optString("light");
        AppMethodBeat.o(184503);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.WebViewUtil", paramString.getMessage());
      }
    }
    AppMethodBeat.o(184503);
    return null;
  }
  
  public static boolean aPj(String paramString)
  {
    AppMethodBeat.i(213850);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213850);
      return false;
    }
    try
    {
      boolean bool = new URL(paramString).getHost().equals("mp.weixin.qq.com");
      if (!bool)
      {
        AppMethodBeat.o(213850);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.WebViewUtil", "create url fail : " + paramString.getLocalizedMessage());
      AppMethodBeat.o(213850);
      return false;
    }
    AppMethodBeat.o(213850);
    return true;
  }
  
  public static void b(Context paramContext, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(103159);
    com.tencent.mm.platformtools.p.a(paramContext, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(213839);
        if (x.fjn() == null) {
          x.a(new bf(1, "webview-save-image", 1));
        }
        x.fjn().c(new x.c(this.val$context, paramString1, paramString2, paramBoolean));
        AppMethodBeat.o(213839);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213840);
        Toast.makeText(this.val$context, this.val$context.getString(2131766280), 1).show();
        AppMethodBeat.o(213840);
      }
    });
    AppMethodBeat.o(103159);
  }
  
  public static final String bN(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(103167);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((!bu.isNullOrNil(str)) && (localObject != null) && ((!(localObject instanceof String)) || (!bu.isNullOrNil((String)localObject))))
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
    AppMethodBeat.o(103167);
    return paramMap;
  }
  
  @Deprecated
  public static String bX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103155);
    paramContext = com.tencent.mm.plugin.appbrand.y.p.a(paramContext, paramString, (p.a)e.K(p.a.class));
    AppMethodBeat.o(103155);
    return paramContext;
  }
  
  public static void c(WebView paramWebView)
  {
    AppMethodBeat.i(103161);
    if (paramWebView == null)
    {
      AppMethodBeat.o(103161);
      return;
    }
    a(new b()
    {
      public final void cC(String paramAnonymousString)
      {
        AppMethodBeat.i(213841);
        this.FDV.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(213841);
      }
    });
    AppMethodBeat.o(103161);
  }
  
  public static String diy()
  {
    AppMethodBeat.i(103173);
    Object localObject = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(103173);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(103173);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(103173);
      return "WIFI";
    }
    ae.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(103173);
      return localObject;
    }
    AppMethodBeat.o(103173);
    return "no";
  }
  
  public static boolean fjk()
  {
    AppMethodBeat.i(213847);
    if (FDQ != -1)
    {
      if (FDQ == 1)
      {
        AppMethodBeat.o(213847);
        return true;
      }
      AppMethodBeat.o(213847);
      return false;
    }
    int i = ay.aRW("bizCommand").decodeInt("sameLayerOpen", -1);
    FDQ = i;
    if (i != -1)
    {
      if (FDQ == 1)
      {
        AppMethodBeat.o(213847);
        return true;
      }
      AppMethodBeat.o(213847);
      return false;
    }
    FDQ = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAK, 0);
    ae.i("MicroMsg.WebViewUtil", "useSameLayerForVideo useSameLayer=%d", new Object[] { Integer.valueOf(FDQ) });
    if (FDQ == 1)
    {
      AppMethodBeat.o(213847);
      return true;
    }
    AppMethodBeat.o(213847);
    return false;
  }
  
  public static boolean fjl()
  {
    AppMethodBeat.i(213848);
    if (FDR != -1)
    {
      if (FDR == 1)
      {
        AppMethodBeat.o(213848);
        return true;
      }
      AppMethodBeat.o(213848);
      return false;
    }
    FDR = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAA, 1);
    ae.i("MicroMsg.WebViewUtil", "updateRandomStr updateRandomStr=%d", new Object[] { Integer.valueOf(FDR) });
    if (FDR == 1)
    {
      AppMethodBeat.o(213848);
      return true;
    }
    AppMethodBeat.o(213848);
    return false;
  }
  
  public static boolean fjm()
  {
    AppMethodBeat.i(213849);
    if (FDS != -1)
    {
      if (FDS == 1)
      {
        AppMethodBeat.o(213849);
        return true;
      }
      AppMethodBeat.o(213849);
      return false;
    }
    if ((j.IS_FLAVOR_RED) || ((bv.fpT()) && (1 > ae.getLogLevel())))
    {
      AppMethodBeat.o(213849);
      return true;
    }
    FDS = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAL, 0);
    ae.i("MicroMsg.WebViewUtil", "mpVideoShareToSns open=%d", new Object[] { Integer.valueOf(FDS) });
    if (FDS == 1)
    {
      AppMethodBeat.o(213849);
      return true;
    }
    AppMethodBeat.o(213849);
    return false;
  }
  
  @Deprecated
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103158);
    paramContext = com.tencent.mm.plugin.appbrand.y.b.getPackageInfo(paramContext, paramString);
    AppMethodBeat.o(103158);
    return paramContext;
  }
  
  public static String lJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103166);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103166);
      return null;
    }
    ae.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    paramString1 = "document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2;
    AppMethodBeat.o(103166);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void RZ(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void cC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */