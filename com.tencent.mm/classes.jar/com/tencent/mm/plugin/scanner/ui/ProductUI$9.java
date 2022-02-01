package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProductUI$9
  implements MenuItem.OnMenuItemClickListener
{
  ProductUI$9(ProductUI paramProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(51862);
    if (ProductUI.c(this.OZW) == 4) {
      this.OZW.setResult(0);
    }
    this.OZW.finish();
    AppMethodBeat.o(51862);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.9
 * JD-Core Version:    0.7.0.1
 */