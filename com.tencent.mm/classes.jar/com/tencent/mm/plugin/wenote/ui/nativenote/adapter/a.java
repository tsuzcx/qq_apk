package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a
  extends RecyclerView.l
{
  private int xwL;
  
  public abstract void dvT();
  
  public abstract void dvU();
  
  public abstract void dvV();
  
  public abstract void iEI();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    if (Math.abs(paramInt2) > this.xwL)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label91;
        }
        dvV();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      return;
      paramInt1 = 0;
      break;
      label91:
      if (!paramRecyclerView.canScrollVertically(1)) {
        iEI();
      } else if (paramInt2 < 0) {
        dvT();
      } else if (paramInt2 > 0) {
        dvU();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
 * JD-Core Version:    0.7.0.1
 */