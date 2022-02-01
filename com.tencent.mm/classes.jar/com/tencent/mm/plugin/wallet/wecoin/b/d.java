package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetIncomeBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetIncomeBalanceResponse;", "()V", "plugin-wxpay_release"})
public final class d
  extends m<bwk>
{
  public d()
  {
    AppMethodBeat.i(251716);
    bwj localbwj = new bwj();
    bwk localbwk = new bwk();
    a((dyl)localbwj, (dyy)localbwk, 4032, "/cgi-bin/micromsg-bin/getincomebalance");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetIncomeBalanceRequest: ");
    AppMethodBeat.o(251716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.d
 * JD-Core Version:    0.7.0.1
 */