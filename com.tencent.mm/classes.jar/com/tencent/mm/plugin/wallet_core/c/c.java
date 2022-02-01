package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.elg;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.ak.c<elh>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    d.a locala = new d.a();
    elg localelg = new elg();
    localelg.LjW = paramString;
    localelg.timestamp = System.currentTimeMillis();
    locala.iLN = localelg;
    locala.iLO = new elh();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */