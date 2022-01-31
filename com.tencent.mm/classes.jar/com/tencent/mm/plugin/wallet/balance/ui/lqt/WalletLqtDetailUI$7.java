package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.ac;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;

final class WalletLqtDetailUI$7
  implements View.OnClickListener
{
  WalletLqtDetailUI$7(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45528);
    if ((WalletLqtDetailUI.e(this.tPQ).xEj != null) && (WalletLqtDetailUI.e(this.tPQ).xEj.xoA) && (WalletLqtDetailUI.e(this.tPQ).xwr != null))
    {
      ac.a(this.tPQ.getContext(), WalletLqtDetailUI.e(this.tPQ).xwr);
      AppMethodBeat.o(45528);
      return;
    }
    paramView = WalletLqtDetailUI.h(this.tPQ).tMI;
    f.A(Integer.valueOf(WalletLqtDetailUI.e(this.tPQ).wMx), Integer.valueOf(1)).c(paramView);
    WalletLqtDetailUI.a(this.tPQ, false, WalletLqtDetailUI.e(this.tPQ).xEj);
    AppMethodBeat.o(45528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.7
 * JD-Core Version:    0.7.0.1
 */