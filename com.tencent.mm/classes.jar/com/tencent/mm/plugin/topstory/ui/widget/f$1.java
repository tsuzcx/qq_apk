package com.tencent.mm.plugin.topstory.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class f$1
  extends RecyclerView.l
{
  boolean awK = false;
  
  f$1(f paramf) {}
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(126674);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.awK))
    {
      this.awK = false;
      this.Grf.mz();
    }
    a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(126674);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236420);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.awK = true;
    }
    a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(236420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f.1
 * JD-Core Version:    0.7.0.1
 */