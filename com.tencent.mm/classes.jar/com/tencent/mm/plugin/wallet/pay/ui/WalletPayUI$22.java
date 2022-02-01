package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;

final class WalletPayUI$22
  implements DialogInterface.OnClickListener
{
  WalletPayUI$22(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(69411);
    if (this.zRG.isChecked())
    {
      g.afC();
      g.afB().afk().set(196614, Boolean.FALSE);
    }
    this.zRD.st(false);
    AppMethodBeat.o(69411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.22
 * JD-Core Version:    0.7.0.1
 */