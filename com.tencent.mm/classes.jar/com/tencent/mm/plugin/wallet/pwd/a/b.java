package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<cgx>
{
  public b()
  {
    AppMethodBeat.i(69523);
    b.a locala = new b.a();
    locala.hQF = new cgw();
    locala.hQG = new cgx();
    locala.funcId = 2513;
    locala.uri = "/cgi-bin/mmpay-bin/openunipayorder";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
    AppMethodBeat.o(69523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */