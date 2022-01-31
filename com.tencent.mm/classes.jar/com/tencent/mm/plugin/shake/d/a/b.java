package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  private String oaI;
  private int scene;
  
  public b(String paramString, int paramInt)
  {
    this.oaI = paramString;
    this.scene = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new aky();
    paramf.ecI = new akz();
    paramf.uri = "/cgi-bin/micromsg-bin/gettvinfo";
    paramf.ecG = 552;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (aky)this.dmK.ecE.ecN;
    paramf.thg = this.oaI;
    paramf.pyo = this.scene;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (aky)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if ((paramq.pyo < 0) || (paramq.thg == null) || (paramq.thg.length() <= 0))
    {
      y.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.pyo) });
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 552;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.b
 * JD-Core Version:    0.7.0.1
 */