package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.k.d;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
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

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class ab
{
  private static p.a Ryj;
  private static final Pattern Ryk;
  private static int Ryl;
  private static int Rym;
  private static QueueWorkerThread mEx;
  
  static
  {
    AppMethodBeat.i(103177);
    Ryj = null;
    mEx = null;
    Ryk = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    Ryl = -1;
    Rym = -1;
    AppMethodBeat.o(103177);
  }
  
  public static boolean J(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103157);
    boolean bool = l.J(paramString1, paramString2);
    AppMethodBeat.o(103157);
    return bool;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(103160);
    if (mEx == null) {
      mEx = new QueueWorkerThread(1, "webview-save-image", 1);
    }
    mEx.add(new c(paramContext, paramString1, paramString2, paramBoolean, 1, parama));
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
        AppMethodBeat.i(205267);
        this.Ryq.dt("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
        AppMethodBeat.o(205267);
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
        AppMethodBeat.i(205840);
        if (this.Ryr)
        {
          paramb.dt("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2);
          AppMethodBeat.o(205840);
          return;
        }
        paramb.dt("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")");
        AppMethodBeat.o(205840);
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
      public final void dt(String paramAnonymousString)
      {
        AppMethodBeat.i(206006);
        this.Ryp.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(206006);
      }
    }, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(103164);
  }
  
  public static final String aXb(String paramString)
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
  
  public static void b(Context paramContext, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(103159);
    com.tencent.mm.platformtools.p.a(paramContext, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(206860);
        if (ab.hnV() == null) {
          ab.a(new QueueWorkerThread(1, "webview-save-image", 1));
        }
        ab.hnV().add(new ab.c(this.val$context, paramString1, paramString2, paramBoolean));
        AppMethodBeat.o(206860);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206808);
        Toast.makeText(this.val$context, this.val$context.getString(a.a.wv_save_image_error), 1).show();
        AppMethodBeat.o(206808);
      }
    });
    AppMethodBeat.o(103159);
  }
  
  public static void b(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103163);
    a(paramWebView, paramString1, paramString2, true);
    AppMethodBeat.o(103163);
  }
  
  public static final String bZ(Map<String, Object> paramMap)
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
  
  public static String bks(String paramString)
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
  
  public static boolean bsa(String paramString)
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
  
  public static final String bsb(String paramString)
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
  
  public static String bsc(String paramString)
  {
    AppMethodBeat.i(103172);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103172);
      return null;
    }
    if (!Ryk.matcher(paramString).matches())
    {
      AppMethodBeat.o(103172);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(103172);
    return paramString;
  }
  
  public static String bsd(String paramString)
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
  
  public static String bse(String paramString)
  {
    AppMethodBeat.i(215712);
    paramString = String.format("preverify://url=%s", new Object[] { URLEncoder.encode(bks(Util.nullAsNil(paramString))) });
    AppMethodBeat.o(215712);
    return paramString;
  }
  
  public static String bsf(String paramString)
  {
    AppMethodBeat.i(184503);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (ar.isDarkMode())
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
  
  public static boolean bsg(String paramString)
  {
    AppMethodBeat.i(215718);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(215718);
      return false;
    }
    try
    {
      boolean bool = new URL(paramString).getHost().equals(WeChatHosts.domainString(a.a.host_mp_weixin_qq_com));
      if (!bool)
      {
        AppMethodBeat.o(215718);
        return false;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebViewUtil", "create url fail : " + paramString.getLocalizedMessage());
      AppMethodBeat.o(215718);
      return false;
    }
    AppMethodBeat.o(215718);
    return true;
  }
  
  @Deprecated
  public static String cC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103155);
    paramContext = com.tencent.mm.plugin.appbrand.ac.p.a(paramContext, paramString, (p.a)e.K(p.a.class));
    AppMethodBeat.o(103155);
    return paramContext;
  }
  
  public static void d(WebView paramWebView)
  {
    AppMethodBeat.i(103161);
    if (paramWebView == null)
    {
      AppMethodBeat.o(103161);
      return;
    }
    a(new b()
    {
      public final void dt(String paramAnonymousString)
      {
        AppMethodBeat.i(206781);
        this.Ryp.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(206781);
      }
    });
    AppMethodBeat.o(103161);
  }
  
  public static String gVU()
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
  
  public static boolean hnS()
  {
    return true;
  }
  
  public static boolean hnT()
  {
    AppMethodBeat.i(215716);
    if (Ryl != -1)
    {
      if (Ryl == 1)
      {
        AppMethodBeat.o(215716);
        return true;
      }
      AppMethodBeat.o(215716);
      return false;
    }
    Ryl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzm, 1);
    Log.i("MicroMsg.WebViewUtil", "updateRandomStr updateRandomStr=%d", new Object[] { Integer.valueOf(Ryl) });
    if (Ryl == 1)
    {
      AppMethodBeat.o(215716);
      return true;
    }
    AppMethodBeat.o(215716);
    return false;
  }
  
  public static boolean hnU()
  {
    AppMethodBeat.i(215717);
    if (Rym != -1)
    {
      if (Rym == 1)
      {
        AppMethodBeat.o(215717);
        return true;
      }
      AppMethodBeat.o(215717);
      return false;
    }
    if ((BuildInfo.IS_FLAVOR_RED) || ((WeChatEnvironment.hasDebugger()) && (1 > Log.getLogLevel())))
    {
      AppMethodBeat.o(215717);
      return true;
    }
    Rym = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzw, 0);
    Log.i("MicroMsg.WebViewUtil", "mpVideoShareToSns open=%d", new Object[] { Integer.valueOf(Rym) });
    if (Rym == 1)
    {
      AppMethodBeat.o(215717);
      return true;
    }
    AppMethodBeat.o(215717);
    return false;
  }
  
  public static String nx(String paramString1, String paramString2)
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
    public abstract void ajz(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void dt(String paramString);
  }
  
  static final class c
    implements QueueWorkerThread.ThreadObject
  {
    private static Pattern Ryt;
    private static Pattern Ryu;
    private String Ryv;
    private String Ryw;
    private ab.a Ryx;
    private boolean Ryy;
    private Context context;
    private s iYE;
    private String imagePath;
    private String imageUrl;
    private int opType;
    private boolean tMW;
    
    static
    {
      AppMethodBeat.i(103154);
      Ryt = Pattern.compile("image/[A-Za-z0-9]+");
      Ryu = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
      AppMethodBeat.o(103154);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
    {
      this(paramContext, paramString1, paramString2, paramBoolean, 0, null);
    }
    
    public c(final Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, ab.a parama)
    {
      AppMethodBeat.i(211231);
      this.Ryy = false;
      this.context = paramContext;
      this.imageUrl = paramString1;
      this.Ryw = paramString2;
      this.tMW = paramBoolean;
      this.opType = paramInt;
      this.Ryx = parama;
      Log.d("MicroMsg.WebViewUtil", "LoadImageThreadObject startLoad");
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206713);
          Log.d("MicroMsg.WebViewUtil", "LoadImageThreadObject check show loading");
          if (!ab.c.a(ab.c.this))
          {
            ab.c localc = ab.c.this;
            d locald = d.QzO;
            ab.c.a(localc, d.a(paramContext.getString(a.a.app_waiting), paramContext, ab.c.b(ab.c.this)));
          }
          AppMethodBeat.o(206713);
        }
      }, 1000L);
      AppMethodBeat.o(211231);
    }
    
    private String Wl(String paramString)
    {
      AppMethodBeat.i(211234);
      this.imagePath = (u.getSysCameraDirPath() + String.format(Locale.US, "mmexport%s_%d.%s", new Object[] { MD5Util.getMD5String(this.imageUrl), Long.valueOf(System.currentTimeMillis()), paramString }));
      paramString = this.imagePath;
      AppMethodBeat.o(211234);
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
        paramString1 = Ryt.matcher(paramString1);
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
          paramString2 = Ryu.matcher(paramString2);
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
        paramString1 = new z(this.imageUrl);
        i = paramString1.mPath.lastIndexOf('.');
        if (i != -1) {
          break label223;
        }
      }
      label223:
      for (paramString2 = "jpg";; paramString2 = paramString1.mPath.substring(i + 1))
      {
        this.imagePath = Wl(paramString2);
        paramString1 = com.tencent.mm.vfs.u.Te(this.imagePath);
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
          this.Ryv = this.context.getString(a.a.cropimage_saved, new Object[] { u.getToastSysCameraPath() });
          u.refreshMediaScanner(this.imagePath, this.context);
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
    private void hnW()
    {
      // Byte code:
      //   0: ldc_w 287
      //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: new 289	java/net/URL
      //   9: dup
      //   10: aload_0
      //   11: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   14: invokespecial 290	java/net/URL:<init>	(Ljava/lang/String;)V
      //   17: invokevirtual 294	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   20: checkcast 266	java/net/HttpURLConnection
      //   23: astore_2
      //   24: aload_2
      //   25: ldc_w 296
      //   28: invokevirtual 299	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   31: aload_2
      //   32: ldc_w 301
      //   35: aload_0
      //   36: getfield 73	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryw	Ljava/lang/String;
      //   39: invokevirtual 304	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   42: aload_2
      //   43: iconst_1
      //   44: invokevirtual 308	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
      //   47: aload_2
      //   48: invokevirtual 312	java/net/HttpURLConnection:getResponseCode	()I
      //   51: istore_1
      //   52: iload_1
      //   53: sipush 200
      //   56: if_icmpeq +112 -> 168
      //   59: iload_1
      //   60: sipush 301
      //   63: if_icmpeq +10 -> 73
      //   66: iload_1
      //   67: sipush 302
      //   70: if_icmpne +72 -> 142
      //   73: aload_2
      //   74: ldc_w 314
      //   77: invokevirtual 317	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   80: astore 4
      //   82: aload 4
      //   84: astore_3
      //   85: aload 4
      //   87: ifnonnull +11 -> 98
      //   90: aload_2
      //   91: ldc_w 319
      //   94: invokevirtual 317	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   97: astore_3
      //   98: ldc 81
      //   100: ldc_w 321
      //   103: iconst_1
      //   104: anewarray 4	java/lang/Object
      //   107: dup
      //   108: iconst_0
      //   109: aload_3
      //   110: aastore
      //   111: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   114: aload_3
      //   115: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   118: ifne +24 -> 142
      //   121: aload_0
      //   122: aload_3
      //   123: putfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   126: aload_0
      //   127: invokespecial 323	com/tencent/mm/pluginsdk/ui/tools/ab$c:hnW	()V
      //   130: aload_2
      //   131: aconst_null
      //   132: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   135: ldc_w 287
      //   138: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   141: return
      //   142: aload_0
      //   143: aload_0
      //   144: getfield 69	com/tencent/mm/pluginsdk/ui/tools/ab$c:context	Landroid/content/Context;
      //   147: getstatic 328	com/tencent/mm/plugin/ay/a$a:wv_save_image_error	I
      //   150: invokevirtual 330	android/content/Context:getString	(I)Ljava/lang/String;
      //   153: putfield 250	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryv	Ljava/lang/String;
      //   156: aload_2
      //   157: aconst_null
      //   158: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   161: ldc_w 287
      //   164: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: return
      //   168: aload_2
      //   169: invokevirtual 333	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   172: astore 4
      //   174: aload_2
      //   175: invokevirtual 270	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   178: astore_3
      //   179: aload_0
      //   180: aload 4
      //   182: aload_2
      //   183: ldc_w 335
      //   186: invokevirtual 317	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   189: aload_3
      //   190: invokespecial 337	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   193: aload_2
      //   194: aload_3
      //   195: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   198: ldc_w 287
      //   201: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   204: return
      //   205: astore 4
      //   207: aconst_null
      //   208: astore_2
      //   209: aconst_null
      //   210: astore_3
      //   211: ldc 81
      //   213: ldc_w 339
      //   216: iconst_1
      //   217: anewarray 4	java/lang/Object
      //   220: dup
      //   221: iconst_0
      //   222: aload 4
      //   224: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   227: aastore
      //   228: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   231: aload_3
      //   232: aload_2
      //   233: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   236: ldc_w 287
      //   239: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   242: return
      //   243: astore 4
      //   245: aconst_null
      //   246: astore_2
      //   247: aconst_null
      //   248: astore_3
      //   249: aload_3
      //   250: aload_2
      //   251: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   254: ldc_w 287
      //   257: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: aload 4
      //   262: athrow
      //   263: astore 4
      //   265: aconst_null
      //   266: astore 5
      //   268: aload_2
      //   269: astore_3
      //   270: aload 5
      //   272: astore_2
      //   273: goto -24 -> 249
      //   276: astore 4
      //   278: aload_2
      //   279: astore 5
      //   281: aload_3
      //   282: astore_2
      //   283: aload 5
      //   285: astore_3
      //   286: goto -37 -> 249
      //   289: astore 4
      //   291: goto -42 -> 249
      //   294: astore 4
      //   296: aconst_null
      //   297: astore 5
      //   299: aload_2
      //   300: astore_3
      //   301: aload 5
      //   303: astore_2
      //   304: goto -93 -> 211
      //   307: astore 4
      //   309: aload_2
      //   310: astore 5
      //   312: aload_3
      //   313: astore_2
      //   314: aload 5
      //   316: astore_3
      //   317: goto -106 -> 211
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	320	0	this	c
      //   51	20	1	i	int
      //   23	291	2	localObject1	Object
      //   84	233	3	localObject2	Object
      //   80	101	4	str	String
      //   205	18	4	localException1	Exception
      //   243	18	4	localObject3	Object
      //   263	1	4	localObject4	Object
      //   276	1	4	localObject5	Object
      //   289	1	4	localObject6	Object
      //   294	1	4	localException2	Exception
      //   307	1	4	localException3	Exception
      //   266	49	5	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   6	24	205	java/lang/Exception
      //   6	24	243	finally
      //   24	52	263	finally
      //   73	82	263	finally
      //   90	98	263	finally
      //   98	130	263	finally
      //   142	156	263	finally
      //   168	179	263	finally
      //   179	193	276	finally
      //   211	231	289	finally
      //   24	52	294	java/lang/Exception
      //   73	82	294	java/lang/Exception
      //   90	98	294	java/lang/Exception
      //   98	130	294	java/lang/Exception
      //   142	156	294	java/lang/Exception
      //   168	179	294	java/lang/Exception
      //   179	193	307	java/lang/Exception
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: ldc_w 341
      //   9: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   12: aload_0
      //   13: getfield 75	com/tencent/mm/pluginsdk/ui/tools/ab$c:tMW	Z
      //   16: ifne +25 -> 41
      //   19: aload_0
      //   20: aload_0
      //   21: getfield 69	com/tencent/mm/pluginsdk/ui/tools/ab$c:context	Landroid/content/Context;
      //   24: getstatic 344	com/tencent/mm/plugin/ay/a$a:wv_save_image_error_nosdcard	I
      //   27: invokevirtual 330	android/content/Context:getString	(I)Ljava/lang/String;
      //   30: putfield 250	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryv	Ljava/lang/String;
      //   33: ldc_w 341
      //   36: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   39: iconst_1
      //   40: ireturn
      //   41: aload_0
      //   42: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   45: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   48: ifeq +11 -> 59
      //   51: ldc_w 341
      //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: iconst_0
      //   58: ireturn
      //   59: aload_0
      //   60: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   63: invokestatic 349	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
      //   66: ifeq +357 -> 423
      //   69: ldc 208
      //   71: astore_2
      //   72: aload_0
      //   73: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   76: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   79: ifne +16 -> 95
      //   82: aload_0
      //   83: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   86: ldc_w 351
      //   89: invokevirtual 354	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   92: ifne +19 -> 111
      //   95: aload_0
      //   96: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   99: ldc_w 351
      //   102: invokevirtual 357	java/lang/String:toUpperCase	()Ljava/lang/String;
      //   105: invokevirtual 354	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   108: ifeq +7 -> 115
      //   111: ldc_w 359
      //   114: astore_2
      //   115: aload_0
      //   116: aload_0
      //   117: aload_2
      //   118: invokespecial 210	com/tencent/mm/pluginsdk/ui/tools/ab$c:Wl	(Ljava/lang/String;)Ljava/lang/String;
      //   121: putfield 158	com/tencent/mm/pluginsdk/ui/tools/ab$c:imagePath	Ljava/lang/String;
      //   124: aload 4
      //   126: astore_3
      //   127: aload 5
      //   129: astore_2
      //   130: aload_0
      //   131: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   134: ldc_w 361
      //   137: invokevirtual 365	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   140: istore_1
      //   141: iload_1
      //   142: ifle +24 -> 166
      //   145: aload 4
      //   147: astore_3
      //   148: aload 5
      //   150: astore_2
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   156: iload_1
      //   157: bipush 7
      //   159: iadd
      //   160: invokevirtual 198	java/lang/String:substring	(I)Ljava/lang/String;
      //   163: putfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   166: aload 4
      //   168: astore_3
      //   169: aload 5
      //   171: astore_2
      //   172: aload_0
      //   173: getfield 158	com/tencent/mm/pluginsdk/ui/tools/ab$c:imagePath	Ljava/lang/String;
      //   176: invokestatic 216	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   179: astore 4
      //   181: aload 4
      //   183: astore_3
      //   184: aload 4
      //   186: astore_2
      //   187: aload_0
      //   188: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   191: iconst_0
      //   192: invokestatic 371	android/util/Base64:decode	(Ljava/lang/String;I)[B
      //   195: astore 5
      //   197: aload 5
      //   199: ifnull +16 -> 215
      //   202: aload 4
      //   204: astore_3
      //   205: aload 4
      //   207: astore_2
      //   208: aload 4
      //   210: aload 5
      //   212: invokevirtual 374	java/io/OutputStream:write	([B)V
      //   215: aload 4
      //   217: astore_3
      //   218: aload 4
      //   220: astore_2
      //   221: aload 4
      //   223: invokevirtual 231	java/io/OutputStream:flush	()V
      //   226: aload 4
      //   228: astore_3
      //   229: aload 4
      //   231: astore_2
      //   232: aload 4
      //   234: invokevirtual 234	java/io/OutputStream:close	()V
      //   237: aload 4
      //   239: astore_3
      //   240: aload 4
      //   242: astore_2
      //   243: aload_0
      //   244: aload_0
      //   245: getfield 69	com/tencent/mm/pluginsdk/ui/tools/ab$c:context	Landroid/content/Context;
      //   248: getstatic 239	com/tencent/mm/plugin/ay/a$a:cropimage_saved	I
      //   251: iconst_1
      //   252: anewarray 4	java/lang/Object
      //   255: dup
      //   256: iconst_0
      //   257: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/u:getToastSysCameraPath	()Ljava/lang/String;
      //   260: aastore
      //   261: invokevirtual 248	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
      //   264: putfield 250	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryv	Ljava/lang/String;
      //   267: aload 4
      //   269: astore_3
      //   270: aload 4
      //   272: astore_2
      //   273: aload_0
      //   274: getfield 158	com/tencent/mm/pluginsdk/ui/tools/ab$c:imagePath	Ljava/lang/String;
      //   277: aload_0
      //   278: getfield 69	com/tencent/mm/pluginsdk/ui/tools/ab$c:context	Landroid/content/Context;
      //   281: invokestatic 254	com/tencent/mm/pluginsdk/ui/tools/u:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
      //   284: aload 4
      //   286: ifnull +8 -> 294
      //   289: aload 4
      //   291: invokevirtual 234	java/io/OutputStream:close	()V
      //   294: ldc_w 341
      //   297: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   300: iconst_1
      //   301: ireturn
      //   302: astore_2
      //   303: ldc 81
      //   305: ldc_w 376
      //   308: iconst_1
      //   309: anewarray 4	java/lang/Object
      //   312: dup
      //   313: iconst_0
      //   314: aload_2
      //   315: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   318: aastore
      //   319: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   322: goto -28 -> 294
      //   325: astore 4
      //   327: aload_3
      //   328: astore_2
      //   329: ldc 81
      //   331: ldc_w 378
      //   334: iconst_1
      //   335: anewarray 4	java/lang/Object
      //   338: dup
      //   339: iconst_0
      //   340: aload 4
      //   342: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   345: aastore
      //   346: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   349: aload_3
      //   350: ifnull -56 -> 294
      //   353: aload_3
      //   354: invokevirtual 234	java/io/OutputStream:close	()V
      //   357: goto -63 -> 294
      //   360: astore_2
      //   361: ldc 81
      //   363: ldc_w 376
      //   366: iconst_1
      //   367: anewarray 4	java/lang/Object
      //   370: dup
      //   371: iconst_0
      //   372: aload_2
      //   373: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   376: aastore
      //   377: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   380: goto -86 -> 294
      //   383: astore_3
      //   384: aload_2
      //   385: ifnull +7 -> 392
      //   388: aload_2
      //   389: invokevirtual 234	java/io/OutputStream:close	()V
      //   392: ldc_w 341
      //   395: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   398: aload_3
      //   399: athrow
      //   400: astore_2
      //   401: ldc 81
      //   403: ldc_w 376
      //   406: iconst_1
      //   407: anewarray 4	java/lang/Object
      //   410: dup
      //   411: iconst_0
      //   412: aload_2
      //   413: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   416: aastore
      //   417: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   420: goto -28 -> 392
      //   423: aload_0
      //   424: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   427: invokestatic 381	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   430: ifeq +244 -> 674
      //   433: new 289	java/net/URL
      //   436: dup
      //   437: aload_0
      //   438: getfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   441: invokespecial 290	java/net/URL:<init>	(Ljava/lang/String;)V
      //   444: invokevirtual 294	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   447: checkcast 383	javax/net/ssl/HttpsURLConnection
      //   450: astore_2
      //   451: aload_2
      //   452: ldc_w 296
      //   455: invokevirtual 384	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   458: aload_2
      //   459: ldc_w 301
      //   462: aload_0
      //   463: getfield 73	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryw	Ljava/lang/String;
      //   466: invokevirtual 385	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   469: aload_2
      //   470: iconst_1
      //   471: invokevirtual 386	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
      //   474: aload_2
      //   475: invokevirtual 387	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   478: istore_1
      //   479: iload_1
      //   480: sipush 200
      //   483: if_icmpeq +104 -> 587
      //   486: iload_1
      //   487: sipush 301
      //   490: if_icmpeq +10 -> 500
      //   493: iload_1
      //   494: sipush 302
      //   497: if_icmpne +68 -> 565
      //   500: aload_2
      //   501: ldc_w 314
      //   504: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   507: astore 4
      //   509: aload 4
      //   511: astore_3
      //   512: aload 4
      //   514: ifnonnull +11 -> 525
      //   517: aload_2
      //   518: ldc_w 319
      //   521: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   524: astore_3
      //   525: ldc 81
      //   527: ldc_w 321
      //   530: iconst_1
      //   531: anewarray 4	java/lang/Object
      //   534: dup
      //   535: iconst_0
      //   536: aload_3
      //   537: aastore
      //   538: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   541: aload_3
      //   542: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   545: ifne +20 -> 565
      //   548: aload_0
      //   549: aload_3
      //   550: putfield 71	com/tencent/mm/pluginsdk/ui/tools/ab$c:imageUrl	Ljava/lang/String;
      //   553: aload_0
      //   554: invokespecial 323	com/tencent/mm/pluginsdk/ui/tools/ab$c:hnW	()V
      //   557: aload_2
      //   558: aconst_null
      //   559: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   562: goto -268 -> 294
      //   565: aload_0
      //   566: aload_0
      //   567: getfield 69	com/tencent/mm/pluginsdk/ui/tools/ab$c:context	Landroid/content/Context;
      //   570: getstatic 328	com/tencent/mm/plugin/ay/a$a:wv_save_image_error	I
      //   573: invokevirtual 330	android/content/Context:getString	(I)Ljava/lang/String;
      //   576: putfield 250	com/tencent/mm/pluginsdk/ui/tools/ab$c:Ryv	Ljava/lang/String;
      //   579: aload_2
      //   580: aconst_null
      //   581: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   584: goto -290 -> 294
      //   587: aload_2
      //   588: invokevirtual 389	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   591: astore 4
      //   593: aload_2
      //   594: invokevirtual 390	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   597: astore_3
      //   598: aload_0
      //   599: aload 4
      //   601: aload_2
      //   602: ldc_w 335
      //   605: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   608: aload_3
      //   609: invokespecial 337	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   612: aload_2
      //   613: aload_3
      //   614: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   617: goto -323 -> 294
      //   620: astore 4
      //   622: aconst_null
      //   623: astore_2
      //   624: aconst_null
      //   625: astore_3
      //   626: ldc 81
      //   628: ldc_w 392
      //   631: iconst_1
      //   632: anewarray 4	java/lang/Object
      //   635: dup
      //   636: iconst_0
      //   637: aload 4
      //   639: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   642: aastore
      //   643: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   646: aload_3
      //   647: aload_2
      //   648: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   651: goto -357 -> 294
      //   654: astore 4
      //   656: aconst_null
      //   657: astore_2
      //   658: aconst_null
      //   659: astore_3
      //   660: aload_3
      //   661: aload_2
      //   662: invokestatic 325	com/tencent/mm/pluginsdk/ui/tools/ab$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   665: ldc_w 341
      //   668: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   671: aload 4
      //   673: athrow
      //   674: aload_0
      //   675: invokespecial 323	com/tencent/mm/pluginsdk/ui/tools/ab$c:hnW	()V
      //   678: goto -384 -> 294
      //   681: astore 4
      //   683: aconst_null
      //   684: astore 5
      //   686: aload_2
      //   687: astore_3
      //   688: aload 5
      //   690: astore_2
      //   691: goto -31 -> 660
      //   694: astore 4
      //   696: aload_2
      //   697: astore 5
      //   699: aload_3
      //   700: astore_2
      //   701: aload 5
      //   703: astore_3
      //   704: goto -44 -> 660
      //   707: astore 4
      //   709: goto -49 -> 660
      //   712: astore 4
      //   714: aconst_null
      //   715: astore 5
      //   717: aload_2
      //   718: astore_3
      //   719: aload 5
      //   721: astore_2
      //   722: goto -96 -> 626
      //   725: astore 4
      //   727: aload_2
      //   728: astore 5
      //   730: aload_3
      //   731: astore_2
      //   732: aload 5
      //   734: astore_3
      //   735: goto -109 -> 626
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	738	0	this	c
      //   140	358	1	i	int
      //   71	202	2	localObject1	Object
      //   302	13	2	localException1	Exception
      //   328	1	2	localObject2	Object
      //   360	29	2	localException2	Exception
      //   400	13	2	localException3	Exception
      //   450	282	2	localObject3	Object
      //   126	228	3	localOutputStream1	OutputStream
      //   383	16	3	localObject4	Object
      //   511	224	3	localObject5	Object
      //   4	286	4	localOutputStream2	OutputStream
      //   325	16	4	localException4	Exception
      //   507	93	4	str	String
      //   620	18	4	localException5	Exception
      //   654	18	4	localObject6	Object
      //   681	1	4	localObject7	Object
      //   694	1	4	localObject8	Object
      //   707	1	4	localObject9	Object
      //   712	1	4	localException6	Exception
      //   725	1	4	localException7	Exception
      //   1	732	5	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   289	294	302	java/lang/Exception
      //   130	141	325	java/lang/Exception
      //   151	166	325	java/lang/Exception
      //   172	181	325	java/lang/Exception
      //   187	197	325	java/lang/Exception
      //   208	215	325	java/lang/Exception
      //   221	226	325	java/lang/Exception
      //   232	237	325	java/lang/Exception
      //   243	267	325	java/lang/Exception
      //   273	284	325	java/lang/Exception
      //   353	357	360	java/lang/Exception
      //   130	141	383	finally
      //   151	166	383	finally
      //   172	181	383	finally
      //   187	197	383	finally
      //   208	215	383	finally
      //   221	226	383	finally
      //   232	237	383	finally
      //   243	267	383	finally
      //   273	284	383	finally
      //   329	349	383	finally
      //   388	392	400	java/lang/Exception
      //   433	451	620	java/lang/Exception
      //   433	451	654	finally
      //   451	479	681	finally
      //   500	509	681	finally
      //   517	525	681	finally
      //   525	557	681	finally
      //   565	579	681	finally
      //   587	598	681	finally
      //   598	612	694	finally
      //   626	646	707	finally
      //   451	479	712	java/lang/Exception
      //   500	509	712	java/lang/Exception
      //   517	525	712	java/lang/Exception
      //   525	557	712	java/lang/Exception
      //   565	579	712	java/lang/Exception
      //   587	598	712	java/lang/Exception
      //   598	612	725	java/lang/Exception
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(103149);
      this.Ryy = true;
      d locald = d.QzO;
      d.c(this.iYE);
      if (1 == this.opType) {
        this.Ryx.ajz(this.imagePath);
      }
      for (;;)
      {
        AppMethodBeat.o(103149);
        return true;
        if (!Util.isNullOrNil(this.Ryv)) {
          Toast.makeText(this.context, this.Ryv, 1).show();
        } else {
          Toast.makeText(this.context, this.context.getString(a.a.wv_save_image_error), 1).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.ab
 * JD-Core Version:    0.7.0.1
 */