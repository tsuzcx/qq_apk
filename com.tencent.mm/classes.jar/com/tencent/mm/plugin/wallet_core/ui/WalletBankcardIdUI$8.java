package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.a;

final class WalletBankcardIdUI$8
  implements DialogInterface.OnClickListener
{
  WalletBankcardIdUI$8(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47168);
    ((a)this.unn.getProcess()).e(this.unn, 0);
    this.unn.finish();
    AppMethodBeat.o(47168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.8
 * JD-Core Version:    0.7.0.1
 */