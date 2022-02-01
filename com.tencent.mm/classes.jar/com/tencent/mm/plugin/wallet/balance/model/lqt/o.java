package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.protocal.protobuf.dri;

public final class o
  extends c<dri>
{
  private drh Olg;
  private d kwO;
  
  public o()
  {
    AppMethodBeat.i(68451);
    this.Olg = null;
    d.a locala = new d.a();
    locala.lBU = new drh();
    locala.lBV = new dri();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.Olg = ((drh)d.b.b(this.kwO.lBR));
    this.Olg.time_stamp = ((int)System.currentTimeMillis());
    this.Olg.OmF = ah.gFF();
    c(locala.bgN());
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.o
 * JD-Core Version:    0.7.0.1
 */