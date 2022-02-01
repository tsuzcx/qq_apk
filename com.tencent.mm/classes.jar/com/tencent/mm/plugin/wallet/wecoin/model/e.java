package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.plugin.wallet.wecoin.a.l;
import com.tencent.mm.plugin.wallet.wecoin.b.k;
import com.tencent.mm.plugin.wallet.wecoin.b.m;
import com.tencent.mm.plugin.wallet.wecoin.utils.c;
import com.tencent.mm.plugin.wallet.wecoin.utils.c.c;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gij;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_priceListResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "businessId", "", "getBusinessId", "()I", "isCacheDataLoaded", "", "isShowProgressDialog", "mAgreementStatus", "mAgreementUrl", "", "mAgreementVersion", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mGetPriceListCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "mInterceptPopUp", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "mParams", "Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "getMParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "setMParams", "(Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;)V", "mPrepareCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "mSceneID", "mSceneSessionID", "mSessionid", "mTotalBalance", "", "mUniqueId", "priceListResponse", "Landroidx/lifecycle/LiveData;", "getPriceListResponse", "()Landroidx/lifecycle/LiveData;", "cancelGetPriceListRequest", "", "cancelPrepareRecharge", "directRecharge", "context", "Landroid/app/Activity;", "customCount", "generateUniqueID", "getAgreementStatus", "getAgreementUrl", "getCacheData", "getCgiRespInfo", "getInterceptPopUp", "getTotalBalance", "getWecoinBalanceRequest", "getWecoinPriceListInfo", "scene", "initKVData", "params", "prepareWecoinRecharge", "info", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "rechargeByMidasSDK", "activity", "response", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "env", "productID", "reportCgiKVStatus", "operationType", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "resetCacheValue", "Companion", "MidasPayCallBackImpl", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends af
{
  public static final e.a Vum;
  private String KFd;
  public int KzF;
  public final x<String> Vun;
  public final x<Integer> Vuo;
  public final x<a> Vup;
  public final x<Long> Vuq;
  public final x<d> Vur;
  public x<cwo> Vus;
  public m Vut;
  public k Vuu;
  public int Vuv;
  public boolean Vuw;
  public String Vux;
  public String Vuy;
  public com.tencent.mm.plugin.wallet.wecoin.a.h Vuz;
  public final x<Boolean> wIq;
  
  static
  {
    AppMethodBeat.i(315846);
    Vum = new e.a((byte)0);
    AppMethodBeat.o(315846);
  }
  
  public e()
  {
    AppMethodBeat.i(315792);
    this.Vun = new x();
    this.Vuo = new x();
    this.Vup = new x();
    this.Vuq = new x();
    this.Vur = new x();
    this.wIq = new x();
    this.Vus = new x();
    this.KzF = -1;
    AppMethodBeat.o(315792);
  }
  
  private static final cwk a(e parame, b.a parama)
  {
    AppMethodBeat.i(315801);
    s.u(parame, "this$0");
    cwk localcwk = (cwk)parama.ott;
    if (localcwk == null)
    {
      AppMethodBeat.o(315801);
      return null;
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parame.Vuq.t(Long.valueOf(localcwk.aatB));
      c.xz(localcwk.aatB);
    }
    AppMethodBeat.o(315801);
    return localcwk;
  }
  
  private static final ah a(e parame, gij paramgij, Activity paramActivity, b.a parama)
  {
    AppMethodBeat.i(315831);
    s.u(parame, "this$0");
    s.u(paramgij, "$info");
    s.u(paramActivity, "$context");
    Log.i("MicroMsg.RechargeProductsDialogViewModel", "prepareWecoinRecharge errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    parame.Vut = null;
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.wIq, Boolean.FALSE);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      paramActivity = (egw)parama.ott;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.ablX;
        if (paramActivity != null)
        {
          esc localesc = parama.ott;
          s.s(localesc, "cgiBack.resp");
          c.d("MicroMsg.RechargeProductsDialogViewModel", (com.tencent.mm.bx.a)localesc);
          com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.Vur, new d((egw)parama.ott, paramgij));
          parame.ihr();
          parame.h(3, 3, parama.errCode, paramActivity.wording);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 27);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
          parame = ah.aiuX;
          AppMethodBeat.o(315831);
          return parame;
        }
      }
      com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.Vup, new a(parama.errType, parama.errCode, parama.errMsg));
      parame.ihr();
      parame.h(3, 3, parama.errCode, parama.errMsg);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
      parame = ah.aiuX;
      AppMethodBeat.o(315831);
      return parame;
    }
    if (parama.ott == null)
    {
      Log.e("MicroMsg.RechargeProductsDialogViewModel", "cgiBack.resp is null");
      com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.Vup, new a(3, -1, ""));
      parame.ihr();
      parame.h(3, 3, 3, "callback resp is null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 22);
      parame = ah.aiuX;
      AppMethodBeat.o(315831);
      return parame;
    }
    parama = (egw)parama.ott;
    if (parama != null)
    {
      Log.i("MicroMsg.RechargeProductsDialogViewModel", s.X("prepareWecoinRecharge, product_id: ", paramgij.MQZ));
      c.d("MicroMsg.RechargeProductsDialogViewModel", (com.tencent.mm.bx.a)parama);
      parame.h(3, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 21);
      paramgij = paramgij.MQZ;
      s.s(paramgij, "info.product_id");
      parame.a(paramActivity, parama, "release", paramgij);
    }
    parame.ihr();
    parame = ah.aiuX;
    AppMethodBeat.o(315831);
    return parame;
  }
  
  private static final ah b(e parame, b.a parama)
  {
    AppMethodBeat.i(315815);
    s.u(parame, "this$0");
    Log.i("MicroMsg.RechargeProductsDialogViewModel", "getWecoinPriceListInfo errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    parame.Vuu = null;
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.wIq, Boolean.FALSE);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      if (parame.Vus.getValue() == null)
      {
        com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.Vup, new a(parama.errType, parama.errCode, parama.errMsg));
        parame.ihr();
      }
      parame.h(8, 3, parama.errCode, parama.errMsg);
      parame = ah.aiuX;
      AppMethodBeat.o(315815);
      return parame;
    }
    if (parama.ott == null)
    {
      if (parame.Vus.getValue() == null)
      {
        com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parame.Vup, new a(3, -1, ""));
        parame.ihr();
      }
      parame.h(8, 3, 3, "callback resp is null");
      parame = ah.aiuX;
      AppMethodBeat.o(315815);
      return parame;
    }
    parama = (cwo)parama.ott;
    if (parama != null)
    {
      c.d("MicroMsg.RechargeProductsDialogViewModel", (com.tencent.mm.bx.a)parama);
      parame.Vun.t(parama.aaBH);
      parame.Vuo.t(Integer.valueOf(parama.aaBI));
      parame.Vuv = parama.aaBJ;
      parame.Vus.t(parama);
      int i = parame.iho();
      s.u(parama, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinPriceListResponse snapshot");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new c.c(parama, i));
      parame.h(8, 3, 0, "");
    }
    parame = ah.aiuX;
    AppMethodBeat.o(315815);
    return parame;
  }
  
  public final void a(Activity paramActivity, egw paramegw, String paramString1, String paramString2)
  {
    AppMethodBeat.i(315887);
    s.u(paramActivity, "activity");
    s.u(paramegw, "response");
    s.u(paramString1, "env");
    s.u(paramString2, "productID");
    if (paramegw.aauM != null)
    {
      localObject = (CharSequence)paramegw.abmj;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label89;
      }
    }
    label89:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.RechargeProductsDialogViewModel", "rechargeByMidasSDK param error.");
      AppMethodBeat.o(315887);
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
    ((APMidasGoodsRequest)localObject).prodcutId = paramString2;
    ((APMidasGoodsRequest)localObject).saveValue = paramegw.abmk;
    h(4, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 23);
    paramString2 = (APMidasBaseRequest)localObject;
    localObject = paramegw.YzL;
    com.tencent.mm.plugin.wallet.wecoin.a.h localh = this.Vuz;
    paramString1 = this.Vuy;
    paramegw = paramString1;
    if (paramString1 == null)
    {
      s.bIx("mSessionid");
      paramegw = null;
    }
    APMidasPayAPI.launchPay(paramActivity, paramString2, (IAPMidasPayCallBack)new b((String)localObject, localh, paramegw));
    AppMethodBeat.o(315887);
  }
  
  public final void a(Activity paramActivity, gij paramgij, int paramInt)
  {
    AppMethodBeat.i(315908);
    s.u(paramActivity, "context");
    s.u(paramgij, "info");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.TRUE);
    h(3, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 20);
    String str = this.KFd;
    Object localObject = str;
    if (str == null) {
      localObject = ihq();
    }
    egv localegv = new egv();
    localegv.request_id = ((String)localObject);
    localegv.abmh = paramgij.MQZ;
    localegv.aaBJ = this.Vuv;
    localegv.scene = paramInt;
    str = this.Vux;
    localObject = str;
    if (str == null)
    {
      s.bIx("mSceneSessionID");
      localObject = null;
    }
    localegv.ZoT = ((String)localObject);
    this.Vut = new m(localegv);
    localObject = this.Vut;
    if (localObject != null)
    {
      localObject = ((m)localObject).bFJ();
      if (localObject != null) {
        ((f)localObject).b(new e..ExternalSyntheticLambda2(this, paramgij, paramActivity));
      }
    }
    AppMethodBeat.o(315908);
  }
  
  public final void ase(int paramInt)
  {
    AppMethodBeat.i(315898);
    h(8, 1, 0, "");
    this.Vuu = new k(l.asd(paramInt));
    Object localObject = this.Vuu;
    if (localObject != null)
    {
      localObject = ((k)localObject).bFJ();
      if (localObject != null) {
        ((f)localObject).b(new e..ExternalSyntheticLambda1(this));
      }
    }
    AppMethodBeat.o(315898);
  }
  
  public final void asf(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(315921);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    int i = this.KzF;
    String str2 = this.Vux;
    String str1 = str2;
    if (str2 == null)
    {
      s.bIx("mSceneSessionID");
      str1 = null;
    }
    str2 = this.Vuy;
    if (str2 == null) {
      s.bIx("mSessionid");
    }
    for (;;)
    {
      localh.b(21651, new Object[] { Integer.valueOf(i), str1, localObject, Integer.valueOf(paramInt) });
      AppMethodBeat.o(315921);
      return;
      localObject = str2;
    }
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(315929);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    int i = this.KzF;
    String str2 = this.Vux;
    String str1 = str2;
    if (str2 == null)
    {
      s.bIx("mSceneSessionID");
      str1 = null;
    }
    str2 = this.Vuy;
    if (str2 == null) {
      s.bIx("mSessionid");
    }
    for (;;)
    {
      localh.b(22129, new Object[] { Integer.valueOf(i), str1, localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(315929);
      return;
      localObject = str2;
    }
  }
  
  public final int iho()
  {
    AppMethodBeat.i(315877);
    com.tencent.mm.plugin.wallet.wecoin.a.h localh = this.Vuz;
    if (localh == null) {}
    for (int i = 0;; i = localh.mScene)
    {
      i = l.asd(i);
      AppMethodBeat.o(315877);
      return i;
    }
  }
  
  public final void ihp()
  {
    AppMethodBeat.i(315892);
    new com.tencent.mm.plugin.wallet.wecoin.b.h().bFJ().b(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(315892);
  }
  
  public final String ihq()
  {
    AppMethodBeat.i(315914);
    String str = UUID.randomUUID().toString();
    s.s(str, "uuid.toString()");
    this.KFd = str;
    AppMethodBeat.o(315914);
    return str;
  }
  
  public final void ihr()
  {
    AppMethodBeat.i(315937);
    Log.i("MicroMsg.RechargeProductsDialogViewModel", "resetCacheValue:");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.Vup, null);
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, null);
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.Vur, null);
    AppMethodBeat.o(315937);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$MidasPayCallBackImpl;", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "billNo", "", "innerParams", "Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "sessionID", "(Ljava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;Ljava/lang/String;)V", "MidasPayCallBack", "", "response", "Lcom/tencent/midas/api/APMidasResponse;", "MidasPayNeedLogin", "cancelWecoinRechargeRequest", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements IAPMidasPayCallBack
  {
    private final String FUP;
    private final com.tencent.mm.plugin.wallet.wecoin.a.h VuA;
    private final String ihu;
    
    public b(String paramString1, com.tencent.mm.plugin.wallet.wecoin.a.h paramh, String paramString2)
    {
      this.ihu = paramString1;
      this.VuA = paramh;
      this.FUP = paramString2;
    }
    
    private static final ah a(b paramb, b.a parama)
    {
      AppMethodBeat.i(315734);
      s.u(paramb, "this$0");
      paramb.h(5, 3, parama.errCode, parama.errMsg);
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        paramb = ah.aiuX;
        AppMethodBeat.o(315734);
        return paramb;
      }
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelWecoinRechargeRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
      paramb = ah.aiuX;
      AppMethodBeat.o(315734);
      return paramb;
    }
    
    private final void h(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(315730);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      Object localObject = this.VuA;
      int i;
      if (localObject == null)
      {
        i = -1;
        i = c.asg(i);
        localObject = this.VuA;
        if (localObject != null) {
          break label121;
        }
      }
      label121:
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject).Vua)
      {
        localh.b(22129, new Object[] { Integer.valueOf(i), localObject, this.FUP, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        AppMethodBeat.o(315730);
        return;
        i = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject).mScene;
        break;
      }
    }
    
    public final void MidasPayCallBack(APMidasResponse paramAPMidasResponse)
    {
      AppMethodBeat.i(315755);
      Object localObject;
      if (paramAPMidasResponse != null)
      {
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "MidasPayCallBack: resultCode: " + paramAPMidasResponse.resultCode + ", resultMsg: " + paramAPMidasResponse.resultMsg + ", realSaveNum: " + paramAPMidasResponse.realSaveNum + ", payChannel: " + paramAPMidasResponse.payChannel + ", payState: " + paramAPMidasResponse.payState + ",provideState: " + paramAPMidasResponse.provideState);
        switch (paramAPMidasResponse.resultCode)
        {
        case 1: 
        default: 
          localObject = this.VuA;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject).VtR;
            if (localObject != null) {
              ((i)localObject).s(3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
            }
          }
          h(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 25);
        }
      }
      do
      {
        AppMethodBeat.o(315755);
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
            new com.tencent.mm.plugin.wallet.wecoin.b.a((String)localObject).bFJ().h(new e.b..ExternalSyntheticLambda0(this));
          }
          localObject = this.VuA;
          if (localObject == null) {
            break;
          }
          localObject = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject).VtR;
          if (localObject == null) {
            break;
          }
          ((i)localObject).s(3, -3, paramAPMidasResponse.resultMsg);
          AppMethodBeat.o(315755);
          return;
        }
        h(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 24);
        paramAPMidasResponse = this.VuA;
      } while (paramAPMidasResponse == null);
      paramAPMidasResponse = paramAPMidasResponse.VtR;
      if (paramAPMidasResponse != null) {
        paramAPMidasResponse.onSuccess(null);
      }
      AppMethodBeat.o(315755);
    }
    
    public final void MidasPayNeedLogin()
    {
      AppMethodBeat.i(315743);
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "Midas pay need login:");
      AppMethodBeat.o(315743);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$directRecharge$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i<Void>
  {
    public c(e parame) {}
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(315741);
      e.a(this.VuB).t(Boolean.FALSE);
      Object localObject = this.VuB.Vuz;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject).VtR;
        if (localObject != null) {
          ((i)localObject).s(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(315741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.e
 * JD-Core Version:    0.7.0.1
 */