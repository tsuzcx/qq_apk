package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletLqtSaveFetchUI$17
  implements TextView.OnEditorActionListener
{
  WalletLqtSaveFetchUI$17(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213986);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
      WalletLqtSaveFetchUI.w(this.HBI);
      h.CyF.a(20287, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(213986);
      return true;
    }
    AppMethodBeat.o(213986);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.17
 * JD-Core Version:    0.7.0.1
 */