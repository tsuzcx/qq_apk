package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.ak.c<cra>
{
  public c(ehn paramehn)
  {
    AppMethodBeat.i(68400);
    cqz localcqz = new cqz();
    localcqz.Mwt = paramehn;
    localcqz.time_stamp = ((int)System.currentTimeMillis());
    localcqz.HuS = ag.fNb();
    d.a locala = new d.a();
    locala.iLN = localcqz;
    locala.iLO = new cra();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    if (paramehn != null) {}
    for (paramehn = Integer.valueOf(paramehn.Nhb);; paramehn = "null")
    {
      Log.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramehn });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */