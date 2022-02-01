package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

final class c$13
  implements MTimerHandler.CallBack
{
  c$13(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(163489);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163488);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfy, "");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfA, Boolean.FALSE);
        AppMethodBeat.o(163488);
      }
    };
    com.tencent.threadpool.h.ahAA.g(local1, "name_thread_get_newer_flavor_red");
    AppMethodBeat.o(163489);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.13
 * JD-Core Version:    0.7.0.1
 */