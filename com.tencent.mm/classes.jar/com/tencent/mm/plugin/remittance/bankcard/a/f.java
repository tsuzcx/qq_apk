package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  public String nuR;
  public tt nuV;
  
  public f(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new ts();
    locala.ecI = new tt();
    locala.ecG = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((ts)this.dmK.ecE.ecN).nvy = paramString;
    this.nuR = paramString;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nuV = ((tt)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nuV.iHq), this.nuV.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (tt)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.f
 * JD-Core Version:    0.7.0.1
 */