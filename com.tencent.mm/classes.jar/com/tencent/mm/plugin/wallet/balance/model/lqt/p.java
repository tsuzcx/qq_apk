package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.wallet_core.model.z;

public final class p
  extends z<ekd>
{
  private ekc UZJ;
  private c nao;
  
  public p()
  {
    AppMethodBeat.i(68451);
    this.UZJ = null;
    c.a locala = new c.a();
    locala.otE = new ekc();
    locala.otF = new ekd();
    locala.funcId = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.UZJ = ((ekc)c.b.b(this.nao.otB));
    this.UZJ.time_stamp = ((int)System.currentTimeMillis());
    this.UZJ.Vbl = ai.ieD();
    c(locala.bEF());
    AppMethodBeat.o(68451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */