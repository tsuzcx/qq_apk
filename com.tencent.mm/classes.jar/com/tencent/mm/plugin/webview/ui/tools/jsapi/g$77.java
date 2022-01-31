package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$77
  implements View.OnCreateContextMenuListener
{
  g$77(g paramg)
  {
    AppMethodBeat.i(9140);
    AppMethodBeat.o(9140);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(154998);
    paramContextMenu.add(0, 1, 0, g.j(this.vqm).getString(2131296938));
    paramContextMenu.add(0, 2, 1, g.j(this.vqm).getString(2131296945));
    AppMethodBeat.o(154998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.77
 * JD-Core Version:    0.7.0.1
 */