package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends b<adt>
{
  public a()
  {
    AppMethodBeat.i(69522);
    c.a locala = new c.a();
    locala.otE = new ads();
    locala.otF = new adt();
    locala.funcId = 2913;
    locala.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
    AppMethodBeat.o(69522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */