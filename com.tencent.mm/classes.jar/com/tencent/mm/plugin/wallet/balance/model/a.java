package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<awu>
{
  public a()
  {
    AppMethodBeat.i(68391);
    b.a locala = new b.a();
    locala.hNM = new awt();
    locala.hNN = new awu();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
    locala.funcId = 2567;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
    AppMethodBeat.o(68391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.a
 * JD-Core Version:    0.7.0.1
 */