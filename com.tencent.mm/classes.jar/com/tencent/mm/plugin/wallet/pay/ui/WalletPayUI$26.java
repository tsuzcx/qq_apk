package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

final class WalletPayUI$26
  implements CompoundButton.OnCheckedChangeListener
{
  WalletPayUI$26(WalletPayUI paramWalletPayUI, d paramd) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(214056);
    paramCompoundButton = this.HHJ.getButton(-2);
    if (paramBoolean)
    {
      paramCompoundButton.setEnabled(false);
      AppMethodBeat.o(214056);
      return;
    }
    paramCompoundButton.setEnabled(true);
    AppMethodBeat.o(214056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.26
 * JD-Core Version:    0.7.0.1
 */