package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class d$1$1
  implements View.OnCreateContextMenuListener
{
  d$1$1(d.1 param1) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(this.nuG.nuF.context.getString(R.l.app_copy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1.1
 * JD-Core Version:    0.7.0.1
 */