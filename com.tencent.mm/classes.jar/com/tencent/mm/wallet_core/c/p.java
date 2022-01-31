package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends s
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public p(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public p(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdw();
    ((b.a)localObject).ecI = new bdx();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((b.a)localObject).ecG = 421;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    ((b.a)localObject).ecM = com.tencent.mm.wallet_core.ui.e.afr(paramString2);
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdw)this.dmK.ecE.ecN;
    ((bdw)localObject).tzf = paramString1;
    ((bdw)localObject).sHl = i.bVj();
    ((bdw)localObject).tzg = paramString3;
    if (!bk.bl(paramString2)) {
      ((bdw)localObject).tzh = new com.tencent.mm.bv.b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((bdw)localObject).sHe = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((bdw)localObject).sss = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((bdw)localObject).tzi = paramInt3;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 421;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.p
 * JD-Core Version:    0.7.0.1
 */