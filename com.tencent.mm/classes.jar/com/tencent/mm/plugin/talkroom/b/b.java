package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private int sceneType;
  
  public b(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new wa();
    ((b.a)localObject).ecI = new wb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/exittalkroom";
    ((b.a)localObject).ecG = 333;
    ((b.a)localObject).ecJ = 148;
    ((b.a)localObject).ecK = 1000000148;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (wa)this.dmK.ecE.ecN;
    ((wa)localObject).sSS = paramString;
    ((wa)localObject).sST = paramInt1;
    ((wa)localObject).sSU = paramLong;
    ((wa)localObject).pyo = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 333;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.b
 * JD-Core Version:    0.7.0.1
 */