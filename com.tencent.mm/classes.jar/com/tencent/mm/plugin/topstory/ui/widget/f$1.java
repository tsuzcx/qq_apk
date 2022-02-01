package com.tencent.mm.plugin.topstory.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class f$1
  extends RecyclerView.m
{
  boolean awM = false;
  
  f$1(f paramf) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199603);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.awM = true;
    }
    a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(199603);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(126674);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.awM))
    {
      this.awM = false;
      this.Bza.mv();
    }
    a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(126674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.f.1
 * JD-Core Version:    0.7.0.1
 */