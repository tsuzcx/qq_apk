package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class n$4$7
  implements View.OnCreateContextMenuListener
{
  n$4$7(n.4 param4) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, R.l.multi_select_send_normal);
    paramContextMenu.add(0, 1, 1, R.l.multi_select_send_record);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.4.7
 * JD-Core Version:    0.7.0.1
 */