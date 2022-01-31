package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.d;

final class WalletDigitalCertUI$1
  extends d
{
  WalletDigitalCertUI$1(WalletDigitalCertUI paramWalletDigitalCertUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46251);
    paramView = new Intent();
    paramView.setClass(this.tYR, WalletIdCardCheckUI.class);
    this.tYR.startActivityForResult(paramView, 1);
    AppMethodBeat.o(46251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.1
 * JD-Core Version:    0.7.0.1
 */