package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
  public String bIW;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public abx nuW;
  
  public g(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new abw();
    locala.ecI = new abx();
    locala.ecG = 1542;
    locala.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((abw)this.dmK.ecE.ecN).sLL = paramString1;
    this.bIW = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nuW = ((abx)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nuW.iHq), this.nuW.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (abx)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.g
 * JD-Core Version:    0.7.0.1
 */