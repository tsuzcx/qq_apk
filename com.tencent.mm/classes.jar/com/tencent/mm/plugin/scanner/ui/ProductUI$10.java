package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProductUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ProductUI$10(ProductUI paramProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(81091);
    if (ProductUI.c(this.qyh) == 4) {
      this.qyh.setResult(0);
    }
    this.qyh.finish();
    AppMethodBeat.o(81091);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.10
 * JD-Core Version:    0.7.0.1
 */