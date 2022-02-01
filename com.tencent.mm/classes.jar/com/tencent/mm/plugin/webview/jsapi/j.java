package com.tencent.mm.plugin.webview.jsapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.plugin.webview.modeltools.k;
import com.tencent.mm.pluginsdk.ui.tools.aa;
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
import com.tencent.threadpool.i;
import com.tencent.xweb.ao;
import java.util.ArrayList;
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

public class j
  implements com.tencent.mm.plugin.webview.jsapi.d.a, e, f
{
  public BaseWebViewController GXZ;
  public String KQY;
  private final LinkedList<p> PmC;
  public boolean UcS;
  private Context WDC;
  private final List<String> WDD;
  private MMHandler WDE;
  private long WDF;
  private boolean WDG;
  public com.tencent.mm.plugin.webview.stub.f WDH;
  public boolean WDI;
  public boolean WDJ;
  public int WDK;
  public a WDL;
  private Set<String> WDM;
  private boolean WDN;
  public List<com.tencent.mm.plugin.webview.jsapi.a.a> WDO;
  public String WDP;
  com.tencent.mm.b.h WDQ;
  private com.tencent.mm.plugin.webview.jsapi.b.a WDR;
  public r WDS;
  private JsapiPermissionWrapper WDT;
  private Bundle WDU;
  private boolean WDV;
  public String WDW;
  public String WDX;
  private final List<String> WDY;
  private volatile String WDZ;
  public MMWebView WDz;
  private volatile int WEa;
  private JSONObject WEb;
  private JSONArray WEc;
  private List<String> WEd;
  private MTimerHandler WEe;
  public long WEf;
  private com.tencent.mm.plugin.webview.l.j WEg;
  private g Wwh;
  public Map<String, Object> hVt;
  private boolean isActive;
  HashMap<String, c> mnT;
  public com.tencent.mm.plugin.webview.stub.e sLC;
  private com.tencent.mm.plugin.webview.e.g sNd;
  
  public j()
  {
    AppMethodBeat.i(295284);
    this.WDD = new LinkedList();
    this.PmC = new LinkedList();
    this.WDE = null;
    this.UcS = false;
    this.isActive = true;
    this.WDF = 0L;
    this.WDG = false;
    this.WDI = false;
    this.KQY = "";
    this.WDJ = false;
    this.WDM = null;
    this.WDN = false;
    this.Wwh = null;
    this.WDO = new ArrayList();
    com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
    this.WDQ = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.p.isQ());
    this.WDR = null;
    this.WDS = null;
    this.mnT = new HashMap();
    this.WDV = false;
    this.WDY = new LinkedList();
    this.WDZ = null;
    this.WEa = 0;
    this.WEb = new JSONObject();
    this.WEc = new JSONArray();
    this.WEd = new LinkedList();
    this.WEe = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(295190);
        String str = p.a.a("onBeaconsInRange", j.j(j.this), j.k(j.this), j.l(j.this));
        j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        j.m(j.this).clear();
        j.a(j.this, new JSONObject());
        j.a(j.this, new JSONArray());
        AppMethodBeat.o(295190);
        return false;
      }
    }, false);
    this.WEf = 0L;
    AppMethodBeat.o(295284);
  }
  
  public j(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.e.g paramg, int paramInt)
  {
    AppMethodBeat.i(295298);
    this.WDD = new LinkedList();
    this.PmC = new LinkedList();
    this.WDE = null;
    this.UcS = false;
    this.isActive = true;
    this.WDF = 0L;
    this.WDG = false;
    this.WDI = false;
    this.KQY = "";
    this.WDJ = false;
    this.WDM = null;
    this.WDN = false;
    this.Wwh = null;
    this.WDO = new ArrayList();
    com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
    this.WDQ = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.p.isQ());
    this.WDR = null;
    this.WDS = null;
    this.mnT = new HashMap();
    this.WDV = false;
    this.WDY = new LinkedList();
    this.WDZ = null;
    this.WEa = 0;
    this.WEb = new JSONObject();
    this.WEc = new JSONArray();
    this.WEd = new LinkedList();
    this.WEe = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(295190);
        String str = p.a.a("onBeaconsInRange", j.j(j.this), j.k(j.this), j.l(j.this));
        j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        j.m(j.this).clear();
        j.a(j.this, new JSONObject());
        j.a(j.this, new JSONArray());
        AppMethodBeat.o(295190);
        return false;
      }
    }, false);
    this.WEf = 0L;
    this.WDz = paramMMWebView;
    this.sNd = paramg;
    this.WDK = paramInt;
    itu();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(295298);
      return;
    }
  }
  
  public j(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.e.g paramg, int paramInt, g paramg1)
  {
    AppMethodBeat.i(295307);
    this.WDD = new LinkedList();
    this.PmC = new LinkedList();
    this.WDE = null;
    this.UcS = false;
    this.isActive = true;
    this.WDF = 0L;
    this.WDG = false;
    this.WDI = false;
    this.KQY = "";
    this.WDJ = false;
    this.WDM = null;
    this.WDN = false;
    this.Wwh = null;
    this.WDO = new ArrayList();
    com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
    this.WDQ = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.p.isQ());
    this.WDR = null;
    this.WDS = null;
    this.mnT = new HashMap();
    this.WDV = false;
    this.WDY = new LinkedList();
    this.WDZ = null;
    this.WEa = 0;
    this.WEb = new JSONObject();
    this.WEc = new JSONArray();
    this.WEd = new LinkedList();
    this.WEe = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(295190);
        String str = p.a.a("onBeaconsInRange", j.j(j.this), j.k(j.this), j.l(j.this));
        j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        j.m(j.this).clear();
        j.a(j.this, new JSONObject());
        j.a(j.this, new JSONArray());
        AppMethodBeat.o(295190);
        return false;
      }
    }, false);
    this.WEf = 0L;
    this.WDz = paramMMWebView;
    this.sNd = paramg;
    this.WDK = paramInt;
    this.Wwh = paramg1;
    itu();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, jsApiPool: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), paramg1 });
      AppMethodBeat.o(295307);
      return;
    }
  }
  
  public j(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.e.g paramg, int paramInt, Set<String> paramSet)
  {
    AppMethodBeat.i(295318);
    this.WDD = new LinkedList();
    this.PmC = new LinkedList();
    this.WDE = null;
    this.UcS = false;
    this.isActive = true;
    this.WDF = 0L;
    this.WDG = false;
    this.WDI = false;
    this.KQY = "";
    this.WDJ = false;
    this.WDM = null;
    this.WDN = false;
    this.Wwh = null;
    this.WDO = new ArrayList();
    com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
    this.WDQ = new com.tencent.mm.b.h(com.tencent.mm.plugin.webview.core.p.isQ());
    this.WDR = null;
    this.WDS = null;
    this.mnT = new HashMap();
    this.WDV = false;
    this.WDY = new LinkedList();
    this.WDZ = null;
    this.WEa = 0;
    this.WEb = new JSONObject();
    this.WEc = new JSONArray();
    this.WEd = new LinkedList();
    this.WEe = new MTimerHandler("BeaconRangeTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(295190);
        String str = p.a.a("onBeaconsInRange", j.j(j.this), j.k(j.this), j.l(j.this));
        j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
        j.m(j.this).clear();
        j.a(j.this, new JSONObject());
        j.a(j.this, new JSONArray());
        AppMethodBeat.o(295190);
        return false;
      }
    }, false);
    this.WEf = 0L;
    this.WDz = paramMMWebView;
    this.sNd = paramg;
    this.WDK = paramInt;
    paramg = paramSet;
    if (paramSet == null) {
      paramg = new HashSet();
    }
    this.WDM = paramg;
    this.WDN = true;
    itu();
    if (paramMMWebView == null) {}
    for (paramInt = 0;; paramInt = paramMMWebView.hashCode())
    {
      Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(295318);
      return;
    }
  }
  
  private boolean a(final p paramp, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, c paramc)
  {
    AppMethodBeat.i(295416);
    if (paramp == null)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
      AppMethodBeat.o(295416);
      return true;
    }
    if (("getBrandWCPayRequest".equals(paramp.function)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(2));
      AppMethodBeat.o(295416);
      return true;
    }
    if ((Arrays.asList(new String[] { "getBrandWCPayBindCardRequest", "openWCPaySpecificView", "verifyWCPayPassword", "getH5TransactionRequest", "getH5PrepayRequest", "getWCPayRealnameVerify", "selectWalletCurrency", "changePayActivityView", "unbindBankCard", "uploadIdCardSuccess", "idCardRealnameVerify", "setWCPayPassword", "handleWCPayWalletBuffer", "faceVerifyForPay" }).contains(paramp.function)) && (!WeChatBrands.Business.Entries.PaymentH5Jsb.checkAvailable(getContext())))
    {
      paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(2));
      AppMethodBeat.o(295416);
      return true;
    }
    if (this.WDG)
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, floating now");
      paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(3));
      AppMethodBeat.o(295416);
      return true;
    }
    if ((paramp.function == null) || (paramp.params == null) || (paramp.type == null) || ((!this.WDV) && (this.WDz == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + paramp.function + ", params = " + paramp.params + ", type = " + paramp.type + ", wv = " + this.WDz);
      paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(4));
      AppMethodBeat.o(295416);
      return true;
    }
    if ((this.WDN) && ((this.WDM == null) || (!this.WDM.contains(paramp.function))))
    {
      Log.i("MicroMsg.JsApiHandler", "limited mode, call unsupported JsApi: %s", new Object[] { paramp.function });
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295377);
          j.this.doCallback(paramp.WEH, "system:access_denied", null);
          AppMethodBeat.o(295377);
        }
      });
      paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(5));
      AppMethodBeat.o(295416);
      return true;
    }
    if (paramBundle != null) {
      paramp.WDU = paramBundle;
    }
    if (paramc != null) {
      this.mnT.put(paramp.WEH, paramc);
    }
    if ((this.hVt != null) && (this.hVt.get("srcUsername") != null) && (!Util.isNullOrNil(this.hVt.get("srcUsername").toString()))) {
      paramp.params.put("src_username", this.hVt.get("srcUsername").toString());
    }
    if ((this.hVt != null) && (this.hVt.get("srcDisplayname") != null) && (!Util.isNullOrNil(this.hVt.get("srcDisplayname").toString()))) {
      paramp.params.put("src_displayname", this.hVt.get("srcDisplayname").toString());
    }
    if ((this.hVt != null) && (this.hVt.get("KTemplateId") != null) && (!Util.isNullOrNil(this.hVt.get("KTemplateId").toString()))) {
      paramp.params.put("tempalate_id", this.hVt.get("KTemplateId").toString());
    }
    if (this.hVt != null)
    {
      paramp.params.put("message_id", this.hVt.get("message_id"));
      paramp.params.put("message_index", this.hVt.get("message_index"));
      paramp.params.put("webview_scene", this.hVt.get("scene"));
      paramp.params.put("pay_channel", this.hVt.get("pay_channel"));
      paramp.params.put("pay_scene", this.hVt.get("pay_scene"));
      Log.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[] { this.hVt.get("pay_package") });
      if (this.hVt.get("pay_package") != null) {
        paramp.params.put("pay_packageName", this.hVt.get("pay_package"));
      }
      paramp.params.put("stastic_scene", this.hVt.get("stastic_scene"));
      paramp.params.put("open_from_scene", this.hVt.get("from_scence"));
      paramBundle = paramp.params;
      paramc = new Bundle();
      paramc.putString("__jsapi_fw_ext_info_key_current_url", this.WDz.getUrl());
      paramBundle.put("__jsapi_fw_ext_info", paramc);
    }
    if ((this.WDz != null) && (!paramp.function.equals("shareWeibo")) && (!paramp.function.equals("openUrlByExtBrowser")) && (!paramp.function.equals("log")) && (!paramp.function.equals("openUrlWithExtraWebview")) && (!paramp.function.equals("openCustomWebview")) && (!paramp.function.equals("openGameWebView")) && (!paramp.function.equals("addToEmoticon")) && (!paramp.function.equals("shareEmoticon")) && (!paramp.function.equals("openGameUrlWithExtraWebView")) && (!paramp.function.equals("request")))
    {
      paramp.params.put("url", this.WDz.getUrl());
      Log.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl:" + this.WDz.getUrl());
    }
    if ((paramp.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramp.function.equalsIgnoreCase("openEmotionDetailViewLocal")) || (paramp.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramp.function.equalsIgnoreCase("openDesignerEmojiViewLocal")) || (paramp.function.equalsIgnoreCase("openDesignerEmojiView")) || (paramp.function.equalsIgnoreCase("openDesignerProfile")) || (paramp.function.equalsIgnoreCase("openDesignerProfileLocal")) || (paramp.function.equalsIgnoreCase("getSearchEmotionData")))
    {
      paramp.params.put("searchID", Long.valueOf(itI()));
      Log.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[] { Long.valueOf(itI()) });
    }
    if (paramp.function.equals("request"))
    {
      if (this.WDW != null) {
        paramp.params.put("key_request_full_url_query", this.WDW);
      }
      if (this.WDX != null) {
        paramp.params.put("key_request_header", this.WDX);
      }
    }
    if (paramp.function.equals("imagePreview")) {
      k.a(paramp.params, this.WDz);
    }
    if ((paramp.function.equals("preVerifyJSAPI")) && (paramp.params.containsKey("verifyOpenTagList"))) {
      com.tencent.mm.plugin.webview.l.c.iDc();
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
          localBundle1.putByteArray("jsapi_perm_wrapper_bytes", paramJsapiPermissionWrapper.YxJ);
          bool2 = bool1;
          localBundle1.putInt("jsapi_perm_wrapper_hardcodePermission", paramJsapiPermissionWrapper.YxK);
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_blacklist", paramJsapiPermissionWrapper.iPW());
          bool2 = bool1;
          localBundle1.putIntArray("jsapi_perm_wrapper_whitelist", paramJsapiPermissionWrapper.iPX());
        }
        bool2 = bool1;
        paramc = p.cj(paramp.params);
        bool2 = bool1;
        if (!Util.isNullOrNil(this.WDP))
        {
          bool2 = bool1;
          paramc.putString("key_wxapp_id", this.WDP);
        }
        bool2 = bool1;
        localBundle2 = new Bundle(3);
        paramBundle = paramc;
        bool2 = bool1;
        if (paramp.WDU != null)
        {
          bool2 = bool1;
          localBundle2.putBundle("jsEngine", paramp.WDU);
          paramBundle = paramc;
          if (paramc == null)
          {
            bool2 = bool1;
            paramBundle = new Bundle();
          }
        }
        bool2 = bool1;
        localBundle2.putBundle("compatParams", paramBundle);
        bool2 = bool1;
        if (paramp.WEI != null)
        {
          bool2 = bool1;
          localBundle2.putString("rawParams", paramp.WEI.toString());
        }
        bool2 = bool1;
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg start %s", new Object[] { paramp.function });
        bool2 = bool1;
        if (this.WDL != null)
        {
          bool2 = bool1;
          bool3 = this.WDL.handleMsg(paramp, paramJsapiPermissionWrapper);
        }
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          paramJsapiPermissionWrapper = new h(getContext(), paramJsapiPermissionWrapper, this.sLC, this, this.WDz);
          bool2 = bool3;
          paramBundle = t.WEP;
          bool2 = bool3;
          bool1 = t.a(paramJsapiPermissionWrapper, paramp);
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
        paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(6));
        continue;
        AppMethodBeat.o(295416);
        return false;
      }
      try
      {
        Log.v("MicroMsg.JsApiHandler", "dealNextMsg intercepted %s", new Object[] { paramp.function });
        i = 1;
        k.iwf();
        Log.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[] { paramp.function, Boolean.valueOf(bool1) });
        if (bool1) {
          paramp.WEJ.put("jsapiHandleResult", Integer.valueOf(1));
        }
        if ((bool1) && (i == 0)) {
          continue;
        }
        AppMethodBeat.o(295416);
        return true;
      }
      catch (Exception paramJsapiPermissionWrapper)
      {
        continue;
        continue;
      }
      bool2 = bool1;
      paramJsapiPermissionWrapper = this.sNd.iwo();
      break;
      bool2 = bool1;
      if ((this.sLC == null) || (paramp == null)) {
        break label2069;
      }
      bool2 = bool1;
      bool1 = this.sLC.a(paramp.type, paramp.function, paramp.WEH, localBundle1, localBundle2, this.WDK);
      i = 0;
    }
  }
  
  /* Error */
  private static boolean aa(String paramString, Map<String, Integer> paramMap)
  {
    // Byte code:
    //   0: ldc_w 871
    //   3: invokestatic 269	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 614	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +7 -> 17
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: ldc_w 381
    //   20: ldc_w 873
    //   23: invokestatic 866	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc_w 871
    //   29: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 875	com/tencent/mm/vfs/u
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 876	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 879	com/tencent/mm/vfs/u:jKS	()Z
    //   49: ifne +9 -> 58
    //   52: aload 4
    //   54: invokevirtual 882	com/tencent/mm/vfs/u:jKZ	()Z
    //   57: pop
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: iconst_1
    //   63: invokestatic 887	com/tencent/mm/vfs/y:e	(Lcom/tencent/mm/vfs/u;Z)Ljava/io/OutputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokeinterface 419 1 0
    //   77: invokeinterface 888 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 472 1 0
    //   91: ifeq +158 -> 249
    //   94: aload 4
    //   96: invokeinterface 476 1 0
    //   101: checkcast 492	java/lang/String
    //   104: astore 5
    //   106: aload_1
    //   107: aload 5
    //   109: invokeinterface 429 2 0
    //   114: checkcast 385	java/lang/Integer
    //   117: invokevirtual 432	java/lang/Integer:intValue	()I
    //   120: istore_2
    //   121: aload_3
    //   122: new 561	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 889	java/lang/StringBuilder:<init>	()V
    //   129: iload_2
    //   130: invokevirtual 892	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc_w 894
    //   136: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 583	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 898	java/lang/String:getBytes	()[B
    //   150: invokevirtual 904	java/io/OutputStream:write	([B)V
    //   153: aload_3
    //   154: bipush 13
    //   156: invokevirtual 906	java/io/OutputStream:write	(I)V
    //   159: aload_3
    //   160: bipush 10
    //   162: invokevirtual 906	java/io/OutputStream:write	(I)V
    //   165: goto -81 -> 84
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: ldc_w 381
    //   174: aload_1
    //   175: ldc_w 290
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: ldc_w 381
    //   188: ldc_w 908
    //   191: invokestatic 866	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 911	java/io/OutputStream:close	()V
    //   202: ldc_w 871
    //   205: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: ldc_w 381
    //   214: ldc_w 913
    //   217: aload_0
    //   218: invokestatic 916	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 919	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 381
    //   230: aload_1
    //   231: ldc_w 290
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: ldc_w 871
    //   244: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_3
    //   250: invokevirtual 922	java/io/OutputStream:flush	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 911	java/io/OutputStream:close	()V
    //   261: ldc_w 381
    //   264: ldc_w 924
    //   267: aload_0
    //   268: invokestatic 916	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 919	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 926	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: ldc_w 871
    //   280: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: ldc_w 381
    //   289: aload_1
    //   290: ldc_w 290
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: ldc_w 381
    //   307: aload_0
    //   308: ldc_w 290
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -116 -> 202
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 911	java/io/OutputStream:close	()V
    //   332: ldc_w 871
    //   335: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: ldc_w 381
    //   344: aload_1
    //   345: ldc_w 290
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  /* Error */
  private boolean bjI(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 935
    //   5: invokestatic 269	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 938	com/tencent/mm/plugin/webview/jsapi/j:itw	()Z
    //   12: ifeq +10 -> 22
    //   15: aload_1
    //   16: invokestatic 614	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   19: ifeq +15 -> 34
    //   22: iconst_0
    //   23: istore_2
    //   24: ldc_w 935
    //   27: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 321	com/tencent/mm/plugin/webview/jsapi/j:WDQ	Lcom/tencent/mm/b/h;
    //   38: aload_1
    //   39: invokevirtual 939	java/lang/String:hashCode	()I
    //   42: invokestatic 389	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aload_1
    //   46: invokevirtual 940	com/tencent/mm/b/h:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: ldc_w 935
    //   55: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -28 -> 30
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	j
    //   0	66	1	paramString	String
    //   23	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	61	finally
    //   24	30	61	finally
    //   34	50	61	finally
    //   52	58	61	finally
  }
  
  public static String bjM(String paramString)
  {
    AppMethodBeat.i(295427);
    paramString = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[] { Util.nullAsNil(paramString) });
    AppMethodBeat.o(295427);
    return paramString;
  }
  
  private String bjP(String paramString)
  {
    AppMethodBeat.i(295432);
    String str1 = this.WDz.getUrl();
    try
    {
      String str2 = n.hv(str1 + paramString);
      str2 = b.bmF() + str2;
      Log.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[] { str1, paramString, str2 });
      AppMethodBeat.o(295432);
      return str2;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(str1)));
      Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
      AppMethodBeat.o(295432);
    }
    return null;
  }
  
  private void crU()
  {
    try
    {
      AppMethodBeat.i(295356);
      if (this.WDQ.size() > 0)
      {
        Iterator localIterator = this.WDQ.entrySet().iterator();
        while ((!itw()) && (localIterator.hasNext()))
        {
          String str = (String)((Map.Entry)localIterator.next()).getValue();
          if (!Util.isNullOrNil(str)) {
            _sendMessage(str);
          }
        }
        this.WDQ.clear();
      }
    }
    finally {}
    AppMethodBeat.o(295356);
  }
  
  private String hX(String paramString, int paramInt)
  {
    AppMethodBeat.i(295421);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("url", paramString);
    localHashMap.put("set_cookie", Integer.valueOf(paramInt));
    paramString = bjM(p.a.b("onGetA8KeyUrl", localHashMap, this.WDI, this.KQY));
    AppMethodBeat.o(295421);
    return paramString;
  }
  
  private Map<String, Object> itA()
  {
    AppMethodBeat.i(295375);
    HashMap localHashMap = new HashMap();
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.sNd.iwo();
    LinkedList localLinkedList = new LinkedList();
    if (localJsapiPermissionWrapper != null)
    {
      if (localJsapiPermissionWrapper.sk(88)) {
        localLinkedList.add("menu:share:timeline");
      }
      if (localJsapiPermissionWrapper.sk(89)) {
        localLinkedList.add("menu:share:appmessage");
      }
      if (localJsapiPermissionWrapper.sk(94)) {
        localLinkedList.add("menu:share:qq");
      }
      if (localJsapiPermissionWrapper.sk(109)) {
        localLinkedList.add("menu:share:weiboApp");
      }
      if (localJsapiPermissionWrapper.sk(134)) {
        localLinkedList.add("menu:share:QZone");
      }
      if (localJsapiPermissionWrapper.sk(219)) {
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
      localLinkedList.add("onDeviceMotionFired");
      localLinkedList.add("onGetVertSearchEntriesData");
      localLinkedList.add("onMPCustomMenuItemClick");
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
      localLinkedList.add("onUserGoBack");
    }
    localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
    AppMethodBeat.o(295375);
    return localHashMap;
  }
  
  private boolean itB()
  {
    AppMethodBeat.i(295382);
    boolean bool1 = false;
    try
    {
      boolean bool2 = this.sLC.aud(this.WDK);
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
    AppMethodBeat.o(295382);
    return bool1;
  }
  
  private void itC()
  {
    AppMethodBeat.i(295387);
    while (itD()) {}
    AppMethodBeat.o(295387);
  }
  
  private boolean itD()
  {
    AppMethodBeat.i(295393);
    if (Util.isNullOrNil(this.PmC))
    {
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
      AppMethodBeat.o(295393);
      return false;
    }
    boolean bool;
    try
    {
      bool = this.sLC.aud(this.WDK);
      Log.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
        AppMethodBeat.o(295393);
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
      if (this.PmC.size() == 0)
      {
        Log.w("MicroMsg.JsApiHandler", "msgList size is 0.");
        AppMethodBeat.o(295393);
        return false;
      }
      p localp = (p)this.PmC.remove(0);
      if (localp == null)
      {
        Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
        AppMethodBeat.o(295393);
        return true;
      }
      oi(localp.function, localp.WEH);
      bool = a(localp, localp.WlV, localp.WDU, localp.WlW);
      j(localp.function, localp.WEH, localp.WEJ);
      AppMethodBeat.o(295393);
    }
    return bool;
  }
  
  private void itu()
  {
    AppMethodBeat.i(295340);
    this.WDE = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(295329);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(295329);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if (!Util.isNullOrNil(paramAnonymousMessage)) {
            j.b(j.this).add(paramAnonymousMessage);
          }
          j.c(j.this);
          AppMethodBeat.o(295329);
          return;
          Log.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(295340);
  }
  
  private boolean itw()
  {
    AppMethodBeat.i(295345);
    if (!this.isActive)
    {
      com.tencent.mm.plugin.webview.core.p localp = com.tencent.mm.plugin.webview.core.p.WzF;
      if (com.tencent.mm.plugin.webview.core.p.isR())
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.WDF;
        localp = com.tencent.mm.plugin.webview.core.p.WzF;
        if (l1 - l2 > com.tencent.mm.plugin.webview.core.p.isP())
        {
          AppMethodBeat.o(295345);
          return true;
        }
      }
    }
    AppMethodBeat.o(295345);
    return false;
  }
  
  private void j(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295328);
    if (!this.WDO.isEmpty())
    {
      Iterator localIterator = this.WDO.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.webview.jsapi.a.a locala = (com.tencent.mm.plugin.webview.jsapi.a.a)localIterator.next();
        if (locala != null) {
          locala.j(paramString1, paramString2, paramMap);
        }
      }
    }
    AppMethodBeat.o(295328);
  }
  
  private void oi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295324);
    if (!this.WDO.isEmpty())
    {
      Iterator localIterator = this.WDO.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.webview.jsapi.a.a locala = (com.tencent.mm.plugin.webview.jsapi.a.a)localIterator.next();
        if (locala != null) {
          locala.oi(paramString1, paramString2);
        }
      }
    }
    AppMethodBeat.o(295324);
  }
  
  private void oj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295332);
    if (!this.WDO.isEmpty())
    {
      Iterator localIterator = this.WDO.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.webview.jsapi.a.a locala = (com.tencent.mm.plugin.webview.jsapi.a.a)localIterator.next();
        if (locala != null) {
          locala.oj(paramString1, paramString2);
        }
      }
    }
    AppMethodBeat.o(295332);
  }
  
  /* Error */
  private static boolean om(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1385
    //   3: invokestatic 269	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 614	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 614	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +20 -> 37
    //   20: ldc_w 381
    //   23: ldc_w 873
    //   26: invokestatic 866	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 1385
    //   32: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: new 875	com/tencent/mm/vfs/u
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 876	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 879	com/tencent/mm/vfs/u:jKS	()Z
    //   52: ifne +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 882	com/tencent/mm/vfs/u:jKZ	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 1389	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   70: astore 4
    //   72: aload 4
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 898	java/lang/String:getBytes	()[B
    //   84: invokevirtual 904	java/io/OutputStream:write	([B)V
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: bipush 13
    //   97: invokevirtual 906	java/io/OutputStream:write	(I)V
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: bipush 10
    //   110: invokevirtual 906	java/io/OutputStream:write	(I)V
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 922	java/io/OutputStream:flush	()V
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 911	java/io/OutputStream:close	()V
    //   134: ldc_w 381
    //   137: ldc_w 924
    //   140: aload_0
    //   141: invokestatic 916	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 919	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 926	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1385
    //   153: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: ldc_w 381
    //   162: ldc_w 913
    //   165: aload_0
    //   166: invokestatic 916	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 919	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc_w 381
    //   178: aload_1
    //   179: ldc_w 290
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: ldc_w 1385
    //   192: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: ldc_w 381
    //   201: aload_1
    //   202: ldc_w 290
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -78 -> 134
    //   215: astore_0
    //   216: aload_2
    //   217: astore_3
    //   218: ldc_w 381
    //   221: aload_0
    //   222: ldc_w 290
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: astore_3
    //   234: ldc_w 381
    //   237: ldc_w 908
    //   240: invokestatic 866	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 911	java/io/OutputStream:close	()V
    //   251: ldc_w 1385
    //   254: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: ldc_w 381
    //   263: aload_0
    //   264: ldc_w 290
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 911	java/io/OutputStream:close	()V
    //   286: ldc_w 1385
    //   289: invokestatic 367	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_1
    //   295: ldc_w 381
    //   298: aload_1
    //   299: ldc_w 290
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 858	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void D(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(295601);
    if (!this.UcS)
    {
      AppMethodBeat.o(295601);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend", Integer.valueOf(paramInt1));
    localHashMap.put("comment", paramString);
    localHashMap.put("scene", Integer.valueOf(paramInt2));
    paramString = p.a.b("menu:haokan", localHashMap, this.WDI, this.KQY);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(295601);
  }
  
  public final void E(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(295735);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
      AppMethodBeat.o(295735);
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
        AppMethodBeat.i(295179);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295179);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295179);
        }
      }
    });
    AppMethodBeat.o(295735);
  }
  
  public final void IA(boolean paramBoolean)
  {
    AppMethodBeat.i(295655);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295655);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("success", Boolean.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295187);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295187);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295187);
        }
      }
    });
    AppMethodBeat.o(295655);
  }
  
  public final void IB(boolean paramBoolean)
  {
    AppMethodBeat.i(295757);
    setActive(paramBoolean);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
      AppMethodBeat.o(295757);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("active", String.valueOf(paramBoolean));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295337);
        try
        {
          j.f(j.this).evaluateJavascript(this.WEo, null);
          AppMethodBeat.o(295337);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295337);
        }
      }
    });
    AppMethodBeat.o(295757);
  }
  
  public final void IC(boolean paramBoolean)
  {
    AppMethodBeat.i(295764);
    Log.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[] { Boolean.valueOf(this.UcS) });
    if ((this.WDz != null) && (this.sLC != null) && (this.UcS)) {
      if (paramBoolean)
      {
        this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:get_html_content", new HashMap(), this.WDI, this.KQY) + ")", null);
        AppMethodBeat.o(295764);
        return;
      }
    }
    try
    {
      List localList = this.sLC.ixh();
      Uri localUri = Uri.parse(this.WDz.getUrl());
      if (localUri != null) {
        Log.d("MicroMsg.JsApiHandler", "wv hijack url host" + localUri.getHost());
      }
      if ((localList != null) && (localUri != null) && (localList.contains(localUri.getHost()))) {
        this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:get_html_content", new HashMap(), this.WDI, this.KQY) + ")", null);
      }
      AppMethodBeat.o(295764);
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
  
  public final void Iy(boolean paramBoolean)
  {
    AppMethodBeat.i(295569);
    this.UcS = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "js ready %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(295569);
  }
  
  public final void Iz(boolean paramBoolean)
  {
    AppMethodBeat.i(295573);
    this.WDG = paramBoolean;
    Log.i("MicroMsg.JsApiHandler", "setIsFloating %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(295573);
  }
  
  public final void Y(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(295661);
    Log.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(295661);
      return;
    }
    this.WDZ = paramString;
    if ((paramMap != null) && (paramMap.size() != 0)) {}
    for (this.WEa = 1;; this.WEa = 0)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295197);
          try
          {
            if ((paramMap == null) || (paramMap.size() == 0)) {
              break label176;
            }
            ao.oQ(MMApplicationContext.getContext());
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ao.setCookie(Util.getDomin(paramString), str + "=" + (String)paramMap.get(str));
            }
            ao.setCookie(Util.getDomin(paramString), "httponly");
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295197);
            return;
          }
          ao.kgo();
          Log.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { ao.getCookie(Util.getDomin(paramString)) });
          label176:
          j.f(j.this).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { paramString }), null);
          j.f(j.this).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
          if (j.g(j.this))
          {
            j.f(j.this).evaluateJavascript(this.WEk, null);
            j.h(j.this);
            j.i(j.this);
          }
          AppMethodBeat.o(295197);
        }
      });
      AppMethodBeat.o(295661);
      return;
    }
  }
  
  public final void Z(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295783);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready, event=%s", new Object[] { paramString });
      AppMethodBeat.o(295783);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295371);
        try
        {
          if (j.f(j.this) != null) {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.WEo + ")", null);
          }
          AppMethodBeat.o(295371);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(295371);
        }
      }
    });
    AppMethodBeat.o(295783);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getAllHosts(final String paramString)
  {
    AppMethodBeat.i(295534);
    if (paramString != null) {
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295380);
          Map localMap = j.V(paramString.split(","));
          String str = j.a(j.this, "hosts");
          if (j.ab(str, localMap))
          {
            if ((j.n(j.this) == null) || (j.f(j.this) == null)) {
              break label118;
            }
            try
            {
              j.n(j.this).ab(0, j.f(j.this).getUrl(), str);
              AppMethodBeat.o(295380);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(295380);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
          label118:
          AppMethodBeat.o(295380);
        }
      });
    }
    AppMethodBeat.o(295534);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public String _getDgtVerifyRandomStr()
  {
    AppMethodBeat.i(295546);
    if ((aa.iOL()) && (!this.WDJ))
    {
      AppMethodBeat.o(295546);
      return "";
    }
    String str = this.KQY;
    AppMethodBeat.o(295546);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _getHtmlContent(final String paramString)
  {
    AppMethodBeat.i(295539);
    if (paramString != null) {
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295381);
          String str = j.a(j.this, "html");
          if (j.on(str, paramString))
          {
            if ((j.n(j.this) == null) || (j.f(j.this) == null)) {
              break label108;
            }
            try
            {
              j.n(j.this).ab(1, j.f(j.this).getUrl(), str);
              AppMethodBeat.o(295381);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
              AppMethodBeat.o(295381);
              return;
            }
          }
          Log.e("MicroMsg.JsApiHandler", "failed to write Html file");
          label108:
          AppMethodBeat.o(295381);
        }
      });
    }
    AppMethodBeat.o(295539);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public boolean _isDgtVerifyEnabled()
  {
    return this.WDI;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _ready(boolean paramBoolean)
  {
    this.UcS = paramBoolean;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void _sendMessage(String paramString)
  {
    AppMethodBeat.i(295527);
    if (bjI(paramString))
    {
      Log.d("MicroMsg.JsApiHandler", "_sendMessage pendingJsApi");
      AppMethodBeat.o(295527);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "_sendMessage");
    if (this.WDE != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      this.WDE.sendMessage(localMessage);
      AppMethodBeat.o(295527);
      return;
    }
    Log.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
    AppMethodBeat.o(295527);
  }
  
  public final void a(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(295738);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
      AppMethodBeat.o(295738);
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
        AppMethodBeat.i(295169);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295169);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295169);
        }
      }
    });
    AppMethodBeat.o(295738);
  }
  
  public final void a(p paramp, c paramc)
  {
    AppMethodBeat.i(295584);
    a(paramp, this.WDT, this.WDU, paramc);
    AppMethodBeat.o(295584);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle)
  {
    this.WDT = paramJsapiPermissionWrapper;
    this.WDU = paramBundle;
    this.WDV = true;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(295666);
        if (this.WEe.stopped()) {
          this.WEe.startTimer(1000L);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((paramDouble1 > 0.0D) && (paramDouble1 < 0.5D)) {
          try
          {
            if (!this.WEd.contains(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2)))
            {
              this.WEd.add(String.valueOf(paramString) + String.valueOf(paramInt1) + String.valueOf(paramInt2));
              localJSONObject.put("uuid", String.valueOf(paramString));
              localJSONObject.put("major", String.valueOf(paramInt1));
              localJSONObject.put("minor", String.valueOf(paramInt2));
              localJSONObject.put("accuracy", String.valueOf(paramDouble1));
              localJSONObject.put("rssi", String.valueOf(paramDouble2));
              localJSONObject.put("heading", String.valueOf(paramFloat));
              localJSONObject.put("proximity", String.valueOf(i));
              this.WEc.put(localJSONObject);
              this.WEb.put("beacons", this.WEc);
              this.WEb.put("err_msg", "onBeaconsInRange:ok");
            }
            p.a.a("onBeaconsInRange", this.WEb, this.WDI, this.KQY);
            AppMethodBeat.o(295666);
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
  
  public final void a(String paramString, long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(295627);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(295627);
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
        AppMethodBeat.i(295335);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295335);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295335);
        }
      }
    });
    AppMethodBeat.o(295627);
  }
  
  public final void a(final String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper, Bundle paramBundle, c paramc)
  {
    AppMethodBeat.i(295588);
    paramString = (p)p.a.n("[" + paramString + "]", false, this.KQY).remove(0);
    if ((paramString != null) && (itB()) && (this.WDE != null))
    {
      paramString.WDU = paramBundle;
      paramString.WlV = paramJsapiPermissionWrapper;
      paramString.WlW = paramc;
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295320);
          j.a(j.this, paramString);
          AppMethodBeat.o(295320);
        }
      });
      AppMethodBeat.o(295588);
      return;
    }
    a(paramString, paramJsapiPermissionWrapper, paramBundle, paramc);
    AppMethodBeat.o(295588);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(295731);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
      AppMethodBeat.o(295731);
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
        AppMethodBeat.i(295162);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295162);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295162);
        }
      }
    });
    AppMethodBeat.o(295731);
  }
  
  public final void a(String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(295670);
    if (!Util.isNullOrNil(paramString1)) {
      doCallback(paramString1, paramString2, paramMap);
    }
    if (paramBoolean) {
      ipd();
    }
    AppMethodBeat.o(295670);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(295702);
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString1);
    localHashMap.put("custom", paramString2);
    localHashMap.put("tagList", paramJSONArray);
    b("onSearchInputChange", localHashMap, null);
    AppMethodBeat.o(295702);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(295699);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
      AppMethodBeat.o(295699);
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
        AppMethodBeat.i(295156);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295156);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295156);
        }
      }
    });
    AppMethodBeat.o(295699);
  }
  
  public final void a(String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295714);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
      AppMethodBeat.o(295714);
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
          AppMethodBeat.i(295143);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
            AppMethodBeat.o(295143);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295143);
          }
        }
      });
      AppMethodBeat.o(295714);
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
  
  public final Bundle atC(int paramInt)
  {
    AppMethodBeat.i(295621);
    try
    {
      Object localObject = this.WDz;
      if (localObject == null)
      {
        AppMethodBeat.o(295621);
        return null;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("WebViewShare_type", paramInt);
      ((Bundle)localObject).putInt("WebViewShare_BinderID", this.WDK);
      ((Bundle)localObject).putString("WebViewShare_wv_url", this.WDz.getUrl());
      if (this.GXZ != null) {
        ((Bundle)localObject).putString("WebViewShare_commit_url", this.GXZ.Wwz);
      }
      localObject = this.sLC.m(105, (Bundle)localObject);
      ((Bundle)localObject).putBoolean("use_update_jsapi_data", true);
      AppMethodBeat.o(295621);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.JsApiHandler", "getShareData err %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(295621);
    }
    return null;
  }
  
  public final void b(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(295606);
    if (!this.UcS)
    {
      AppMethodBeat.o(295606);
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
      paramString1 = p.a.b("onMPPageAction", localHashMap, this.WDI, this.KQY);
      this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
      AppMethodBeat.o(295606);
      return;
      localHashMap.put("replyId", Integer.valueOf(paramInt2));
      localHashMap.put("openid", paramString2);
    }
  }
  
  public final void b(final String paramString, final Map<String, Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(295707);
    if ((!this.UcS) || ((paramMap == null) && (paramJSONObject == null)))
    {
      Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[] { paramString });
      AppMethodBeat.o(295707);
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
    for (paramMap = p.a.b(paramString, paramMap, this.WDI, this.KQY);; paramMap = p.a.a(paramString, paramJSONObject, this.WDI, this.KQY))
    {
      paramString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295136);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(295136);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { paramString, localException.getMessage() });
            AppMethodBeat.o(295136);
          }
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label173;
      }
      paramString.run();
      AppMethodBeat.o(295707);
      return;
      str1 = paramMap.toString();
      break;
      str2 = paramJSONObject.toString();
      break label63;
    }
    label173:
    MMHandlerThread.postToMainThread(paramString);
    AppMethodBeat.o(295707);
  }
  
  public final void bB(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(295630);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onWindowFocusChanged fail, not ready %b", new Object[] { Boolean.valueOf(paramBoolean1) });
      AppMethodBeat.o(295630);
      return;
    }
    if (this.WDz == null)
    {
      AppMethodBeat.o(295630);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
    if ((!paramBoolean2) && (localObject != null) && (!((com.tencent.mm.plugin.brandservice.api.c)localObject).isMpUrl(this.WDz.getUrl())))
    {
      AppMethodBeat.o(295630);
      return;
    }
    Log.d("MicroMsg.JsApiHandler", "onWindowFocusChanged, hasFocus = ".concat(String.valueOf(paramBoolean1)));
    localObject = new HashMap();
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      ((Map)localObject).put("hasFocus", Integer.valueOf(i));
      localObject = p.a.b("onWindowFocusChanged", (Map)localObject, this.WDI, this.KQY);
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295229);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
            AppMethodBeat.o(295229);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295229);
          }
        }
      });
      AppMethodBeat.o(295630);
      return;
    }
  }
  
  public final void biN(String paramString)
  {
    AppMethodBeat.i(295718);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
      AppMethodBeat.o(295718);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295157);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295157);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295157);
        }
      }
    });
    AppMethodBeat.o(295718);
  }
  
  public final String bjJ(String paramString)
  {
    AppMethodBeat.i(295594);
    Context localContext = getContext();
    if ((localContext instanceof d))
    {
      paramString = ((d)localContext).bjg(paramString);
      AppMethodBeat.o(295594);
      return paramString;
    }
    AppMethodBeat.o(295594);
    return "";
  }
  
  public final void bjK(final String paramString)
  {
    AppMethodBeat.i(295645);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
      AppMethodBeat.o(295645);
      return;
    }
    if (this.WDE != null) {
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295314);
          p localp = new p();
          localp.params = new HashMap();
          localp.params.put("username", paramString);
          localp.WEI = new JSONObject();
          localp.type = "call";
          localp.WEH = "";
          localp.function = "profile";
          j.d(j.this).add(localp);
          j.e(j.this);
          AppMethodBeat.o(295314);
        }
      });
    }
    AppMethodBeat.o(295645);
  }
  
  public final void bjL(String paramString)
  {
    AppMethodBeat.i(295659);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295659);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_msg", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295204);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295204);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295204);
        }
      }
    });
    AppMethodBeat.o(295659);
  }
  
  public final void bjN(String paramString)
  {
    AppMethodBeat.i(295769);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295769);
      return;
    }
    if (!aa.brX(getCurrentUrl()))
    {
      AppMethodBeat.o(295769);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onMenuClick");
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    paramString = p.a.b("onMenuClick", localHashMap, this.WDI, this.KQY);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ")", null);
    AppMethodBeat.o(295769);
  }
  
  public final void bjO(String paramString)
  {
    AppMethodBeat.i(295779);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295779);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(295779);
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
    if (this.sLC != null) {}
    for (;;)
    {
      try
      {
        i = this.sLC.m(110, new Bundle()).getInt("sim_card_type", 0);
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
          AppMethodBeat.i(295322);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
            AppMethodBeat.o(295322);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295322);
          }
        }
      });
      AppMethodBeat.o(295779);
      return;
      if (i == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final boolean bjo(final String paramString)
  {
    AppMethodBeat.i(295555);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback() {});
    AppMethodBeat.o(295555);
    return true;
  }
  
  public final boolean bjq(String paramString)
  {
    AppMethodBeat.i(295553);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(295553);
      return false;
    }
    boolean bool = aa.M(paramString, "weixin://dispatch_message/");
    AppMethodBeat.o(295553);
    return bool;
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(295688);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
      AppMethodBeat.o(295688);
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
        AppMethodBeat.i(295149);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295149);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295149);
        }
      }
    });
    AppMethodBeat.o(295688);
  }
  
  public final void c(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(295615);
    Log.i("MicroMsg.JsApiHandler", "onSendToFriend %b", new Object[] { Boolean.valueOf(this.UcS) });
    if (paramInt == 2) {}
    try
    {
      this.sLC.aI("scene", "recentFriend", this.WDK);
      this.sLC.aI("sourUserName", (String)paramHashMap.get("sourUserName"), this.WDK);
      while (!this.UcS)
      {
        Log.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
        i(cf(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(295615);
        return;
        this.sLC.aI("scene", "friend", this.WDK);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + localException.getMessage());
      }
      paramHashMap = atC(1);
      if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false)))
      {
        i(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(295615);
        return;
      }
      paramHashMap = new HashMap();
      paramHashMap.put("scene", "friend");
      paramHashMap.put("shareScene", Integer.valueOf(paramInt));
      paramHashMap = p.a.b("menu:share:appmessage", paramHashMap, this.WDI, this.KQY);
      this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
      AppMethodBeat.o(295615);
    }
  }
  
  public final Bundle cf(Map<String, String> paramMap)
  {
    AppMethodBeat.i(295623);
    Bundle localBundle = new Bundle();
    String str1 = this.WDz.getUrl();
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
        localObject = this.WDz.getTitle();
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
          AppMethodBeat.o(295623);
          return localBundle;
          localObject = this.WDz.getTitle();
          localBundle.putString("link", str1);
          localBundle.putString("desc", str1);
          localBundle.putString("img_url", "");
          break;
          paramMap = MMApplicationContext.getContext().getString(a.e.webview_jssdk_link);
          continue;
          paramMap = (Map<String, String>)localObject;
        }
      }
    }
  }
  
  public final void cg(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295631);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
      AppMethodBeat.o(295631);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295222);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295222);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295222);
        }
      }
    });
    AppMethodBeat.o(295631);
  }
  
  public final void ch(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295632);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
      AppMethodBeat.o(295632);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
    paramMap = p.a.b("onVoiceRecordEnd", paramMap, this.WDI, this.KQY);
    Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[] { paramMap });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295269);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
          AppMethodBeat.o(295269);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295269);
        }
      }
    });
    AppMethodBeat.o(295632);
  }
  
  public final void ci(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295680);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
      AppMethodBeat.o(295680);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295182);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295182);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295182);
        }
      }
    });
    AppMethodBeat.o(295680);
  }
  
  public final void d(HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(295617);
    Log.i("MicroMsg.JsApiHandler", "onFavorite %b", new Object[] { Boolean.valueOf(this.UcS) });
    if (!this.UcS) {
      try
      {
        this.sLC.aI("scene", "favorite", this.WDK);
        i(cf(paramHashMap), "sendAppMessage");
        AppMethodBeat.o(295617);
        return;
      }
      catch (Exception paramHashMap)
      {
        Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
        AppMethodBeat.o(295617);
        return;
      }
    }
    paramHashMap = atC(1);
    if ((paramHashMap != null) && (paramHashMap.getBoolean("WebViewShare_reslut", false))) {
      try
      {
        this.sLC.aI("scene", "favorite", this.WDK);
        i(paramHashMap, "sendAppMessage");
        AppMethodBeat.o(295617);
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
    paramHashMap = p.a.b("menu:share:appmessage", paramHashMap, this.WDI, this.KQY);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramHashMap + ")", null);
    try
    {
      this.sLC.aI("scene", "favorite", this.WDK);
      AppMethodBeat.o(295617);
      return;
    }
    catch (Exception paramHashMap)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramHashMap.getMessage());
      AppMethodBeat.o(295617);
    }
  }
  
  public final void dG(int paramInt, String paramString)
  {
    AppMethodBeat.i(295726);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
      AppMethodBeat.o(295726);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("data", paramString);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295159);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295159);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295159);
        }
      }
    });
    AppMethodBeat.o(295726);
  }
  
  public final void dG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(295517);
    try
    {
      this.sLC.n(paramString, paramBoolean, this.WDK);
      AppMethodBeat.o(295517);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(295517);
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(295597);
    itK();
    this.UcS = false;
    this.PmC.clear();
    this.WDD.clear();
    this.WDE = null;
    AppMethodBeat.o(295597);
  }
  
  public void doCallback(String paramString1, String paramString2, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295679);
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null))
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(295679);
      return;
    }
    if (this.mnT.containsKey(paramString1))
    {
      localObject = (c)this.mnT.get(paramString1);
      if (localObject != null)
      {
        ((c)localObject).doCallback(paramString1, paramString2, paramMap);
        this.mnT.remove(paramString1);
      }
      AppMethodBeat.o(295679);
      return;
    }
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
      AppMethodBeat.o(295679);
      return;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("err_msg", paramString2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Log.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + paramMap.size());
      ((Map)localObject).putAll(paramMap);
    }
    paramMap = p.a.a(paramString1, (Map)localObject, this.WDI, this.KQY);
    Log.i("MicroMsg.JsApiHandler", "doCallback, ret = " + paramString2 + ", cb = " + paramMap);
    if ((paramMap != null) && (this.WDz != null))
    {
      paramMap = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295194);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramMap + ")", null);
            AppMethodBeat.o(295194);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295194);
          }
        }
      };
      if (!MMHandlerThread.isMainThread()) {
        break label286;
      }
      paramMap.run();
    }
    for (;;)
    {
      oj(paramString1, paramString2);
      AppMethodBeat.o(295679);
      return;
      label286:
      MMHandlerThread.postToMainThread(paramMap);
    }
  }
  
  public final void fR(Context paramContext)
  {
    this.WDC = paramContext;
  }
  
  public final int getBinderID()
  {
    return this.WDK;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(295590);
    if (this.WDV)
    {
      if (this.WDC != null)
      {
        localContext = this.WDC;
        AppMethodBeat.o(295590);
        return localContext;
      }
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(295590);
      return localContext;
    }
    if (this.WDz == null)
    {
      AppMethodBeat.o(295590);
      return null;
    }
    Context localContext = this.WDz.getActivityContextIfHas();
    AppMethodBeat.o(295590);
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(295805);
    if (this.WDz == null)
    {
      AppMethodBeat.o(295805);
      return "";
    }
    String str = this.WDz.getUrl();
    AppMethodBeat.o(295805);
    return str;
  }
  
  public final void hR(String paramString, int paramInt)
  {
    AppMethodBeat.i(295628);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
      AppMethodBeat.o(295628);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
      AppMethodBeat.o(295628);
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
          AppMethodBeat.i(295343);
          try
          {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
            AppMethodBeat.o(295343);
            return;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(295343);
          }
        }
      });
      AppMethodBeat.o(295628);
      return;
      if (paramInt == 1) {
        localHashMap.put("state", "connecting");
      } else {
        localHashMap.put("state", "disconnected");
      }
    }
  }
  
  public final void hS(String paramString, int paramInt)
  {
    AppMethodBeat.i(295634);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
      AppMethodBeat.o(295634);
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
        AppMethodBeat.i(295266);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295266);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295266);
        }
      }
    });
    AppMethodBeat.o(295634);
  }
  
  public final void hT(String paramString, int paramInt)
  {
    AppMethodBeat.i(295635);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
      AppMethodBeat.o(295635);
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
        AppMethodBeat.i(295293);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295293);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295293);
        }
      }
    });
    AppMethodBeat.o(295635);
  }
  
  public final void hU(String paramString, int paramInt)
  {
    AppMethodBeat.i(295638);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
      AppMethodBeat.o(295638);
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
        AppMethodBeat.i(295299);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295299);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295299);
        }
      }
    });
    AppMethodBeat.o(295638);
  }
  
  public final void hV(String paramString, int paramInt)
  {
    AppMethodBeat.i(295642);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
      AppMethodBeat.o(295642);
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
        AppMethodBeat.i(295262);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295262);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295262);
        }
      }
    });
    AppMethodBeat.o(295642);
  }
  
  public final void hW(String paramString, int paramInt)
  {
    AppMethodBeat.i(295643);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
      AppMethodBeat.o(295643);
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
        AppMethodBeat.i(295316);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295316);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295316);
        }
      }
    });
    AppMethodBeat.o(295643);
  }
  
  public final void hY(String paramString, int paramInt)
  {
    AppMethodBeat.i(295744);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
      AppMethodBeat.o(295744);
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
        AppMethodBeat.i(295160);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295160);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295160);
        }
      }
    });
    AppMethodBeat.o(295744);
  }
  
  public final void i(final Bundle paramBundle, final String paramString)
  {
    AppMethodBeat.i(295625);
    if (paramBundle == null)
    {
      Log.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
      AppMethodBeat.o(295625);
      return;
    }
    if (this.WDE != null) {
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295347);
          p localp = new p();
          localp.params = new HashMap();
          localp.params.put("link", paramBundle.getString("link"));
          localp.params.put("title", paramBundle.getString("title"));
          localp.params.put("desc", paramBundle.getString("desc"));
          localp.WEI = new JSONObject();
          localp.params.put("img_url", paramBundle.getString("img_url"));
          localp.params.put("use_update_jsapi_data", Boolean.valueOf(paramBundle.getBoolean("use_update_jsapi_data")));
          localp.type = "call";
          localp.WEH = "";
          localp.function = paramString;
          j.d(j.this).add(localp);
          j.e(j.this);
          AppMethodBeat.o(295347);
        }
      });
    }
    AppMethodBeat.o(295625);
  }
  
  public final void iF(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(295629);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", new Object[] { paramString1 });
      AppMethodBeat.o(295629);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state %s, extData %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", paramString1);
    localHashMap.put("extData", paramString2);
    paramString1 = p.a.b("activity:state_change", localHashMap, this.WDI, this.KQY);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      try
      {
        this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
        AppMethodBeat.o(295629);
        return;
      }
      catch (Exception paramString1)
      {
        Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(295629);
        return;
      }
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295221);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
          AppMethodBeat.o(295221);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295221);
        }
      }
    });
    AppMethodBeat.o(295629);
  }
  
  public final void init()
  {
    AppMethodBeat.i(295558);
    Log.v("MicroMsg.JsApiHandler", "jsapi init");
    if (this.WDz == null)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
      AppMethodBeat.o(295558);
      return;
    }
    ity();
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:init", null, this.WDI, this.KQY) + ")", new ValueCallback() {});
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:bridged", null, this.WDI, this.KQY) + ")", new ValueCallback() {});
    Iy(true);
    itz();
    if ((!Util.isNullOrNil(this.WDZ)) && (this.WDz != null))
    {
      this.WDz.evaluateJavascript(hX(this.WDZ, this.WEa), null);
      this.WDZ = null;
      this.WEa = 0;
    }
    AppMethodBeat.o(295558);
  }
  
  public final void ioZ()
  {
    AppMethodBeat.i(295676);
    if (this.PmC != null) {
      this.PmC.clear();
    }
    AppMethodBeat.o(295676);
  }
  
  public final void ipd()
  {
    AppMethodBeat.i(295674);
    if (this.WDE != null) {
      this.WDE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295192);
          j.e(j.this);
          AppMethodBeat.o(295192);
        }
      });
    }
    AppMethodBeat.o(295674);
  }
  
  public final void itE()
  {
    AppMethodBeat.i(295653);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295653);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("userHasGoBack", Boolean.TRUE);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295302);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295302);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onUserGoBack fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295302);
        }
      }
    });
    AppMethodBeat.o(295653);
  }
  
  public final boolean itF()
  {
    AppMethodBeat.i(295685);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, not ready");
      AppMethodBeat.o(295685);
      return false;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden success, ready");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295212);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295212);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295212);
        }
      }
    });
    AppMethodBeat.o(295685);
    return true;
  }
  
  public final void itG()
  {
    AppMethodBeat.i(295773);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
      AppMethodBeat.o(295773);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("needShow", Boolean.TRUE);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295327);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295327);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295327);
        }
      }
    });
    AppMethodBeat.o(295773);
  }
  
  public final void itH()
  {
    AppMethodBeat.i(295780);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
      AppMethodBeat.o(295780);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
    String str = p.a.b("onNavigationBarRightButtonClick", new HashMap(), this.WDI, this.KQY);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
    AppMethodBeat.o(295780);
  }
  
  public final long itI()
  {
    AppMethodBeat.i(295793);
    Log.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[] { Long.valueOf(this.WEf) });
    long l = this.WEf;
    AppMethodBeat.o(295793);
    return l;
  }
  
  public final com.tencent.mm.plugin.webview.l.j itJ()
  {
    AppMethodBeat.i(295798);
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      Log.e("MicroMsg.JsApiHandler", "AppBrand Expansion is not Installed, WebCompt return null");
      AppMethodBeat.o(295798);
      return null;
    }
    if (this.WEg == null) {
      this.WEg = new com.tencent.mm.plugin.webview.l.j(this);
    }
    com.tencent.mm.plugin.webview.l.j localj = this.WEg;
    AppMethodBeat.o(295798);
    return localj;
  }
  
  public final void itK()
  {
    AppMethodBeat.i(295802);
    if (!this.UcS)
    {
      AppMethodBeat.o(295802);
      return;
    }
    if (this.WEg != null) {
      this.WEg.clear();
    }
    if (this.sLC != null) {
      try
      {
        this.sLC.aue(this.WDK);
        AppMethodBeat.o(295802);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", localException, "clearSession", new Object[0]);
      }
    }
    AppMethodBeat.o(295802);
  }
  
  public final g itt()
  {
    return this.Wwh;
  }
  
  public final void itv()
  {
    AppMethodBeat.i(295512);
    if (this.WDI != true)
    {
      this.WDI = true;
      if (!com.tencent.matrix.trace.f.c.hm(this.WDz.getRandomStr())) {
        break label80;
      }
    }
    label80:
    for (String str = Util.getRandomString(16);; str = this.WDz.getRandomStr())
    {
      this.KQY = str;
      Log.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", new Object[] { this.KQY, Integer.valueOf(hashCode()) });
      AppMethodBeat.o(295512);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.b.a itx()
  {
    AppMethodBeat.i(295549);
    if (this.WDR == null) {
      this.WDR = new com.tencent.mm.plugin.webview.jsapi.b.a();
    }
    this.WDR.WDl = this.WDz;
    com.tencent.mm.plugin.webview.jsapi.b.a locala = this.WDR;
    AppMethodBeat.o(295549);
    return locala;
  }
  
  public final void ity()
  {
    AppMethodBeat.i(295566);
    Log.i("MicroMsg.JsApiHandler", "alvinluo updateRandomStr");
    if ((this.WDI) && (aa.iOL()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("__event_id", "sys:updateRandomStr");
        localJSONObject2.put("randomStr", this.KQY);
        localJSONObject1.put("__json_message", localJSONObject2);
        this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + localJSONObject1.toString() + ")", new ValueCallback() {});
        AppMethodBeat.o(295566);
        return;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(295566);
  }
  
  public final void itz()
  {
    AppMethodBeat.i(295578);
    Log.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[] { Boolean.valueOf(this.UcS) });
    if ((this.WDz != null) && (this.UcS)) {
      this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:attach_runOn3rd_apis", itA(), this.WDI, this.KQY) + ")", new ValueCallback() {});
    }
    AppMethodBeat.o(295578);
  }
  
  public final void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(295626);
    if ((!this.UcS) || (paramBundle == null))
    {
      Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
      AppMethodBeat.o(295626);
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
        AppMethodBeat.i(295344);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295344);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295344);
        }
      }
    });
    AppMethodBeat.o(295626);
  }
  
  public final void k(int paramInt, String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    AppMethodBeat.i(295742);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "%s fail, not ready", new Object[] { paramString4 });
      AppMethodBeat.o(295742);
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
        AppMethodBeat.i(295164);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295164);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", new Object[] { paramString4, localException.getMessage() });
          AppMethodBeat.o(295164);
        }
      }
    });
    AppMethodBeat.o(295742);
  }
  
  public final void m(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(295683);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
      AppMethodBeat.o(295683);
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
        AppMethodBeat.i(295207);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295207);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295207);
        }
      }
    });
    AppMethodBeat.o(295683);
  }
  
  public final void n(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(295787);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295787);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295378);
        try
        {
          if (j.f(j.this) != null) {
            j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.WEo + ")", null);
          }
          AppMethodBeat.o(295378);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
          AppMethodBeat.o(295378);
        }
      }
    });
    AppMethodBeat.o(295787);
  }
  
  public final void nh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295648);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "not ready");
      AppMethodBeat.o(295648);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(Math.round(paramInt1 / this.WDz.getMMDensity())));
    if (paramInt2 != 0) {
      localHashMap.put("inputHeight", Integer.valueOf(Math.round(paramInt2 / this.WDz.getMMDensity())));
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295305);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", null);
          AppMethodBeat.o(295305);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295305);
        }
      }
    });
    AppMethodBeat.o(295648);
  }
  
  public final void ok(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295612);
    if (!this.UcS)
    {
      AppMethodBeat.o(295612);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoVid", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("action", "onEmbedMpVideoShare");
    paramString1 = p.a.b("onMPPageAction", localHashMap, this.WDI, this.KQY);
    this.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString1 + ")", null);
    AppMethodBeat.o(295612);
  }
  
  public final void ol(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295693);
    if (!this.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
      AppMethodBeat.o(295693);
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
        AppMethodBeat.i(295155);
        try
        {
          j.f(j.this).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ejD + ")", new ValueCallback() {});
          AppMethodBeat.o(295155);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(295155);
        }
      }
    });
    AppMethodBeat.o(295693);
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(295752);
    this.isActive = paramBoolean;
    if (this.isActive)
    {
      crU();
      AppMethodBeat.o(295752);
      return;
    }
    this.WDF = System.currentTimeMillis();
    AppMethodBeat.o(295752);
  }
  
  public static abstract interface a
  {
    public abstract boolean handleMsg(p paramp, JsapiPermissionWrapper paramJsapiPermissionWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.j
 * JD-Core Version:    0.7.0.1
 */