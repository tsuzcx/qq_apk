package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ap$3
  implements View.OnCreateContextMenuListener
{
  ap$3(ap paramap) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(35510);
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(2131764691));
    paramContextMenu.add(0, 1, 1, paramView.getContext().getString(2131764682));
    AppMethodBeat.o(35510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ap.3
 * JD-Core Version:    0.7.0.1
 */