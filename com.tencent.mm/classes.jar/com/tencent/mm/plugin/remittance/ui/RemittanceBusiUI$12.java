package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBusiUI$12
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBusiUI$12(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44903);
    if (RemittanceBusiUI.f(this.qoF))
    {
      this.qoF.hideVKB();
      this.qoF.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(44903);
      return true;
      this.qoF.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.12
 * JD-Core Version:    0.7.0.1
 */