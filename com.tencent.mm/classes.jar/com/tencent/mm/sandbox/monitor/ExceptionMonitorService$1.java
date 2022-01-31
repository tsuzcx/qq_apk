package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.sdk.platformtools.y;

final class ExceptionMonitorService$1
  implements Runnable
{
  ExceptionMonitorService$1(ExceptionMonitorService paramExceptionMonitorService) {}
  
  public final void run()
  {
    y.d("MicroMsg.CrashMonitorService", "stopSelf");
    this.ubP.stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService.1
 * JD-Core Version:    0.7.0.1
 */