package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new rs();
    locala.ecI = new rt();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.ecG = 1561;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((rs)this.dmK.ecE.ecN).version = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1561;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */