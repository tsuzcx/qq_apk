package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.bd;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ckj;
import com.tencent.mm.protocal.c.ckk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private f dmL;
  private com.tencent.mm.ah.b esv;
  
  public b(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 976;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendyo";
    ((b.a)localObject).ecH = new ckj();
    ((b.a)localObject).ecI = new ckk();
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.esv = ((b.a)localObject).Kt();
    localObject = (ckj)this.esv.ecE.ecN;
    ((ckj)localObject).kWm = paramString;
    ((ckj)localObject).ttf = ((ckj)localObject).mPL;
    ((ckj)localObject).mPL = ((int)bd.iK(paramString));
    ((ckj)localObject).hQR = 63;
    ((ckj)localObject).tXL = 1;
    ((ckj)localObject).hPS = 1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 976;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.b
 * JD-Core Version:    0.7.0.1
 */