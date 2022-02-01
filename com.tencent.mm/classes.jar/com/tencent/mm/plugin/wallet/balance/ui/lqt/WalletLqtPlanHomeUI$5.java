package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtPlanHomeUI$5
  implements View.OnClickListener
{
  WalletLqtPlanHomeUI$5(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, caq paramcaq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68930);
    ad.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
    e.p(this.zKT.getContext(), this.zKU.DXc.url, true);
    AppMethodBeat.o(68930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.5
 * JD-Core Version:    0.7.0.1
 */