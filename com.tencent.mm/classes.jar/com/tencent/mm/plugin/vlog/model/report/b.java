package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/MultiVideoProfileIDKeyStat;", "", "()V", "ID", "", "endSeek", "", "cost", "endUpdateComposition", "report", "key", "reportFps", "fps", "", "startSeek", "startUpdateComposition", "plugin-vlog_release"})
public final class b
{
  public static final b GBb;
  
  static
  {
    AppMethodBeat.i(190816);
    GBb = new b();
    AppMethodBeat.o(190816);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(190815);
    h.CyF.F(1468L, paramLong);
    AppMethodBeat.o(190815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.b
 * JD-Core Version:    0.7.0.1
 */