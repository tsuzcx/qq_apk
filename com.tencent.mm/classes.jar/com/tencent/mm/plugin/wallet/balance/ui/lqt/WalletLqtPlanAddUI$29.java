package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class WalletLqtPlanAddUI$29
  implements View.OnTouchListener
{
  WalletLqtPlanAddUI$29(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68864);
    if ((WalletLqtPlanAddUI.j(this.Hzj).isShown()) && (WalletLqtPlanAddUI.k(this.Hzj).hgP()))
    {
      this.Hzj.hideWcKb();
      AppMethodBeat.o(68864);
      return true;
    }
    AppMethodBeat.o(68864);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.29
 * JD-Core Version:    0.7.0.1
 */