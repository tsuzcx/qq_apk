package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.xweb.b;

final class h$4
  implements MenuItem.OnMenuItemClickListener
{
  h$4(h paramh, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(6125);
    u.a(h.a(this.uSc).mContext, this.ihm, b.dYg().getCookie(this.ihm), f.Mi(), new h.4.1(this));
    AppMethodBeat.o(6125);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.4
 * JD-Core Version:    0.7.0.1
 */