package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBankcardIdUI$8
  implements DialogInterface.OnClickListener
{
  WalletBankcardIdUI$8(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70730);
    if (WalletBankcardIdUI.e(this.VMc) == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = WalletBankcardIdUI.f(this.VMc).findFocus())
    {
      if ((paramDialogInterface != null) && ((paramDialogInterface instanceof EditText))) {
        this.VMc.showVKB();
      }
      AppMethodBeat.o(70730);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.8
 * JD-Core Version:    0.7.0.1
 */