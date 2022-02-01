package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "()V", "plugin-wxpay_release"})
public final class g
  extends m<cgh>
{
  public g()
  {
    AppMethodBeat.i(274026);
    cgg localcgg = new cgg();
    cgh localcgh = new cgh();
    a((dyl)localcgg, (dyy)localcgh, 6401, "/cgi-bin/micromsg-bin/getwecoinbalance");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinBalanceRequest: ");
    AppMethodBeat.o(274026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.g
 * JD-Core Version:    0.7.0.1
 */