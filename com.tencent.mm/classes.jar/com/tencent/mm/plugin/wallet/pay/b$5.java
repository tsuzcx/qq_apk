package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$5
  implements DialogInterface.OnClickListener
{
  b$5(b paramb, int paramInt, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.u(this.qlV).putInt("key_pay_flag", 3);
    b.v(this.qlV).putInt("key_err_code", this.bEg);
    this.qlV.a(this.qlW, 0, b.w(this.qlV));
    if (this.qlW.aSk()) {
      this.qlW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.5
 * JD-Core Version:    0.7.0.1
 */