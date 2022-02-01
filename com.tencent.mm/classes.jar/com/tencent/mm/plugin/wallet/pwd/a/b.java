package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<cbm>
{
  public b()
  {
    AppMethodBeat.i(69523);
    b.a locala = new b.a();
    locala.hvt = new cbl();
    locala.hvu = new cbm();
    locala.funcId = 2513;
    locala.uri = "/cgi-bin/mmpay-bin/openunipayorder";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
    AppMethodBeat.o(69523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */