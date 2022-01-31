package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class WalletLqtSaveFetchUI$12
  implements View.OnTouchListener
{
  WalletLqtSaveFetchUI$12(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142330);
    if ((WalletLqtSaveFetchUI.b(this.tRZ).isShown()) && (WalletLqtSaveFetchUI.c(this.tRZ).dRV()))
    {
      WalletLqtSaveFetchUI.d(this.tRZ).dRT();
      AppMethodBeat.o(142330);
      return true;
    }
    AppMethodBeat.o(142330);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.12
 * JD-Core Version:    0.7.0.1
 */