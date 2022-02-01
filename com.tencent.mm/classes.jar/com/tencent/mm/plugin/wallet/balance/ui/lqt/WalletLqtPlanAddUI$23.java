package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class WalletLqtPlanAddUI$23
  implements View.OnClickListener
{
  WalletLqtPlanAddUI$23(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68857);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (WalletLqtPlanAddUI.b(this.Hzj).isShown()) {
      this.Hzj.hideWcKb();
    }
    Log.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
    WalletLqtPlanAddUI.c(this.Hzj);
    if (!WalletLqtPlanAddUI.d(this.Hzj).isEnabled())
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68857);
      return;
    }
    if (WalletLqtPlanAddUI.e(this.Hzj) == 1) {
      WalletLqtPlanAddUI.a(this.Hzj, 0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68857);
      return;
      WalletLqtPlanAddUI.a(this.Hzj, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.23
 * JD-Core Version:    0.7.0.1
 */