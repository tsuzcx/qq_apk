package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<abk>
{
  public a()
  {
    AppMethodBeat.i(69522);
    d.a locala = new d.a();
    locala.iLN = new abj();
    locala.iLO = new abk();
    locala.funcId = 2913;
    locala.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
    AppMethodBeat.o(69522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */