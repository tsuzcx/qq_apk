package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayCashierDialog$10
  implements View.OnClickListener
{
  WcPayCashierDialog$10(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47774);
    ab.i("MicroMsg.WcPayCashierDialog", "click close icon");
    this.uvD.cancel();
    AppMethodBeat.o(47774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.10
 * JD-Core Version:    0.7.0.1
 */