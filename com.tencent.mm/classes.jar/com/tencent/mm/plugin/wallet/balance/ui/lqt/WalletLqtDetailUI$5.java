package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$5
  implements View.OnClickListener
{
  WalletLqtDetailUI$5(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45526);
    ab.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.e(this.tPQ).xEh.xuO == 2)
    {
      if (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPQ).xEh.wPJ))
      {
        e.m(this.tPQ, WalletLqtDetailUI.e(this.tPQ).xEh.wPJ, false);
        h.qsU.e(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.e(this.tPQ).xEh.wPJ });
        AppMethodBeat.o(45526);
      }
    }
    else if ((WalletLqtDetailUI.e(this.tPQ).xEh.xuO == 3) && (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPQ).xEh.wFW)) && (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPQ).xEh.wPJ)))
    {
      e.q(WalletLqtDetailUI.e(this.tPQ).xEh.wFW, WalletLqtDetailUI.e(this.tPQ).xEh.wPJ, 0, 1061);
      h.qsU.e(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.e(this.tPQ).xEh.wPJ, WalletLqtDetailUI.e(this.tPQ).xEh.wFW });
    }
    AppMethodBeat.o(45526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.5
 * JD-Core Version:    0.7.0.1
 */