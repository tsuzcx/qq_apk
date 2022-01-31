package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhq;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public bhr nvb;
  
  public l(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bhq();
    locala.ecI = new bhr();
    locala.ecG = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bhq)this.dmK.ecE.ecN).sFw = paramString;
    y.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nvb = ((bhr)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (bhr)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.l
 * JD-Core Version:    0.7.0.1
 */