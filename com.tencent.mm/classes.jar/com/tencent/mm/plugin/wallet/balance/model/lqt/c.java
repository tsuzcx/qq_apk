package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.al.c<brx>
{
  public c(dbu paramdbu)
  {
    AppMethodBeat.i(68400);
    brw localbrw = new brw();
    localbrw.DPx = paramdbu;
    localbrw.time_stamp = ((int)System.currentTimeMillis());
    localbrw.zFY = ae.dYR();
    b.a locala = new b.a();
    locala.gUU = localbrw;
    locala.gUV = new brx();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    if (paramdbu != null) {}
    for (paramdbu = Integer.valueOf(paramdbu.Etx);; paramdbu = "null")
    {
      ad.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramdbu });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */