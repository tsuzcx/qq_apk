package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class RemittanceBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBaseUI$1(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((this.nAH.fzn == 1) || (this.nAH.fzn == 6))
    {
      this.nAH.bwp();
      this.nAH.finish();
    }
    for (;;)
    {
      this.nAH.bwq();
      return true;
      if ((this.nAH.fzn == 2) || (this.nAH.fzn == 5)) {
        this.nAH.finish();
      } else {
        this.nAH.bwz();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.1
 * JD-Core Version:    0.7.0.1
 */