package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.protocal.c.bwp;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public int mStatus;
  public int pLs;
  
  public i(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bwo();
    locala.ecI = new bwp();
    locala.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
    locala.ecG = 615;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bwo)this.dmK.ecE.ecN).bNb = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bwp)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.mStatus = paramq.tzB;
    this.pLs = paramq.tMV;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 615;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.i
 * JD-Core Version:    0.7.0.1
 */