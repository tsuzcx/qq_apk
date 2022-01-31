package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.bv.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;

public final class g
  extends m
  implements k
{
  f dmL;
  private final q edR = new a();
  String pLd = "";
  int pLe = 0;
  private String pLf = "";
  
  public g(String paramString)
  {
    ay.a locala = (ay.a)this.edR.Kv();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(73), paramString });
    locala.dWa.tik = 73;
    locala.dWa.til = paramString;
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ay.b)paramq.HF();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      au.DS().O(new g.1(this, paramInt1));
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (paramArrayOfByte.dWb.tim != null)
    {
      this.pLd = new String(paramArrayOfByte.dWb.tim.tFo.tFM.oY);
      this.pLe = paramArrayOfByte.dWb.tim.tDZ;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[] { Integer.valueOf(this.pLe), this.pLf, this.pLd });
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
    }
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g
 * JD-Core Version:    0.7.0.1
 */