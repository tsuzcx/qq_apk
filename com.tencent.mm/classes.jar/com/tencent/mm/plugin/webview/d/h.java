package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.aa;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  implements b, c, d, com.tencent.mm.plugin.webview.d.d.a
{
  public String EVx;
  private final LinkedList<n> LIS;
  public boolean NoX;
  public e PGM;
  private a PNA;
  private Set<String> PNB;
  private boolean PNC;
  public String PND;
  com.tencent.mm.b.h PNE;
  private com.tencent.mm.plugin.webview.d.b.a PNF;
  private p PNG;
  private JsapiPermissionWrapper PNH;
  private Bundle PNI;
  private boolean PNJ;
  public String PNK;
  public String PNL;
  private final List<String> PNM;
  volatile String PNN;
  volatile int PNO;
  private JSONObject PNP;
  private JSONArray PNQ;
  private List<String> PNR;
  private MTimerHandler PNS;
  public long PNT;
  private k PNU;
  public MMWebView PNp;
  private Context PNs;
  private final List<String> PNt;
  private MMHandler PNu;
  private long PNv;
  private boolean PNw;
  public boolean PNx;
  public boolean PNy;
  public int PNz;
  public Map<String, Object> fPy;
  private boolean isActive;
  HashMap<String, b> jPb;
  public com.tencent.mm.plugin.webview.stub.e pGC;
  private g pIm;
  
  public h()
  {
    AppMethodBeat.i(213155);
    this.PNt = new LinkedList();
    this.LIS = new LinkedList();
    this.PNu = null;
    this.NoX = false;
    this.isActive = true;
    this.PNv = 0L;
    this.PNw = false;
    this.PNx = false;
    this.EVx = "";
    this.PNy = false;
    this.PNB = null;
    this.PNC = false;
    this.PGM = null;
    com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
    this.PNE = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.n.gTe());
    this.PNF = null;
    this.PNG = null;
    this.jPb = new HashMap();
    this.PNJ = false;
    this.PNM = new LinkedList();
    this.PNN = null;
    this.PNO = 0;
    this.PNP = new JSONObject();
    this.PNQ = new JSONArray();
    this.PNR = new LinkedList();
    this.PNS = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206945);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(206945);
        return false;
      }
    }, false);
    this.PNT = 0L;
    AppMethodBeat.o(213155);
  }
  
  public h(MMWebView paramMMWebView, g paramg, int paramInt)
  {
    AppMethodBeat.i(213157);
    this.PNt = new LinkedList();
    this.LIS = new LinkedList();
    this.PNu = null;
    this.NoX = false;
    this.isActive = true;
    this.PNv = 0L;
    this.PNw = false;
    this.PNx = false;
    this.EVx = "";
    this.PNy = false;
    this.PNB = null;
    this.PNC = false;
    this.PGM = null;
    com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
    this.PNE = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.n.gTe());
    this.PNF = null;
    this.PNG = null;
    this.jPb = new HashMap();
    this.PNJ = false;
    this.PNM = new LinkedList();
    this.PNN = null;
    this.PNO = 0;
    this.PNP = new JSONObject();
    this.PNQ = new JSONArray();
    this.PNR = new LinkedList();
    this.PNS = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206945);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(206945);
        return false;
      }
    }, false);
    this.PNT = 0L;
    this.PNp = paramMMWebView;
    this.pIm = paramg;
    this.PNz = paramInt;
    gTK();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213157);
      return;
    }
  }
  
  public h(MMWebView paramMMWebView, g paramg, int paramInt, e parame)
  {
    AppMethodBeat.i(213158);
    this.PNt = new LinkedList();
    this.LIS = new LinkedList();
    this.PNu = null;
    this.NoX = false;
    this.isActive = true;
    this.PNv = 0L;
    this.PNw = false;
    this.PNx = false;
    this.EVx = "";
    this.PNy = false;
    this.PNB = null;
    this.PNC = false;
    this.PGM = null;
    com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
    this.PNE = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.n.gTe());
    this.PNF = null;
    this.PNG = null;
    this.jPb = new HashMap();
    this.PNJ = false;
    this.PNM = new LinkedList();
    this.PNN = null;
    this.PNO = 0;
    this.PNP = new JSONObject();
    this.PNQ = new JSONArray();
    this.PNR = new LinkedList();
    this.PNS = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206945);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(206945);
        return false;
      }
    }, false);
    this.PNT = 0L;
    this.PNp = paramMMWebView;
    this.pIm = paramg;
    this.PNz = paramInt;
    this.PGM = parame;
    gTK();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, jsApiPool: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), parame });
      AppMethodBeat.o(213158);
      return;
    }
  }
  
  public h(MMWebView paramMMWebView, g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(213160);
    this.PNt = new LinkedList();
    this.LIS = new LinkedList();
    this.PNu = null;
    this.NoX = false;
    this.isActive = true;
    this.PNv = 0L;
    this.PNw = false;
    this.PNx = false;
    this.EVx = "";
    this.PNy = false;
    this.PNB = null;
    this.PNC = false;
    this.PGM = null;
    com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
    this.PNE = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.n.gTe());
    this.PNF = null;
    this.PNG = null;
    this.jPb = new HashMap();
    this.PNJ = false;
    this.PNM = new LinkedList();
    this.PNN = null;
    this.PNO = 0;
    this.PNP = new JSONObject();
    this.PNQ = new JSONArray();
    this.PNR = new LinkedList();
    this.PNS = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206945);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(206945);
        return false;
      }
    }, false);
    this.PNT = 0L;
    this.PNp = paramMMWebView;
    this.pIm = paramg;
    this.PNz = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.PNB = paramg;
    this.PNC = true;
    gTK();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213160);
      return;
    }
  }
  
  /* Error */
  private static boolean Q(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 406
    //   3: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 412	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 370
    //   20: ldc_w 414
    //   23: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 406
    //   29: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 420	com/tencent/mm/vfs/q
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 423	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 427	com/tencent/mm/vfs/q:ifE	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 430	com/tencent/mm/vfs/q:ifM	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 436	com/tencent/mm/vfs/u:e	(Lcom/tencent/mm/vfs/q;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 442 1 0
    //   77: invokeinterface 448 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 453 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 457 1 0
    //   101: checkcast 459	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 463 2 0
    //   114: checkcast 374	java/lang/Integer
    //   117: invokevirtual 466	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 468	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 473	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 475
    //   136: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 482	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 486	java/lang/String:getBytes	()[B
    //   150: invokevirtual 492	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 494	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 494	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 370
    //   174: aload_1
    //   175: ldc_w 284
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 370
    //   188: ldc_w 500
    //   191: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 503	java/io/OutputStream:close	()V
    //   202: ldc_w 406
    //   205: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 370
    //   214: ldc_w 505
    //   217: aload_0
    //   218: invokestatic 508	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 370
    //   230: aload_1
    //   231: ldc_w 284
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 406
    //   244: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 517	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 503	java/io/OutputStream:close	()V
    //   261: ldc_w 370
    //   264: ldc_w 519
    //   267: aload_0
    //   268: invokestatic 508	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 522	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 406
    //   280: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 370
    //   289: aload_1
    //   290: ldc_w 284
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 370
    //   307: aload_0
    //   308: ldc_w 284
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 503	java/io/OutputStream:close	()V
    //   332: ldc_w 406
    //   335: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 370
    //   344: aload_1
    //   345: ldc_w 284
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private boolean a(final n paramn, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(213233);
    if (paramn == null)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(213233);
      return true;
    }
    if (("getBrandWCPayRequest".equals(paramn.function)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      AppMethodBeat.o(213233);
      return true;
    }
    if ((Arrays.asList(new String[] { "getBrandWCPayBindCardRequest", "openWCPaySpecificView", "verifyWCPayPassword", "getH5TransactionRequest", "getH5PrepayRequest", "getWCPayRealnameVerify", "selectWalletCurrency", "changePayActivityView", "unbindBankCard", "uploadIdCardSuccess", "idCardRealnameVerify", "setWCPayPassword", "handleWCPayWalletBuffer", "faceVerifyForPay" }).contains(paramn.function)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      AppMethodBeat.o(213233);
      return true;
    }
    if (this.PNw)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, floating now");
      AppMethodBeat.o(213233);
      return true;
    }
    if ((paramn.function == null) || (paramn.params == null) || (paramn.type == null) || ((!this.PNJ) && (this.PNp == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paramn.function + ", params = " + paramn.params + ", type = " + paramn.type + ", wv = " + this.PNp);
      AppMethodBeat.o(213233);
      return true;
    }
    if ((this.PNC) && ((this.PNB == null) || (!this.PNB.contains(paramn.function))))
    {
      Log.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paramn.function });
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206581);
          h.this.h(paramn.POu, "system:access_denied", null);
          AppMethodBeat.o(206581);
        }
      });
      AppMethodBeat.o(213233);
      return true;
    }
    if (paramBundle != null) {
      paramn.PNI = paramBundle;
    }
    if (paramb != null) {
      this.jPb.put(paramn.POu, paramb);
    }
    if ((this.fPy != null) && (this.fPy.get("srcUsername") != null) && (!Util.isNullOrNil(this.fPy.get("srcUsername").toString()))) {
      paramn.params.put("src_username", this.fPy.get("srcUsername").toString());
    }
    if ((this.fPy != null) && (this.fPy.get("srcDisplayname") != null) && (!Util.isNullOrNil(this.fPy.get("srcDisplayname").toString()))) {
      paramn.params.put("src_displayname", this.fPy.get("srcDisplayname").toString());
    }
    if ((this.fPy != null) && (this.fPy.get("KTemplateId") != null) && (!Util.isNullOrNil(this.fPy.get("KTemplateId").toString()))) {
      paramn.params.put("tempalate_id", this.fPy.get("KTemplateId").toString());
    }
    if (this.fPy != null)
    {
      paramn.params.put("message_id", this.fPy.get("message_id"));
      paramn.params.put("message_index", this.fPy.get("message_index"));
      paramn.params.put("webview_scene", this.fPy.get("scene"));
      paramn.params.put("pay_channel", this.fPy.get("pay_channel"));
      paramn.params.put("pay_scene", this.fPy.get("pay_scene"));
      Log.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.fPy.get("pay_package") });
      if (this.fPy.get("pay_package") != null) {
        paramn.params.put("pay_packageName", this.fPy.get("pay_package"));
      }
      paramn.params.put("stastic_scene", this.fPy.get("stastic_scene"));
      paramn.params.put("open_from_scene", this.fPy.get("from_scence"));
      paramBundle = paramn.params;
      paramb = new Bundle();
      paramb.putString("__jsapi_fw_ext_info_key_current_url", this.PNp.getUrl());
      paramBundle.put("__jsapi_fw_ext_info", paramb);
    }
    if ((this.PNp != null) && (!paramn.function.equals("shareWeibo")) && (!paramn.function.equals("openUrlByExtBrowser")) && (!paramn.function.equals("log")) && (!paramn.function.equals("openUrlWithExtraWebview")) && (!paramn.function.equals("openCustomWebview")) && (!paramn.function.equals("openGameWebView")) && (!paramn.function.equals("addToEmoticon")) && (!paramn.function.equals("shareEmoticon")) && (!paramn.function.equals("openGameUrlWithExtraWebView")) && (!paramn.function.equals("request")))
    {
      paramn.params.put("url", this.PNp.getUrl());
      Log.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.PNp.getUrl());
    }
    if ((paramn.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.function.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paramn.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.function.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paramn.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.function.equalsIgnoreCase("openDesignerProfile")) || (paramn.function.equalsIgnoreCase("openDesignerProfileLocal")) || (paramn.function.equalsIgnoreCase("getSearchEmotionData")))
    {
      paramn.params.put("searchID", Long.valueOf(gUb()));
      Log.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(gUb()) });
    }
    if (paramn.function.equals("request"))
    {
      if (this.PNK != null) {
        paramn.params.put("key_request_full_url_query", this.PNK);
      }
      if (this.PNL != null) {
        paramn.params.put("key_request_header", this.PNL);
      }
    }
    if (paramn.function.equals("imagePreview")) {
      j.a(paramn.params, this.PNp);
    }
    if ((paramn.function.equals("preVerifyJSAPI")) && (paramn.params.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.l.c.hcE();
    }
    bool1 = false;
    boolean bool3 = false;
    if (paramJsapiPermissionWrapper != null) {
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        localBundle1 = new Bundle();
        if (paramJsapiPermissionWrapper != null)
        {
          bool2 = bool1;
          localBundle1.putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.RBg);
          bool2 = bool1;
          localBundle1.putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.RBh);
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.hpb());
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.hpc());
        }
        bool2 = bool1;
        paramb = n.bQ(paramn.params);
        bool2 = bool1;
        if (!Util.isNullOrNil(this.PND))
        {
          bool2 = bool1;
          paramb.putString("key_wxapp_id", this.PND);
        }
        bool2 = bool1;
        localBundle2 = new Bundle(3);
        paramBundle = paramb;
        bool2 = bool1;
        if (paramn.PNI != null)
        {
          bool2 = bool1;
          localBundle2.putBundle("jsEngine", paramn.PNI);
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
        if (paramn.POv != null)
        {
          bool2 = bool1;
          localBundle2.putString("rawParams", paramn.POv.toString());
        }
        bool2 = bool1;
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paramn.function });
        bool2 = bool1;
        if (this.PNA != null)
        {
          bool2 = bool1;
          bool3 = this.PNA.b(paramn);
        }
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          paramJsapiPermissionWrapper = new f(getContext(), paramJsapiPermissionWrapper, this.pGC, this, this.PNp);
          bool2 = bool3;
          paramBundle = r.POE;
          bool2 = bool3;
          bool1 = r.a(paramJsapiPermissionWrapper, paramn);
        }
        if (bool1) {
          i = 1;
        }
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        Bundle localBundle1;
        Bundle localBundle2;
        int i = 0;
        bool1 = bool2;
        Log.printErrStackTrace("MicroMsg.JsApiHandler", paramJsapiPermissionWrapper, "", new Object[0]);
        Log.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + paramJsapiPermissionWrapper.getMessage());
        continue;
        AppMethodBeat.o(213233);
        return false;
      }
      try
      {
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paramn.function });
        i = 1;
        j.gWA();
        Log.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paramn.function, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          continue;
        }
        AppMethodBeat.o(213233);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        continue;
        continue;
      }
      bool2 = bool1;
      paramJsapiPermissionWrapper = this.pIm.gWI();
      break;
      bool2 = bool1;
      if ((this.pGC == null) || (paramn == null)) {
        break label1943;
      }
      bool2 = bool1;
      bool1 = this.pGC.a(paramn.type, paramn.function, paramn.POu, localBundle1, localBundle2, this.PNz);
      i = 0;
    }
  }
  
  private void bRP()
  {
    try
    {
      AppMethodBeat.i(213178);
      if (this.PNE.size() > 0)
      {
        Iterator localIterator = this.PNE.entrySet().iterator();
        while ((!gTO()) && (localIterator.hasNext()))
        {
          String str = (String)((Map.Entry)localIterator.next()).getValue();
          if (!Util.isNullOrNil(str)) {
            _sendMessage(str);
          }
        }
        this.PNE.clear();
      }
    }
    finally {}
    AppMethodBeat.o(213178);
  }
  
  /* Error */
  private boolean bjV(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 940
    //   5: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 927	com/tencent/mm/plugin/webview/d/h:gTO	()Z
    //   12: ifeq +10 -> 22
    //   15: aload_1
    //   16: invokestatic 412	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   19: ifeq +15 -> 34
    //   22: iconst_0
    //   23: istore_2
    //   24: ldc_w 940
    //   27: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 310	com/tencent/mm/plugin/webview/d/h:PNE	Lcom/tencent/mm/b/h;
    //   38: aload_1
    //   39: invokevirtual 941	java/lang/String:hashCode	()I
    //   42: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aload_1
    //   46: invokevirtual 942	com/tencent/mm/b/h:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 940
    //   55: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -28 -> 30
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	h
    //   0	66	1	paramString	String
    //   23	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	61	finally
    //   24	30	61	finally
    //   34	50	61	finally
    //   52	58	61	finally
  }
  
  public static String bkc(String paramString)
  {
    AppMethodBeat.i(213374);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { Util.nullAsNil(paramString) });
    AppMethodBeat.o(213374);
    return paramString;
  }
  
  private String bkf(String paramString)
  {
    AppMethodBeat.i(213411);
    String str1 = this.PNp.getUrl();
    try
    {
      String str2 = com.tencent.mm.b.n.fS(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.aSR() + str2;
      Log.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(213411);
      return str2;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(213411);
    }
    return null;
  }
  
  private void gTK()
  {
    AppMethodBeat.i(213161);
    this.PNu = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(207750);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(207750);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!Util.isNullOrNil(paramAnonymousMessage)) {
            h.b(h.this).add(paramAnonymousMessage);
          }
          h.c(h.this);
          AppMethodBeat.o(207750);
          return;
          Log.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(213161);
  }
  
  private boolean gTO()
  {
    AppMethodBeat.i(213173);
    if (!this.isActive)
    {
      com.tencent.mm.plugin.webview.core.n localn = com.tencent.mm.plugin.webview.core.n.PJr;
      if (((Boolean)com.tencent.mm.plugin.webview.core.n.PJo.getValue()).booleanValue())
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.PNv;
        localn = com.tencent.mm.plugin.webview.core.n.PJr;
        if (l1 - l2 > ((Number)com.tencent.mm.plugin.webview.core.n.PJm.getValue()).intValue())
        {
          AppMethodBeat.o(213173);
          return true;
        }
      }
    }
    AppMethodBeat.o(213173);
    return false;
  }
  
  private Map<String, Object> gTT()
  {
    AppMethodBeat.i(213209);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.pIm.gWI();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.so(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.so(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.so(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.so(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.so(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.so(219)) {
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
      localLinkedList.add("onWindowFocusChanged");
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
      localLinkedList.add("onNavShadowClick");
      localLinkedList.add("onSearchWAWidgetOpenApp");
      localLinkedList.add("onSearchDataReady");
      localLinkedList.add("onCurrentLocationReady");
      localLinkedList.add("onClientNavAction");
      localLinkedList.add("onNavBarShadowManuallyHidden");
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
      localLinkedList.add("onGetVertSearchEntriesData");
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
      if (!Util.isNullOrNil(null)) {
        localLinkedList.addAll(null);
      }
      localLinkedList.add("onReceivePageData");
      localLinkedList.add("onPageAuthOK");
      localLinkedList.add("onScrollViewDidScroll");
      localLinkedList.add("onPublishHaowanEnd");
      localLinkedList.add("onPublishHaowanProgress");
      localLinkedList.add("onAccessibilityStateChange");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(213209);
    return localHashMap;
  }
  
  private boolean gTU()
  {
    AppMethodBeat.i(213210);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.pGC.aol(this.PNz);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException.getMessage());
      }
    }
    Log.i("MicroMsg.JsApiHandler", "checkIsMsgQueueBusy isBusy = ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(213210);
    return bool1;
  }
  
  private void gTV()
  {
    AppMethodBeat.i(213213);
    while (gTW()) {}
    AppMethodBeat.o(213213);
  }
  
  private boolean gTW()
  {
    AppMethodBeat.i(213216);
    if (Util.isNullOrNil(this.LIS))
    {
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(213216);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.pGC.aol(this.PNz);
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(213216);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiHandler", "isBusy, ex = " + localException.getMessage());
        bool = false;
      }
      if (this.LIS.size() == 0)
      {
        Log.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(213216);
        return false;
      }
      n localn = (n)this.LIS.remove(0);
      if (localn == null)
      {
        Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
        AppMethodBeat.o(213216);
        return true;
      }
      bool = a(localn, localn.PvI, localn.PNI, localn.PvG);
      AppMethodBeat.o(213216);
    }
    return bool;
  }
  
  /* Error */
  private static boolean mw(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1338
    //   3: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 412	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 412	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 370
    //   23: ldc_w 414
    //   26: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1338
    //   32: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 420	com/tencent/mm/vfs/q
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 423	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 427	com/tencent/mm/vfs/q:ifE	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 430	com/tencent/mm/vfs/q:ifM	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1342	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 486	java/lang/String:getBytes	()[B
    //   84: invokevirtual 492	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 494	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 494	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 517	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 503	java/io/OutputStream:close	()V
    //   134: ldc_w 370
    //   137: ldc_w 519
    //   140: aload_0
    //   141: invokestatic 508	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 522	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1338
    //   153: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 370
    //   162: ldc_w 505
    //   165: aload_0
    //   166: invokestatic 508	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 370
    //   178: aload_1
    //   179: ldc_w 284
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1338
    //   192: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 370
    //   201: aload_1
    //   202: ldc_w 284
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 370
    //   221: aload_0
    //   222: ldc_w 284
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 370
    //   237: ldc_w 500
    //   240: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 503	java/io/OutputStream:close	()V
    //   251: ldc_w 1338
    //   254: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 370
    //   263: aload_0
    //   264: ldc_w 284
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 503	java/io/OutputStream:close	()V
    //   286: ldc_w 1338
    //   289: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 370
    //   298: aload_1
    //   299: ldc_w 284
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void CQ(boolean paramBoolean)
  {
    AppMethodBeat.i(213200);
    this.NoX = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "js ready %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(213200);
  }
  
  public final void CR(boolean paramBoolean)
  {
    AppMethodBeat.i(213202);
    this.PNw = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "setIsFloating %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(213202);
  }
  
  public final void CS(boolean paramBoolean)
  {
    AppMethodBeat.i(213326);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213326);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205526);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(205526);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205526);
        }
      }
    });
    AppMethodBeat.o(213326);
  }
  
  public final void CT(boolean paramBoolean)
  {
    AppMethodBeat.i(213378);
    setActive(paramBoolean);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(213378);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215915);
        try
        {
          h.f(h.this).evaluateJavascript(this.POc, null);
          AppMethodBeat.o(215915);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(215915);
        }
      }
    });
    AppMethodBeat.o(213378);
  }
  
  public final void CU(boolean paramBoolean)
  {
    AppMethodBeat.i(213383);
    Log.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.NoX) });
    if ((this.PNp != null) && (this.pGC != null) && (this.NoX)) {
      if (paramBoolean)
      {
        this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.PNx, this.EVx) + ")", null);
        AppMethodBeat.o(213383);
        return;
      }
    }
    try
    {
      List localList = this.pGC.gXl();
      Uri localUri = Uri.parse(this.PNp.getUrl());
      if (localUri != null) {
        Log.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.PNx, this.EVx) + ")", null);
      }
      AppMethodBeat.o(213383);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void O(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(213329);
    Log.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213329);
      return;
    }
    this.PNN = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.PNO = 1;; this.PNO = 0)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206810);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.my(MMApplicationContext.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.ivX();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localc.setCookie(Util.getDomin(paramString), str + "=" + (String)paramMap.get(str));
            }
            localException.setCookie(Util.getDomin(paramString), "httponly");
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(206810);
            return;
          }
          com.tencent.xweb.d.ivZ();
          com.tencent.xweb.d.sync();
          Log.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(Util.getDomin(paramString)) });
          label188:
          h.f(h.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          h.f(h.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (h.g(h.this))
          {
            h.f(h.this).evaluateJavascript(this.PNY, null);
            h.h(h.this);
            h.i(h.this);
          }
          AppMethodBeat.o(206810);
        }
      });
      AppMethodBeat.o(213329);
      return;
    }
  }
  
  public final void P(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213392);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready, event=%s", new Object[] { paramString });
      AppMethodBeat.o(213392);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207287);
        try
        {
          if (h.f(h.this) != null) {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.POc + ")", null);
          }
          AppMethodBeat.o(207287);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(207287);
        }
      }
    });
    AppMethodBeat.o(213392);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(213183);
    if (paramString != null) {
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207158);
          Map localMap = h.U(paramString.split(","));
          String str = h.a(h.this, "hosts");
          if (h.R(str, localMap))
          {
            if ((h.n(h.this) == null) || (h.f(h.this) == null)) {
              break label118;
            }
            try
            {
              h.n(h.this).Y(0, h.f(h.this).getUrl(), str);
              AppMethodBeat.o(207158);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(207158);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(207158);
        }
      });
    }
    AppMethodBeat.o(213183);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(213185);
    if ((ab.hnT()) && (!this.PNy))
    {
      AppMethodBeat.o(213185);
      return "";
    }
    String str = this.EVx;
    AppMethodBeat.o(213185);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(213184);
    if (paramString != null) {
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206450);
          String str = h.a(h.this, "html");
          if (h.mx(str, paramString))
          {
            if ((h.n(h.this) == null) || (h.f(h.this) == null)) {
              break label108;
            }
            try
            {
              h.n(h.this).Y(1, h.f(h.this).getUrl(), str);
              AppMethodBeat.o(206450);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(206450);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(206450);
        }
      });
    }
    AppMethodBeat.o(213184);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.PNx;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.NoX = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(213182);
    if (bjV(paramString))
    {
      Log.d("MicroMsg.JsApiHandler", "_sendMessage pendingJsApi");
      AppMethodBeat.o(213182);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.PNu != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.PNu.sendMessage(localMessage);
      AppMethodBeat.o(213182);
      return;
    }
    Log.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(213182);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(213368);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(213368);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("reqId", Long.valueOf(paramLong));
    localHashMap.put("json", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213018);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(213018);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(213018);
        }
      }
    });
    AppMethodBeat.o(213368);
  }
  
  public final void a(a parama)
  {
    this.PNA = parama;
  }
  
  public final void a(n paramn, b paramb)
  {
    AppMethodBeat.i(213222);
    a(paramn, this.PNH, this.PNI, paramb);
    AppMethodBeat.o(213222);
  }
  
  public final void a(com.tencent.mm.plugin.webview.stub.e parame)
  {
    this.pGC = parame;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle)
  {
    this.PNH = paramJsapiPermissionWrapper;
    this.PNI = paramBundle;
    this.PNJ = true;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213333);
        if (this.PNS.stopped()) {
          this.PNS.startTimer(1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.PNR.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.PNR.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.PNQ.put(localJSONObject);
              this.PNP.put("beacons", this.PNQ);
              this.PNP.put("err_msg", "onBeaconsInRange:ok");
            }
            n.a.a("onBeaconsInRange", this.PNP, this.PNx, this.EVx);
            AppMethodBeat.o(213333);
            return;
          }
          catch (Exception paramString)
          {
            Log.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[] { paramString.getMessage() });
            continue;
          }
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213252);
    if (!this.NoX)
    {
      AppMethodBeat.o(213252);
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
      paramString1 = n.a.b("onMPPageAction", localHashMap, this.PNx, this.EVx);
      this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(213252);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(213282);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213282);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", paramString);
    localHashMap.put("download_id", Long.valueOf(paramLong));
    localHashMap.put("progress", Integer.valueOf(paramInt));
    localHashMap.put("progress_float", Float.valueOf(paramFloat));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207231);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(207231);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207231);
        }
      }
    });
    AppMethodBeat.o(213282);
  }
  
  public final void a(final String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(213224);
    paramString = (n)n.a.j("[" + paramString + "]", false, this.EVx).remove(0);
    if ((paramString != null) && (gTU()) && (this.PNu != null))
    {
      paramString.PNI = paramBundle;
      paramString.PvI = paramJsapiPermissionWrapper;
      paramString.PvG = paramb;
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206173);
          h.a(h.this, paramString);
          AppMethodBeat.o(206173);
        }
      });
      AppMethodBeat.o(213224);
      return;
    }
    a(paramString, paramJsapiPermissionWrapper, paramBundle, paramb);
    AppMethodBeat.o(213224);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(213363);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(213363);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString1);
    localHashMap.put("thumbPath", paramString2);
    localHashMap.put("tab", Integer.valueOf(paramInt1));
    localHashMap.put("asyncDownload", Integer.valueOf(paramInt2));
    localHashMap.put("emojiUrl", paramString3);
    localHashMap.put("aesKey", paramString4);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216006);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(216006);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(216006);
        }
      }
    });
    AppMethodBeat.o(213363);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(213334);
    if (!Util.isNullOrNil(paramString1)) {
      h(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      gPJ();
    }
    AppMethodBeat.o(213334);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(213352);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(213352);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(213350);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(213350);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    localHashMap.put("isCancelButtonClick", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210066);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(210066);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(210066);
        }
      }
    });
    AppMethodBeat.o(213350);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213357);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(213357);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[] { paramString1, paramString2, paramJSONArray.toString() });
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
                Log.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException1, "", new Object[0]);
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
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211946);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
            AppMethodBeat.o(211946);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(211946);
          }
        }
      });
      AppMethodBeat.o(213357);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final Bundle anI(int paramInt)
  {
    AppMethodBeat.i(213263);
    try
    {
      Object localObject = this.PNp;
      if (localObject == null)
      {
        AppMethodBeat.o(213263);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.PNz);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.PNp.getUrl());
      localObject = this.pGC.l(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(213263);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(213263);
    }
    return null;
  }
  
  public final void anJ(int paramInt)
  {
    AppMethodBeat.i(292873);
    lx(paramInt, 0);
    AppMethodBeat.o(292873);
  }
  
  public final void anz(int paramInt)
  {
    AppMethodBeat.i(213248);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(213248);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = n.a.b("menu:setfont", (Map)localObject, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(213248);
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213354);
    if ((!this.NoX) || ((paramMap == null) && (paramJSONObject == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(213354);
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
      Log.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", new Object[] { paramString, str1, str2 });
      if (paramMap == null) {
        break label156;
      }
    }
    label147:
    label156:
    for (paramMap = n.a.b(paramString, paramMap, this.PNx, this.EVx);; paramMap = n.a.a(paramString, paramJSONObject, this.PNx, this.EVx))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205459);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(205459);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(205459);
          }
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(213354);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    MMHandlerThread.postToMainThread(paramString);
    AppMethodBeat.o(213354);
  }
  
  public final void b(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213345);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(213345);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventId", paramString1);
    localHashMap.put("widgetId", paramString3);
    localHashMap.put("hitTest", Boolean.valueOf(paramBoolean));
    localHashMap.put("err_msg", paramString2);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207612);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(207612);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207612);
        }
      }
    });
    AppMethodBeat.o(213345);
  }
  
  public final void bL(Map<String, Object> paramMap)
  {
    this.fPy = paramMap;
  }
  
  public final Bundle bM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(213268);
    Bundle localBundle = new Bundle();
    String str1 = this.PNp.getUrl();
    String str2;
    if (paramMap != null)
    {
      str2 = (String)paramMap.get("share_report_pre_msg_url");
      if (!Util.isNullOrNil(str2)) {
        break label273;
      }
      str2 = str1;
    }
    label273:
    for (;;)
    {
      Object localObject = (String)paramMap.get("share_report_pre_msg_title");
      if (Util.isNullOrNil((String)localObject)) {
        localObject = this.PNp.getTitle();
      }
      for (;;)
      {
        String str4 = (String)paramMap.get("share_report_pre_msg_desc");
        String str3 = str4;
        if (Util.isNullOrNil(str4)) {
          str3 = str1;
        }
        localBundle.putString("link", str2);
        localBundle.putString("desc", str3);
        localBundle.putString("img_url", Util.nullAsNil((String)paramMap.get("share_report_pre_msg_icon_url")));
        if (Util.isNullOrNil((String)localObject)) {
          if (!Util.isNullOrNil(str1))
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
          AppMethodBeat.o(213268);
          return localBundle;
          localObject = this.PNp.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = MMApplicationContext.getContext().getString(a.a.webview_jssdk_link);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void bN(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213299);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(213299);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216573);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(216573);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(216573);
        }
      }
    });
    AppMethodBeat.o(213299);
  }
  
  public final void bO(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213303);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(213303);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = n.a.b("onVoiceRecordEnd", paramMap, this.PNx, this.EVx);
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214614);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(214614);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(214614);
        }
      }
    });
    AppMethodBeat.o(213303);
  }
  
  public final void bP(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213340);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(213340);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206599);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(206599);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(206599);
        }
      }
    });
    AppMethodBeat.o(213340);
  }
  
  public final void biX(String paramString)
  {
    AppMethodBeat.i(213358);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(213358);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214787);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(214787);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(214787);
        }
      }
    });
    AppMethodBeat.o(213358);
  }
  
  public final boolean bjE(final String paramString)
  {
    AppMethodBeat.i(213194);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(213194);
    return true;
  }
  
  public final boolean bjF(String paramString)
  {
    AppMethodBeat.i(213191);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213191);
      return false;
    }
    boolean bool = ab.J(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(213191);
    return bool;
  }
  
  public final void bjU(String paramString)
  {
    this.PND = paramString;
  }
  
  public final String bjW(String paramString)
  {
    AppMethodBeat.i(213241);
    Context localContext = getContext();
    if ((localContext instanceof com.tencent.mm.plugin.webview.core.b))
    {
      paramString = ((com.tencent.mm.plugin.webview.core.b)localContext).bju(paramString);
      AppMethodBeat.o(213241);
      return paramString;
    }
    AppMethodBeat.o(213241);
    return "";
  }
  
  public final void bjX(String paramString)
  {
    this.PNK = paramString;
  }
  
  public final void bjY(String paramString)
  {
    this.PNL = paramString;
  }
  
  public final void bjZ(final String paramString)
  {
    AppMethodBeat.i(213291);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(213291);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = n.a.b("activity:state_change", localHashMap, this.PNx, this.EVx);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(213291);
        return;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(213291);
        return;
      }
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205418);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(205418);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205418);
        }
      }
    });
    AppMethodBeat.o(213291);
  }
  
  public final void bka(final String paramString)
  {
    AppMethodBeat.i(213322);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(213322);
      return;
    }
    if (this.PNu != null) {
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207540);
          n localn = new n();
          localn.params = new HashMap();
          localn.params.put("username", paramString);
          localn.POv = new JSONObject();
          localn.type = "call";
          localn.POu = "";
          localn.function = "profile";
          h.d(h.this).add(localn);
          h.e(h.this);
          AppMethodBeat.o(207540);
        }
      });
    }
    AppMethodBeat.o(213322);
  }
  
  public final void bkb(String paramString)
  {
    AppMethodBeat.i(213327);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213327);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206508);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(206508);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(206508);
        }
      }
    });
    AppMethodBeat.o(213327);
  }
  
  public final void bkd(String paramString)
  {
    AppMethodBeat.i(213384);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213384);
      return;
    }
    if (!ab.bsg(getCurrentUrl()))
    {
      AppMethodBeat.o(213384);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = n.a.b("onMenuClick", localHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213384);
  }
  
  public final void bke(String paramString)
  {
    AppMethodBeat.i(213389);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213389);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213389);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "onNetWorkChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("netType", paramString);
    paramString = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected(paramString)) {
      localHashMap.put("networkType", "none");
    }
    if (NetStatusUtil.is2G(paramString))
    {
      Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 2g");
      localHashMap.put("networkType", "2g");
    }
    if (NetStatusUtil.is3G(paramString))
    {
      Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 3g");
      localHashMap.put("networkType", "3g");
    }
    if (NetStatusUtil.is4G(paramString))
    {
      Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 4g");
      localHashMap.put("networkType", "4g");
    }
    if (NetStatusUtil.is5G(paramString))
    {
      Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 5g");
      localHashMap.put("networkType", "5g");
    }
    if (NetStatusUtil.isWifi(paramString))
    {
      Log.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
      localHashMap.put("networkType", "wifi");
    }
    if (this.pGC != null) {}
    for (;;)
    {
      try
      {
        i = this.pGC.l(110, new Bundle()).getInt("sim_card_type", 0);
        if (i != 0) {
          continue;
        }
        i = 0;
        localHashMap.put("simType", Integer.valueOf(i));
        Log.d("MicroMsg.JsApiHandler", "onNetWorkChange simType=%s", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception paramString)
      {
        int i;
        Log.e("MicroMsg.JsApiHandler", "invokeAsResult ex %s", new Object[] { paramString.getMessage() });
        continue;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206964);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
            AppMethodBeat.o(206964);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(206964);
          }
        }
      });
      AppMethodBeat.o(213389);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void c(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(213257);
    Log.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.NoX) });
    if (!this.NoX)
    {
      Log.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      i(bM(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(213257);
      return;
    }
    paramHashMap = anI(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      i(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(213257);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap.put("shareScene", Integer.valueOf(paramInt));
    paramHashMap = n.a.b("menu:share:appmessage", paramHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.pGC.aw("scene", "friend", this.PNz);
      AppMethodBeat.o(213257);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213257);
    }
  }
  
  public final void cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(213360);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(213360);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207111);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(207111);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207111);
        }
      }
    });
    AppMethodBeat.o(213360);
  }
  
  public final void cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213170);
    try
    {
      this.pGC.o(paramString, paramBoolean, this.PNz);
      AppMethodBeat.o(213170);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213170);
    }
  }
  
  public final void d(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(213260);
    Log.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(this.NoX) });
    if (!this.NoX) {
      try
      {
        this.pGC.aw("scene", "favorite", this.PNz);
        i(bM(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(213260);
        return;
      }
      catch (Exception paramHashMap)
      {
        Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
        AppMethodBeat.o(213260);
        return;
      }
    }
    paramHashMap = anI(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false))) {
      try
      {
        this.pGC.aw("scene", "favorite", this.PNz);
        i(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(213260);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException.getMessage());
        }
      }
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "favorite");
    paramHashMap.put("favScene", Integer.valueOf(paramInt));
    paramHashMap = n.a.b("menu:share:appmessage", paramHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.pGC.aw("scene", "favorite", this.PNz);
      AppMethodBeat.o(213260);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(213260);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(213245);
    gUd();
    this.NoX = false;
    this.LIS.clear();
    this.PNt.clear();
    this.PNu = null;
    AppMethodBeat.o(213245);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213394);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213394);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211472);
        try
        {
          if (h.f(h.this) != null) {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.POc + ")", null);
          }
          AppMethodBeat.o(211472);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(211472);
        }
      }
    });
    AppMethodBeat.o(213394);
  }
  
  public final void eU(Context paramContext)
  {
    this.PNs = paramContext;
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(213409);
    if (MMHandlerThread.isMainThread())
    {
      this.PNp.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(213409);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205208);
        h.f(h.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(205208);
      }
    });
    AppMethodBeat.o(213409);
  }
  
  public final void gPF()
  {
    AppMethodBeat.i(213336);
    if (this.LIS != null) {
      this.LIS.clear();
    }
    AppMethodBeat.o(213336);
  }
  
  public final void gPJ()
  {
    AppMethodBeat.i(213335);
    if (this.PNu != null) {
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206641);
          h.e(h.this);
          AppMethodBeat.o(206641);
        }
      });
    }
    AppMethodBeat.o(213335);
  }
  
  public final void gQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(213254);
    if (!this.NoX)
    {
      AppMethodBeat.o(213254);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = n.a.b("onMPPageAction", localHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213254);
  }
  
  public final void gR(String paramString, int paramInt)
  {
    AppMethodBeat.i(213287);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(213287);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(213287);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", paramString);
    if (paramInt == 2) {
      localHashMap.put("state", "connected");
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205296);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
            AppMethodBeat.o(205296);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205296);
          }
        }
      });
      AppMethodBeat.o(213287);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void gS(String paramString, int paramInt)
  {
    AppMethodBeat.i(213306);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(213306);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211899);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(211899);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(211899);
        }
      }
    });
    AppMethodBeat.o(213306);
  }
  
  public final void gT(String paramString, int paramInt)
  {
    AppMethodBeat.i(213310);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(213310);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205383);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(205383);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205383);
        }
      }
    });
    AppMethodBeat.o(213310);
  }
  
  public final void gTL()
  {
    AppMethodBeat.i(213163);
    if (this.PNx != true)
    {
      this.PNx = true;
      if (!com.tencent.matrix.trace.g.b.fK(this.PNp.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = Util.getRandomString(16);; str = this.PNp.getRandomStr())
    {
      this.EVx = str;
      Log.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.EVx, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(213163);
      return;
    }
  }
  
  public final void gTM()
  {
    AppMethodBeat.i(213164);
    this.PNx = true;
    this.EVx = Util.getRandomString(16);
    this.PNp.setRandomStr(this.EVx);
    Log.i("MicroMsg.JsApiHandler", "WebView-Trace js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { this.EVx, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(213164);
  }
  
  public final String gTN()
  {
    return this.EVx;
  }
  
  public final com.tencent.mm.plugin.webview.d.b.a gTP()
  {
    AppMethodBeat.i(213186);
    if (this.PNF == null) {
      this.PNF = new com.tencent.mm.plugin.webview.d.b.a();
    }
    this.PNF.PNe = this.PNp;
    com.tencent.mm.plugin.webview.d.b.a locala = this.PNF;
    AppMethodBeat.o(213186);
    return locala;
  }
  
  public final p gTQ()
  {
    AppMethodBeat.i(213188);
    if (this.PNG == null) {
      this.PNG = new p();
    }
    p localp = this.PNG;
    kotlin.g.b.p.k(this, "jsApiHandler");
    localp.PNo = this;
    localp = this.PNG;
    AppMethodBeat.o(213188);
    return localp;
  }
  
  public final void gTR()
  {
    AppMethodBeat.i(213197);
    if ((this.PNx) && (ab.hnT()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("__event_id", "sys:updateRandomStr");
        localJSONObject2.put("randomStr", this.EVx);
        localJSONObject1.put("__json_message", localJSONObject2);
        this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + localJSONObject1.toString() + ")", new ValueCallback() {});
        AppMethodBeat.o(213197);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(213197);
  }
  
  public final void gTS()
  {
    AppMethodBeat.i(213203);
    Log.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.NoX) });
    if ((this.PNp != null) && (this.NoX)) {
      this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:attach_runOn3rd_apis", gTT(), this.PNx, this.EVx) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(213203);
  }
  
  public final boolean gTX()
  {
    AppMethodBeat.i(213342);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, not ready");
      AppMethodBeat.o(213342);
      return false;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209496);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(209496);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(209496);
        }
      }
    });
    AppMethodBeat.o(213342);
    return true;
  }
  
  public final void gTY()
  {
    AppMethodBeat.i(213381);
    Log.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.NoX) });
    if ((this.PNp != null) && (this.NoX)) {
      this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_all_hosts", new HashMap(), this.PNx, this.EVx) + ")", null);
    }
    AppMethodBeat.o(213381);
  }
  
  public final void gTZ()
  {
    AppMethodBeat.i(213385);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(213385);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212155);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(212155);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(212155);
        }
      }
    });
    AppMethodBeat.o(213385);
  }
  
  public final void gU(String paramString, int paramInt)
  {
    AppMethodBeat.i(213313);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(213313);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207136);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(207136);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207136);
        }
      }
    });
    AppMethodBeat.o(213313);
  }
  
  public final void gUa()
  {
    AppMethodBeat.i(213390);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(213390);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = n.a.b("onNavigationBarRightButtonClick", new HashMap(), this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(213390);
  }
  
  public final long gUb()
  {
    AppMethodBeat.i(213396);
    Log.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.PNT) });
    long l = this.PNT;
    AppMethodBeat.o(213396);
    return l;
  }
  
  public final k gUc()
  {
    AppMethodBeat.i(213398);
    com.tencent.mm.plugin.expansions.a.dbf();
    if (this.PNU == null) {
      this.PNU = new k(this);
    }
    k localk = this.PNU;
    AppMethodBeat.o(213398);
    return localk;
  }
  
  public final void gUd()
  {
    AppMethodBeat.i(213401);
    if (!this.NoX)
    {
      AppMethodBeat.o(213401);
      return;
    }
    if (this.PNU != null) {
      this.PNU.clear();
    }
    if (this.pGC != null) {
      try
      {
        this.pGC.aom(this.PNz);
        AppMethodBeat.o(213401);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(213401);
  }
  
  public final void gV(String paramString, int paramInt)
  {
    AppMethodBeat.i(213316);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(213316);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("serverId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205829);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(205829);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205829);
        }
      }
    });
    AppMethodBeat.o(213316);
  }
  
  public final void gW(String paramString, int paramInt)
  {
    AppMethodBeat.i(213318);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(213318);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", paramString);
    localHashMap.put("percent", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208991);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(208991);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(208991);
        }
      }
    });
    AppMethodBeat.o(213318);
  }
  
  final String gX(String paramString, int paramInt)
  {
    AppMethodBeat.i(213330);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = bkc(n.a.b("onGetA8KeyUrl", localHashMap, this.PNx, this.EVx));
    AppMethodBeat.o(213330);
    return paramString;
  }
  
  public final void gY(String paramString, int paramInt)
  {
    AppMethodBeat.i(213373);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(213373);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("snsid", paramString);
    localHashMap.put("status", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214006);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(214006);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(214006);
        }
      }
    });
    AppMethodBeat.o(213373);
  }
  
  public final int getBinderID()
  {
    return this.PNz;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(213236);
    if (this.PNJ)
    {
      if (this.PNs != null)
      {
        localContext = this.PNs;
        AppMethodBeat.o(213236);
        return localContext;
      }
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(213236);
      return localContext;
    }
    if (this.PNp == null)
    {
      AppMethodBeat.o(213236);
      return null;
    }
    Context localContext = this.PNp.getActivityContextIfHas();
    AppMethodBeat.o(213236);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(213408);
    if (this.PNp == null)
    {
      AppMethodBeat.o(213408);
      return "";
    }
    String str = this.PNp.getUrl();
    AppMethodBeat.o(213408);
    return str;
  }
  
  public final aa getSettings()
  {
    AppMethodBeat.i(213162);
    aa localaa = this.PNp.getSettings();
    AppMethodBeat.o(213162);
    return localaa;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(213405);
    String str = (String)this.fPy.get("srcUsername");
    AppMethodBeat.o(213405);
    return str;
  }
  
  public final void h(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213339);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(213339);
      return;
    }
    if (this.jPb.containsKey(paramString1))
    {
      localObject = (b)this.jPb.get(paramString1);
      if (localObject != null)
      {
        ((b)localObject).h(paramString1, paramString2, paramMap);
        this.jPb.remove(paramString1);
      }
      AppMethodBeat.o(213339);
      return;
    }
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(213339);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Log.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      ((Map)localObject).putAll(paramMap);
    }
    paramString1 = n.a.a(paramString1, (Map)localObject, this.PNx, this.EVx);
    Log.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.PNp != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205410);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(205410);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(205410);
          }
        }
      };
      if (MMHandlerThread.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(213339);
        return;
      }
      MMHandlerThread.postToMainThread(paramString1);
    }
    AppMethodBeat.o(213339);
  }
  
  public final void i(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(213371);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(213371);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "%s success, ready", new Object[] { paramString4 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", Integer.valueOf(paramInt));
    localHashMap.put("errMsg", paramString1);
    localHashMap.put("json", paramString2);
    if (!Util.isNullOrNil(paramString3)) {
      localHashMap.put("requestId", paramString3);
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211595);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(211595);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(211595);
        }
      }
    });
    AppMethodBeat.o(213371);
  }
  
  public final void i(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(213271);
    if (paramBundle == null)
    {
      Log.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(213271);
      return;
    }
    if (this.PNu != null) {
      this.PNu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211678);
          n localn = new n();
          localn.params = new HashMap();
          localn.params.put("link", paramBundle.getString("link"));
          localn.params.put("title", paramBundle.getString("title"));
          localn.params.put("desc", paramBundle.getString("desc"));
          localn.POv = new JSONObject();
          localn.params.put("img_url", paramBundle.getString("img_url"));
          localn.params.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          localn.type = "call";
          localn.POu = "";
          localn.function = paramString;
          h.d(h.this).add(localn);
          h.e(h.this);
          AppMethodBeat.o(211678);
        }
      });
    }
    AppMethodBeat.o(213271);
  }
  
  public final void i(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(213341);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(213341);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString1);
    localHashMap.put("newQuery", Boolean.valueOf(paramBoolean));
    localHashMap.put("requestId", paramString2);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207168);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(207168);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207168);
        }
      }
    });
    AppMethodBeat.o(213341);
  }
  
  public final void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(213277);
    if ((!this.NoX) || (paramBundle == null))
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(213277);
      return;
    }
    long l = paramBundle.getLong("download_manager_downloadid");
    String str = paramBundle.getString("download_manager_appid", "");
    int i = paramBundle.getInt("download_manager_errcode");
    Log.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + l + ", state = " + paramString + ", errCode = " + i);
    paramBundle = new HashMap();
    paramBundle.put("appid", str);
    paramBundle.put("download_id", Long.valueOf(l));
    paramBundle.put("err_code", Integer.valueOf(i));
    paramBundle.put("state", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205502);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(205502);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205502);
        }
      }
    });
    AppMethodBeat.o(213277);
  }
  
  public final void lx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213325);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(213325);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.ci.a.H(MMApplicationContext.getContext(), paramInt1)));
    if (paramInt2 != 0) {
      localHashMap.put("inputHeight", Integer.valueOf(com.tencent.mm.ci.a.H(MMApplicationContext.getContext(), paramInt2)));
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205839);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(205839);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205839);
        }
      }
    });
    AppMethodBeat.o(213325);
  }
  
  public final void mu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213255);
    if (!this.NoX)
    {
      AppMethodBeat.o(213255);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = n.a.b("onMPPageAction", localHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(213255);
  }
  
  public final void mv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213347);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(213347);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208092);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", new ValueCallback() {});
          AppMethodBeat.o(208092);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(208092);
        }
      }
    });
    AppMethodBeat.o(213347);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(213295);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onWindowFocusChanged fail, not ready %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(213295);
      return;
    }
    if (this.PNp == null)
    {
      AppMethodBeat.o(213295);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.brandservice.a.c)localObject).isMpUrl(this.PNp.getUrl())))
    {
      AppMethodBeat.o(213295);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "onWindowFocusChanged, hasFocus = ".concat(String.valueOf(paramBoolean)));
    localObject = new HashMap();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((Map)localObject).put("hasFocus", Integer.valueOf(i));
      localObject = n.a.b("onWindowFocusChanged", (Map)localObject, this.PNx, this.EVx);
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207598);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
            AppMethodBeat.o(207598);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(207598);
          }
        }
      });
      AppMethodBeat.o(213295);
      return;
    }
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(213376);
    this.isActive = paramBoolean;
    if (this.isActive)
    {
      bRP();
      AppMethodBeat.o(213376);
      return;
    }
    this.PNv = System.currentTimeMillis();
    AppMethodBeat.o(213376);
  }
  
  public final void y(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213251);
    if (!this.NoX)
    {
      AppMethodBeat.o(213251);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = n.a.b("menu:haokan", localHashMap, this.PNx, this.EVx);
    this.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(213251);
  }
  
  public final void z(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(213365);
    if (!this.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(213365);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestType", Integer.valueOf(paramInt1));
    localHashMap.put("json", paramString);
    localHashMap.put("isCacheData", Integer.valueOf(paramInt2));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216438);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.nAF + ")", null);
          AppMethodBeat.o(216438);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(216438);
        }
      }
    });
    AppMethodBeat.o(213365);
  }
  
  public static abstract interface a
  {
    public abstract boolean b(n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.h
 * JD-Core Version:    0.7.0.1
 */