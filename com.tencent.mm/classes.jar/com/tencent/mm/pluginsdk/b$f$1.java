package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.u;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
final class b$f$1
  implements av.a
{
  public static final 1 BNe;
  
  static
  {
    AppMethodBeat.i(124772);
    BNe = new 1();
    AppMethodBeat.o(124772);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124771);
    if (!u.eKd())
    {
      b localb = b.BMT;
      b.euH();
    }
    AppMethodBeat.o(124771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.b.f.1
 * JD-Core Version:    0.7.0.1
 */