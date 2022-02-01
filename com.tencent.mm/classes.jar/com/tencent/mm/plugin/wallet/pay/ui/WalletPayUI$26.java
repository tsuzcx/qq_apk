package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;

final class WalletPayUI$26
  implements CompoundButton.OnCheckedChangeListener
{
  WalletPayUI$26(WalletPayUI paramWalletPayUI, e parame) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(315519);
    paramCompoundButton = this.VoO.aEJ(-2);
    if (paramBoolean)
    {
      paramCompoundButton.setEnabled(false);
      AppMethodBeat.o(315519);
      return;
    }
    paramCompoundButton.setEnabled(true);
    AppMethodBeat.o(315519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.26
 * JD-Core Version:    0.7.0.1
 */