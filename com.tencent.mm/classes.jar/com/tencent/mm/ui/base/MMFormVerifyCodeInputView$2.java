package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMFormVerifyCodeInputView$2
  implements View.OnClickListener
{
  MMFormVerifyCodeInputView$2(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141936);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (MMFormVerifyCodeInputView.e(this.OQk) != null) {
      MMFormVerifyCodeInputView.e(this.OQk).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(141936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.2
 * JD-Core Version:    0.7.0.1
 */