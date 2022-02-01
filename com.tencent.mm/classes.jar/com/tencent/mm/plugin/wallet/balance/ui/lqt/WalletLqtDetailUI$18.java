package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$18
  implements View.OnClickListener
{
  WalletLqtDetailUI$18(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68807);
    ac.i("MicroMsg.WalletLqtDetailUI", "click balance title");
    e.n(this.Bbf.getContext(), WalletLqtDetailUI.d(this.Bbf).Fyc, false);
    AppMethodBeat.o(68807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.18
 * JD-Core Version:    0.7.0.1
 */