package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class b
  extends s
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new beb();
    ((b.a)localObject).ecI = new bec();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payudeluserroll";
    ((b.a)localObject).ecG = 1544;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (beb)this.dmK.ecE.ecN;
    if (!bk.bl(paramString)) {
      ((beb)localObject).mPI = paramString;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 1544;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.b
 * JD-Core Version:    0.7.0.1
 */