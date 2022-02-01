package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.a;

final class WalletBankcardIdUI$7
  implements DialogInterface.OnClickListener
{
  WalletBankcardIdUI$7(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70729);
    ((a)this.VMc.getProcess()).i(this.VMc, 0);
    this.VMc.finish();
    AppMethodBeat.o(70729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.7
 * JD-Core Version:    0.7.0.1
 */