package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class GestureGuardLogicUI$8
  implements DialogInterface.OnCancelListener
{
  GestureGuardLogicUI$8(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    GestureGuardLogicUI.l(this.qPX)[GestureGuardLogicUI.m(this.qPX)].qQf.bYt();
    if ((GestureGuardLogicUI.p(this.qPX) != null) && (!GestureGuardLogicUI.p(this.qPX).aSd)) {
      g.Dk().c(GestureGuardLogicUI.p(this.qPX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.8
 * JD-Core Version:    0.7.0.1
 */