package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private int dDC = 1;
  public b dmK;
  private com.tencent.mm.ah.f dmL;
  private int igH;
  private byte[] nGU;
  private String nGV = "en";
  private String nGW = "zh_CN";
  
  public f(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt)
  {
    this.nGU = paramArrayOfByte;
    this.dDC = 1;
    this.nGV = paramString1;
    this.nGW = paramString2;
    this.igH = paramInt;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new azj();
    paramf.ecI = new azk();
    paramf.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
    paramf.ecG = 392;
    paramf.ecJ = 199;
    paramf.ecK = 1000000199;
    this.dmK = paramf.Kt();
    paramf = (azj)this.dmK.ecE.ecN;
    paramf.sDQ = ((int)bk.UY() & 0x7FFFFFFF);
    paramf.sDR = new bmk().bs(this.nGU);
    paramf.sDU = this.dDC;
    paramf.tvB = this.nGV;
    paramf.tvC = this.nGW;
    paramf.sDV = this.igH;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (azj)((b)paramq).ecE.ecN;
    if ((paramq.sDQ <= 0) || (bk.bl(paramq.tvC)) || (bk.bl(paramq.tvB)) || (paramq.sDU < 0) || (paramq.sDR == null) || (paramq.sDR.tFK <= 0))
    {
      y.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 392;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.f
 * JD-Core Version:    0.7.0.1
 */