package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceDetailUI$15
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceDetailUI$15(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68140);
    e.o(this.wRp.getContext(), RemittanceDetailUI.w(this.wRp), false);
    AppMethodBeat.o(68140);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.15
 * JD-Core Version:    0.7.0.1
 */