package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.ui.i.c;

final class r$c
  implements i.c
{
  private r$c(r paramr) {}
  
  public final void Du(String paramString)
  {
    AppMethodBeat.i(126211);
    f.Ozc.kvStat(14349, paramString);
    AppMethodBeat.o(126211);
  }
  
  public final void hp(long paramLong)
  {
    AppMethodBeat.i(126210);
    f.Ozc.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(126210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.c
 * JD-Core Version:    0.7.0.1
 */