package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletLqtPlanAddUI$12
  implements TextView.OnEditorActionListener
{
  WalletLqtPlanAddUI$12(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68846);
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      ad.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
      this.CCt.hideWcKb();
      AppMethodBeat.o(68846);
      return true;
    }
    AppMethodBeat.o(68846);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.12
 * JD-Core Version:    0.7.0.1
 */