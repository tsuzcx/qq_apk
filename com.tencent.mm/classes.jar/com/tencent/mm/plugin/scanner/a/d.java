package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private String bJd;
  public b dmK;
  private f dmL;
  private String iJx;
  private int scene;
  
  public d(String paramString1, int paramInt, String paramString2)
  {
    this.bJd = paramString1;
    this.scene = paramInt;
    this.iJx = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new iz();
    paramf.ecI = new ja();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
    paramf.ecG = 1063;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (iz)this.dmK.ecE.ecN;
    paramf.syc = this.bJd;
    paramf.pyo = this.scene;
    paramf.sDl = this.iJx;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (iz)((b)paramq).ecE.ecN;
    if ((paramq.pyo < 0) || (paramq.syc == null) || (paramq.syc.length() <= 0))
    {
      y.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[] { Integer.valueOf(paramq.pyo) });
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 1063;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.d
 * JD-Core Version:    0.7.0.1
 */