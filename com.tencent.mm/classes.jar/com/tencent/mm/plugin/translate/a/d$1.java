package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$1
  implements ap.a
{
  d$1(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26068);
    if (this.tpc.toY)
    {
      ab.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(this.tpc.index) });
      this.tpc.cKU();
      this.tpc.tpa.a(-1, this.tpc.toX, null);
    }
    AppMethodBeat.o(26068);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d.1
 * JD-Core Version:    0.7.0.1
 */