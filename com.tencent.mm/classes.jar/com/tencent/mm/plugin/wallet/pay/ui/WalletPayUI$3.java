package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletPayUI$3
  implements View.OnClickListener
{
  WalletPayUI$3(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69388);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.CKl.eDN();
    a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.3
 * JD-Core Version:    0.7.0.1
 */