package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$3
  implements View.OnLongClickListener
{
  MMViewPager$3(MMViewPager paramMMViewPager) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(106899);
    if (MMViewPager.p(this.znE) != null) {
      MMViewPager.p(this.znE).bxv();
    }
    AppMethodBeat.o(106899);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.3
 * JD-Core Version:    0.7.0.1
 */