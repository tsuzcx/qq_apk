package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchFinishUI$4
  implements Runnable
{
  WalletLqtSaveFetchFinishUI$4(WalletLqtSaveFetchFinishUI paramWalletLqtSaveFetchFinishUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45641);
    LinearLayout localLinearLayout = (LinearLayout)this.tRw.findViewById(2131829196);
    if (localLinearLayout == null)
    {
      AppMethodBeat.o(45641);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.addRule(12);
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(45641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishUI.4
 * JD-Core Version:    0.7.0.1
 */