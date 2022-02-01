package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "(Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends n<egw>
{
  private final egv Vuh;
  
  public m(egv paramegv)
  {
    AppMethodBeat.i(315693);
    this.Vuh = paramegv;
    paramegv = new egw();
    a((erp)this.Vuh, (esc)paramegv, 6242, "/cgi-bin/micromsg-bin/preparewecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareWecoinRechargeRequest: requestID: " + this.Vuh.request_id + ", productID:  " + this.Vuh.abmh);
    AppMethodBeat.o(315693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.m
 * JD-Core Version:    0.7.0.1
 */