package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blg;
import com.tencent.mm.sdk.platformtools.y;

public final class w
  extends m
  implements k
{
  private f dmL;
  public b esv;
  private String qTV;
  private int scene;
  
  public w(blf paramblf)
  {
    b.a locala = new b.a();
    locala.ecG = 1134;
    locala.uri = "/cgi-bin/mmsearch-bin/searchreport";
    locala.ecH = paramblf;
    locala.ecI = new blg();
    this.esv = locala.Kt();
    this.scene = paramblf.pyo;
    this.qTV = paramblf.tEQ;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    ao.BG(5);
    ao.v(this.scene, 4, this.qTV);
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ao.BG(7);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ao.BG(6);
    ao.a(this.scene, 5, paramInt2, paramInt3, this.qTV);
  }
  
  public final int getType()
  {
    return 1134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */