package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public d(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aal();
    ((b.a)localObject).ecI = new aam();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).ecG = 177;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aal)this.dmK.ecE.ecN;
    ((aal)localObject).sRV = 1;
    ((aal)localObject).sZF = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 177;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */