package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class d
  extends z<dyp>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    dyo localdyo = new dyo();
    localdyo.time_stamp = ((int)System.currentTimeMillis());
    localdyo.ZlW = paramString;
    localdyo.Vbl = ai.ieD();
    c.a locala = new c.a();
    locala.otE = localdyo;
    locala.otF = new dyp();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */