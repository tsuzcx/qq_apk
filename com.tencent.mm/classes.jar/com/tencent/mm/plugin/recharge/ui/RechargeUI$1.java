package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RechargeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RechargeUI$1(RechargeUI paramRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(67216);
    this.NyL.hideVKB();
    this.NyL.finish();
    AppMethodBeat.o(67216);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.1
 * JD-Core Version:    0.7.0.1
 */