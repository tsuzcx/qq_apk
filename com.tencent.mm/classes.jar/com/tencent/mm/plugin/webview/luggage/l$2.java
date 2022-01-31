package com.tencent.mm.plugin.webview.luggage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class l$2
  implements View.OnClickListener
{
  l$2(l paraml, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6173);
    if (this.nka.byJ.um().peek() == l.a(this.uSA)) {
      this.uSA.bFu();
    }
    AppMethodBeat.o(6173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l.2
 * JD-Core Version:    0.7.0.1
 */