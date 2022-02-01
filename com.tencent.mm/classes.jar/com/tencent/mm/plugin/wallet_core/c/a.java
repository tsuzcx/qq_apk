package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<vi>
{
  public a(String paramString)
  {
    AppMethodBeat.i(69887);
    b.a locala = new b.a();
    vh localvh = new vh();
    localvh.Epz = paramString;
    localvh.timestamp = System.currentTimeMillis();
    locala.hvt = localvh;
    locala.hvu = new vi();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */