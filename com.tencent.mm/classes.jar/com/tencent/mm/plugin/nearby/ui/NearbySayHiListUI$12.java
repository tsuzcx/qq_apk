package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class NearbySayHiListUI$12
  implements MenuItem.OnMenuItemClickListener
{
  NearbySayHiListUI$12(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.mDP.XM();
    this.mDP.setResult(0);
    this.mDP.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.12
 * JD-Core Version:    0.7.0.1
 */