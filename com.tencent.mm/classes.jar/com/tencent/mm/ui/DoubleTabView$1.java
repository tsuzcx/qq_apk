package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class DoubleTabView$1
  implements View.OnClickListener
{
  DoubleTabView$1(DoubleTabView paramDoubleTabView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141284);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = ((Integer)paramView.getTag()).intValue();
    if (DoubleTabView.a(this.adxV) != null) {
      DoubleTabView.a(this.adxV).onTabClick(i);
    }
    a.a(this, "com/tencent/mm/ui/DoubleTabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(141284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.DoubleTabView.1
 * JD-Core Version:    0.7.0.1
 */