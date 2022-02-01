package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;

final class av$3
  implements View.OnCreateContextMenuListener
{
  av$3(av paramav) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(35510);
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(R.l.gTI));
    paramContextMenu.add(0, 1, 1, paramView.getContext().getString(R.l.gTA));
    AppMethodBeat.o(35510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.av.3
 * JD-Core Version:    0.7.0.1
 */