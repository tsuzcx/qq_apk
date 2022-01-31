package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$28
  implements MenuItem.OnMenuItemClickListener
{
  ShakeReportUI$28(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24810);
    ShakeReportUI.a(this.qRs, false);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.qRs, ShakePersonalInfoUI.class);
    this.qRs.startActivityForResult(paramMenuItem, 3);
    AppMethodBeat.o(24810);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.28
 * JD-Core Version:    0.7.0.1
 */