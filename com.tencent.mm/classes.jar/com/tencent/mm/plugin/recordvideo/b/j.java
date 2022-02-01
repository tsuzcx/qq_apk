package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class j
{
  public static boolean xxH = false;
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(75022);
    if (xxH)
    {
      AppMethodBeat.o(75022);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.qvW, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.ly(28))) {
        break label97;
      }
      if (g.ajC().ajl().a(al.a.IFS, 0L) < 3L) {
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