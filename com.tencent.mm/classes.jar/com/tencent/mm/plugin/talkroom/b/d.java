package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends f
{
  public int actionType;
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private final String lGF;
  public int pBj;
  private int sceneType = 0;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bwx();
    ((b.a)localObject).ecI = new bwy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).ecG = 334;
    ((b.a)localObject).ecJ = 146;
    ((b.a)localObject).ecK = 1000000146;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bwx)this.dmK.ecE.ecN;
    ((bwx)localObject).sST = paramInt1;
    ((bwx)localObject).sSU = paramLong;
    ((bwx)localObject).sYX = paramInt2;
    ((bwx)localObject).svy = ((int)bk.UX());
    this.actionType = paramInt2;
    this.lGF = paramString;
    ((bwx)localObject).pyo = paramInt3;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.pBj = ((bwy)this.dmK.ecF.ecN).sSV;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final String bMK()
  {
    return this.lGF;
  }
  
  public final int bML()
  {
    return this.sceneType;
  }
  
  public final int getType()
  {
    return 334;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */