package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<zu>
{
  public a()
  {
    AppMethodBeat.i(69522);
    b.a locala = new b.a();
    locala.hQF = new zt();
    locala.hQG = new zu();
    locala.funcId = 2913;
    locala.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
    AppMethodBeat.o(69522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */