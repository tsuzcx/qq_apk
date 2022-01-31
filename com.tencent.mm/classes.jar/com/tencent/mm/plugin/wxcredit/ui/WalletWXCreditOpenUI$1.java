package com.tencent.mm.plugin.wxcredit.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditOpenUI$1
  implements CompoundButton.OnCheckedChangeListener
{
  WalletWXCreditOpenUI$1(WalletWXCreditOpenUI paramWalletWXCreditOpenUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(48750);
    WalletWXCreditOpenUI.a(this.vIK).setEnabled(paramBoolean);
    AppMethodBeat.o(48750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.1
 * JD-Core Version:    0.7.0.1
 */