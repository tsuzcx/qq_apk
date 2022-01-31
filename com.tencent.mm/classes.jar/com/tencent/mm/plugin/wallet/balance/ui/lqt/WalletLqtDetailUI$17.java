package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$17
  implements View.OnClickListener
{
  WalletLqtDetailUI$17(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup, bfx parambfx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45541);
    paramView = (String)this.tPX.getTag();
    e.m(this.tPQ, paramView, false);
    h.qsU.e(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.tPW.wPJ });
    AppMethodBeat.o(45541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.17
 * JD-Core Version:    0.7.0.1
 */