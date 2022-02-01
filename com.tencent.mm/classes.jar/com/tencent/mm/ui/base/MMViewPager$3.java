package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMViewPager$3
  implements View.OnLongClickListener
{
  MMViewPager$3(MMViewPager paramMMViewPager) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(142262);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    if (MMViewPager.p(this.OUs) != null) {
      MMViewPager.p(this.OUs).bmu();
    }
    a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(142262);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.3
 * JD-Core Version:    0.7.0.1
 */