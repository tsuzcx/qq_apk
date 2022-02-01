package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.v;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
final class b$f$1
  implements au.a
{
  public static final 1 Dfo;
  
  static
  {
    AppMethodBeat.i(124772);
    Dfo = new 1();
    AppMethodBeat.o(124772);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124771);
    if (!v.eZA())
    {
      b localb = b.Dfd;
      b.eKa();
    }
    AppMethodBeat.o(124771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.f.1
 * JD-Core Version:    0.7.0.1
 */