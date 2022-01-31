package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$14
  implements View.OnClickListener
{
  WalletLqtDetailUI$14(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45538);
    if (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPQ).xEb))
    {
      e.m(this.tPQ, WalletLqtDetailUI.e(this.tPQ).xEb, false);
      h.qsU.e(17084, new Object[] { Integer.valueOf(1) });
    }
    AppMethodBeat.o(45538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.14
 * JD-Core Version:    0.7.0.1
 */