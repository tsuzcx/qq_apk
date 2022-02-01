package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

final class WalletPayUI$25
  implements CompoundButton.OnCheckedChangeListener
{
  WalletPayUI$25(WalletPayUI paramWalletPayUI, d paramd) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(69414);
    paramCompoundButton = this.DbV.getButton(-2);
    if (paramBoolean)
    {
      paramCompoundButton.setEnabled(false);
      AppMethodBeat.o(69414);
      return;
    }
    paramCompoundButton.setEnabled(true);
    AppMethodBeat.o(69414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.25
 * JD-Core Version:    0.7.0.1
 */