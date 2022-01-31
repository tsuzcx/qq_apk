package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public abz nuX;
  
  public h()
  {
    b.a locala = new b.a();
    locala.ecH = new aby();
    locala.ecI = new abz();
    locala.ecG = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nuX = ((abz)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nuX.iHq), this.nuX.iHr });
    if ((!this.iHX) && (this.nuX.iHq != 0)) {
      this.iHY = true;
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (abz)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */