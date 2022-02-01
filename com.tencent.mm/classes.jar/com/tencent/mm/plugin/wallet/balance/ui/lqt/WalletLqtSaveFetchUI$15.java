package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

final class WalletLqtSaveFetchUI$15
  implements TextView.OnEditorActionListener
{
  WalletLqtSaveFetchUI$15(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(207224);
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ac.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
      this.wJE.onClick(null);
      h.wUl.f(20287, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(207224);
      return true;
    }
    AppMethodBeat.o(207224);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.15
 * JD-Core Version:    0.7.0.1
 */