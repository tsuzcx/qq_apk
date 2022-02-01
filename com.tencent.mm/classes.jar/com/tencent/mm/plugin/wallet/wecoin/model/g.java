package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.wallet.wecoin.b.l;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.esh;
import com.tencent.mm.protocal.protobuf.gim;
import com.tencent.mm.protocal.protobuf.gjo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "Landroidx/lifecycle/ViewModel;", "entranceInfoData", "", "mBusinessID", "", "([BI)V", "_cutTaxEntranceInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/WecoinTaxCutEntranceInfo;", "cutTaxEntranceInfo", "Landroidx/lifecycle/LiveData;", "getCutTaxEntranceInfo", "()Landroidx/lifecycle/LiveData;", "isShowProgressDialog", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCtxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "mEncashResultPageInfo", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "mInterceptPopUp", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mLastFetchAccount", "", "mUniqueId", "", "wxTokenParams", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "encashIncome", "", "token", "agentId", "action", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getBusinessID", "getCgiRespInfo", "getEncashResultPageInfo", "getInterceptPopUp", "getLastFetchAccount", "getWXTokenParams", "initKVData", "kvData", "prepareWecoinEncash", "businessID", "amount", "reportCgiKVStatus", "operationType", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends af
{
  public static final a VuE;
  private String KFd;
  public final int VuF;
  public final x<gjo> VuG;
  public final x<anu> VuH;
  public long VuI;
  private com.tencent.mm.bx.b VuJ;
  public WecoinEncashKVData VuK;
  public final x<gim> VuL;
  public final x<a> Vup;
  public final x<egr> Vur;
  public final x<Boolean> wIq;
  
  static
  {
    AppMethodBeat.i(315851);
    VuE = new a((byte)0);
    AppMethodBeat.o(315851);
  }
  
  public g(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(315796);
    this.VuF = paramInt;
    this.VuG = new x();
    this.Vup = new x();
    this.VuH = new x();
    this.Vur = new x();
    this.wIq = new x();
    this.VuL = new x();
    com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new gim();
    try
    {
      locala.parseFrom(paramArrayOfByte);
      paramArrayOfByte = locala;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
        paramArrayOfByte = null;
      }
    }
    paramArrayOfByte = (gim)paramArrayOfByte;
    this.VuL.t(paramArrayOfByte);
    AppMethodBeat.o(315796);
  }
  
  private static final ah a(g paramg, b.a parama)
  {
    AppMethodBeat.i(315819);
    s.u(paramg, "this$0");
    Log.i("MicroMsg.WeCoinEncashViewModel", "prepareWecoinEncash errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(paramg.wIq, Boolean.FALSE);
    s.s(parama, "cgiBack");
    if (com.tencent.mm.plugin.wallet.wecoin.utils.c.o(parama))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 92);
      Object localObject = (egr)parama.ott;
      if (localObject != null)
      {
        localObject = ((egr)localObject).ablX;
        if (localObject != null)
        {
          esc localesc = parama.ott;
          s.s(localesc, "cgiBack.resp");
          com.tencent.mm.plugin.wallet.wecoin.utils.c.d("MicroMsg.WeCoinEncashViewModel", (com.tencent.mm.bx.a)localesc);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 99);
          paramg.Vur.t(parama.ott);
          paramg.h(6, 3, parama.errCode, ((dcl)localObject).wording);
          paramg = ah.aiuX;
          AppMethodBeat.o(315819);
          return paramg;
        }
      }
      paramg.Vup.t(new a(parama.errType, parama.errCode, parama.errMsg));
      paramg.h(6, 3, parama.errCode, parama.errMsg);
      paramg = ah.aiuX;
      AppMethodBeat.o(315819);
      return paramg;
    }
    if (parama.ott == null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 92);
      paramg.Vup.t(new a(3, -1, ""));
      paramg.h(6, 3, 3, "callback resp is null");
      paramg = ah.aiuX;
      AppMethodBeat.o(315819);
      return paramg;
    }
    parama = (egr)parama.ott;
    if (parama != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 91);
      com.tencent.mm.plugin.wallet.wecoin.utils.c.d("MicroMsg.WeCoinEncashViewModel", (com.tencent.mm.bx.a)parama);
      paramg.VuJ = parama.ZoR;
      paramg.VuG.t(parama.ablW);
      paramg.h(6, 3, 0, "");
    }
    paramg = ah.aiuX;
    AppMethodBeat.o(315819);
    return paramg;
  }
  
  private static final ah a(g paramg, String paramString1, String paramString2, int paramInt, com.tencent.mm.vending.e.b paramb, b.a parama)
  {
    AppMethodBeat.i(315844);
    s.u(paramg, "this$0");
    s.u(paramString1, "$token");
    s.u(paramb, "$keeper");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(paramg.wIq, Boolean.FALSE);
    Log.i("MicroMsg.WeCoinEncashViewModel", "encashIncome errorType: " + parama.errType + ", errorCode: " + parama.errCode + ", errorMsg: " + parama.errMsg);
    s.s(parama, "cgiBack");
    if (com.tencent.mm.plugin.wallet.wecoin.utils.c.p(parama))
    {
      paramg.h(7, 3, parama.errCode, parama.errMsg);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 98);
      if (parama.errCode == 10001)
      {
        Object localObject = (ans)parama.ott;
        if (localObject != null)
        {
          localObject = ((ans)localObject).ZoV;
          if (localObject != null)
          {
            parama = parama.ott;
            s.s(parama, "cgiBack.resp");
            com.tencent.mm.plugin.wallet.wecoin.utils.c.d("MicroMsg.WeCoinEncashViewModel", (com.tencent.mm.bx.a)parama);
            com.tencent.threadpool.h.ahAA.p(new g..ExternalSyntheticLambda2(paramg, paramString1, paramString2, paramInt, paramb), ((esh)localObject).abvV);
            paramg = ah.aiuX;
            AppMethodBeat.o(315844);
            return paramg;
          }
        }
      }
      paramg.Vup.t(new a(parama.errType, parama.errCode, parama.errMsg, parama.ott));
      paramg = ah.aiuX;
      AppMethodBeat.o(315844);
      return paramg;
    }
    if (parama.ott == null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 98);
      paramg.Vup.t(new a(3, -1, ""));
      paramg.h(7, 3, -1, "callback resp is null");
      paramg = ah.aiuX;
      AppMethodBeat.o(315844);
      return paramg;
    }
    paramString1 = (ans)parama.ott;
    if (paramString1 != null)
    {
      paramg.h(7, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 97);
      com.tencent.mm.plugin.wallet.wecoin.utils.c.d("MicroMsg.WeCoinEncashViewModel", (com.tencent.mm.bx.a)paramString1);
      paramg.VuH.t(paramString1.Zvq);
      paramg = ah.aiuX;
      AppMethodBeat.o(315844);
      return paramg;
    }
    paramg = ah.aiuX;
    AppMethodBeat.o(315844);
    return paramg;
  }
  
  private static final void a(g paramg, String paramString1, String paramString2, int paramInt, com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(315828);
    s.u(paramg, "this$0");
    s.u(paramString1, "$token");
    s.u(paramb, "$keeper");
    paramg.a(paramString1, paramString2, paramInt, paramb);
    AppMethodBeat.o(315828);
  }
  
  private final void h(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(315807);
    Object localObject1 = this.VuK;
    Object localObject2;
    WecoinEncashKVData localWecoinEncashKVData;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
      localWecoinEncashKVData = this.VuK;
      if (localWecoinEncashKVData != null) {
        break label130;
      }
    }
    label130:
    for (int i = 1;; i = localWecoinEncashKVData.Vvz)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(22129, new Object[] { Integer.valueOf(i), localObject1, this.KFd, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(315807);
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
  
  public final void a(int paramInt, long paramLong, com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(315886);
    s.u(paramb, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.TRUE);
    String str2 = com.tencent.mm.plugin.wallet.wecoin.utils.c.ihq();
    this.KFd = str2;
    this.VuI = paramLong;
    Object localObject = this.VuK;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      h(6, 1, 0, "");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 90);
      new l(str2, (String)localObject, paramInt, paramLong).bFJ().b(new g..ExternalSyntheticLambda0(this)).a(paramb);
      AppMethodBeat.o(315886);
      return;
      String str1 = ((WecoinEncashKVData)localObject).ugZ;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(315899);
    s.u(paramString1, "token");
    s.u(paramb, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.TRUE);
    h(7, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 96);
    if (this.VuJ == null)
    {
      Log.i("MicroMsg.WeCoinEncashViewModel", "mCtxBuff is null!");
      com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.FALSE);
      this.Vup.t(new a(3, -1, ""));
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 98);
      h(7, 3, -1, "mCtxBuff is null");
      AppMethodBeat.o(315899);
      return;
    }
    Object localObject2 = com.tencent.mm.network.b.bQD();
    Object localObject1 = this.VuJ;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
    {
      localObject1 = ((com.tencent.mm.network.b)localObject2).aK((byte[])localObject1);
      if (localObject1 != null) {
        break;
      }
      Log.i("MicroMsg.WeCoinEncashViewModel", "signedByte is null!");
      com.tencent.mm.plugin.wallet.wecoin.utils.a.b(this.wIq, Boolean.FALSE);
      this.Vup.t(new a(3, 4, ""));
      h(7, 3, 4, "sign data failed");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 98);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 100);
      AppMethodBeat.o(315899);
      return;
    }
    localObject2 = this.VuJ;
    s.checkNotNull(localObject2);
    new com.tencent.mm.plugin.wallet.wecoin.b.c(paramString1, (com.tencent.mm.bx.b)localObject2, new com.tencent.mm.bx.b((byte[])localObject1), paramString2, paramInt).bFJ().b(new g..ExternalSyntheticLambda1(this, paramString1, paramString2, paramInt, paramb)).a(paramb);
    AppMethodBeat.o(315899);
  }
  
  public final void asf(int paramInt)
  {
    AppMethodBeat.i(315906);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
    }
    AppMethodBeat.o(315906);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.g
 * JD-Core Version:    0.7.0.1
 */