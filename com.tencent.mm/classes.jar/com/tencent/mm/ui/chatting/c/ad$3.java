package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$3
  implements View.OnCreateContextMenuListener
{
  ad$3(ad paramad) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(31615);
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(2131302698));
    paramContextMenu.add(0, 1, 1, paramView.getContext().getString(2131302690));
    AppMethodBeat.o(31615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ad.3
 * JD-Core Version:    0.7.0.1
 */