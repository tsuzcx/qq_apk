package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$19
  implements View.OnClickListener
{
  WalletLqtDetailUI$19(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68808);
    if (!bt.isNullOrNil(WalletLqtDetailUI.d(this.zIT).EaT))
    {
      e.o(this.zIT, WalletLqtDetailUI.d(this.zIT).EaT, false);
      h.vKh.f(17084, new Object[] { Integer.valueOf(1) });
    }
    AppMethodBeat.o(68808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.19
 * JD-Core Version:    0.7.0.1
 */