package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.b.g;
import com.tencent.mm.plugin.wallet.wecoin.utils.c;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "mBusinessID", "", "(I)V", "incomePageInfoResponse", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "getIncomePageInfoResponse", "()Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "isCocertActivate", "", "()Z", "setCocertActivate", "(Z)V", "isShowProgressDialog", "Landroidx/lifecycle/MutableLiveData;", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mFaqUrl", "", "mIncomeBalance", "", "mIncomeBillUrl", "mIncomePageInfoResponse", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mRealNameAuthInfo", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "mRealNameAuthored", "tips", "getTips", "()Ljava/lang/String;", "setTips", "(Ljava/lang/String;)V", "getBusinessID", "getCgiRespInfo", "Landroidx/lifecycle/LiveData;", "getFAQUrl", "getIncomeBalance", "getIncomeBillUrl", "getIncomePageInfoRequest", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getRealNameAuthInfo", "getRealNameAuthRequest", "token", "getRealNameAuthored", "getWeCoinBanner", "initKVData", "kvData", "loadSnapshot", "reportCgiKVStatus", "sessionID", "operationType", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "saveSnapshot", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends af
{
  public static final a VuN;
  public final int VuF;
  public WecoinEncashKVData VuK;
  public x<String> VuO;
  public x<String> VuP;
  public x<Long> VuQ;
  public x<emd> VuR;
  public final x<adz> VuS;
  public final x<Boolean> VuT;
  public clp VuU;
  public boolean VuV;
  public final x<a> Vup;
  public String lym;
  public final x<Boolean> wIq;
  
  static
  {
    AppMethodBeat.i(315836);
    VuN = new a((byte)0);
    AppMethodBeat.o(315836);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(315793);
    this.VuF = paramInt;
    this.VuO = new x();
    this.VuP = new x();
    this.VuQ = new x();
    this.VuR = new x();
    this.VuS = new x();
    this.Vup = new x();
    this.VuT = new x();
    this.wIq = new x();
    this.lym = "";
    AppMethodBeat.o(315793);
  }
  
  private static final ah a(i parami, b.a parama)
  {
    AppMethodBeat.i(315817);
    s.u(parami, "this$0");
    Log.i("MicroMsg.WeCoinIncomeDetailViewModel", "getIncomePageInfoRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      if (parami.VuU == null) {
        parami.Vup.t(new a(parama.errType, parama.errCode, parama.errMsg));
      }
      parami.a("", 9, 3, parama.errCode, parama.errMsg);
      parami = ah.aiuX;
      AppMethodBeat.o(315817);
      return parami;
    }
    if (parama.ott == null)
    {
      if (parami.VuU == null) {
        parami.Vup.t(new a(3, -1, ""));
      }
      parami.a("", 9, 3, 3, "callback resp is null");
      parami = ah.aiuX;
      AppMethodBeat.o(315817);
      return parami;
    }
    parama = (clp)parama.ott;
    if (parama != null)
    {
      c.d("MicroMsg.WeCoinIncomeDetailViewModel", (com.tencent.mm.bx.a)parama);
      parami.VuO.t(parama.aarS);
      parami.VuP.t(parama.aatC);
      parami.VuQ.t(Long.valueOf(parama.aarR));
      parami.VuR.t(parama.aarT);
      parami.VuS.t(parama.aatD);
      parami.VuU = parama;
      parami.a("", 9, 3, 0, "");
      parami = ah.aiuX;
      AppMethodBeat.o(315817);
      return parami;
    }
    parami = ah.aiuX;
    AppMethodBeat.o(315817);
    return parami;
  }
  
  private static final ah a(i parami, String paramString, b.a parama)
  {
    AppMethodBeat.i(315826);
    s.u(parami, "this$0");
    s.u(paramString, "$uniqueId");
    Log.i("MicroMsg.WeCoinIncomeDetailViewModel", "getRealNameAuthRequest errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(parami.wIq, Boolean.FALSE);
    s.s(parama, "cgiBack");
    if (c.o(parama))
    {
      parami.Vup.t(new a(parama.errType, parama.errCode, parama.errMsg));
      parami.a(paramString, 10, 3, parama.errCode, parama.errMsg);
      parami = ah.aiuX;
      AppMethodBeat.o(315826);
      return parami;
    }
    if (parama.ott == null)
    {
      parami.Vup.t(new a(3, -1, ""));
      parami.a(paramString, 10, 3, 3, "callback resp is null");
      parami = ah.aiuX;
      AppMethodBeat.o(315826);
      return parami;
    }
    parami.a(paramString, 10, 3, 0, "");
    parami.VuT.t(Boolean.TRUE);
    parami = ah.aiuX;
    AppMethodBeat.o(315826);
    return parami;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(315802);
    Object localObject1 = this.VuK;
    Object localObject2;
    WecoinEncashKVData localWecoinEncashKVData;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = h.OAn;
      localWecoinEncashKVData = this.VuK;
      if (localWecoinEncashKVData != null) {
        break label128;
      }
    }
    label128:
    for (int i = 1;; i = localWecoinEncashKVData.Vvz)
    {
      ((h)localObject2).b(22129, new Object[] { Integer.valueOf(i), localObject1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
      AppMethodBeat.o(315802);
      return;
      localObject2 = ((WecoinEncashKVData)localObject1).Vua;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  public final void a(String paramString, b<?> paramb)
  {
    AppMethodBeat.i(315869);
    s.u(paramString, "token");
    s.u(paramb, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.TRUE);
    String str = UUID.randomUUID().toString();
    s.s(str, "uuid.toString()");
    a(str, 10, 1, 0, "");
    new g(paramString, str, 1).bFJ().b(new i..ExternalSyntheticLambda1(this, str)).a(paramb);
    AppMethodBeat.o(315869);
  }
  
  public final void asf(int paramInt)
  {
    AppMethodBeat.i(315878);
    Object localObject3 = this.VuK;
    if (localObject3 != null)
    {
      int i = ((WecoinEncashKVData)localObject3).Vvz;
      Object localObject2 = ((WecoinEncashKVData)localObject3).Vua;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((WecoinEncashKVData)localObject3).ugZ;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      h.OAn.b(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
    }
    AppMethodBeat.o(315878);
  }
  
  public final void e(b<?> paramb)
  {
    AppMethodBeat.i(315861);
    s.u(paramb, "keeper");
    a("", 9, 1, 0, "");
    new com.tencent.mm.plugin.wallet.wecoin.b.i().bFJ().b(new i..ExternalSyntheticLambda0(this)).a(paramb);
    AppMethodBeat.o(315861);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.i
 * JD-Core Version:    0.7.0.1
 */