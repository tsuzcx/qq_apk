package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMFormInputView$1
  implements View.OnFocusChangeListener
{
  MMFormInputView$1(MMFormInputView paramMMFormInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(106556);
    if (paramView == MMFormInputView.a(this.zjo))
    {
      MMFormInputView.b(this.zjo);
      if (!paramBoolean) {
        break label73;
      }
      this.zjo.setBackgroundResource(2130839162);
    }
    for (;;)
    {
      MMFormInputView.c(this.zjo);
      if (MMFormInputView.d(this.zjo) != null) {
        MMFormInputView.d(this.zjo).onFocusChange(paramView, paramBoolean);
      }
      AppMethodBeat.o(106556);
      return;
      label73:
      this.zjo.setBackgroundResource(2130839163);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView.1
 * JD-Core Version:    0.7.0.1
 */