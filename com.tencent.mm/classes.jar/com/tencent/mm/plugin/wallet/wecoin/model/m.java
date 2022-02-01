package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.plugin.wallet.wecoin.b.j;
import com.tencent.mm.plugin.wallet.wecoin.utils.c;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.gii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isMidasSDKInitialized", "Landroidx/lifecycle/MutableLiveData;", "", "isShowProgressDialog", "isWccoinAuthed", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mIncomeBalance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "mTotalBalance", "", "mWeCoinPageInfoResp", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "mWecoinBillUrl", "", "mWecoinNewUserTips", "Lcom/tencent/mm/protocal/protobuf/WecoinNewUserTips;", "mWecoinQaUrl", "checkBalance", "", "callback", "Lkotlin/Function1;", "getCgiRespInfo", "Landroidx/lifecycle/LiveData;", "getIncomeBalance", "getIsWccoinAuthed", "getShowTutorialFlag", "getTotalBalance", "getWecoinBanner", "getWecoinBillUrl", "getWecoinNewUserTips", "getWecoinPageInfoRequest", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getWecoinQaUrl", "initMidasSdkInfo", "activity", "Landroid/content/Context;", "loadSnapshot", "reportCgiKVStatus", "stepID", "", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "setShowTutorialFlag", "updateAuthFlag", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends af
{
  public static final m.a Vvq;
  public final x<f> VuQ;
  public final x<adz> VuS;
  public final x<a> Vup;
  public final x<Long> Vuq;
  public final x<Boolean> Vvr;
  public final x<String> Vvs;
  public final x<String> Vvt;
  public final x<gii> Vvu;
  public cwm Vvv;
  public final x<Boolean> Vvw;
  public final x<Boolean> wIq;
  
  static
  {
    AppMethodBeat.i(315827);
    Vvq = new m.a((byte)0);
    AppMethodBeat.o(315827);
  }
  
  public m()
  {
    AppMethodBeat.i(315774);
    this.Vvr = new x();
    this.Vuq = new x();
    this.VuQ = new x();
    this.Vvs = new x();
    this.Vvt = new x();
    this.VuS = new x();
    this.Vup = new x();
    this.Vvu = new x();
    this.Vvw = new x();
    this.wIq = new x();
    AppMethodBeat.o(315774);
  }
  
  private static void T(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(315779);
    com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(2), "", "", Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(315779);
  }
  
  private static final ah a(m paramm, b.a parama)
  {
    AppMethodBeat.i(315804);
    s.u(paramm, "this$0");
    Log.i("MicroMsg.WeCoinRechargeViewModel", "getWecoinPageInfoRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      if (paramm.Vvv == null) {
        paramm.Vup.t(new a(parama.errType, parama.errCode, parama.errMsg));
      }
      T(3, parama.errCode, parama.errMsg);
      paramm = ah.aiuX;
      AppMethodBeat.o(315804);
      return paramm;
    }
    if (parama.ott == null)
    {
      if (paramm.Vvv == null) {
        paramm.Vup.t(new a(3, -1, ""));
      }
      T(3, 3, "callback resp is null");
      paramm = ah.aiuX;
      AppMethodBeat.o(315804);
      return paramm;
    }
    parama = (cwm)parama.ott;
    if (parama != null)
    {
      c.d("MicroMsg.WeCoinRechargeViewModel", (com.tencent.mm.bx.a)parama);
      paramm.VuQ.t(new f(parama.aaBD, parama.aarR));
      paramm.Vuq.t(Long.valueOf(parama.ZoU));
      paramm.Vvs.t(parama.aatC);
      paramm.Vvt.t(parama.aaBC);
      paramm.VuS.t(parama.aatD);
      paramm.Vvu.t(parama.aaBE);
      paramm.Vvv = parama;
      c.xz(parama.ZoU);
      paramm.Vvw.t(Boolean.valueOf(((d)com.tencent.mm.kernel.h.ax(d.class)).ihl()));
      T(3, 0, "");
      paramm = ah.aiuX;
      AppMethodBeat.o(315804);
      return paramm;
    }
    paramm = ah.aiuX;
    AppMethodBeat.o(315804);
    return paramm;
  }
  
  private static final ah a(m paramm, kotlin.g.a.b paramb, b.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(315814);
    s.u(paramm, "this$0");
    s.u(paramb, "$callback");
    Log.i("MicroMsg.WeCoinRechargeViewModel", "getWecoinPageInfoRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    paramm.wIq.t(Boolean.FALSE);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      paramm = (Long)paramm.Vuq.getValue();
      if (paramm == null) {}
      for (bool = true;; bool = false)
      {
        paramb.invoke(Boolean.valueOf(bool));
        paramm = ah.aiuX;
        AppMethodBeat.o(315814);
        return paramm;
        if (paramm.longValue() != 0L) {
          break;
        }
      }
    }
    if (((cwm)parama.ott).ZoU != 0L) {}
    for (;;)
    {
      paramb.invoke(Boolean.valueOf(bool));
      break;
      bool = false;
    }
  }
  
  public static void asf(int paramInt)
  {
    AppMethodBeat.i(315775);
    com.tencent.mm.plugin.report.service.h.OAn.b(21650, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(315775);
  }
  
  public static boolean ihv()
  {
    AppMethodBeat.i(315783);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acXW, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(315783);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(315783);
    return bool;
  }
  
  public static void ihw()
  {
    AppMethodBeat.i(315791);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXW, Boolean.TRUE);
    AppMethodBeat.o(315791);
  }
  
  public final void aP(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(315867);
    s.u(paramb, "callback");
    this.wIq.t(Boolean.TRUE);
    new j().bFJ().b(new m..ExternalSyntheticLambda1(this, paramb));
    AppMethodBeat.o(315867);
  }
  
  public final void f(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(315852);
    s.u(paramb, "keeper");
    T(1, 0, "");
    new j().bFJ().b(new m..ExternalSyntheticLambda0(this)).a(paramb);
    AppMethodBeat.o(315852);
  }
  
  public final void ihx()
  {
    AppMethodBeat.i(315860);
    this.Vvw.t(Boolean.valueOf(((d)com.tencent.mm.kernel.h.ax(d.class)).ihl()));
    AppMethodBeat.o(315860);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel$initMidasSdkInfo$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i<Boolean>
  {
    public b(m paramm) {}
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(315824);
      m.a(this.Vvx).t(Boolean.FALSE);
      AppMethodBeat.o(315824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.m
 * JD-Core Version:    0.7.0.1
 */