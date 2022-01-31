package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class MMFormMobileInputView$1
  implements View.OnFocusChangeListener
{
  MMFormMobileInputView$1(MMFormMobileInputView paramMMFormMobileInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView == MMFormMobileInputView.a(this.uVa)) || (paramView == MMFormMobileInputView.b(this.uVa))) {
      this.uVa.mZ(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.1
 * JD-Core Version:    0.7.0.1
 */