package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.bpw;

public final class l
  extends a<bpw>
{
  private b goo;
  private bpv tMi;
  
  public l()
  {
    AppMethodBeat.i(45238);
    this.tMi = null;
    b.a locala = new b.a();
    locala.fsX = new bpv();
    locala.fsY = new bpw();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.tMi = ((bpv)this.goo.fsV.fta);
    this.tMi.time_stamp = ((int)System.currentTimeMillis());
    this.tMi.tNy = ab.cQT();
    this.rr = locala.ado();
    AppMethodBeat.o(45238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.l
 * JD-Core Version:    0.7.0.1
 */