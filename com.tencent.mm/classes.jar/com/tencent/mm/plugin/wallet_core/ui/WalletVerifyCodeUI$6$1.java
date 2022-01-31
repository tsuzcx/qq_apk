package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;

final class WalletVerifyCodeUI$6$1
  implements DialogInterface.OnClickListener
{
  WalletVerifyCodeUI$6$1(WalletVerifyCodeUI.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47694);
    ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
    paramDialogInterface = this.uuo.uul.getInput();
    paramDialogInterface.putInt("key_err_code", 408);
    a.j(this.uuo.uul, paramDialogInterface);
    this.uuo.uul.finish();
    AppMethodBeat.o(47694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.6.1
 * JD-Core Version:    0.7.0.1
 */