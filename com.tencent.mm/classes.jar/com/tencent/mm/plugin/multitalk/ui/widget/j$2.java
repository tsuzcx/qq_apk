package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.e;

final class j$2
  extends RecyclerView.m
{
  j$2(j paramj) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178930);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.vbT;
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      j.a(paramRecyclerView, bool);
      a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(178930);
      return;
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(178929);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    super.b(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (j.b(this.vbT)))
    {
      j.c(this.vbT);
      e.ot(true);
    }
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkTalkingUILogic$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(178929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j.2
 * JD-Core Version:    0.7.0.1
 */