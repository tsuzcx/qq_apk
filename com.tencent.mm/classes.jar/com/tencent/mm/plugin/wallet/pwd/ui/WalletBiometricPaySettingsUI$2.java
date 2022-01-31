package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.bu.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBiometricPaySettingsUI$2
  implements DialogInterface.OnClickListener
{
  WalletBiometricPaySettingsUI$2(WalletBiometricPaySettingsUI paramWalletBiometricPaySettingsUI, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46222);
    paramDialogInterface = g.c(this.tYD.getContext(), false, null);
    bu localbu = new bu();
    bu.a locala = localbu.cpi;
    if (WalletBiometricPaySettingsUI.a(this.tYD).byS()) {}
    for (paramInt = 1;; paramInt = 2)
    {
      locala.cpk = paramInt;
      localbu.callback = new WalletBiometricPaySettingsUI.2.1(this, localbu, paramDialogInterface);
      a.ymk.a(localbu, this.tYD.getMainLooper());
      WalletBiometricPaySettingsUI.d(this.tYD);
      this.iLO.notifyDataSetChanged();
      AppMethodBeat.o(46222);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.2
 * JD-Core Version:    0.7.0.1
 */