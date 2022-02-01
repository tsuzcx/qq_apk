package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isMidasSDKInitialized", "Landroidx/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mHasShowTutorialFlag", "mIncomeBalance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "mTotalBalance", "", "mWeCoinPageInfoResp", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "mWecoinBillUrl", "", "mWecoinQaUrl", "getCgiRespInfo", "Landroidx/lifecycle/LiveData;", "getIncomeBalance", "getShowTutorialFlag", "", "getTotalBalance", "getWecoinBanner", "getWecoinBillUrl", "getWecoinPageInfoRequest", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getWecoinQaUrl", "hasShowTutorialFlag", "initMidasSdkInfo", "activity", "Landroid/content/Context;", "loadSnapshot", "reportCgiKVStatus", "stepID", "", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "setShowTutorialFlag", "Companion", "plugin-wxpay_release"})
public final class l
  extends x
{
  public static final l.a OFT;
  public final r<a> OEM;
  public final r<Long> OEN;
  public final r<Boolean> OFO;
  public final r<String> OFP;
  public final r<String> OFQ;
  public final r<Boolean> OFR;
  public cgj OFS;
  public final r<g> OFr;
  public final r<abx> OFt;
  
  static
  {
    AppMethodBeat.i(277200);
    OFT = new l.a((byte)0);
    AppMethodBeat.o(277200);
  }
  
  public l()
  {
    AppMethodBeat.i(277198);
    this.OFO = new r();
    this.OEN = new r();
    this.OFr = new r();
    this.OFP = new r();
    this.OFQ = new r();
    this.OFt = new r();
    this.OEM = new r();
    this.OFR = new r();
    AppMethodBeat.o(277198);
  }
  
  public static void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(277195);
    com.tencent.mm.plugin.report.service.h.IzE.a(22129, new Object[] { Integer.valueOf(2), "", "", Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(277195);
  }
  
  public static void amu(int paramInt)
  {
    AppMethodBeat.i(277194);
    com.tencent.mm.plugin.report.service.h.IzE.a(21650, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(277194);
  }
  
  public static void gIm()
  {
    AppMethodBeat.i(277196);
    f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vwm, Boolean.TRUE);
    AppMethodBeat.o(277196);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public b(l paraml) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel$initMidasSdkInfo$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-wxpay_release"})
  public static final class c
    implements e<Boolean>
  {
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(186304);
      l.a(this.OFU).L(Boolean.FALSE);
      AppMethodBeat.o(186304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.l
 * JD-Core Version:    0.7.0.1
 */