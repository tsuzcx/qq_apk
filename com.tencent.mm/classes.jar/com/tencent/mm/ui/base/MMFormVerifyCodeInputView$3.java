package com.tencent.mm.ui.base;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class MMFormVerifyCodeInputView$3
  implements ap.a
{
  MMFormVerifyCodeInputView$3(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(106594);
    MMFormVerifyCodeInputView.f(this.zjB);
    MMFormVerifyCodeInputView.h(this.zjB).setText(this.zjB.getContext().getString(2131301595, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(this.zjB)) }));
    if (MMFormVerifyCodeInputView.g(this.zjB) == 0)
    {
      MMFormVerifyCodeInputView.i(this.zjB).stopTimer();
      MMFormVerifyCodeInputView.a(this.zjB, MMFormVerifyCodeInputView.j(this.zjB));
      MMFormVerifyCodeInputView.k(this.zjB).setVisibility(0);
      MMFormVerifyCodeInputView.h(this.zjB).setVisibility(8);
    }
    AppMethodBeat.o(106594);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.3
 * JD-Core Version:    0.7.0.1
 */