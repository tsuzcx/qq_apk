package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dhl;

public final class e
  extends c<dhl>
{
  public e()
  {
    AppMethodBeat.i(68402);
    dhk localdhk = new dhk();
    localdhk.time_stamp = ((int)System.currentTimeMillis());
    localdhk.HuS = ag.fNb();
    d.a locala = new d.a();
    locala.iLN = localdhk;
    locala.iLO = new dhl();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */