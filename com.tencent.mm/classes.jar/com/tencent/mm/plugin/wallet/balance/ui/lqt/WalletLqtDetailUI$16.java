package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$16
  implements View.OnClickListener
{
  WalletLqtDetailUI$16(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187114);
    paramView = (String)this.zJa.getTag();
    e.o(this.zIT, paramView, false);
    h.vKh.f(17084, new Object[] { Integer.valueOf(11) });
    AppMethodBeat.o(187114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.16
 * JD-Core Version:    0.7.0.1
 */