package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;

final class WalletPayUI$24
  implements DialogInterface.OnClickListener
{
  WalletPayUI$24(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(69413);
    if (this.VoN.isChecked())
    {
      h.baF();
      h.baE().ban().B(196614, Boolean.FALSE);
    }
    this.VoK.Hv(false);
    AppMethodBeat.o(69413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.24
 * JD-Core Version:    0.7.0.1
 */