package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletSwitchVerifyPhoneUI$3
  implements j.a
{
  WalletSwitchVerifyPhoneUI$3(WalletSwitchVerifyPhoneUI paramWalletSwitchVerifyPhoneUI, hc paramhc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47672);
    ab.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
    WalletSwitchVerifyPhoneUI.a(this.utO, this.utP);
    AppMethodBeat.o(47672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.3
 * JD-Core Version:    0.7.0.1
 */