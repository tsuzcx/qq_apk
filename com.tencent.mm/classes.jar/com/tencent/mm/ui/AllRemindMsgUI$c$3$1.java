package com.tencent.mm.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class AllRemindMsgUI$c$3$1
  implements View.OnCreateContextMenuListener
{
  AllRemindMsgUI$c$3$1(AllRemindMsgUI.c.3 param3) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, this.uGH.uGG.uGB.mController.uMN.getString(R.l.chatting_long_click_menu_delete_msg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.3.1
 * JD-Core Version:    0.7.0.1
 */