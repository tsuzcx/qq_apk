package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.g;

final class RemittanceBaseUI$27
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceBaseUI$27(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(67980);
    g.p(this.Ipl.getContext(), this.Ipl.IoN, false);
    AppMethodBeat.o(67980);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.27
 * JD-Core Version:    0.7.0.1
 */