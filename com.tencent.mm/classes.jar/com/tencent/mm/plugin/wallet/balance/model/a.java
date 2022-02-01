package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends c<aps>
{
  public a()
  {
    AppMethodBeat.i(68391);
    b.a locala = new b.a();
    locala.gUU = new apr();
    locala.gUV = new aps();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(68391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.a
 * JD-Core Version:    0.7.0.1
 */