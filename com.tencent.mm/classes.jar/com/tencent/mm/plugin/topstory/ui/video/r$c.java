package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.ui.h.c;

final class r$c
  implements h.c
{
  private r$c(r paramr) {}
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(1836);
    e.qrI.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(1836);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(1837);
    e.qrI.kvStat(14349, paramString);
    AppMethodBeat.o(1837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.c
 * JD-Core Version:    0.7.0.1
 */