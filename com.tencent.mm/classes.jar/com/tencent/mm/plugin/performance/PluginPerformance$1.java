package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.elf.a;

final class PluginPerformance$1
  implements Runnable
{
  PluginPerformance$1(PluginPerformance paramPluginPerformance) {}
  
  public final void run()
  {
    AppMethodBeat.i(111014);
    ((MainProcessChecker)a.an(MainProcessChecker.class)).start();
    AppMethodBeat.o(111014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.1
 * JD-Core Version:    0.7.0.1
 */