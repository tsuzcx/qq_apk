package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.u.a;

final class WalletIbgAdapterUI$1
  implements DialogInterface.OnClickListener
{
  WalletIbgAdapterUI$1(WalletIbgAdapterUI paramWalletIbgAdapterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47836);
    u.a.dlq();
    Toast.makeText(this.uvU, this.uvU.getString(2131305902), 1).show();
    this.uvU.finish();
    AppMethodBeat.o(47836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI.1
 * JD-Core Version:    0.7.0.1
 */