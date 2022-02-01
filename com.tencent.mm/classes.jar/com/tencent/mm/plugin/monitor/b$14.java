package com.tencent.mm.plugin.monitor;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class b$14
  implements aw.a
{
  b$14(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(163489);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163488);
        g.ajR().ajA().set(am.a.JdL, "");
        g.ajR().ajA().set(am.a.JdN, Boolean.FALSE);
        AppMethodBeat.o(163488);
      }
    };
    h.MqF.f(local1, "name_thread_get_newer_flavor_red");
    AppMethodBeat.o(163489);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.14
 * JD-Core Version:    0.7.0.1
 */