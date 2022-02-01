package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.b.i;
import com.tencent.mm.plugin.wallet.wecoin.b.k;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isCacheDataLoaded", "", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "mAgreementStatus", "", "mAgreementUrl", "", "mAgreementVersion", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mGetPriceListCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "mInterceptPopUp", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "mParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "getMParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "setMParams", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "mPrepareCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "mPriceListResponse", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "mSceneID", "mSceneSessionID", "mSessionid", "mTotalBalance", "", "mUniqueId", "mWecoinPriceInfo", "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "cancelGetPriceListRequest", "", "cancelPrepareRecharge", "generateUniqueID", "getAgreementStatus", "Landroid/arch/lifecycle/LiveData;", "getAgreementUrl", "getCacheData", "getCgiRespInfo", "getInterceptPopUp", "getTotalBalance", "getWecoinBalanceRequest", "getWecoinPriceInfo", "getWecoinPriceListInfo", "initKVData", "params", "prepareWecoinRecharge", "context", "Landroid/app/Activity;", "info", "scene", "rechargeByMidasSDK", "activity", "response", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "env", "productID", "reportCgiKVStatus", "operationType", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "resetCacheValue", "Companion", "MidasPayCallBackImpl", "plugin-wxpay_release"})
public final class RechargeProductsDialogViewModel
  extends ViewModel
{
  public static final RechargeProductsDialogViewModel.a HNb;
  public final MutableLiveData<List<faz>> HMN;
  public final MutableLiveData<String> HMO;
  public final MutableLiveData<Integer> HMP;
  public final MutableLiveData<a> HMQ;
  public final MutableLiveData<Long> HMR;
  public final MutableLiveData<d> HMS;
  public byr HMT;
  public k HMU;
  public i HMV;
  public int HMW;
  public boolean HMX;
  public String HMY;
  public String HMZ;
  public e HNa;
  public final MutableLiveData<Boolean> qiR;
  public int zbZ;
  public String zfX;
  
  static
  {
    AppMethodBeat.i(212713);
    HNb = new RechargeProductsDialogViewModel.a((byte)0);
    AppMethodBeat.o(212713);
  }
  
  public RechargeProductsDialogViewModel()
  {
    AppMethodBeat.i(212712);
    this.HMN = new MutableLiveData();
    this.HMO = new MutableLiveData();
    this.HMP = new MutableLiveData();
    this.HMQ = new MutableLiveData();
    this.HMR = new MutableLiveData();
    this.HMS = new MutableLiveData();
    this.qiR = new MutableLiveData();
    this.zbZ = -1;
    AppMethodBeat.o(212712);
  }
  
  public final void a(Activity paramActivity, dep paramdep, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212707);
    p.h(paramActivity, "activity");
    p.h(paramdep, "response");
    p.h(paramString1, "env");
    p.h(paramString2, "productID");
    if (paramdep.LYf != null)
    {
      localObject = (CharSequence)paramdep.MJH;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label82;
      }
    }
    label82:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.RechargeProductsDialogViewModel", "rechargeByMidasSDK param error.");
      AppMethodBeat.o(212707);
      return;
    }
    Object localObject = new APMidasGoodsRequest();
    ((APMidasGoodsRequest)localObject).offerId = paramdep.LYf.MuV;
    ((APMidasGoodsRequest)localObject).openId = paramdep.LYf.MuW;
    ((APMidasGoodsRequest)localObject).openKey = paramdep.LYf.MuX;
    ((APMidasGoodsRequest)localObject).sessionId = paramdep.LYf.session_id;
    ((APMidasGoodsRequest)localObject).sessionType = paramdep.LYf.MuY;
    ((APMidasGoodsRequest)localObject).pf = paramdep.LYf.pf;
    ((APMidasGoodsRequest)localObject).pfKey = paramdep.LYf.MuZ;
    ((APMidasGoodsRequest)localObject).zoneId = "1";
    ((APMidasGoodsRequest)localObject).goodsTokenUrl = paramdep.MJH;
    ((APMidasGoodsRequest)localObject).mpInfo.payChannel = "wechat";
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.setEnv(paramString1);
    ((APMidasGoodsRequest)localObject).tokenType = 1;
    ((APMidasGoodsRequest)localObject).prodcutId = paramString2;
    ((APMidasGoodsRequest)localObject).saveValue = paramdep.MJI;
    f(4, 1, 0, "");
    h.CyF.dN(1581, 23);
    paramString1 = (APMidasBaseRequest)localObject;
    paramdep = paramdep.KBs;
    paramString2 = this.HNa;
    localObject = this.HMZ;
    if (localObject == null) {
      p.btv("mSessionid");
    }
    APMidasPayAPI.launchPay(paramActivity, paramString1, (IAPMidasPayCallBack)new b(paramdep, paramString2, (String)localObject));
    AppMethodBeat.o(212707);
  }
  
  public final void aeH(int paramInt)
  {
    AppMethodBeat.i(212709);
    h localh = h.CyF;
    int i = this.zbZ;
    String str1 = this.HMY;
    if (str1 == null) {
      p.btv("mSceneSessionID");
    }
    String str2 = this.HMZ;
    if (str2 == null) {
      p.btv("mSessionid");
    }
    localh.a(21651, new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(212709);
  }
  
  public final void f(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(212710);
    h localh = h.CyF;
    int i = this.zbZ;
    String str1 = this.HMY;
    if (str1 == null) {
      p.btv("mSceneSessionID");
    }
    String str2 = this.HMZ;
    if (str2 == null) {
      p.btv("mSessionid");
    }
    localh.a(22129, new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(212710);
  }
  
  public final String fPE()
  {
    AppMethodBeat.i(212708);
    String str = UUID.randomUUID().toString();
    p.g(str, "uuid.toString()");
    this.zfX = str;
    AppMethodBeat.o(212708);
    return str;
  }
  
  public final void fPF()
  {
    AppMethodBeat.i(212711);
    Log.i("MicroMsg.RechargeProductsDialogViewModel", "resetCacheValue:");
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HMQ, null);
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, null);
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HMS, null);
    AppMethodBeat.o(212711);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$MidasPayCallBackImpl;", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "billNo", "", "innerParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "sessionID", "(Ljava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;Ljava/lang/String;)V", "MidasPayCallBack", "", "response", "Lcom/tencent/midas/api/APMidasResponse;", "MidasPayNeedLogin", "cancelWecoinRechargeRequest", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "plugin-wxpay_release"})
  public static final class b
    implements IAPMidasPayCallBack
  {
    private final e HNc;
    private final String egU;
    private final String vPa;
    
    public b(String paramString1, e parame, String paramString2)
    {
      this.egU = paramString1;
      this.HNc = parame;
      this.vPa = paramString2;
    }
    
    public final void MidasPayCallBack(APMidasResponse paramAPMidasResponse)
    {
      AppMethodBeat.i(212702);
      if (paramAPMidasResponse != null)
      {
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "MidasPayCallBack: resultCode: " + paramAPMidasResponse.resultCode + ", resultMsg: " + paramAPMidasResponse.resultMsg + ',' + " realSaveNum: " + paramAPMidasResponse.realSaveNum + ", payChannel: " + paramAPMidasResponse.payChannel + ", payState: " + paramAPMidasResponse.payState + ',' + "provideState: " + paramAPMidasResponse.provideState);
        Object localObject;
        switch (paramAPMidasResponse.resultCode)
        {
        case 1: 
        default: 
          localObject = this.HNc;
          if (localObject != null)
          {
            localObject = ((e)localObject).HML;
            if (localObject != null) {
              ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
            }
          }
          f(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          h.CyF.dN(1581, 25);
          AppMethodBeat.o(212702);
          return;
        case 2: 
          f(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          h.CyF.dN(1581, 26);
          localObject = this.egU;
          CharSequence localCharSequence = (CharSequence)localObject;
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              f(5, 1, 0, "");
              new com.tencent.mm.plugin.wallet.wecoin.b.a((String)localObject).aYI().h((com.tencent.mm.vending.c.a)new a(this));
            }
            localObject = this.HNc;
            if (localObject == null) {
              break;
            }
            localObject = ((e)localObject).HML;
            if (localObject == null) {
              break;
            }
            ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, -3, paramAPMidasResponse.resultMsg);
            AppMethodBeat.o(212702);
            return;
          }
          AppMethodBeat.o(212702);
          return;
        }
        f(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
        h.CyF.dN(1581, 24);
        paramAPMidasResponse = this.HNc;
        if (paramAPMidasResponse != null)
        {
          if (paramAPMidasResponse.mScene != 0)
          {
            localObject = g.aAh();
            p.g(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OhZ, Boolean.FALSE);
            if (localObject == null)
            {
              paramAPMidasResponse = new t("null cannot be cast to non-null type kotlin.Boolean");
              AppMethodBeat.o(212702);
              throw paramAPMidasResponse;
            }
            if (!((Boolean)localObject).booleanValue())
            {
              paramAPMidasResponse = paramAPMidasResponse.HML;
              if (paramAPMidasResponse != null) {
                paramAPMidasResponse.onSuccess(Boolean.TRUE);
              }
              paramAPMidasResponse = g.aAh();
              p.g(paramAPMidasResponse, "MMKernel.storage()");
              paramAPMidasResponse.azQ().set(ar.a.OhZ, Boolean.TRUE);
              AppMethodBeat.o(212702);
              return;
            }
          }
          paramAPMidasResponse = paramAPMidasResponse.HML;
          if (paramAPMidasResponse != null)
          {
            paramAPMidasResponse.onSuccess(Boolean.FALSE);
            AppMethodBeat.o(212702);
            return;
          }
          AppMethodBeat.o(212702);
          return;
        }
        AppMethodBeat.o(212702);
        return;
      }
      AppMethodBeat.o(212702);
    }
    
    public final void MidasPayNeedLogin()
    {
      AppMethodBeat.i(212701);
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "Midas pay need login:");
      AppMethodBeat.o(212701);
    }
    
    public final void f(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(212703);
      h localh = h.CyF;
      Object localObject1 = this.HNc;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((e)localObject1).mScene);
        localObject2 = this.HNc;
        if (localObject2 == null) {
          break label121;
        }
      }
      label121:
      for (Object localObject2 = ((e)localObject2).HMK;; localObject2 = null)
      {
        localh.a(22129, new Object[] { localObject1, localObject2, this.vPa, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        AppMethodBeat.o(212703);
        return;
        localObject1 = Integer.valueOf(1);
        break;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      a(RechargeProductsDialogViewModel.b paramb) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(RechargeProductsDialogViewModel paramRechargeProductsDialogViewModel) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public d(RechargeProductsDialogViewModel paramRechargeProductsDialogViewModel) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public e(RechargeProductsDialogViewModel paramRechargeProductsDialogViewModel, faz paramfaz, Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.RechargeProductsDialogViewModel
 * JD-Core Version:    0.7.0.1
 */