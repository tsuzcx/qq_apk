package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUserUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsUserUI$3(SnsUserUI paramSnsUserUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39787);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.sce, SnsMsgUI.class);
    paramMenuItem.putExtra("sns_msg_force_show_all", true);
    paramMenuItem.putExtra("sns_msg_comment_list_scene", 2);
    this.sce.startActivityForResult(paramMenuItem, 8);
    AppMethodBeat.o(39787);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.3
 * JD-Core Version:    0.7.0.1
 */