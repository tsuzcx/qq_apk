package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletOrderInfoNewUI$21
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$21(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142518);
    ab.i("MicroMsg.WalletOrderInfoNewUI", "click card mch subscribe");
    if (WalletOrderInfoNewUI.f(this.ury))
    {
      WalletOrderInfoNewUI.g(this.ury);
      AppMethodBeat.o(142518);
      return;
    }
    WalletOrderInfoNewUI.h(this.ury);
    AppMethodBeat.o(142518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.21
 * JD-Core Version:    0.7.0.1
 */