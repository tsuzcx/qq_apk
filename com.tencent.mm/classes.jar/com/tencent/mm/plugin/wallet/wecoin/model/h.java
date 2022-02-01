package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.wallet.wecoin.b.c;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.fmw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroidx/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCtxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "mEncashResultPageInfo", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "mInterceptPopUp", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mLastFetchAccount", "", "mUniqueId", "", "wxTokenParams", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "encashIncome", "", "token", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCgiRespInfo", "Landroidx/lifecycle/LiveData;", "getEncashResultPageInfo", "getInterceptPopUp", "getLastFetchAccount", "getWXTokenParams", "initKVData", "kvData", "prepareWecoinEncash", "amount", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "Companion", "plugin-wxpay_release"})
public final class h
  extends x
{
  public static final h.a OFj;
  public String ELa;
  public final r<a> OEM;
  public final r<doa> OEO;
  public final r<fmw> OFe;
  public final r<akk> OFf;
  public long OFg;
  private com.tencent.mm.cd.b OFh;
  public WecoinEncashKVData OFi;
  public final r<Boolean> tEN;
  
  static
  {
    AppMethodBeat.i(277116);
    OFj = new h.a((byte)0);
    AppMethodBeat.o(277116);
  }
  
  public h()
  {
    AppMethodBeat.i(277115);
    this.OFe = new r();
    this.OEM = new r();
    this.OFf = new r();
    this.OEO = new r();
    this.tEN = new r();
    AppMethodBeat.o(277115);
  }
  
  public final void a(final String paramString, final com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(277107);
    p.k(paramString, "token");
    p.k(paramb, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.tEN, Boolean.TRUE);
    e(7, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.IzE.el(1581, 96);
    if (this.OFh == null)
    {
      Log.i("MicroMsg.WeCoinEncashViewModel", "mCtxBuff is null!");
      com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.tEN, Boolean.FALSE);
      this.OEM.L(new a(3, -1, ""));
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 98);
      e(7, 3, -1, "mCtxBuff is null");
      AppMethodBeat.o(277107);
      return;
    }
    Object localObject2 = com.tencent.mm.network.b.bsU();
    Object localObject1 = this.OFh;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.cd.b)localObject1).UH;; localObject1 = null)
    {
      localObject1 = ((com.tencent.mm.network.b)localObject2).aK((byte[])localObject1);
      if (localObject1 != null) {
        break;
      }
      Log.i("MicroMsg.WeCoinEncashViewModel", "signedByte is null!");
      com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.tEN, Boolean.FALSE);
      this.OEM.L(new a(3, 4, ""));
      e(7, 3, 4, "sign data failed");
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 98);
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 100);
      AppMethodBeat.o(277107);
      return;
    }
    localObject2 = this.OFh;
    if (localObject2 == null) {
      p.iCn();
    }
    new c(paramString, (com.tencent.mm.cd.b)localObject2, new com.tencent.mm.cd.b((byte[])localObject1)).bhW().b((com.tencent.mm.vending.c.a)new b(this, paramString, paramb)).a(paramb);
    AppMethodBeat.o(277107);
  }
  
  public final void amu(int paramInt)
  {
    AppMethodBeat.i(277110);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(21655, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(paramInt), localObject2 });
      AppMethodBeat.o(277110);
      return;
    }
    AppMethodBeat.o(277110);
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(277112);
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
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    Object localObject2 = this.OFi;
    if (localObject2 != null) {}
    for (localObject2 = Integer.valueOf(((WecoinEncashKVData)localObject2).OFV);; localObject2 = Integer.valueOf(1))
    {
      localh.a(22129, new Object[] { localObject2, localObject1, this.ELa, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(277112);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(h paramh, String paramString, com.tencent.mm.vending.e.b paramb) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel$encashIncome$1$1$1"})
    static final class a
      implements Runnable
    {
      a(h.b paramb, c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(215557);
        this.OFn.OFk.a(this.OFn.OFl, this.OFn.OFm);
        AppMethodBeat.o(215557);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.h
 * JD-Core Version:    0.7.0.1
 */