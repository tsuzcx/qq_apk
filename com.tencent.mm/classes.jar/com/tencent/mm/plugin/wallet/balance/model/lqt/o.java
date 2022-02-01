package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.cju;

public final class o
  extends c<cju>
{
  private cjt AWR;
  private b gvE;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.AWR = null;
    b.a locala = new b.a();
    locala.hvt = new cjt();
    locala.hvu = new cju();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.AWR = ((cjt)this.gvE.hvr.hvw);
    this.AWR.time_stamp = ((int)System.currentTimeMillis());
    this.AWR.AYl = ae.eon();
    this.rr = locala.aAz();
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */