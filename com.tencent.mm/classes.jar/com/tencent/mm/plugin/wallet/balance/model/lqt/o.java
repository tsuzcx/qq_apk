package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dhn;

public final class o
  extends c<dhn>
{
  private dhm Htv;
  private d hJu;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.Htv = null;
    d.a locala = new d.a();
    locala.iLN = new dhm();
    locala.iLO = new dhn();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.Htv = ((dhm)this.hJu.iLK.iLR);
    this.Htv.time_stamp = ((int)System.currentTimeMillis());
    this.Htv.HuS = ag.fNb();
    c(locala.aXF());
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */