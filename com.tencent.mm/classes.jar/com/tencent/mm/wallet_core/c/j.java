package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends s
{
  private b dmK;
  private f dmL;
  
  public j(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new lo();
    ((b.a)localObject).ecI = new lp();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((b.a)localObject).ecG = 410;
    ((b.a)localObject).ecJ = 198;
    ((b.a)localObject).ecK = 1000000198;
    ((b.a)localObject).ecM = com.tencent.mm.wallet_core.ui.e.afr(paramString2);
    this.dmK = ((b.a)localObject).Kt();
    localObject = (lo)this.dmK.ecE.ecN;
    ((lo)localObject).sHk = paramString1;
    ((lo)localObject).sye = paramString2;
    ((lo)localObject).sHl = i.bVj();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneCancelQRPay", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 410;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */