package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$6
  implements DialogInterface.OnClickListener
{
  a$6(a parama, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.qoe.b(this.qlW, a.g(this.qoe));
    if (this.qlW.aSk()) {
      this.qlW.finish();
    }
    WalletBaseUI.cNh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.6
 * JD-Core Version:    0.7.0.1
 */