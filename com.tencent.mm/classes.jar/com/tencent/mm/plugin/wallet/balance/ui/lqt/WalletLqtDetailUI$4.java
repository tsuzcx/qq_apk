package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletLqtDetailUI$4
  implements View.OnClickListener
{
  WalletLqtDetailUI$4(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45525);
    paramView = new so();
    paramView.cIQ.userName = WalletLqtDetailUI.e(this.tPQ).xDV.username;
    paramView.cIQ.cIS = bo.bf(WalletLqtDetailUI.e(this.tPQ).xDV.path, "");
    paramView.cIQ.scene = 1061;
    paramView.cIQ.cIT = 0;
    a.ymk.l(paramView);
    AppMethodBeat.o(45525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4
 * JD-Core Version:    0.7.0.1
 */