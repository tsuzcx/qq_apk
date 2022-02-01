package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.wallet.wecoin.b.m;
import com.tencent.mm.plugin.wallet.wecoin.utils.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.gij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "", "()V", "isMidasAlreadyInit", "", "mPrepareCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "sdkInfo", "Lcom/tencent/mm/protocal/protobuf/MidasSdkInfo;", "cancelPrepareRecharge", "", "handleInterceptWinInfo", "activity", "Landroid/app/Activity;", "interceptInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "productInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "uniqueId", "", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "initMidasSDK", "Landroid/content/Context;", "initSDK", "prepareWecoinRecharge", "context", "info", "rechargeByMidasSDK", "response", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "env", "reportCgiKVStatus", "scene", "", "sceneSessionID", "uniqueID", "operationType", "stepID", "errorCode", "errorMsg", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "Companion", "MidasPayCommonCallBackImpl", "SingletonHolder", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a Vvd;
  private static final l Vvg;
  private m Vut;
  private dop Vve;
  private boolean Vvf;
  private w lKp;
  
  static
  {
    AppMethodBeat.i(315889);
    Vvd = new l.a((byte)0);
    c localc = c.Vvj;
    Vvg = c.ihu();
    AppMethodBeat.o(315889);
  }
  
  private static final ah a(com.tencent.mm.plugin.wallet.wecoin.a.i parami, l paraml, Context paramContext, b.a parama)
  {
    AppMethodBeat.i(315838);
    s.u(paraml, "this$0");
    s.u(paramContext, "$activity");
    Log.i("MicroMsg.WeCoinMidasInitializer", "CgiGetMidasSdkInfoRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      if (parami != null) {
        parami.s(parama.errType, parama.errCode, parama.errMsg);
      }
      parami = ah.aiuX;
      AppMethodBeat.o(315838);
      return parami;
    }
    if (parama.ott == null)
    {
      if (parami != null) {
        parami.s(3, -2, "");
      }
      parami = ah.aiuX;
      AppMethodBeat.o(315838);
      return parami;
    }
    Object localObject = (cnj)parama.ott;
    if (localObject != null)
    {
      localObject = ((cnj)localObject).aauM;
      if (localObject != null)
      {
        parama = parama.ott;
        s.s(parama, "cgiBack.resp");
        c.d("MicroMsg.WeCoinMidasInitializer", (com.tencent.mm.bx.a)parama);
        paraml.Vve = ((dop)localObject);
        paraml.a(paramContext, (dop)localObject);
        if (parami != null) {
          parami.onSuccess(Boolean.TRUE);
        }
        parami = ah.aiuX;
        AppMethodBeat.o(315838);
        return parami;
      }
    }
    parami = ah.aiuX;
    AppMethodBeat.o(315838);
    return parami;
  }
  
  private static final ah a(final l paraml, final Activity paramActivity, final com.tencent.mm.plugin.wallet.wecoin.a.i parami, int paramInt, String paramString1, final String paramString2, egv paramegv, final com.tencent.mm.plugin.wallet.wecoin.a.h paramh, b.a parama)
  {
    AppMethodBeat.i(315857);
    s.u(paraml, "this$0");
    s.u(paramActivity, "$context");
    s.u(paramString1, "$sceneSessionID");
    s.u(paramString2, "$uniqueId");
    s.u(paramegv, "$request");
    s.u(paramh, "$info");
    Log.i("MicroMsg.WeCoinMidasInitializer", "prepareWecoinRecharge errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    paraml.Vut = null;
    paraml.e(paramActivity, false);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      if (parami != null) {
        parami.s(parama.errType, parama.errCode, parama.errMsg);
      }
      Object localObject1 = (egw)parama.ott;
      if (localObject1 != null)
      {
        localObject1 = ((egw)localObject1).ablX;
        if (localObject1 != null)
        {
          Object localObject2 = parama.ott;
          s.s(localObject2, "cgiBack.resp");
          c.d("MicroMsg.WeCoinMidasInitializer", (com.tencent.mm.bx.a)localObject2);
          localObject2 = new gij();
          ((gij)localObject2).MQZ = paramegv.request_id;
          paramegv = new d((egw)parama.ott, (gij)localObject2);
          Log.d("MicroMsg.WeCoinMidasInitializer", s.X("handleInterceptWinInfo: ", paramegv));
          localObject2 = paramegv.Vuk;
          if (localObject2 != null)
          {
            paramegv = paramegv.Vul;
            if (paramegv != null) {
              break label366;
            }
          }
          label366:
          for (paramegv = null;; paramegv = paramegv.MQZ)
          {
            paraml = new d(paramegv, paraml, paramActivity, (egw)localObject2, paramh, paramString2, parami);
            c.a((Context)paramActivity, ((egw)localObject2).ablX, (b)paraml);
            a(paramInt, paramString1, paramString2, 3, 3, parama.errCode, ((dcl)localObject1).wording);
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 27);
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
            paraml = ah.aiuX;
            AppMethodBeat.o(315857);
            return paraml;
          }
        }
      }
      a(paramActivity, new a(parama.errType, parama.errCode, parama.errMsg));
      a(paramInt, paramString1, paramString2, 3, 3, parama.errCode, parama.errMsg);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
      paraml = ah.aiuX;
      AppMethodBeat.o(315857);
      return paraml;
    }
    if (parama.ott == null)
    {
      Log.e("MicroMsg.WeCoinMidasInitializer", "cgiBack.resp is null");
      if (parami != null) {
        parami.s(3, -1, "");
      }
      a(paramActivity, new a(3, -1, ""));
      a(paramInt, paramString1, paramString2, 3, 3, 3, "callback resp is null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
      paraml = ah.aiuX;
      AppMethodBeat.o(315857);
      return paraml;
    }
    paraml = (egw)parama.ott;
    if (paraml != null)
    {
      Log.i("MicroMsg.WeCoinMidasInitializer", s.X("prepareWecoinRecharge, product_id: ", paramh.hBT));
      c.d("MicroMsg.WeCoinMidasInitializer", (com.tencent.mm.bx.a)paraml);
      a(paramInt, paramString1, paramString2, 3, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 21);
      a(paramActivity, paraml, "release", paramh, paramString2, parami);
    }
    paraml = ah.aiuX;
    AppMethodBeat.o(315857);
    return paraml;
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(315816);
    com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString3 });
    AppMethodBeat.o(315816);
  }
  
  private static void a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(315794);
    Log.d("MicroMsg.WeCoinMidasInitializer", s.X("showErrorMsg: ", parama));
    c.a((Context)paramActivity, parama);
    AppMethodBeat.o(315794);
  }
  
  private static final void a(Activity paramActivity, l paraml, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(315865);
    s.u(paramActivity, "$context");
    s.u(paraml, "this$0");
    if ((!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      Log.i("MicroMsg.WeCoinMidasInitializer", s.X("cancelPrepareRecharge, mPrepareCgi: ", paraml.Vut));
      paramDialogInterface = paraml.Vut;
      if (paramDialogInterface != null) {
        paramDialogInterface.cancel();
      }
      paramActivity.finish();
    }
    paramActivity = paraml.lKp;
    if ((paramActivity != null) && (paramActivity.isShowing()))
    {
      paramActivity.dismiss();
      paraml.lKp = null;
    }
    AppMethodBeat.o(315865);
  }
  
  private static void a(Activity paramActivity, egw paramegw, String paramString1, com.tencent.mm.plugin.wallet.wecoin.a.h paramh, String paramString2, com.tencent.mm.plugin.wallet.wecoin.a.i<Void> parami)
  {
    AppMethodBeat.i(315810);
    if (paramegw.aauM != null)
    {
      localObject = (CharSequence)paramegw.abmj;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.WeCoinMidasInitializer", "rechargeByMidasSDK param error.");
      AppMethodBeat.o(315810);
      return;
    }
    Object localObject = new APMidasGoodsRequest();
    ((APMidasGoodsRequest)localObject).offerId = paramegw.aauM.aaVy;
    ((APMidasGoodsRequest)localObject).openId = paramegw.aauM.aaVz;
    ((APMidasGoodsRequest)localObject).openKey = paramegw.aauM.aaVA;
    ((APMidasGoodsRequest)localObject).sessionId = paramegw.aauM.session_id;
    ((APMidasGoodsRequest)localObject).sessionType = paramegw.aauM.aaVB;
    ((APMidasGoodsRequest)localObject).pf = paramegw.aauM.pf;
    ((APMidasGoodsRequest)localObject).pfKey = paramegw.aauM.aaVC;
    ((APMidasGoodsRequest)localObject).zoneId = "1";
    ((APMidasGoodsRequest)localObject).goodsTokenUrl = paramegw.abmj;
    ((APMidasGoodsRequest)localObject).mpInfo.payChannel = "wechat";
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.setEnv(paramString1);
    ((APMidasGoodsRequest)localObject).tokenType = 1;
    ((APMidasGoodsRequest)localObject).prodcutId = paramh.hBT;
    ((APMidasGoodsRequest)localObject).saveValue = paramegw.abmk;
    i = c.asg(paramh.mScene);
    paramString1 = paramh.Vua;
    s.s(paramString1, "info.sceneSessionID");
    a(i, paramString1, paramString2, 4, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 23);
    APMidasPayAPI.launchPay(paramActivity, (APMidasBaseRequest)localObject, (IAPMidasPayCallBack)new b(paramegw.YzL, parami, paramh, paramString2));
    AppMethodBeat.o(315810);
  }
  
  private final void a(Context paramContext, dop paramdop)
  {
    AppMethodBeat.i(315780);
    Log.i("MicroMsg.WeCoinMidasInitializer", s.X("is midas sdk already initialized: ", Boolean.valueOf(this.Vvf)));
    if ((c.ihE()) && (this.Vvf))
    {
      AppMethodBeat.o(315780);
      return;
    }
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    localAPMidasGameRequest.offerId = paramdop.aaVy;
    localAPMidasGameRequest.openId = paramdop.aaVz;
    localAPMidasGameRequest.openKey = paramdop.aaVA;
    localAPMidasGameRequest.sessionId = paramdop.session_id;
    localAPMidasGameRequest.sessionType = paramdop.aaVB;
    localAPMidasGameRequest.pf = paramdop.pf;
    localAPMidasGameRequest.pfKey = paramdop.aaVC;
    localAPMidasGameRequest.reserv = "enableX5=0";
    APMidasPayAPI.setEnv("release");
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.setLogCallback(MidasPayLogCallbackImpl.class);
    APMidasPayAPI.init(paramContext, (APMidasBaseRequest)localAPMidasGameRequest);
    this.Vvf = true;
    AppMethodBeat.o(315780);
  }
  
  private static final void c(com.tencent.mm.plugin.wallet.wecoin.a.i parami)
  {
    AppMethodBeat.i(315822);
    if (parami != null) {
      parami.onSuccess(Boolean.TRUE);
    }
    AppMethodBeat.o(315822);
  }
  
  private final void e(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(315788);
    Log.d("MicroMsg.WeCoinMidasInitializer", s.X("showProgressDialog: ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (paramActivity = w.a((Context)paramActivity, (CharSequence)paramActivity.getString(a.i.loading_tips), true, 3, new l..ExternalSyntheticLambda0(paramActivity, this));; paramActivity = null)
    {
      this.lKp = paramActivity;
      AppMethodBeat.o(315788);
      return;
      paramActivity = this.lKp;
      if (paramActivity != null) {
        paramActivity.dismiss();
      }
    }
  }
  
  public final void a(Activity paramActivity, com.tencent.mm.plugin.wallet.wecoin.a.h paramh, com.tencent.mm.plugin.wallet.wecoin.a.i<Void> parami)
  {
    AppMethodBeat.i(315939);
    s.u(paramActivity, "context");
    s.u(paramh, "info");
    String str = c.ihq();
    Object localObject2 = paramh.Vua;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = str;
    }
    e(paramActivity, true);
    int i = c.asg(paramh.mScene);
    a(i, (String)localObject1, str, 3, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 20);
    localObject2 = new egv();
    ((egv)localObject2).request_id = str;
    ((egv)localObject2).abmh = paramh.hBT;
    ((egv)localObject2).aaBJ = paramh.Vuc;
    ((egv)localObject2).scene = paramh.mScene;
    ((egv)localObject2).ZoT = ((String)localObject1);
    ((egv)localObject2).abmi = paramh.Vue;
    this.Vut = new m((egv)localObject2);
    Object localObject3 = this.Vut;
    if (localObject3 != null)
    {
      localObject3 = ((m)localObject3).bFJ();
      if (localObject3 != null) {
        ((com.tencent.mm.cp.f)localObject3).b(new l..ExternalSyntheticLambda2(this, paramActivity, parami, i, (String)localObject1, str, (egv)localObject2, paramh));
      }
    }
    AppMethodBeat.o(315939);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.wallet.wecoin.a.i<Boolean> parami)
  {
    AppMethodBeat.i(315925);
    s.u(paramContext, "activity");
    Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK.");
    dop localdop = this.Vve;
    if (localdop != null)
    {
      Log.i("MicroMsg.WeCoinMidasInitializer", "initSDK already initialized.");
      a(paramContext, localdop);
      com.tencent.threadpool.h.ahAA.bk(new l..ExternalSyntheticLambda3(parami));
      AppMethodBeat.o(315925);
      return;
    }
    parami = new com.tencent.mm.plugin.wallet.wecoin.b.f().bFJ().b(new l..ExternalSyntheticLambda1(parami, this, paramContext));
    if ((paramContext instanceof MMActivity)) {
      parami.a((com.tencent.mm.vending.e.b)paramContext);
    }
    AppMethodBeat.o(315925);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$MidasPayCommonCallBackImpl;", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "billNo", "", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "uniqueID", "(Ljava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;Ljava/lang/String;)V", "MidasPayCallBack", "", "response", "Lcom/tencent/midas/api/APMidasResponse;", "MidasPayNeedLogin", "cancelWecoinRechargeRequest", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements IAPMidasPayCallBack
  {
    private final com.tencent.mm.plugin.wallet.wecoin.a.i<Void> VtR;
    private final com.tencent.mm.plugin.wallet.wecoin.a.h Vvh;
    private final String Vvi;
    private final String ihu;
    
    public b(String paramString1, com.tencent.mm.plugin.wallet.wecoin.a.i<Void> parami, com.tencent.mm.plugin.wallet.wecoin.a.h paramh, String paramString2)
    {
      AppMethodBeat.i(315767);
      this.ihu = paramString1;
      this.VtR = parami;
      this.Vvh = paramh;
      this.Vvi = paramString2;
      AppMethodBeat.o(315767);
    }
    
    private static final ah a(b paramb, b.a parama)
    {
      AppMethodBeat.i(315786);
      s.u(paramb, "this$0");
      paramb.h(5, 3, parama.errCode, parama.errMsg);
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        paramb = ah.aiuX;
        AppMethodBeat.o(315786);
        return paramb;
      }
      Log.i("MicroMsg.WeCoinMidasInitializer", "cancelWecoinRechargeRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
      paramb = ah.aiuX;
      AppMethodBeat.o(315786);
      return paramb;
    }
    
    private final void h(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(315776);
      com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(c.asg(this.Vvh.mScene)), this.Vvh.Vua, this.Vvi, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(315776);
    }
    
    public final void MidasPayCallBack(APMidasResponse paramAPMidasResponse)
    {
      AppMethodBeat.i(315829);
      Object localObject;
      if (paramAPMidasResponse != null)
      {
        Log.i("MicroMsg.WeCoinMidasInitializer", "MidasPayCallBack: resultCode: " + paramAPMidasResponse.resultCode + ", resultMsg: " + paramAPMidasResponse.resultMsg + ", realSaveNum: " + paramAPMidasResponse.realSaveNum + ", payChannel: " + paramAPMidasResponse.payChannel + ", payState: " + paramAPMidasResponse.payState + ",provideState: " + paramAPMidasResponse.provideState);
        switch (paramAPMidasResponse.resultCode)
        {
        case 1: 
        default: 
          localObject = this.VtR;
          if (localObject != null) {
            ((com.tencent.mm.plugin.wallet.wecoin.a.i)localObject).s(3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          }
          h(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 25);
        }
      }
      do
      {
        AppMethodBeat.o(315829);
        return;
        h(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 26);
        localObject = this.ihu;
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            h(5, 1, 0, "");
            new com.tencent.mm.plugin.wallet.wecoin.b.a((String)localObject).bFJ().h(new l.b..ExternalSyntheticLambda0(this));
          }
          localObject = this.VtR;
          if (localObject == null) {
            break;
          }
          ((com.tencent.mm.plugin.wallet.wecoin.a.i)localObject).s(3, -3, paramAPMidasResponse.resultMsg);
          AppMethodBeat.o(315829);
          return;
        }
        h(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 24);
        paramAPMidasResponse = this.VtR;
      } while (paramAPMidasResponse == null);
      paramAPMidasResponse.onSuccess(null);
      AppMethodBeat.o(315829);
    }
    
    public final void MidasPayNeedLogin()
    {
      AppMethodBeat.i(315805);
      Log.i("MicroMsg.WeCoinMidasInitializer", "Midas pay need login:");
      AppMethodBeat.o(315805);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "getHolder", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    public static final c Vvj;
    private static final l Vvk;
    
    static
    {
      AppMethodBeat.i(315765);
      Vvj = new c();
      Vvk = new l((byte)0);
      AppMethodBeat.o(315765);
    }
    
    public static l ihu()
    {
      return Vvk;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/model/WeCoinMidasInitializer$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b
  {
    d(String paramString1, l paraml, Activity paramActivity, egw paramegw, com.tencent.mm.plugin.wallet.wecoin.a.h paramh, String paramString2, com.tencent.mm.plugin.wallet.wecoin.a.i<Void> parami) {}
    
    public final void a(efg paramefg)
    {
      AppMethodBeat.i(315759);
      Activity localActivity;
      egw localegw;
      com.tencent.mm.plugin.wallet.wecoin.a.h localh;
      String str1;
      com.tencent.mm.plugin.wallet.wecoin.a.i locali;
      if (paramefg != null)
      {
        String str2 = this.Vvl;
        localActivity = paramActivity;
        localegw = this.Vvn;
        localh = paramh;
        str1 = paramString2;
        locali = parami;
        if (paramefg.action == 3)
        {
          paramefg = (CharSequence)str2;
          if ((paramefg != null) && (paramefg.length() != 0)) {
            break label97;
          }
        }
      }
      label97:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          l.b(localActivity, localegw, "release", localh, str1, locali);
        }
        AppMethodBeat.o(315759);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.l
 * JD-Core Version:    0.7.0.1
 */