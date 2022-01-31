package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private f dmL;
  private b esv;
  akq ptn;
  akr pto;
  c ptp;
  
  public d(long paramLong1, long paramLong2, c paramc)
  {
    this.ptp = paramc;
    paramc = new b.a();
    paramc.ecG = 1734;
    paramc.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
    paramc.ecH = new akq();
    paramc.ecI = new akr();
    this.esv = paramc.Kt();
    this.ptn = ((akq)this.esv.ecE.ecN);
    this.ptn.sQR = ((int)(paramLong1 / 1000L));
    this.ptn.sQS = ((int)(paramLong2 / 1000L));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.pto = ((akr)this.esv.ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.d
 * JD-Core Version:    0.7.0.1
 */