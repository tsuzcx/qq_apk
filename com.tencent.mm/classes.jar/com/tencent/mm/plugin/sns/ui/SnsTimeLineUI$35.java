package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsTimeLineUI$35
  implements MenuItem.OnMenuItemClickListener
{
  SnsTimeLineUI$35(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(179250);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.xHe, SnsMsgUI.class);
    paramMenuItem.putExtra("sns_msg_force_show_all", true);
    paramMenuItem.putExtra("sns_msg_comment_list_scene", 1);
    this.xHe.startActivityForResult(paramMenuItem, 8);
    AppMethodBeat.o(179250);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.35
 * JD-Core Version:    0.7.0.1
 */