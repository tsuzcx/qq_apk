package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b;

final class h$5
  implements MenuItem.OnMenuItemClickListener
{
  h$5(h paramh, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(6126);
    try
    {
      u.a(h.a(this.uSc).mContext, this.ihm, b.dYg().getCookie(this.ihm), f.Mi());
      AppMethodBeat.o(6126);
      return true;
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.5
 * JD-Core Version:    0.7.0.1
 */