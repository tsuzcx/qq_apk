package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletBalanceSaveUI$12
  implements TextView.OnEditorActionListener
{
  WalletBalanceSaveUI$12(WalletBalanceSaveUI paramWalletBalanceSaveUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68707);
    ad.d("MicroMsg.WalletBalanceSaveUI", "on action key: %s, %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66)) {
      this.xXl.onClick(null);
    }
    AppMethodBeat.o(68707);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.12
 * JD-Core Version:    0.7.0.1
 */