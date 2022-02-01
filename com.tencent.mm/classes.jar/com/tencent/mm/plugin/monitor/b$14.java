package com.tencent.mm.plugin.monitor;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class b$14
  implements MTimerHandler.CallBack
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
        g.aAh().azQ().set(ar.a.Onr, "");
        g.aAh().azQ().set(ar.a.Ont, Boolean.FALSE);
        AppMethodBeat.o(163488);
      }
    };
    h.RTc.b(local1, "name_thread_get_newer_flavor_red");
    AppMethodBeat.o(163489);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.14
 * JD-Core Version:    0.7.0.1
 */