package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class WalletOrderInfoOldUI$10
  implements View.OnClickListener
{
  WalletOrderInfoOldUI$10(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47483);
    e.m(this.urV, ((Orders.Commodity)this.urV.tVr.ujl.get(0)).ujX.url, false);
    AppMethodBeat.o(47483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.10
 * JD-Core Version:    0.7.0.1
 */