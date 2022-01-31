package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtDetailUI$11
  implements d.a
{
  WalletLqtDetailUI$11(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(142295);
    if (WalletLqtDetailUI.a(this.tPQ) != null) {
      WalletLqtDetailUI.a(this.tPQ).dismiss();
    }
    ab.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label74;
      }
    }
    label74:
    for (paramObject = paramObject.toString();; paramObject = this.tPQ.getString(2131305218))
    {
      Toast.makeText(this.tPQ, paramObject, 1).show();
      AppMethodBeat.o(142295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.11
 * JD-Core Version:    0.7.0.1
 */