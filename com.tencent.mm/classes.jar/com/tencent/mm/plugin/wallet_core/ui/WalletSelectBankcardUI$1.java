package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class WalletSelectBankcardUI$1
  implements j.a
{
  WalletSelectBankcardUI$1(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47652);
    ab.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
    e.bT(this.utE, this.utE.getString(2131304853));
    AppMethodBeat.o(47652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.1
 * JD-Core Version:    0.7.0.1
 */