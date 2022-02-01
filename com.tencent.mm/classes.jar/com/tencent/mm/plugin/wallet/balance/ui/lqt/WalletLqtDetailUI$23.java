package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$23
  implements View.OnClickListener
{
  WalletLqtDetailUI$23(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup, bsy parambsy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68812);
    paramView = (String)this.zIU.getTag();
    e.o(this.zIT, paramView, false);
    h.vKh.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.zJb.DcE });
    AppMethodBeat.o(68812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.23
 * JD-Core Version:    0.7.0.1
 */