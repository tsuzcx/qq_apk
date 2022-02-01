package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.e;

final class g$1
  extends RecyclerView.m
{
  g$1(g paramg) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178926);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.vba;
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      g.a(paramRecyclerView, bool);
      a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(178926);
      return;
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(178925);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    super.b(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (g.a(this.vba))) {
      e.ot(false);
    }
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkInvitingUILogic$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(178925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g.1
 * JD-Core Version:    0.7.0.1
 */