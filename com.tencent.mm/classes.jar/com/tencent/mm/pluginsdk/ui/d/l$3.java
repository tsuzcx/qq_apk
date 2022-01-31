package com.tencent.mm.pluginsdk.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.Iterator;
import java.util.List;

public final class l$3
  implements View.OnCreateContextMenuListener
{
  public l$3(List paramList) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = this.sjN.iterator();
    while (paramView.hasNext()) {
      paramContextMenu.add(0, 0, 0, (String)paramView.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.3
 * JD-Core Version:    0.7.0.1
 */