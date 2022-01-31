package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class am$b$1
  implements View.OnCreateContextMenuListener
{
  am$b$1(am.b paramb, Context paramContext) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33304);
    paramContextMenu.clear();
    paramContextMenu.add(0, 0, 0, this.val$context.getResources().getString(2131296895));
    paramContextMenu.add(0, 1, 0, this.val$context.getResources().getString(2131301554));
    paramContextMenu.add(0, 2, 0, this.val$context.getResources().getString(2131301553));
    paramContextMenu.add(0, 3, 0, this.val$context.getResources().getString(2131299680));
    AppMethodBeat.o(33304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b.1
 * JD-Core Version:    0.7.0.1
 */