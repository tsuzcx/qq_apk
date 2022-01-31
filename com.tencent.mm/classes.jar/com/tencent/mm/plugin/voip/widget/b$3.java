package com.tencent.mm.plugin.voip.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$3
  implements ap.a
{
  b$3(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(5174);
    com.tencent.mm.plugin.voip.b.cLD().aeI(this.tJE.cQe());
    AppMethodBeat.o(5174);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b.3
 * JD-Core Version:    0.7.0.1
 */