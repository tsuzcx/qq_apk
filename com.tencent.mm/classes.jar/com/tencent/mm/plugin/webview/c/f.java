package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  implements b, c, com.tencent.mm.plugin.webview.c.d.a
{
  private static final int Cju;
  public boolean Apr;
  public String CjA;
  public int CjB;
  private a CjC;
  private Set<String> CjD;
  private boolean CjE;
  public String CjF;
  private com.tencent.mm.plugin.webview.c.b.a CjG;
  public String CjH;
  public String CjI;
  private final List<String> CjJ;
  volatile String CjK;
  volatile int CjL;
  private JSONObject CjM;
  private JSONArray CjN;
  private List<String> CjO;
  private au CjP;
  public long CjQ;
  public com.tencent.mm.plugin.webview.k.k CjR;
  public MMWebView Cjr;
  private final List<String> Cjv;
  private ao Cjw;
  public Map<String, Object> Cjx;
  private g Cjy;
  public boolean Cjz;
  HashMap<String, b> fWm;
  public com.tencent.mm.plugin.webview.stub.e kYt;
  private final LinkedList<l> zuC;
  
  static
  {
    AppMethodBeat.i(205298);
    if (com.tencent.mm.compatible.util.d.la(19)) {}
    for (int i = 200;; i = 20)
    {
      Cju = i;
      AppMethodBeat.o(205298);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt)
  {
    AppMethodBeat.i(205203);
    this.Cjv = new LinkedList();
    this.zuC = new LinkedList();
    this.Cjw = null;
    this.Apr = false;
    this.Cjz = false;
    this.CjA = "";
    this.CjD = null;
    this.CjE = false;
    this.CjG = null;
    this.fWm = new HashMap();
    this.CjJ = new LinkedList();
    this.CjK = null;
    this.CjL = 0;
    this.CjM = new JSONObject();
    this.CjN = new JSONArray();
    this.CjO = new LinkedList();
    this.CjP = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(205154);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(205154);
        return false;
      }
    }, false);
    this.CjQ = 0L;
    this.CjR = new com.tencent.mm.plugin.webview.k.k(this);
    this.Cjr = paramMMWebView;
    this.Cjy = paramg;
    this.CjB = paramInt;
    ezG();
    ac.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(205203);
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(205204);
    this.Cjv = new LinkedList();
    this.zuC = new LinkedList();
    this.Cjw = null;
    this.Apr = false;
    this.Cjz = false;
    this.CjA = "";
    this.CjD = null;
    this.CjE = false;
    this.CjG = null;
    this.fWm = new HashMap();
    this.CjJ = new LinkedList();
    this.CjK = null;
    this.CjL = 0;
    this.CjM = new JSONObject();
    this.CjN = new JSONArray();
    this.CjO = new LinkedList();
    this.CjP = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(205154);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(205154);
        return false;
      }
    }, false);
    this.CjQ = 0L;
    this.CjR = new com.tencent.mm.plugin.webview.k.k(this);
    this.Cjr = paramMMWebView;
    this.Cjy = paramg;
    this.CjB = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.CjD = paramg;
    this.CjE = true;
    ezG();
    ac.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(205204);
  }
  
  /* Error */
  private static boolean G(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 227	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 357	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 318
    //   20: ldc_w 359
    //   23: invokestatic 363	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 351
    //   29: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 365	com/tencent/mm/vfs/e
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 368	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 372	com/tencent/mm/vfs/e:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 375	com/tencent/mm/vfs/e:createNewFile	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 381	com/tencent/mm/vfs/i:d	(Lcom/tencent/mm/vfs/e;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 387 1 0
    //   77: invokeinterface 393 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 398 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 402 1 0
    //   101: checkcast 404	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 408 2 0
    //   114: checkcast 326	java/lang/Integer
    //   117: invokevirtual 411	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 413	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 420
    //   136: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 427	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 431	java/lang/String:getBytes	()[B
    //   150: invokevirtual 437	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 439	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 439	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 318
    //   174: aload_1
    //   175: ldc_w 259
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 318
    //   188: ldc_w 445
    //   191: invokestatic 363	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 448	java/io/OutputStream:close	()V
    //   202: ldc_w 351
    //   205: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 318
    //   214: ldc_w 450
    //   217: aload_0
    //   218: invokestatic 453	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 457	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 460	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 318
    //   230: aload_1
    //   231: ldc_w 259
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 351
    //   244: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 463	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 448	java/io/OutputStream:close	()V
    //   261: ldc_w 318
    //   264: ldc_w 465
    //   267: aload_0
    //   268: invokestatic 453	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 457	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 467	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 351
    //   280: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 318
    //   289: aload_1
    //   290: ldc_w 259
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 318
    //   307: aload_0
    //   308: ldc_w 259
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 448	java/io/OutputStream:close	()V
    //   332: ldc_w 351
    //   335: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 318
    //   344: aload_1
    //   345: ldc_w 259
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: goto -23 -> 332
    //   358: astore_0
    //   359: goto -35 -> 324
    //   362: astore_1
    //   363: aload_0
    //   364: astore_3
    //   365: aload_1
    //   366: astore_0
    //   367: goto -43 -> 324
    //   370: astore_1
    //   371: aload_3
    //   372: astore_0
    //   373: goto -202 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramString	String
    //   0	376	1	paramMap	Map<String, Integer>
    //   120	10	2	i	int
    //   59	313	3	localObject1	Object
    //   42	53	4	localObject2	Object
    //   104	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   71	84	168	java/lang/Exception
    //   84	165	168	java/lang/Exception
    //   249	253	168	java/lang/Exception
    //   52	58	210	java/io/IOException
    //   257	261	285	java/io/IOException
    //   198	202	303	java/io/IOException
    //   60	68	321	finally
    //   328	332	340	java/io/IOException
    //   71	84	358	finally
    //   84	165	358	finally
    //   249	253	358	finally
    //   171	194	362	finally
    //   60	68	370	java/lang/Exception
  }
  
  private boolean a(final l paraml, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(205222);
    if (paraml == null)
    {
      ac.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(205222);
      return true;
    }
    if ((paraml.kCH == null) || (paraml.vUl == null) || (paraml.type == null) || (this.Cjr == null))
    {
      ac.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paraml.kCH + ", params = " + paraml.vUl + ", type = " + paraml.type + ", wv = " + this.Cjr);
      AppMethodBeat.o(205222);
      return true;
    }
    if ((this.CjE) && ((this.CjD == null) || (!this.CjD.contains(paraml.kCH))))
    {
      ac.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paraml.kCH });
      com.tencent.e.h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205191);
          f.this.j(paraml.Ckt, "system:access_denied", null);
          AppMethodBeat.o(205191);
        }
      });
      AppMethodBeat.o(205222);
      return true;
    }
    if ((this.Cjx != null) && (this.Cjx.get("srcUsername") != null) && (!bs.isNullOrNil(this.Cjx.get("srcUsername").toString()))) {
      paraml.vUl.put("src_username", this.Cjx.get("srcUsername").toString());
    }
    if ((this.Cjx != null) && (this.Cjx.get("srcDisplayname") != null) && (!bs.isNullOrNil(this.Cjx.get("srcDisplayname").toString()))) {
      paraml.vUl.put("src_displayname", this.Cjx.get("srcDisplayname").toString());
    }
    if ((this.Cjx != null) && (this.Cjx.get("KTemplateId") != null) && (!bs.isNullOrNil(this.Cjx.get("KTemplateId").toString()))) {
      paraml.vUl.put("tempalate_id", this.Cjx.get("KTemplateId").toString());
    }
    Object localObject1;
    Bundle localBundle;
    if (this.Cjx != null)
    {
      paraml.vUl.put("message_id", this.Cjx.get("message_id"));
      paraml.vUl.put("message_index", this.Cjx.get("message_index"));
      paraml.vUl.put("webview_scene", this.Cjx.get("scene"));
      paraml.vUl.put("pay_channel", this.Cjx.get("pay_channel"));
      paraml.vUl.put("pay_scene", this.Cjx.get("pay_scene"));
      ac.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.Cjx.get("pay_package") });
      if (this.Cjx.get("pay_package") != null) {
        paraml.vUl.put("pay_packageName", this.Cjx.get("pay_package"));
      }
      paraml.vUl.put("stastic_scene", this.Cjx.get("stastic_scene"));
      paraml.vUl.put("open_from_scene", this.Cjx.get("from_scence"));
      localObject1 = paraml.vUl;
      localBundle = new Bundle();
      localBundle.putString("__jsapi_fw_ext_info_key_current_url", this.Cjr.getUrl());
      ((Map)localObject1).put("__jsapi_fw_ext_info", localBundle);
    }
    if ((!paraml.kCH.equals("shareWeibo")) && (!paraml.kCH.equals("openUrlByExtBrowser")) && (!paraml.kCH.equals("openUrlWithExtraWebview")) && (!paraml.kCH.equals("openCustomWebview")) && (!paraml.kCH.equals("openGameWebView")) && (!paraml.kCH.equals("addToEmoticon")) && (!paraml.kCH.equals("shareEmoticon")) && (!paraml.kCH.equals("openGameUrlWithExtraWebView")) && (!paraml.kCH.equals("request")))
    {
      paraml.vUl.put("url", this.Cjr.getUrl());
      ac.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.Cjr.getUrl());
    }
    if ((paraml.kCH.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kCH.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paraml.kCH.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kCH.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paraml.kCH.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kCH.equalsIgnoreCase("openDesignerProfile")) || (paraml.kCH.equalsIgnoreCase("openDesignerProfileLocal")) || (paraml.kCH.equalsIgnoreCase("getSearchEmotionData")))
    {
      paraml.vUl.put("searchID", Long.valueOf(ezU()));
      ac.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(ezU()) });
    }
    if (paraml.kCH.equals("request"))
    {
      if (this.CjH != null) {
        paraml.vUl.put("key_request_full_url_query", this.CjH);
      }
      if (this.CjI != null) {
        paraml.vUl.put("key_request_header", this.CjI);
      }
    }
    if (paraml.kCH.equals("imagePreview")) {
      j.a(paraml.vUl, this.Cjr);
    }
    if ((paraml.kCH.equals("preVerifyJSAPI")) && (paraml.vUl.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.k.c.eHd();
    }
    if (paramJsapiPermissionWrapper != null) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        localObject1 = new Bundle();
        if (paramJsapiPermissionWrapper != null)
        {
          ((Bundle)localObject1).putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.DIA);
          ((Bundle)localObject1).putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.DIB);
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.eRo());
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.eRp());
        }
        localObject2 = l.by(paraml.vUl);
        if (!bs.isNullOrNil(this.CjF)) {
          ((Bundle)localObject2).putString("key_wxapp_id", this.CjF);
        }
        localBundle = new Bundle(3);
        if (paraml.Ckv != null) {
          localBundle.putBundle("webCompt", paraml.Ckv);
        }
        localBundle.putBundle("compatParams", (Bundle)localObject2);
        if (paraml.Cku != null) {
          localBundle.putString("rawParams", paraml.Cku.toString());
        }
        ac.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paraml.kCH });
        localObject2 = this.CjC;
        if (localObject2 == null) {
          break label1949;
        }
        bool2 = ((a)localObject2).b(paraml);
        bool3 = bool2;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        Object localObject2;
        i = 0;
        bool1 = false;
        ac.printErrStackTrace("MicroMsg.JsApiHandler", paramJsapiPermissionWrapper, "", new Object[0]);
        ac.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + paramJsapiPermissionWrapper.getMessage());
        continue;
        AppMethodBeat.o(205222);
        return false;
      }
      try
      {
        this.Cjy.eCn();
        bool3 = bool2;
        getContext();
        bool1 = bool2;
        if (!bool2)
        {
          bool3 = bool2;
          paramJsapiPermissionWrapper = new d(getContext(), paramJsapiPermissionWrapper, this.kYt, this, this.Cjr);
          bool3 = bool2;
          localObject2 = m.Ckz;
          bool3 = bool2;
          d.g.b.k.h(paramJsapiPermissionWrapper, "env");
          bool3 = bool2;
          d.g.b.k.h(paraml, "msg");
          bool3 = bool2;
          if (com.tencent.mm.sdk.platformtools.h.DEBUG)
          {
            bool3 = bool2;
            if (1 > ac.getLogLevel())
            {
              bool3 = bool2;
              if (m.Ckx.isEmpty()) {
                continue;
              }
              bool1 = true;
              bool3 = bool2;
              Assert.assertTrue("handleMsg jsApis isEmpty", bool1);
            }
          }
          bool3 = bool2;
          if (!m.Ckx.containsKey(paraml.kCH)) {
            break label1955;
          }
          bool3 = bool2;
          localObject2 = m.Ckx.get(paraml.kCH);
          if (localObject2 == null)
          {
            bool3 = bool2;
            d.g.b.k.fOy();
          }
          bool3 = bool2;
          localObject2 = (com.tencent.mm.plugin.webview.c.c.a)localObject2;
          bool3 = bool2;
          if (!m.Cky.UM(((com.tencent.mm.plugin.webview.c.c.a)localObject2).ezX())) {
            continue;
          }
          bool3 = bool2;
          paramJsapiPermissionWrapper.Cjq.j(paraml.Ckt, "system:too_frequent", null);
          bool3 = bool2;
          m.a(paramJsapiPermissionWrapper, (com.tencent.mm.plugin.webview.c.c.a)localObject2);
          bool1 = true;
        }
        else
        {
          if (!bool1) {
            continue;
          }
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        i = 0;
        bool1 = bool3;
        continue;
      }
      try
      {
        ac.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paraml.kCH });
        i = 1;
        j.eCg();
        ac.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paraml.kCH, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          continue;
        }
        AppMethodBeat.o(205222);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        i = 1;
        continue;
        continue;
      }
      paramJsapiPermissionWrapper = this.Cjy.eCm();
      continue;
      boolean bool1 = false;
      continue;
      boolean bool3 = bool2;
      int i = ((com.tencent.mm.plugin.webview.c.c.a)localObject2).ezX();
      bool3 = bool2;
      if (paramJsapiPermissionWrapper.Cjp.ma(i))
      {
        bool3 = bool2;
        bool1 = ((com.tencent.mm.plugin.webview.c.c.a)localObject2).a(paramJsapiPermissionWrapper, paraml);
        if (!bool1)
        {
          bool3 = bool2;
          if (bs.lr(((com.tencent.mm.plugin.webview.c.c.a)localObject2).ezY(), "handleMPPageAction")) {}
        }
        else
        {
          bool3 = bool2;
          m.b(paramJsapiPermissionWrapper, paraml);
          bool3 = bool2;
          m.a(paraml, bool1);
          bool1 = true;
        }
      }
      else
      {
        bool3 = bool2;
        ac.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paraml.kCH);
        bool3 = bool2;
        paramJsapiPermissionWrapper.Cjq.j(paraml.Ckt, "system:access_denied", null);
        bool1 = false;
        continue;
        bool3 = bool1;
        if ((this.kYt != null) && (paraml != null))
        {
          bool3 = bool1;
          bool1 = this.kYt.a(paraml.type, paraml.kCH, paraml.Ckt, (Bundle)localObject1, localBundle, this.CjB);
          i = 0;
          continue;
        }
        label1949:
        bool2 = false;
        continue;
      }
      label1955:
      bool1 = false;
    }
  }
  
  public static String aBq(String paramString)
  {
    AppMethodBeat.i(205277);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bs.nullAsNil(paramString) });
    AppMethodBeat.o(205277);
    return paramString;
  }
  
  private String aBs(String paramString)
  {
    AppMethodBeat.i(205289);
    String str1 = this.Cjr.getUrl();
    try
    {
      String str2 = n.du(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.apm() + str2;
      ac.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(205289);
      return str2;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      ac.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(205289);
    }
    return null;
  }
  
  private void ezG()
  {
    AppMethodBeat.i(205205);
    this.Cjw = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(205127);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(205127);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!bs.isNullOrNil(paramAnonymousMessage)) {
            f.b(f.this).add(paramAnonymousMessage);
          }
          f.c(f.this);
          AppMethodBeat.o(205127);
          return;
          ac.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(205205);
  }
  
  private Map<String, Object> ezM()
  {
    AppMethodBeat.i(205218);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.Cjy.eCm();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.ma(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.ma(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.ma(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.ma(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.ma(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.ma(219)) {
        localLinkedList.add("sys:record");
      }
      localLinkedList.add("onVoiceRecordEnd");
      localLinkedList.add("onVoicePlayBegin");
      localLinkedList.add("onVoicePlayEnd");
      localLinkedList.add("onLocalImageUploadProgress");
      localLinkedList.add("onImageDownloadProgress");
      localLinkedList.add("onVoiceUploadProgress");
      localLinkedList.add("onVoiceDownloadProgress");
      localLinkedList.add("onVideoUploadProgress");
      localLinkedList.add("onMediaFileUploadProgress");
      localLinkedList.add("menu:setfont");
      localLinkedList.add("menu:haokan");
      localLinkedList.add("topbar:click");
      localLinkedList.add("reportOnLeaveForMP");
      localLinkedList.add("onMPPageAction");
      localLinkedList.add("onMPVideoStateChange");
      localLinkedList.add("onReceiveMPPageData");
      localLinkedList.add("onMPAdWebviewStateChange");
      localLinkedList.add("onScreenShot");
      localLinkedList.add("menu:share:email");
      localLinkedList.add("wxdownload:state_change");
      localLinkedList.add("wxdownload:progress_change");
      localLinkedList.add("hdOnDeviceStateChanged");
      localLinkedList.add("activity:state_change");
      localLinkedList.add("onVideoPlay");
      localLinkedList.add("onVideoPause");
      localLinkedList.add("onVideoEnded");
      localLinkedList.add("onVideoWaiting");
      localLinkedList.add("onVideoBufferUpdate");
      localLinkedList.add("onVideoTimeUpdate");
      localLinkedList.add("onVideoError");
      localLinkedList.add("onVideoLoadedMetaData");
      localLinkedList.add("onEnterFullscreen");
      localLinkedList.add("onExitFullscreen");
      localLinkedList.add("onOrientationsChange");
      localLinkedList.add("onWXDeviceBluetoothStateChange");
      localLinkedList.add("onWXDeviceLanStateChange");
      localLinkedList.add("onWXDeviceBindStateChange");
      localLinkedList.add("onReceiveDataFromWXDevice");
      localLinkedList.add("onScanWXDeviceResult");
      localLinkedList.add("onWXDeviceStateChange");
      localLinkedList.add("onNfcTouch");
      localLinkedList.add("onBeaconMonitoring");
      localLinkedList.add("onBeaconsInRange");
      localLinkedList.add("menu:custom");
      localLinkedList.add("onMenuClick");
      localLinkedList.add("onSearchWAWidgetOpenApp");
      localLinkedList.add("onSearchDataReady");
      localLinkedList.add("onGetPoiInfoReturn");
      localLinkedList.add("onSearchHistoryReady");
      localLinkedList.add("onSearchWAWidgetOnTapCallback");
      localLinkedList.add("onSearchImageListReady");
      localLinkedList.add("onTeachSearchDataReady");
      localLinkedList.add("onSearchGuideDataReady");
      localLinkedList.add("onUxOplogDataReady");
      localLinkedList.add("onSearchInputChange");
      localLinkedList.add("onSearchInputConfirm");
      localLinkedList.add("onSearchSuggestionDataReady");
      localLinkedList.add("onMusicStatusChanged");
      localLinkedList.add("switchToTabSearch");
      localLinkedList.add("onVideoPlayerCallback");
      localLinkedList.add("onSelectContact");
      localLinkedList.add("onSearchWAWidgetAttrChanged");
      localLinkedList.add("onSearchWAWidgetReloadData");
      localLinkedList.add("onSearchWAWidgetReloadDataFinish");
      localLinkedList.add("onSearchWAWidgetStateChange");
      localLinkedList.add("onSearchWAWidgetDataPush");
      localLinkedList.add("emoticonIsChosen");
      localLinkedList.add("onSimilarEmoticonReady");
      localLinkedList.add("onSearchWebQueryReady");
      localLinkedList.add("onPullDownRefresh");
      localLinkedList.add("onPageStateChange");
      localLinkedList.add("onGetKeyboardHeight");
      localLinkedList.add("onGetSmiley");
      localLinkedList.add("onAddShortcutStatus");
      localLinkedList.add("onFocusSearchInput");
      localLinkedList.add("onGetA8KeyUrl");
      localLinkedList.add("deleteAccountSuccess");
      localLinkedList.add("onGetMsgProofItems");
      localLinkedList.add("WNJSHandlerInsert");
      localLinkedList.add("WNJSHandlerMultiInsert");
      localLinkedList.add("WNJSHandlerExportData");
      localLinkedList.add("WNJSHandlerHeaderAndFooterChange");
      localLinkedList.add("WNJSHandlerEditableChange");
      localLinkedList.add("WNJSHandlerEditingChange");
      localLinkedList.add("WNJSHandlerSaveSelectionRange");
      localLinkedList.add("WNJSHandlerLoadSelectionRange");
      localLinkedList.add("onCustomGameMenuClicked");
      localLinkedList.add("showLoading");
      localLinkedList.add("getSearchEmotionDataCallBack");
      localLinkedList.add("onNavigationBarRightButtonClick");
      localLinkedList.add("onSearchActionSheetClick");
      localLinkedList.add("onGetMatchContactList");
      localLinkedList.add("onUiInit");
      localLinkedList.add("onNetWorkChange");
      localLinkedList.add("onMiniProgramData");
      localLinkedList.add("onBackgroundAudioStateChange");
      localLinkedList.add("onArticleReadingBtnClicked");
      if (!bs.gY(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(205218);
    return localHashMap;
  }
  
  private void ezN()
  {
    AppMethodBeat.i(205219);
    while (ezO()) {}
    AppMethodBeat.o(205219);
  }
  
  private boolean ezO()
  {
    AppMethodBeat.i(205220);
    if (bs.gY(this.zuC))
    {
      ac.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(205220);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.kYt.Vt(this.CjB);
      ac.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        ac.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(205220);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException.getMessage());
        bool = false;
      }
      if (this.zuC.size() == 0)
      {
        ac.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(205220);
        return false;
      }
      bool = a((l)this.zuC.remove(0), null);
      AppMethodBeat.o(205220);
    }
    return bool;
  }
  
  /* Error */
  private static boolean ks(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1237
    //   3: invokestatic 227	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 357	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 357	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 318
    //   23: ldc_w 359
    //   26: invokestatic 363	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1237
    //   32: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 365	com/tencent/mm/vfs/e
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 368	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 372	com/tencent/mm/vfs/e:exists	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 375	com/tencent/mm/vfs/e:createNewFile	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1241	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 431	java/lang/String:getBytes	()[B
    //   84: invokevirtual 437	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 439	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 439	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 463	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 448	java/io/OutputStream:close	()V
    //   134: ldc_w 318
    //   137: ldc_w 465
    //   140: aload_0
    //   141: invokestatic 453	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 457	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 467	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1237
    //   153: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 318
    //   162: ldc_w 450
    //   165: aload_0
    //   166: invokestatic 453	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 457	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 460	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 318
    //   178: aload_1
    //   179: ldc_w 259
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1237
    //   192: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 318
    //   201: aload_1
    //   202: ldc_w 259
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 318
    //   221: aload_0
    //   222: ldc_w 259
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 318
    //   237: ldc_w 445
    //   240: invokestatic 363	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 448	java/io/OutputStream:close	()V
    //   251: ldc_w 1237
    //   254: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 318
    //   263: aload_0
    //   264: ldc_w 259
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 448	java/io/OutputStream:close	()V
    //   286: ldc_w 1237
    //   289: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 318
    //   298: aload_1
    //   299: ldc_w 259
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 443	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: goto -23 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString1	String
    //   0	312	1	paramString2	String
    //   64	184	2	localObject1	Object
    //   62	221	3	localObject2	Object
    //   45	85	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	61	158	java/io/IOException
    //   129	134	197	java/io/IOException
    //   65	72	215	java/lang/Exception
    //   78	87	215	java/lang/Exception
    //   93	100	215	java/lang/Exception
    //   106	113	215	java/lang/Exception
    //   119	124	215	java/lang/Exception
    //   247	251	259	java/io/IOException
    //   65	72	277	finally
    //   78	87	277	finally
    //   93	100	277	finally
    //   106	113	277	finally
    //   119	124	277	finally
    //   218	232	277	finally
    //   234	243	277	finally
    //   282	286	294	java/io/IOException
  }
  
  public final void F(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(205254);
    ac.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(205254);
      return;
    }
    this.CjK = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.CjL = 1;; this.CjL = 0)
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205153);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.li(ai.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.fJa();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localc.setCookie(bs.aLP(paramString), str + "=" + (String)paramMap.get(str));
            }
            localException.setCookie(bs.aLP(paramString), "httponly");
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205153);
            return;
          }
          com.tencent.xweb.d.fJc();
          com.tencent.xweb.d.sync();
          ac.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bs.aLP(paramString)) });
          label188:
          f.f(f.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          f.f(f.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (f.g(f.this))
          {
            f.f(f.this).evaluateJavascript(this.CjU, null);
            f.h(f.this);
            f.i(f.this);
          }
          AppMethodBeat.o(205153);
        }
      });
      AppMethodBeat.o(205254);
      return;
    }
  }
  
  public final void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(205231);
    if (!this.Apr)
    {
      ac.w("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205231);
      return;
    }
    ac.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "onMPDotWebviewStateChange");
    localHashMap.put("id", Integer.valueOf(paramInt1));
    localHashMap.put("webviewId", Integer.valueOf(paramInt2));
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPPageAction", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205231);
  }
  
  public final void UD(int paramInt)
  {
    AppMethodBeat.i(205225);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(205225);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = l.a.b("menu:setfont", (Map)localObject, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(205225);
  }
  
  public final Bundle UN(int paramInt)
  {
    AppMethodBeat.i(205236);
    try
    {
      Object localObject = this.Cjr;
      if (localObject == null)
      {
        AppMethodBeat.o(205236);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.CjB);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.Cjr.getUrl());
      localObject = this.kYt.k(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(205236);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(205236);
    }
    return null;
  }
  
  public final void UO(int paramInt)
  {
    AppMethodBeat.i(205251);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205251);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.cc.a.ax(ai.getContext(), paramInt)));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205148);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205148);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205148);
        }
      }
    });
    AppMethodBeat.o(205251);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(205211);
    if (paramString != null) {
      this.Cjw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205199);
          Map localMap = f.O(paramString.split(","));
          String str = f.a(f.this, "hosts");
          if (f.H(str, localMap))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label118;
            }
            try
            {
              f.n(f.this).P(0, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(205199);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ac.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(205199);
              return;
            }
          }
          ac.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(205199);
        }
      });
    }
    AppMethodBeat.o(205211);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    return this.CjA;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(205212);
    if (paramString != null) {
      this.Cjw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205200);
          String str = f.a(f.this, "html");
          if (f.kt(str, paramString))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label108;
            }
            try
            {
              f.n(f.this).P(1, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(205200);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ac.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(205200);
              return;
            }
          }
          ac.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(205200);
        }
      });
    }
    AppMethodBeat.o(205212);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.Cjz;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.Apr = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(205210);
    ac.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.Cjw != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.Cjw.sendMessage(localMessage);
      AppMethodBeat.o(205210);
      return;
    }
    ac.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(205210);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(205274);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(205274);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("reqId", Long.valueOf(paramLong));
    localHashMap.put("json", paramString);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205183);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205183);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205183);
        }
      }
    });
    AppMethodBeat.o(205274);
  }
  
  public final void a(a parama)
  {
    this.CjC = parama;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(205256);
        if (this.CjP.eVs()) {
          this.CjP.au(1000L, 1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.CjO.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.CjO.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.CjN.put(localJSONObject);
              this.CjM.put("beacons", this.CjN);
              this.CjM.put("err_msg", "onBeaconsInRange:ok");
            }
            l.a.a("onBeaconsInRange", this.CjM, this.Cjz, this.CjA);
            AppMethodBeat.o(205256);
            return;
          }
          catch (Exception paramString)
          {
            ac.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[] { paramString.getMessage() });
            continue;
          }
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205240);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(205240);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    localHashMap.put("progress_float", Float.valueOf(paramFloat));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205128);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205128);
          return;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205128);
        }
      }
    });
    AppMethodBeat.o(205240);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(205221);
    paramString = (l)l.a.k(paramString, false, this.CjA).remove(0);
    paramString.Ckv = paramBundle;
    this.fWm.put(paramString.Ckt, paramb);
    a(paramString, paramJsapiPermissionWrapper);
    AppMethodBeat.o(205221);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(205257);
    if (!bs.isNullOrNil(paramString1)) {
      j(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      ezP();
    }
    AppMethodBeat.o(205257);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(205266);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(205266);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(205265);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(205265);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205174);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205174);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205174);
        }
      }
    });
    AppMethodBeat.o(205265);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205269);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(205269);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() != null) {
          try
          {
            localJSONObject.put((String)localEntry.getKey(), new JSONObject(localEntry.getValue().toString()));
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localJSONObject.put((String)localEntry.getKey(), new JSONArray(localEntry.getValue().toString()));
            }
            catch (JSONException localJSONException3)
            {
              try
              {
                localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
              }
              catch (JSONException localJSONException2)
              {
                ac.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
              }
            }
          }
        }
      }
    }
    try
    {
      localJSONObject.put("query", paramString1);
      localJSONObject.put("custom", paramString2);
      localJSONObject.put("tagList", paramJSONArray);
      localJSONObject.put("isBackButtonClick", paramInt);
      localJSONObject.put("sugId", "");
      localJSONObject.put("sugClickType", 0);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205176);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
            AppMethodBeat.o(205176);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205176);
          }
        }
      });
      AppMethodBeat.o(205269);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(205263);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(205263);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205166);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205166);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205166);
        }
      }
    });
    AppMethodBeat.o(205263);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205267);
    localJSONObject = new JSONObject();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      try
      {
        localJSONObject.put("scene", paramString1);
        localJSONObject.put("type", paramString2);
        localJSONObject.put("isSug", paramString3);
        localJSONObject.put("isLocalSug", paramString4);
        localJSONObject.put("sessionId", paramString5);
        b("switchToTabSearch", null, localJSONObject);
        AppMethodBeat.o(205267);
        return true;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
        }
      }
    }
    catch (Exception paramMap)
    {
      ac.printErrStackTrace("MicroMsg.JsApiHandler", paramMap, "", new Object[0]);
    }
  }
  
  public final boolean aAU(final String paramString)
  {
    AppMethodBeat.i(205215);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(205215);
    return true;
  }
  
  public final boolean aAV(String paramString)
  {
    AppMethodBeat.i(205214);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(205214);
      return false;
    }
    boolean bool = x.B(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(205214);
    return bool;
  }
  
  public final void aBi(String paramString)
  {
    this.CjH = paramString;
  }
  
  public final void aBj(String paramString)
  {
    this.CjI = paramString;
  }
  
  public final void aBk(String paramString)
  {
    AppMethodBeat.i(205233);
    if (!this.Apr)
    {
      AppMethodBeat.o(205233);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = l.a.b("onReceiveMPPageData", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205233);
  }
  
  public final void aBl(String paramString)
  {
    AppMethodBeat.i(205234);
    if (!this.Apr)
    {
      AppMethodBeat.o(205234);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPAdWebviewStateChange", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205234);
  }
  
  public final void aBm(final String paramString)
  {
    AppMethodBeat.i(205242);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(205242);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("activity:state_change", localHashMap, this.Cjz, this.CjA);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(205242);
        return;
      }
      catch (Exception paramString)
      {
        ac.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(205242);
        return;
      }
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205134);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(205134);
          return;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205134);
        }
      }
    });
    AppMethodBeat.o(205242);
  }
  
  public final void aBn(final String paramString)
  {
    AppMethodBeat.i(205250);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(205250);
      return;
    }
    if (this.Cjw != null) {
      this.Cjw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205147);
          l locall = new l();
          locall.vUl = new HashMap();
          locall.vUl.put("username", paramString);
          locall.Cku = new JSONObject();
          locall.type = "call";
          locall.Ckt = "";
          locall.kCH = "profile";
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(205147);
        }
      });
    }
    AppMethodBeat.o(205250);
  }
  
  public final void aBo(String paramString)
  {
    AppMethodBeat.i(205253);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205253);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205152);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205152);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205152);
        }
      }
    });
    AppMethodBeat.o(205253);
  }
  
  public final void aBp(String paramString)
  {
    AppMethodBeat.i(205270);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(205270);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205177);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205177);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205177);
        }
      }
    });
    AppMethodBeat.o(205270);
  }
  
  public final void aBr(String paramString)
  {
    AppMethodBeat.i(205282);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205282);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(205282);
      return;
    }
    ac.d("MicroMsg.JsApiHandler", "onNetWorkChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    paramString = ai.getContext();
    if (!ax.isConnected(paramString)) {
      localHashMap.put("networkType", "none");
    }
    if (ax.is2G(paramString))
    {
      ac.i("MicroMsg.JsApiHandler", "onNetWorkChange 2g");
      localHashMap.put("networkType", "2g");
    }
    if (ax.is3G(paramString))
    {
      ac.i("MicroMsg.JsApiHandler", "onNetWorkChange 3g");
      localHashMap.put("networkType", "3g");
    }
    if (ax.is4G(paramString))
    {
      ac.i("MicroMsg.JsApiHandler", "onNetWorkChange 4g");
      localHashMap.put("networkType", "4g");
    }
    if (ax.isWifi(paramString))
    {
      ac.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
      localHashMap.put("networkType", "wifi");
    }
    if (this.kYt != null) {}
    for (;;)
    {
      try
      {
        i = this.kYt.k(110, new Bundle()).getInt("sim_card_type", 0);
        if (i != 0) {
          continue;
        }
        i = 0;
        localHashMap.put("simType", Integer.valueOf(i));
        ac.d("MicroMsg.JsApiHandler", "onNetWorkChange simType=%s", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception paramString)
      {
        int i;
        ac.e("MicroMsg.JsApiHandler", "invokeAsResult ex %s", new Object[] { paramString.getMessage() });
        continue;
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205192);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
            AppMethodBeat.o(205192);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205192);
          }
        }
      });
      AppMethodBeat.o(205282);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void aCo(String paramString)
  {
    AppMethodBeat.i(210489);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(210489);
      return;
    }
    if (!x.aXH(getCurrentUrl()))
    {
      AppMethodBeat.o(210489);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = l.a.b("onMenuClick", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(210489);
  }
  
  public final void b(com.tencent.mm.plugin.webview.stub.e parame)
  {
    this.kYt = parame;
  }
  
  public final void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205227);
    if (!this.Apr)
    {
      AppMethodBeat.o(205227);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString1);
    localHashMap.put("personal_comment_id", Integer.valueOf(paramInt1));
    if ("praiseComment".equals(paramString1))
    {
      localHashMap.put("reply_id", Integer.valueOf(paramInt2));
      localHashMap.put("is_like", Integer.valueOf(paramInt3));
    }
    for (;;)
    {
      paramString1 = l.a.b("onMPPageAction", localHashMap, this.Cjz, this.CjA);
      this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(205227);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(205272);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(205272);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString1);
    localHashMap.put("thumbPath", paramString2);
    localHashMap.put("tab", Integer.valueOf(paramInt1));
    localHashMap.put("asyncDownload", Integer.valueOf(paramInt2));
    localHashMap.put("emojiUrl", paramString3);
    localHashMap.put("aesKey", paramString4);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205179);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205179);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205179);
        }
      }
    });
    AppMethodBeat.o(205272);
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205268);
    if ((!this.Apr) || ((paramMap == null) && (paramJSONObject == null)))
    {
      ac.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(205268);
      return;
    }
    String str1;
    String str2;
    if (paramMap == null)
    {
      str1 = "";
      if (paramJSONObject != null) {
        break label147;
      }
      str2 = "";
      label63:
      ac.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label156;
      }
    }
    label147:
    label156:
    for (paramMap = l.a.b(paramString, paramMap, this.Cjz, this.CjA);; paramMap = l.a.a(paramString, paramJSONObject, this.Cjz, this.CjA))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205175);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(205175);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(205175);
          }
        }
      };
      if (!ap.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(205268);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    ap.f(paramString);
    AppMethodBeat.o(205268);
  }
  
  public final void bt(Map<String, Object> paramMap)
  {
    this.Cjx = paramMap;
  }
  
  public final Bundle bu(Map<String, String> paramMap)
  {
    AppMethodBeat.i(205237);
    Bundle localBundle = new Bundle();
    String str1 = this.Cjr.getUrl();
    String str2;
    if (paramMap != null)
    {
      str2 = (String)paramMap.get("share_report_pre_msg_url");
      if (!bs.isNullOrNil(str2)) {
        break label273;
      }
      str2 = str1;
    }
    label273:
    for (;;)
    {
      Object localObject = (String)paramMap.get("share_report_pre_msg_title");
      if (bs.isNullOrNil((String)localObject)) {
        localObject = this.Cjr.getTitle();
      }
      for (;;)
      {
        String str4 = (String)paramMap.get("share_report_pre_msg_desc");
        String str3 = str4;
        if (bs.isNullOrNil(str4)) {
          str3 = str1;
        }
        localBundle.putString("link", str2);
        localBundle.putString("desc", str3);
        localBundle.putString("img_url", bs.nullAsNil((String)paramMap.get("share_report_pre_msg_icon_url")));
        if (bs.isNullOrNil((String)localObject)) {
          if (!bs.isNullOrNil(str1))
          {
            localObject = Uri.parse(str1);
            paramMap = str1;
            if (((Uri)localObject).getHost() != null) {
              paramMap = ((Uri)localObject).getHost();
            }
          }
        }
        for (;;)
        {
          localBundle.putString("title", paramMap);
          localBundle.putBoolean("use_update_jsapi_data", false);
          AppMethodBeat.o(205237);
          return localBundle;
          localObject = this.Cjr.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = ai.getContext().getString(2131766105);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void bv(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205243);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(205243);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205135);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205135);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205135);
        }
      }
    });
    AppMethodBeat.o(205243);
  }
  
  public final void bw(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205244);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(205244);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = l.a.b("onVoiceRecordEnd", paramMap, this.Cjz, this.CjA);
    ac.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205136);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(205136);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205136);
        }
      }
    });
    AppMethodBeat.o(205244);
  }
  
  public final void bx(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205261);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(205261);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205157);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205157);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205157);
        }
      }
    });
    AppMethodBeat.o(205261);
  }
  
  public final void cf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205209);
    try
    {
      this.kYt.l(paramString, paramBoolean, this.CjB);
      AppMethodBeat.o(205209);
      return;
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(205209);
    }
  }
  
  public final void ct(int paramInt, String paramString)
  {
    AppMethodBeat.i(205271);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(205271);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205178);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205178);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205178);
        }
      }
    });
    AppMethodBeat.o(205271);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(205224);
    this.Apr = false;
    this.zuC.clear();
    this.Cjv.clear();
    this.Cjw = null;
    AppMethodBeat.o(205224);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205284);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205284);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205196);
        try
        {
          if (f.f(f.this) != null) {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.CjY + ")", null);
          }
          AppMethodBeat.o(205196);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(205196);
        }
      }
    });
    AppMethodBeat.o(205284);
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(205288);
    if (ap.isMainThread())
    {
      this.Cjr.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(205288);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205198);
        f.f(f.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(205198);
      }
    });
    AppMethodBeat.o(205288);
  }
  
  public final void ezH()
  {
    AppMethodBeat.i(205207);
    if (this.Cjz != true)
    {
      this.Cjz = true;
      if (!com.tencent.matrix.trace.g.b.cX(this.Cjr.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = bs.Yu(16);; str = this.Cjr.getRandomStr())
    {
      this.CjA = str;
      ac.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.CjA, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(205207);
      return;
    }
  }
  
  public final void ezI()
  {
    AppMethodBeat.i(205208);
    this.Cjz = true;
    this.CjA = bs.Yu(16);
    this.Cjr.setRandomStr(this.CjA);
    ac.i("MicroMsg.JsApiHandler", "js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { this.CjA, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(205208);
  }
  
  public final String ezJ()
  {
    return this.CjA;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a ezK()
  {
    AppMethodBeat.i(205213);
    if (this.CjG == null) {
      this.CjG = new com.tencent.mm.plugin.webview.c.b.a();
    }
    this.CjG.Cjl = this.Cjr;
    com.tencent.mm.plugin.webview.c.b.a locala = this.CjG;
    AppMethodBeat.o(205213);
    return locala;
  }
  
  public final void ezL()
  {
    AppMethodBeat.i(205217);
    ac.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.Apr) });
    if ((this.Cjr != null) && (this.Apr)) {
      this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:attach_runOn3rd_apis", ezM(), this.Cjz, this.CjA) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(205217);
  }
  
  public final void ezP()
  {
    AppMethodBeat.i(205258);
    if (this.Cjw != null) {
      this.Cjw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205155);
          f.e(f.this);
          AppMethodBeat.o(205155);
        }
      });
    }
    AppMethodBeat.o(205258);
  }
  
  public final void ezQ()
  {
    AppMethodBeat.i(205259);
    if (this.zuC != null) {
      this.zuC.clear();
    }
    AppMethodBeat.o(205259);
  }
  
  public final void ezR()
  {
    AppMethodBeat.i(205279);
    ac.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.Apr) });
    if ((this.Cjr != null) && (this.Apr)) {
      this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_all_hosts", new HashMap(), this.Cjz, this.CjA) + ")", null);
    }
    AppMethodBeat.o(205279);
  }
  
  public final void ezS()
  {
    AppMethodBeat.i(205281);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(205281);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205189);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205189);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205189);
        }
      }
    });
    AppMethodBeat.o(205281);
  }
  
  public final void ezT()
  {
    AppMethodBeat.i(205283);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(205283);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = l.a.b("onNavigationBarRightButtonClick", new HashMap(), this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(205283);
  }
  
  public final long ezU()
  {
    AppMethodBeat.i(205285);
    ac.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.CjQ) });
    long l = this.CjQ;
    AppMethodBeat.o(205285);
    return l;
  }
  
  public final com.tencent.mm.plugin.webview.k.k ezV()
  {
    return this.CjR;
  }
  
  public final void ezW()
  {
    AppMethodBeat.i(205286);
    if (!this.Apr)
    {
      AppMethodBeat.o(205286);
      return;
    }
    this.CjR.clear();
    if (this.kYt != null) {
      try
      {
        this.kYt.Vu(this.CjB);
        AppMethodBeat.o(205286);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(205286);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(205232);
    if (!this.Apr)
    {
      AppMethodBeat.o(205232);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    localHashMap.put("currentTime", paramString4);
    localHashMap.put("playedTotalTime", paramString5);
    paramString1 = l.a.b("onMPVideoStateChange", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(205232);
  }
  
  public final void fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(205228);
    if (!this.Apr)
    {
      AppMethodBeat.o(205228);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = l.a.b("onMPPageAction", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205228);
  }
  
  public final void fd(String paramString, int paramInt)
  {
    AppMethodBeat.i(205230);
    if (!this.Apr)
    {
      AppMethodBeat.o(205230);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = l.a.b("onMPPageAction", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205230);
  }
  
  public final void fe(String paramString, int paramInt)
  {
    AppMethodBeat.i(205241);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(205241);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(205241);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205129);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
            AppMethodBeat.o(205129);
            return;
          }
          catch (Exception localException)
          {
            ac.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205129);
          }
        }
      });
      AppMethodBeat.o(205241);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void ff(String paramString, int paramInt)
  {
    AppMethodBeat.i(205245);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(205245);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205139);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205139);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205139);
        }
      }
    });
    AppMethodBeat.o(205245);
  }
  
  public final void fg(String paramString, int paramInt)
  {
    AppMethodBeat.i(205246);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(205246);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205140);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205140);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205140);
        }
      }
    });
    AppMethodBeat.o(205246);
  }
  
  public final void fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(205247);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(205247);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205141);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205141);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205141);
        }
      }
    });
    AppMethodBeat.o(205247);
  }
  
  public final void fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(205248);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(205248);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205142);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205142);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205142);
        }
      }
    });
    AppMethodBeat.o(205248);
  }
  
  public final void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(205249);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(205249);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205143);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205143);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205143);
        }
      }
    });
    AppMethodBeat.o(205249);
  }
  
  final String fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(205255);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = aBq(l.a.b("onGetA8KeyUrl", localHashMap, this.Cjz, this.CjA));
    AppMethodBeat.o(205255);
    return paramString;
  }
  
  public final void fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(205276);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(205276);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205185);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205185);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205185);
        }
      }
    });
    AppMethodBeat.o(205276);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(205275);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(205275);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "%s success, ready", new Object[] { paramString4 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", Integer.valueOf(paramInt));
    localHashMap.put("errMsg", paramString1);
    localHashMap.put("json", paramString2);
    if (!bs.isNullOrNil(paramString3)) {
      localHashMap.put("requestId", paramString3);
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205184);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205184);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(205184);
        }
      }
    });
    AppMethodBeat.o(205275);
  }
  
  public final int getBinderID()
  {
    return this.CjB;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(205223);
    if (this.Cjr == null)
    {
      AppMethodBeat.o(205223);
      return null;
    }
    Context localContext = this.Cjr.getActivityContextIfHas();
    AppMethodBeat.o(205223);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(210490);
    if (this.Cjr == null)
    {
      AppMethodBeat.o(210490);
      return "";
    }
    String str = this.Cjr.getUrl();
    AppMethodBeat.o(210490);
    return str;
  }
  
  public final z getSettings()
  {
    AppMethodBeat.i(205206);
    z localz = this.Cjr.getSettings();
    AppMethodBeat.o(205206);
    return localz;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(205287);
    String str = (String)this.Cjx.get("srcUsername");
    AppMethodBeat.o(205287);
    return str;
  }
  
  public final void i(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(205238);
    if (paramBundle == null)
    {
      ac.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(205238);
      return;
    }
    if (this.Cjw != null) {
      this.Cjw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205201);
          l locall = new l();
          locall.vUl = new HashMap();
          locall.vUl.put("link", paramBundle.getString("link"));
          locall.vUl.put("title", paramBundle.getString("title"));
          locall.vUl.put("desc", paramBundle.getString("desc"));
          locall.Cku = new JSONObject();
          locall.vUl.put("img_url", paramBundle.getString("img_url"));
          locall.vUl.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          locall.type = "call";
          locall.Ckt = "";
          locall.kCH = paramString;
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(205201);
        }
      });
    }
    AppMethodBeat.o(205238);
  }
  
  public final boolean isReady()
  {
    return this.Apr;
  }
  
  public final void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(205239);
    if ((!this.Apr) || (paramBundle == null))
    {
      ac.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(205239);
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    ac.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205202);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205202);
          return;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205202);
        }
      }
    });
    AppMethodBeat.o(205239);
  }
  
  public final void j(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(205260);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      ac.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(205260);
      return;
    }
    if (this.fWm.containsKey(paramString1))
    {
      ((b)this.fWm.get(paramString1)).j(paramString1, paramString2, paramMap);
      this.fWm.remove(paramString1);
      AppMethodBeat.o(205260);
      return;
    }
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(205260);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      ac.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      localHashMap.putAll(paramMap);
    }
    paramString1 = l.a.a(paramString1, localHashMap, this.Cjz, this.CjA);
    ac.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.Cjr != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205156);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(205156);
            return;
          }
          catch (Exception localException)
          {
            ac.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205156);
          }
        }
      };
      if (ap.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(205260);
        return;
      }
      ap.f(paramString1);
    }
    AppMethodBeat.o(205260);
  }
  
  public final void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(205262);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(205262);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205163);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205163);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205163);
        }
      }
    });
    AppMethodBeat.o(205262);
  }
  
  public final void kq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205229);
    if (!this.Apr)
    {
      AppMethodBeat.o(205229);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = l.a.b("onMPPageAction", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(205229);
  }
  
  public final void kr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205264);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(205264);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205170);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", new ValueCallback() {});
          AppMethodBeat.o(205170);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205170);
        }
      }
    });
    AppMethodBeat.o(205264);
  }
  
  public final void m(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(205235);
    ac.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.Apr) });
    if (!this.Apr)
    {
      ac.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      i(bu(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(205235);
      return;
    }
    paramHashMap = UN(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      i(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(205235);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.kYt.ac("scene", "friend", this.CjB);
      AppMethodBeat.o(205235);
      return;
    }
    catch (Exception paramHashMap)
    {
      ac.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(205235);
    }
  }
  
  public final void ui(boolean paramBoolean)
  {
    AppMethodBeat.i(205216);
    this.Apr = paramBoolean;
    ac.i("MicroMsg.JsApiHandler", "js ready now");
    AppMethodBeat.o(205216);
  }
  
  public final void uj(boolean paramBoolean)
  {
    AppMethodBeat.i(205252);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(205252);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205151);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205151);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205151);
        }
      }
    });
    AppMethodBeat.o(205252);
  }
  
  public final void uk(boolean paramBoolean)
  {
    AppMethodBeat.i(205278);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(205278);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205187);
        try
        {
          f.f(f.this).evaluateJavascript(this.CjY, null);
          AppMethodBeat.o(205187);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205187);
        }
      }
    });
    AppMethodBeat.o(205278);
  }
  
  public final void ul(boolean paramBoolean)
  {
    AppMethodBeat.i(205280);
    ac.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.Apr) });
    if ((this.Cjr != null) && (this.kYt != null) && (this.Apr)) {
      if (paramBoolean)
      {
        this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.Cjz, this.CjA) + ")", null);
        AppMethodBeat.o(205280);
        return;
      }
    }
    try
    {
      List localList = this.kYt.eCP();
      Uri localUri = Uri.parse(this.Cjr.getUrl());
      if (localUri != null) {
        ac.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.Cjz, this.CjA) + ")", null);
      }
      AppMethodBeat.o(205280);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void v(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(205226);
    if (!this.Apr)
    {
      AppMethodBeat.o(205226);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = l.a.b("menu:haokan", localHashMap, this.Cjz, this.CjA);
    this.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(205226);
  }
  
  public final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(205273);
    if (!this.Apr)
    {
      ac.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(205273);
      return;
    }
    ac.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205180);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.leF + ")", null);
          AppMethodBeat.o(205180);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205180);
        }
      }
    });
    AppMethodBeat.o(205273);
  }
  
  public static abstract interface a
  {
    public abstract boolean b(l paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.f
 * JD-Core Version:    0.7.0.1
 */