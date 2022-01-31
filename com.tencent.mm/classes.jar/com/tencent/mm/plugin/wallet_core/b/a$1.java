package com.tencent.mm.plugin.wallet_core.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.qqs.b(this.qlW, this.qqs.kke);
    if (this.qlW.aSk()) {
      this.qlW.finish();
    }
    WalletBaseUI.cNh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.1
 * JD-Core Version:    0.7.0.1
 */