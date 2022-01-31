package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletSecuritySettingUI$3
  implements View.OnClickListener
{
  WalletSecuritySettingUI$3(WalletSecuritySettingUI paramWalletSecuritySettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46395);
    ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
    this.uaz.finish();
    AppMethodBeat.o(46395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.3
 * JD-Core Version:    0.7.0.1
 */