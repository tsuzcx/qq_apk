package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.cij;
import com.tencent.mm.protocal.c.cik;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public int bVm = -1;
  b dmK;
  private f dmL;
  
  public c()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cij();
    ((b.a)localObject).ecI = new cik();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
    ((b.a)localObject).ecG = 1866;
    this.dmK = ((b.a)localObject).Kt();
    localObject = aa.Jx();
    cij localcij = (cij)this.dmK.ecE.ecN;
    if (localObject != null)
    {
      localcij.tWP = ((atp)localObject).sGK;
      localcij.tWQ = ((atp)localObject).sGJ;
    }
    localcij.tWR = aa.boM();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return this.dmK.ecG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */