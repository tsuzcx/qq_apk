package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;

final class WalletPayUI$24
  implements DialogInterface.OnClickListener
{
  WalletPayUI$24(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(69413);
    if (this.HHI.isChecked())
    {
      g.aAi();
      g.aAh().azQ().set(196614, Boolean.FALSE);
    }
    this.HHF.xW(false);
    AppMethodBeat.o(69413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.24
 * JD-Core Version:    0.7.0.1
 */