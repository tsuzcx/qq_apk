package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cku;
import com.tencent.mm.protocal.c.ckv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  private f dmL;
  private b esv;
  cku qTR = new cku();
  ckv qTS;
  
  public u(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecG = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.ecH = new cku();
    locala.ecI = new ckv();
    this.esv = locala.Kt();
    this.qTR = ((cku)this.esv.ecE.ecN);
    this.qTR.tqS = aa.Bs(0);
    this.qTR.jxi = x.fB(ae.getContext());
    this.qTR.sZQ = aa.boM();
    this.qTR.tqT = aa.Jx();
    this.qTR.pyo = paramInt;
    this.qTR.sFC = 0L;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.qTS = ((ckv)this.esv.ecF.ecN);
    if (this.qTS != null) {
      y.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.qTS.sEb });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1948;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */