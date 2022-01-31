package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBankcardIdUI$4
  implements j.a
{
  WalletBankcardIdUI$4(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47164);
    ab.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
    WalletBankcardIdUI.a(this.unn);
    AppMethodBeat.o(47164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.4
 * JD-Core Version:    0.7.0.1
 */