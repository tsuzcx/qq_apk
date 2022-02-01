package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/MultiVideoProfileIDKeyStat;", "", "()V", "ID", "", "endSeek", "", "cost", "endUpdateComposition", "report", "key", "reportFps", "fps", "", "startSeek", "startUpdateComposition", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Ucm;
  
  static
  {
    AppMethodBeat.i(283718);
    Ucm = new b();
    AppMethodBeat.o(283718);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(283713);
    h.OAn.p(1468L, paramLong, 1L);
    AppMethodBeat.o(283713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.b
 * JD-Core Version:    0.7.0.1
 */