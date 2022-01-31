package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cca;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL;
  public alp nQG;
  public byte[] nQH;
  
  public f(byte[] paramArrayOfByte)
  {
    this.nQH = paramArrayOfByte;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    alo localalo = new alo();
    if (this.nQH != null) {
      localalo.thB = aa.I(this.nQH).tFM;
    }
    paramf.ecH = localalo;
    this.nQG = new alp();
    paramf.ecI = this.nQG;
    paramf.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramf.ecG = 1146;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.nQG = ((alp)((b)paramq).ecF.ecN);
    if (this.nQG.sQB != null)
    {
      paramInt3 = this.nQG.sQB.bLB;
      paramString = this.nQG.sQB.bLC;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1146;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */