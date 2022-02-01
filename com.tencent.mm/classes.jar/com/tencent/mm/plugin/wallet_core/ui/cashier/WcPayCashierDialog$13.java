package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WcPayCashierDialog$13
  implements View.OnClickListener
{
  WcPayCashierDialog$13(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71357);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    WcPayCashierDialog.g(this.Per);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.13
 * JD-Core Version:    0.7.0.1
 */