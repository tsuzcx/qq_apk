package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class h$2$1
  implements View.OnCreateContextMenuListener
{
  h$2$1(h.2 param2) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(R.l.retransmits));
    paramContextMenu.add(0, 1, 0, paramView.getContext().getString(R.l.chatting_fav));
    paramContextMenu.add(0, 2, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.h.2.1
 * JD-Core Version:    0.7.0.1
 */