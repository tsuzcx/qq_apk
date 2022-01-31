package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135437);
    int i = this.tLQ.tCH[(this.tLQ.tCJ % this.tLQ.tCH.length)];
    if (this.tLQ.md != null)
    {
      if (-1 != i) {
        break label78;
      }
      this.tLQ.md.setText(null);
    }
    for (;;)
    {
      b localb = this.tLQ;
      localb.tCJ += 1;
      AppMethodBeat.o(135437);
      return true;
      label78:
      this.tLQ.md.setText(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.1
 * JD-Core Version:    0.7.0.1
 */