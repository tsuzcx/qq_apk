package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class c$3
  implements b.a
{
  c$3(c paramc) {}
  
  public final void b(int paramInt1, int paramInt2, bly parambly)
  {
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + paramInt1);
      if (paramInt1 == -2) {
        new File(this.ucx.SV()).delete();
      }
      c.e(this.ucx);
      this.ucx.a(c.b(this.ucx));
      return;
    }
    y.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
    try
    {
      if (e.bJ(this.ucx.SV()) < c.f(this.ucx))
      {
        y.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
        this.ucx.a(c.b(this.ucx));
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
      y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
      c.b(this.ucx).b(-1, -1, parambly);
      return;
    }
    if (c.g(this.ucx))
    {
      if (!c.h(this.ucx).equalsIgnoreCase(g.bQ(this.ucx.SV())))
      {
        y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
        new File(this.ucx.SV()).delete();
        c.b(this.ucx).b(2, -1, parambly);
        return;
      }
      c.a(this.ucx, parambly);
      return;
    }
    if (!c.i(this.ucx).equalsIgnoreCase(g.bQ(this.ucx.SV())))
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
      new File(this.ucx.SV()).delete();
      c.b(this.ucx).b(-1, -1, parambly);
      return;
    }
    e.f(com.tencent.mm.sandbox.monitor.c.ubQ, c.j(this.ucx) + ".temp", c.k(this.ucx) + ".apk");
    c.b(this.ucx).b(200, 0, parambly);
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramInt1 + ", offset=" + paramInt2);
    c.b(this.ucx).cy(paramInt1, paramInt2);
  }
  
  public final void hm(long paramLong)
  {
    c.b(this.ucx).hm(paramLong);
  }
  
  public final void hn(long paramLong)
  {
    c.b(this.ucx).hn(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.3
 * JD-Core Version:    0.7.0.1
 */