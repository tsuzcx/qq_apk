package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.y;

public final class v
  extends m
  implements k
{
  public int bVm;
  public int businessType;
  private f dmL;
  private b esv;
  public String lJQ;
  public avl qTT;
  private int qTU;
  public int scene;
  
  public v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2)
  {
    this.scene = paramInt1;
    this.qTU = paramInt3;
    this.bVm = paramInt4;
    this.businessType = paramInt2;
    this.lJQ = paramString2;
    y.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.ecG = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.ecH = new avk();
    paramString2.ecI = new avl();
    this.esv = paramString2.Kt();
    paramString2 = (avk)this.esv.ecE.ecN;
    paramString2.pyo = paramInt1;
    paramString2.tqS = paramInt3;
    paramString2.tqT = aa.Jx();
    paramString2.tqU = paramInt2;
    paramString2.jxi = paramString1;
    paramString2.tqV = paramLong;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.qTT = ((avl)this.esv.ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1048;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */