package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.ak.c<dih>
{
  public c()
  {
    AppMethodBeat.i(69524);
    d.a locala = new d.a();
    locala.iLN = new dig();
    locala.iLO = new dih();
    locala.funcId = 2904;
    locala.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
    AppMethodBeat.o(69524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */