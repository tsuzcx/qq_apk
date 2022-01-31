package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.sns.i.j;

final class i$a$1
  implements View.OnCreateContextMenuListener
{
  i$a$1(i.a parama) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, i.c(this.oOb.oNT).getString(i.j.app_copy));
    paramContextMenu.add(1, 1, 0, i.c(this.oOb.oNT).getString(i.j.app_delete));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.a.1
 * JD-Core Version:    0.7.0.1
 */