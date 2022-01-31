package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class ProductUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ProductUI$10(ProductUI paramProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (ProductUI.c(this.nKF) == 4) {
      this.nKF.setResult(0);
    }
    this.nKF.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.10
 * JD-Core Version:    0.7.0.1
 */