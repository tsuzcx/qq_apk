package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBankcardIdUI$9
  implements DialogInterface.OnClickListener
{
  WalletBankcardIdUI$9(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70730);
    if (WalletBankcardIdUI.e(this.DcG) == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = WalletBankcardIdUI.f(this.DcG).findFocus())
    {
      if ((paramDialogInterface != null) && ((paramDialogInterface instanceof EditText))) {
        this.DcG.showVKB();
      }
      AppMethodBeat.o(70730);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.9
 * JD-Core Version:    0.7.0.1
 */