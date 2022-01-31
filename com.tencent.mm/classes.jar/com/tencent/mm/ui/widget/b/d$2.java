package com.tencent.mm.ui.widget.b;

import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  extends BottomSheetBehavior.a
{
  d$2(d paramd) {}
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(112648);
    if ((d.i(this.AHn) != null) && (!d.j(this.AHn)))
    {
      if ((d.k(this.AHn).canScrollVertically(-1)) && (d.l(this.AHn)) && (paramFloat != 0.0F))
      {
        d.i(this.AHn).setVisibility(0);
        AppMethodBeat.o(112648);
        return;
      }
      d.i(this.AHn).setVisibility(4);
    }
    AppMethodBeat.o(112648);
  }
  
  public final void x(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.d.2
 * JD-Core Version:    0.7.0.1
 */