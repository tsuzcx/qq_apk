package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

final class RemittanceDetailUI$21
  implements a.a
{
  RemittanceDetailUI$21(RemittanceDetailUI paramRemittanceDetailUI, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45022);
    if (this.qql)
    {
      d.H(this.qpY, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
      AppMethodBeat.o(45022);
      return;
    }
    h.an(this.qpY, 0);
    AppMethodBeat.o(45022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.21
 * JD-Core Version:    0.7.0.1
 */