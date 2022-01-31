package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBindCardResultUI$4
  implements View.OnClickListener
{
  WalletBindCardResultUI$4(WalletBindCardResultUI paramWalletBindCardResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47189);
    ab.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
    WalletBindCardResultUI.b(this.unQ);
    AppMethodBeat.o(47189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.4
 * JD-Core Version:    0.7.0.1
 */