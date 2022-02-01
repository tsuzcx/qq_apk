package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<axk>
{
  public a()
  {
    AppMethodBeat.i(68391);
    b.a locala = new b.a();
    locala.hQF = new axj();
    locala.hQG = new axk();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(68391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.a
 * JD-Core Version:    0.7.0.1
 */