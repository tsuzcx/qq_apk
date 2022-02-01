package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends b<eku>
{
  public c()
  {
    AppMethodBeat.i(69524);
    c.a locala = new c.a();
    locala.otE = new ekt();
    locala.otF = new eku();
    locala.funcId = 2904;
    locala.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
    AppMethodBeat.o(69524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */