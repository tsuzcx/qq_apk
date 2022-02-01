package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<xh>
{
  public a(String paramString)
  {
    AppMethodBeat.i(69887);
    b.a locala = new b.a();
    xg localxg = new xg();
    localxg.FWL = paramString;
    localxg.timestamp = System.currentTimeMillis();
    locala.hNM = localxg;
    locala.hNN = new xh();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */