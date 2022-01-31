package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  byte[] ccD;
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  int ret;
  
  public b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new brd();
    ((b.a)localObject).ecI = new bre();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakereport";
    ((b.a)localObject).ecG = 161;
    ((b.a)localObject).ecJ = 56;
    ((b.a)localObject).ecK = 1000000056;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (brd)this.dmK.ecE.ecN;
    y.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    ((brd)localObject).ssq = 0;
    ((brd)localObject).sGJ = paramFloat1;
    ((brd)localObject).sGK = paramFloat2;
    ((brd)localObject).sUn = paramInt1;
    ((brd)localObject).sUo = paramString1;
    ((brd)localObject).sUp = paramString2;
    ((brd)localObject).sUq = paramInt2;
    au.Hx();
    ((brd)localObject).tIa = bk.a((Integer)c.Dz().get(4107, null), 0);
    au.Hx();
    paramInt2 = bk.g((Integer)c.Dz().get(4106, null));
    ((brd)localObject).tIb = paramInt2;
    au.Hx();
    c.Dz().o(4106, Integer.valueOf(paramInt2 + 1));
    ((brd)localObject).tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
    o.a(2002, paramFloat1, paramFloat2, paramInt1);
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneShakeReport", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bre)this.dmK.ecF.ecN;
    this.ret = paramq.HF().spN;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ccD = aa.a(paramArrayOfByte.szp);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int bzF()
  {
    return ((brd)this.dmK.ecE.ecN).sUq;
  }
  
  public final int getType()
  {
    return 161;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.b
 * JD-Core Version:    0.7.0.1
 */