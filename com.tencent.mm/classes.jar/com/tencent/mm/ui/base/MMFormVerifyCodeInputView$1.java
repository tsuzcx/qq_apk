package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMFormVerifyCodeInputView$1
  implements View.OnFocusChangeListener
{
  MMFormVerifyCodeInputView$1(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(106592);
    if (paramView == MMFormVerifyCodeInputView.a(this.zjB))
    {
      MMFormVerifyCodeInputView.b(this.zjB);
      if (!paramBoolean) {
        break label73;
      }
      this.zjB.setBackgroundResource(2130839162);
    }
    for (;;)
    {
      MMFormVerifyCodeInputView.c(this.zjB);
      if (MMFormVerifyCodeInputView.d(this.zjB) != null) {
        MMFormVerifyCodeInputView.d(this.zjB).onFocusChange(paramView, paramBoolean);
      }
      AppMethodBeat.o(106592);
      return;
      label73:
      this.zjB.setBackgroundResource(2130839163);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.1
 * JD-Core Version:    0.7.0.1
 */