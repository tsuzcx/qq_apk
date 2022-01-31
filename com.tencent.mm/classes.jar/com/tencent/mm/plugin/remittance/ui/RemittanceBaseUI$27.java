package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBaseUI$27
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBaseUI$27(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142158);
    e.m(this.qmk.getContext(), this.qmk.qlM, false);
    AppMethodBeat.o(142158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.27
 * JD-Core Version:    0.7.0.1
 */