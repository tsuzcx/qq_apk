package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.protocal.protobuf.drg;

public final class e
  extends c<drg>
{
  public e()
  {
    AppMethodBeat.i(68402);
    drf localdrf = new drf();
    localdrf.time_stamp = ((int)System.currentTimeMillis());
    localdrf.OmF = ah.gFF();
    d.a locala = new d.a();
    locala.lBU = localdrf;
    locala.lBV = new drg();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */