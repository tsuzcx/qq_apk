package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class l
{
  public static boolean NHr = false;
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(75022);
    if (NHr)
    {
      AppMethodBeat.o(75022);
      return true;
    }
    if (((c)h.ax(c.class)).a(c.a.yQI, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.rb(28))) {
        break label97;
      }
      if (h.baE().ban().a(at.a.acZa, 0L) < 3L) {
        break label92;
      }
    }
    label92:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label97;
      }
      AppMethodBeat.o(75022);
      return true;
      i = 0;
      break;
    }
    label97:
    AppMethodBeat.o(75022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.l
 * JD-Core Version:    0.7.0.1
 */