package com.tencent.mm.plugin.webview.luggage;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.y;

final class i$3$1
  implements View.OnCreateContextMenuListener
{
  i$3$1(i.3 param3) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.rcs.rcq.gGu != null)
    {
      y.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
      this.rcs.rcq.b(paramContextMenu, this.rcs.rcq.gGu);
      this.rcs.rcq.gGu = null;
    }
    while (this.rcs.rcq.gGv == null) {
      return;
    }
    y.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
    this.rcs.rcq.a(paramContextMenu, this.rcs.rcq.gGv);
    this.rcs.rcq.gGv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.3.1
 * JD-Core Version:    0.7.0.1
 */