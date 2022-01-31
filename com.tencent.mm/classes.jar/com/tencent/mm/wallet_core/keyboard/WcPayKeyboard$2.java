package com.tencent.mm.wallet_core.keyboard;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WcPayKeyboard$2
  implements WcPayKeyboardAnimationActionButton.a
{
  WcPayKeyboard$2(WcPayKeyboard paramWcPayKeyboard) {}
  
  public final void dRW()
  {
    AppMethodBeat.i(142613);
    ab.d("MicroMsg.WcPayKeyBoard", "onClickListener()");
    AppMethodBeat.o(142613);
  }
  
  public final void dRX()
  {
    AppMethodBeat.i(142614);
    ab.d("MicroMsg.WcPayKeyBoard", "animationFinish()");
    AppMethodBeat.o(142614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.2
 * JD-Core Version:    0.7.0.1
 */