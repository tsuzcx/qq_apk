package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, bh.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6282);
    if (paramInt1 == (this.uTr.hashCode() & 0xFFFF))
    {
      if (paramInt2 == -1)
      {
        this.lax.c(null, null);
        AppMethodBeat.o(6282);
        return;
      }
      this.lax.c("fail", null);
    }
    AppMethodBeat.o(6282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */