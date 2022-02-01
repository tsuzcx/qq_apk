package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.ak.c<bwo>
{
  public c(dhg paramdhg)
  {
    AppMethodBeat.i(68400);
    bwn localbwn = new bwn();
    localbwn.FlO = paramdhg;
    localbwn.time_stamp = ((int)System.currentTimeMillis());
    localbwn.AYl = ae.eon();
    b.a locala = new b.a();
    locala.hvt = localbwn;
    locala.hvu = new bwo();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    if (paramdhg != null) {}
    for (paramdhg = Integer.valueOf(paramdhg.FQz);; paramdhg = "null")
    {
      ac.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramdhg });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */