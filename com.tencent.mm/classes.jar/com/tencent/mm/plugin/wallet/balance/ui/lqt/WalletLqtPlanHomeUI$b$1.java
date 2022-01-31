package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtPlanHomeUI$b$1
  implements View.OnClickListener
{
  WalletLqtPlanHomeUI$b$1(WalletLqtPlanHomeUI.b paramb, bmo parambmo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45619);
    e.m(this.tRj.iDS.getContext(), this.tQY.xAX.url, true);
    AppMethodBeat.o(45619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.b.1
 * JD-Core Version:    0.7.0.1
 */