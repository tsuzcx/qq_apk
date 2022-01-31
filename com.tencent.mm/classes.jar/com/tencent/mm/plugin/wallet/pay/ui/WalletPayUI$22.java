package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class WalletPayUI$22
  implements DialogInterface.OnClickListener
{
  WalletPayUI$22(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46060);
    if (this.tXt.isChecked())
    {
      g.RM();
      g.RL().Ru().set(196614, Boolean.FALSE);
    }
    this.tXq.nz(false);
    AppMethodBeat.o(46060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.22
 * JD-Core Version:    0.7.0.1
 */