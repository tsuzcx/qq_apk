package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a
  extends RecyclerView.m
{
  private int oOF;
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    if (Math.abs(paramInt2) > this.oOF)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label91;
        }
        bZo();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      return;
      paramInt1 = 0;
      break;
      label91:
      if (!paramRecyclerView.canScrollVertically(1)) {
        eIz();
      } else if (paramInt2 < 0) {
        bZm();
      } else if (paramInt2 > 0) {
        bZn();
      }
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    super.b(paramRecyclerView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/adapter/NoteRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public abstract void bZm();
  
  public abstract void bZn();
  
  public abstract void bZo();
  
  public abstract void eIz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a
 * JD-Core Version:    0.7.0.1
 */