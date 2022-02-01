package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
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
public final class z
{
  private static p.a KwS;
  private static final Pattern KwT;
  private static int KwU;
  private static int KwV;
  private static int KwW;
  private static QueueWorkerThread jNp;
  
  static
  {
    AppMethodBeat.i(103177);
    KwS = null;
    jNp = null;
    KwT = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    KwU = -1;
    KwV = -1;
    KwW = -1;
    AppMethodBeat.o(103177);
  }
  
  public static boolean C(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103157);
    boolean bool = l.C(paramString1, paramString2);
    AppMethodBeat.o(103157);
    return bool;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(103160);
    if (jNp == null) {
      jNp = new QueueWorkerThread(1, "webview-save-image", 1);
    }
    jNp.add(new z.c(paramContext, paramString1, paramString2, paramBoolean, 1, parama));
    AppMethodBeat.o(103160);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(103162);
    Log.d("MicroMsg.WebViewUtil", "initIFrame");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224523);
        this.Kxa.cT("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
        AppMethodBeat.o(224523);
      }
    });
    AppMethodBeat.o(103162);
  }
  
  private static void a(final b paramb, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(103165);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103165);
      return;
    }
    Log.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    a(paramb);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224525);
        if (this.Kxb)
        {
          paramb.cT("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2);
          AppMethodBeat.o(224525);
          return;
        }
        paramb.cT("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")");
        AppMethodBeat.o(224525);
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
      public final void cT(String paramAnonymousString)
      {
        AppMethodBeat.i(224524);
        this.KwZ.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(224524);
      }
    }, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(103164);
  }
  
  public static String aYy(String paramString)
  {
    AppMethodBeat.i(103176);
    if (Util.isNullOrNil(paramString))
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
  
  public static void b(Context paramContext, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(103159);
    com.tencent.mm.platformtools.p.a(paramContext, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(224520);
        if (z.gsN() == null) {
          z.a(new QueueWorkerThread(1, "webview-save-image", 1));
        }
        z.gsN().add(new z.c(this.val$context, paramString1, paramString2, paramBoolean));
        AppMethodBeat.o(224520);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224521);
        Toast.makeText(this.val$context, this.val$context.getString(2131768791), 1).show();
        AppMethodBeat.o(224521);
      }
    });
    AppMethodBeat.o(103159);
  }
  
  public static final String bS(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(103167);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((!Util.isNullOrNil(str)) && (localObject != null) && ((!(localObject instanceof String)) || (!Util.isNullOrNil((String)localObject))))
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
  
  public static boolean bfF(String paramString)
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
  
  public static final String bfG(String paramString)
  {
    AppMethodBeat.i(103168);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        AppMethodBeat.o(103168);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    AppMethodBeat.o(103168);
    return paramString;
  }
  
  public static final String bfH(String paramString)
  {
    AppMethodBeat.i(103169);
    if (!Util.isNullOrNil(paramString))
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
          Log.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      paramString = Base64.encodeToString(paramString, 2);
      AppMethodBeat.o(103169);
      return paramString;
    }
    AppMethodBeat.o(103169);
    return paramString;
  }
  
  public static String bfI(String paramString)
  {
    AppMethodBeat.i(103172);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103172);
      return null;
    }
    if (!KwT.matcher(paramString).matches())
    {
      AppMethodBeat.o(103172);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(103172);
    return paramString;
  }
  
  public static String bfJ(String paramString)
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
  
  public static String bfK(String paramString)
  {
    AppMethodBeat.i(224527);
    paramString = String.format("preverify://url=%s", new Object[] { URLEncoder.encode(aYy(Util.nullAsNil(paramString))) });
    AppMethodBeat.o(224527);
    return paramString;
  }
  
  public static String bfL(String paramString)
  {
    AppMethodBeat.i(184503);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (ao.isDarkMode())
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
        Log.e("MicroMsg.WebViewUtil", paramString.getMessage());
      }
    }
    AppMethodBeat.o(184503);
    return null;
  }
  
  public static boolean bfM(String paramString)
  {
    AppMethodBeat.i(224531);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224531);
      return false;
    }
    try
    {
      boolean bool = new URL(paramString).getHost().equals(WeChatHosts.domainString(2131761726));
      if (!bool)
      {
        AppMethodBeat.o(224531);
        return false;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebViewUtil", "create url fail : " + paramString.getLocalizedMessage());
      AppMethodBeat.o(224531);
      return false;
    }
    AppMethodBeat.o(224531);
    return true;
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
      public final void cT(String paramAnonymousString)
      {
        AppMethodBeat.i(224522);
        this.KwZ.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(224522);
      }
    });
    AppMethodBeat.o(103161);
  }
  
  @Deprecated
  public static String cr(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103155);
    paramContext = com.tencent.mm.plugin.appbrand.ac.p.a(paramContext, paramString, (p.a)e.M(p.a.class));
    AppMethodBeat.o(103155);
    return paramContext;
  }
  
  public static String gcX()
  {
    AppMethodBeat.i(103173);
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
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
    Log.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(103173);
      return localObject;
    }
    AppMethodBeat.o(103173);
    return "no";
  }
  
  @Deprecated
  public static String getMimeTypeByFilePath(String paramString)
  {
    AppMethodBeat.i(103175);
    paramString = MimeTypeUtil.getMimeTypeByFilePath(paramString);
    AppMethodBeat.o(103175);
    return paramString;
  }
  
  @Deprecated
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103158);
    paramContext = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(paramContext, paramString);
    AppMethodBeat.o(103158);
    return paramContext;
  }
  
  public static boolean gsK()
  {
    AppMethodBeat.i(224528);
    if (KwU != -1)
    {
      if (KwU == 1)
      {
        AppMethodBeat.o(224528);
        return true;
      }
      AppMethodBeat.o(224528);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("bizCommand").decodeInt("sameLayerOpen", -1);
    KwU = i;
    if (i != -1)
    {
      if (KwU == 1)
      {
        AppMethodBeat.o(224528);
        return true;
      }
      AppMethodBeat.o(224528);
      return false;
    }
    KwU = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSY, 1);
    Log.i("MicroMsg.WebViewUtil", "useSameLayerForVideo useSameLayer=%d", new Object[] { Integer.valueOf(KwU) });
    if (KwU == 1)
    {
      AppMethodBeat.o(224528);
      return true;
    }
    AppMethodBeat.o(224528);
    return false;
  }
  
  public static boolean gsL()
  {
    AppMethodBeat.i(224529);
    if (KwV != -1)
    {
      if (KwV == 1)
      {
        AppMethodBeat.o(224529);
        return true;
      }
      AppMethodBeat.o(224529);
      return false;
    }
    KwV = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSN, 1);
    Log.i("MicroMsg.WebViewUtil", "updateRandomStr updateRandomStr=%d", new Object[] { Integer.valueOf(KwV) });
    if (KwV == 1)
    {
      AppMethodBeat.o(224529);
      return true;
    }
    AppMethodBeat.o(224529);
    return false;
  }
  
  public static boolean gsM()
  {
    AppMethodBeat.i(224530);
    if (KwW != -1)
    {
      if (KwW == 1)
      {
        AppMethodBeat.o(224530);
        return true;
      }
      AppMethodBeat.o(224530);
      return false;
    }
    if ((BuildInfo.IS_FLAVOR_RED) || ((WeChatEnvironment.hasDebugger()) && (1 > Log.getLogLevel())))
    {
      AppMethodBeat.o(224530);
      return true;
    }
    KwW = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSZ, 0);
    Log.i("MicroMsg.WebViewUtil", "mpVideoShareToSns open=%d", new Object[] { Integer.valueOf(KwW) });
    if (KwW == 1)
    {
      AppMethodBeat.o(224530);
      return true;
    }
    AppMethodBeat.o(224530);
    return false;
  }
  
  public static String mH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103166);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103166);
      return null;
    }
    Log.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    paramString1 = "document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2;
    AppMethodBeat.o(103166);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void abE(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void cT(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.z
 * JD-Core Version:    0.7.0.1
 */