package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<yw>
{
  public a(String paramString)
  {
    AppMethodBeat.i(69887);
    d.a locala = new d.a();
    yv localyv = new yv();
    localyv.LjW = paramString;
    localyv.timestamp = System.currentTimeMillis();
    locala.iLN = localyv;
    locala.iLO = new yw();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */