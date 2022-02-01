package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a<dqo>
{
  public c(String paramString)
  {
    AppMethodBeat.i(69889);
    b.a locala = new b.a();
    dqn localdqn = new dqn();
    localdqn.FWL = paramString;
    localdqn.timestamp = System.currentTimeMillis();
    locala.hNM = localdqn;
    locala.hNN = new dqo();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */