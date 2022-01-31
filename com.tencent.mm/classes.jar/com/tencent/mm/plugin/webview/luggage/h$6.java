package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.xweb.b;

final class h$6
  implements MenuItem.OnMenuItemClickListener
{
  h$6(h paramh, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(6128);
    paramMenuItem = this.ihm.replaceAll("tp=webp", "");
    u.a(h.a(this.uSc).mContext, paramMenuItem, b.dYg().getCookie(paramMenuItem), f.Mi(), new h.6.1(this));
    AppMethodBeat.o(6128);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.6
 * JD-Core Version:    0.7.0.1
 */