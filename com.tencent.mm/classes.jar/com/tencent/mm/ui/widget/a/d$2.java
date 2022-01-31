package com.tencent.mm.ui.widget.a;

import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

final class d$2
  extends BottomSheetBehavior.a
{
  d$2(d paramd) {}
  
  public final void g(float paramFloat)
  {
    if ((d.i(this.wnq) != null) && (!d.j(this.wnq)))
    {
      if ((d.k(this.wnq).canScrollVertically(-1)) && (d.l(this.wnq)) && (paramFloat != 0.0F)) {
        d.i(this.wnq).setVisibility(0);
      }
    }
    else {
      return;
    }
    d.i(this.wnq).setVisibility(4);
  }
  
  public final void y(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d.2
 * JD-Core Version:    0.7.0.1
 */