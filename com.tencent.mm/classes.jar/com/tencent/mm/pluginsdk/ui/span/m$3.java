package com.tencent.mm.pluginsdk.ui.span;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class m$3
  implements View.OnCreateContextMenuListener
{
  public m$3(List paramList) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(31923);
    paramView = this.FhH.iterator();
    while (paramView.hasNext()) {
      paramContextMenu.add(0, 0, 0, (String)paramView.next());
    }
    AppMethodBeat.o(31923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m.3
 * JD-Core Version:    0.7.0.1
 */