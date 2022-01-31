package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.protocal.c.bwe;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private b dmK;
  private f dmL;
  public String mSp;
  
  public k(bsn parambsn)
  {
    b.a locala = new b.a();
    locala.ecH = new bwe();
    locala.ecI = new bwf();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.ecG = 557;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bwe)this.dmK.ecE.ecN).tMP = parambsn;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (bwf)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + paramq.tMQ);
      this.mSp = paramq.tMQ;
    }
    y.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 557;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.k
 * JD-Core Version:    0.7.0.1
 */