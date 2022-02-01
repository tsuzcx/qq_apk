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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.y;
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

public final class f
  implements b, c, com.tencent.mm.plugin.webview.c.d.a
{
  private static final int ARh;
  private JSONArray ARA;
  private List<String> ARB;
  private av ARC;
  public long ARD;
  public com.tencent.mm.plugin.webview.k.k ARE;
  public MMWebView ARe;
  private final List<String> ARi;
  private ap ARj;
  public Map<String, Object> ARk;
  private g ARl;
  public boolean ARm;
  public String ARn;
  public int ARo;
  private a ARp;
  private Set<String> ARq;
  private boolean ARr;
  public String ARs;
  private com.tencent.mm.plugin.webview.c.b.a ARt;
  public String ARu;
  public String ARv;
  private final List<String> ARw;
  volatile String ARx;
  volatile int ARy;
  private JSONObject ARz;
  HashMap<String, b> fSr;
  public com.tencent.mm.plugin.webview.stub.e kxf;
  public boolean yZR;
  private final LinkedList<l> yhC;
  
  static
  {
    AppMethodBeat.i(189669);
    if (com.tencent.mm.compatible.util.d.lg(19)) {}
    for (int i = 200;; i = 20)
    {
      ARh = i;
      AppMethodBeat.o(189669);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt)
  {
    AppMethodBeat.i(189572);
    this.ARi = new LinkedList();
    this.yhC = new LinkedList();
    this.ARj = null;
    this.yZR = false;
    this.ARm = false;
    this.ARn = "";
    this.ARq = null;
    this.ARr = false;
    this.ARt = null;
    this.fSr = new HashMap();
    this.ARw = new LinkedList();
    this.ARx = null;
    this.ARy = 0;
    this.ARz = new JSONObject();
    this.ARA = new JSONArray();
    this.ARB = new LinkedList();
    this.ARC = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(189523);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(189523);
        return false;
      }
    }, false);
    this.ARD = 0L;
    this.ARE = new com.tencent.mm.plugin.webview.k.k(this);
    this.ARe = paramMMWebView;
    this.ARl = paramg;
    this.ARo = paramInt;
    ekl();
    ad.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(189572);
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(189573);
    this.ARi = new LinkedList();
    this.yhC = new LinkedList();
    this.ARj = null;
    this.yZR = false;
    this.ARm = false;
    this.ARn = "";
    this.ARq = null;
    this.ARr = false;
    this.ARt = null;
    this.fSr = new HashMap();
    this.ARw = new LinkedList();
    this.ARx = null;
    this.ARy = 0;
    this.ARz = new JSONObject();
    this.ARA = new JSONArray();
    this.ARB = new LinkedList();
    this.ARC = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(189523);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(189523);
        return false;
      }
    }, false);
    this.ARD = 0L;
    this.ARE = new com.tencent.mm.plugin.webview.k.k(this);
    this.ARe = paramMMWebView;
    this.ARl = paramg;
    this.ARo = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.ARq = paramg;
    this.ARr = true;
    ekl();
    ad.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramMMWebView.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(189573);
  }
  
  /* Error */
  private static boolean F(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 227	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 357	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 318
    //   20: ldc_w 359
    //   23: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   182: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 318
    //   188: ldc_w 445
    //   191: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   224: invokestatic 460	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 318
    //   230: aload_1
    //   231: ldc_w 259
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   274: invokestatic 467	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   297: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 318
    //   307: aload_0
    //   308: ldc_w 259
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   352: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    AppMethodBeat.i(189589);
    if (paraml == null)
    {
      ad.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(189589);
      return true;
    }
    if ((paraml.kbU == null) || (paraml.uLu == null) || (paraml.type == null) || (this.ARe == null))
    {
      ad.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paraml.kbU + ", params = " + paraml.uLu + ", type = " + paraml.type + ", wv = " + this.ARe);
      AppMethodBeat.o(189589);
      return true;
    }
    if ((this.ARr) && ((this.ARq == null) || (!this.ARq.contains(paraml.kbU))))
    {
      ad.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paraml.kbU });
      com.tencent.e.h.Iye.aN(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189560);
          f.this.h(paraml.ASg, "system:access_denied", null);
          AppMethodBeat.o(189560);
        }
      });
      AppMethodBeat.o(189589);
      return true;
    }
    if ((this.ARk != null) && (this.ARk.get("srcUsername") != null) && (!bt.isNullOrNil(this.ARk.get("srcUsername").toString()))) {
      paraml.uLu.put("src_username", this.ARk.get("srcUsername").toString());
    }
    if ((this.ARk != null) && (this.ARk.get("srcDisplayname") != null) && (!bt.isNullOrNil(this.ARk.get("srcDisplayname").toString()))) {
      paraml.uLu.put("src_displayname", this.ARk.get("srcDisplayname").toString());
    }
    if ((this.ARk != null) && (this.ARk.get("KTemplateId") != null) && (!bt.isNullOrNil(this.ARk.get("KTemplateId").toString()))) {
      paraml.uLu.put("tempalate_id", this.ARk.get("KTemplateId").toString());
    }
    Object localObject1;
    Bundle localBundle;
    if (this.ARk != null)
    {
      paraml.uLu.put("message_id", this.ARk.get("message_id"));
      paraml.uLu.put("message_index", this.ARk.get("message_index"));
      paraml.uLu.put("webview_scene", this.ARk.get("scene"));
      paraml.uLu.put("pay_channel", this.ARk.get("pay_channel"));
      paraml.uLu.put("pay_scene", this.ARk.get("pay_scene"));
      ad.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.ARk.get("pay_package") });
      if (this.ARk.get("pay_package") != null) {
        paraml.uLu.put("pay_packageName", this.ARk.get("pay_package"));
      }
      paraml.uLu.put("stastic_scene", this.ARk.get("stastic_scene"));
      paraml.uLu.put("open_from_scene", this.ARk.get("from_scence"));
      localObject1 = paraml.uLu;
      localBundle = new Bundle();
      localBundle.putString("__jsapi_fw_ext_info_key_current_url", this.ARe.getUrl());
      ((Map)localObject1).put("__jsapi_fw_ext_info", localBundle);
    }
    if ((!paraml.kbU.equals("shareWeibo")) && (!paraml.kbU.equals("openUrlByExtBrowser")) && (!paraml.kbU.equals("openUrlWithExtraWebview")) && (!paraml.kbU.equals("openCustomWebview")) && (!paraml.kbU.equals("openGameWebView")) && (!paraml.kbU.equals("addToEmoticon")) && (!paraml.kbU.equals("shareEmoticon")) && (!paraml.kbU.equals("openGameUrlWithExtraWebView")) && (!paraml.kbU.equals("request")))
    {
      paraml.uLu.put("url", this.ARe.getUrl());
      ad.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.ARe.getUrl());
    }
    if ((paraml.kbU.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kbU.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paraml.kbU.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kbU.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paraml.kbU.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kbU.equalsIgnoreCase("openDesignerProfile")) || (paraml.kbU.equalsIgnoreCase("openDesignerProfileLocal")) || (paraml.kbU.equalsIgnoreCase("getSearchEmotionData")))
    {
      paraml.uLu.put("searchID", Long.valueOf(eky()));
      ad.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(eky()) });
    }
    if (paraml.kbU.equals("request"))
    {
      if (this.ARu != null) {
        paraml.uLu.put("key_request_full_url_query", this.ARu);
      }
      if (this.ARv != null) {
        paraml.uLu.put("key_request_header", this.ARv);
      }
    }
    if (paraml.kbU.equals("imagePreview")) {
      j.a(paraml.uLu, this.ARe);
    }
    if ((paraml.kbU.equals("preVerifyJSAPI")) && (paraml.uLu.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.k.c.erJ();
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
          ((Bundle)localObject1).putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.Cqi);
          ((Bundle)localObject1).putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.Cqj);
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.eBT());
          ((Bundle)localObject1).putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.eBU());
        }
        localObject2 = l.bt(paraml.uLu);
        if (!bt.isNullOrNil(this.ARs)) {
          ((Bundle)localObject2).putString("key_wxapp_id", this.ARs);
        }
        localBundle = new Bundle(3);
        if (paraml.ASi != null) {
          localBundle.putBundle("webCompt", paraml.ASi);
        }
        localBundle.putBundle("compatParams", (Bundle)localObject2);
        if (paraml.ASh != null) {
          localBundle.putString("rawParams", paraml.ASh.toString());
        }
        ad.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paraml.kbU });
        localObject2 = this.ARp;
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
        ad.printErrStackTrace("MicroMsg.JsApiHandler", paramJsapiPermissionWrapper, "", new Object[0]);
        ad.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + paramJsapiPermissionWrapper.getMessage());
        continue;
        AppMethodBeat.o(189589);
        return false;
      }
      try
      {
        this.ARl.emS();
        bool3 = bool2;
        getContext();
        bool1 = bool2;
        if (!bool2)
        {
          bool3 = bool2;
          paramJsapiPermissionWrapper = new d(getContext(), paramJsapiPermissionWrapper, this.kxf, this, this.ARe);
          bool3 = bool2;
          localObject2 = m.ASm;
          bool3 = bool2;
          d.g.b.k.h(paramJsapiPermissionWrapper, "env");
          bool3 = bool2;
          d.g.b.k.h(paraml, "msg");
          bool3 = bool2;
          if (com.tencent.mm.sdk.platformtools.h.DEBUG)
          {
            bool3 = bool2;
            if (1 > ad.getLogLevel())
            {
              bool3 = bool2;
              if (m.ASk.isEmpty()) {
                continue;
              }
              bool1 = true;
              bool3 = bool2;
              Assert.assertTrue("handleMsg jsApis isEmpty", bool1);
            }
          }
          bool3 = bool2;
          if (!m.ASk.containsKey(paraml.kbU)) {
            break label1955;
          }
          bool3 = bool2;
          localObject2 = m.ASk.get(paraml.kbU);
          if (localObject2 == null)
          {
            bool3 = bool2;
            d.g.b.k.fvU();
          }
          bool3 = bool2;
          localObject2 = (com.tencent.mm.plugin.webview.c.c.a)localObject2;
          bool3 = bool2;
          if (!m.ASl.SE(((com.tencent.mm.plugin.webview.c.c.a)localObject2).ekB())) {
            continue;
          }
          bool3 = bool2;
          paramJsapiPermissionWrapper.ARd.h(paraml.ASg, "system:too_frequent", null);
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
        ad.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paraml.kbU });
        i = 1;
        j.emL();
        ad.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paraml.kbU, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          continue;
        }
        AppMethodBeat.o(189589);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        i = 1;
        continue;
        continue;
      }
      paramJsapiPermissionWrapper = this.ARl.emR();
      continue;
      boolean bool1 = false;
      continue;
      boolean bool3 = bool2;
      int i = ((com.tencent.mm.plugin.webview.c.c.a)localObject2).ekB();
      bool3 = bool2;
      if (paramJsapiPermissionWrapper.ARc.mb(i))
      {
        bool3 = bool2;
        bool1 = ((com.tencent.mm.plugin.webview.c.c.a)localObject2).a(paramJsapiPermissionWrapper, paraml);
        if (!bool1)
        {
          bool3 = bool2;
          if (bt.kU(((com.tencent.mm.plugin.webview.c.c.a)localObject2).ekC(), "handleMPPageAction")) {}
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
        ad.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paraml.kbU);
        bool3 = bool2;
        paramJsapiPermissionWrapper.ARd.h(paraml.ASg, "system:access_denied", null);
        bool1 = false;
        continue;
        bool3 = bool1;
        if ((this.kxf != null) && (paraml != null))
        {
          bool3 = bool1;
          bool1 = this.kxf.a(paraml.type, paraml.kbU, paraml.ASg, (Bundle)localObject1, localBundle, this.ARo);
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
  
  public static String avY(String paramString)
  {
    AppMethodBeat.i(189648);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bt.nullAsNil(paramString) });
    AppMethodBeat.o(189648);
    return paramString;
  }
  
  private String awa(String paramString)
  {
    AppMethodBeat.i(189660);
    String str1 = this.ARe.getUrl();
    try
    {
      String str2 = n.dF(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.aim() + str2;
      ad.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(189660);
      return str2;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(189660);
    }
    return null;
  }
  
  private void ekl()
  {
    AppMethodBeat.i(189574);
    this.ARj = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(189496);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(189496);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!bt.isNullOrNil(paramAnonymousMessage)) {
            f.b(f.this).add(paramAnonymousMessage);
          }
          f.c(f.this);
          AppMethodBeat.o(189496);
          return;
          ad.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(189574);
  }
  
  private Map<String, Object> ekq()
  {
    AppMethodBeat.i(189585);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.ARl.emR();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.mb(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.mb(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.mb(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.mb(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.mb(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.mb(219)) {
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
      if (!bt.gL(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(189585);
    return localHashMap;
  }
  
  private void ekr()
  {
    AppMethodBeat.i(189586);
    while (eks()) {}
    AppMethodBeat.o(189586);
  }
  
  private boolean eks()
  {
    AppMethodBeat.i(189587);
    if (bt.gL(this.yhC))
    {
      ad.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(189587);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.kxf.Tl(this.ARo);
      ad.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        ad.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(189587);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException.getMessage());
        bool = false;
      }
      if (this.yhC.size() == 0)
      {
        ad.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(189587);
        return false;
      }
      bool = a((l)this.yhC.remove(0), null);
      AppMethodBeat.o(189587);
    }
    return bool;
  }
  
  /* Error */
  private static boolean jW(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1235
    //   3: invokestatic 227	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 357	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 357	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 318
    //   23: ldc_w 359
    //   26: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1235
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
    //   67: invokestatic 1239	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
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
    //   147: invokestatic 467	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1235
    //   153: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 318
    //   162: ldc_w 450
    //   165: aload_0
    //   166: invokestatic 453	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 457	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 460	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 318
    //   178: aload_1
    //   179: ldc_w 259
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1235
    //   192: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 318
    //   201: aload_1
    //   202: ldc_w 259
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 318
    //   221: aload_0
    //   222: ldc_w 259
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 318
    //   237: ldc_w 445
    //   240: invokestatic 363	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 448	java/io/OutputStream:close	()V
    //   251: ldc_w 1235
    //   254: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 318
    //   263: aload_0
    //   264: ldc_w 259
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 448	java/io/OutputStream:close	()V
    //   286: ldc_w 1235
    //   289: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 318
    //   298: aload_1
    //   299: ldc_w 259
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void E(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(189621);
    ad.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(189621);
      return;
    }
    this.ARx = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.ARy = 1;; this.ARy = 0)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189522);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.kU(aj.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.fqC();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localc.setCookie(bt.aGy(paramString), str + "=" + (String)paramMap.get(str));
            }
            localException.setCookie(bt.aGy(paramString), "httponly");
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(189522);
            return;
          }
          com.tencent.xweb.d.fqE();
          com.tencent.xweb.d.sync();
          ad.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bt.aGy(paramString)) });
          label188:
          f.f(f.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          f.f(f.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (f.g(f.this))
          {
            f.f(f.this).evaluateJavascript(this.ARH, null);
            f.h(f.this);
            f.i(f.this);
          }
          AppMethodBeat.o(189522);
        }
      });
      AppMethodBeat.o(189621);
      return;
    }
  }
  
  public final void M(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(189598);
    if (!this.yZR)
    {
      ad.w("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189598);
      return;
    }
    ad.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "onMPDotWebviewStateChange");
    localHashMap.put("id", Integer.valueOf(paramInt1));
    localHashMap.put("webviewId", Integer.valueOf(paramInt2));
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPPageAction", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189598);
  }
  
  public final Bundle SF(int paramInt)
  {
    AppMethodBeat.i(189603);
    try
    {
      Object localObject = this.ARe;
      if (localObject == null)
      {
        AppMethodBeat.o(189603);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.ARo);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.ARe.getUrl());
      localObject = this.kxf.j(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(189603);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(189603);
    }
    return null;
  }
  
  public final void SG(int paramInt)
  {
    AppMethodBeat.i(189618);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189618);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.cd.a.ar(aj.getContext(), paramInt)));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189517);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189517);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189517);
        }
      }
    });
    AppMethodBeat.o(189618);
  }
  
  public final void Sv(int paramInt)
  {
    AppMethodBeat.i(189592);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(189592);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = l.a.b("menu:setfont", (Map)localObject, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(189592);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(189579);
    if (paramString != null) {
      this.ARj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189568);
          Map localMap = f.O(paramString.split(","));
          String str = f.a(f.this, "hosts");
          if (f.G(str, localMap))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label118;
            }
            try
            {
              f.n(f.this).P(0, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(189568);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ad.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(189568);
              return;
            }
          }
          ad.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(189568);
        }
      });
    }
    AppMethodBeat.o(189579);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String _getDgtVerifyRandomStr()
  {
    return this.ARn;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(189580);
    if (paramString != null) {
      this.ARj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189569);
          String str = f.a(f.this, "html");
          if (f.jX(str, paramString))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label108;
            }
            try
            {
              f.n(f.this).P(1, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(189569);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ad.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(189569);
              return;
            }
          }
          ad.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(189569);
        }
      });
    }
    AppMethodBeat.o(189580);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _isDgtVerifyEnabled()
  {
    return this.ARm;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    this.yZR = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(189578);
    ad.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.ARj != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.ARj.sendMessage(localMessage);
      AppMethodBeat.o(189578);
      return;
    }
    ad.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(189578);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(189645);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(189645);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("reqId", Long.valueOf(paramLong));
    localHashMap.put("json", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189552);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189552);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189552);
        }
      }
    });
    AppMethodBeat.o(189645);
  }
  
  public final void a(a parama)
  {
    this.ARp = parama;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(189623);
        if (this.ARC.eFX()) {
          this.ARC.av(1000L, 1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.ARB.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.ARB.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.ARA.put(localJSONObject);
              this.ARz.put("beacons", this.ARA);
              this.ARz.put("err_msg", "onBeaconsInRange:ok");
            }
            l.a.a("onBeaconsInRange", this.ARz, this.ARm, this.ARn);
            AppMethodBeat.o(189623);
            return;
          }
          catch (Exception paramString)
          {
            ad.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[] { paramString.getMessage() });
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
    AppMethodBeat.i(189607);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(189607);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    localHashMap.put("progress_float", Float.valueOf(paramFloat));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189497);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189497);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189497);
        }
      }
    });
    AppMethodBeat.o(189607);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(189588);
    paramString = (l)l.a.k(paramString, false, this.ARn).remove(0);
    paramString.ASi = paramBundle;
    this.fSr.put(paramString.ASg, paramb);
    a(paramString, paramJsapiPermissionWrapper);
    AppMethodBeat.o(189588);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(189624);
    if (!bt.isNullOrNil(paramString1)) {
      h(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      ekt();
    }
    AppMethodBeat.o(189624);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(189636);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(189636);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(189635);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(189635);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189543);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189543);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189543);
        }
      }
    });
    AppMethodBeat.o(189635);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189639);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(189639);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
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
                ad.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
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
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189545);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
            AppMethodBeat.o(189545);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(189545);
          }
        }
      });
      AppMethodBeat.o(189639);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(189633);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(189633);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189535);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189535);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189535);
        }
      }
    });
    AppMethodBeat.o(189633);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189637);
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
        AppMethodBeat.o(189637);
        return true;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
        }
      }
    }
    catch (Exception paramMap)
    {
      ad.printErrStackTrace("MicroMsg.JsApiHandler", paramMap, "", new Object[0]);
    }
  }
  
  public final void ao(Bundle paramBundle)
  {
    AppMethodBeat.i(189632);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
      AppMethodBeat.o(189632);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramBundle.getString("json"));
    localHashMap.put("searchId", paramBundle.getString("searchId"));
    localHashMap.put("poiId", paramBundle.getString("poiId"));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189533);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189533);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189533);
        }
      }
    });
    AppMethodBeat.o(189632);
  }
  
  public final boolean avC(final String paramString)
  {
    AppMethodBeat.i(189583);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(189583);
    return true;
  }
  
  public final boolean avD(String paramString)
  {
    AppMethodBeat.i(189582);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(189582);
      return false;
    }
    boolean bool = x.A(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(189582);
    return bool;
  }
  
  public final void avQ(String paramString)
  {
    this.ARu = paramString;
  }
  
  public final void avR(String paramString)
  {
    this.ARv = paramString;
  }
  
  public final void avS(String paramString)
  {
    AppMethodBeat.i(189600);
    if (!this.yZR)
    {
      AppMethodBeat.o(189600);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = l.a.b("onReceiveMPPageData", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189600);
  }
  
  public final void avT(String paramString)
  {
    AppMethodBeat.i(189601);
    if (!this.yZR)
    {
      AppMethodBeat.o(189601);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPAdWebviewStateChange", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189601);
  }
  
  public final void avU(final String paramString)
  {
    AppMethodBeat.i(189609);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(189609);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("activity:state_change", localHashMap, this.ARm, this.ARn);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(189609);
        return;
      }
      catch (Exception paramString)
      {
        ad.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(189609);
        return;
      }
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189503);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(189503);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189503);
        }
      }
    });
    AppMethodBeat.o(189609);
  }
  
  public final void avV(final String paramString)
  {
    AppMethodBeat.i(189617);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(189617);
      return;
    }
    if (this.ARj != null) {
      this.ARj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189516);
          l locall = new l();
          locall.uLu = new HashMap();
          locall.uLu.put("username", paramString);
          locall.ASh = new JSONObject();
          locall.type = "call";
          locall.ASg = "";
          locall.kbU = "profile";
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(189516);
        }
      });
    }
    AppMethodBeat.o(189617);
  }
  
  public final void avW(String paramString)
  {
    AppMethodBeat.i(189620);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189620);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189521);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189521);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189521);
        }
      }
    });
    AppMethodBeat.o(189620);
  }
  
  public final void avX(String paramString)
  {
    AppMethodBeat.i(189640);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(189640);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189546);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189546);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189546);
        }
      }
    });
    AppMethodBeat.o(189640);
  }
  
  public final void avZ(String paramString)
  {
    AppMethodBeat.i(189653);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189653);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(189653);
      return;
    }
    ad.d("MicroMsg.JsApiHandler", "onNetWorkChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    paramString = aj.getContext();
    if (!ay.isConnected(paramString)) {
      localHashMap.put("networkType", "none");
    }
    if (ay.is2G(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange 2g");
      localHashMap.put("networkType", "2g");
    }
    if (ay.is3G(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange 3g");
      localHashMap.put("networkType", "3g");
    }
    if (ay.is4G(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange 4g");
      localHashMap.put("networkType", "4g");
    }
    if (ay.isWifi(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
      localHashMap.put("networkType", "wifi");
    }
    if (this.kxf != null) {}
    for (;;)
    {
      try
      {
        i = this.kxf.j(110, new Bundle()).getInt("sim_card_type", 0);
        if (i != 0) {
          continue;
        }
        i = 0;
        localHashMap.put("simType", Integer.valueOf(i));
        ad.d("MicroMsg.JsApiHandler", "onNetWorkChange simType=%s", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception paramString)
      {
        int i;
        ad.e("MicroMsg.JsApiHandler", "invokeAsResult ex %s", new Object[] { paramString.getMessage() });
        continue;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189561);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
            AppMethodBeat.o(189561);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(189561);
          }
        }
      });
      AppMethodBeat.o(189653);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.webview.stub.e parame)
  {
    this.kxf = parame;
  }
  
  public final void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189594);
    if (!this.yZR)
    {
      AppMethodBeat.o(189594);
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
      paramString1 = l.a.b("onMPPageAction", localHashMap, this.ARm, this.ARn);
      this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(189594);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189642);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(189642);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString1);
    localHashMap.put("thumbPath", paramString2);
    localHashMap.put("tab", Integer.valueOf(paramInt1));
    localHashMap.put("asyncDownload", Integer.valueOf(paramInt2));
    localHashMap.put("emojiUrl", paramString3);
    localHashMap.put("aesKey", paramString4);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189548);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189548);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189548);
        }
      }
    });
    AppMethodBeat.o(189642);
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189638);
    if ((!this.yZR) || ((paramMap == null) && (paramJSONObject == null)))
    {
      ad.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(189638);
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
      ad.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label156;
      }
    }
    label147:
    label156:
    for (paramMap = l.a.b(paramString, paramMap, this.ARm, this.ARn);; paramMap = l.a.a(paramString, paramJSONObject, this.ARm, this.ARn))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189544);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(189544);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(189544);
          }
        }
      };
      if (!aq.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(189638);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    aq.f(paramString);
    AppMethodBeat.o(189638);
  }
  
  public final void bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189577);
    try
    {
      this.kxf.l(paramString, paramBoolean, this.ARo);
      AppMethodBeat.o(189577);
      return;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189577);
    }
  }
  
  public final void bo(Map<String, Object> paramMap)
  {
    this.ARk = paramMap;
  }
  
  public final Bundle bp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(189604);
    Bundle localBundle = new Bundle();
    String str1 = this.ARe.getUrl();
    String str2;
    if (paramMap != null)
    {
      str2 = (String)paramMap.get("share_report_pre_msg_url");
      if (!bt.isNullOrNil(str2)) {
        break label273;
      }
      str2 = str1;
    }
    label273:
    for (;;)
    {
      Object localObject = (String)paramMap.get("share_report_pre_msg_title");
      if (bt.isNullOrNil((String)localObject)) {
        localObject = this.ARe.getTitle();
      }
      for (;;)
      {
        String str4 = (String)paramMap.get("share_report_pre_msg_desc");
        String str3 = str4;
        if (bt.isNullOrNil(str4)) {
          str3 = str1;
        }
        localBundle.putString("link", str2);
        localBundle.putString("desc", str3);
        localBundle.putString("img_url", bt.nullAsNil((String)paramMap.get("share_report_pre_msg_icon_url")));
        if (bt.isNullOrNil((String)localObject)) {
          if (!bt.isNullOrNil(str1))
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
          AppMethodBeat.o(189604);
          return localBundle;
          localObject = this.ARe.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = aj.getContext().getString(2131766105);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void bq(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189610);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(189610);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189504);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189504);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189504);
        }
      }
    });
    AppMethodBeat.o(189610);
  }
  
  public final void bq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189630);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189630);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189530);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189530);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetMatchContactList fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189530);
        }
      }
    });
    AppMethodBeat.o(189630);
  }
  
  public final void br(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189611);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(189611);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = l.a.b("onVoiceRecordEnd", paramMap, this.ARm, this.ARn);
    ad.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189505);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(189505);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189505);
        }
      }
    });
    AppMethodBeat.o(189611);
  }
  
  public final void bs(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189628);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(189628);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189526);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189526);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189526);
        }
      }
    });
    AppMethodBeat.o(189628);
  }
  
  public final void cq(int paramInt, String paramString)
  {
    AppMethodBeat.i(189641);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(189641);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189547);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189547);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189547);
        }
      }
    });
    AppMethodBeat.o(189641);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(189591);
    this.yZR = false;
    this.yhC.clear();
    this.ARi.clear();
    this.ARj = null;
    AppMethodBeat.o(189591);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189655);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189655);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189565);
        try
        {
          if (f.f(f.this) != null) {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ARL + ")", null);
          }
          AppMethodBeat.o(189565);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(189565);
        }
      }
    });
    AppMethodBeat.o(189655);
  }
  
  public final void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(189595);
    if (!this.yZR)
    {
      AppMethodBeat.o(189595);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = l.a.b("onMPPageAction", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189595);
  }
  
  public final void eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(189597);
    if (!this.yZR)
    {
      AppMethodBeat.o(189597);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = l.a.b("onMPPageAction", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189597);
  }
  
  public final void eW(String paramString, int paramInt)
  {
    AppMethodBeat.i(189608);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(189608);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(189608);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189498);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
            AppMethodBeat.o(189498);
            return;
          }
          catch (Exception localException)
          {
            ad.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(189498);
          }
        }
      });
      AppMethodBeat.o(189608);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(189612);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(189612);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189508);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189508);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189508);
        }
      }
    });
    AppMethodBeat.o(189612);
  }
  
  public final void eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(189613);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(189613);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189509);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189509);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189509);
        }
      }
    });
    AppMethodBeat.o(189613);
  }
  
  public final void eZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(189614);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(189614);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189510);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189510);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189510);
        }
      }
    });
    AppMethodBeat.o(189614);
  }
  
  public final void ekA()
  {
    AppMethodBeat.i(189657);
    if (!this.yZR)
    {
      AppMethodBeat.o(189657);
      return;
    }
    this.ARE.clear();
    if (this.kxf != null) {
      try
      {
        this.kxf.Tm(this.ARo);
        AppMethodBeat.o(189657);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(189657);
  }
  
  public final void ekm()
  {
    AppMethodBeat.i(189576);
    if (this.ARm != true)
    {
      this.ARm = true;
      if (!com.tencent.matrix.trace.g.b.dq(this.ARe.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = bt.Wl(16);; str = this.ARe.getRandomStr())
    {
      this.ARn = str;
      ad.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.ARn, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(189576);
      return;
    }
  }
  
  public final String ekn()
  {
    return this.ARn;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eko()
  {
    AppMethodBeat.i(189581);
    if (this.ARt == null) {
      this.ARt = new com.tencent.mm.plugin.webview.c.b.a();
    }
    this.ARt.AQY = this.ARe;
    com.tencent.mm.plugin.webview.c.b.a locala = this.ARt;
    AppMethodBeat.o(189581);
    return locala;
  }
  
  public final void ekp()
  {
    AppMethodBeat.i(189584);
    ad.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.yZR) });
    if ((this.ARe != null) && (this.yZR)) {
      this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:attach_runOn3rd_apis", ekq(), this.ARm, this.ARn) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(189584);
  }
  
  public final void ekt()
  {
    AppMethodBeat.i(189625);
    if (this.ARj != null) {
      this.ARj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189524);
          f.e(f.this);
          AppMethodBeat.o(189524);
        }
      });
    }
    AppMethodBeat.o(189625);
  }
  
  public final void eku()
  {
    AppMethodBeat.i(189626);
    if (this.yhC != null) {
      this.yhC.clear();
    }
    AppMethodBeat.o(189626);
  }
  
  public final void ekv()
  {
    AppMethodBeat.i(189650);
    ad.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.yZR) });
    if ((this.ARe != null) && (this.yZR)) {
      this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_all_hosts", new HashMap(), this.ARm, this.ARn) + ")", null);
    }
    AppMethodBeat.o(189650);
  }
  
  public final void ekw()
  {
    AppMethodBeat.i(189652);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(189652);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189558);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189558);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189558);
        }
      }
    });
    AppMethodBeat.o(189652);
  }
  
  public final void ekx()
  {
    AppMethodBeat.i(189654);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(189654);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = l.a.b("onNavigationBarRightButtonClick", new HashMap(), this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(189654);
  }
  
  public final long eky()
  {
    AppMethodBeat.i(189656);
    ad.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.ARD) });
    long l = this.ARD;
    AppMethodBeat.o(189656);
    return l;
  }
  
  public final com.tencent.mm.plugin.webview.k.k ekz()
  {
    return this.ARE;
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(189659);
    if (aq.isMainThread())
    {
      this.ARe.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(189659);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189567);
        f.f(f.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(189567);
      }
    });
    AppMethodBeat.o(189659);
  }
  
  public final void f(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(189646);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(189646);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "%s success, ready", new Object[] { paramString4 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", Integer.valueOf(paramInt));
    localHashMap.put("errMsg", paramString1);
    localHashMap.put("json", paramString2);
    if (!bt.isNullOrNil(paramString3)) {
      localHashMap.put("requestId", paramString3);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189553);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189553);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(189553);
        }
      }
    });
    AppMethodBeat.o(189646);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(189599);
    if (!this.yZR)
    {
      AppMethodBeat.o(189599);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    localHashMap.put("currentTime", paramString4);
    localHashMap.put("playedTotalTime", paramString5);
    paramString1 = l.a.b("onMPVideoStateChange", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(189599);
  }
  
  public final void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(189615);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(189615);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189511);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189511);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189511);
        }
      }
    });
    AppMethodBeat.o(189615);
  }
  
  public final void fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(189616);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(189616);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189512);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189512);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189512);
        }
      }
    });
    AppMethodBeat.o(189616);
  }
  
  final String fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(189622);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = avY(l.a.b("onGetA8KeyUrl", localHashMap, this.ARm, this.ARn));
    AppMethodBeat.o(189622);
    return paramString;
  }
  
  public final void fd(String paramString, int paramInt)
  {
    AppMethodBeat.i(189647);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(189647);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189554);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189554);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189554);
        }
      }
    });
    AppMethodBeat.o(189647);
  }
  
  public final int getBinderID()
  {
    return this.ARo;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(189590);
    if (this.ARe == null)
    {
      AppMethodBeat.o(189590);
      return null;
    }
    Context localContext = this.ARe.getActivityContextIfHas();
    AppMethodBeat.o(189590);
    return localContext;
  }
  
  public final y getSettings()
  {
    AppMethodBeat.i(189575);
    y localy = this.ARe.getSettings();
    AppMethodBeat.o(189575);
    return localy;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(189658);
    String str = (String)this.ARk.get("srcUsername");
    AppMethodBeat.o(189658);
    return str;
  }
  
  public final void h(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(189605);
    if (paramBundle == null)
    {
      ad.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(189605);
      return;
    }
    if (this.ARj != null) {
      this.ARj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189570);
          l locall = new l();
          locall.uLu = new HashMap();
          locall.uLu.put("link", paramBundle.getString("link"));
          locall.uLu.put("title", paramBundle.getString("title"));
          locall.uLu.put("desc", paramBundle.getString("desc"));
          locall.ASh = new JSONObject();
          locall.uLu.put("img_url", paramBundle.getString("img_url"));
          locall.uLu.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          locall.type = "call";
          locall.ASg = "";
          locall.kbU = paramString;
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(189570);
        }
      });
    }
    AppMethodBeat.o(189605);
  }
  
  public final void h(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(189627);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      ad.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(189627);
      return;
    }
    if (this.fSr.containsKey(paramString1))
    {
      ((b)this.fSr.get(paramString1)).h(paramString1, paramString2, paramMap);
      this.fSr.remove(paramString1);
      AppMethodBeat.o(189627);
      return;
    }
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(189627);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      ad.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      localHashMap.putAll(paramMap);
    }
    paramString1 = l.a.a(paramString1, localHashMap, this.ARm, this.ARn);
    ad.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.ARe != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189525);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(189525);
            return;
          }
          catch (Exception localException)
          {
            ad.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(189525);
          }
        }
      };
      if (aq.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(189627);
        return;
      }
      aq.f(paramString1);
    }
    AppMethodBeat.o(189627);
  }
  
  public final void i(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(189606);
    if ((!this.yZR) || (paramBundle == null))
    {
      ad.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(189606);
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    ad.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189571);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189571);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189571);
        }
      }
    });
    AppMethodBeat.o(189606);
  }
  
  public final boolean isReady()
  {
    return this.yZR;
  }
  
  public final void it(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189629);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
      AppMethodBeat.o(189629);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", Integer.valueOf(paramInt1));
    localHashMap.put("actionSheetId", Integer.valueOf(paramInt2));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189527);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189527);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189527);
        }
      }
    });
    AppMethodBeat.o(189629);
  }
  
  public final void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(189631);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(189631);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189532);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189532);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189532);
        }
      }
    });
    AppMethodBeat.o(189631);
  }
  
  public final void jU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189596);
    if (!this.yZR)
    {
      AppMethodBeat.o(189596);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = l.a.b("onMPPageAction", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(189596);
  }
  
  public final void jV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189634);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(189634);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189539);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", new ValueCallback() {});
          AppMethodBeat.o(189539);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189539);
        }
      }
    });
    AppMethodBeat.o(189634);
  }
  
  public final void l(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(189602);
    ad.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.yZR) });
    if (!this.yZR)
    {
      ad.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      h(bp(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(189602);
      return;
    }
    paramHashMap = SF(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      h(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(189602);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.kxf.ab("scene", "friend", this.ARo);
      AppMethodBeat.o(189602);
      return;
    }
    catch (Exception paramHashMap)
    {
      ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(189602);
    }
  }
  
  public final void q(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189644);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
      AppMethodBeat.o(189644);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt1));
    localHashMap.put("isExpired", Integer.valueOf(paramInt2));
    localHashMap.put("isPreload", Integer.valueOf(paramInt3));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189551);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189551);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189551);
        }
      }
    });
    AppMethodBeat.o(189644);
  }
  
  public final void t(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189593);
    if (!this.yZR)
    {
      AppMethodBeat.o(189593);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = l.a.b("menu:haokan", localHashMap, this.ARm, this.ARn);
    this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(189593);
  }
  
  public final void th(boolean paramBoolean)
  {
    AppMethodBeat.i(189619);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(189619);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189520);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189520);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189520);
        }
      }
    });
    AppMethodBeat.o(189619);
  }
  
  public final void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(189649);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(189649);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189556);
        try
        {
          f.f(f.this).evaluateJavascript(this.ARL, null);
          AppMethodBeat.o(189556);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189556);
        }
      }
    });
    AppMethodBeat.o(189649);
  }
  
  public final void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(189651);
    ad.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.yZR) });
    if ((this.ARe != null) && (this.kxf != null) && (this.yZR)) {
      if (paramBoolean)
      {
        this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.ARm, this.ARn) + ")", null);
        AppMethodBeat.o(189651);
        return;
      }
    }
    try
    {
      List localList = this.kxf.enw();
      Uri localUri = Uri.parse(this.ARe.getUrl());
      if (localUri != null) {
        ad.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.ARm, this.ARn) + ")", null);
      }
      AppMethodBeat.o(189651);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void u(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189643);
    if (!this.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(189643);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189549);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.kDn + ")", null);
          AppMethodBeat.o(189549);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(189549);
        }
      }
    });
    AppMethodBeat.o(189643);
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