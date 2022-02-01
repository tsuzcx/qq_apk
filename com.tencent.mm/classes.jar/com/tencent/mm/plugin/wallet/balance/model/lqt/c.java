package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a<cbe>
{
  public c(dmv paramdmv)
  {
    AppMethodBeat.i(68400);
    cbd localcbd = new cbd();
    localcbd.GVx = paramdmv;
    localcbd.time_stamp = ((int)System.currentTimeMillis());
    localcbd.Cyu = ae.eCl();
    b.a locala = new b.a();
    locala.hNM = localcbd;
    locala.hNN = new cbe();
    locala.funcId = 1640;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    if (paramdmv != null) {}
    for (paramdmv = Integer.valueOf(paramdmv.HBe);; paramdmv = "null")
    {
      ad.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", new Object[] { paramdmv });
      AppMethodBeat.o(68400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.c
 * JD-Core Version:    0.7.0.1
 */