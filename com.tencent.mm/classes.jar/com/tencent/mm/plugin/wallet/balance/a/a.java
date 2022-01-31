package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.ai.a<agl>
{
  public a()
  {
    AppMethodBeat.i(45219);
    b.a locala = new b.a();
    locala.fsX = new agk();
    locala.fsY = new agl();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(45219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a
 * JD-Core Version:    0.7.0.1
 */