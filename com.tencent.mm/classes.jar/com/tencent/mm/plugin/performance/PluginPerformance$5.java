package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.elf.a;

final class PluginPerformance$5
  implements Runnable
{
  PluginPerformance$5(PluginPerformance paramPluginPerformance) {}
  
  public final void run()
  {
    AppMethodBeat.i(300790);
    ((MainProcessChecker)a.bY(MainProcessChecker.class)).start();
    AppMethodBeat.o(300790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.5
 * JD-Core Version:    0.7.0.1
 */