package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletCardElementUI$15
  implements View.OnClickListener
{
  WalletCardElementUI$15(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70789);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    WalletCardElementUI.h(this.DeC);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.15
 * JD-Core Version:    0.7.0.1
 */