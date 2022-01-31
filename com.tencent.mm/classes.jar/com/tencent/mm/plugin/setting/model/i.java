package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.protocal.c.cca;

public final class i
  extends m
  implements k
{
  private String bGm;
  private f dmL;
  public byte[] nQH;
  public boj nQK;
  
  public i(String paramString)
  {
    this.bGm = paramString;
  }
  
  public i(byte[] paramArrayOfByte)
  {
    this.nQH = paramArrayOfByte;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    boi localboi = new boi();
    localboi.bGm = this.bGm;
    if (this.nQH != null) {
      localboi.thB = aa.I(this.nQH).tFM;
    }
    paramf.ecH = localboi;
    paramf.ecI = new boj();
    paramf.ecG = 1169;
    paramf.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramf.ecJ = 0;
    paramf.ecK = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.nQK = ((boj)((b)paramq).ecF.ecN);
    paramInt1 = this.nQK.sQB.bLB;
    paramString = this.nQK.sQB.bLC;
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramString, this);
  }
  
  public final int getType()
  {
    return 1169;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */