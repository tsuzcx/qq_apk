package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMFormMobileInputView$1
  implements View.OnFocusChangeListener
{
  MMFormMobileInputView$1(MMFormMobileInputView paramMMFormMobileInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(106570);
    if ((paramView == MMFormMobileInputView.a(this.zjv)) || (paramView == MMFormMobileInputView.b(this.zjv))) {
      this.zjv.qC(paramBoolean);
    }
    AppMethodBeat.o(106570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView.1
 * JD-Core Version:    0.7.0.1
 */