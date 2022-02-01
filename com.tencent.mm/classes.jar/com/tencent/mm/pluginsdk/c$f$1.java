package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.y;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
final class c$f$1
  implements av.a
{
  public static final 1 EJk;
  
  static
  {
    AppMethodBeat.i(124772);
    EJk = new 1();
    AppMethodBeat.o(124772);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124771);
    if (!y.fpz())
    {
      c localc = c.EIZ;
      c.eYO();
    }
    AppMethodBeat.o(124771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.f.1
 * JD-Core Version:    0.7.0.1
 */