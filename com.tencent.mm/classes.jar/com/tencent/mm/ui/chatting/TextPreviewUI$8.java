package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class TextPreviewUI$8
  implements View.OnCreateContextMenuListener
{
  TextPreviewUI$8(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.clear();
    paramContextMenu.add(0, 0, 0, this.vnn.getResources().getString(R.l.app_copy));
    paramContextMenu.add(1, 1, 0, this.vnn.getResources().getString(R.l.menu_select_all));
    paramContextMenu.add(1, 2, 0, this.vnn.getResources().getString(R.l.menu_retransmits));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */