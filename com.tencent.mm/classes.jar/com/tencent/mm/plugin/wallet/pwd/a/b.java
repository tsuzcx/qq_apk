package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<cxe>
{
  public b()
  {
    AppMethodBeat.i(69523);
    d.a locala = new d.a();
    locala.iLN = new cxd();
    locala.iLO = new cxe();
    locala.funcId = 2513;
    locala.uri = "/cgi-bin/mmpay-bin/openunipayorder";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
    AppMethodBeat.o(69523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */