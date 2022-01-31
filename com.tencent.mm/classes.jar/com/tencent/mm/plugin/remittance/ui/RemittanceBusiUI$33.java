package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class RemittanceBusiUI$33
  implements View.OnTouchListener
{
  RemittanceBusiUI$33(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142205);
    if ((RemittanceBusiUI.q(this.qoF) != null) && (RemittanceBusiUI.r(this.qoF).isShown()) && (RemittanceBusiUI.s(this.qoF).dRV()))
    {
      RemittanceBusiUI.t(this.qoF).dRT();
      AppMethodBeat.o(142205);
      return true;
    }
    AppMethodBeat.o(142205);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.33
 * JD-Core Version:    0.7.0.1
 */