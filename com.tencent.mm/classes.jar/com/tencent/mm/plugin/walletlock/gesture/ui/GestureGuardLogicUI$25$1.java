package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.sdk.platformtools.ah;

final class GestureGuardLogicUI$25$1
  implements Runnable
{
  GestureGuardLogicUI$25$1(GestureGuardLogicUI.25 param25) {}
  
  public final void run()
  {
    GestureGuardLogicUI.f(this.qQc.qPX).removeCallbacks(this);
    this.qQc.qQb.qQf.bYt();
    GestureGuardLogicUI.a(this.qQc.qPX, 16);
    GestureGuardLogicUI.g(this.qQc.qPX);
    GestureGuardLogicUI.h(this.qQc.qPX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.25.1
 * JD-Core Version:    0.7.0.1
 */