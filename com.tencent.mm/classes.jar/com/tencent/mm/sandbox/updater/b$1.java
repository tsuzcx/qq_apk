package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class b$1
  implements b.a
{
  b$1(b paramb) {}
  
  public final void b(int paramInt1, int paramInt2, bly parambly)
  {
    if ((paramInt1 != 200) || (paramInt2 != 0) || ((parambly != null) && (parambly.tFx.sze != 0)))
    {
      if ((!this.ucp.cpG()) && (b.a(this.ucp) < b.b(this.ucp).length * 5))
      {
        this.ucp.a(b.c(this.ucp));
        return;
      }
      b.c(this.ucp).b(paramInt1, paramInt2, parambly);
      return;
    }
    aln localaln = (aln)parambly;
    y.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.compatible.util.e.bkF);
    y.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + localaln.ndf);
    y.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + localaln.ndg);
    y.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + localaln.ndh);
    if ((localaln.ndh <= 0) || (localaln.ndi == null))
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
      b.c(this.ucp).b(paramInt1, -1, null);
      return;
    }
    if (localaln.ndi.tFK != localaln.ndh)
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + localaln.ndh + " data buf len = " + localaln.ndi.tFK);
      b.c(this.ucp).b(4, -1, null);
      return;
    }
    if ((localaln.ndg < 0) || (localaln.ndg + localaln.ndh > localaln.ndf))
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + localaln.ndg + " dataLen = " + localaln.ndh + " totalLen = " + localaln.ndf);
      b.c(this.ucp).b(4, -1, null);
      return;
    }
    if (localaln.ndf <= 0)
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + localaln.ndf);
      b.c(this.ucp).b(4, -1, null);
      return;
    }
    String str1 = c.ubQ;
    String str2 = b.d(this.ucp);
    byte[] arrayOfByte = localaln.ndi.tFM.toByteArray();
    paramInt1 = com.tencent.mm.a.e.b(str1, str2 + ".temp", arrayOfByte);
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + paramInt1);
      b.c(this.ucp).b(4, -1, null);
      return;
    }
    b.a(this.ucp, localaln.ndh + localaln.ndg);
    b.b(this.ucp, localaln.ndf);
    b.c(this.ucp).cy(localaln.ndf, localaln.ndg);
    if (localaln.ndg + localaln.ndh >= localaln.ndf)
    {
      try
      {
        if (b.f(this.ucp).equalsIgnoreCase(g.bQ(b.e(this.ucp))))
        {
          com.tencent.mm.a.e.f(c.ubQ, b.g(this.ucp) + ".temp", b.h(this.ucp) + ".apk");
          b.c(this.ucp).b(200, 0, parambly);
          return;
        }
      }
      catch (Exception parambly)
      {
        y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", parambly, "", new Object[0]);
        return;
      }
      y.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
      new File(b.i(this.ucp)).delete();
      b.c(this.ucp).b(-1, -1, parambly);
      return;
    }
    this.ucp.a(b.c(this.ucp));
  }
  
  public final void cy(int paramInt1, int paramInt2) {}
  
  public final void hm(long paramLong)
  {
    b.c(this.ucp).hm(paramLong);
  }
  
  public final void hn(long paramLong)
  {
    b.c(this.ucp).hn(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b.1
 * JD-Core Version:    0.7.0.1
 */