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
    AppMethodBeat.i(28479);
    ShakeReportUI.a(this.yQi, false);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.yQi, ShakePersonalInfoUI.class);
    this.yQi.startActivityForResult(paramMenuItem, 3);
    AppMethodBeat.o(28479);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.28
 * JD-Core Version:    0.7.0.1
 */