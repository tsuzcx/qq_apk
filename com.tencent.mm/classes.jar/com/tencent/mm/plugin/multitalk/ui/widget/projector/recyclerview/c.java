package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends RecyclerView.l
{
  private LinearLayoutManager AJH;
  
  public c(LinearLayoutManager paramLinearLayoutManager)
  {
    this.AJH = paramLinearLayoutManager;
  }
  
  public abstract void giu();
  
  public abstract boolean giv();
  
  public abstract boolean isLoading();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.AJH;
    s.checkNotNull(paramRecyclerView);
    paramInt1 = paramRecyclerView.getChildCount();
    paramRecyclerView = this.AJH;
    s.checkNotNull(paramRecyclerView);
    paramInt2 = paramRecyclerView.getItemCount();
    paramRecyclerView = this.AJH;
    s.checkNotNull(paramRecyclerView);
    int i = paramRecyclerView.Ju();
    if ((!isLoading()) && (!giv()) && (paramInt1 + i >= paramInt2) && (i >= 0)) {
      giu();
    }
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */