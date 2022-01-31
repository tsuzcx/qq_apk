package com.tencent.mm.plugin.webview.luggage;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$3$1
  implements View.OnCreateContextMenuListener
{
  h$3$1(h.3 param3) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(6122);
    if (this.uSe.uSc.ihb != null)
    {
      ab.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
      this.uSe.uSc.b(paramContextMenu, this.uSe.uSc.ihb);
      this.uSe.uSc.ihb = null;
      AppMethodBeat.o(6122);
      return;
    }
    if (this.uSe.uSc.ihc != null)
    {
      ab.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
      this.uSe.uSc.a(paramContextMenu, this.uSe.uSc.ihc);
      this.uSe.uSc.ihc = null;
    }
    AppMethodBeat.o(6122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.3.1
 * JD-Core Version:    0.7.0.1
 */