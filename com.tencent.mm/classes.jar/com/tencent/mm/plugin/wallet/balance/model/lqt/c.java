package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.an.c<czr>
{
  public c(erp paramerp)
  {
    AppMethodBeat.i(68400);
    czq localczq = new czq();
    localczq.THr = paramerp;
    localczq.time_stamp = ((int)System.currentTimeMillis());
    localczq.OmF = ah.gFF();
    d.a locala = new d.a();
    locala.lBU = localczq;
    locala.lBV = new czr();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    if (paramerp != null) {}
    for (paramerp = Integer.valueOf(paramerp.dte);; paramerp = "null")
    {
      Log.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramerp });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */