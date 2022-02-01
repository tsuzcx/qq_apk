package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mm.plugin.wallet.wecoin.b.j;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.fls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isCacheDataLoaded", "", "isShowProgressDialog", "Landroidx/lifecycle/MutableLiveData;", "mAgreementStatus", "", "mAgreementUrl", "", "mAgreementVersion", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mGetPriceListCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "mInterceptPopUp", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "mParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "getMParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "setMParams", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "mPrepareCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "mPriceListResponse", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "mSceneID", "mSceneSessionID", "mSessionid", "mTotalBalance", "", "mUniqueId", "mWecoinPriceInfo", "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "cancelGetPriceListRequest", "", "cancelPrepareRecharge", "generateUniqueID", "getAgreementStatus", "Landroidx/lifecycle/LiveData;", "getAgreementUrl", "getCacheData", "getCgiRespInfo", "getInterceptPopUp", "getTotalBalance", "getWecoinBalanceRequest", "getWecoinPriceInfo", "getWecoinPriceListInfo", "initKVData", "params", "prepareWecoinRecharge", "context", "Landroid/app/Activity;", "info", "scene", "rechargeByMidasSDK", "activity", "response", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "env", "productID", "reportCgiKVStatus", "operationType", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "resetCacheValue", "Companion", "MidasPayCallBackImpl", "plugin-wxpay_release"})
public final class f
  extends x
{
  public static final f.a OEX;
  public int EGw;
  public String ELa;
  public final r<List<fls>> OEJ;
  public final r<String> OEK;
  public final r<Integer> OEL;
  public final r<a> OEM;
  public final r<Long> OEN;
  public final r<d> OEO;
  public cgl OEP;
  public com.tencent.mm.plugin.wallet.wecoin.b.l OEQ;
  public j OER;
  public int OES;
  public boolean OET;
  public String OEU;
  public String OEV;
  public e OEW;
  public final r<Boolean> tEN;
  
  static
  {
    AppMethodBeat.i(246282);
    OEX = new f.a((byte)0);
    AppMethodBeat.o(246282);
  }
  
  public f()
  {
    AppMethodBeat.i(246281);
    this.OEJ = new r();
    this.OEK = new r();
    this.OEL = new r();
    this.OEM = new r();
    this.OEN = new r();
    this.OEO = new r();
    this.tEN = new r();
    this.EGw = -1;
    AppMethodBeat.o(246281);
  }
  
  public final void a(Activity paramActivity, dof paramdof, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246275);
    p.k(paramActivity, "activity");
    p.k(paramdof, "response");
    p.k(paramString1, "env");
    p.k(paramString2, "productID");
    if (paramdof.Thw != null)
    {
      localObject = (CharSequence)paramdof.TVw;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label82;
      }
    }
    label82:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.RechargeProductsDialogViewModel", "rechargeByMidasSDK param error.");
      AppMethodBeat.o(246275);
      return;
    }
    Object localObject = new APMidasGoodsRequest();
    ((APMidasGoodsRequest)localObject).offerId = paramdof.Thw.TFS;
    ((APMidasGoodsRequest)localObject).openId = paramdof.Thw.TFT;
    ((APMidasGoodsRequest)localObject).openKey = paramdof.Thw.TFU;
    ((APMidasGoodsRequest)localObject).sessionId = paramdof.Thw.session_id;
    ((APMidasGoodsRequest)localObject).sessionType = paramdof.Thw.TFV;
    ((APMidasGoodsRequest)localObject).pf = paramdof.Thw.pf;
    ((APMidasGoodsRequest)localObject).pfKey = paramdof.Thw.TFW;
    ((APMidasGoodsRequest)localObject).zoneId = "1";
    ((APMidasGoodsRequest)localObject).goodsTokenUrl = paramdof.TVw;
    ((APMidasGoodsRequest)localObject).mpInfo.payChannel = "wechat";
    APMidasPayAPI.setLogEnable(false);
    APMidasPayAPI.setEnv(paramString1);
    ((APMidasGoodsRequest)localObject).tokenType = 1;
    ((APMidasGoodsRequest)localObject).prodcutId = paramString2;
    ((APMidasGoodsRequest)localObject).saveValue = paramdof.TVx;
    e(4, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.IzE.el(1581, 23);
    paramString1 = (APMidasBaseRequest)localObject;
    paramdof = paramdof.RDi;
    paramString2 = this.OEW;
    localObject = this.OEV;
    if (localObject == null) {
      p.bGy("mSessionid");
    }
    APMidasPayAPI.launchPay(paramActivity, paramString1, (IAPMidasPayCallBack)new b(paramdof, paramString2, (String)localObject));
    AppMethodBeat.o(246275);
  }
  
  public final void amu(int paramInt)
  {
    AppMethodBeat.i(246278);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    int i = this.EGw;
    String str1 = this.OEU;
    if (str1 == null) {
      p.bGy("mSceneSessionID");
    }
    String str2 = this.OEV;
    if (str2 == null) {
      p.bGy("mSessionid");
    }
    localh.a(21651, new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(246278);
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(246279);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    int i = this.EGw;
    String str1 = this.OEU;
    if (str1 == null) {
      p.bGy("mSceneSessionID");
    }
    String str2 = this.OEV;
    if (str2 == null) {
      p.bGy("mSessionid");
    }
    localh.a(22129, new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(246279);
  }
  
  public final String gIi()
  {
    AppMethodBeat.i(246277);
    String str = UUID.randomUUID().toString();
    p.j(str, "uuid.toString()");
    this.ELa = str;
    AppMethodBeat.o(246277);
    return str;
  }
  
  public final void gIj()
  {
    AppMethodBeat.i(246280);
    Log.i("MicroMsg.RechargeProductsDialogViewModel", "resetCacheValue:");
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.OEM, null);
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.tEN, null);
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.OEO, null);
    AppMethodBeat.o(246280);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$MidasPayCallBackImpl;", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "billNo", "", "innerParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "sessionID", "(Ljava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;Ljava/lang/String;)V", "MidasPayCallBack", "", "response", "Lcom/tencent/midas/api/APMidasResponse;", "MidasPayNeedLogin", "cancelWecoinRechargeRequest", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "plugin-wxpay_release"})
  public static final class b
    implements IAPMidasPayCallBack
  {
    private final String AvN;
    private final e OEY;
    private final String gbk;
    
    public b(String paramString1, e parame, String paramString2)
    {
      this.gbk = paramString1;
      this.OEY = parame;
      this.AvN = paramString2;
    }
    
    public final void MidasPayCallBack(APMidasResponse paramAPMidasResponse)
    {
      AppMethodBeat.i(224905);
      if (paramAPMidasResponse != null)
      {
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "MidasPayCallBack: resultCode: " + paramAPMidasResponse.resultCode + ", resultMsg: " + paramAPMidasResponse.resultMsg + ',' + " realSaveNum: " + paramAPMidasResponse.realSaveNum + ", payChannel: " + paramAPMidasResponse.payChannel + ", payState: " + paramAPMidasResponse.payState + ',' + "provideState: " + paramAPMidasResponse.provideState);
        Object localObject;
        switch (paramAPMidasResponse.resultCode)
        {
        case 1: 
        default: 
          localObject = this.OEY;
          if (localObject != null)
          {
            localObject = ((e)localObject).OEH;
            if (localObject != null) {
              ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
            }
          }
          e(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          com.tencent.mm.plugin.report.service.h.IzE.el(1581, 25);
          AppMethodBeat.o(224905);
          return;
        case 2: 
          e(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
          com.tencent.mm.plugin.report.service.h.IzE.el(1581, 26);
          localObject = this.gbk;
          CharSequence localCharSequence = (CharSequence)localObject;
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              e(5, 1, 0, "");
              new com.tencent.mm.plugin.wallet.wecoin.b.a((String)localObject).bhW().h((com.tencent.mm.vending.c.a)new a(this));
            }
            localObject = this.OEY;
            if (localObject == null) {
              break;
            }
            localObject = ((e)localObject).OEH;
            if (localObject == null) {
              break;
            }
            ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, -3, paramAPMidasResponse.resultMsg);
            AppMethodBeat.o(224905);
            return;
          }
          AppMethodBeat.o(224905);
          return;
        }
        e(4, 3, paramAPMidasResponse.resultCode, paramAPMidasResponse.resultMsg);
        com.tencent.mm.plugin.report.service.h.IzE.el(1581, 24);
        paramAPMidasResponse = this.OEY;
        if (paramAPMidasResponse != null)
        {
          if (paramAPMidasResponse.mScene != 0)
          {
            localObject = com.tencent.mm.kernel.h.aHG();
            p.j(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.Vwp, Boolean.FALSE);
            if (localObject == null)
            {
              paramAPMidasResponse = new t("null cannot be cast to non-null type kotlin.Boolean");
              AppMethodBeat.o(224905);
              throw paramAPMidasResponse;
            }
            if (!((Boolean)localObject).booleanValue())
            {
              paramAPMidasResponse = paramAPMidasResponse.OEH;
              if (paramAPMidasResponse != null) {
                paramAPMidasResponse.onSuccess(Boolean.TRUE);
              }
              paramAPMidasResponse = com.tencent.mm.kernel.h.aHG();
              p.j(paramAPMidasResponse, "MMKernel.storage()");
              paramAPMidasResponse.aHp().set(ar.a.Vwp, Boolean.TRUE);
              AppMethodBeat.o(224905);
              return;
            }
          }
          paramAPMidasResponse = paramAPMidasResponse.OEH;
          if (paramAPMidasResponse != null)
          {
            paramAPMidasResponse.onSuccess(Boolean.FALSE);
            AppMethodBeat.o(224905);
            return;
          }
          AppMethodBeat.o(224905);
          return;
        }
        AppMethodBeat.o(224905);
        return;
      }
      AppMethodBeat.o(224905);
    }
    
    public final void MidasPayNeedLogin()
    {
      AppMethodBeat.i(224881);
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "Midas pay need login:");
      AppMethodBeat.o(224881);
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(224915);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      Object localObject1 = this.OEY;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((e)localObject1).mScene);
        localObject2 = this.OEY;
        if (localObject2 == null) {
          break label121;
        }
      }
      label121:
      for (Object localObject2 = ((e)localObject2).OEG;; localObject2 = null)
      {
        localh.a(22129, new Object[] { localObject1, localObject2, this.AvN, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        AppMethodBeat.o(224915);
        return;
        localObject1 = Integer.valueOf(1);
        break;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      a(f.b paramb) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(f paramf) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public d(f paramf) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public e(f paramf, fls paramfls, Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.f
 * JD-Core Version:    0.7.0.1
 */