package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.fmx;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends b<dqy>
{
  public c(fmx paramfmx)
  {
    AppMethodBeat.i(68400);
    dqx localdqx = new dqx();
    localdqx.aaXa = paramfmx;
    localdqx.time_stamp = ((int)System.currentTimeMillis());
    localdqx.Vbl = ai.ieD();
    c.a locala = new c.a();
    locala.otE = localdqx;
    locala.otF = new dqy();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    if (paramfmx != null) {}
    for (paramfmx = Integer.valueOf(paramfmx.ftu);; paramfmx = "null")
    {
      Log.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramfmx });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */