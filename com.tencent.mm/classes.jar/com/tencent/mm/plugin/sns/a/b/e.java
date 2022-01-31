package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bl;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends m
  implements k
{
  private b dmK;
  public f dmL;
  public List<asw> hfb;
  
  public e(List<asw> paramList)
  {
    Object localObject = new b.a();
    this.hfb = paramList;
    ((b.a)localObject).ecH = new bk();
    ((b.a)localObject).ecI = new bl();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).ecG = 1802;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bk)this.dmK.ecE.ecN;
    asv localasv = new asv();
    localasv.sEc = d.soV;
    localasv.sEd = d.soU;
    localasv.sEe = d.soX;
    localasv.sEf = d.soY;
    localasv.sEg = x.cqJ();
    localasv.toB = ((int)(System.currentTimeMillis() / 1000L));
    ((bk)localObject).svd = localasv;
    while (i < paramList.size())
    {
      ((bk)localObject).sve.add(paramList.get(i));
      i += 1;
    }
    y.i("MicroMsg.NetSceneAdLog", "report count: " + ((bk)localObject).sve.size());
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bl)((b)paramq).ecF.ecN).svf;
      g.DQ();
      g.DP().Dz().c(ac.a.upR, Integer.valueOf(paramInt1));
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1802;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.e
 * JD-Core Version:    0.7.0.1
 */