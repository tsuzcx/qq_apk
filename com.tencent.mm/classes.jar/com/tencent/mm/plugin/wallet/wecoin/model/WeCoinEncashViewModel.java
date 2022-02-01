package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.b.c;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCtxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "mEncashResultPageInfo", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "mInterceptPopUp", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mLastFetchAccount", "", "mUniqueId", "", "wxTokenParams", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "encashIncome", "", "token", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getEncashResultPageInfo", "getInterceptPopUp", "getLastFetchAccount", "getWXTokenParams", "initKVData", "kvData", "prepareWecoinEncash", "amount", "reportCgiKVStatus", "operationType", "", "stepID", "errorCode", "errorMsg", "reportKVStatus", "value", "Companion", "plugin-wxpay_release"})
public final class WeCoinEncashViewModel
  extends ViewModel
{
  public static final WeCoinEncashViewModel.a HNn;
  public final MutableLiveData<a> HMQ;
  public final MutableLiveData<dek> HMS;
  public final MutableLiveData<fbz> HNi;
  public final MutableLiveData<ajj> HNj;
  public long HNk;
  private com.tencent.mm.bw.b HNl;
  public WecoinEncashKVData HNm;
  public final MutableLiveData<Boolean> qiR;
  public String zfX;
  
  static
  {
    AppMethodBeat.i(212721);
    HNn = new WeCoinEncashViewModel.a((byte)0);
    AppMethodBeat.o(212721);
  }
  
  public WeCoinEncashViewModel()
  {
    AppMethodBeat.i(212720);
    this.HNi = new MutableLiveData();
    this.HMQ = new MutableLiveData();
    this.HNj = new MutableLiveData();
    this.HMS = new MutableLiveData();
    this.qiR = new MutableLiveData();
    AppMethodBeat.o(212720);
  }
  
  public final void a(final String paramString, final com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(212717);
    p.h(paramString, "token");
    p.h(paramb, "keeper");
    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.TRUE);
    f(7, 1, 0, "");
    h.CyF.dN(1581, 96);
    if (this.HNl == null)
    {
      Log.i("MicroMsg.WeCoinEncashViewModel", "mCtxBuff is null!");
      com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.FALSE);
      this.HMQ.postValue(new a(3, -1, ""));
      h.CyF.dN(1581, 98);
      f(7, 3, -1, "mCtxBuff is null");
      AppMethodBeat.o(212717);
      return;
    }
    Object localObject2 = com.tencent.mm.network.b.bjq();
    Object localObject1 = this.HNl;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).zy;; localObject1 = null)
    {
      localObject1 = ((com.tencent.mm.network.b)localObject2).az((byte[])localObject1);
      if (localObject1 != null) {
        break;
      }
      Log.i("MicroMsg.WeCoinEncashViewModel", "signedByte is null!");
      com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.FALSE);
      this.HMQ.postValue(new a(3, 4, ""));
      f(7, 3, 4, "sign data failed");
      h.CyF.dN(1581, 98);
      h.CyF.dN(1581, 100);
      AppMethodBeat.o(212717);
      return;
    }
    localObject2 = this.HNl;
    if (localObject2 == null) {
      p.hyc();
    }
    new c(paramString, (com.tencent.mm.bw.b)localObject2, new com.tencent.mm.bw.b((byte[])localObject1)).aYI().b((com.tencent.mm.vending.c.a)new b(this, paramString, paramb)).a(paramb);
    AppMethodBeat.o(212717);
  }
  
  public final void aeH(int paramInt)
  {
    AppMethodBeat.i(212718);
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
      AppMethodBeat.o(212718);
      return;
    }
    AppMethodBeat.o(212718);
  }
  
  public final void f(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(212719);
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
      localh.a(22129, new Object[] { localObject2, localObject1, this.zfX, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(212719);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(WeCoinEncashViewModel paramWeCoinEncashViewModel, String paramString, com.tencent.mm.vending.e.b paramb) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel$encashIncome$1$1$1"})
    static final class a
      implements Runnable
    {
      a(WeCoinEncashViewModel.b paramb, c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(212714);
        this.HNr.HNo.a(this.HNr.HNp, this.HNr.HNq);
        AppMethodBeat.o(212714);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(WeCoinEncashViewModel paramWeCoinEncashViewModel) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.WeCoinEncashViewModel
 * JD-Core Version:    0.7.0.1
 */