package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$3
  implements ap.a
{
  c$3(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(63367);
    if ((c.b(this.vEJ)) && (!c.c(this.vEJ)))
    {
      ab.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
      al.d(new c.3.1(this));
    }
    for (;;)
    {
      AppMethodBeat.o(63367);
      return false;
      c.Lo(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.3
 * JD-Core Version:    0.7.0.1
 */