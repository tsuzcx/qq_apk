package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class j
{
  public static boolean vhf = false;
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(75022);
    if (vhf)
    {
      AppMethodBeat.o(75022);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.pnZ, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.lf(28))) {
        break label97;
      }
      if (g.afB().afk().a(ae.a.Fvt, 0L) < 3L) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.j
 * JD-Core Version:    0.7.0.1
 */