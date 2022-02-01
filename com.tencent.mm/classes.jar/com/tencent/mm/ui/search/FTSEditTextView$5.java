package com.tencent.mm.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSEditTextView$5
  implements View.OnClickListener
{
  FTSEditTextView$5(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(250019);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/search/FTSEditTextView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (FTSEditTextView.j(this.afCi) != null) {
      FTSEditTextView.j(this.afCi).iAx();
    }
    a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(250019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView.5
 * JD-Core Version:    0.7.0.1
 */