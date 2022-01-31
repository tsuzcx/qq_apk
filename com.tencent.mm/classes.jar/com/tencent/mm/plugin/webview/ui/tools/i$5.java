package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.xweb.b;

final class i$5
  implements n.d
{
  i$5(i parami, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(153200);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(153200);
      return;
      paramMenuItem = this.vcB;
      String str = this.ihm;
      boolean bool;
      try
      {
        bool = paramMenuItem.ddJ();
        u.a(paramMenuItem.ddt(), str, b.dYg().getCookie(str), bool, new i.8(paramMenuItem));
        AppMethodBeat.o(153200);
        return;
      }
      catch (Exception paramMenuItem)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
        AppMethodBeat.o(153200);
        return;
      }
      paramMenuItem = this.vcB;
      str = this.ihm;
      try
      {
        bool = paramMenuItem.ddJ();
        u.a(paramMenuItem.ddt(), str, b.dYg().getCookie(str), bool);
        AppMethodBeat.o(153200);
        return;
      }
      catch (Exception paramMenuItem)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
        AppMethodBeat.o(153200);
        return;
      }
      paramMenuItem = this.vcB;
      str = this.ihm;
      try
      {
        bool = paramMenuItem.ddJ();
        str = str.replaceAll("tp=webp", "");
        u.a(paramMenuItem.ddt(), str, b.dYg().getCookie(str), bool, new i.9(paramMenuItem));
        AppMethodBeat.o(153200);
        return;
      }
      catch (Exception paramMenuItem)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i.5
 * JD-Core Version:    0.7.0.1
 */