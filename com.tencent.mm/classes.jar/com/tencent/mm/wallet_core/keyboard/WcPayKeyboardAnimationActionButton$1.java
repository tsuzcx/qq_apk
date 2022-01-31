package com.tencent.mm.wallet_core.keyboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayKeyboardAnimationActionButton$1
  implements View.OnClickListener
{
  WcPayKeyboardAnimationActionButton$1(WcPayKeyboardAnimationActionButton paramWcPayKeyboardAnimationActionButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142633);
    if (WcPayKeyboardAnimationActionButton.a(this.AWB) != null) {
      WcPayKeyboardAnimationActionButton.a(this.AWB).dRW();
    }
    AppMethodBeat.o(142633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton.1
 * JD-Core Version:    0.7.0.1
 */