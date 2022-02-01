package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$23
  implements View.OnClickListener
{
  WalletLqtDetailUI$23(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup, bxp parambxp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68812);
    paramView = (String)this.Bbg.getTag();
    e.n(this.Bbf, paramView, false);
    h.wUl.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Bbn.EvL });
    AppMethodBeat.o(68812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.23
 * JD-Core Version:    0.7.0.1
 */