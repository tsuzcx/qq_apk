package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bhm;

public final class g
  extends a<bhm>
{
  private b eWr;
  private bhl qfq = null;
  
  public g()
  {
    b.a locala = new b.a();
    locala.ecH = new bhl();
    locala.ecI = new bhm();
    locala.ecG = 1211;
    locala.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.qfq = ((bhl)this.eWr.ecE.ecN);
    this.qfq.time_stamp = ((int)System.currentTimeMillis());
    this.dmK = locala.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.g
 * JD-Core Version:    0.7.0.1
 */