package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwz;
import com.tencent.mm.protocal.c.bxa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends f
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private final String lGF;
  private int sceneType = 0;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bwz();
    ((b.a)localObject).ecI = new bxa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).ecG = 335;
    ((b.a)localObject).ecJ = 149;
    ((b.a)localObject).ecK = 1000000149;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bwz)this.dmK.ecE.ecN;
    ((bwz)localObject).sST = paramInt1;
    ((bwz)localObject).sSU = paramLong;
    ((bwz)localObject).svy = ((int)bk.UX());
    this.lGF = paramString;
    ((bwz)localObject).pyo = paramInt2;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
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
    return 335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.e
 * JD-Core Version:    0.7.0.1
 */