package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.ai.a<sg>
{
  public a(String paramString)
  {
    AppMethodBeat.i(142390);
    b.a locala = new b.a();
    sf localsf = new sf();
    localsf.wKD = paramString;
    localsf.timestamp = System.currentTimeMillis();
    locala.fsX = localsf;
    locala.fsY = new sg();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(142390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */