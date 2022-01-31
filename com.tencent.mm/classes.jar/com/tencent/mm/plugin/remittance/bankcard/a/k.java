package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class k
  extends b
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public bcj nva;
  
  public k()
  {
    b.a locala = new b.a();
    locala.ecH = new bci();
    locala.ecI = new bcj();
    locala.ecG = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nva = ((bcj)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nva.iHq), this.nva.iHr });
    if ((!this.iHX) && (!this.iHY))
    {
      y.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.nva.txM), Integer.valueOf(this.nva.txN) });
      if (this.nva.txM >= 0) {
        g.DP().Dz().c(ac.a.uyw, Integer.valueOf(this.nva.txM));
      }
      if (this.nva.txN > 0) {
        g.DP().Dz().c(ac.a.uyx, Integer.valueOf(this.nva.txN));
      }
      if (!bk.bl(this.nva.txO)) {
        g.DP().Dz().c(ac.a.uyy, this.nva.txO);
      }
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (bcj)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */