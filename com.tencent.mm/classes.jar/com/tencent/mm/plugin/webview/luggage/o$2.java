package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.d;

final class o$2
  implements n.d
{
  o$2(o paramo) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6220);
    o localo = this.uSN;
    localo.uSv.a(localo.uSb.mContext, localo.uSb, paramMenuItem);
    this.uSN.uSM.cre();
    AppMethodBeat.o(6220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o.2
 * JD-Core Version:    0.7.0.1
 */