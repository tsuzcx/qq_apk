package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.j;

final class WalletLqtPlanAddUI$11
  implements View.OnClickListener
{
  WalletLqtPlanAddUI$11(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316434);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (WalletLqtPlanAddUI.p(this.Vge) != null) {
      WalletLqtPlanAddUI.p(this.Vge).xcO.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.11
 * JD-Core Version:    0.7.0.1
 */