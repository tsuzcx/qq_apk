package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletChangeBankcardUI$5
  implements View.OnClickListener
{
  WalletChangeBankcardUI$5(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(277578);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new KeyEvent(1, 4);
    this.Oyc.dispatchKeyEvent(paramView);
    a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.5
 * JD-Core Version:    0.7.0.1
 */