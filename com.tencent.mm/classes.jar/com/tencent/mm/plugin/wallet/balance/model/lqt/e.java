package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.wallet_core.model.z;

public final class e
  extends z<ekb>
{
  public e()
  {
    AppMethodBeat.i(68402);
    eka localeka = new eka();
    localeka.time_stamp = ((int)System.currentTimeMillis());
    localeka.Vbl = ai.ieD();
    c.a locala = new c.a();
    locala.otE = localeka;
    locala.otF = new ekb();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */