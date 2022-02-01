package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.ak.c<dkx>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    b.a locala = new b.a();
    dkw localdkw = new dkw();
    localdkw.Epz = paramString;
    localdkw.timestamp = System.currentTimeMillis();
    locala.hvt = localdkw;
    locala.hvu = new dkx();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */