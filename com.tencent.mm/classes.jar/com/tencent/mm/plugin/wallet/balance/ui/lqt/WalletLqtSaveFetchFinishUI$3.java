package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchFinishUI$3
  implements Runnable
{
  WalletLqtSaveFetchFinishUI$3(WalletLqtSaveFetchFinishUI paramWalletLqtSaveFetchFinishUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45640);
    LinearLayout localLinearLayout = (LinearLayout)this.tRw.findViewById(2131829196);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.removeRule(12);
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(45640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.3
 * JD-Core Version:    0.7.0.1
 */