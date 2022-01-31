package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(63366);
    try
    {
      ab.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
      c.d(this.vEL.vEJ);
      c.e(this.vEL.vEJ);
      int i = c.dkm();
      if (i > 1)
      {
        if (c.f(this.vEL.vEJ) != null) {
          a.b("whiteScreen", c.g(this.vEL.vEJ), c.f(this.vEL.vEJ).ezY, c.f(this.vEL.vEJ).version, -1L, 0L, null);
        }
        h.qsU.idkeyStat(859L, 13L, 1L, false);
        String str = d.akM(c.g(this.vEL.vEJ));
        b.Ey(str);
        com.tencent.mm.plugin.wepkg.model.b.dkA().ee(str, 1);
        c.dkn();
        AppMethodBeat.o(63366);
        return;
      }
      c.Lo(i + 1);
      AppMethodBeat.o(63366);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(63366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.3.1
 * JD-Core Version:    0.7.0.1
 */