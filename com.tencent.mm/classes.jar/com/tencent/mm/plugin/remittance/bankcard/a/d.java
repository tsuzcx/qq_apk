package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public of nuT;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new oe();
    ((b.a)localObject).ecI = new of();
    ((b.a)localObject).ecG = 1349;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (oe)this.dmK.ecE.ecN;
    ((oe)localObject).sLK = paramString1;
    ((oe)localObject).sLL = paramString2;
    ((oe)localObject).lnT = paramString3;
    ((oe)localObject).mOb = paramString4;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nuT = ((of)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nuT.iHq), this.nuT.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (of)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1349;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.d
 * JD-Core Version:    0.7.0.1
 */