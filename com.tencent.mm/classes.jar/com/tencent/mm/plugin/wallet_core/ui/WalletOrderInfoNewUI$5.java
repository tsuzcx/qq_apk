package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletOrderInfoNewUI$5
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$5(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47430);
    ab.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
    WalletOrderInfoNewUI.t(this.ury);
    AppMethodBeat.o(47430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.5
 * JD-Core Version:    0.7.0.1
 */