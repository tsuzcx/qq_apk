package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "(Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "plugin-wxpay_release"})
public final class l
  extends m<dof>
{
  private final doe OEC;
  
  public l(doe paramdoe)
  {
    AppMethodBeat.i(194632);
    this.OEC = paramdoe;
    paramdoe = new dof();
    a((dyl)this.OEC, (dyy)paramdoe, 6242, "/cgi-bin/micromsg-bin/preparewecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareWecoinRechargeRequest: requestID: " + this.OEC.request_id + ", productID:  " + this.OEC.TVv);
    AppMethodBeat.o(194632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.l
 * JD-Core Version:    0.7.0.1
 */