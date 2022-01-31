package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class GestureGuardLogicUI$1
  implements MenuItem.OnMenuItemClickListener
{
  GestureGuardLogicUI$1(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (GestureGuardLogicUI.a(this.qPX)) {
      return true;
    }
    GestureGuardLogicUI.a(this.qPX, 0, 4, "user cancel when setting gesture");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.1
 * JD-Core Version:    0.7.0.1
 */