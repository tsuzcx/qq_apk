package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMNeat7extView$2
  implements View.OnLongClickListener
{
  MMNeat7extView$2(MMNeat7extView paramMMNeat7extView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(143365);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if (MMNeat7extView.afTn) {
      Toast.makeText(this.afTt.getContext(), MMNeat7extView.bDu(this.afTt.jPy().toString()), 1).show();
    }
    if (MMNeat7extView.f(this.afTt) != null)
    {
      boolean bool = MMNeat7extView.f(this.afTt).onLongClick(paramView);
      a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(143365);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(143365);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNeat7extView.2
 * JD-Core Version:    0.7.0.1
 */