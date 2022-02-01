package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.djt;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mFaqUrl", "", "mIncomeBalance", "", "mIncomeBillUrl", "mIncomePageInfoResponse", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mRealNameAuthInfo", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "mRealNameAuthored", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getFAQUrl", "getIncomeBalance", "getIncomeBillUrl", "getIncomePageInfoRequest", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getRealNameAuthInfo", "getRealNameAuthRequest", "token", "getRealNameAuthored", "getWeCoinBanner", "initKVData", "kvData", "loadSnapshot", "reportCgiKVStatus", "sessionID", "operationType", "", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "Companion", "plugin-wxpay_release"})
public final class WeCoinIncomeDetailViewModel
  extends ViewModel
{
  public static final WeCoinIncomeDetailViewModel.a HNA;
  public final MutableLiveData<a> HMQ;
  public WecoinEncashKVData HNm;
  public MutableLiveData<String> HNt;
  public MutableLiveData<String> HNu;
  public MutableLiveData<Long> HNv;
  public MutableLiveData<djt> HNw;
  public final MutableLiveData<abq> HNx;
  public final MutableLiveData<Boolean> HNy;
  public bop HNz;
  public final MutableLiveData<Boolean> qiR;
  
  static
  {
    AppMethodBeat.i(212727);
    HNA = new WeCoinIncomeDetailViewModel.a((byte)0);
    AppMethodBeat.o(212727);
  }
  
  public WeCoinIncomeDetailViewModel()
  {
    AppMethodBeat.i(212726);
    this.HNt = new MutableLiveData();
    this.HNu = new MutableLiveData();
    this.HNv = new MutableLiveData();
    this.HNw = new MutableLiveData();
    this.HNx = new MutableLiveData();
    this.HMQ = new MutableLiveData();
    this.HNy = new MutableLiveData();
    this.qiR = new MutableLiveData();
    AppMethodBeat.o(212726);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(212725);
    Object localObject1 = this.HNm;
    if (localObject1 != null)
    {
      localObject2 = ((WecoinEncashKVData)localObject1).HMK;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    h localh = h.CyF;
    Object localObject2 = this.HNm;
    if (localObject2 != null) {}
    for (localObject2 = Integer.valueOf(((WecoinEncashKVData)localObject2).HNZ);; localObject2 = Integer.valueOf(1))
    {
      localh.a(22129, new Object[] { localObject2, localObject1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
      AppMethodBeat.o(212725);
      return;
    }
  }
  
  public final void aeH(int paramInt)
  {
    AppMethodBeat.i(212724);
    Object localObject3 = this.HNm;
    if (localObject3 != null)
    {
      int i = ((WecoinEncashKVData)localObject3).HNZ;
      Object localObject2 = ((WecoinEncashKVData)localObject3).HMK;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((WecoinEncashKVData)localObject3).nZz;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      h.CyF.a(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(212724);
      return;
    }
    AppMethodBeat.o(212724);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public b(WeCoinIncomeDetailViewModel paramWeCoinIncomeDetailViewModel) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(WeCoinIncomeDetailViewModel paramWeCoinIncomeDetailViewModel, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WeCoinIncomeDetailViewModel
 * JD-Core Version:    0.7.0.1
 */