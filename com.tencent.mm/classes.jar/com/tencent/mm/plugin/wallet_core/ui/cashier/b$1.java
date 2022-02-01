package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import org.xwalk.core.Log;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71416);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
    this.DCW.cancel();
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b.1
 * JD-Core Version:    0.7.0.1
 */