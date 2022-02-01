package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WcPayCashierFingerprintDialog$3
  implements View.OnClickListener
{
  WcPayCashierFingerprintDialog$3(WcPayCashierFingerprintDialog paramWcPayCashierFingerprintDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71420);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
    this.PeG.cancel();
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.3
 * JD-Core Version:    0.7.0.1
 */