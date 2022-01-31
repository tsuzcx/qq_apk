package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class GestureGuardLogicUI$4
  implements DialogInterface.OnCancelListener
{
  GestureGuardLogicUI$4(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    GestureGuardLogicUI.l(this.qPX)[GestureGuardLogicUI.m(this.qPX)].qQf.bYt();
    if ((GestureGuardLogicUI.n(this.qPX) != null) && (!GestureGuardLogicUI.n(this.qPX).aSd)) {
      g.Dk().c(GestureGuardLogicUI.n(this.qPX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.4
 * JD-Core Version:    0.7.0.1
 */