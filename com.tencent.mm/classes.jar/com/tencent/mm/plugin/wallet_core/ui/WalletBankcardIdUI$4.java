package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletBankcardIdUI$4
  implements l.a
{
  WalletBankcardIdUI$4(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70725);
    ad.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
    WalletBankcardIdUI.a(this.DcG);
    AppMethodBeat.o(70725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.4
 * JD-Core Version:    0.7.0.1
 */