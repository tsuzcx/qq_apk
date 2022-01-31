package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtPlanAddUI$1
  implements View.OnClickListener
{
  WalletLqtPlanAddUI$1(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45558);
    this.tQA.hideTenpayKB();
    ab.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
    WalletLqtPlanAddUI.a(this.tQA);
    if (!WalletLqtPlanAddUI.b(this.tQA).isEnabled())
    {
      AppMethodBeat.o(45558);
      return;
    }
    if (WalletLqtPlanAddUI.c(this.tQA) == 1)
    {
      WalletLqtPlanAddUI.a(this.tQA, 0);
      AppMethodBeat.o(45558);
      return;
    }
    WalletLqtPlanAddUI.a(this.tQA, 4);
    AppMethodBeat.o(45558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.1
 * JD-Core Version:    0.7.0.1
 */