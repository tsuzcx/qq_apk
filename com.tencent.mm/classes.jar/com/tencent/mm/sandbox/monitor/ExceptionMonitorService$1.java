package com.tencent.mm.sandbox.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExceptionMonitorService$1
  implements Runnable
{
  ExceptionMonitorService$1(ExceptionMonitorService paramExceptionMonitorService) {}
  
  public final void run()
  {
    AppMethodBeat.i(28787);
    ab.d("MicroMsg.CrashMonitorService", "stopSelf");
    this.yke.stopSelf();
    AppMethodBeat.o(28787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService.1
 * JD-Core Version:    0.7.0.1
 */