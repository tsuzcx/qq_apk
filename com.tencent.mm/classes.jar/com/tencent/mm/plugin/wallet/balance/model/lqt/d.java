package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends c<cwy>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    cwx localcwx = new cwx();
    localcwx.time_stamp = ((int)System.currentTimeMillis());
    localcwx.Lmm = paramString;
    localcwx.HuS = ag.fNb();
    d.a locala = new d.a();
    locala.iLN = localcwx;
    locala.iLO = new cwy();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */