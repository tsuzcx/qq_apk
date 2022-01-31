package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtPlanAddUI$16$2
  implements Runnable
{
  WalletLqtPlanAddUI$16$2(WalletLqtPlanAddUI.16 param16) {}
  
  public final void run()
  {
    AppMethodBeat.i(45575);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletLqtPlanAddUI.b(this.tQF.tQA).getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.bottomMargin = WalletLqtPlanAddUI.bUU();
      WalletLqtPlanAddUI.b(this.tQF.tQA).setLayoutParams(localLayoutParams);
    }
    WalletLqtPlanAddUI.h(this.tQF.tQA).scrollTo(0, 0);
    AppMethodBeat.o(45575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.16.2
 * JD-Core Version:    0.7.0.1
 */