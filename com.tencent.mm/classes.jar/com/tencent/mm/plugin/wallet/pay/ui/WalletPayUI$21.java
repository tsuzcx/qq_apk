package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletPayUI$21
  implements View.OnClickListener
{
  WalletPayUI$21(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69410);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.CKo;
    if (!this.CKo.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69410);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.21
 * JD-Core Version:    0.7.0.1
 */