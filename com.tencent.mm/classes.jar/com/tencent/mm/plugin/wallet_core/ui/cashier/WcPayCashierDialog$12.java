package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WcPayCashierDialog$12
  implements View.OnClickListener
{
  WcPayCashierDialog$12(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71356);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WcPayCashierDialog.f(this.IlZ);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.12
 * JD-Core Version:    0.7.0.1
 */