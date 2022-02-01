package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class c$12
  implements MTimerHandler.CallBack
{
  c$12(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(51512);
    c.e(this.LfZ);
    AppMethodBeat.o(51512);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.12
 * JD-Core Version:    0.7.0.1
 */