package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$2$1
  implements View.OnCreateContextMenuListener
{
  f$2$1(f.2 param2) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(36552);
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(2131764635));
    paramContextMenu.add(0, 1, 0, paramView.getContext().getString(2131757361));
    paramContextMenu.add(0, 2, 0, paramView.getContext().getString(2131757433));
    AppMethodBeat.o(36552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.f.2.1
 * JD-Core Version:    0.7.0.1
 */