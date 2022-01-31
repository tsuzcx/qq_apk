package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  String pLd = "";
  int pLe = 0;
  String pLf = "";
  
  public d(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new amb();
    ((b.a)localObject).ecI = new amc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
    ((b.a)localObject).ecG = 611;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (amb)this.dmK.ecE.ecN;
    y.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ((amb)localObject).tik = paramInt;
    ((amb)localObject).til = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (amc)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramq.tim != null)
    {
      this.pLd = new String(paramq.tim.tFo.tFM.oY);
      this.pLe = paramq.tim.tDZ;
      y.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[] { Integer.valueOf(this.pLe), this.pLd });
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
    }
  }
  
  public final int getType()
  {
    return 611;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.d
 * JD-Core Version:    0.7.0.1
 */