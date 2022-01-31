package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class RemittanceBusiUI$12
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBusiUI$12(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (RemittanceBusiUI.f(this.nCA))
    {
      this.nCA.XM();
      this.nCA.showDialog(1000);
    }
    for (;;)
    {
      return true;
      this.nCA.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.12
 * JD-Core Version:    0.7.0.1
 */