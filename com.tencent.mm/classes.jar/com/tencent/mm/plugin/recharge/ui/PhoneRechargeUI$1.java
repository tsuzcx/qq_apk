package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhoneRechargeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  PhoneRechargeUI$1(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44252);
    this.pWp.hideVKB();
    this.pWp.finish();
    AppMethodBeat.o(44252);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.1
 * JD-Core Version:    0.7.0.1
 */