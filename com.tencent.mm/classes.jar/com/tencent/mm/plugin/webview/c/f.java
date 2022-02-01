package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.k.k;
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
  private static final int DMy;
  private final LinkedList<l> AMx;
  public boolean BHY;
  private ap DMA;
  public Map<String, Object> DMB;
  private g DMC;
  public boolean DMD;
  public boolean DME;
  public int DMF;
  private a DMG;
  private Set<String> DMH;
  private boolean DMI;
  public String DMJ;
  private com.tencent.mm.plugin.webview.c.b.a DMK;
  private JsapiPermissionWrapper DML;
  private Bundle DMM;
  private boolean DMN;
  public String DMO;
  public String DMP;
  private final List<String> DMQ;
  volatile String DMR;
  volatile int DMS;
  private JSONObject DMT;
  private JSONArray DMU;
  private List<String> DMV;
  private av DMW;
  public long DMX;
  public k DMY;
  public MMWebView DMv;
  private final List<String> DMz;
  private Context OdW;
  HashMap<String, b> gpP;
  public com.tencent.mm.plugin.webview.stub.e lvv;
  public String vJP;
  
  static
  {
    AppMethodBeat.i(213900);
    if (com.tencent.mm.compatible.util.d.lz(19)) {}
    for (int i = 200;; i = 20)
    {
      DMy = i;
      AppMethodBeat.o(213900);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt)
  {
    AppMethodBeat.i(213798);
    this.DMz = new LinkedList();
    this.AMx = new LinkedList();
    this.DMA = null;
    this.BHY = false;
    this.DMD = false;
    this.vJP = "";
    this.DME = false;
    this.DMH = null;
    this.DMI = false;
    this.DMK = null;
    this.gpP = new HashMap();
    this.DMN = false;
    this.DMQ = new LinkedList();
    this.DMR = null;
    this.DMS = 0;
    this.DMT = new JSONObject();
    this.DMU = new JSONArray();
    this.DMV = new LinkedList();
    this.DMW = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213748);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(213748);
        return false;
      }
    }, false);
    this.DMX = 0L;
    this.DMY = new k(this);
    this.DMv = paramMMWebView;
    this.DMC = paramg;
    this.DMF = paramInt;
    eOv();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      ad.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213798);
      return;
    }
  }
  
  public f(MMWebView paramMMWebView, g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(213799);
    this.DMz = new LinkedList();
    this.AMx = new LinkedList();
    this.DMA = null;
    this.BHY = false;
    this.DMD = false;
    this.vJP = "";
    this.DME = false;
    this.DMH = null;
    this.DMI = false;
    this.DMK = null;
    this.gpP = new HashMap();
    this.DMN = false;
    this.DMQ = new LinkedList();
    this.DMR = null;
    this.DMS = 0;
    this.DMT = new JSONObject();
    this.DMU = new JSONArray();
    this.DMV = new LinkedList();
    this.DMW = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213748);
        String str = l.a.a("onBeaconsInRange", f.j(f.this), f.k(f.this), f.l(f.this));
        f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        f.m(f.this).clear();
        f.a(f.this, new JSONObject());
        f.a(f.this, new JSONArray());
        AppMethodBeat.o(213748);
        return false;
      }
    }, false);
    this.DMX = 0L;
    this.DMY = new k(this);
    this.DMv = paramMMWebView;
    this.DMC = paramg;
    this.DMF = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.DMH = paramg;
    this.DMI = true;
    eOv();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      ad.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213799);
      return;
    }
  }
  
  /* Error */
  private static boolean H(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 367
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 373	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 334
    //   20: ldc_w 375
    //   23: invokestatic 379	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 367
    //   29: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 381	com/tencent/mm/vfs/e
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 384	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 388	com/tencent/mm/vfs/e:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 391	com/tencent/mm/vfs/e:createNewFile	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 397	com/tencent/mm/vfs/i:d	(Lcom/tencent/mm/vfs/e;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 403 1 0
    //   77: invokeinterface 409 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 414 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 418 1 0
    //   101: checkcast 420	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 424 2 0
    //   114: checkcast 338	java/lang/Integer
    //   117: invokevirtual 427	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 429	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 430	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 436
    //   136: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 447	java/lang/String:getBytes	()[B
    //   150: invokevirtual 453	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 455	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 455	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 334
    //   174: aload_1
    //   175: ldc_w 271
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 334
    //   188: ldc_w 461
    //   191: invokestatic 379	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 464	java/io/OutputStream:close	()V
    //   202: ldc_w 367
    //   205: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 334
    //   214: ldc_w 466
    //   217: aload_0
    //   218: invokestatic 469	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 473	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 334
    //   230: aload_1
    //   231: ldc_w 271
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 367
    //   244: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 479	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 464	java/io/OutputStream:close	()V
    //   261: ldc_w 334
    //   264: ldc_w 481
    //   267: aload_0
    //   268: invokestatic 469	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 473	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 483	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 367
    //   280: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 334
    //   289: aload_1
    //   290: ldc_w 271
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 334
    //   307: aload_0
    //   308: ldc_w 271
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 464	java/io/OutputStream:close	()V
    //   332: ldc_w 367
    //   335: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 334
    //   344: aload_1
    //   345: ldc_w 271
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    AppMethodBeat.i(213820);
    if (paraml == null)
    {
      ad.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(213820);
      return true;
    }
    if ((paraml.kYO == null) || (paraml.xaW == null) || (paraml.type == null) || ((!this.DMN) && (this.DMv == null)))
    {
      ad.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paraml.kYO + ", params = " + paraml.xaW + ", type = " + paraml.type + ", wv = " + this.DMv);
      AppMethodBeat.o(213820);
      return true;
    }
    if ((this.DMI) && ((this.DMH == null) || (!this.DMH.contains(paraml.kYO))))
    {
      ad.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paraml.kYO });
      h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213794);
          f.this.i(paraml.DNz, "system:access_denied", null);
          AppMethodBeat.o(213794);
        }
      });
      AppMethodBeat.o(213820);
      return true;
    }
    if (paramBundle != null) {
      paraml.DMM = paramBundle;
    }
    if (paramb != null) {
      this.gpP.put(paraml.DNz, paramb);
    }
    if ((this.DMB != null) && (this.DMB.get("srcUsername") != null) && (!bt.isNullOrNil(this.DMB.get("srcUsername").toString()))) {
      paraml.xaW.put("src_username", this.DMB.get("srcUsername").toString());
    }
    if ((this.DMB != null) && (this.DMB.get("srcDisplayname") != null) && (!bt.isNullOrNil(this.DMB.get("srcDisplayname").toString()))) {
      paraml.xaW.put("src_displayname", this.DMB.get("srcDisplayname").toString());
    }
    if ((this.DMB != null) && (this.DMB.get("KTemplateId") != null) && (!bt.isNullOrNil(this.DMB.get("KTemplateId").toString()))) {
      paraml.xaW.put("tempalate_id", this.DMB.get("KTemplateId").toString());
    }
    if (this.DMB != null)
    {
      paraml.xaW.put("message_id", this.DMB.get("message_id"));
      paraml.xaW.put("message_index", this.DMB.get("message_index"));
      paraml.xaW.put("webview_scene", this.DMB.get("scene"));
      paraml.xaW.put("pay_channel", this.DMB.get("pay_channel"));
      paraml.xaW.put("pay_scene", this.DMB.get("pay_scene"));
      ad.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.DMB.get("pay_package") });
      if (this.DMB.get("pay_package") != null) {
        paraml.xaW.put("pay_packageName", this.DMB.get("pay_package"));
      }
      paraml.xaW.put("stastic_scene", this.DMB.get("stastic_scene"));
      paraml.xaW.put("open_from_scene", this.DMB.get("from_scence"));
      paramBundle = paraml.xaW;
      paramb = new Bundle();
      paramb.putString("__jsapi_fw_ext_info_key_current_url", this.DMv.getUrl());
      paramBundle.put("__jsapi_fw_ext_info", paramb);
    }
    if ((this.DMv != null) && (!paraml.kYO.equals("shareWeibo")) && (!paraml.kYO.equals("openUrlByExtBrowser")) && (!paraml.kYO.equals("log")) && (!paraml.kYO.equals("openUrlWithExtraWebview")) && (!paraml.kYO.equals("openCustomWebview")) && (!paraml.kYO.equals("openGameWebView")) && (!paraml.kYO.equals("addToEmoticon")) && (!paraml.kYO.equals("shareEmoticon")) && (!paraml.kYO.equals("openGameUrlWithExtraWebView")) && (!paraml.kYO.equals("request")))
    {
      paraml.xaW.put("url", this.DMv.getUrl());
      ad.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.DMv.getUrl());
    }
    if ((paraml.kYO.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kYO.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paraml.kYO.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kYO.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paraml.kYO.equalsIgnoreCase("openDesignerEmojiView")) || (paraml.kYO.equalsIgnoreCase("openDesignerProfile")) || (paraml.kYO.equalsIgnoreCase("openDesignerProfileLocal")) || (paraml.kYO.equalsIgnoreCase("getSearchEmotionData")))
    {
      paraml.xaW.put("searchID", Long.valueOf(eOI()));
      ad.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(eOI()) });
    }
    if (paraml.kYO.equals("request"))
    {
      if (this.DMO != null) {
        paraml.xaW.put("key_request_full_url_query", this.DMO);
      }
      if (this.DMP != null) {
        paraml.xaW.put("key_request_header", this.DMP);
      }
    }
    if (paraml.kYO.equals("imagePreview")) {
      j.a(paraml.xaW, this.DMv);
    }
    if ((paraml.kYO.equals("preVerifyJSAPI")) && (paraml.xaW.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.k.c.eWc();
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
          localBundle1.putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.FnH);
          bool2 = bool1;
          localBundle1.putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.FnI);
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.fgs());
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.fgt());
        }
        bool2 = bool1;
        paramb = l.bB(paraml.xaW);
        bool2 = bool1;
        if (!bt.isNullOrNil(this.DMJ))
        {
          bool2 = bool1;
          paramb.putString("key_wxapp_id", this.DMJ);
        }
        bool2 = bool1;
        localBundle2 = new Bundle(3);
        paramBundle = paramb;
        bool2 = bool1;
        if (paraml.DMM != null)
        {
          bool2 = bool1;
          localBundle2.putBundle("jsEngine", paraml.DMM);
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
        if (paraml.DNA != null)
        {
          bool2 = bool1;
          localBundle2.putString("rawParams", paraml.DNA.toString());
        }
        bool2 = bool1;
        ad.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paraml.kYO });
        bool2 = bool1;
        if (this.DMG != null)
        {
          bool2 = bool1;
          bool3 = this.DMG.b(paraml);
        }
        bool2 = bool3;
        if (!this.DMN)
        {
          bool2 = bool3;
          this.DMC.eRh();
          bool2 = bool3;
          getContext();
        }
        bool1 = bool3;
        if (bool3) {
          break label1736;
        }
        bool2 = bool3;
        paramJsapiPermissionWrapper = new d(getContext(), paramJsapiPermissionWrapper, this.lvv, this, this.DMv);
        bool2 = bool3;
        paramBundle = m.DNE;
        bool2 = bool3;
        p.h(paramJsapiPermissionWrapper, "env");
        bool2 = bool3;
        p.h(paraml, "msg");
        bool2 = bool3;
        if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
          break label1632;
        }
        bool2 = bool3;
        if (1 <= ad.getLogLevel()) {
          break label1632;
        }
        bool2 = bool3;
        if (m.DNC.isEmpty()) {
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
          ad.printErrStackTrace("MicroMsg.JsApiHandler", paramJsapiPermissionWrapper, "", new Object[0]);
          ad.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + paramJsapiPermissionWrapper.getMessage());
          continue;
          bool1 = false;
          continue;
          bool2 = bool1;
          if ((this.lvv != null) && (paraml != null))
          {
            bool2 = bool1;
            bool1 = this.lvv.a(paraml.type, paraml.kYO, paraml.DNz, localBundle1, localBundle2, this.DMF);
            i = 0;
            continue;
            AppMethodBeat.o(213820);
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
      if (!m.DNC.containsKey(paraml.kYO)) {
        break label2022;
      }
      bool2 = bool3;
      paramBundle = m.DNC.get(paraml.kYO);
      if (paramBundle == null)
      {
        bool2 = bool3;
        p.gfZ();
      }
      bool2 = bool3;
      paramBundle = (com.tencent.mm.plugin.webview.c.c.a)paramBundle;
      bool2 = bool3;
      if (!m.DND.WD(paramBundle.eOL())) {
        break;
      }
      bool2 = bool3;
      paramJsapiPermissionWrapper.Dyx.i(paraml.DNz, "system:too_frequent", null);
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
        ad.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paraml.kYO });
        i = 1;
        j.eRa();
        ad.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paraml.kYO, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          break label2084;
        }
        AppMethodBeat.o(213820);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        for (;;) {}
      }
      bool2 = bool1;
      paramJsapiPermissionWrapper = this.DMC.eRg();
    }
    bool1 = false;
    bool2 = bool3;
    i = paramBundle.eOL();
    bool2 = bool3;
    if (paramJsapiPermissionWrapper.DzO.mz(i))
    {
      bool2 = bool3;
      bool1 = paramBundle.a(paramJsapiPermissionWrapper, paraml);
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = bool3;
        if (bt.lQ(paramBundle.eOM(), "handleMPPageAction")) {
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
      ad.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paraml.kYO);
      bool2 = bool3;
      paramJsapiPermissionWrapper.Dyx.i(paraml.DNz, "system:access_denied", null);
    }
  }
  
  public static String aGM(String paramString)
  {
    AppMethodBeat.i(213877);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { bt.nullAsNil(paramString) });
    AppMethodBeat.o(213877);
    return paramString;
  }
  
  private String aGP(String paramString)
  {
    AppMethodBeat.i(213891);
    String str1 = this.DMv.getUrl();
    try
    {
      String str2 = n.eq(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.asa() + str2;
      ad.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(213891);
      return str2;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      ad.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(213891);
    }
    return null;
  }
  
  private Map<String, Object> eOC()
  {
    AppMethodBeat.i(213815);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.DMC.eRg();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.mz(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.mz(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.mz(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.mz(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.mz(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.mz(219)) {
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
      if (!bt.hj(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(213815);
    return localHashMap;
  }
  
  private void eOD()
  {
    AppMethodBeat.i(213816);
    while (eOE()) {}
    AppMethodBeat.o(213816);
  }
  
  private boolean eOE()
  {
    AppMethodBeat.i(213817);
    if (bt.hj(this.AMx))
    {
      ad.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(213817);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.lvv.Xi(this.DMF);
      ad.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        ad.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(213817);
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
      if (this.AMx.size() == 0)
      {
        ad.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(213817);
        return false;
      }
      bool = a((l)this.AMx.remove(0), null, null, null);
      AppMethodBeat.o(213817);
    }
    return bool;
  }
  
  private void eOv()
  {
    AppMethodBeat.i(213800);
    this.DMA = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(213720);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(213720);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!bt.isNullOrNil(paramAnonymousMessage)) {
            f.b(f.this).add(paramAnonymousMessage);
          }
          f.c(f.this);
          AppMethodBeat.o(213720);
          return;
          ad.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(213800);
  }
  
  /* Error */
  private static boolean kQ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1256
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 373	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 373	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 334
    //   23: ldc_w 375
    //   26: invokestatic 379	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1256
    //   32: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 381	com/tencent/mm/vfs/e
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 384	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 388	com/tencent/mm/vfs/e:exists	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 391	com/tencent/mm/vfs/e:createNewFile	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1260	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 447	java/lang/String:getBytes	()[B
    //   84: invokevirtual 453	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 455	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 455	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 479	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 464	java/io/OutputStream:close	()V
    //   134: ldc_w 334
    //   137: ldc_w 481
    //   140: aload_0
    //   141: invokestatic 469	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 473	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 483	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1256
    //   153: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 334
    //   162: ldc_w 466
    //   165: aload_0
    //   166: invokestatic 469	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 473	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 334
    //   178: aload_1
    //   179: ldc_w 271
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1256
    //   192: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 334
    //   201: aload_1
    //   202: ldc_w 271
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 334
    //   221: aload_0
    //   222: ldc_w 271
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 334
    //   237: ldc_w 461
    //   240: invokestatic 379	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 464	java/io/OutputStream:close	()V
    //   251: ldc_w 1256
    //   254: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 334
    //   263: aload_0
    //   264: ldc_w 271
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 464	java/io/OutputStream:close	()V
    //   286: ldc_w 1256
    //   289: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 334
    //   298: aload_1
    //   299: ldc_w 271
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void G(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(213854);
    ad.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213854);
      return;
    }
    this.DMR = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.DMS = 1;; this.DMS = 0)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213747);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.lv(aj.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.gaw();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localc.setCookie(bt.aRw(paramString), str + "=" + (String)paramMap.get(str));
            }
            localException.setCookie(bt.aRw(paramString), "httponly");
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213747);
            return;
          }
          com.tencent.xweb.d.gay();
          com.tencent.xweb.d.sync();
          ad.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bt.aRw(paramString)) });
          label188:
          f.f(f.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          f.f(f.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (f.g(f.this))
          {
            f.f(f.this).evaluateJavascript(this.DNb, null);
            f.h(f.this);
            f.i(f.this);
          }
          AppMethodBeat.o(213747);
        }
      });
      AppMethodBeat.o(213854);
      return;
    }
  }
  
  public final void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(213830);
    if (!this.BHY)
    {
      ad.w("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213830);
      return;
    }
    ad.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "onMPDotWebviewStateChange");
    localHashMap.put("id", Integer.valueOf(paramInt1));
    localHashMap.put("webviewId", Integer.valueOf(paramInt2));
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPPageAction", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213830);
  }
  
  public final Bundle WE(int paramInt)
  {
    AppMethodBeat.i(213836);
    try
    {
      Object localObject = this.DMv;
      if (localObject == null)
      {
        AppMethodBeat.o(213836);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.DMF);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.DMv.getUrl());
      localObject = this.lvv.k(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(213836);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(213836);
    }
    return null;
  }
  
  public final void WF(int paramInt)
  {
    AppMethodBeat.i(213851);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213851);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.cc.a.aA(aj.getContext(), paramInt)));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213743);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213743);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213743);
        }
      }
    });
    AppMethodBeat.o(213851);
  }
  
  public final void Wv(int paramInt)
  {
    AppMethodBeat.i(213824);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(213824);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = l.a.b("menu:setfont", (Map)localObject, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(213824);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(213806);
    if (paramString != null) {
      this.DMA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213795);
          Map localMap = f.Q(paramString.split(","));
          String str = f.a(f.this, "hosts");
          if (f.I(str, localMap))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label118;
            }
            try
            {
              f.n(f.this).S(0, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(213795);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ad.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(213795);
              return;
            }
          }
          ad.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(213795);
        }
      });
    }
    AppMethodBeat.o(213806);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(213808);
    if ((x.ffv()) && (!this.DME))
    {
      AppMethodBeat.o(213808);
      return "";
    }
    String str = this.vJP;
    AppMethodBeat.o(213808);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(213807);
    if (paramString != null) {
      this.DMA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213796);
          String str = f.a(f.this, "html");
          if (f.kR(str, paramString))
          {
            if ((f.n(f.this) == null) || (f.f(f.this) == null)) {
              break label108;
            }
            try
            {
              f.n(f.this).S(1, f.f(f.this).getUrl(), str);
              AppMethodBeat.o(213796);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              ad.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(213796);
              return;
            }
          }
          ad.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(213796);
        }
      });
    }
    AppMethodBeat.o(213807);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.DMD;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.BHY = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(213805);
    ad.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.DMA != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.DMA.sendMessage(localMessage);
      AppMethodBeat.o(213805);
      return;
    }
    ad.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(213805);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(213874);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(213874);
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
        AppMethodBeat.i(213778);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213778);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213778);
        }
      }
    });
    AppMethodBeat.o(213874);
  }
  
  public final void a(a parama)
  {
    this.DMG = parama;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle)
  {
    this.DML = paramJsapiPermissionWrapper;
    this.DMM = paramBundle;
    this.DMN = true;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213856);
        if (this.DMW.fkZ()) {
          this.DMW.az(1000L, 1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.DMV.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.DMV.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.DMU.put(localJSONObject);
              this.DMT.put("beacons", this.DMU);
              this.DMT.put("err_msg", "onBeaconsInRange:ok");
            }
            l.a.a("onBeaconsInRange", this.DMT, this.DMD, this.vJP);
            AppMethodBeat.o(213856);
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
    AppMethodBeat.i(213840);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213840);
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
        AppMethodBeat.i(213722);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213722);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213722);
        }
      }
    });
    AppMethodBeat.o(213840);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(213818);
    a(paramString, this.DML, this.DMM, paramb);
    AppMethodBeat.o(213818);
  }
  
  public final void a(String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(213819);
    a((l)l.a.k("[" + paramString + "]", false, this.vJP).remove(0), paramJsapiPermissionWrapper, paramBundle, paramb);
    AppMethodBeat.o(213819);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213872);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(213872);
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
        AppMethodBeat.i(213775);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213775);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213775);
        }
      }
    });
    AppMethodBeat.o(213872);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(213857);
    if (!bt.isNullOrNil(paramString1)) {
      i(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      eLy();
    }
    AppMethodBeat.o(213857);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(213866);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(213866);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(213865);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(213865);
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
        AppMethodBeat.i(213769);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213769);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213769);
        }
      }
    });
    AppMethodBeat.o(213865);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213869);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(213869);
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
          AppMethodBeat.i(213771);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
            AppMethodBeat.o(213771);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213771);
          }
        }
      });
      AppMethodBeat.o(213869);
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
    AppMethodBeat.i(213863);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(213863);
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
        AppMethodBeat.i(213761);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213761);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213761);
        }
      }
    });
    AppMethodBeat.o(213863);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213867);
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
        AppMethodBeat.o(213867);
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
  
  public final String aGD(String paramString)
  {
    AppMethodBeat.i(213822);
    Context localContext = getContext();
    if ((localContext instanceof com.tencent.mm.plugin.webview.core.b))
    {
      paramString = ((com.tencent.mm.plugin.webview.core.b)localContext).aGj(paramString);
      AppMethodBeat.o(213822);
      return paramString;
    }
    AppMethodBeat.o(213822);
    return "";
  }
  
  public final void aGE(String paramString)
  {
    this.DMO = paramString;
  }
  
  public final void aGF(String paramString)
  {
    this.DMP = paramString;
  }
  
  public final void aGG(String paramString)
  {
    AppMethodBeat.i(213832);
    if (!this.BHY)
    {
      AppMethodBeat.o(213832);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = l.a.b("onReceiveMPPageData", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213832);
  }
  
  public final void aGH(String paramString)
  {
    AppMethodBeat.i(213833);
    if (!this.BHY)
    {
      AppMethodBeat.o(213833);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("onMPAdWebviewStateChange", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213833);
  }
  
  public final void aGI(final String paramString)
  {
    AppMethodBeat.i(213842);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(213842);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = l.a.b("activity:state_change", localHashMap, this.DMD, this.vJP);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(213842);
        return;
      }
      catch (Exception paramString)
      {
        ad.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(213842);
        return;
      }
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213728);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(213728);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213728);
        }
      }
    });
    AppMethodBeat.o(213842);
  }
  
  public final void aGJ(final String paramString)
  {
    AppMethodBeat.i(213850);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(213850);
      return;
    }
    if (this.DMA != null) {
      this.DMA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213741);
          l locall = new l();
          locall.xaW = new HashMap();
          locall.xaW.put("username", paramString);
          locall.DNA = new JSONObject();
          locall.type = "call";
          locall.DNz = "";
          locall.kYO = "profile";
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(213741);
        }
      });
    }
    AppMethodBeat.o(213850);
  }
  
  public final void aGK(String paramString)
  {
    AppMethodBeat.i(213853);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213853);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213746);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213746);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213746);
        }
      }
    });
    AppMethodBeat.o(213853);
  }
  
  public final void aGL(String paramString)
  {
    AppMethodBeat.i(213870);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(213870);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213772);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213772);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213772);
        }
      }
    });
    AppMethodBeat.o(213870);
  }
  
  public final void aGN(String paramString)
  {
    AppMethodBeat.i(213881);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213881);
      return;
    }
    if (!x.aNM(getCurrentUrl()))
    {
      AppMethodBeat.o(213881);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = l.a.b("onMenuClick", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213881);
  }
  
  public final void aGO(String paramString)
  {
    AppMethodBeat.i(213883);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213883);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213883);
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
    if (ay.is5G(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange 5g");
      localHashMap.put("networkType", "5g");
    }
    if (ay.isWifi(paramString))
    {
      ad.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
      localHashMap.put("networkType", "wifi");
    }
    if (this.lvv != null) {}
    for (;;)
    {
      try
      {
        i = this.lvv.k(110, new Bundle()).getInt("sim_card_type", 0);
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
          AppMethodBeat.i(213787);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
            AppMethodBeat.o(213787);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213787);
          }
        }
      });
      AppMethodBeat.o(213883);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final boolean aGp(final String paramString)
  {
    AppMethodBeat.i(213811);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(213811);
    return true;
  }
  
  public final boolean aGq(String paramString)
  {
    AppMethodBeat.i(213810);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213810);
      return false;
    }
    boolean bool = x.C(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(213810);
    return bool;
  }
  
  public final void b(com.tencent.mm.plugin.webview.stub.e parame)
  {
    this.lvv = parame;
  }
  
  public final void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213826);
    if (!this.BHY)
    {
      AppMethodBeat.o(213826);
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
      paramString1 = l.a.b("onMPPageAction", localHashMap, this.DMD, this.vJP);
      this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(213826);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213868);
    if ((!this.BHY) || ((paramMap == null) && (paramJSONObject == null)))
    {
      ad.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(213868);
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
    for (paramMap = l.a.b(paramString, paramMap, this.DMD, this.vJP);; paramMap = l.a.a(paramString, paramJSONObject, this.DMD, this.vJP))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213770);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(213770);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(213770);
          }
        }
      };
      if (!aq.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(213868);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    aq.f(paramString);
    AppMethodBeat.o(213868);
  }
  
  public final void b(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(213834);
    ad.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.BHY) });
    if (!this.BHY)
    {
      ad.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      h(bx(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(213834);
      return;
    }
    paramHashMap = WE(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      h(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(213834);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap.put("shareScene", Integer.valueOf(paramInt));
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.lvv.ah("scene", "friend", this.DMF);
      AppMethodBeat.o(213834);
      return;
    }
    catch (Exception paramHashMap)
    {
      ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213834);
    }
  }
  
  public final void bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213861);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(213861);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213751);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213751);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213751);
        }
      }
    });
    AppMethodBeat.o(213861);
  }
  
  public final void br(Context paramContext)
  {
    this.OdW = paramContext;
  }
  
  public final void bw(Map<String, Object> paramMap)
  {
    this.DMB = paramMap;
  }
  
  public final Bundle bx(Map<String, String> paramMap)
  {
    AppMethodBeat.i(213837);
    Bundle localBundle = new Bundle();
    String str1 = this.DMv.getUrl();
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
        localObject = this.DMv.getTitle();
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
          AppMethodBeat.o(213837);
          return localBundle;
          localObject = this.DMv.getTitle();
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
  
  public final void by(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213843);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(213843);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213729);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213729);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213729);
        }
      }
    });
    AppMethodBeat.o(213843);
  }
  
  public final void bz(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213844);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(213844);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = l.a.b("onVoiceRecordEnd", paramMap, this.DMD, this.vJP);
    ad.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213730);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(213730);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213730);
        }
      }
    });
    AppMethodBeat.o(213844);
  }
  
  public final void cn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213804);
    try
    {
      this.lvv.l(paramString, paramBoolean, this.DMF);
      AppMethodBeat.o(213804);
      return;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213804);
    }
  }
  
  public final void cz(int paramInt, String paramString)
  {
    AppMethodBeat.i(213871);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(213871);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213773);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213773);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213773);
        }
      }
    });
    AppMethodBeat.o(213871);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(213823);
    this.BHY = false;
    this.AMx.clear();
    this.DMz.clear();
    this.DMA = null;
    AppMethodBeat.o(213823);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213885);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213885);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213791);
        try
        {
          if (f.f(f.this) != null) {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.DNf + ")", null);
          }
          AppMethodBeat.o(213791);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(213791);
        }
      }
    });
    AppMethodBeat.o(213885);
  }
  
  public final void eLu()
  {
    AppMethodBeat.i(213859);
    if (this.AMx != null) {
      this.AMx.clear();
    }
    AppMethodBeat.o(213859);
  }
  
  public final void eLy()
  {
    AppMethodBeat.i(213858);
    if (this.DMA != null) {
      this.DMA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213749);
          f.e(f.this);
          AppMethodBeat.o(213749);
        }
      });
    }
    AppMethodBeat.o(213858);
  }
  
  public final void eOA()
  {
    AppMethodBeat.i(213812);
    if ((this.DMD) && (x.ffv()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("__event_id", "sys:updateRandomStr");
        localJSONObject2.put("randomStr", this.vJP);
        localJSONObject1.put("__json_message", localJSONObject2);
        this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + localJSONObject1.toString() + ")", new ValueCallback() {});
        AppMethodBeat.o(213812);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(213812);
  }
  
  public final void eOB()
  {
    AppMethodBeat.i(213814);
    ad.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.BHY) });
    if ((this.DMv != null) && (this.BHY)) {
      this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:attach_runOn3rd_apis", eOC(), this.DMD, this.vJP) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(213814);
  }
  
  public final void eOF()
  {
    AppMethodBeat.i(213879);
    ad.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.BHY) });
    if ((this.DMv != null) && (this.BHY)) {
      this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_all_hosts", new HashMap(), this.DMD, this.vJP) + ")", null);
    }
    AppMethodBeat.o(213879);
  }
  
  public final void eOG()
  {
    AppMethodBeat.i(213882);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(213882);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213785);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213785);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213785);
        }
      }
    });
    AppMethodBeat.o(213882);
  }
  
  public final void eOH()
  {
    AppMethodBeat.i(213884);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(213884);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = l.a.b("onNavigationBarRightButtonClick", new HashMap(), this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(213884);
  }
  
  public final long eOI()
  {
    AppMethodBeat.i(213886);
    ad.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.DMX) });
    long l = this.DMX;
    AppMethodBeat.o(213886);
    return l;
  }
  
  public final k eOJ()
  {
    return this.DMY;
  }
  
  public final void eOK()
  {
    AppMethodBeat.i(213887);
    if (!this.BHY)
    {
      AppMethodBeat.o(213887);
      return;
    }
    this.DMY.clear();
    if (this.lvv != null) {
      try
      {
        this.lvv.Xj(this.DMF);
        AppMethodBeat.o(213887);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(213887);
  }
  
  public final void eOw()
  {
    AppMethodBeat.i(213802);
    if (this.DMD != true)
    {
      this.DMD = true;
      if (!com.tencent.matrix.trace.g.b.ea(this.DMv.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = bt.aaz(16);; str = this.DMv.getRandomStr())
    {
      this.vJP = str;
      ad.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.vJP, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213802);
      return;
    }
  }
  
  public final void eOx()
  {
    AppMethodBeat.i(213803);
    this.DMD = true;
    this.vJP = bt.aaz(16);
    this.DMv.setRandomStr(this.vJP);
    ad.i("MicroMsg.JsApiHandler", "js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { this.vJP, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(213803);
  }
  
  public final String eOy()
  {
    return this.vJP;
  }
  
  public final com.tencent.mm.plugin.webview.c.b.a eOz()
  {
    AppMethodBeat.i(213809);
    if (this.DMK == null) {
      this.DMK = new com.tencent.mm.plugin.webview.c.b.a();
    }
    this.DMK.DMr = this.DMv;
    com.tencent.mm.plugin.webview.c.b.a locala = this.DMK;
    AppMethodBeat.o(213809);
    return locala;
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(213890);
    if (aq.isMainThread())
    {
      this.DMv.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(213890);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213793);
        f.f(f.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(213793);
      }
    });
    AppMethodBeat.o(213890);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(213831);
    if (!this.BHY)
    {
      AppMethodBeat.o(213831);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    localHashMap.put("currentTime", paramString4);
    localHashMap.put("playedTotalTime", paramString5);
    paramString1 = l.a.b("onMPVideoStateChange", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(213831);
  }
  
  public final void fA(String paramString, int paramInt)
  {
    AppMethodBeat.i(213829);
    if (!this.BHY)
    {
      AppMethodBeat.o(213829);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = l.a.b("onMPPageAction", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213829);
  }
  
  public final void fB(String paramString, int paramInt)
  {
    AppMethodBeat.i(213841);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(213841);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(213841);
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
          AppMethodBeat.i(213723);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
            AppMethodBeat.o(213723);
            return;
          }
          catch (Exception localException)
          {
            ad.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213723);
          }
        }
      });
      AppMethodBeat.o(213841);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void fC(String paramString, int paramInt)
  {
    AppMethodBeat.i(213845);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(213845);
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
        AppMethodBeat.i(213733);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213733);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213733);
        }
      }
    });
    AppMethodBeat.o(213845);
  }
  
  public final void fD(String paramString, int paramInt)
  {
    AppMethodBeat.i(213846);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(213846);
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
        AppMethodBeat.i(213734);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213734);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213734);
        }
      }
    });
    AppMethodBeat.o(213846);
  }
  
  public final void fE(String paramString, int paramInt)
  {
    AppMethodBeat.i(213847);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(213847);
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
        AppMethodBeat.i(213735);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213735);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213735);
        }
      }
    });
    AppMethodBeat.o(213847);
  }
  
  public final void fF(String paramString, int paramInt)
  {
    AppMethodBeat.i(213848);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(213848);
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
        AppMethodBeat.i(213736);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213736);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213736);
        }
      }
    });
    AppMethodBeat.o(213848);
  }
  
  public final void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(213849);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(213849);
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
        AppMethodBeat.i(213737);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213737);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213737);
        }
      }
    });
    AppMethodBeat.o(213849);
  }
  
  final String fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(213855);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = aGM(l.a.b("onGetA8KeyUrl", localHashMap, this.DMD, this.vJP));
    AppMethodBeat.o(213855);
    return paramString;
  }
  
  public final void fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(213876);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(213876);
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
        AppMethodBeat.i(213780);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213780);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213780);
        }
      }
    });
    AppMethodBeat.o(213876);
  }
  
  public final void fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(213827);
    if (!this.BHY)
    {
      AppMethodBeat.o(213827);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = l.a.b("onMPPageAction", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213827);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(213875);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(213875);
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
        AppMethodBeat.i(213779);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213779);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(213779);
        }
      }
    });
    AppMethodBeat.o(213875);
  }
  
  public final int getBinderID()
  {
    return this.DMF;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(213821);
    if (this.DMN)
    {
      if (this.OdW != null)
      {
        localContext = this.OdW;
        AppMethodBeat.o(213821);
        return localContext;
      }
      localContext = aj.getContext();
      AppMethodBeat.o(213821);
      return localContext;
    }
    if (this.DMv == null)
    {
      AppMethodBeat.o(213821);
      return null;
    }
    Context localContext = this.DMv.getActivityContextIfHas();
    AppMethodBeat.o(213821);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(213889);
    if (this.DMv == null)
    {
      AppMethodBeat.o(213889);
      return "";
    }
    String str = this.DMv.getUrl();
    AppMethodBeat.o(213889);
    return str;
  }
  
  public final z getSettings()
  {
    AppMethodBeat.i(213801);
    z localz = this.DMv.getSettings();
    AppMethodBeat.o(213801);
    return localz;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(213888);
    String str = (String)this.DMB.get("srcUsername");
    AppMethodBeat.o(213888);
    return str;
  }
  
  public final void h(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(213838);
    if (paramBundle == null)
    {
      ad.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(213838);
      return;
    }
    if (this.DMA != null) {
      this.DMA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213797);
          l locall = new l();
          locall.xaW = new HashMap();
          locall.xaW.put("link", paramBundle.getString("link"));
          locall.xaW.put("title", paramBundle.getString("title"));
          locall.xaW.put("desc", paramBundle.getString("desc"));
          locall.DNA = new JSONObject();
          locall.xaW.put("img_url", paramBundle.getString("img_url"));
          locall.xaW.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          locall.type = "call";
          locall.DNz = "";
          locall.kYO = paramString;
          f.d(f.this).add(locall);
          f.e(f.this);
          AppMethodBeat.o(213797);
        }
      });
    }
    AppMethodBeat.o(213838);
  }
  
  public final void i(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(213839);
    if ((!this.BHY) || (paramBundle == null))
    {
      ad.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213839);
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
        AppMethodBeat.i(213721);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213721);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213721);
        }
      }
    });
    AppMethodBeat.o(213839);
  }
  
  public final void i(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213860);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      ad.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(213860);
      return;
    }
    if (this.gpP.containsKey(paramString1))
    {
      ((b)this.gpP.get(paramString1)).i(paramString1, paramString2, paramMap);
      this.gpP.remove(paramString1);
      AppMethodBeat.o(213860);
      return;
    }
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(213860);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      ad.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      localHashMap.putAll(paramMap);
    }
    paramString1 = l.a.a(paramString1, localHashMap, this.DMD, this.vJP);
    ad.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.DMv != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213750);
          try
          {
            f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(213750);
            return;
          }
          catch (Exception localException)
          {
            ad.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(213750);
          }
        }
      };
      if (aq.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(213860);
        return;
      }
      aq.f(paramString1);
    }
    AppMethodBeat.o(213860);
  }
  
  public final boolean isReady()
  {
    return this.BHY;
  }
  
  public final void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(213862);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(213862);
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
        AppMethodBeat.i(213757);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213757);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213757);
        }
      }
    });
    AppMethodBeat.o(213862);
  }
  
  public final void kO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213828);
    if (!this.BHY)
    {
      AppMethodBeat.o(213828);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = l.a.b("onMPPageAction", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(213828);
  }
  
  public final void kP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213864);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(213864);
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
        AppMethodBeat.i(213766);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", new ValueCallback() {});
          AppMethodBeat.o(213766);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213766);
        }
      }
    });
    AppMethodBeat.o(213864);
  }
  
  public final void m(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(213835);
    ad.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(this.BHY) });
    if (!this.BHY) {
      try
      {
        this.lvv.ah("scene", "favorite", this.DMF);
        h(bx(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(213835);
        return;
      }
      catch (Exception paramHashMap)
      {
        ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
        AppMethodBeat.o(213835);
        return;
      }
    }
    paramHashMap = WE(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false))) {
      try
      {
        this.lvv.ah("scene", "favorite", this.DMF);
        h(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(213835);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException.getMessage());
        }
      }
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "favorite");
    paramHashMap = l.a.b("menu:share:appmessage", paramHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.lvv.ah("scene", "favorite", this.DMF);
      AppMethodBeat.o(213835);
      return;
    }
    catch (Exception paramHashMap)
    {
      ad.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213835);
    }
  }
  
  public final void u(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213825);
    if (!this.BHY)
    {
      AppMethodBeat.o(213825);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = l.a.b("menu:haokan", localHashMap, this.DMD, this.vJP);
    this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213825);
  }
  
  public final void uW(boolean paramBoolean)
  {
    AppMethodBeat.i(213813);
    this.BHY = paramBoolean;
    ad.i("MicroMsg.JsApiHandler", "js ready now");
    AppMethodBeat.o(213813);
  }
  
  public final void uX(boolean paramBoolean)
  {
    AppMethodBeat.i(213852);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213852);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213745);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213745);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213745);
        }
      }
    });
    AppMethodBeat.o(213852);
  }
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(213878);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(213878);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213782);
        try
        {
          f.f(f.this).evaluateJavascript(this.DNf, null);
          AppMethodBeat.o(213782);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213782);
        }
      }
    });
    AppMethodBeat.o(213878);
  }
  
  public final void uZ(boolean paramBoolean)
  {
    AppMethodBeat.i(213880);
    ad.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.BHY) });
    if ((this.DMv != null) && (this.lvv != null) && (this.BHY)) {
      if (paramBoolean)
      {
        this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.DMD, this.vJP) + ")", null);
        AppMethodBeat.o(213880);
        return;
      }
    }
    try
    {
      List localList = this.lvv.eRG();
      Uri localUri = Uri.parse(this.DMv.getUrl());
      if (localUri != null) {
        ad.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:get_html_content", new HashMap(), this.DMD, this.vJP) + ")", null);
      }
      AppMethodBeat.o(213880);
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
  
  public final void v(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213873);
    if (!this.BHY)
    {
      ad.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(213873);
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
        AppMethodBeat.i(213776);
        try
        {
          f.f(f.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.lBE + ")", null);
          AppMethodBeat.o(213776);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213776);
        }
      }
    });
    AppMethodBeat.o(213873);
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