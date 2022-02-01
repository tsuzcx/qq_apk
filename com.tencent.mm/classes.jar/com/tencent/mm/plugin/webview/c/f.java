package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import d.g.b.p;
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
  private static final int Eew;
  public boolean BZx;
  private final LinkedList<l> BdZ;
  public Map<String, Object> EeA;
  private g EeB;
  public boolean EeC;
  public boolean EeD;
  public int EeE;
  private a EeF;
  private Set<String> EeG;
  private boolean EeH;
  public String EeI;
  private com.tencent.mm.plugin.webview.c.b.a EeJ;
  private JsapiPermissionWrapper EeK;
  private Bundle EeL;
  private boolean EeM;
  public String EeN;
  public String EeO;
  private final List<String> EeP;
  volatile String EeQ;
  volatile int EeR;
  private JSONObject EeS;
  private JSONArray EeT;
  private List<String> EeU;
  private aw EeV;
  public long EeW;
  public k EeX;
  public MMWebView Eet;
  private Context Eex;
  private final List<String> Eey;
  private aq Eez;
  HashMap<String, b> gsk;
  public com.tencent.mm.plugin.webview.stub.e lzT;
  public String vVT;
  
  static
  {
    AppMethodBeat.i(213729);
    if (com.tencent.mm.compatible.util.d.lB(19)) {}
    for (int i = 200;; i = 20)
    {
      Eew = i;
      AppMethodBeat.o(213729);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt)
  {
    AppMethodBeat.i(213627);
    this.Eey = new LinkedList();
    this.BdZ = new LinkedList();
    this.Eez = null;
    this.BZx = false;
    this.EeC = false;
    this.vVT = "";
    this.EeD = false;
    this.EeG = null;
    this.EeH = false;
    this.EeJ = null;
    this.gsk = new HashMap();
    this.EeM = false;
    this.EeP = new LinkedList();
    this.EeQ = null;
    this.EeR = 0;
    this.EeS = new JSONObject();
    this.EeT = new JSONArray();
    this.EeU = new LinkedList();
    this.EeV = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213577);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(213577);
        return false;
      }
    }, false);
    this.EeW = 0L;
    this.EeX = new k(this);
    this.Eet = paramMMWebView;
    this.EeB = paramg;
    this.EeE = paramInt;
    eSg();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      ae.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213627);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(213628);
    this.Eey = new LinkedList();
    this.BdZ = new LinkedList();
    this.Eez = null;
    this.BZx = false;
    this.EeC = false;
    this.vVT = "";
    this.EeD = false;
    this.EeG = null;
    this.EeH = false;
    this.EeJ = null;
    this.gsk = new HashMap();
    this.EeM = false;
    this.EeP = new LinkedList();
    this.EeQ = null;
    this.EeR = 0;
    this.EeS = new JSONObject();
    this.EeT = new JSONArray();
    this.EeU = new LinkedList();
    this.EeV = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213577);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(213577);
        return false;
      }
    }, false);
    this.EeW = 0L;
    this.EeX = new k(this);
    this.Eet = paramMMWebView;
    this.EeB = paramg;
    this.EeE = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.EeG = paramg;
    this.EeH = true;
    eSg();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      ae.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213628);
      return;
    }
  }
  
  /* Error */
  private static boolean I(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 366
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 372	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 334
    //   20: ldc_w 374
    //   23: invokestatic 378	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 366
    //   29: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 380	com/tencent/mm/vfs/k
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 383	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 387	com/tencent/mm/vfs/k:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 390	com/tencent/mm/vfs/k:createNewFile	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 396	com/tencent/mm/vfs/o:d	(Lcom/tencent/mm/vfs/k;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 402 1 0
    //   77: invokeinterface 408 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 413 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 417 1 0
    //   101: checkcast 419	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 423 2 0
    //   114: checkcast 338	java/lang/Integer
    //   117: invokevirtual 426	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 428	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 435
    //   136: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 446	java/lang/String:getBytes	()[B
    //   150: invokevirtual 452	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 454	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 454	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 334
    //   174: aload_1
    //   175: ldc_w 271
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 334
    //   188: ldc_w 460
    //   191: invokestatic 378	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 463	java/io/OutputStream:close	()V
    //   202: ldc_w 366
    //   205: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 334
    //   214: ldc_w 465
    //   217: aload_0
    //   218: invokestatic 468	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 475	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 334
    //   230: aload_1
    //   231: ldc_w 271
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 366
    //   244: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 478	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 463	java/io/OutputStream:close	()V
    //   261: ldc_w 334
    //   264: ldc_w 480
    //   267: aload_0
    //   268: invokestatic 468	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 482	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 366
    //   280: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 334
    //   289: aload_1
    //   290: ldc_w 271
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 334
    //   307: aload_0
    //   308: ldc_w 271
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 463	java/io/OutputStream:close	()V
    //   332: ldc_w 366
    //   335: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 334
    //   344: aload_1
    //   345: ldc_w 271
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private boolean a(final l paraml, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(213649);
    if (paraml == null)
    {
      ae.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(213649);
      return true;
    }
    if ((paraml.lcx == null) || (paraml.xqN == null) || (paraml.type == null) || ((!this.EeM) && (this.Eet == null)))
    {
      ae.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paraml.lcx + ", params = " + paraml.xqN + ", type = " + paraml.type + ", wv = " + this.Eet);
      AppMethodBeat.o(213649);
      return true;
    }
    if ((this.EeH) && ((this.EeG == null) || (!this.EeG.contains(paraml.lcx))))
    {
      ae.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paraml.lcx });
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213623);
          f.this.i(paraml.Efy, "system:access_denied", null);
          AppMethodBeat.o(213623);
        }
      });
      AppMethodBeat.o(213649);
      return true;
    }
    if (paramBundle != null) {
      paraml.EeL = paramBundle;
    }
    if (paramb != null) {
      this.gsk.put(paraml.Efy, paramb);
    }
    if ((this.EeA != null) && (this.EeA.get("srcUsername") != null) && (!bu.isNullOrNil(this.EeA.get("srcUsername").toString()))) {
      paraml.xqN.put("src_username", this.EeA.get("srcUsername").toString());
    }
    if ((this.EeA != null) && (this.EeA.get("srcDisplayname") != null) && (!bu.isNullOrNil(this.EeA.get("srcDisplayname").toString()))) {
      paraml.xqN.put("src_displayname", this.EeA.get("srcDisplayname").toString());
    }
    if ((this.EeA != null) && (this.EeA.get("KTemplateId") != null) && (!bu.isNullOrNil(this.EeA.get("KTemplateId").toString()))) {
      paraml.xqN.put("tempalate_id", this.EeA.get("KTemplateId").toString());
    }
    if (this.EeA != null)
    {
      paraml.xqN.put("message_id", this.EeA.get("message_id"));
      paraml.xqN.put("message_index", this.EeA.get("message_index"));
      paraml.xqN.put("webview_scene", this.EeA.get("scene"));
      paraml.xqN.put("pay_channel", this.EeA.get("pay_channel"));
      paraml.xqN.put("pay_scene", this.EeA.get("pay_scene"));
      ae.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.EeA.get("pay_package") });
      if (this.EeA.get("pay_package") != null) {
        paraml.xqN.put("pay_packageName", this.EeA.get("pay_package"));
      }
      paraml.xqN.put("stastic_scene", this.EeA.get("stastic_scene"));
      paraml.xqN.put("open_from_scene", this.EeA.get("from_scence"));
      paramBundle = paraml.xqN;
      paramb = new Bundle();
      paramb.putString("__jsapi_fw_ext_info_key_current_url", this.Eet.getUrl());
      paramBundle.put("__jsapi_fw_ext_info", paramb);
    }
    if ((this.Eet != null) && (!paraml.lcx.equals("shareWeibo")) && (!paraml.lcx.equals("openUrlByExtBrowser")) && (!paraml.lcx.equals("log")) && (!paraml.lcx.equals("openUrlWithExtraWebview")) && (!paraml.lcx.equals("openCustomWebview")) && (!paraml.lcx.equals("openGameWebView")) && (!paraml.lcx.equals("addToEmoticon")) && (!paraml.lcx.equals("shareEmoticon")) && (!paraml.lcx.equals("openGameUrlWithExtraWebView")) && (!paraml.lcx.equals("request")))
    {
      paraml.xqN.put("url", this.Eet.getUrl());
      ae.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.Eet.getUrl());
    }
    if ((paraml.lcx.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.lcx.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paraml.lcx.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.lcx.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paraml.lcx.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.lcx.equalsIgnoreCase("openDesignerProfile")) || (paraml.lcx.equalsIgnoreCase("openDesignerProfileLocal")) || (paraml.lcx.equalsIgnoreCase("getSearchEmotionData")))
    {
      paraml.xqN.put("searchID", Long.valueOf(eSt()));
      ae.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(eSt()) });
    }
    if (paraml.lcx.equals("request"))
    {
      if (this.EeN != null) {
        paraml.xqN.put("key_request_full_url_query", this.EeN);
      }
      if (this.EeO != null) {
        paraml.xqN.put("key_request_header", this.EeO);
      }
    }
    if (paraml.lcx.equals("imagePreview")) {
      com.tencent.mm.plugin.webview.modeltools.j.a(paraml.xqN, this.Eet);
    }
    if ((paraml.lcx.equals("preVerifyJSAPI")) && (paraml.xqN.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.k.c.eZO();
    }
    bool1 = false;
    boolean bool3 = false;
    if (paramJsapiPermissionWrapper != null) {}
    for (;;)
    {
      bool2 = bool1;
      try
      {
        localBundle1 = new Bundle();
        if (paramJsapiPermissionWrapper != null)
        {
          bool2 = bool1;
          localBundle1.putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.FGf);
          bool2 = bool1;
          localBundle1.putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.FGg);
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.fki());
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.fkj());
        }
        bool2 = bool1;
        paramb = l.bH(paraml.xqN);
        bool2 = bool1;
        if (!bu.isNullOrNil(this.EeI))
        {
          bool2 = bool1;
          paramb.putString("key_wxapp_id", this.EeI);
        }
        bool2 = bool1;
        localBundle2 = new Bundle(3);
        paramBundle = paramb;
        bool2 = bool1;
        if (paraml.EeL != null)
        {
          bool2 = bool1;
          localBundle2.putBundle("jsEngine", paraml.EeL);
          paramBundle = paramb;
          if (paramb == null)
          {
            bool2 = bool1;
            paramBundle = new Bundle();
          }
        }
        bool2 = bool1;
        localBundle2.putBundle("compatParams", paramBundle);
        bool2 = bool1;
        if (paraml.Efz != null)
        {
          bool2 = bool1;
          localBundle2.putString("rawParams", paraml.Efz.toString());
        }
        bool2 = bool1;
        ae.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paraml.lcx });
        bool2 = bool1;
        if (this.EeF != null)
        {
          bool2 = bool1;
          bool3 = this.EeF.b(paraml);
        }
        bool2 = bool3;
        if (!this.EeM)
        {
          bool2 = bool3;
          this.EeB.eUT();
          bool2 = bool3;
          getContext();
        }
        bool1 = bool3;
        if (bool3) {
          break label1736;
        }
        bool2 = bool3;
        paramJsapiPermissionWrapper = new d(getContext(), paramJsapiPermissionWrapper, this.lzT, this, this.Eet);
        bool2 = bool3;
        paramBundle = m.EfD;
        bool2 = bool3;
        p.h(paramJsapiPermissionWrapper, "env");
        bool2 = bool3;
        p.h(paraml, "msg");
        bool2 = bool3;
        if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
          break label1632;
        }
        bool2 = bool3;
        if (1 <= ae.getLogLevel()) {
          break label1632;
        }
        bool2 = bool3;
        if (m.EfB.isEmpty()) {
          break label2099;
        }
        bool1 = true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        for (;;)
        {
          Bundle localBundle1;
          Bundle localBundle2;
          int i = 0;
          bool1 = bool2;
          ae.printErrStackTrace("MicroMsg.JsApiHandler", paramJsapiPermissionWrapper, "", new Object[0]);
          ae.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + paramJsapiPermissionWrapper.getMessage());
          continue;
          bool1 = false;
          continue;
          bool2 = bool1;
          if ((this.lzT != null) && (paraml != null))
          {
            bool2 = bool1;
            bool1 = this.lzT.a(paraml.type, paraml.lcx, paraml.Efy, localBundle1, localBundle2, this.EeE);
            i = 0;
            continue;
            AppMethodBeat.o(213649);
            return false;
          }
          else
          {
            bool1 = false;
          }
        }
      }
      bool2 = bool3;
      Assert.assertTrue("handleMsg jsApis isEmpty", bool1);
      label1632:
      bool2 = bool3;
      if (!m.EfB.containsKey(paraml.lcx)) {
        break label2022;
      }
      bool2 = bool3;
      paramBundle = m.EfB.get(paraml.lcx);
      if (paramBundle == null)
      {
        bool2 = bool3;
        p.gkB();
      }
      bool2 = bool3;
      paramBundle = (com.tencent.mm.plugin.webview.c.c.a)paramBundle;
      bool2 = bool3;
      if (!m.EfC.Xk(paramBundle.eSw())) {
        break;
      }
      bool2 = bool3;
      paramJsapiPermissionWrapper.DQe.i(paraml.Efy, "system:too_frequent", null);
      bool2 = bool3;
      m.a(paramJsapiPermissionWrapper, paramBundle);
      bool1 = true;
      label1736:
      if (!bool1) {
        break label2028;
      }
      i = 1;
      try
      {
        ae.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paraml.lcx });
        i = 1;
        com.tencent.mm.plugin.webview.modeltools.j.eUM();
        ae.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paraml.lcx, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          break label2084;
        }
        AppMethodBeat.o(213649);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        for (;;) {}
      }
      bool2 = bool1;
      paramJsapiPermissionWrapper = this.EeB.eUS();
    }
    bool1 = false;
    bool2 = bool3;
    i = paramBundle.eSw();
    bool2 = bool3;
    if (paramJsapiPermissionWrapper.DRw.mC(i))
    {
      bool2 = bool3;
      bool1 = paramBundle.a(paramJsapiPermissionWrapper, paraml);
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = bool3;
        if (bu.lX(paramBundle.eSx(), "handleMPPageAction")) {
          break label2022;
        }
      }
      bool2 = bool3;
      m.b(paramJsapiPermissionWrapper, paraml);
      bool2 = bool3;
      m.a(paraml, bool1);
      bool1 = true;
      break;
      bool2 = bool3;
      ae.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paraml.lcx);
      bool2 = bool3;
      paramJsapiPermissionWrapper.DQe.i(paraml.Efy, "system:access_denied", null);
    }
  }
  
  public static String aIg(String paramString)
  {
    AppMethodBeat.i(213706);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bu.nullAsNil(paramString) });
    AppMethodBeat.o(213706);
    return paramString;
  }
  
  private String aIj(String paramString)
  {
    AppMethodBeat.i(213720);
    String str1 = this.Eet.getUrl();
    try
    {
      String str2 = n.ev(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.asp() + str2;
      ae.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(213720);
      return str2;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      ae.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(213720);
    }
    return null;
  }
  
  private void eSg()
  {
    AppMethodBeat.i(213629);
    this.Eez = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(213549);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(213549);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!bu.isNullOrNil(paramAnonymousMessage)) {
            f.b(f.this).add(paramAnonymousMessage);
          }
          f.c(f.this);
          AppMethodBeat.o(213549);
          return;
          ae.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(213629);
  }
  
  private Map<String, Object> eSn()
  {
    AppMethodBeat.i(213644);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.EeB.eUS();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.mC(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.mC(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.mC(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.mC(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.mC(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.mC(219)) {
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
      localLinkedList.add("onPlayerProcessStateChanged");
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
      localLinkedList.add("onChatSearchDataReady");
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
      if (!bu.ht(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(213644);
    return localHashMap;
  }
  
  private void eSo()
  {
    AppMethodBeat.i(213645);
    while (eSp()) {}
    AppMethodBeat.o(213645);
  }
  
  private boolean eSp()
  {
    AppMethodBeat.i(213646);
    if (bu.ht(this.BdZ))
    {
      ae.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(213646);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.lzT.XO(this.EeE);
      ae.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        ae.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(213646);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException.getMessage());
        bool = false;
      }
      if (this.BdZ.size() == 0)
      {
        ae.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(213646);
        return false;
      }
      bool = a((l)this.BdZ.remove(0), null, null, null);
      AppMethodBeat.o(213646);
    }
    return bool;
  }
  
  /* Error */
  private static boolean kX(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1255
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 372	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 372	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 334
    //   23: ldc_w 374
    //   26: invokestatic 378	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1255
    //   32: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 380	com/tencent/mm/vfs/k
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 383	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 387	com/tencent/mm/vfs/k:exists	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 390	com/tencent/mm/vfs/k:createNewFile	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1259	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 446	java/lang/String:getBytes	()[B
    //   84: invokevirtual 452	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 454	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 454	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 478	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 463	java/io/OutputStream:close	()V
    //   134: ldc_w 334
    //   137: ldc_w 480
    //   140: aload_0
    //   141: invokestatic 468	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 482	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1255
    //   153: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 334
    //   162: ldc_w 465
    //   165: aload_0
    //   166: invokestatic 468	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 475	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 334
    //   178: aload_1
    //   179: ldc_w 271
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1255
    //   192: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 334
    //   201: aload_1
    //   202: ldc_w 271
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 334
    //   221: aload_0
    //   222: ldc_w 271
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 334
    //   237: ldc_w 460
    //   240: invokestatic 378	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 463	java/io/OutputStream:close	()V
    //   251: ldc_w 1255
    //   254: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 334
    //   263: aload_0
    //   264: ldc_w 271
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 463	java/io/OutputStream:close	()V
    //   286: ldc_w 1255
    //   289: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 334
    //   298: aload_1
    //   299: ldc_w 271
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 458	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void H(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(213683);
    ae.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213683);
      return;
    }
    this.EeQ = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.EeR = 1;; this.EeR = 0)
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213576);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.lB(ak.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.geY();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localc.setCookie(bu.aST(paramString), str + "=" + (String)paramMap.get(str));
            }
            localException.setCookie(bu.aST(paramString), "httponly");
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213576);
            return;
          }
          com.tencent.xweb.d.gfa();
          com.tencent.xweb.d.sync();
          ae.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bu.aST(paramString)) });
          label188:
          f.f(f.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          f.f(f.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (f.g(f.this))
          {
            f.f(f.this).evaluateJavascript(this.Efa, null);
            f.h(f.this);
            f.i(f.this);
          }
          AppMethodBeat.o(213576);
        }
      });
      AppMethodBeat.o(213683);
      return;
    }
  }
  
  public final void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(213659);
    if (!this.BZx)
    {
      ae.w("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213659);
      return;
    }
    ae.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "onMPDotWebviewStateChange");
    localHashMap.put("id", Integer.valueOf(paramInt1));
    localHashMap.put("webviewId", Integer.valueOf(paramInt2));
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPPageAction", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213659);
  }
  
  public final void Xc(int paramInt)
  {
    AppMethodBeat.i(213653);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(213653);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = l.a.b("menu:setfont", (Map)localObject, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(213653);
  }
  
  public final Bundle Xl(int paramInt)
  {
    AppMethodBeat.i(213665);
    try
    {
      Object localObject = this.Eet;
      if (localObject == null)
      {
        AppMethodBeat.o(213665);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.EeE);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.Eet.getUrl());
      localObject = this.lzT.k(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(213665);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(213665);
    }
    return null;
  }
  
  public final void Xm(int paramInt)
  {
    AppMethodBeat.i(213680);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213680);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.cb.a.aA(ak.getContext(), paramInt)));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213572);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213572);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213572);
        }
      }
    });
    AppMethodBeat.o(213680);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(213635);
    if (paramString != null) {
      this.Eez.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213624);
          Map localMap = f.Q(paramString.split(","));
          String str = f.a(f.this, "hosts");
          if (f.J(str, localMap))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label118;
            }
            try
            {
              f.n(f.this).S(0, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(213624);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ae.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(213624);
              return;
            }
          }
          ae.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(213624);
        }
      });
    }
    AppMethodBeat.o(213635);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(213637);
    if ((x.fjl()) && (!this.EeD))
    {
      AppMethodBeat.o(213637);
      return "";
    }
    String str = this.vVT;
    AppMethodBeat.o(213637);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(213636);
    if (paramString != null) {
      this.Eez.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213625);
          String str = f.a(f.this, "html");
          if (f.kY(str, paramString))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label108;
            }
            try
            {
              f.n(f.this).S(1, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(213625);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ae.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(213625);
              return;
            }
          }
          ae.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(213625);
        }
      });
    }
    AppMethodBeat.o(213636);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.EeC;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.BZx = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(213634);
    ae.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.Eez != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.Eez.sendMessage(localMessage);
      AppMethodBeat.o(213634);
      return;
    }
    ae.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(213634);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(213703);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(213703);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("reqId", Long.valueOf(paramLong));
    localHashMap.put("json", paramString);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213607);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213607);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213607);
        }
      }
    });
    AppMethodBeat.o(213703);
  }
  
  public final void a(a parama)
  {
    this.EeF = parama;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle)
  {
    this.EeK = paramJsapiPermissionWrapper;
    this.EeL = paramBundle;
    this.EeM = true;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213685);
        if (this.EeV.foU()) {
          this.EeV.ay(1000L, 1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.EeU.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.EeU.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.EeT.put(localJSONObject);
              this.EeS.put("beacons", this.EeT);
              this.EeS.put("err_msg", "onBeaconsInRange:ok");
            }
            l.a.a("onBeaconsInRange", this.EeS, this.EeC, this.vVT);
            AppMethodBeat.o(213685);
            return;
          }
          catch (Exception paramString)
          {
            ae.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[] { paramString.getMessage() });
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
    AppMethodBeat.i(213669);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213669);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    localHashMap.put("progress_float", Float.valueOf(paramFloat));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213551);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213551);
          return;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213551);
        }
      }
    });
    AppMethodBeat.o(213669);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(213647);
    a(paramString, this.EeK, this.EeL, paramb);
    AppMethodBeat.o(213647);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(213648);
    a((l)l.a.k("[" + paramString + "]", false, this.vVT).remove(0), paramJsapiPermissionWrapper, paramBundle, paramb);
    AppMethodBeat.o(213648);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213701);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(213701);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString1);
    localHashMap.put("thumbPath", paramString2);
    localHashMap.put("tab", Integer.valueOf(paramInt1));
    localHashMap.put("asyncDownload", Integer.valueOf(paramInt2));
    localHashMap.put("emojiUrl", paramString3);
    localHashMap.put("aesKey", paramString4);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213604);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213604);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213604);
        }
      }
    });
    AppMethodBeat.o(213701);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(213686);
    if (!bu.isNullOrNil(paramString1)) {
      i(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      ePh();
    }
    AppMethodBeat.o(213686);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(213695);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(213695);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(213694);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(213694);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213598);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213598);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213598);
        }
      }
    });
    AppMethodBeat.o(213694);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213698);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(213698);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
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
                ae.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
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
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213600);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
            AppMethodBeat.o(213600);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213600);
          }
        }
      });
      AppMethodBeat.o(213698);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213692);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(213692);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213590);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213590);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213590);
        }
      }
    });
    AppMethodBeat.o(213692);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213696);
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
        AppMethodBeat.o(213696);
        return true;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
        }
      }
    }
    catch (Exception paramMap)
    {
      ae.printErrStackTrace("MicroMsg.JsApiHandler", paramMap, "", new Object[0]);
    }
  }
  
  public final boolean aHJ(final String paramString)
  {
    AppMethodBeat.i(213640);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(213640);
    return true;
  }
  
  public final boolean aHK(String paramString)
  {
    AppMethodBeat.i(213639);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213639);
      return false;
    }
    boolean bool = x.C(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(213639);
    return bool;
  }
  
  public final String aHX(String paramString)
  {
    AppMethodBeat.i(213651);
    Context localContext = getContext();
    if ((localContext instanceof com.tencent.mm.plugin.webview.core.b))
    {
      paramString = ((com.tencent.mm.plugin.webview.core.b)localContext).aHD(paramString);
      AppMethodBeat.o(213651);
      return paramString;
    }
    AppMethodBeat.o(213651);
    return "";
  }
  
  public final void aHY(String paramString)
  {
    this.EeN = paramString;
  }
  
  public final void aHZ(String paramString)
  {
    this.EeO = paramString;
  }
  
  public final void aIa(String paramString)
  {
    AppMethodBeat.i(213661);
    if (!this.BZx)
    {
      AppMethodBeat.o(213661);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = l.a.b("onReceiveMPPageData", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213661);
  }
  
  public final void aIb(String paramString)
  {
    AppMethodBeat.i(213662);
    if (!this.BZx)
    {
      AppMethodBeat.o(213662);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPAdWebviewStateChange", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213662);
  }
  
  public final void aIc(final String paramString)
  {
    AppMethodBeat.i(213671);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(213671);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("activity:state_change", localHashMap, this.EeC, this.vVT);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(213671);
        return;
      }
      catch (Exception paramString)
      {
        ae.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(213671);
        return;
      }
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213557);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(213557);
          return;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213557);
        }
      }
    });
    AppMethodBeat.o(213671);
  }
  
  public final void aId(final String paramString)
  {
    AppMethodBeat.i(213679);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(213679);
      return;
    }
    if (this.Eez != null) {
      this.Eez.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213570);
          l locall = new l();
          locall.xqN = new HashMap();
          locall.xqN.put("username", paramString);
          locall.Efz = new JSONObject();
          locall.type = "call";
          locall.Efy = "";
          locall.lcx = "profile";
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(213570);
        }
      });
    }
    AppMethodBeat.o(213679);
  }
  
  public final void aIe(String paramString)
  {
    AppMethodBeat.i(213682);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213682);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213575);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213575);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213575);
        }
      }
    });
    AppMethodBeat.o(213682);
  }
  
  public final void aIf(String paramString)
  {
    AppMethodBeat.i(213699);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(213699);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213601);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213601);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213601);
        }
      }
    });
    AppMethodBeat.o(213699);
  }
  
  public final void aIh(String paramString)
  {
    AppMethodBeat.i(213710);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213710);
      return;
    }
    if (!x.aPj(getCurrentUrl()))
    {
      AppMethodBeat.o(213710);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = l.a.b("onMenuClick", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213710);
  }
  
  public final void aIi(String paramString)
  {
    AppMethodBeat.i(213712);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213712);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213712);
      return;
    }
    ae.d("MicroMsg.JsApiHandler", "onNetWorkChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    paramString = ak.getContext();
    if (!az.isConnected(paramString)) {
      localHashMap.put("networkType", "none");
    }
    if (az.is2G(paramString))
    {
      ae.i("MicroMsg.JsApiHandler", "onNetWorkChange 2g");
      localHashMap.put("networkType", "2g");
    }
    if (az.is3G(paramString))
    {
      ae.i("MicroMsg.JsApiHandler", "onNetWorkChange 3g");
      localHashMap.put("networkType", "3g");
    }
    if (az.is4G(paramString))
    {
      ae.i("MicroMsg.JsApiHandler", "onNetWorkChange 4g");
      localHashMap.put("networkType", "4g");
    }
    if (az.is5G(paramString))
    {
      ae.i("MicroMsg.JsApiHandler", "onNetWorkChange 5g");
      localHashMap.put("networkType", "5g");
    }
    if (az.isWifi(paramString))
    {
      ae.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
      localHashMap.put("networkType", "wifi");
    }
    if (this.lzT != null) {}
    for (;;)
    {
      try
      {
        i = this.lzT.k(110, new Bundle()).getInt("sim_card_type", 0);
        if (i != 0) {
          continue;
        }
        i = 0;
        localHashMap.put("simType", Integer.valueOf(i));
        ae.d("MicroMsg.JsApiHandler", "onNetWorkChange simType=%s", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception paramString)
      {
        int i;
        ae.e("MicroMsg.JsApiHandler", "invokeAsResult ex %s", new Object[] { paramString.getMessage() });
        continue;
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213616);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
            AppMethodBeat.o(213616);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213616);
          }
        }
      });
      AppMethodBeat.o(213712);
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
    this.lzT = parame;
  }
  
  public final void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213655);
    if (!this.BZx)
    {
      AppMethodBeat.o(213655);
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
      paramString1 = l.a.b("onMPPageAction", localHashMap, this.EeC, this.vVT);
      this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(213655);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213697);
    if ((!this.BZx) || ((paramMap == null) && (paramJSONObject == null)))
    {
      ae.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(213697);
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
      ae.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label156;
      }
    }
    label147:
    label156:
    for (paramMap = l.a.b(paramString, paramMap, this.EeC, this.vVT);; paramMap = l.a.a(paramString, paramJSONObject, this.EeC, this.vVT))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213599);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(213599);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(213599);
          }
        }
      };
      if (!ar.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(213697);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    ar.f(paramString);
    AppMethodBeat.o(213697);
  }
  
  public final void b(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(213663);
    ae.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.BZx) });
    if (!this.BZx)
    {
      ae.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      h(bD(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(213663);
      return;
    }
    paramHashMap = Xl(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      h(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(213663);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap.put("shareScene", Integer.valueOf(paramInt));
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.lzT.aj("scene", "friend", this.EeE);
      AppMethodBeat.o(213663);
      return;
    }
    catch (Exception paramHashMap)
    {
      ae.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213663);
    }
  }
  
  public final void bC(Map<String, Object> paramMap)
  {
    this.EeA = paramMap;
  }
  
  public final Bundle bD(Map<String, String> paramMap)
  {
    AppMethodBeat.i(213666);
    Bundle localBundle = new Bundle();
    String str1 = this.Eet.getUrl();
    String str2;
    if (paramMap != null)
    {
      str2 = (String)paramMap.get("share_report_pre_msg_url");
      if (!bu.isNullOrNil(str2)) {
        break label273;
      }
      str2 = str1;
    }
    label273:
    for (;;)
    {
      Object localObject = (String)paramMap.get("share_report_pre_msg_title");
      if (bu.isNullOrNil((String)localObject)) {
        localObject = this.Eet.getTitle();
      }
      for (;;)
      {
        String str4 = (String)paramMap.get("share_report_pre_msg_desc");
        String str3 = str4;
        if (bu.isNullOrNil(str4)) {
          str3 = str1;
        }
        localBundle.putString("link", str2);
        localBundle.putString("desc", str3);
        localBundle.putString("img_url", bu.nullAsNil((String)paramMap.get("share_report_pre_msg_icon_url")));
        if (bu.isNullOrNil((String)localObject)) {
          if (!bu.isNullOrNil(str1))
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
          AppMethodBeat.o(213666);
          return localBundle;
          localObject = this.Eet.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = ak.getContext().getString(2131766105);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213672);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(213672);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213558);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213558);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213558);
        }
      }
    });
    AppMethodBeat.o(213672);
  }
  
  public final void bF(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213673);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(213673);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = l.a.b("onVoiceRecordEnd", paramMap, this.EeC, this.vVT);
    ae.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213559);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(213559);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213559);
        }
      }
    });
    AppMethodBeat.o(213673);
  }
  
  public final void bG(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213690);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(213690);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213580);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213580);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213580);
        }
      }
    });
    AppMethodBeat.o(213690);
  }
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213633);
    try
    {
      this.lzT.l(paramString, paramBoolean, this.EeE);
      AppMethodBeat.o(213633);
      return;
    }
    catch (Exception paramString)
    {
      ae.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213633);
    }
  }
  
  public final void cz(int paramInt, String paramString)
  {
    AppMethodBeat.i(213700);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(213700);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213602);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213602);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213602);
        }
      }
    });
    AppMethodBeat.o(213700);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(213652);
    this.BZx = false;
    this.BdZ.clear();
    this.Eey.clear();
    this.Eez = null;
    AppMethodBeat.o(213652);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213714);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213714);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213620);
        try
        {
          if (f.f(f.this) != null) {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.Efe + ")", null);
          }
          AppMethodBeat.o(213620);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(213620);
        }
      }
    });
    AppMethodBeat.o(213714);
  }
  
  public final void ePd()
  {
    AppMethodBeat.i(213688);
    if (this.BdZ != null) {
      this.BdZ.clear();
    }
    AppMethodBeat.o(213688);
  }
  
  public final void ePh()
  {
    AppMethodBeat.i(213687);
    if (this.Eez != null) {
      this.Eez.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213578);
          f.e(f.this);
          AppMethodBeat.o(213578);
        }
      });
    }
    AppMethodBeat.o(213687);
  }
  
  public final void eSh()
  {
    AppMethodBeat.i(213631);
    if (this.EeC != true)
    {
      this.EeC = true;
      if (!com.tencent.matrix.trace.g.b.ef(this.Eet.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = bu.abf(16);; str = this.Eet.getRandomStr())
    {
      this.vVT = str;
      ae.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.vVT, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213631);
      return;
    }
  }
  
  public final void eSi()
  {
    AppMethodBeat.i(213632);
    this.EeC = true;
    this.vVT = bu.abf(16);
    this.Eet.setRandomStr(this.vVT);
    ae.i("MicroMsg.JsApiHandler", "js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { this.vVT, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(213632);
  }
  
  public final String eSj()
  {
    return this.vVT;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eSk()
  {
    AppMethodBeat.i(213638);
    if (this.EeJ == null) {
      this.EeJ = new com.tencent.mm.plugin.webview.c.b.a();
    }
    this.EeJ.Eep = this.Eet;
    com.tencent.mm.plugin.webview.c.b.a locala = this.EeJ;
    AppMethodBeat.o(213638);
    return locala;
  }
  
  public final void eSl()
  {
    AppMethodBeat.i(213641);
    if ((this.EeC) && (x.fjl()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("__event_id", "sys:updateRandomStr");
        localJSONObject2.put("randomStr", this.vVT);
        localJSONObject1.put("__json_message", localJSONObject2);
        this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + localJSONObject1.toString() + ")", new ValueCallback() {});
        AppMethodBeat.o(213641);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(213641);
  }
  
  public final void eSm()
  {
    AppMethodBeat.i(213643);
    ae.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.BZx) });
    if ((this.Eet != null) && (this.BZx)) {
      this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:attach_runOn3rd_apis", eSn(), this.EeC, this.vVT) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(213643);
  }
  
  public final void eSq()
  {
    AppMethodBeat.i(213708);
    ae.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.BZx) });
    if ((this.Eet != null) && (this.BZx)) {
      this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_all_hosts", new HashMap(), this.EeC, this.vVT) + ")", null);
    }
    AppMethodBeat.o(213708);
  }
  
  public final void eSr()
  {
    AppMethodBeat.i(213711);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(213711);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213614);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213614);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213614);
        }
      }
    });
    AppMethodBeat.o(213711);
  }
  
  public final void eSs()
  {
    AppMethodBeat.i(213713);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(213713);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = l.a.b("onNavigationBarRightButtonClick", new HashMap(), this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(213713);
  }
  
  public final long eSt()
  {
    AppMethodBeat.i(213715);
    ae.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.EeW) });
    long l = this.EeW;
    AppMethodBeat.o(213715);
    return l;
  }
  
  public final k eSu()
  {
    return this.EeX;
  }
  
  public final void eSv()
  {
    AppMethodBeat.i(213716);
    if (!this.BZx)
    {
      AppMethodBeat.o(213716);
      return;
    }
    this.EeX.clear();
    if (this.lzT != null) {
      try
      {
        this.lzT.XP(this.EeE);
        AppMethodBeat.o(213716);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(213716);
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(213719);
    if (ar.isMainThread())
    {
      this.Eet.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(213719);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213622);
        f.f(f.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(213622);
      }
    });
    AppMethodBeat.o(213719);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(213660);
    if (!this.BZx)
    {
      AppMethodBeat.o(213660);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    localHashMap.put("currentTime", paramString4);
    localHashMap.put("playedTotalTime", paramString5);
    paramString1 = l.a.b("onMPVideoStateChange", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(213660);
  }
  
  public final void fK(String paramString, int paramInt)
  {
    AppMethodBeat.i(213656);
    if (!this.BZx)
    {
      AppMethodBeat.o(213656);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = l.a.b("onMPPageAction", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213656);
  }
  
  public final void fL(String paramString, int paramInt)
  {
    AppMethodBeat.i(213658);
    if (!this.BZx)
    {
      AppMethodBeat.o(213658);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = l.a.b("onMPPageAction", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213658);
  }
  
  public final void fM(String paramString, int paramInt)
  {
    AppMethodBeat.i(213670);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(213670);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(213670);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213552);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
            AppMethodBeat.o(213552);
            return;
          }
          catch (Exception localException)
          {
            ae.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213552);
          }
        }
      });
      AppMethodBeat.o(213670);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(213674);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(213674);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213562);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213562);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213562);
        }
      }
    });
    AppMethodBeat.o(213674);
  }
  
  public final void fO(String paramString, int paramInt)
  {
    AppMethodBeat.i(213675);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(213675);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213563);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213563);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213563);
        }
      }
    });
    AppMethodBeat.o(213675);
  }
  
  public final void fP(String paramString, int paramInt)
  {
    AppMethodBeat.i(213676);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(213676);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213564);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213564);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213564);
        }
      }
    });
    AppMethodBeat.o(213676);
  }
  
  public final void fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(213677);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(213677);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213565);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213565);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213565);
        }
      }
    });
    AppMethodBeat.o(213677);
  }
  
  public final void fR(String paramString, int paramInt)
  {
    AppMethodBeat.i(213678);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(213678);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213566);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213566);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213566);
        }
      }
    });
    AppMethodBeat.o(213678);
  }
  
  final String fS(String paramString, int paramInt)
  {
    AppMethodBeat.i(213684);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = aIg(l.a.b("onGetA8KeyUrl", localHashMap, this.EeC, this.vVT));
    AppMethodBeat.o(213684);
    return paramString;
  }
  
  public final void fT(String paramString, int paramInt)
  {
    AppMethodBeat.i(213705);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(213705);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213609);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213609);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213609);
        }
      }
    });
    AppMethodBeat.o(213705);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(213704);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(213704);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "%s success, ready", new Object[] { paramString4 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", Integer.valueOf(paramInt));
    localHashMap.put("errMsg", paramString1);
    localHashMap.put("json", paramString2);
    if (!bu.isNullOrNil(paramString3)) {
      localHashMap.put("requestId", paramString3);
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213608);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213608);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(213608);
        }
      }
    });
    AppMethodBeat.o(213704);
  }
  
  public final void gY(Context paramContext)
  {
    this.Eex = paramContext;
  }
  
  public final int getBinderID()
  {
    return this.EeE;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(213650);
    if (this.EeM)
    {
      if (this.Eex != null)
      {
        localContext = this.Eex;
        AppMethodBeat.o(213650);
        return localContext;
      }
      localContext = ak.getContext();
      AppMethodBeat.o(213650);
      return localContext;
    }
    if (this.Eet == null)
    {
      AppMethodBeat.o(213650);
      return null;
    }
    Context localContext = this.Eet.getActivityContextIfHas();
    AppMethodBeat.o(213650);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(213718);
    if (this.Eet == null)
    {
      AppMethodBeat.o(213718);
      return "";
    }
    String str = this.Eet.getUrl();
    AppMethodBeat.o(213718);
    return str;
  }
  
  public final z getSettings()
  {
    AppMethodBeat.i(213630);
    z localz = this.Eet.getSettings();
    AppMethodBeat.o(213630);
    return localz;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(213717);
    String str = (String)this.EeA.get("srcUsername");
    AppMethodBeat.o(213717);
    return str;
  }
  
  public final void h(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(213667);
    if (paramBundle == null)
    {
      ae.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(213667);
      return;
    }
    if (this.Eez != null) {
      this.Eez.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213626);
          l locall = new l();
          locall.xqN = new HashMap();
          locall.xqN.put("link", paramBundle.getString("link"));
          locall.xqN.put("title", paramBundle.getString("title"));
          locall.xqN.put("desc", paramBundle.getString("desc"));
          locall.Efz = new JSONObject();
          locall.xqN.put("img_url", paramBundle.getString("img_url"));
          locall.xqN.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          locall.type = "call";
          locall.Efy = "";
          locall.lcx = paramString;
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(213626);
        }
      });
    }
    AppMethodBeat.o(213667);
  }
  
  public final void i(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(213668);
    if ((!this.BZx) || (paramBundle == null))
    {
      ae.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213668);
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    ae.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213550);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213550);
          return;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213550);
        }
      }
    });
    AppMethodBeat.o(213668);
  }
  
  public final void i(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213689);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      ae.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(213689);
      return;
    }
    if (this.gsk.containsKey(paramString1))
    {
      ((b)this.gsk.get(paramString1)).i(paramString1, paramString2, paramMap);
      this.gsk.remove(paramString1);
      AppMethodBeat.o(213689);
      return;
    }
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(213689);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      ae.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      localHashMap.putAll(paramMap);
    }
    paramString1 = l.a.a(paramString1, localHashMap, this.EeC, this.vVT);
    ae.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.Eet != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213579);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(213579);
            return;
          }
          catch (Exception localException)
          {
            ae.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213579);
          }
        }
      };
      if (ar.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(213689);
        return;
      }
      ar.f(paramString1);
    }
    AppMethodBeat.o(213689);
  }
  
  public final boolean isReady()
  {
    return this.BZx;
  }
  
  public final void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(213691);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(213691);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213586);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213586);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213586);
        }
      }
    });
    AppMethodBeat.o(213691);
  }
  
  public final void kV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213657);
    if (!this.BZx)
    {
      AppMethodBeat.o(213657);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = l.a.b("onMPPageAction", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(213657);
  }
  
  public final void kW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213693);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(213693);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213595);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", new ValueCallback() {});
          AppMethodBeat.o(213595);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213595);
        }
      }
    });
    AppMethodBeat.o(213693);
  }
  
  public final void n(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(213664);
    ae.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(this.BZx) });
    if (!this.BZx) {
      try
      {
        this.lzT.aj("scene", "favorite", this.EeE);
        h(bD(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(213664);
        return;
      }
      catch (Exception paramHashMap)
      {
        ae.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
        AppMethodBeat.o(213664);
        return;
      }
    }
    paramHashMap = Xl(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false))) {
      try
      {
        this.lzT.aj("scene", "favorite", this.EeE);
        h(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(213664);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException.getMessage());
        }
      }
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "favorite");
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.lzT.aj("scene", "favorite", this.EeE);
      AppMethodBeat.o(213664);
      return;
    }
    catch (Exception paramHashMap)
    {
      ae.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213664);
    }
  }
  
  public final void u(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213654);
    if (!this.BZx)
    {
      AppMethodBeat.o(213654);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = l.a.b("menu:haokan", localHashMap, this.EeC, this.vVT);
    this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213654);
  }
  
  public final void v(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213702);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(213702);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213605);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213605);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213605);
        }
      }
    });
    AppMethodBeat.o(213702);
  }
  
  public final void ve(boolean paramBoolean)
  {
    AppMethodBeat.i(213642);
    this.BZx = paramBoolean;
    ae.i("MicroMsg.JsApiHandler", "js ready now");
    AppMethodBeat.o(213642);
  }
  
  public final void vf(boolean paramBoolean)
  {
    AppMethodBeat.i(213681);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213681);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213574);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lGd + ")", null);
          AppMethodBeat.o(213574);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213574);
        }
      }
    });
    AppMethodBeat.o(213681);
  }
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(213707);
    if (!this.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(213707);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213611);
        try
        {
          f.f(f.this).evaluateJavascript(this.Efe, null);
          AppMethodBeat.o(213611);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213611);
        }
      }
    });
    AppMethodBeat.o(213707);
  }
  
  public final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(213709);
    ae.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.BZx) });
    if ((this.Eet != null) && (this.lzT != null) && (this.BZx)) {
      if (paramBoolean)
      {
        this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.EeC, this.vVT) + ")", null);
        AppMethodBeat.o(213709);
        return;
      }
    }
    try
    {
      List localList = this.lzT.eVs();
      Uri localUri = Uri.parse(this.Eet.getUrl());
      if (localUri != null) {
        ae.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.EeC, this.vVT) + ")", null);
      }
      AppMethodBeat.o(213709);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
        Object localObject = null;
      }
    }
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