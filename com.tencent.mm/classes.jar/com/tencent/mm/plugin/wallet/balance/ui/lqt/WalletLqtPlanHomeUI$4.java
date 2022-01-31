package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtPlanHomeUI$4
  implements View.OnClickListener
{
  WalletLqtPlanHomeUI$4(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, bmn parambmn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45607);
    ab.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
    e.m(this.tQV.getContext(), this.tQW.xAT.url, true);
    AppMethodBeat.o(45607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.4
 * JD-Core Version:    0.7.0.1
 */