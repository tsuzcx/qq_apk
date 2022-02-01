package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.dti;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroidx/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mFaqUrl", "", "mIncomeBalance", "", "mIncomeBillUrl", "mIncomePageInfoResponse", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mRealNameAuthInfo", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "mRealNameAuthored", "getCgiRespInfo", "Landroidx/lifecycle/LiveData;", "getFAQUrl", "getIncomeBalance", "getIncomeBillUrl", "getIncomePageInfoRequest", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getRealNameAuthInfo", "getRealNameAuthRequest", "token", "getRealNameAuthored", "getWeCoinBanner", "initKVData", "kvData", "loadSnapshot", "reportCgiKVStatus", "sessionID", "operationType", "", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "Companion", "plugin-wxpay_release"})
public final class i
  extends x
{
  public static final i.a OFw;
  public final r<a> OEM;
  public WecoinEncashKVData OFi;
  public r<String> OFp;
  public r<String> OFq;
  public r<Long> OFr;
  public r<dti> OFs;
  public final r<abx> OFt;
  public final r<Boolean> OFu;
  public bwm OFv;
  public final r<Boolean> tEN;
  
  static
  {
    AppMethodBeat.i(272370);
    OFw = new i.a((byte)0);
    AppMethodBeat.o(272370);
  }
  
  public i()
  {
    AppMethodBeat.i(272367);
    this.OFp = new r();
    this.OFq = new r();
    this.OFr = new r();
    this.OFs = new r();
    this.OFt = new r();
    this.OEM = new r();
    this.OFu = new r();
    this.tEN = new r();
    AppMethodBeat.o(272367);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(272365);
    Object localObject1 = this.OFi;
    if (localObject1 != null)
    {
      localObject2 = ((WecoinEncashKVData)localObject1).OEG;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    h localh = h.IzE;
    Object localObject2 = this.OFi;
    if (localObject2 != null) {}
    for (localObject2 = Integer.valueOf(((WecoinEncashKVData)localObject2).OFV);; localObject2 = Integer.valueOf(1))
    {
      localh.a(22129, new Object[] { localObject2, localObject1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
      AppMethodBeat.o(272365);
      return;
    }
  }
  
  public final void amu(int paramInt)
  {
    AppMethodBeat.i(272363);
    Object localObject3 = this.OFi;
    if (localObject3 != null)
    {
      int i = ((WecoinEncashKVData)localObject3).OFV;
      Object localObject2 = ((WecoinEncashKVData)localObject3).OEG;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((WecoinEncashKVData)localObject3).rbk;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      h.IzE.a(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(272363);
      return;
    }
    AppMethodBeat.o(272363);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public b(i parami) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(i parami, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.i
 * JD-Core Version:    0.7.0.1
 */