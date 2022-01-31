package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class ShakeReportUI$28
  implements MenuItem.OnMenuItemClickListener
{
  ShakeReportUI$28(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ShakeReportUI.a(this.odm, false);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.odm, ShakePersonalInfoUI.class);
    this.odm.startActivityForResult(paramMenuItem, 3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.28
 * JD-Core Version:    0.7.0.1
 */