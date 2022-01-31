package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class g
  extends s
{
  private b dmK;
  private f dmL;
  
  public g(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdb();
    ((b.a)localObject).ecI = new bdc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).ecG = 389;
    ((b.a)localObject).ecJ = 187;
    ((b.a)localObject).ecK = 1000000187;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdb)this.dmK.ecE.ecN;
    ((bdb)localObject).tys = 1;
    if (!bk.bl(paramString1)) {
      ((bdb)localObject).mPI = paramString1;
    }
    if (!bk.bl(paramString2)) {
      ((bdb)localObject).mQb = paramString2;
    }
    ((bdb)localObject).sHl = i.bVj();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final int brE()
  {
    return ((bdb)this.dmK.ecE.ecN).tys;
  }
  
  public final String brF()
  {
    return ((bdb)this.dmK.ecE.ecN).mPI;
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 389;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */