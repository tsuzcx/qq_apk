package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletPasswordSettingUI$10
  implements DialogInterface.OnClickListener
{
  WalletPasswordSettingUI$10(WalletPasswordSettingUI paramWalletPasswordSettingUI, l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46360);
    ab.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
    this.uac.dS(this.tZZ);
    AppMethodBeat.o(46360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.10
 * JD-Core Version:    0.7.0.1
 */