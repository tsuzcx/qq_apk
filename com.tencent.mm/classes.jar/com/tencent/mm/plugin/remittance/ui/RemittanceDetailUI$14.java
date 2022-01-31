package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceDetailUI$14
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceDetailUI$14(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45012);
    e.m(this.qpY.getContext(), RemittanceDetailUI.w(this.qpY), false);
    AppMethodBeat.o(45012);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.14
 * JD-Core Version:    0.7.0.1
 */