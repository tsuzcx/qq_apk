package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<asw>
{
  public a()
  {
    AppMethodBeat.i(68391);
    b.a locala = new b.a();
    locala.hvt = new asv();
    locala.hvu = new asw();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(68391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.a
 * JD-Core Version:    0.7.0.1
 */