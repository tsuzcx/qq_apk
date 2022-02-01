package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMFormVerifyCodeInputView$4
  implements View.OnClickListener
{
  MMFormVerifyCodeInputView$4(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251439);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/base/MMFormVerifyCodeInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (MMFormVerifyCodeInputView.f(this.adQu) != null) {
      MMFormVerifyCodeInputView.f(this.adQu).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/ui/base/MMFormVerifyCodeInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.4
 * JD-Core Version:    0.7.0.1
 */