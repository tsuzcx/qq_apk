package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.p;

final class WalletLqtPlanAddUI$10
  implements Runnable
{
  WalletLqtPlanAddUI$10(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(68843);
    if (WalletLqtPlanAddUI.r(this.CCt) != null) {
      WalletLqtPlanAddUI.r(this.CCt).setVisibility(0);
    }
    p.a(this.CCt, WalletLqtPlanAddUI.l(this.CCt), this.CCt.findViewById(2131303141), WalletLqtPlanAddUI.s(this.CCt), WalletLqtPlanAddUI.r(this.CCt), 24);
    AppMethodBeat.o(68843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.10
 * JD-Core Version:    0.7.0.1
 */