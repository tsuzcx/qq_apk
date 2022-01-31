package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMFormVerifyCodeInputView$2
  implements View.OnClickListener
{
  MMFormVerifyCodeInputView$2(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106593);
    if (MMFormVerifyCodeInputView.e(this.zjB) != null) {
      MMFormVerifyCodeInputView.e(this.zjB).onClick(paramView);
    }
    AppMethodBeat.o(106593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.2
 * JD-Core Version:    0.7.0.1
 */