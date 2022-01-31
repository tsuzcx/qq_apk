package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletIapUI$5
  implements DialogInterface.OnCancelListener
{
  WalletIapUI$5(WalletIapUI paramWalletIapUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48277);
    ab.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.g(this.uBu)) });
    if (WalletIapUI.g(this.uBu) == 2) {}
    for (paramDialogInterface = b.bu(7, "");; paramDialogInterface = b.bu(1, ""))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_err_code", paramDialogInterface.nGE);
      localIntent.putExtra("key_err_msg", paramDialogInterface.nGF);
      this.uBu.setResult(-1, localIntent);
      this.uBu.finish();
      AppMethodBeat.o(48277);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.5
 * JD-Core Version:    0.7.0.1
 */