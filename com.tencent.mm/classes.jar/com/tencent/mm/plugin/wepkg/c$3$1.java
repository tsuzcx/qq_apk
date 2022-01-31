package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.y;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3) {}
  
  public final void run()
  {
    try
    {
      y.i("MicroMsg.WePkgPlugin", "load url from net");
      c.d(this.rOb.rNZ);
      c.b(this.rOb.rNZ);
      int i = c.cjK();
      if (i > 1)
      {
        if (c.e(this.rOb.rNZ) != null) {
          a.b("whiteScreen", c.f(this.rOb.rNZ), c.e(this.rOb.rNZ).dCD, c.e(this.rOb.rNZ).version, -1L, 0L, null);
        }
        h.nFQ.a(859L, 13L, 1L, false);
        String str = d.Vq(c.f(this.rOb.rNZ));
        b.vW(str);
        e.Vf(str);
        c.cjL();
        return;
      }
      c.Dw(i + 1);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.3.1
 * JD-Core Version:    0.7.0.1
 */