package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiCancelWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "billNo", "", "(Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class a
  extends m<tu>
{
  public a(String paramString)
  {
    AppMethodBeat.i(217303);
    tt localtt = new tt();
    localtt.RDi = paramString;
    tu localtu = new tu();
    a((dyl)localtt, (dyy)localtu, 6233, "/cgi-bin/micromsg-bin/cancelwecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiCancelWecoinRechargeRequest: billNo: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(217303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.a
 * JD-Core Version:    0.7.0.1
 */