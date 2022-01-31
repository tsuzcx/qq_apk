package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private f dIJ;
  public final b dmK;
  public Object tag;
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ajo();
    ((b.a)localObject).ecI = new ajp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
    ((b.a)localObject).ecG = 673;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ajo)this.dmK.ecE.ecN;
    ((ajo)localObject).URL = paramString1;
    ((ajo)localObject).tgg = paramString2;
    ((ajo)localObject).Width = paramInt1;
    ((ajo)localObject).Height = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    }
  }
  
  public final int getType()
  {
    return 673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */