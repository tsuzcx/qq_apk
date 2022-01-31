package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.e.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.b;

final class i$4
  implements MenuItem.OnMenuItemClickListener
{
  i$4(i parami, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    s.a(i.a(this.rcq).mContext, this.gGE, b.cSe().getCookie(this.gGE), f.zF(), new i.4.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.4
 * JD-Core Version:    0.7.0.1
 */