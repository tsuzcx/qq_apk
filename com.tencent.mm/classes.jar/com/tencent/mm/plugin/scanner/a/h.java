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
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.jh;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends m
  implements k
{
  private int dDC = 1;
  public b dmK;
  private f dmL;
  private int ebK;
  private int igH;
  private byte[] nGU;
  private int offset;
  
  public h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.nGU = paramArrayOfByte;
    this.dDC = 1;
    this.ebK = paramInt1;
    this.offset = 0;
    this.igH = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new jh();
    paramf.ecI = new ji();
    paramf.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
    paramf.ecG = 1062;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (jh)this.dmK.ecE.ecN;
    paramf.sDQ = ((int)bk.UY() & 0x7FFFFFFF);
    paramf.sDR = new bmk().bs(this.nGU);
    paramf.sDS = this.ebK;
    paramf.sDT = this.offset;
    if (this.offset + this.nGU.length < this.ebK) {}
    for (paramf.euw = 0;; paramf.euw = 1)
    {
      paramf.sDU = this.dDC;
      paramf.sDV = this.igH;
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (jh)((b)paramq).ecE.ecN;
    if ((paramq.sDQ <= 0) || (paramq.sDU < 0) || (paramq.sDR == null) || (paramq.sDR.tFK <= 0) || (paramq.sDS <= 0) || (paramq.sDT < 0) || (paramq.sDT + paramq.sDR.tFK > paramq.sDS))
    {
      y.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[] { Integer.valueOf(paramq.sDU), Integer.valueOf(paramq.sDS), Integer.valueOf(paramq.sDT) });
      if (paramq.sDR != null) {
        y.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[] { Integer.valueOf(paramq.sDR.tFK) });
      }
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 1062;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.h
 * JD-Core Version:    0.7.0.1
 */