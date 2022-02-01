package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetIncomeBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetIncomeBalanceResponse;", "()V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends n<cln>
{
  public e()
  {
    AppMethodBeat.i(315700);
    clm localclm = new clm();
    cln localcln = new cln();
    a((erp)localclm, (esc)localcln, 4032, "/cgi-bin/micromsg-bin/getincomebalance");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetIncomeBalanceRequest: ");
    AppMethodBeat.o(315700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.e
 * JD-Core Version:    0.7.0.1
 */