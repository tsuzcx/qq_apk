package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "(Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "plugin-wxpay_release"})
public final class k
  extends l<dep>
{
  private final deo HMG;
  
  public k(deo paramdeo)
  {
    AppMethodBeat.i(212697);
    this.HMG = paramdeo;
    paramdeo = new dep();
    a((dop)this.HMG, (dpc)paramdeo, 6242, "/cgi-bin/micromsg-bin/preparewecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareWecoinRechargeRequest: requestID: " + this.HMG.request_id + ", productID:  " + this.HMG.MJG);
    AppMethodBeat.o(212697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.k
 * JD-Core Version:    0.7.0.1
 */