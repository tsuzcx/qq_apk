package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletLqtSaveFetchUI$14
  implements TextView.OnEditorActionListener
{
  WalletLqtSaveFetchUI$14(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68992);
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ad.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
      this.vzz.onClick(null);
      AppMethodBeat.o(68992);
      return true;
    }
    AppMethodBeat.o(68992);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.14
 * JD-Core Version:    0.7.0.1
 */