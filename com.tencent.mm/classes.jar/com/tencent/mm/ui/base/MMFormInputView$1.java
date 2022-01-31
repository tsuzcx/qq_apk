package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.ac.a.f;

final class MMFormInputView$1
  implements View.OnFocusChangeListener
{
  MMFormInputView$1(MMFormInputView paramMMFormInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == MMFormInputView.a(this.uUT))
    {
      MMFormInputView.b(this.uUT);
      if (!paramBoolean) {
        break label64;
      }
      this.uUT.setBackgroundResource(a.f.input_bar_bg_active);
    }
    for (;;)
    {
      MMFormInputView.c(this.uUT);
      if (MMFormInputView.d(this.uUT) != null) {
        MMFormInputView.d(this.uUT).onFocusChange(paramView, paramBoolean);
      }
      return;
      label64:
      this.uUT.setBackgroundResource(a.f.input_bar_bg_normal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView.1
 * JD-Core Version:    0.7.0.1
 */