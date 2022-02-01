package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class j
{
  public static boolean xNE = false;
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(75022);
    if (xNE)
    {
      AppMethodBeat.o(75022);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.qCV, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.lA(28))) {
        break label97;
      }
      if (g.ajR().ajA().a(am.a.Jas, 0L) < 3L) {
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
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.j
 * JD-Core Version:    0.7.0.1
 */