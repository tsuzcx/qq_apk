package com.tencent.mm.view;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
public final class RecyclerHorizontalViewPager$d
  extends RecyclerView.m
{
  private final Rect LqD;
  private final Rect LqE;
  private int rwG;
  
  RecyclerHorizontalViewPager$d()
  {
    AppMethodBeat.i(164563);
    this.rwG = -1;
    this.LqD = new Rect();
    this.LqE = new Rect();
    AppMethodBeat.o(164563);
  }
  
  public final void a(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164562);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramRecyclerView);
    ((b)localObject1).mr(paramInt1);
    ((b)localObject1).mr(paramInt2);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject1).ahq());
    p.h(paramRecyclerView, "recyclerView");
    super.a(paramRecyclerView, paramInt1, paramInt2);
    localObject1 = this.LqF.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(164562);
      throw paramRecyclerView;
    }
    paramInt1 = ((LinearLayoutManager)localObject1).km();
    localObject1 = this.LqF.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(164562);
      throw paramRecyclerView;
    }
    paramInt2 = ((LinearLayoutManager)localObject1).ko();
    localObject1 = paramRecyclerView.ci(paramInt1);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).auu;
      RecyclerView.w localw = paramRecyclerView.ci(paramInt2);
      paramRecyclerView = localObject2;
      if (localw != null) {
        paramRecyclerView = localw.auu;
      }
      if (localObject1 != null) {
        ((View)localObject1).getLocalVisibleRect(this.LqD);
      }
      if (paramRecyclerView != null) {
        paramRecyclerView.getLocalVisibleRect(this.LqE);
      }
      if (this.LqD.width() <= this.LqE.width()) {
        break label292;
      }
    }
    for (;;)
    {
      if ((paramInt1 != this.rwG) && (paramInt1 != -1))
      {
        this.LqF.post((Runnable)new a(this, paramInt1));
        this.rwG = paramInt1;
      }
      a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(164562);
      return;
      localObject1 = null;
      break;
      label292:
      paramInt1 = paramInt2;
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(186648);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(186648);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164561);
      this.LqG.LqF.ad(paramInt1, true);
      AppMethodBeat.o(164561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager.d
 * JD-Core Version:    0.7.0.1
 */