package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private aar nEZ = null;
  public ah nFa;
  
  public g(int paramInt1, int paramInt2)
  {
    iv(true);
    ag localag = new ag();
    this.nEZ = new aar();
    try
    {
      localag.ssQ = paramInt1;
      localag.ssR = paramInt2;
      this.nEZ.taq = localag;
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
    }
  }
  
  private static void iv(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    com.tencent.mm.kernel.g.DN();
    int i;
    if (!a.Db())
    {
      y.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
      i = -1;
    }
    int j;
    do
    {
      return i;
      paramf = new b.a();
      paramf.ecL = false;
      paramf.ecH = this.nEZ;
      paramf.ecI = new aas();
      paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      paramf.ecG = 914;
      this.dmK = paramf.Kt();
      j = a(parame, this.dmK, this);
      i = j;
    } while (j >= 0);
    y.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      this.nFa = null;
      iv(false);
      return j;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(parame) });
    }
    return j;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    try
    {
      this.nFa = null;
      if ((com.tencent.mm.kernel.g.DO().dJT == null) || (com.tencent.mm.kernel.g.DO().dJT.edx == null))
      {
        y.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if (paramInt2 != 0)
      {
        y.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + paramInt2 + ", errCode:" + paramInt3);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      y.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
      this.nFa = ((aas)this.dmK.ecF.ecN).tar;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    finally
    {
      iv(false);
    }
  }
  
  public final int getType()
  {
    return 914;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.g
 * JD-Core Version:    0.7.0.1
 */