package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.am;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBalanceSaveUI$1
  implements View.OnClickListener
{
  WalletBalanceSaveUI$1(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68693);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", new Object[] { Boolean.valueOf(WalletBalanceSaveUI.a(this.Ooq).OIL) });
    h.IzE.a(17084, new Object[] { Integer.valueOf(5) });
    if (WalletBalanceSaveUI.a(this.Ooq).OIL)
    {
      this.Ooq.hideWcKb();
      WalletBalanceSaveUI.b(this.Ooq);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68693);
      return;
      WalletBalanceSaveUI.c(this.Ooq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.1
 * JD-Core Version:    0.7.0.1
 */