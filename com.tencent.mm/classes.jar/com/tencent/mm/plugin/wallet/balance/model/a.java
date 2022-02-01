package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<ceu>
{
  public a()
  {
    AppMethodBeat.i(68391);
    c.a locala = new c.a();
    locala.otE = new cet();
    locala.otF = new ceu();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(68391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.a
 * JD-Core Version:    0.7.0.1
 */