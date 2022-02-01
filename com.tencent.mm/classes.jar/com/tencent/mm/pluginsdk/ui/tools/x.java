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
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.z.o;
import com.tencent.mm.plugin.appbrand.z.o.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
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
  private static o.a DGl;
  private static final Pattern DGm;
  private static int DGn;
  private static bd iuw;
  
  static
  {
    AppMethodBeat.i(103177);
    DGl = null;
    iuw = null;
    DGm = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    DGn = -1;
    AppMethodBeat.o(103177);
  }
  
  public static boolean B(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103157);
    boolean bool = k.B(paramString1, paramString2);
    AppMethodBeat.o(103157);
    return bool;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(103160);
    if (iuw == null) {
      iuw = new bd(1, "webview-save-image", 1);
    }
    iuw.c(new c(paramContext, paramString1, paramString2, paramBoolean, 1, parama));
    AppMethodBeat.o(103160);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(103162);
    ac.d("MicroMsg.WebViewUtil", "initIFrame");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205409);
        this.DGr.aIk("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
        AppMethodBeat.o(205409);
      }
    });
    AppMethodBeat.o(103162);
  }
  
  private static void a(final b paramb, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(103165);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103165);
      return;
    }
    ac.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    a(paramb);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205411);
        if (this.DGs)
        {
          paramb.aIk("javascript:document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2);
          AppMethodBeat.o(205411);
          return;
        }
        paramb.aIk("javascript:console.log('" + paramString1 + "' + " + paramString2 + ")");
        AppMethodBeat.o(205411);
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
      public final void aIk(String paramAnonymousString)
      {
        AppMethodBeat.i(205410);
        this.DGq.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(205410);
      }
    }, paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(103164);
  }
  
  public static String aBE(String paramString)
  {
    AppMethodBeat.i(103176);
    if (bs.isNullOrNil(paramString))
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
  
  public static boolean aIc(String paramString)
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
  
  public static final String aId(String paramString)
  {
    AppMethodBeat.i(103168);
    if (!bs.isNullOrNil(paramString)) {
      try
      {
        String str = URLEncoder.encode(paramString, "utf-8");
        AppMethodBeat.o(103168);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ac.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
      }
    }
    AppMethodBeat.o(103168);
    return paramString;
  }
  
  public static final String aIe(String paramString)
  {
    AppMethodBeat.i(103169);
    if (!bs.isNullOrNil(paramString))
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
          ac.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        }
      }
      paramString = Base64.encodeToString(paramString, 2);
      AppMethodBeat.o(103169);
      return paramString;
    }
    AppMethodBeat.o(103169);
    return paramString;
  }
  
  public static String aIf(String paramString)
  {
    AppMethodBeat.i(103172);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103172);
      return null;
    }
    if (!DGm.matcher(paramString).matches())
    {
      AppMethodBeat.o(103172);
      return null;
    }
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(103172);
    return paramString;
  }
  
  public static String aIg(String paramString)
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
  public static String aIh(String paramString)
  {
    AppMethodBeat.i(103175);
    paramString = d.aIh(paramString);
    AppMethodBeat.o(103175);
    return paramString;
  }
  
  public static String aIi(String paramString)
  {
    AppMethodBeat.i(205412);
    paramString = String.format("preverify://url=%s", new Object[] { URLEncoder.encode(aBE(bs.nullAsNil(paramString))) });
    AppMethodBeat.o(205412);
    return paramString;
  }
  
  public static String aIj(String paramString)
  {
    AppMethodBeat.i(184503);
    if (!bs.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (aj.DT())
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
        ac.e("MicroMsg.WebViewUtil", paramString.getMessage());
      }
    }
    AppMethodBeat.o(184503);
    return null;
  }
  
  public static boolean aXH(String paramString)
  {
    AppMethodBeat.i(210492);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(210492);
      return false;
    }
    try
    {
      boolean bool = new URL(paramString).getHost().equals("mp.weixin.qq.com");
      if (!bool)
      {
        AppMethodBeat.o(210492);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.WebViewUtil", "create url fail : " + paramString.getLocalizedMessage());
      AppMethodBeat.o(210492);
      return false;
    }
    AppMethodBeat.o(210492);
    return true;
  }
  
  public static void b(Context paramContext, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(103159);
    p.a(paramContext, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(205406);
        if (x.eQt() == null) {
          x.a(new bd(1, "webview-save-image", 1));
        }
        x.eQt().c(new x.c(this.val$context, paramString1, paramString2, paramBoolean));
        AppMethodBeat.o(205406);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205407);
        Toast.makeText(this.val$context, this.val$context.getString(2131766280), 1).show();
        AppMethodBeat.o(205407);
      }
    });
    AppMethodBeat.o(103159);
  }
  
  public static final String bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(103167);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((!bs.isNullOrNil(str)) && (localObject != null) && ((!(localObject instanceof String)) || (!bs.isNullOrNil((String)localObject))))
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
  public static String bS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103155);
    paramContext = o.a(paramContext, paramString, (o.a)e.K(o.a.class));
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
      public final void aIk(String paramAnonymousString)
      {
        AppMethodBeat.i(205408);
        this.DGq.evaluateJavascript(paramAnonymousString, null);
        AppMethodBeat.o(205408);
      }
    });
    AppMethodBeat.o(103161);
  }
  
  public static String cWt()
  {
    AppMethodBeat.i(103173);
    Object localObject = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
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
    ac.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[] { ((NetworkInfo)localObject).getExtraInfo(), Integer.valueOf(((NetworkInfo)localObject).getType()), ((NetworkInfo)localObject).getExtraInfo() });
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(103173);
      return localObject;
    }
    AppMethodBeat.o(103173);
    return "no";
  }
  
  public static boolean eQs()
  {
    AppMethodBeat.i(205413);
    if (DGn != -1)
    {
      if (DGn == 1)
      {
        AppMethodBeat.o(205413);
        return true;
      }
      AppMethodBeat.o(205413);
      return false;
    }
    int i = aw.aKT("bizCommand").decodeInt("sameLayerOpen", -1);
    DGn = i;
    if (i != -1)
    {
      if (DGn == 1)
      {
        AppMethodBeat.o(205413);
        return true;
      }
      AppMethodBeat.o(205413);
      return false;
    }
    DGn = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPU, 0);
    ac.i("MicroMsg.WebViewUtil", "useSameLayerForVideo useSameLayer=%d", new Object[] { Integer.valueOf(DGn) });
    if (DGn == 1)
    {
      AppMethodBeat.o(205413);
      return true;
    }
    AppMethodBeat.o(205413);
    return false;
  }
  
  @Deprecated
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(103158);
    paramContext = com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(paramContext, paramString);
    AppMethodBeat.o(103158);
    return paramContext;
  }
  
  public static String ld(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103166);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(103166);
      return null;
    }
    ac.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[] { paramString1, paramString2 });
    paramString1 = "document.getElementById('_edw_iframe_').src = '" + paramString1 + "' + " + paramString2;
    AppMethodBeat.o(103166);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void NR(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void aIk(String paramString);
  }
  
  static final class c
    implements bd.a
  {
    private static Pattern DGu;
    private static Pattern DGv;
    private String DGw;
    private String DGx;
    private x.a DGy;
    private Context context;
    private String hgd;
    private String imagePath;
    private int opType;
    private boolean opt;
    
    static
    {
      AppMethodBeat.i(103154);
      DGu = Pattern.compile("image/[A-Za-z0-9]+");
      DGv = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
      AppMethodBeat.o(103154);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
    {
      this(paramContext, paramString1, paramString2, paramBoolean, 0, null);
    }
    
    public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, x.a parama)
    {
      this.context = paramContext;
      this.hgd = paramString1;
      this.DGx = paramString2;
      this.opt = paramBoolean;
      this.opType = paramInt;
      this.DGy = parama;
    }
    
    private void a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      AppMethodBeat.i(177338);
      ac.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[] { paramString1, paramString2 });
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (!bs.isNullOrNil(paramString1))
      {
        paramString1 = DGu.matcher(paramString1);
        localObject1 = localObject2;
        if (paramString1.find()) {
          localObject1 = paramString1.group().substring(paramString1.group().lastIndexOf('/') + 1);
        }
      }
      paramString1 = (String)localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        paramString1 = (String)localObject1;
        if (!bs.isNullOrNil(paramString2))
        {
          paramString2 = DGv.matcher(paramString2);
          paramString1 = (String)localObject1;
          if (paramString2.find()) {
            paramString1 = paramString2.group().substring(paramString2.group().lastIndexOf('.') + 1);
          }
        }
      }
      paramString2 = paramString1;
      int i;
      if (bs.isNullOrNil(paramString1))
      {
        paramString1 = new v(this.hgd);
        i = paramString1.mPath.lastIndexOf('.');
        if (i != -1) {
          break label223;
        }
      }
      label223:
      for (paramString2 = "jpg";; paramString2 = paramString1.mPath.substring(i + 1))
      {
        this.imagePath = q.alY(paramString2);
        paramString1 = i.cS(this.imagePath, false);
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
          this.DGw = this.context.getString(2131757969, new Object[] { q.eQn() });
          q.k(this.imagePath, this.context);
        }
        AppMethodBeat.o(177338);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ac.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[] { paramString1.getMessage() });
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
            ac.printErrStackTrace("MicroMsg.WebViewUtil", paramHttpURLConnection, "", new Object[0]);
          }
          localException = localException;
          ac.e("MicroMsg.WebViewUtil", localException.getMessage());
        }
        AppMethodBeat.o(184502);
      }
    }
    
    /* Error */
    private void eQu()
    {
      // Byte code:
      //   0: ldc 204
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 206	java/net/URL
      //   8: dup
      //   9: aload_0
      //   10: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   13: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
      //   16: invokevirtual 211	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   19: checkcast 185	java/net/HttpURLConnection
      //   22: astore_2
      //   23: aload_2
      //   24: ldc 213
      //   26: invokevirtual 216	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   29: aload_2
      //   30: ldc 218
      //   32: aload_0
      //   33: getfield 65	com/tencent/mm/pluginsdk/ui/tools/x$c:DGx	Ljava/lang/String;
      //   36: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   39: aload_2
      //   40: iconst_1
      //   41: invokevirtual 225	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
      //   44: aload_2
      //   45: invokevirtual 229	java/net/HttpURLConnection:getResponseCode	()I
      //   48: istore_1
      //   49: iload_1
      //   50: sipush 200
      //   53: if_icmpeq +106 -> 159
      //   56: iload_1
      //   57: sipush 301
      //   60: if_icmpeq +10 -> 70
      //   63: iload_1
      //   64: sipush 302
      //   67: if_icmpne +68 -> 135
      //   70: aload_2
      //   71: ldc 231
      //   73: invokevirtual 234	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   76: astore 4
      //   78: aload 4
      //   80: astore_3
      //   81: aload 4
      //   83: ifnonnull +10 -> 93
      //   86: aload_2
      //   87: ldc 236
      //   89: invokevirtual 234	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   92: astore_3
      //   93: ldc 78
      //   95: ldc 238
      //   97: iconst_1
      //   98: anewarray 4	java/lang/Object
      //   101: dup
      //   102: iconst_0
      //   103: aload_3
      //   104: aastore
      //   105: invokestatic 85	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   108: aload_3
      //   109: invokestatic 91	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   112: ifne +23 -> 135
      //   115: aload_0
      //   116: aload_3
      //   117: putfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   120: aload_0
      //   121: invokespecial 240	com/tencent/mm/pluginsdk/ui/tools/x$c:eQu	()V
      //   124: aload_2
      //   125: aconst_null
      //   126: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   129: ldc 204
      //   131: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: return
      //   135: aload_0
      //   136: aload_0
      //   137: getfield 61	com/tencent/mm/pluginsdk/ui/tools/x$c:context	Landroid/content/Context;
      //   140: ldc 243
      //   142: invokevirtual 245	android/content/Context:getString	(I)Ljava/lang/String;
      //   145: putfield 169	com/tencent/mm/pluginsdk/ui/tools/x$c:DGw	Ljava/lang/String;
      //   148: aload_2
      //   149: aconst_null
      //   150: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   153: ldc 204
      //   155: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   158: return
      //   159: aload_2
      //   160: invokevirtual 248	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   163: astore 4
      //   165: aload_2
      //   166: invokevirtual 189	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   169: astore_3
      //   170: aload_0
      //   171: aload 4
      //   173: aload_2
      //   174: ldc 250
      //   176: invokevirtual 234	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   179: aload_3
      //   180: invokespecial 252	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   183: aload_2
      //   184: aload_3
      //   185: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   188: ldc 204
      //   190: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   193: return
      //   194: astore 4
      //   196: aconst_null
      //   197: astore_2
      //   198: aconst_null
      //   199: astore_3
      //   200: ldc 78
      //   202: ldc 254
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload 4
      //   212: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   215: aastore
      //   216: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   219: aload_3
      //   220: aload_2
      //   221: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   224: ldc 204
      //   226: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   229: return
      //   230: astore 4
      //   232: aconst_null
      //   233: astore_2
      //   234: aconst_null
      //   235: astore_3
      //   236: aload_3
      //   237: aload_2
      //   238: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   241: ldc 204
      //   243: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload 4
      //   248: athrow
      //   249: astore 4
      //   251: aconst_null
      //   252: astore 5
      //   254: aload_2
      //   255: astore_3
      //   256: aload 5
      //   258: astore_2
      //   259: goto -23 -> 236
      //   262: astore 4
      //   264: aload_2
      //   265: astore 5
      //   267: aload_3
      //   268: astore_2
      //   269: aload 5
      //   271: astore_3
      //   272: goto -36 -> 236
      //   275: astore 4
      //   277: goto -41 -> 236
      //   280: astore 4
      //   282: aconst_null
      //   283: astore 5
      //   285: aload_2
      //   286: astore_3
      //   287: aload 5
      //   289: astore_2
      //   290: goto -90 -> 200
      //   293: astore 4
      //   295: aload_2
      //   296: astore 5
      //   298: aload_3
      //   299: astore_2
      //   300: aload 5
      //   302: astore_3
      //   303: goto -103 -> 200
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	306	0	this	c
      //   48	20	1	i	int
      //   22	278	2	localObject1	Object
      //   80	223	3	localObject2	Object
      //   76	96	4	str	String
      //   194	17	4	localException1	Exception
      //   230	17	4	localObject3	Object
      //   249	1	4	localObject4	Object
      //   262	1	4	localObject5	Object
      //   275	1	4	localObject6	Object
      //   280	1	4	localException2	Exception
      //   293	1	4	localException3	Exception
      //   252	49	5	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   5	23	194	java/lang/Exception
      //   5	23	230	finally
      //   23	49	249	finally
      //   70	78	249	finally
      //   86	93	249	finally
      //   93	124	249	finally
      //   135	148	249	finally
      //   159	170	249	finally
      //   170	183	262	finally
      //   200	219	275	finally
      //   23	49	280	java/lang/Exception
      //   70	78	280	java/lang/Exception
      //   86	93	280	java/lang/Exception
      //   93	124	280	java/lang/Exception
      //   135	148	280	java/lang/Exception
      //   159	170	280	java/lang/Exception
      //   170	183	293	java/lang/Exception
    }
    
    /* Error */
    public final boolean aBj()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: ldc_w 256
      //   9: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   12: aload_0
      //   13: getfield 67	com/tencent/mm/pluginsdk/ui/tools/x$c:opt	Z
      //   16: ifne +25 -> 41
      //   19: aload_0
      //   20: aload_0
      //   21: getfield 61	com/tencent/mm/pluginsdk/ui/tools/x$c:context	Landroid/content/Context;
      //   24: ldc_w 257
      //   27: invokevirtual 245	android/content/Context:getString	(I)Ljava/lang/String;
      //   30: putfield 169	com/tencent/mm/pluginsdk/ui/tools/x$c:DGw	Ljava/lang/String;
      //   33: ldc_w 256
      //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   39: iconst_1
      //   40: ireturn
      //   41: aload_0
      //   42: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   45: invokestatic 91	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   48: ifeq +11 -> 59
      //   51: ldc_w 256
      //   54: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: iconst_0
      //   58: ireturn
      //   59: aload_0
      //   60: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   63: invokestatic 262	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
      //   66: ifeq +356 -> 422
      //   69: ldc 125
      //   71: astore_2
      //   72: aload_0
      //   73: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   76: invokestatic 91	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   79: ifne +16 -> 95
      //   82: aload_0
      //   83: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   86: ldc_w 264
      //   89: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   92: ifne +19 -> 111
      //   95: aload_0
      //   96: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   99: ldc_w 264
      //   102: invokevirtual 270	java/lang/String:toUpperCase	()Ljava/lang/String;
      //   105: invokevirtual 267	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   108: ifeq +7 -> 115
      //   111: ldc_w 272
      //   114: astore_2
      //   115: aload_0
      //   116: aload_2
      //   117: invokestatic 131	com/tencent/mm/pluginsdk/ui/tools/q:alY	(Ljava/lang/String;)Ljava/lang/String;
      //   120: putfield 133	com/tencent/mm/pluginsdk/ui/tools/x$c:imagePath	Ljava/lang/String;
      //   123: aload 4
      //   125: astore_3
      //   126: aload 5
      //   128: astore_2
      //   129: aload_0
      //   130: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   133: ldc_w 274
      //   136: invokevirtual 278	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   139: istore_1
      //   140: iload_1
      //   141: ifle +24 -> 165
      //   144: aload 4
      //   146: astore_3
      //   147: aload 5
      //   149: astore_2
      //   150: aload_0
      //   151: aload_0
      //   152: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   155: iload_1
      //   156: bipush 7
      //   158: iadd
      //   159: invokevirtual 115	java/lang/String:substring	(I)Ljava/lang/String;
      //   162: putfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   165: aload 4
      //   167: astore_3
      //   168: aload 5
      //   170: astore_2
      //   171: aload_0
      //   172: getfield 133	com/tencent/mm/pluginsdk/ui/tools/x$c:imagePath	Ljava/lang/String;
      //   175: iconst_0
      //   176: invokestatic 139	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   179: astore 4
      //   181: aload 4
      //   183: astore_3
      //   184: aload 4
      //   186: astore_2
      //   187: aload_0
      //   188: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   191: iconst_0
      //   192: invokestatic 284	android/util/Base64:decode	(Ljava/lang/String;I)[B
      //   195: astore 5
      //   197: aload 5
      //   199: ifnull +16 -> 215
      //   202: aload 4
      //   204: astore_3
      //   205: aload 4
      //   207: astore_2
      //   208: aload 4
      //   210: aload 5
      //   212: invokevirtual 287	java/io/OutputStream:write	([B)V
      //   215: aload 4
      //   217: astore_3
      //   218: aload 4
      //   220: astore_2
      //   221: aload 4
      //   223: invokevirtual 154	java/io/OutputStream:flush	()V
      //   226: aload 4
      //   228: astore_3
      //   229: aload 4
      //   231: astore_2
      //   232: aload 4
      //   234: invokevirtual 157	java/io/OutputStream:close	()V
      //   237: aload 4
      //   239: astore_3
      //   240: aload 4
      //   242: astore_2
      //   243: aload_0
      //   244: aload_0
      //   245: getfield 61	com/tencent/mm/pluginsdk/ui/tools/x$c:context	Landroid/content/Context;
      //   248: ldc 158
      //   250: iconst_1
      //   251: anewarray 4	java/lang/Object
      //   254: dup
      //   255: iconst_0
      //   256: invokestatic 161	com/tencent/mm/pluginsdk/ui/tools/q:eQn	()Ljava/lang/String;
      //   259: aastore
      //   260: invokevirtual 167	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
      //   263: putfield 169	com/tencent/mm/pluginsdk/ui/tools/x$c:DGw	Ljava/lang/String;
      //   266: aload 4
      //   268: astore_3
      //   269: aload 4
      //   271: astore_2
      //   272: aload_0
      //   273: getfield 133	com/tencent/mm/pluginsdk/ui/tools/x$c:imagePath	Ljava/lang/String;
      //   276: aload_0
      //   277: getfield 61	com/tencent/mm/pluginsdk/ui/tools/x$c:context	Landroid/content/Context;
      //   280: invokestatic 173	com/tencent/mm/pluginsdk/ui/tools/q:k	(Ljava/lang/String;Landroid/content/Context;)V
      //   283: aload 4
      //   285: ifnull +8 -> 293
      //   288: aload 4
      //   290: invokevirtual 157	java/io/OutputStream:close	()V
      //   293: ldc_w 256
      //   296: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   299: iconst_1
      //   300: ireturn
      //   301: astore_2
      //   302: ldc 78
      //   304: ldc_w 289
      //   307: iconst_1
      //   308: anewarray 4	java/lang/Object
      //   311: dup
      //   312: iconst_0
      //   313: aload_2
      //   314: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   317: aastore
      //   318: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   321: goto -28 -> 293
      //   324: astore 4
      //   326: aload_3
      //   327: astore_2
      //   328: ldc 78
      //   330: ldc_w 291
      //   333: iconst_1
      //   334: anewarray 4	java/lang/Object
      //   337: dup
      //   338: iconst_0
      //   339: aload 4
      //   341: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   344: aastore
      //   345: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   348: aload_3
      //   349: ifnull -56 -> 293
      //   352: aload_3
      //   353: invokevirtual 157	java/io/OutputStream:close	()V
      //   356: goto -63 -> 293
      //   359: astore_2
      //   360: ldc 78
      //   362: ldc_w 289
      //   365: iconst_1
      //   366: anewarray 4	java/lang/Object
      //   369: dup
      //   370: iconst_0
      //   371: aload_2
      //   372: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   375: aastore
      //   376: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   379: goto -86 -> 293
      //   382: astore_3
      //   383: aload_2
      //   384: ifnull +7 -> 391
      //   387: aload_2
      //   388: invokevirtual 157	java/io/OutputStream:close	()V
      //   391: ldc_w 256
      //   394: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   397: aload_3
      //   398: athrow
      //   399: astore_2
      //   400: ldc 78
      //   402: ldc_w 289
      //   405: iconst_1
      //   406: anewarray 4	java/lang/Object
      //   409: dup
      //   410: iconst_0
      //   411: aload_2
      //   412: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   415: aastore
      //   416: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   419: goto -28 -> 391
      //   422: aload_0
      //   423: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   426: invokestatic 294	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   429: ifeq +237 -> 666
      //   432: new 206	java/net/URL
      //   435: dup
      //   436: aload_0
      //   437: getfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   440: invokespecial 207	java/net/URL:<init>	(Ljava/lang/String;)V
      //   443: invokevirtual 211	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   446: checkcast 296	javax/net/ssl/HttpsURLConnection
      //   449: astore_2
      //   450: aload_2
      //   451: ldc 213
      //   453: invokevirtual 297	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   456: aload_2
      //   457: ldc 218
      //   459: aload_0
      //   460: getfield 65	com/tencent/mm/pluginsdk/ui/tools/x$c:DGx	Ljava/lang/String;
      //   463: invokevirtual 298	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   466: aload_2
      //   467: iconst_1
      //   468: invokevirtual 299	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
      //   471: aload_2
      //   472: invokevirtual 300	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   475: istore_1
      //   476: iload_1
      //   477: sipush 200
      //   480: if_icmpeq +100 -> 580
      //   483: iload_1
      //   484: sipush 301
      //   487: if_icmpeq +10 -> 497
      //   490: iload_1
      //   491: sipush 302
      //   494: if_icmpne +65 -> 559
      //   497: aload_2
      //   498: ldc 231
      //   500: invokevirtual 301	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   503: astore 4
      //   505: aload 4
      //   507: astore_3
      //   508: aload 4
      //   510: ifnonnull +10 -> 520
      //   513: aload_2
      //   514: ldc 236
      //   516: invokevirtual 301	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   519: astore_3
      //   520: ldc 78
      //   522: ldc 238
      //   524: iconst_1
      //   525: anewarray 4	java/lang/Object
      //   528: dup
      //   529: iconst_0
      //   530: aload_3
      //   531: aastore
      //   532: invokestatic 85	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   535: aload_3
      //   536: invokestatic 91	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   539: ifne +20 -> 559
      //   542: aload_0
      //   543: aload_3
      //   544: putfield 63	com/tencent/mm/pluginsdk/ui/tools/x$c:hgd	Ljava/lang/String;
      //   547: aload_0
      //   548: invokespecial 240	com/tencent/mm/pluginsdk/ui/tools/x$c:eQu	()V
      //   551: aload_2
      //   552: aconst_null
      //   553: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   556: goto -263 -> 293
      //   559: aload_0
      //   560: aload_0
      //   561: getfield 61	com/tencent/mm/pluginsdk/ui/tools/x$c:context	Landroid/content/Context;
      //   564: ldc 243
      //   566: invokevirtual 245	android/content/Context:getString	(I)Ljava/lang/String;
      //   569: putfield 169	com/tencent/mm/pluginsdk/ui/tools/x$c:DGw	Ljava/lang/String;
      //   572: aload_2
      //   573: aconst_null
      //   574: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   577: goto -284 -> 293
      //   580: aload_2
      //   581: invokevirtual 302	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   584: astore 4
      //   586: aload_2
      //   587: invokevirtual 303	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   590: astore_3
      //   591: aload_0
      //   592: aload 4
      //   594: aload_2
      //   595: ldc 250
      //   597: invokevirtual 301	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   600: aload_3
      //   601: invokespecial 252	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
      //   604: aload_2
      //   605: aload_3
      //   606: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   609: goto -316 -> 293
      //   612: astore 4
      //   614: aconst_null
      //   615: astore_2
      //   616: aconst_null
      //   617: astore_3
      //   618: ldc 78
      //   620: ldc_w 305
      //   623: iconst_1
      //   624: anewarray 4	java/lang/Object
      //   627: dup
      //   628: iconst_0
      //   629: aload 4
      //   631: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   634: aastore
      //   635: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   638: aload_3
      //   639: aload_2
      //   640: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   643: goto -350 -> 293
      //   646: astore 4
      //   648: aconst_null
      //   649: astore_2
      //   650: aconst_null
      //   651: astore_3
      //   652: aload_3
      //   653: aload_2
      //   654: invokestatic 242	com/tencent/mm/pluginsdk/ui/tools/x$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
      //   657: ldc_w 256
      //   660: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   663: aload 4
      //   665: athrow
      //   666: aload_0
      //   667: invokespecial 240	com/tencent/mm/pluginsdk/ui/tools/x$c:eQu	()V
      //   670: goto -377 -> 293
      //   673: astore 4
      //   675: aconst_null
      //   676: astore 5
      //   678: aload_2
      //   679: astore_3
      //   680: aload 5
      //   682: astore_2
      //   683: goto -31 -> 652
      //   686: astore 4
      //   688: aload_2
      //   689: astore 5
      //   691: aload_3
      //   692: astore_2
      //   693: aload 5
      //   695: astore_3
      //   696: goto -44 -> 652
      //   699: astore 4
      //   701: goto -49 -> 652
      //   704: astore 4
      //   706: aconst_null
      //   707: astore 5
      //   709: aload_2
      //   710: astore_3
      //   711: aload 5
      //   713: astore_2
      //   714: goto -96 -> 618
      //   717: astore 4
      //   719: aload_2
      //   720: astore 5
      //   722: aload_3
      //   723: astore_2
      //   724: aload 5
      //   726: astore_3
      //   727: goto -109 -> 618
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	730	0	this	c
      //   139	356	1	i	int
      //   71	201	2	localObject1	Object
      //   301	13	2	localException1	Exception
      //   327	1	2	localObject2	Object
      //   359	29	2	localException2	Exception
      //   399	13	2	localException3	Exception
      //   449	275	2	localObject3	Object
      //   125	228	3	localOutputStream1	OutputStream
      //   382	16	3	localObject4	Object
      //   507	220	3	localObject5	Object
      //   4	285	4	localOutputStream2	OutputStream
      //   324	16	4	localException4	Exception
      //   503	90	4	str	String
      //   612	18	4	localException5	Exception
      //   646	18	4	localObject6	Object
      //   673	1	4	localObject7	Object
      //   686	1	4	localObject8	Object
      //   699	1	4	localObject9	Object
      //   704	1	4	localException6	Exception
      //   717	1	4	localException7	Exception
      //   1	724	5	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   288	293	301	java/lang/Exception
      //   129	140	324	java/lang/Exception
      //   150	165	324	java/lang/Exception
      //   171	181	324	java/lang/Exception
      //   187	197	324	java/lang/Exception
      //   208	215	324	java/lang/Exception
      //   221	226	324	java/lang/Exception
      //   232	237	324	java/lang/Exception
      //   243	266	324	java/lang/Exception
      //   272	283	324	java/lang/Exception
      //   352	356	359	java/lang/Exception
      //   129	140	382	finally
      //   150	165	382	finally
      //   171	181	382	finally
      //   187	197	382	finally
      //   208	215	382	finally
      //   221	226	382	finally
      //   232	237	382	finally
      //   243	266	382	finally
      //   272	283	382	finally
      //   328	348	382	finally
      //   387	391	399	java/lang/Exception
      //   432	450	612	java/lang/Exception
      //   432	450	646	finally
      //   450	476	673	finally
      //   497	505	673	finally
      //   513	520	673	finally
      //   520	551	673	finally
      //   559	572	673	finally
      //   580	591	673	finally
      //   591	604	686	finally
      //   618	638	699	finally
      //   450	476	704	java/lang/Exception
      //   497	505	704	java/lang/Exception
      //   513	520	704	java/lang/Exception
      //   520	551	704	java/lang/Exception
      //   559	572	704	java/lang/Exception
      //   580	591	704	java/lang/Exception
      //   591	604	717	java/lang/Exception
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(103149);
      if (1 == this.opType)
      {
        this.DGy.NR(this.imagePath);
        AppMethodBeat.o(103149);
        return true;
      }
      if (!bs.isNullOrNil(this.DGw)) {
        Toast.makeText(this.context, this.DGw, 1).show();
      }
      for (;;)
      {
        AppMethodBeat.o(103149);
        return true;
        Toast.makeText(this.context, this.context.getString(2131766280), 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */