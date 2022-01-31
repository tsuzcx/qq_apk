package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.luggage.e.e;
import com.tencent.mm.plugin.webview.luggage.ipc.c;
import com.tencent.mm.sdk.platformtools.y;

final class i$7
  implements MenuItem.OnMenuItemClickListener
{
  i$7(i parami, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
    paramMenuItem = new Bundle();
    paramMenuItem.putString("result", this.gGH);
    paramMenuItem.putString("url", i.b(this.rcq));
    paramMenuItem.putInt("codeType", this.rcq.gGr);
    paramMenuItem.putInt("codeVersion", this.rcq.gGs);
    c.a(i.a(this.rcq).mContext, paramMenuItem, i.d.class);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.7
 * JD-Core Version:    0.7.0.1
 */