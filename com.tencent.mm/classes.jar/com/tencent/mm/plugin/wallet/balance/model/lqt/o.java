package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;

public final class o
  extends c<cer>
{
  private b iaa;
  private ceq zEE;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.zEE = null;
    b.a locala = new b.a();
    locala.gUU = new ceq();
    locala.gUV = new cer();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.zEE = ((ceq)this.iaa.gUS.gUX);
    this.zEE.time_stamp = ((int)System.currentTimeMillis());
    this.zEE.zFY = ae.dYR();
    this.rr = locala.atI();
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */