package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.cck;
import com.tencent.mm.protocal.c.ccl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class j
  extends s
{
  public String bJd;
  private b dmK;
  private f dmL;
  public int errCode;
  
  public j(int paramInt1, int paramInt2, String paramString, aqf paramaqf, aqe paramaqe)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cck();
    ((b.a)localObject).ecI = new ccl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).ecG = 1306;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cck)this.dmK.ecE.ecN;
    ((cck)localObject).taw = paramInt1;
    ((cck)localObject).bUy = paramInt2;
    this.bJd = paramString;
    ((cck)localObject).taD = paramaqf;
    ((cck)localObject).taC = paramaqe;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg:" + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      return;
    }
    paramq = (ccl)this.dmK.ecF.ecN;
    y.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.bPH + ",errMsg:" + paramq.bPI);
    paramInt2 = paramq.bPH;
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 1306;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.j
 * JD-Core Version:    0.7.0.1
 */