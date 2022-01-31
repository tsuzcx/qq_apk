package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class WalletBrandUI$1
  implements DialogInterface.OnCancelListener
{
  WalletBrandUI$1(WalletBrandUI paramWalletBrandUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.DQ();
    g.DO().dJT.c(this.bEe);
    this.qLY.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.1
 * JD-Core Version:    0.7.0.1
 */