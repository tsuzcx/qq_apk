package com.tencent.mm.plugin.remittance.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class RemittanceNewBaseUI$33
  implements View.OnTouchListener
{
  RemittanceNewBaseUI$33(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142264);
    if ((RemittanceNewBaseUI.i(this.qqR).isShown()) && (RemittanceNewBaseUI.j(this.qqR).dRV()))
    {
      RemittanceNewBaseUI.k(this.qqR).dRT();
      AppMethodBeat.o(142264);
      return true;
    }
    AppMethodBeat.o(142264);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.33
 * JD-Core Version:    0.7.0.1
 */