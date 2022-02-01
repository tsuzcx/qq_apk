package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpm;

public final class e
  extends a<cpm>
{
  public e()
  {
    AppMethodBeat.i(68402);
    cpl localcpl = new cpl();
    localcpl.time_stamp = ((int)System.currentTimeMillis());
    localcpl.CPZ = ae.eFT();
    b.a locala = new b.a();
    locala.hQF = localcpl;
    locala.hQG = new cpm();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */