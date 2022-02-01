package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBankcardIdUI$4
  implements l.a
{
  WalletBankcardIdUI$4(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70725);
    Log.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
    WalletBankcardIdUI.a(this.Idw);
    AppMethodBeat.o(70725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.4
 * JD-Core Version:    0.7.0.1
 */