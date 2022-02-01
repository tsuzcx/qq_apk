package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a<drl>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    b.a locala = new b.a();
    drk localdrk = new drk();
    localdrk.Gpk = paramString;
    localdrk.timestamp = System.currentTimeMillis();
    locala.hQF = localdrk;
    locala.hQG = new drl();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */