package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71310);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.Dkm.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a.4
 * JD-Core Version:    0.7.0.1
 */