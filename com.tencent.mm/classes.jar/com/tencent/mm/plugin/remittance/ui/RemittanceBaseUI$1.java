package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBaseUI$1(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44825);
    if ((this.qmk.mScene == 1) || (this.qmk.mScene == 6))
    {
      this.qmk.chf();
      this.qmk.finish();
    }
    for (;;)
    {
      this.qmk.chg();
      AppMethodBeat.o(44825);
      return true;
      if ((this.qmk.mScene == 2) || (this.qmk.mScene == 5)) {
        this.qmk.finish();
      } else {
        this.qmk.chp();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.1
 * JD-Core Version:    0.7.0.1
 */