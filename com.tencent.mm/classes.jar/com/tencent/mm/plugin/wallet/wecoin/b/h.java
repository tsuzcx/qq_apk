package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "()V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends n<cwk>
{
  public h()
  {
    AppMethodBeat.i(315702);
    cwj localcwj = new cwj();
    cwk localcwk = new cwk();
    a((erp)localcwj, (esc)localcwk, 6401, "/cgi-bin/micromsg-bin/getwecoinbalance");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinBalanceRequest: ");
    AppMethodBeat.o(315702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.h
 * JD-Core Version:    0.7.0.1
 */