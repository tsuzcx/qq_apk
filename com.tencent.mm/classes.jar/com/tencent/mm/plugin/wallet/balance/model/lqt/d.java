package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends c<dgi>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    dgh localdgh = new dgh();
    localdgh.time_stamp = ((int)System.currentTimeMillis());
    localdgh.SnA = paramString;
    localdgh.OmF = ah.gFF();
    d.a locala = new d.a();
    locala.lBU = localdgh;
    locala.lBV = new dgi();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    Log.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */