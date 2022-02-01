package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.y;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
final class c$f$1
  implements aw.a
{
  public static final 1 FbI;
  
  static
  {
    AppMethodBeat.i(124772);
    FbI = new 1();
    AppMethodBeat.o(124772);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124771);
    if (!y.fty())
    {
      c localc = c.Fbx;
      c.fcC();
    }
    AppMethodBeat.o(124771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.f.1
 * JD-Core Version:    0.7.0.1
 */