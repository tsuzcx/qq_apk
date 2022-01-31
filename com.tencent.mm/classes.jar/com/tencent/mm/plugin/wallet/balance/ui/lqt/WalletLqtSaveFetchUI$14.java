package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtSaveFetchUI$14
  implements TextView.OnEditorActionListener
{
  WalletLqtSaveFetchUI$14(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(155087);
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ab.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
      this.qoN.onClick(null);
      AppMethodBeat.o(155087);
      return true;
    }
    AppMethodBeat.o(155087);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.14
 * JD-Core Version:    0.7.0.1
 */