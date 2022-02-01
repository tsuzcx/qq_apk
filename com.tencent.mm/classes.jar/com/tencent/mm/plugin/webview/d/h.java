package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.plugin.webview.modeltools.j;
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
  private static final int IRd;
  private final LinkedList<n> FoQ;
  public boolean GBl;
  public e IKO;
  private JSONArray IRA;
  private List<String> IRB;
  private MTimerHandler IRC;
  public long IRD;
  private k IRE;
  public MMWebView IRa;
  private Context IRe;
  private final List<String> IRf;
  private MMHandler IRg;
  private boolean IRh;
  private com.tencent.mm.plugin.webview.f.g IRi;
  public boolean IRj;
  public boolean IRk;
  public int IRl;
  private a IRm;
  private Set<String> IRn;
  private boolean IRo;
  public String IRp;
  private com.tencent.mm.plugin.webview.d.b.a IRq;
  private JsapiPermissionWrapper IRr;
  private Bundle IRs;
  private boolean IRt;
  public String IRu;
  public String IRv;
  private final List<String> IRw;
  volatile String IRx;
  volatile int IRy;
  private JSONObject IRz;
  public Map<String, Object> dVU;
  HashMap<String, b> hdu;
  public com.tencent.mm.plugin.webview.stub.e mHh;
  public String zpY;
  
  static
  {
    AppMethodBeat.i(224405);
    if (com.tencent.mm.compatible.util.d.oE(19)) {}
    for (int i = 200;; i = 20)
    {
      IRd = i;
      AppMethodBeat.o(224405);
      return;
    }
  }
  
  public h()
  {
    AppMethodBeat.i(224296);
    this.IRf = new LinkedList();
    this.FoQ = new LinkedList();
    this.IRg = null;
    this.GBl = false;
    this.IRh = false;
    this.IRj = false;
    this.zpY = "";
    this.IRk = false;
    this.IRn = null;
    this.IRo = false;
    this.IKO = null;
    this.IRq = null;
    this.hdu = new HashMap();
    this.IRt = false;
    this.IRw = new LinkedList();
    this.IRx = null;
    this.IRy = 0;
    this.IRz = new JSONObject();
    this.IRA = new JSONArray();
    this.IRB = new LinkedList();
    this.IRC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(224242);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(224242);
        return false;
      }
    }, false);
    this.IRD = 0L;
    AppMethodBeat.o(224296);
  }
  
  public h(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.f.g paramg, int paramInt)
  {
    AppMethodBeat.i(224297);
    this.IRf = new LinkedList();
    this.FoQ = new LinkedList();
    this.IRg = null;
    this.GBl = false;
    this.IRh = false;
    this.IRj = false;
    this.zpY = "";
    this.IRk = false;
    this.IRn = null;
    this.IRo = false;
    this.IKO = null;
    this.IRq = null;
    this.hdu = new HashMap();
    this.IRt = false;
    this.IRw = new LinkedList();
    this.IRx = null;
    this.IRy = 0;
    this.IRz = new JSONObject();
    this.IRA = new JSONArray();
    this.IRB = new LinkedList();
    this.IRC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(224242);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(224242);
        return false;
      }
    }, false);
    this.IRD = 0L;
    this.IRa = paramMMWebView;
    this.IRi = paramg;
    this.IRl = paramInt;
    gaS();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(224297);
      return;
    }
  }
  
  public h(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.f.g paramg, int paramInt, e parame)
  {
    AppMethodBeat.i(224298);
    this.IRf = new LinkedList();
    this.FoQ = new LinkedList();
    this.IRg = null;
    this.GBl = false;
    this.IRh = false;
    this.IRj = false;
    this.zpY = "";
    this.IRk = false;
    this.IRn = null;
    this.IRo = false;
    this.IKO = null;
    this.IRq = null;
    this.hdu = new HashMap();
    this.IRt = false;
    this.IRw = new LinkedList();
    this.IRx = null;
    this.IRy = 0;
    this.IRz = new JSONObject();
    this.IRA = new JSONArray();
    this.IRB = new LinkedList();
    this.IRC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(224242);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(224242);
        return false;
      }
    }, false);
    this.IRD = 0L;
    this.IRa = paramMMWebView;
    this.IRi = paramg;
    this.IRl = paramInt;
    this.IKO = parame;
    gaS();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, jsApiPool: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), parame });
      AppMethodBeat.o(224298);
      return;
    }
  }
  
  public h(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.f.g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(224299);
    this.IRf = new LinkedList();
    this.FoQ = new LinkedList();
    this.IRg = null;
    this.GBl = false;
    this.IRh = false;
    this.IRj = false;
    this.zpY = "";
    this.IRk = false;
    this.IRn = null;
    this.IRo = false;
    this.IKO = null;
    this.IRq = null;
    this.hdu = new HashMap();
    this.IRt = false;
    this.IRw = new LinkedList();
    this.IRx = null;
    this.IRy = 0;
    this.IRz = new JSONObject();
    this.IRA = new JSONArray();
    this.IRB = new LinkedList();
    this.IRC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(224242);
        String str = n.a.a("onBeaconsInRange", h.j(h.this), h.k(h.this), h.l(h.this));
        h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        h.m(h.this).clear();
        h.a(h.this, new JSONObject());
        h.a(h.this, new JSONArray());
        AppMethodBeat.o(224242);
        return false;
      }
    }, false);
    this.IRD = 0L;
    this.IRa = paramMMWebView;
    this.IRi = paramg;
    this.IRl = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.IRn = paramg;
    this.IRo = true;
    gaS();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(224299);
      return;
    }
  }
  
  /* Error */
  private static boolean N(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 388
    //   3: invokestatic 256	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 394	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 351
    //   20: ldc_w 396
    //   23: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 388
    //   29: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 402	com/tencent/mm/vfs/o
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 405	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 409	com/tencent/mm/vfs/o:exists	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 412	com/tencent/mm/vfs/o:createNewFile	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 418	com/tencent/mm/vfs/s:d	(Lcom/tencent/mm/vfs/o;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 424 1 0
    //   77: invokeinterface 430 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 435 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 439 1 0
    //   101: checkcast 441	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 445 2 0
    //   114: checkcast 355	java/lang/Integer
    //   117: invokevirtual 448	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 450	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 451	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 455	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 457
    //   136: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 464	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 468	java/lang/String:getBytes	()[B
    //   150: invokevirtual 474	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 476	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 476	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 351
    //   174: aload_1
    //   175: ldc_w 289
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 351
    //   188: ldc_w 482
    //   191: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 485	java/io/OutputStream:close	()V
    //   202: ldc_w 388
    //   205: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 351
    //   214: ldc_w 487
    //   217: aload_0
    //   218: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 494	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 351
    //   230: aload_1
    //   231: ldc_w 289
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 388
    //   244: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 500	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 485	java/io/OutputStream:close	()V
    //   261: ldc_w 351
    //   264: ldc_w 502
    //   267: aload_0
    //   268: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 494	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 504	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 388
    //   280: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 351
    //   289: aload_1
    //   290: ldc_w 289
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 351
    //   307: aload_0
    //   308: ldc_w 289
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 485	java/io/OutputStream:close	()V
    //   332: ldc_w 388
    //   335: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 351
    //   344: aload_1
    //   345: ldc_w 289
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    AppMethodBeat.i(224322);
    if (paramn == null)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(224322);
      return true;
    }
    if (("getBrandWCPayRequest".equals(paramn.mhO)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      AppMethodBeat.o(224322);
      return true;
    }
    if ((Arrays.asList(new String[] { "getBrandWCPayBindCardRequest", "openWCPaySpecificView", "verifyWCPayPassword", "getH5TransactionRequest", "getH5PrepayRequest", "getWCPayRealnameVerify", "selectWalletCurrency", "changePayActivityView", "unbindBankCard", "uploadIdCardSuccess", "idCardRealnameVerify", "setWCPayPassword", "handleWCPayWalletBuffer", "faceVerifyForPay" }).contains(paramn.mhO)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      AppMethodBeat.o(224322);
      return true;
    }
    if (this.IRh)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, floating now");
      AppMethodBeat.o(224322);
      return true;
    }
    if ((paramn.mhO == null) || (paramn.params == null) || (paramn.type == null) || ((!this.IRt) && (this.IRa == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paramn.mhO + ", params = " + paramn.params + ", type = " + paramn.type + ", wv = " + this.IRa);
      AppMethodBeat.o(224322);
      return true;
    }
    if ((this.IRo) && ((this.IRn == null) || (!this.IRn.contains(paramn.mhO))))
    {
      Log.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paramn.mhO });
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224295);
          h.this.h(paramn.ISe, "system:access_denied", null);
          AppMethodBeat.o(224295);
        }
      });
      AppMethodBeat.o(224322);
      return true;
    }
    if (paramBundle != null) {
      paramn.IRs = paramBundle;
    }
    if (paramb != null) {
      this.hdu.put(paramn.ISe, paramb);
    }
    if ((this.dVU != null) && (this.dVU.get("srcUsername") != null) && (!Util.isNullOrNil(this.dVU.get("srcUsername").toString()))) {
      paramn.params.put("src_username", this.dVU.get("srcUsername").toString());
    }
    if ((this.dVU != null) && (this.dVU.get("srcDisplayname") != null) && (!Util.isNullOrNil(this.dVU.get("srcDisplayname").toString()))) {
      paramn.params.put("src_displayname", this.dVU.get("srcDisplayname").toString());
    }
    if ((this.dVU != null) && (this.dVU.get("KTemplateId") != null) && (!Util.isNullOrNil(this.dVU.get("KTemplateId").toString()))) {
      paramn.params.put("tempalate_id", this.dVU.get("KTemplateId").toString());
    }
    if (this.dVU != null)
    {
      paramn.params.put("message_id", this.dVU.get("message_id"));
      paramn.params.put("message_index", this.dVU.get("message_index"));
      paramn.params.put("webview_scene", this.dVU.get("scene"));
      paramn.params.put("pay_channel", this.dVU.get("pay_channel"));
      paramn.params.put("pay_scene", this.dVU.get("pay_scene"));
      Log.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.dVU.get("pay_package") });
      if (this.dVU.get("pay_package") != null) {
        paramn.params.put("pay_packageName", this.dVU.get("pay_package"));
      }
      paramn.params.put("stastic_scene", this.dVU.get("stastic_scene"));
      paramn.params.put("open_from_scene", this.dVU.get("from_scence"));
      paramBundle = paramn.params;
      paramb = new Bundle();
      paramb.putString("__jsapi_fw_ext_info_key_current_url", this.IRa.getUrl());
      paramBundle.put("__jsapi_fw_ext_info", paramb);
    }
    if ((this.IRa != null) && (!paramn.mhO.equals("shareWeibo")) && (!paramn.mhO.equals("openUrlByExtBrowser")) && (!paramn.mhO.equals("log")) && (!paramn.mhO.equals("openUrlWithExtraWebview")) && (!paramn.mhO.equals("openCustomWebview")) && (!paramn.mhO.equals("openGameWebView")) && (!paramn.mhO.equals("addToEmoticon")) && (!paramn.mhO.equals("shareEmoticon")) && (!paramn.mhO.equals("openGameUrlWithExtraWebView")) && (!paramn.mhO.equals("request")))
    {
      paramn.params.put("url", this.IRa.getUrl());
      Log.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.IRa.getUrl());
    }
    if ((paramn.mhO.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.mhO.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paramn.mhO.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.mhO.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paramn.mhO.equalsIgnoreCase("openDesignerEmojiView")) || (paramn.mhO.equalsIgnoreCase("openDesignerProfile")) || (paramn.mhO.equalsIgnoreCase("openDesignerProfileLocal")) || (paramn.mhO.equalsIgnoreCase("getSearchEmotionData")))
    {
      paramn.params.put("searchID", Long.valueOf(gbh()));
      Log.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(gbh()) });
    }
    if (paramn.mhO.equals("request"))
    {
      if (this.IRu != null) {
        paramn.params.put("key_request_full_url_query", this.IRu);
      }
      if (this.IRv != null) {
        paramn.params.put("key_request_header", this.IRv);
      }
    }
    if (paramn.mhO.equals("imagePreview")) {
      j.a(paramn.params, this.IRa);
    }
    if ((paramn.mhO.equals("preVerifyJSAPI")) && (paramn.params.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.l.c.giT();
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
          localBundle1.putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.Kzq);
          bool2 = bool1;
          localBundle1.putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.Kzr);
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.gtL());
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.gtM());
        }
        bool2 = bool1;
        paramb = n.bL(paramn.params);
        bool2 = bool1;
        if (!Util.isNullOrNil(this.IRp))
        {
          bool2 = bool1;
          paramb.putString("key_wxapp_id", this.IRp);
        }
        bool2 = bool1;
        localBundle2 = new Bundle(3);
        paramBundle = paramb;
        bool2 = bool1;
        if (paramn.IRs != null)
        {
          bool2 = bool1;
          localBundle2.putBundle("jsEngine", paramn.IRs);
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
        if (paramn.ISf != null)
        {
          bool2 = bool1;
          localBundle2.putString("rawParams", paramn.ISf.toString());
        }
        bool2 = bool1;
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paramn.mhO });
        bool2 = bool1;
        if (this.IRm != null)
        {
          bool2 = bool1;
          bool3 = this.IRm.b(paramn);
        }
        bool2 = bool3;
        if (!this.IRt)
        {
          bool2 = bool3;
          this.IRi.gdI();
          bool2 = bool3;
          getContext();
        }
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          paramJsapiPermissionWrapper = new f(getContext(), paramJsapiPermissionWrapper, this.mHh, this, this.IRa);
          bool2 = bool3;
          paramBundle = q.ISm;
          bool2 = bool3;
          bool1 = q.a(paramJsapiPermissionWrapper, paramn);
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
        AppMethodBeat.o(224322);
        return false;
      }
      try
      {
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paramn.mhO });
        i = 1;
        j.gdB();
        Log.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paramn.mhO, Boolean.valueOf(bool1) });
        if ((bool1) && (i == 0)) {
          continue;
        }
        AppMethodBeat.o(224322);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        continue;
        continue;
      }
      bool2 = bool1;
      paramJsapiPermissionWrapper = this.IRi.gdH();
      break;
      bool2 = bool1;
      if ((this.mHh == null) || (paramn == null)) {
        break label1975;
      }
      bool2 = bool1;
      bool1 = this.mHh.a(paramn.type, paramn.mhO, paramn.ISe, localBundle1, localBundle2, this.IRl);
      i = 0;
    }
  }
  
  public static String aYh(String paramString)
  {
    AppMethodBeat.i(224380);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { Util.nullAsNil(paramString) });
    AppMethodBeat.o(224380);
    return paramString;
  }
  
  private String aYk(String paramString)
  {
    AppMethodBeat.i(224395);
    String str1 = this.IRa.getUrl();
    try
    {
      String str2 = com.tencent.mm.b.n.fc(str1 + paramString);
      str2 = com.tencent.mm.loader.j.b.aKP() + str2;
      Log.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(224395);
      return str2;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(224395);
    }
    return null;
  }
  
  private void gaS()
  {
    AppMethodBeat.i(224300);
    this.IRg = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(224212);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(224212);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!Util.isNullOrNil(paramAnonymousMessage)) {
            h.b(h.this).add(paramAnonymousMessage);
          }
          h.c(h.this);
          AppMethodBeat.o(224212);
          return;
          Log.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(224300);
  }
  
  private Map<String, Object> gaZ()
  {
    AppMethodBeat.i(224316);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.IRi.gdH();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.pP(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.pP(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.pP(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.pP(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.pP(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.pP(219)) {
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
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(224316);
    return localHashMap;
  }
  
  private boolean gba()
  {
    AppMethodBeat.i(224317);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.mHh.agw(this.IRl);
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
    AppMethodBeat.o(224317);
    return bool1;
  }
  
  private void gbb()
  {
    AppMethodBeat.i(224318);
    while (gbc()) {}
    AppMethodBeat.o(224318);
  }
  
  private boolean gbc()
  {
    AppMethodBeat.i(224319);
    if (Util.isNullOrNil(this.FoQ))
    {
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(224319);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.mHh.agw(this.IRl);
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(224319);
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
      if (this.FoQ.size() == 0)
      {
        Log.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(224319);
        return false;
      }
      n localn = (n)this.FoQ.remove(0);
      if (localn == null)
      {
        Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
        AppMethodBeat.o(224319);
        return true;
      }
      bool = a(localn, localn.IBv, localn.IRs, localn.IBt);
      AppMethodBeat.o(224319);
    }
    return bool;
  }
  
  /* Error */
  private static boolean lV(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1273
    //   3: invokestatic 256	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 394	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 394	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 351
    //   23: ldc_w 396
    //   26: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1273
    //   32: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 402	com/tencent/mm/vfs/o
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 405	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 409	com/tencent/mm/vfs/o:exists	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 412	com/tencent/mm/vfs/o:createNewFile	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1277	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 468	java/lang/String:getBytes	()[B
    //   84: invokevirtual 474	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 476	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 476	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 500	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 485	java/io/OutputStream:close	()V
    //   134: ldc_w 351
    //   137: ldc_w 502
    //   140: aload_0
    //   141: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 494	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 504	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1273
    //   153: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 351
    //   162: ldc_w 487
    //   165: aload_0
    //   166: invokestatic 490	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 494	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 351
    //   178: aload_1
    //   179: ldc_w 289
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1273
    //   192: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 351
    //   201: aload_1
    //   202: ldc_w 289
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 351
    //   221: aload_0
    //   222: ldc_w 289
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 351
    //   237: ldc_w 482
    //   240: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 485	java/io/OutputStream:close	()V
    //   251: ldc_w 1273
    //   254: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 351
    //   263: aload_0
    //   264: ldc_w 289
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 485	java/io/OutputStream:close	()V
    //   286: ldc_w 1273
    //   289: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 351
    //   298: aload_1
    //   299: ldc_w 289
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void M(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(224357);
    Log.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224357);
      return;
    }
    this.IRx = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.IRy = 1;; this.IRy = 0)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224241);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label188;
            }
            com.tencent.xweb.d.lA(MMApplicationContext.getContext());
            com.tencent.xweb.c localc = com.tencent.xweb.c.hsp();
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
            AppMethodBeat.o(224241);
            return;
          }
          com.tencent.xweb.d.hsr();
          com.tencent.xweb.d.sync();
          Log.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(Util.getDomin(paramString)) });
          label188:
          h.f(h.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          h.f(h.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (h.g(h.this))
          {
            h.f(h.this).evaluateJavascript(this.IRI, null);
            h.h(h.this);
            h.i(h.this);
          }
          AppMethodBeat.o(224241);
        }
      });
      AppMethodBeat.o(224357);
      return;
    }
  }
  
  public final void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(224332);
    if (!this.GBl)
    {
      Log.w("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224332);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", "onMPDotWebviewStateChange");
    localHashMap.put("id", Integer.valueOf(paramInt1));
    localHashMap.put("webviewId", Integer.valueOf(paramInt2));
    localHashMap.put("state", paramString);
    paramString = n.a.b("onMPPageAction", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224332);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(224306);
    if (paramString != null) {
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224293);
          Map localMap = h.T(paramString.split(","));
          String str = h.a(h.this, "hosts");
          if (h.O(str, localMap))
          {
            if ((h.n(h.this) == null) || (h.f(h.this) == null)) {
              break label118;
            }
            try
            {
              h.n(h.this).U(0, h.f(h.this).getUrl(), str);
              AppMethodBeat.o(224293);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(224293);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(224293);
        }
      });
    }
    AppMethodBeat.o(224306);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(224308);
    if ((com.tencent.mm.pluginsdk.ui.tools.z.gsL()) && (!this.IRk))
    {
      AppMethodBeat.o(224308);
      return "";
    }
    String str = this.zpY;
    AppMethodBeat.o(224308);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(224307);
    if (paramString != null) {
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224294);
          String str = h.a(h.this, "html");
          if (h.lW(str, paramString))
          {
            if ((h.n(h.this) == null) || (h.f(h.this) == null)) {
              break label108;
            }
            try
            {
              h.n(h.this).U(1, h.f(h.this).getUrl(), str);
              AppMethodBeat.o(224294);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(224294);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(224294);
        }
      });
    }
    AppMethodBeat.o(224307);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.IRj;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.GBl = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(224305);
    Log.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.IRg != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.IRg.sendMessage(localMessage);
      AppMethodBeat.o(224305);
      return;
    }
    Log.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(224305);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(224377);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(224377);
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
        AppMethodBeat.i(224276);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224276);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224276);
        }
      }
    });
    AppMethodBeat.o(224377);
  }
  
  public final void a(a parama)
  {
    this.IRm = parama;
  }
  
  public final void a(n paramn, b paramb)
  {
    AppMethodBeat.i(224320);
    a(paramn, this.IRr, this.IRs, paramb);
    AppMethodBeat.o(224320);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle)
  {
    this.IRr = paramJsapiPermissionWrapper;
    this.IRs = paramBundle;
    this.IRt = true;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(224359);
        if (this.IRC.stopped()) {
          this.IRC.startTimer(1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.IRB.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.IRB.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.IRA.put(localJSONObject);
              this.IRz.put("beacons", this.IRA);
              this.IRz.put("err_msg", "onBeaconsInRange:ok");
            }
            n.a.a("onBeaconsInRange", this.IRz, this.IRj, this.zpY);
            AppMethodBeat.o(224359);
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
    AppMethodBeat.i(224328);
    if (!this.GBl)
    {
      AppMethodBeat.o(224328);
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
      paramString1 = n.a.b("onMPPageAction", localHashMap, this.IRj, this.zpY);
      this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(224328);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(224342);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(224342);
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
        AppMethodBeat.i(224215);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224215);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224215);
        }
      }
    });
    AppMethodBeat.o(224342);
  }
  
  public final void a(final String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(224321);
    paramString = (n)n.a.k("[" + paramString + "]", false, this.zpY).remove(0);
    if ((paramString != null) && (gba()) && (this.IRg != null))
    {
      paramString.IRs = paramBundle;
      paramString.IBv = paramJsapiPermissionWrapper;
      paramString.IBt = paramb;
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224287);
          h.a(h.this, paramString);
          AppMethodBeat.o(224287);
        }
      });
      AppMethodBeat.o(224321);
      return;
    }
    a(paramString, paramJsapiPermissionWrapper, paramBundle, paramb);
    AppMethodBeat.o(224321);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(224375);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(224375);
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
        AppMethodBeat.i(224273);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224273);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224273);
        }
      }
    });
    AppMethodBeat.o(224375);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(224360);
    if (!Util.isNullOrNil(paramString1)) {
      h(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      fWZ();
    }
    AppMethodBeat.o(224360);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(224370);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(224370);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(224369);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(224369);
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
        AppMethodBeat.i(224268);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224268);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224268);
        }
      }
    });
    AppMethodBeat.o(224369);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224372);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(224372);
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
          AppMethodBeat.i(224270);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
            AppMethodBeat.o(224270);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(224270);
          }
        }
      });
      AppMethodBeat.o(224372);
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
  
  public final boolean aXJ(final String paramString)
  {
    AppMethodBeat.i(224311);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(224311);
    return true;
  }
  
  public final boolean aXK(String paramString)
  {
    AppMethodBeat.i(224310);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224310);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(224310);
    return bool;
  }
  
  public final String aXZ(String paramString)
  {
    AppMethodBeat.i(224324);
    Context localContext = getContext();
    if ((localContext instanceof com.tencent.mm.plugin.webview.core.b))
    {
      paramString = ((com.tencent.mm.plugin.webview.core.b)localContext).aXD(paramString);
      AppMethodBeat.o(224324);
      return paramString;
    }
    AppMethodBeat.o(224324);
    return "";
  }
  
  public final void aXm(String paramString)
  {
    AppMethodBeat.i(224373);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(224373);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224271);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224271);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224271);
        }
      }
    });
    AppMethodBeat.o(224373);
  }
  
  public final void aYa(String paramString)
  {
    this.IRu = paramString;
  }
  
  public final void aYb(String paramString)
  {
    this.IRv = paramString;
  }
  
  public final void aYc(String paramString)
  {
    AppMethodBeat.i(224334);
    if (!this.GBl)
    {
      AppMethodBeat.o(224334);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString);
    paramString = n.a.b("onReceiveMPPageData", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224334);
  }
  
  public final void aYd(String paramString)
  {
    AppMethodBeat.i(224335);
    if (!this.GBl)
    {
      AppMethodBeat.o(224335);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = n.a.b("onMPAdWebviewStateChange", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224335);
  }
  
  public final void aYe(final String paramString)
  {
    AppMethodBeat.i(224344);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString });
      AppMethodBeat.o(224344);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(paramString)));
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString);
    paramString = n.a.b("activity:state_change", localHashMap, this.IRj, this.zpY);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
        AppMethodBeat.o(224344);
        return;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(224344);
        return;
      }
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224221);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
          AppMethodBeat.o(224221);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224221);
        }
      }
    });
    AppMethodBeat.o(224344);
  }
  
  public final void aYf(final String paramString)
  {
    AppMethodBeat.i(224353);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(224353);
      return;
    }
    if (this.IRg != null) {
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224236);
          n localn = new n();
          localn.params = new HashMap();
          localn.params.put("username", paramString);
          localn.ISf = new JSONObject();
          localn.type = "call";
          localn.ISe = "";
          localn.mhO = "profile";
          h.d(h.this).add(localn);
          h.e(h.this);
          AppMethodBeat.o(224236);
        }
      });
    }
    AppMethodBeat.o(224353);
  }
  
  public final void aYg(String paramString)
  {
    AppMethodBeat.i(224356);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224356);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224240);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224240);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224240);
        }
      }
    });
    AppMethodBeat.o(224356);
  }
  
  public final void aYi(String paramString)
  {
    AppMethodBeat.i(224384);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224384);
      return;
    }
    if (!com.tencent.mm.pluginsdk.ui.tools.z.bfM(getCurrentUrl()))
    {
      AppMethodBeat.o(224384);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = n.a.b("onMenuClick", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224384);
  }
  
  public final void aYj(String paramString)
  {
    AppMethodBeat.i(224386);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224386);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224386);
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
    if (this.mHh != null) {}
    for (;;)
    {
      try
      {
        i = this.mHh.j(110, new Bundle()).getInt("sim_card_type", 0);
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
          AppMethodBeat.i(224285);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
            AppMethodBeat.o(224285);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(224285);
          }
        }
      });
      AppMethodBeat.o(224386);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void afL(int paramInt)
  {
    AppMethodBeat.i(224326);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
      AppMethodBeat.o(224326);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("fontSize", String.valueOf(paramInt));
    localObject = n.a.b("menu:setfont", (Map)localObject, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    AppMethodBeat.o(224326);
  }
  
  public final Bundle afU(int paramInt)
  {
    AppMethodBeat.i(224338);
    try
    {
      Object localObject = this.IRa;
      if (localObject == null)
      {
        AppMethodBeat.o(224338);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.IRl);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.IRa.getUrl());
      localObject = this.mHh.j(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(224338);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(224338);
    }
    return null;
  }
  
  public final void afV(int paramInt)
  {
    AppMethodBeat.i(224354);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224354);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(com.tencent.mm.cb.a.E(MMApplicationContext.getContext(), paramInt)));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224237);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224237);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224237);
        }
      }
    });
    AppMethodBeat.o(224354);
  }
  
  public final void b(com.tencent.mm.plugin.webview.stub.e parame)
  {
    this.mHh = parame;
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(224371);
    if ((!this.GBl) || ((paramMap == null) && (paramJSONObject == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(224371);
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
    for (paramMap = n.a.b(paramString, paramMap, this.IRj, this.zpY);; paramMap = n.a.a(paramString, paramJSONObject, this.IRj, this.zpY))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224269);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(224269);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(224269);
          }
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(224371);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    MMHandlerThread.postToMainThread(paramString);
    AppMethodBeat.o(224371);
  }
  
  public final void b(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224367);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(224367);
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
        AppMethodBeat.i(224260);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224260);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224260);
        }
      }
    });
    AppMethodBeat.o(224367);
  }
  
  public final void bG(Map<String, Object> paramMap)
  {
    this.dVU = paramMap;
  }
  
  public final Bundle bH(Map<String, String> paramMap)
  {
    AppMethodBeat.i(224339);
    Bundle localBundle = new Bundle();
    String str1 = this.IRa.getUrl();
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
        localObject = this.IRa.getTitle();
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
          AppMethodBeat.o(224339);
          return localBundle;
          localObject = this.IRa.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = MMApplicationContext.getContext().getString(2131768576);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void bI(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224346);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(224346);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224224);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224224);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224224);
        }
      }
    });
    AppMethodBeat.o(224346);
  }
  
  public final void bJ(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224347);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(224347);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = n.a.b("onVoiceRecordEnd", paramMap, this.IRj, this.zpY);
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224225);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(224225);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224225);
        }
      }
    });
    AppMethodBeat.o(224347);
  }
  
  public final void bK(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224364);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(224364);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224246);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224246);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224246);
        }
      }
    });
    AppMethodBeat.o(224364);
  }
  
  public final void c(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(224336);
    Log.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.GBl) });
    if (!this.GBl)
    {
      Log.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
      i(bH(paramHashMap), "sendAppMessage");
      AppMethodBeat.o(224336);
      return;
    }
    paramHashMap = afU(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
    {
      i(paramHashMap, "sendAppMessage");
      AppMethodBeat.o(224336);
      return;
    }
    paramHashMap = new HashMap();
    paramHashMap.put("scene", "friend");
    paramHashMap.put("shareScene", Integer.valueOf(paramInt));
    paramHashMap = n.a.b("menu:share:appmessage", paramHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.mHh.an("scene", "friend", this.IRl);
      AppMethodBeat.o(224336);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(224336);
    }
  }
  
  public final void cL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224304);
    try
    {
      this.mHh.l(paramString, paramBoolean, this.IRl);
      AppMethodBeat.o(224304);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224304);
    }
  }
  
  public final void cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(224374);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(224374);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224272);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224272);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224272);
        }
      }
    });
    AppMethodBeat.o(224374);
  }
  
  public final void d(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(224337);
    Log.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(this.GBl) });
    if (!this.GBl) {
      try
      {
        this.mHh.an("scene", "favorite", this.IRl);
        i(bH(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(224337);
        return;
      }
      catch (Exception paramHashMap)
      {
        Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
        AppMethodBeat.o(224337);
        return;
      }
    }
    paramHashMap = afU(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false))) {
      try
      {
        this.mHh.an("scene", "favorite", this.IRl);
        i(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(224337);
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
    paramHashMap = n.a.b("menu:share:appmessage", paramHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.mHh.an("scene", "favorite", this.IRl);
      AppMethodBeat.o(224337);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(224337);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(224325);
    gbj();
    this.GBl = false;
    this.FoQ.clear();
    this.IRf.clear();
    this.IRg = null;
    AppMethodBeat.o(224325);
  }
  
  public final void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(224388);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224388);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224290);
        try
        {
          if (h.f(h.this) != null) {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.IRM + ")", null);
          }
          AppMethodBeat.o(224290);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(224290);
        }
      }
    });
    AppMethodBeat.o(224388);
  }
  
  public final void eQ(Context paramContext)
  {
    this.IRe = paramContext;
  }
  
  public final void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(224394);
    if (MMHandlerThread.isMainThread())
    {
      this.IRa.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(224394);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224292);
        h.f(h.this).evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(224292);
      }
    });
    AppMethodBeat.o(224394);
  }
  
  public final void fWV()
  {
    AppMethodBeat.i(224362);
    if (this.FoQ != null) {
      this.FoQ.clear();
    }
    AppMethodBeat.o(224362);
  }
  
  public final void fWZ()
  {
    AppMethodBeat.i(224361);
    if (this.IRg != null) {
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224243);
          h.e(h.this);
          AppMethodBeat.o(224243);
        }
      });
    }
    AppMethodBeat.o(224361);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(224378);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(224378);
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
        AppMethodBeat.i(224278);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224278);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(224278);
        }
      }
    });
    AppMethodBeat.o(224378);
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(224302);
    if (this.IRj != true)
    {
      this.IRj = true;
      if (!com.tencent.matrix.trace.g.b.eP(this.IRa.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = Util.getRandomString(16);; str = this.IRa.getRandomStr())
    {
      this.zpY = str;
      Log.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.zpY, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(224302);
      return;
    }
  }
  
  public final void gaU()
  {
    AppMethodBeat.i(224303);
    this.IRj = true;
    this.zpY = Util.getRandomString(16);
    this.IRa.setRandomStr(this.zpY);
    Log.i("MicroMsg.JsApiHandler", "js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { this.zpY, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(224303);
  }
  
  public final String gaV()
  {
    return this.zpY;
  }
  
  public final com.tencent.mm.plugin.webview.d.b.a gaW()
  {
    AppMethodBeat.i(224309);
    if (this.IRq == null) {
      this.IRq = new com.tencent.mm.plugin.webview.d.b.a();
    }
    this.IRq.IQP = this.IRa;
    com.tencent.mm.plugin.webview.d.b.a locala = this.IRq;
    AppMethodBeat.o(224309);
    return locala;
  }
  
  public final void gaX()
  {
    AppMethodBeat.i(224312);
    if ((this.IRj) && (com.tencent.mm.pluginsdk.ui.tools.z.gsL()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("__event_id", "sys:updateRandomStr");
        localJSONObject2.put("randomStr", this.zpY);
        localJSONObject1.put("__json_message", localJSONObject2);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + localJSONObject1.toString() + ")", new ValueCallback() {});
        AppMethodBeat.o(224312);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(224312);
  }
  
  public final void gaY()
  {
    AppMethodBeat.i(224315);
    Log.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.GBl) });
    if ((this.IRa != null) && (this.GBl)) {
      this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:attach_runOn3rd_apis", gaZ(), this.IRj, this.zpY) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(224315);
  }
  
  public final boolean gbd()
  {
    AppMethodBeat.i(224366);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, not ready");
      AppMethodBeat.o(224366);
      return false;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224254);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224254);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224254);
        }
      }
    });
    AppMethodBeat.o(224366);
    return true;
  }
  
  public final void gbe()
  {
    AppMethodBeat.i(224382);
    Log.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(this.GBl) });
    if ((this.IRa != null) && (this.GBl)) {
      this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_all_hosts", new HashMap(), this.IRj, this.zpY) + ")", null);
    }
    AppMethodBeat.o(224382);
  }
  
  public final void gbf()
  {
    AppMethodBeat.i(224385);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(224385);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224283);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224283);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224283);
        }
      }
    });
    AppMethodBeat.o(224385);
  }
  
  public final void gbg()
  {
    AppMethodBeat.i(224387);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(224387);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = n.a.b("onNavigationBarRightButtonClick", new HashMap(), this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(224387);
  }
  
  public final long gbh()
  {
    AppMethodBeat.i(224389);
    Log.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.IRD) });
    long l = this.IRD;
    AppMethodBeat.o(224389);
    return l;
  }
  
  public final k gbi()
  {
    AppMethodBeat.i(224390);
    com.tencent.mm.plugin.expansions.a.cMr();
    if (this.IRE == null) {
      this.IRE = new k(this);
    }
    k localk = this.IRE;
    AppMethodBeat.o(224390);
    return localk;
  }
  
  public final void gbj()
  {
    AppMethodBeat.i(224391);
    if (!this.GBl)
    {
      AppMethodBeat.o(224391);
      return;
    }
    if (this.IRE != null) {
      this.IRE.clear();
    }
    if (this.mHh != null) {
      try
      {
        this.mHh.agx(this.IRl);
        AppMethodBeat.o(224391);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(224391);
  }
  
  public final int getBinderID()
  {
    return this.IRl;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(224323);
    if (this.IRt)
    {
      if (this.IRe != null)
      {
        localContext = this.IRe;
        AppMethodBeat.o(224323);
        return localContext;
      }
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(224323);
      return localContext;
    }
    if (this.IRa == null)
    {
      AppMethodBeat.o(224323);
      return null;
    }
    Context localContext = this.IRa.getActivityContextIfHas();
    AppMethodBeat.o(224323);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(224393);
    if (this.IRa == null)
    {
      AppMethodBeat.o(224393);
      return "";
    }
    String str = this.IRa.getUrl();
    AppMethodBeat.o(224393);
    return str;
  }
  
  public final com.tencent.xweb.z getSettings()
  {
    AppMethodBeat.i(224301);
    com.tencent.xweb.z localz = this.IRa.getSettings();
    AppMethodBeat.o(224301);
    return localz;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(224392);
    String str = (String)this.dVU.get("srcUsername");
    AppMethodBeat.o(224392);
    return str;
  }
  
  public final void gh(String paramString, int paramInt)
  {
    AppMethodBeat.i(224329);
    if (!this.GBl)
    {
      AppMethodBeat.o(224329);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString);
    localHashMap.put("videoCurrTime", Integer.valueOf(paramInt));
    localHashMap.put("action", "onExitMpVideoFullPage");
    paramString = n.a.b("onMPPageAction", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224329);
  }
  
  public final void gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(224331);
    if (!this.GBl)
    {
      AppMethodBeat.o(224331);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    localHashMap.put("shareFuncFlag", Integer.valueOf(paramInt));
    paramString = n.a.b("onMPPageAction", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224331);
  }
  
  public final void gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(224343);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(224343);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(224343);
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
          AppMethodBeat.i(224216);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
            AppMethodBeat.o(224216);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(224216);
          }
        }
      });
      AppMethodBeat.o(224343);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void gk(String paramString, int paramInt)
  {
    AppMethodBeat.i(224348);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(224348);
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
        AppMethodBeat.i(224227);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224227);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224227);
        }
      }
    });
    AppMethodBeat.o(224348);
  }
  
  public final void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(224349);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(224349);
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
        AppMethodBeat.i(224228);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224228);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224228);
        }
      }
    });
    AppMethodBeat.o(224349);
  }
  
  public final void gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(224350);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(224350);
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
        AppMethodBeat.i(224229);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224229);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224229);
        }
      }
    });
    AppMethodBeat.o(224350);
  }
  
  public final void gn(String paramString, int paramInt)
  {
    AppMethodBeat.i(224351);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(224351);
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
        AppMethodBeat.i(224230);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224230);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224230);
        }
      }
    });
    AppMethodBeat.o(224351);
  }
  
  public final void go(String paramString, int paramInt)
  {
    AppMethodBeat.i(224352);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(224352);
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
        AppMethodBeat.i(224231);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224231);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224231);
        }
      }
    });
    AppMethodBeat.o(224352);
  }
  
  final String gp(String paramString, int paramInt)
  {
    AppMethodBeat.i(224358);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = aYh(n.a.b("onGetA8KeyUrl", localHashMap, this.IRj, this.zpY));
    AppMethodBeat.o(224358);
    return paramString;
  }
  
  public final void gq(String paramString, int paramInt)
  {
    AppMethodBeat.i(224379);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(224379);
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
        AppMethodBeat.i(224279);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224279);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224279);
        }
      }
    });
    AppMethodBeat.o(224379);
  }
  
  public final void h(final String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224363);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(224363);
      return;
    }
    if (this.hdu.containsKey(paramString1))
    {
      localObject = (b)this.hdu.get(paramString1);
      if (localObject != null)
      {
        ((b)localObject).h(paramString1, paramString2, paramMap);
        this.hdu.remove(paramString1);
      }
      AppMethodBeat.o(224363);
      return;
    }
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(224363);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Log.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      ((Map)localObject).putAll(paramMap);
    }
    paramString1 = n.a.a(paramString1, (Map)localObject, this.IRj, this.zpY);
    Log.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramString1);
    if ((paramString1 != null) && (this.IRa != null))
    {
      paramString1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224245);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
            AppMethodBeat.o(224245);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(224245);
          }
        }
      };
      if (MMHandlerThread.isMainThread())
      {
        paramString1.run();
        AppMethodBeat.o(224363);
        return;
      }
      MMHandlerThread.postToMainThread(paramString1);
    }
    AppMethodBeat.o(224363);
  }
  
  public final void i(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(224340);
    if (paramBundle == null)
    {
      Log.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(224340);
      return;
    }
    if (this.IRg != null) {
      this.IRg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224213);
          n localn = new n();
          localn.params = new HashMap();
          localn.params.put("link", paramBundle.getString("link"));
          localn.params.put("title", paramBundle.getString("title"));
          localn.params.put("desc", paramBundle.getString("desc"));
          localn.ISf = new JSONObject();
          localn.params.put("img_url", paramBundle.getString("img_url"));
          localn.params.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          localn.type = "call";
          localn.ISe = "";
          localn.mhO = paramString;
          h.d(h.this).add(localn);
          h.e(h.this);
          AppMethodBeat.o(224213);
        }
      });
    }
    AppMethodBeat.o(224340);
  }
  
  public final boolean isReady()
  {
    return this.GBl;
  }
  
  public final void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(224341);
    if ((!this.GBl) || (paramBundle == null))
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(224341);
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
        AppMethodBeat.i(224214);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224214);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224214);
        }
      }
    });
    AppMethodBeat.o(224341);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(224333);
    if (!this.GBl)
    {
      AppMethodBeat.o(224333);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("vid", paramString2);
    localHashMap.put("errMsg", paramString3);
    localHashMap.put("currentTime", paramString4);
    localHashMap.put("playedTotalTime", paramString5);
    paramString1 = n.a.b("onMPVideoStateChange", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(224333);
  }
  
  public final void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(224365);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(224365);
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
        AppMethodBeat.i(224251);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224251);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224251);
        }
      }
    });
    AppMethodBeat.o(224365);
  }
  
  public final void lT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224330);
    if (!this.GBl)
    {
      AppMethodBeat.o(224330);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = n.a.b("onMPPageAction", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(224330);
  }
  
  public final void lU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224368);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(224368);
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
        AppMethodBeat.i(224264);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", new ValueCallback() {});
          AppMethodBeat.o(224264);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224264);
        }
      }
    });
    AppMethodBeat.o(224368);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(224345);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onWindowFocusChanged fail, not ready %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(224345);
      return;
    }
    if (this.IRa == null)
    {
      AppMethodBeat.o(224345);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.brandservice.a.b)localObject).isMpUrl(this.IRa.getUrl())))
    {
      AppMethodBeat.o(224345);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "onWindowFocusChanged, hasFocus = ".concat(String.valueOf(paramBoolean)));
    localObject = new HashMap();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((Map)localObject).put("hasFocus", Integer.valueOf(i));
      localObject = n.a.b("onWindowFocusChanged", (Map)localObject, this.IRj, this.zpY);
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224222);
          try
          {
            h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
            AppMethodBeat.o(224222);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(224222);
          }
        }
      });
      AppMethodBeat.o(224345);
      return;
    }
  }
  
  public final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(224327);
    if (!this.GBl)
    {
      AppMethodBeat.o(224327);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = n.a.b("menu:haokan", localHashMap, this.IRj, this.zpY);
    this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(224327);
  }
  
  public final void x(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(224376);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(224376);
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
        AppMethodBeat.i(224274);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224274);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224274);
        }
      }
    });
    AppMethodBeat.o(224376);
  }
  
  public final void yV(boolean paramBoolean)
  {
    AppMethodBeat.i(224313);
    this.GBl = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "js ready %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(224313);
  }
  
  public final void yW(boolean paramBoolean)
  {
    AppMethodBeat.i(224314);
    this.IRh = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "setIsFloating %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(224314);
  }
  
  public final void yX(boolean paramBoolean)
  {
    AppMethodBeat.i(224355);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(224355);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224239);
        try
        {
          h.f(h.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
          AppMethodBeat.o(224239);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224239);
        }
      }
    });
    AppMethodBeat.o(224355);
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(224381);
    if (!this.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(224381);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224281);
        try
        {
          h.f(h.this).evaluateJavascript(this.IRM, null);
          AppMethodBeat.o(224281);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(224281);
        }
      }
    });
    AppMethodBeat.o(224381);
  }
  
  public final void yZ(boolean paramBoolean)
  {
    AppMethodBeat.i(224383);
    Log.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.GBl) });
    if ((this.IRa != null) && (this.mHh != null) && (this.GBl)) {
      if (paramBoolean)
      {
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224383);
        return;
      }
    }
    try
    {
      List localList = this.mHh.gej();
      Uri localUri = Uri.parse(this.IRa.getUrl());
      if (localUri != null) {
        Log.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.IRj, this.zpY) + ")", null);
      }
      AppMethodBeat.o(224383);
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
  
  public static abstract interface a
  {
    public abstract boolean b(n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.h
 * JD-Core Version:    0.7.0.1
 */