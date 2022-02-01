package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;

public final class o
  extends a<cou>
{
  private cot Cxa;
  private b gPp;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.Cxa = null;
    b.a locala = new b.a();
    locala.hNM = new cot();
    locala.hNN = new cou();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.Cxa = ((cot)this.gPp.hNK.hNQ);
    this.Cxa.time_stamp = ((int)System.currentTimeMillis());
    this.Cxa.Cyu = ae.eCl();
    c(locala.aDC());
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */