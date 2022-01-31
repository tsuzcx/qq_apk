package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.ac.a.f;

final class MMFormVerifyCodeInputView$1
  implements View.OnFocusChangeListener
{
  MMFormVerifyCodeInputView$1(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == MMFormVerifyCodeInputView.a(this.uVg))
    {
      MMFormVerifyCodeInputView.b(this.uVg);
      if (!paramBoolean) {
        break label64;
      }
      this.uVg.setBackgroundResource(a.f.input_bar_bg_active);
    }
    for (;;)
    {
      MMFormVerifyCodeInputView.c(this.uVg);
      if (MMFormVerifyCodeInputView.d(this.uVg) != null) {
        MMFormVerifyCodeInputView.d(this.uVg).onFocusChange(paramView, paramBoolean);
      }
      return;
      label64:
      this.uVg.setBackgroundResource(a.f.input_bar_bg_normal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.1
 * JD-Core Version:    0.7.0.1
 */