package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierDialog$15
  implements View.OnClickListener
{
  WcPayCashierDialog$15(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47779);
    ab.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
    WcPayCashierDialog.m(this.uvD);
    AppMethodBeat.o(47779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.15
 * JD-Core Version:    0.7.0.1
 */