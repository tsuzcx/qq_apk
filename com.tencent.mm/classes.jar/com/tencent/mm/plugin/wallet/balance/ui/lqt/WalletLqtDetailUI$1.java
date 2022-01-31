package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtDetailUI$1
  implements d.a
{
  WalletLqtDetailUI$1(WalletLqtDetailUI paramWalletLqtDetailUI, int paramInt) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(45522);
    if (WalletLqtDetailUI.a(this.tPQ) != null) {
      WalletLqtDetailUI.a(this.tPQ).dismiss();
    }
    ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    int i = this.oxU - 1;
    if (i > 0)
    {
      WalletLqtDetailUI.a(this.tPQ, i);
      AppMethodBeat.o(45522);
      return;
    }
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label99;
      }
    }
    label99:
    for (paramObject = paramObject.toString();; paramObject = this.tPQ.getString(2131305218))
    {
      Toast.makeText(this.tPQ, paramObject, 1).show();
      AppMethodBeat.o(45522);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.1
 * JD-Core Version:    0.7.0.1
 */