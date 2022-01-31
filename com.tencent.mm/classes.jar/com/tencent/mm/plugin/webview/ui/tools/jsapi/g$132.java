package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$132
  implements View.OnCreateContextMenuListener
{
  g$132(g paramg) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(155045);
    paramContextMenu.add(0, 1, 0, g.j(this.vqm).getString(2131302892));
    paramContextMenu.add(0, 2, 1, g.j(this.vqm).getString(2131302887));
    AppMethodBeat.o(155045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.132
 * JD-Core Version:    0.7.0.1
 */