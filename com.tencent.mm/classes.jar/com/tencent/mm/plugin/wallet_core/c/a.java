package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<za>
{
  public a(String paramString)
  {
    AppMethodBeat.i(69887);
    d.a locala = new d.a();
    yz localyz = new yz();
    localyz.Sld = paramString;
    localyz.timestamp = System.currentTimeMillis();
    locala.lBU = localyz;
    locala.lBV = new za();
    locala.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
    locala.funcId = 2553;
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    Log.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(69887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */