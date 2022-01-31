package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class GestureGuardLogicUI$27
  implements GestureGuardLogicUI.a
{
  GestureGuardLogicUI$27(GestureGuardLogicUI paramGestureGuardLogicUI, a parama) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(51613);
    GestureGuardLogicUI.a(this.uFf, 0);
    this.uFj.uFn.cYe();
    this.uFj.uFn.setEnableInput(true);
    AppMethodBeat.o(51613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.27
 * JD-Core Version:    0.7.0.1
 */