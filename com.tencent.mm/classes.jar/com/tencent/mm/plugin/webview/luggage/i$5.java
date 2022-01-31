package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.e.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;

final class i$5
  implements MenuItem.OnMenuItemClickListener
{
  i$5(i parami, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      s.a(i.a(this.rcq).mContext, this.gGE, b.cSe().getCookie(this.gGE), f.zF());
      return true;
    }
    catch (Exception paramMenuItem)
    {
      y.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.5
 * JD-Core Version:    0.7.0.1
 */