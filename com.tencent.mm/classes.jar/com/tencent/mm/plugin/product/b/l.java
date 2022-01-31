package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.protocal.c.bwg;
import com.tencent.mm.protocal.c.bwh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class l
  extends s
  implements k
{
  private b dmK;
  private f dmL;
  public String mSp;
  
  public l(bsn parambsn, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bwg();
    ((b.a)localObject).ecI = new bwh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((b.a)localObject).ecG = 556;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bwg)this.dmK.ecE.ecN;
    ((bwg)localObject).tMP = parambsn;
    ((bwg)localObject).tMR = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    paramq = (bwh)((b)paramq).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + paramq.tMQ);
      this.mSp = paramq.tMQ;
    }
    y.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt2 + ", errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 556;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */