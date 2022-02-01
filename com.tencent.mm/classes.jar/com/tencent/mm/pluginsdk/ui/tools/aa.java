package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.sensitive.d;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class aa
{
  private static r.a YuF;
  private static final Pattern YuG;
  private static int YuH;
  private static int YuI;
  private static QueueWorkerThread pBa;
  
  static
  {
    AppMethodBeat.i(103177);
    YuF = null;
    pBa = null;
    YuG = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    YuH = -1;
    YuI = -1;
    AppMethodBeat.o(103177);
  }
  
  public static boolean M(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103157);
    boolean bool = m.M(paramString1, paramString2);
    AppMethodBeat.o(103157);
    return bool;
  }
  
  public static void a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    AppMethodBeat.i(245593);
    ExportFileUtil.a(paramContext, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(245758);
        if (((d)com.tencent.mm.kernel.h.az(d.class)).checkAndShowPermissionDialog(d.c.actw, d.a.acto, new d.f()
        {
          public final void onOp(Boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(245606);
            if (paramAnonymous2Boolean.booleanValue()) {
              aa.a(aa.this, aa.1.this.PUd, aa.1.this.WvY, aa.1.this.YuJ, aa.1.this.WVc);
            }
            AppMethodBeat.o(245606);
          }
        }))
        {
          Log.i("MicroMsg.WebViewUtil", "business switch close ,return");
          AppMethodBeat.o(245758);
          return;
        }
        if (aa.iON() == null) {
          aa.a(new QueueWorkerThread(1, "webview-save-image", 1));
        }
        aa.iON().add(new aa.c(aa.this, paramString1, paramString2, paramString3, paramBoolean));
        AppMethodBeat.o(245758);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245760);
        Toast.makeText(aa.this, aa.this.getString(a.e.wv_save_image_error), 1).show();
        AppMethodBeat.o(245760);
      }
    });
    AppMethodBeat.o(245593);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(245595);
    if (pBa == null) {
      pBa = new QueueWorkerThread(1, "webview-save-image", 1);
    }
    pBa.add(new c(paramContext, paramString1, paramString2, paramString3, paramBoolean, 1, parama));
    AppMethodBeat.o(245595);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(103160);
    a(paramContext, paramString1, "", paramString2, paramBoolean, parama);
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
        AppMethodBeat.i(245762);
        aa.this.eE("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
        AppMethodBeat.o(245762);
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
        AppMethodBeat.i(245767);
        if (this.YuN)
        {
          paramb.eE("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2);
          AppMethodBeat.o(245767);
          return;
        }
        paramb.eE("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")");
        AppMethodBeat.o(245767);
      }
    });
    AppMethodBeat.o(103165);
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
      public final void eE(String paramAnonymousString)
      {
        AppMethodBeat.i(245761);
        aa.this.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(245761);
      }
    }, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(103164);
  }
  
  public static final String aUC(String paramString)
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
  
  public static void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(103159);
    a(paramContext, paramString1, "", paramString2, paramBoolean);
    AppMethodBeat.o(103159);
  }
  
  public static void b(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103163);
    a(paramWebView, paramString1, paramString2, true);
    AppMethodBeat.o(103163);
  }
  
  public static String bkc(String paramString)
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
  
  public static boolean brR(String paramString)
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
  
  public static final String brS(String paramString)
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
  
  public static String brT(String paramString)
  {
    AppMethodBeat.i(103172);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103172);
      return null;
    }
    if (!YuG.matcher(paramString).matches())
    {
      AppMethodBeat.o(103172);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(103172);
    return paramString;
  }
  
  public static String brU(String paramString)
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
  
  public static String brV(String paramString)
  {
    AppMethodBeat.i(245639);
    paramString = String.format("preverify://url=%s", new Object[] { URLEncoder.encode(bkc(Util.nullAsNil(paramString))) });
    AppMethodBeat.o(245639);
    return paramString;
  }
  
  public static String brW(String paramString)
  {
    AppMethodBeat.i(184503);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (aw.isDarkMode())
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
  
  public static boolean brX(String paramString)
  {
    AppMethodBeat.i(245661);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(245661);
      return false;
    }
    try
    {
      boolean bool = new URL(paramString).getHost().equals(WeChatHosts.domainString(a.e.host_mp_weixin_qq_com));
      if (!bool)
      {
        AppMethodBeat.o(245661);
        return false;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebViewUtil", "create url fail : " + paramString.getLocalizedMessage());
      AppMethodBeat.o(245661);
      return false;
    }
    AppMethodBeat.o(245661);
    return true;
  }
  
  @Deprecated
  public static String cN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103155);
    paramContext = r.a(paramContext, paramString, (r.a)com.tencent.luggage.a.e.T(r.a.class));
    AppMethodBeat.o(103155);
    return paramContext;
  }
  
  public static final String cx(Map<String, Object> paramMap)
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
  
  public static void e(WebView paramWebView)
  {
    AppMethodBeat.i(103161);
    if (paramWebView == null)
    {
      AppMethodBeat.o(103161);
      return;
    }
    a(new b()
    {
      public final void eE(String paramAnonymousString)
      {
        AppMethodBeat.i(245765);
        aa.this.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(245765);
      }
    });
    AppMethodBeat.o(103161);
  }
  
  public static String fTX()
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
    paramContext = b.getPackageInfo(paramContext, paramString);
    AppMethodBeat.o(103158);
    return paramContext;
  }
  
  public static boolean iOK()
  {
    return true;
  }
  
  public static boolean iOL()
  {
    AppMethodBeat.i(245650);
    if (YuH != -1)
    {
      if (YuH == 1)
      {
        AppMethodBeat.o(245650);
        return true;
      }
      AppMethodBeat.o(245650);
      return false;
    }
    YuH = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yMR, 1);
    Log.i("MicroMsg.WebViewUtil", "updateRandomStr updateRandomStr=%d", new Object[] { Integer.valueOf(YuH) });
    if (YuH == 1)
    {
      AppMethodBeat.o(245650);
      return true;
    }
    AppMethodBeat.o(245650);
    return false;
  }
  
  public static boolean iOM()
  {
    AppMethodBeat.i(245656);
    if (YuI != -1)
    {
      if (YuI == 1)
      {
        AppMethodBeat.o(245656);
        return true;
      }
      AppMethodBeat.o(245656);
      return false;
    }
    if ((BuildInfo.IS_FLAVOR_RED) || ((WeChatEnvironment.hasDebugger()) && (1 > Log.getLogLevel())))
    {
      AppMethodBeat.o(245656);
      return true;
    }
    YuI = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yNb, 0);
    Log.i("MicroMsg.WebViewUtil", "mpVideoShareToSns open=%d", new Object[] { Integer.valueOf(YuI) });
    if (YuI == 1)
    {
      AppMethodBeat.o(245656);
      return true;
    }
    AppMethodBeat.o(245656);
    return false;
  }
  
  public static String pt(String paramString1, String paramString2)
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
    public abstract void acA(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void eE(String paramString);
  }
  
  static final class c
    implements QueueWorkerThread.ThreadObject
  {
    private static Pattern YuP;
    private static Pattern YuQ;
    private String YuR;
    private String YuS;
    private aa.a YuT;
    private boolean YuU;
    private Context context;
    private String imagePath;
    private String imageUrl;
    private int opType;
    private w psR;
    private String sML;
    private boolean wQm;
    
    static
    {
      AppMethodBeat.i(103154);
      YuP = Pattern.compile("image/[A-Za-z0-9]+");
      YuQ = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
      AppMethodBeat.o(103154);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this(paramContext, paramString1, paramString2, paramString3, paramBoolean, 0, null);
    }
    
    public c(final Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, aa.a parama)
    {
      AppMethodBeat.i(245796);
      this.YuU = false;
      this.context = paramContext;
      this.imageUrl = paramString1;
      this.sML = paramString2;
      this.YuS = paramString3;
      this.wQm = paramBoolean;
      this.opType = paramInt;
      this.YuT = parama;
      Log.d("MicroMsg.WebViewUtil", "LoadImageThreadObject startLoad");
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245647);
          Log.d("MicroMsg.WebViewUtil", "LoadImageThreadObject check show loading");
          if (!aa.c.a(aa.c.this))
          {
            aa.c localc = aa.c.this;
            com.tencent.mm.plugin.webview.k.e locale = com.tencent.mm.plugin.webview.k.e.XsJ;
            aa.c.a(localc, com.tencent.mm.plugin.webview.k.e.a(paramContext.getString(a.e.app_waiting), paramContext, aa.c.b(aa.c.this)));
          }
          AppMethodBeat.o(245647);
        }
      }, 1000L);
      AppMethodBeat.o(245796);
    }
    
    private String Ol(String paramString)
    {
      AppMethodBeat.i(245798);
      this.imagePath = (t.getSysCameraDirPath() + String.format(Locale.US, "mmexport%s_%d.%s", new Object[] { MD5Util.getMD5String(this.imageUrl), Long.valueOf(System.currentTimeMillis()), paramString }));
      paramString = this.imagePath;
      AppMethodBeat.o(245798);
      return paramString;
    }
    
    private void a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      AppMethodBeat.i(177338);
      Log.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[] { paramString1, paramString2 });
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString1 = YuP.matcher(paramString1);
        localObject1 = localObject2;
        if (paramString1.find()) {
          localObject1 = paramString1.group().substring(paramString1.group().lastIndexOf('/') + 1);
        }
      }
      paramString1 = (String)localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        paramString1 = (String)localObject1;
        if (!Util.isNullOrNil(paramString2))
        {
          paramString2 = YuQ.matcher(paramString2);
          paramString1 = (String)localObject1;
          if (paramString2.find()) {
            paramString1 = paramString2.group().substring(paramString2.group().lastIndexOf('.') + 1);
          }
        }
      }
      paramString2 = paramString1;
      int i;
      if (Util.isNullOrNil(paramString1))
      {
        paramString1 = new y(this.imageUrl);
        i = paramString1.mPath.lastIndexOf('.');
        if (i != -1) {
          break label224;
        }
      }
      label224:
      for (paramString2 = "jpg";; paramString2 = paramString1.mPath.substring(i + 1))
      {
        this.imagePath = Ol(paramString2);
        paramString1 = com.tencent.mm.vfs.y.ev(this.imagePath, false);
        paramString2 = new byte[8192];
        for (;;)
        {
          i = paramInputStream.read(paramString2);
          if (i == -1) {
            break;
          }
          paramString1.write(paramString2, 0, i);
        }
      }
      try
      {
        paramString1.flush();
        paramString1.close();
        if (this.opType == 0)
        {
          this.YuR = this.context.getString(a.e.cropimage_saved, new Object[] { t.getToastSysCameraPath() });
          t.refreshMediaScanner(this.imagePath, this.context);
        }
        AppMethodBeat.o(177338);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[] { paramString1.getMessage() });
        }
      }
    }
    
    private static void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
    {
      AppMethodBeat.i(184502);
      if (paramHttpURLConnection != null) {}
      try
      {
        paramHttpURLConnection.getInputStream().close();
        paramHttpURLConnection.disconnect();
        if (paramInputStream == null) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            paramInputStream.close();
            AppMethodBeat.o(184502);
            return;
          }
          catch (Exception paramHttpURLConnection)
          {
            Log.printErrStackTrace("MicroMsg.WebViewUtil", paramHttpURLConnection, "", new Object[0]);
          }
          localException = localException;
          Log.e("MicroMsg.WebViewUtil", localException.getMessage());
        }
        AppMethodBeat.o(184502);
      }
    }
    
    /* Error */
    private void iOO()
    {
      // Byte code:
      //   0: ldc_w 289
      //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: new 291	java/net/URL
      //   9: dup
      //   10: aload_0
      //   11: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   14: invokespecial 292	java/net/URL:<init>	(Ljava/lang/String;)V
      //   17: invokevirtual 296	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   20: checkcast 268	java/net/HttpURLConnection
      //   23: astore_2
      //   24: aload_2
      //   25: ldc_w 298
      //   28: invokevirtual 301	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   31: aload_2
      //   32: ldc_w 303
      //   35: aload_0
      //   36: getfield 76	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuS	Ljava/lang/String;
      //   39: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   42: aload_2
      //   43: ldc_w 308
      //   46: aload_0
      //   47: getfield 74	com/tencent/mm/pluginsdk/ui/tools/aa$c:sML	Ljava/lang/String;
      //   50: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   53: aload_2
      //   54: iconst_1
      //   55: invokevirtual 312	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
      //   58: aload_2
      //   59: invokevirtual 316	java/net/HttpURLConnection:getResponseCode	()I
      //   62: istore_1
      //   63: iload_1
      //   64: sipush 200
      //   67: if_icmpeq +112 -> 179
      //   70: iload_1
      //   71: sipush 301
      //   74: if_icmpeq +10 -> 84
      //   77: iload_1
      //   78: sipush 302
      //   81: if_icmpne +72 -> 153
      //   84: aload_2
      //   85: ldc_w 318
      //   88: invokevirtual 321	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   91: astore 4
      //   93: aload 4
      //   95: astore_3
      //   96: aload 4
      //   98: ifnonnull +11 -> 109
      //   101: aload_2
      //   102: ldc_w 323
      //   105: invokevirtual 321	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   108: astore_3
      //   109: ldc 84
      //   111: ldc_w 325
      //   114: iconst_1
      //   115: anewarray 4	java/lang/Object
      //   118: dup
      //   119: iconst_0
      //   120: aload_3
      //   121: aastore
      //   122: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   125: aload_3
      //   126: invokestatic 179	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   129: ifne +24 -> 153
      //   132: aload_0
      //   133: aload_3
      //   134: putfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   137: aload_0
      //   138: invokespecial 327	com/tencent/mm/pluginsdk/ui/tools/aa$c:iOO	()V
      //   141: aload_2
      //   142: aconst_null
      //   143: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   146: ldc_w 289
      //   149: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   152: return
      //   153: aload_0
      //   154: aload_0
      //   155: getfield 70	com/tencent/mm/pluginsdk/ui/tools/aa$c:context	Landroid/content/Context;
      //   158: getstatic 332	com/tencent/mm/plugin/ba/a$e:wv_save_image_error	I
      //   161: invokevirtual 334	android/content/Context:getString	(I)Ljava/lang/String;
      //   164: putfield 252	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuR	Ljava/lang/String;
      //   167: aload_2
      //   168: aconst_null
      //   169: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   172: ldc_w 289
      //   175: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   178: return
      //   179: aload_2
      //   180: invokevirtual 337	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   183: astore 4
      //   185: aload_2
      //   186: invokevirtual 272	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   189: astore_3
      //   190: aload_0
      //   191: aload 4
      //   193: aload_2
      //   194: ldc_w 339
      //   197: invokevirtual 321	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   200: aload_3
      //   201: invokespecial 341	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   204: aload_2
      //   205: aload_3
      //   206: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   209: ldc_w 289
      //   212: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   215: return
      //   216: astore 4
      //   218: aconst_null
      //   219: astore_2
      //   220: aconst_null
      //   221: astore_3
      //   222: ldc 84
      //   224: ldc_w 343
      //   227: iconst_1
      //   228: anewarray 4	java/lang/Object
      //   231: dup
      //   232: iconst_0
      //   233: aload 4
      //   235: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   238: aastore
      //   239: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   242: aload_3
      //   243: aload_2
      //   244: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   247: ldc_w 289
      //   250: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   253: return
      //   254: astore 4
      //   256: aconst_null
      //   257: astore_2
      //   258: aconst_null
      //   259: astore_3
      //   260: aload_3
      //   261: aload_2
      //   262: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   265: ldc_w 289
      //   268: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   271: aload 4
      //   273: athrow
      //   274: astore 4
      //   276: aconst_null
      //   277: astore 5
      //   279: aload_2
      //   280: astore_3
      //   281: aload 5
      //   283: astore_2
      //   284: goto -24 -> 260
      //   287: astore 4
      //   289: aload_2
      //   290: astore 5
      //   292: aload_3
      //   293: astore_2
      //   294: aload 5
      //   296: astore_3
      //   297: goto -37 -> 260
      //   300: astore 4
      //   302: goto -42 -> 260
      //   305: astore 4
      //   307: aconst_null
      //   308: astore 5
      //   310: aload_2
      //   311: astore_3
      //   312: aload 5
      //   314: astore_2
      //   315: goto -93 -> 222
      //   318: astore 4
      //   320: aload_2
      //   321: astore 5
      //   323: aload_3
      //   324: astore_2
      //   325: aload 5
      //   327: astore_3
      //   328: goto -106 -> 222
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	331	0	this	c
      //   62	20	1	i	int
      //   23	302	2	localObject1	Object
      //   95	233	3	localObject2	Object
      //   91	101	4	str	String
      //   216	18	4	localException1	Exception
      //   254	18	4	localObject3	Object
      //   274	1	4	localObject4	Object
      //   287	1	4	localObject5	Object
      //   300	1	4	localObject6	Object
      //   305	1	4	localException2	Exception
      //   318	1	4	localException3	Exception
      //   277	49	5	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   6	24	216	java/lang/Exception
      //   6	24	254	finally
      //   24	63	274	finally
      //   84	93	274	finally
      //   101	109	274	finally
      //   109	141	274	finally
      //   153	167	274	finally
      //   179	190	274	finally
      //   190	204	287	finally
      //   222	242	300	finally
      //   24	63	305	java/lang/Exception
      //   84	93	305	java/lang/Exception
      //   101	109	305	java/lang/Exception
      //   109	141	305	java/lang/Exception
      //   153	167	305	java/lang/Exception
      //   179	190	305	java/lang/Exception
      //   190	204	318	java/lang/Exception
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: ldc_w 345
      //   9: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   12: aload_0
      //   13: getfield 78	com/tencent/mm/pluginsdk/ui/tools/aa$c:wQm	Z
      //   16: ifne +25 -> 41
      //   19: aload_0
      //   20: aload_0
      //   21: getfield 70	com/tencent/mm/pluginsdk/ui/tools/aa$c:context	Landroid/content/Context;
      //   24: getstatic 348	com/tencent/mm/plugin/ba/a$e:wv_save_image_error_nosdcard	I
      //   27: invokevirtual 334	android/content/Context:getString	(I)Ljava/lang/String;
      //   30: putfield 252	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuR	Ljava/lang/String;
      //   33: ldc_w 345
      //   36: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   39: iconst_1
      //   40: ireturn
      //   41: aload_0
      //   42: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   45: invokestatic 179	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   48: ifeq +11 -> 59
      //   51: ldc_w 345
      //   54: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: iconst_0
      //   58: ireturn
      //   59: aload_0
      //   60: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   63: invokestatic 353	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
      //   66: ifeq +358 -> 424
      //   69: ldc 210
      //   71: astore_2
      //   72: aload_0
      //   73: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   76: invokestatic 179	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   79: ifne +16 -> 95
      //   82: aload_0
      //   83: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   86: ldc_w 355
      //   89: invokevirtual 358	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   92: ifne +19 -> 111
      //   95: aload_0
      //   96: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   99: ldc_w 355
      //   102: invokevirtual 361	java/lang/String:toUpperCase	()Ljava/lang/String;
      //   105: invokevirtual 358	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   108: ifeq +7 -> 115
      //   111: ldc_w 363
      //   114: astore_2
      //   115: aload_0
      //   116: aload_0
      //   117: aload_2
      //   118: invokespecial 212	com/tencent/mm/pluginsdk/ui/tools/aa$c:Ol	(Ljava/lang/String;)Ljava/lang/String;
      //   121: putfield 160	com/tencent/mm/pluginsdk/ui/tools/aa$c:imagePath	Ljava/lang/String;
      //   124: aload 4
      //   126: astore_3
      //   127: aload 5
      //   129: astore_2
      //   130: aload_0
      //   131: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   134: ldc_w 365
      //   137: invokevirtual 369	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   140: istore_1
      //   141: iload_1
      //   142: ifle +24 -> 166
      //   145: aload 4
      //   147: astore_3
      //   148: aload 5
      //   150: astore_2
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   156: iload_1
      //   157: bipush 7
      //   159: iadd
      //   160: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
      //   163: putfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   166: aload 4
      //   168: astore_3
      //   169: aload 5
      //   171: astore_2
      //   172: aload_0
      //   173: getfield 160	com/tencent/mm/pluginsdk/ui/tools/aa$c:imagePath	Ljava/lang/String;
      //   176: iconst_0
      //   177: invokestatic 218	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   180: astore 4
      //   182: aload 4
      //   184: astore_3
      //   185: aload 4
      //   187: astore_2
      //   188: aload_0
      //   189: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   192: iconst_0
      //   193: invokestatic 375	android/util/Base64:decode	(Ljava/lang/String;I)[B
      //   196: astore 5
      //   198: aload 5
      //   200: ifnull +16 -> 216
      //   203: aload 4
      //   205: astore_3
      //   206: aload 4
      //   208: astore_2
      //   209: aload 4
      //   211: aload 5
      //   213: invokevirtual 378	java/io/OutputStream:write	([B)V
      //   216: aload 4
      //   218: astore_3
      //   219: aload 4
      //   221: astore_2
      //   222: aload 4
      //   224: invokevirtual 233	java/io/OutputStream:flush	()V
      //   227: aload 4
      //   229: astore_3
      //   230: aload 4
      //   232: astore_2
      //   233: aload 4
      //   235: invokevirtual 236	java/io/OutputStream:close	()V
      //   238: aload 4
      //   240: astore_3
      //   241: aload 4
      //   243: astore_2
      //   244: aload_0
      //   245: aload_0
      //   246: getfield 70	com/tencent/mm/pluginsdk/ui/tools/aa$c:context	Landroid/content/Context;
      //   249: getstatic 241	com/tencent/mm/plugin/ba/a$e:cropimage_saved	I
      //   252: iconst_1
      //   253: anewarray 4	java/lang/Object
      //   256: dup
      //   257: iconst_0
      //   258: invokestatic 244	com/tencent/mm/pluginsdk/ui/tools/t:getToastSysCameraPath	()Ljava/lang/String;
      //   261: aastore
      //   262: invokevirtual 250	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
      //   265: putfield 252	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuR	Ljava/lang/String;
      //   268: aload 4
      //   270: astore_3
      //   271: aload 4
      //   273: astore_2
      //   274: aload_0
      //   275: getfield 160	com/tencent/mm/pluginsdk/ui/tools/aa$c:imagePath	Ljava/lang/String;
      //   278: aload_0
      //   279: getfield 70	com/tencent/mm/pluginsdk/ui/tools/aa$c:context	Landroid/content/Context;
      //   282: invokestatic 256	com/tencent/mm/pluginsdk/ui/tools/t:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
      //   285: aload 4
      //   287: ifnull +8 -> 295
      //   290: aload 4
      //   292: invokevirtual 236	java/io/OutputStream:close	()V
      //   295: ldc_w 345
      //   298: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   301: iconst_1
      //   302: ireturn
      //   303: astore_2
      //   304: ldc 84
      //   306: ldc_w 380
      //   309: iconst_1
      //   310: anewarray 4	java/lang/Object
      //   313: dup
      //   314: iconst_0
      //   315: aload_2
      //   316: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   319: aastore
      //   320: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   323: goto -28 -> 295
      //   326: astore 4
      //   328: aload_3
      //   329: astore_2
      //   330: ldc 84
      //   332: ldc_w 382
      //   335: iconst_1
      //   336: anewarray 4	java/lang/Object
      //   339: dup
      //   340: iconst_0
      //   341: aload 4
      //   343: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   346: aastore
      //   347: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   350: aload_3
      //   351: ifnull -56 -> 295
      //   354: aload_3
      //   355: invokevirtual 236	java/io/OutputStream:close	()V
      //   358: goto -63 -> 295
      //   361: astore_2
      //   362: ldc 84
      //   364: ldc_w 380
      //   367: iconst_1
      //   368: anewarray 4	java/lang/Object
      //   371: dup
      //   372: iconst_0
      //   373: aload_2
      //   374: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   377: aastore
      //   378: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   381: goto -86 -> 295
      //   384: astore_3
      //   385: aload_2
      //   386: ifnull +7 -> 393
      //   389: aload_2
      //   390: invokevirtual 236	java/io/OutputStream:close	()V
      //   393: ldc_w 345
      //   396: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   399: aload_3
      //   400: athrow
      //   401: astore_2
      //   402: ldc 84
      //   404: ldc_w 380
      //   407: iconst_1
      //   408: anewarray 4	java/lang/Object
      //   411: dup
      //   412: iconst_0
      //   413: aload_2
      //   414: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   417: aastore
      //   418: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   421: goto -28 -> 393
      //   424: aload_0
      //   425: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   428: invokestatic 385	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   431: ifeq +255 -> 686
      //   434: new 291	java/net/URL
      //   437: dup
      //   438: aload_0
      //   439: getfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   442: invokespecial 292	java/net/URL:<init>	(Ljava/lang/String;)V
      //   445: invokevirtual 296	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   448: checkcast 387	javax/net/ssl/HttpsURLConnection
      //   451: astore_2
      //   452: aload_2
      //   453: ldc_w 298
      //   456: invokevirtual 388	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   459: aload_2
      //   460: ldc_w 303
      //   463: aload_0
      //   464: getfield 76	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuS	Ljava/lang/String;
      //   467: invokevirtual 389	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   470: aload_2
      //   471: ldc_w 308
      //   474: aload_0
      //   475: getfield 74	com/tencent/mm/pluginsdk/ui/tools/aa$c:sML	Ljava/lang/String;
      //   478: invokevirtual 389	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   481: aload_2
      //   482: iconst_1
      //   483: invokevirtual 390	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
      //   486: aload_2
      //   487: invokevirtual 391	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   490: istore_1
      //   491: iload_1
      //   492: sipush 200
      //   495: if_icmpeq +104 -> 599
      //   498: iload_1
      //   499: sipush 301
      //   502: if_icmpeq +10 -> 512
      //   505: iload_1
      //   506: sipush 302
      //   509: if_icmpne +68 -> 577
      //   512: aload_2
      //   513: ldc_w 318
      //   516: invokevirtual 392	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   519: astore 4
      //   521: aload 4
      //   523: astore_3
      //   524: aload 4
      //   526: ifnonnull +11 -> 537
      //   529: aload_2
      //   530: ldc_w 323
      //   533: invokevirtual 392	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   536: astore_3
      //   537: ldc 84
      //   539: ldc_w 325
      //   542: iconst_1
      //   543: anewarray 4	java/lang/Object
      //   546: dup
      //   547: iconst_0
      //   548: aload_3
      //   549: aastore
      //   550: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   553: aload_3
      //   554: invokestatic 179	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   557: ifne +20 -> 577
      //   560: aload_0
      //   561: aload_3
      //   562: putfield 72	com/tencent/mm/pluginsdk/ui/tools/aa$c:imageUrl	Ljava/lang/String;
      //   565: aload_0
      //   566: invokespecial 327	com/tencent/mm/pluginsdk/ui/tools/aa$c:iOO	()V
      //   569: aload_2
      //   570: aconst_null
      //   571: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   574: goto -279 -> 295
      //   577: aload_0
      //   578: aload_0
      //   579: getfield 70	com/tencent/mm/pluginsdk/ui/tools/aa$c:context	Landroid/content/Context;
      //   582: getstatic 332	com/tencent/mm/plugin/ba/a$e:wv_save_image_error	I
      //   585: invokevirtual 334	android/content/Context:getString	(I)Ljava/lang/String;
      //   588: putfield 252	com/tencent/mm/pluginsdk/ui/tools/aa$c:YuR	Ljava/lang/String;
      //   591: aload_2
      //   592: aconst_null
      //   593: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   596: goto -301 -> 295
      //   599: aload_2
      //   600: invokevirtual 393	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   603: astore 4
      //   605: aload_2
      //   606: invokevirtual 394	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   609: astore_3
      //   610: aload_0
      //   611: aload 4
      //   613: aload_2
      //   614: ldc_w 339
      //   617: invokevirtual 392	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   620: aload_3
      //   621: invokespecial 341	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   624: aload_2
      //   625: aload_3
      //   626: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   629: goto -334 -> 295
      //   632: astore 4
      //   634: aconst_null
      //   635: astore_2
      //   636: aconst_null
      //   637: astore_3
      //   638: ldc 84
      //   640: ldc_w 396
      //   643: iconst_1
      //   644: anewarray 4	java/lang/Object
      //   647: dup
      //   648: iconst_0
      //   649: aload 4
      //   651: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   654: aastore
      //   655: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   658: aload_3
      //   659: aload_2
      //   660: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   663: goto -368 -> 295
      //   666: astore 4
      //   668: aconst_null
      //   669: astore_2
      //   670: aconst_null
      //   671: astore_3
      //   672: aload_3
      //   673: aload_2
      //   674: invokestatic 329	com/tencent/mm/pluginsdk/ui/tools/aa$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   677: ldc_w 345
      //   680: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   683: aload 4
      //   685: athrow
      //   686: aload_0
      //   687: invokespecial 327	com/tencent/mm/pluginsdk/ui/tools/aa$c:iOO	()V
      //   690: goto -395 -> 295
      //   693: astore 4
      //   695: aconst_null
      //   696: astore 5
      //   698: aload_2
      //   699: astore_3
      //   700: aload 5
      //   702: astore_2
      //   703: goto -31 -> 672
      //   706: astore 4
      //   708: aload_2
      //   709: astore 5
      //   711: aload_3
      //   712: astore_2
      //   713: aload 5
      //   715: astore_3
      //   716: goto -44 -> 672
      //   719: astore 4
      //   721: goto -49 -> 672
      //   724: astore 4
      //   726: aconst_null
      //   727: astore 5
      //   729: aload_2
      //   730: astore_3
      //   731: aload 5
      //   733: astore_2
      //   734: goto -96 -> 638
      //   737: astore 4
      //   739: aload_2
      //   740: astore 5
      //   742: aload_3
      //   743: astore_2
      //   744: aload 5
      //   746: astore_3
      //   747: goto -109 -> 638
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	750	0	this	c
      //   140	370	1	i	int
      //   71	203	2	localObject1	Object
      //   303	13	2	localException1	Exception
      //   329	1	2	localObject2	Object
      //   361	29	2	localException2	Exception
      //   401	13	2	localException3	Exception
      //   451	293	2	localObject3	Object
      //   126	229	3	localOutputStream1	OutputStream
      //   384	16	3	localObject4	Object
      //   523	224	3	localObject5	Object
      //   4	287	4	localOutputStream2	OutputStream
      //   326	16	4	localException4	Exception
      //   519	93	4	str	String
      //   632	18	4	localException5	Exception
      //   666	18	4	localObject6	Object
      //   693	1	4	localObject7	Object
      //   706	1	4	localObject8	Object
      //   719	1	4	localObject9	Object
      //   724	1	4	localException6	Exception
      //   737	1	4	localException7	Exception
      //   1	744	5	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   290	295	303	java/lang/Exception
      //   130	141	326	java/lang/Exception
      //   151	166	326	java/lang/Exception
      //   172	182	326	java/lang/Exception
      //   188	198	326	java/lang/Exception
      //   209	216	326	java/lang/Exception
      //   222	227	326	java/lang/Exception
      //   233	238	326	java/lang/Exception
      //   244	268	326	java/lang/Exception
      //   274	285	326	java/lang/Exception
      //   354	358	361	java/lang/Exception
      //   130	141	384	finally
      //   151	166	384	finally
      //   172	182	384	finally
      //   188	198	384	finally
      //   209	216	384	finally
      //   222	227	384	finally
      //   233	238	384	finally
      //   244	268	384	finally
      //   274	285	384	finally
      //   330	350	384	finally
      //   389	393	401	java/lang/Exception
      //   434	452	632	java/lang/Exception
      //   434	452	666	finally
      //   452	491	693	finally
      //   512	521	693	finally
      //   529	537	693	finally
      //   537	569	693	finally
      //   577	591	693	finally
      //   599	610	693	finally
      //   610	624	706	finally
      //   638	658	719	finally
      //   452	491	724	java/lang/Exception
      //   512	521	724	java/lang/Exception
      //   529	537	724	java/lang/Exception
      //   537	569	724	java/lang/Exception
      //   577	591	724	java/lang/Exception
      //   599	610	724	java/lang/Exception
      //   610	624	737	java/lang/Exception
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(103149);
      this.YuU = true;
      com.tencent.mm.plugin.webview.k.e locale = com.tencent.mm.plugin.webview.k.e.XsJ;
      com.tencent.mm.plugin.webview.k.e.d(this.psR);
      if (1 == this.opType) {
        this.YuT.acA(this.imagePath);
      }
      for (;;)
      {
        AppMethodBeat.o(103149);
        return true;
        if (!Util.isNullOrNil(this.YuR)) {
          Toast.makeText(this.context, this.YuR, 1).show();
        } else {
          Toast.makeText(this.context, this.context.getString(a.e.wv_save_image_error), 1).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.aa
 * JD-Core Version:    0.7.0.1
 */