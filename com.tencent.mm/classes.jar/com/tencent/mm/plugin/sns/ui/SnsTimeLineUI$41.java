package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsTimeLineUI$41
  implements MenuItem.OnMenuItemClickListener
{
  SnsTimeLineUI$41(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(179251);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.RAo, SnsMsgUI.class);
    paramMenuItem.putExtra("sns_msg_force_show_all", true);
    paramMenuItem.putExtra("sns_msg_comment_list_scene", 1);
    this.RAo.startActivityForResult(paramMenuItem, 8);
    AppMethodBeat.o(179251);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.41
 * JD-Core Version:    0.7.0.1
 */