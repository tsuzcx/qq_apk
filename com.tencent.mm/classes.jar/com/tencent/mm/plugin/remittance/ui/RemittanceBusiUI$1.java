package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBusiUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBusiUI$1(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44893);
    RemittanceBusiUI.e(this.qoF);
    this.qoF.finish();
    AppMethodBeat.o(44893);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.1
 * JD-Core Version:    0.7.0.1
 */