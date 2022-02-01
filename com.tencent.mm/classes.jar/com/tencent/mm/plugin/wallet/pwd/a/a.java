package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<xs>
{
  public a()
  {
    AppMethodBeat.i(69522);
    b.a locala = new b.a();
    locala.hvt = new xr();
    locala.hvu = new xs();
    locala.funcId = 2913;
    locala.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
    AppMethodBeat.o(69522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */