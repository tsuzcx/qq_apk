package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ap$2
  implements View.OnClickListener
{
  ap$2(ap paramap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159101);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ap.b(this.adJJ);
    a.a(this, "com/tencent/mm/ui/SearchBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ap.2
 * JD-Core Version:    0.7.0.1
 */