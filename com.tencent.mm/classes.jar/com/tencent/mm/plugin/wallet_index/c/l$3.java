package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;

final class l$3
  implements Runnable
{
  l$3(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(142583);
    if (this.uAp.uAm.callback != null) {
      this.uAp.uAm.callback.run();
    }
    AppMethodBeat.o(142583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.l.3
 * JD-Core Version:    0.7.0.1
 */