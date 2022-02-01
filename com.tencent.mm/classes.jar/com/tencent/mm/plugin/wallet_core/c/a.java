package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<xk>
{
  public a(String paramString)
  {
    AppMethodBeat.i(69887);
    b.a locala = new b.a();
    xj localxj = new xj();
    localxj.Gpk = paramString;
    localxj.timestamp = System.currentTimeMillis();
    locala.hQF = localxj;
    locala.hQG = new xk();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */