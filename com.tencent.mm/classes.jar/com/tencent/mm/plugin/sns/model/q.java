package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.btq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Vector;

public final class q
  extends m
  implements k
{
  public static List<Long> opN = new Vector();
  public b dmK;
  public f dmL;
  private long eAA;
  
  public q(long paramLong)
  {
    this.eAA = paramLong;
    b.a locala = new b.a();
    locala.ecH = new btp();
    locala.ecI = new btq();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.ecG = 210;
    locala.ecJ = 101;
    locala.ecK = 1000000101;
    this.dmK = locala.Kt();
    ((btp)this.dmK.ecE.ecN).sGd = paramLong;
    y.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId " + paramLong);
  }
  
  private static boolean fV(long paramLong)
  {
    opN.remove(Long.valueOf(paramLong));
    return true;
  }
  
  public static boolean fW(long paramLong)
  {
    if (opN.contains(Long.valueOf(paramLong))) {
      return false;
    }
    opN.add(Long.valueOf(paramLong));
    return true;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      fV(this.eAA);
      return;
    }
    paramq = ((btq)this.dmK.ecF.ecN).tKq;
    if (paramq != null) {
      y.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + aa.b(paramq.tJU));
    }
    aj.d(paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    fV(this.eAA);
  }
  
  public final int getType()
  {
    return 210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */