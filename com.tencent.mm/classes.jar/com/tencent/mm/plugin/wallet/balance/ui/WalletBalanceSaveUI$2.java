package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceSaveUI$2
  implements TextView.OnEditorActionListener
{
  WalletBalanceSaveUI$2(WalletBalanceSaveUI paramWalletBalanceSaveUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213911);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66)) {
      this.jVJ.onClick(null);
    }
    AppMethodBeat.o(213911);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.2
 * JD-Core Version:    0.7.0.1
 */