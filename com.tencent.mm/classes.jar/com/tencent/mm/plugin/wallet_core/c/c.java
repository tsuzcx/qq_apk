package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.al.c<dfi>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    b.a locala = new b.a();
    dfh localdfh = new dfh();
    localdfh.CWQ = paramString;
    localdfh.timestamp = System.currentTimeMillis();
    locala.gUU = localdfh;
    locala.gUV = new dfi();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */