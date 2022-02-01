package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WcPayCashierDialog$15
  implements View.OnClickListener
{
  WcPayCashierDialog$15(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71359);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
    WcPayCashierDialog.m(this.IlZ);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.15
 * JD-Core Version:    0.7.0.1
 */