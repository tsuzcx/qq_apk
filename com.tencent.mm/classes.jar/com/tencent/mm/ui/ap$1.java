package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ap$1
  implements View.OnClickListener
{
  ap$1(ap paramap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159100);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (ap.a(this.adJJ) != null) {
      ap.a(this.adJJ).onClickBackBtn(paramView);
    }
    a.a(this, "com/tencent/mm/ui/SearchBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ap.1
 * JD-Core Version:    0.7.0.1
 */