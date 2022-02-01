package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/MultiVideoProfileIDKeyStat;", "", "()V", "ID", "", "endSeek", "", "cost", "endUpdateComposition", "report", "key", "reportFps", "fps", "", "startSeek", "startUpdateComposition", "plugin-vlog_release"})
public final class b
{
  public static final b NoK;
  
  static
  {
    AppMethodBeat.i(243199);
    NoK = new b();
    AppMethodBeat.o(243199);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(243198);
    h.IzE.F(1468L, paramLong);
    AppMethodBeat.o(243198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.b
 * JD-Core Version:    0.7.0.1
 */