package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.e.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.b;

final class i$6
  implements MenuItem.OnMenuItemClickListener
{
  i$6(i parami, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.gGE.replaceAll("tp=webp", "");
    s.a(i.a(this.rcq).mContext, paramMenuItem, b.cSe().getCookie(paramMenuItem), f.zF(), new i.6.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.6
 * JD-Core Version:    0.7.0.1
 */