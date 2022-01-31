package com.tencent.mm.plugin.webview.luggage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$8
  implements View.OnClickListener
{
  l$8(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6180);
    if (l.a(this.uSA) == null)
    {
      AppMethodBeat.o(6180);
      return;
    }
    l.a(this.uSA).bzs.a(new l.8.1(this));
    AppMethodBeat.o(6180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l.8
 * JD-Core Version:    0.7.0.1
 */