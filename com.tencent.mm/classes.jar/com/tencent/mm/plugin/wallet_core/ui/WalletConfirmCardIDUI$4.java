package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletConfirmCardIDUI$4
  implements View.OnClickListener
{
  WalletConfirmCardIDUI$4(WalletConfirmCardIDUI paramWalletConfirmCardIDUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70933);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.DfV.hideTenpayKB();
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.4
 * JD-Core Version:    0.7.0.1
 */