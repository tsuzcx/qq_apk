package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$9
  implements DialogInterface.OnClickListener
{
  b$9(b paramb, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45874);
    paramDialogInterface = (Bankcard)b.B(this.tVh).getParcelable("key_bankcard");
    PayInfo localPayInfo = (PayInfo)b.C(this.tVh).getParcelable("key_pay_info");
    if ((paramDialogInterface != null) && (localPayInfo != null)) {
      paramDialogInterface.ufL = localPayInfo.cnI;
    }
    b.D(this.tVh).putInt("key_err_code", -1004);
    this.tVh.a(this.tVi, 0, b.E(this.tVh));
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    AppMethodBeat.o(45874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.9
 * JD-Core Version:    0.7.0.1
 */