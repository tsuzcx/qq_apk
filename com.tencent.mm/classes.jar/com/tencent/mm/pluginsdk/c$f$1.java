package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ad;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
final class c$f$1
  implements MTimerHandler.CallBack
{
  public static final 1 JSC;
  
  static
  {
    AppMethodBeat.i(124772);
    JSC = new 1();
    AppMethodBeat.o(124772);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124771);
    ad localad = ad.NRn;
    if (!ad.gBl()) {
      c.JSr.glO();
    }
    AppMethodBeat.o(124771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.f.1
 * JD-Core Version:    0.7.0.1
 */