package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;

public final class n
  extends b
  implements g
{
  private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public blo nvd;
  
  public n(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, int paramInt4, String paramString5)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bln();
    ((b.a)localObject).ecI = new blo();
    ((b.a)localObject).ecG = 1380;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/request_tsbc";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bln)this.dmK.ecE.ecN;
    ((bln)localObject).nvy = paramString1;
    ((bln)localObject).nvz = paramString2;
    ((bln)localObject).mOb = paramString3;
    ((bln)localObject).nvl = paramInt1;
    ((bln)localObject).tEY = paramInt2;
    ((bln)localObject).tEZ = paramString4;
    ((bln)localObject).tFa = paramInt3;
    ((bln)localObject).tFb = paramInt4;
    ((bln)localObject).sxV = paramString5;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final boolean aEE()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.nvd.tFc != null)
    {
      bool1 = bool2;
      if (this.nvd.tFc.bcw == 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nvd = ((blo)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nvd.iHq), this.nvd.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (blo)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.n
 * JD-Core Version:    0.7.0.1
 */