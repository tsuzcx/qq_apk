package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.sdk.platformtools.ak;

final class GestureGuardLogicUI$25$1
  implements Runnable
{
  GestureGuardLogicUI$25$1(GestureGuardLogicUI.25 param25) {}
  
  public final void run()
  {
    AppMethodBeat.i(51610);
    GestureGuardLogicUI.f(this.uFk.uFf).removeCallbacks(this);
    this.uFk.uFj.uFn.cYe();
    GestureGuardLogicUI.a(this.uFk.uFf, 16);
    GestureGuardLogicUI.g(this.uFk.uFf);
    GestureGuardLogicUI.h(this.uFk.uFf);
    AppMethodBeat.o(51610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.25.1
 * JD-Core Version:    0.7.0.1
 */