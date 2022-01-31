package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$8
  implements DialogInterface.OnClickListener
{
  b$8(b paramb, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (Bankcard)b.A(this.qlV).getParcelable("key_bankcard");
    PayInfo localPayInfo = (PayInfo)b.B(this.qlV).getParcelable("key_pay_info");
    if ((paramDialogInterface != null) && (localPayInfo != null)) {
      paramDialogInterface.qtx = localPayInfo.bMX;
    }
    b.C(this.qlV).putInt("key_err_code", -1004);
    this.qlV.a(this.qlW, 0, b.D(this.qlV));
    if (this.qlW.aSk()) {
      this.qlW.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.8
 * JD-Core Version:    0.7.0.1
 */