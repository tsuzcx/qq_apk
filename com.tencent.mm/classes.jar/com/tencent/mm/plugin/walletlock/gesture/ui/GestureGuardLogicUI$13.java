package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class GestureGuardLogicUI$13
  implements DialogInterface.OnCancelListener
{
  GestureGuardLogicUI$13(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(51598);
    GestureGuardLogicUI.l(this.uFf)[GestureGuardLogicUI.m(this.uFf)].uFn.cYe();
    if ((GestureGuardLogicUI.n(this.uFf) != null) && (!GestureGuardLogicUI.n(this.uFf).isCanceled())) {
      g.Rc().a(GestureGuardLogicUI.n(this.uFf));
    }
    AppMethodBeat.o(51598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.13
 * JD-Core Version:    0.7.0.1
 */