package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLayoutManager", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "onScrolled", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "plugin-multitalk_release"})
public abstract class c
  extends RecyclerView.l
{
  private LinearLayoutManager vKp;
  
  public c(LinearLayoutManager paramLinearLayoutManager)
  {
    this.vKp = paramLinearLayoutManager;
  }
  
  public abstract void epH();
  
  public abstract boolean epI();
  
  public abstract boolean isLoading();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    p.h(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this.vKp;
    if (paramRecyclerView == null) {
      p.hyc();
    }
    paramInt1 = paramRecyclerView.getChildCount();
    paramRecyclerView = this.vKp;
    if (paramRecyclerView == null) {
      p.hyc();
    }
    paramInt2 = paramRecyclerView.getItemCount();
    paramRecyclerView = this.vKp;
    if (paramRecyclerView == null) {
      p.hyc();
    }
    int i = paramRecyclerView.ks();
    if ((!isLoading()) && (!epI()) && (paramInt1 + i >= paramInt2) && (i >= 0)) {
      epH();
    }
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */