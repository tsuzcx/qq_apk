package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class ac$3
  implements View.OnCreateContextMenuListener
{
  ac$3(ac paramac) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, paramView.getContext().getString(R.l.room_delete_member_remove_this_member));
    paramContextMenu.add(0, 1, 1, paramView.getContext().getString(R.l.room_delete_member_cancel_qrcode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ac.3
 * JD-Core Version:    0.7.0.1
 */