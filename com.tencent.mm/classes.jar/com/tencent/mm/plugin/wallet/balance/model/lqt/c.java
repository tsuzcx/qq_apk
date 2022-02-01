package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.dns;

public final class c
  extends a<cby>
{
  public c(dns paramdns)
  {
    AppMethodBeat.i(68400);
    cbx localcbx = new cbx();
    localcbx.HoY = paramdns;
    localcbx.time_stamp = ((int)System.currentTimeMillis());
    localcbx.CPZ = ae.eFT();
    b.a locala = new b.a();
    locala.hQF = localcbx;
    locala.hQG = new cby();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    if (paramdns != null) {}
    for (paramdns = Integer.valueOf(paramdns.HUR);; paramdns = "null")
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramdns });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */