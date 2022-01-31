package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class WalletPayUI$21
  implements DialogInterface.OnClickListener
{
  WalletPayUI$21(WalletPayUI paramWalletPayUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.qnY.isChecked())
    {
      g.DQ();
      g.DP().Dz().o(196614, Boolean.valueOf(false));
    }
    this.qnV.kw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.21
 * JD-Core Version:    0.7.0.1
 */