package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class GestureGuardLogicUI$2
  implements GestureGuardLogicUI.a
{
  GestureGuardLogicUI$2(GestureGuardLogicUI paramGestureGuardLogicUI, PatternLockView paramPatternLockView) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(51587);
    this.uFg.cYe();
    this.uFg.setEnableInput(true);
    AppMethodBeat.o(51587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.2
 * JD-Core Version:    0.7.0.1
 */