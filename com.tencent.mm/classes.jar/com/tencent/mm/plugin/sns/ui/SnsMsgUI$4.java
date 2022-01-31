package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsMsgUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SnsMsgUI$4(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39068);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("sns_cmd_list", SnsMsgUI.m(this.rSU));
    this.rSU.setResult(-1, paramMenuItem);
    this.rSU.finish();
    AppMethodBeat.o(39068);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.4
 * JD-Core Version:    0.7.0.1
 */