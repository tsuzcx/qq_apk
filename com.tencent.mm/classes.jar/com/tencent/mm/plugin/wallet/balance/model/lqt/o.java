package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;

public final class o
  extends a<cpo>
{
  private cpn COF;
  private b gRX;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.COF = null;
    b.a locala = new b.a();
    locala.hQF = new cpn();
    locala.hQG = new cpo();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.COF = ((cpn)this.gRX.hQD.hQJ);
    this.COF.time_stamp = ((int)System.currentTimeMillis());
    this.COF.CPZ = ae.eFT();
    c(locala.aDS());
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */