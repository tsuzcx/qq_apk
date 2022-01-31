package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

final class RemittanceDetailUI$7
  implements a.a
{
  RemittanceDetailUI$7(RemittanceDetailUI paramRemittanceDetailUI, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.nDt)
    {
      d.x(this.nDm, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
      return;
    }
    h.Z(this.nDm, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.7
 * JD-Core Version:    0.7.0.1
 */