package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isMidasSDKInitialized", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mHasShowTutorialFlag", "mIncomeBalance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "mTotalBalance", "", "mWeCoinPageInfoResp", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "mWecoinBillUrl", "", "mWecoinQaUrl", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getIncomeBalance", "getShowTutorialFlag", "", "getTotalBalance", "getWecoinBanner", "getWecoinBillUrl", "getWecoinPageInfoRequest", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getWecoinQaUrl", "hasShowTutorialFlag", "initMidasSdkInfo", "activity", "Landroid/content/Context;", "loadSnapshot", "reportCgiKVStatus", "stepID", "", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "setShowTutorialFlag", "Companion", "plugin-wxpay_release"})
public final class WeCoinRechargeViewModel
  extends ViewModel
{
  public static final WeCoinRechargeViewModel.a HNX;
  public final MutableLiveData<a> HMQ;
  public final MutableLiveData<Long> HMR;
  public final MutableLiveData<Boolean> HNS;
  public final MutableLiveData<String> HNT;
  public final MutableLiveData<String> HNU;
  public final MutableLiveData<Boolean> HNV;
  public byp HNW;
  public final MutableLiveData<f> HNv;
  public final MutableLiveData<abq> HNx;
  
  static
  {
    AppMethodBeat.i(212742);
    HNX = new WeCoinRechargeViewModel.a((byte)0);
    AppMethodBeat.o(212742);
  }
  
  public WeCoinRechargeViewModel()
  {
    AppMethodBeat.i(212741);
    this.HNS = new MutableLiveData();
    this.HMR = new MutableLiveData();
    this.HNv = new MutableLiveData();
    this.HNT = new MutableLiveData();
    this.HNU = new MutableLiveData();
    this.HNx = new MutableLiveData();
    this.HMQ = new MutableLiveData();
    this.HNV = new MutableLiveData();
    AppMethodBeat.o(212741);
  }
  
  public static void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(212739);
    h.CyF.a(22129, new Object[] { Integer.valueOf(2), "", "", Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(212739);
  }
  
  public static void aeH(int paramInt)
  {
    AppMethodBeat.i(212738);
    h.CyF.a(21650, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(212738);
  }
  
  public static void fPI()
  {
    AppMethodBeat.i(212740);
    com.tencent.mm.kernel.e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OhW, Boolean.TRUE);
    AppMethodBeat.o(212740);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public b(WeCoinRechargeViewModel paramWeCoinRechargeViewModel) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel$initMidasSdkInfo$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-wxpay_release"})
  public static final class c
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean>
  {
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(212737);
      WeCoinRechargeViewModel.a(this.HNY).postValue(Boolean.FALSE);
      AppMethodBeat.o(212737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WeCoinRechargeViewModel
 * JD-Core Version:    0.7.0.1
 */