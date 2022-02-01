package com.tencent.mm.view;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
public final class RecyclerHorizontalViewPager$d
  extends RecyclerView.l
{
  private final Rect RlE;
  private final Rect RlF;
  private int tex;
  
  RecyclerHorizontalViewPager$d()
  {
    AppMethodBeat.i(164563);
    this.tex = -1;
    this.RlE = new Rect();
    this.RlF = new Rect();
    AppMethodBeat.o(164563);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(204981);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(204981);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, final int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164562);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramRecyclerView);
    ((b)localObject1).pH(paramInt1);
    ((b)localObject1).pH(paramInt2);
    a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject1).axR());
    p.h(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    localObject1 = this.RlG.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(164562);
      throw paramRecyclerView;
    }
    paramInt1 = ((LinearLayoutManager)localObject1).ks();
    localObject1 = this.RlG.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(164562);
      throw paramRecyclerView;
    }
    paramInt2 = ((LinearLayoutManager)localObject1).ku();
    localObject1 = paramRecyclerView.ch(paramInt1);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).aus;
      RecyclerView.v localv = paramRecyclerView.ch(paramInt2);
      paramRecyclerView = localObject2;
      if (localv != null) {
        paramRecyclerView = localv.aus;
      }
      if (localObject1 != null) {
        ((View)localObject1).getLocalVisibleRect(this.RlE);
      }
      if (paramRecyclerView != null) {
        paramRecyclerView.getLocalVisibleRect(this.RlF);
      }
      if (this.RlE.width() <= this.RlF.width()) {
        break label292;
      }
    }
    for (;;)
    {
      if ((paramInt1 != this.tex) && (paramInt1 != -1))
      {
        this.RlG.post((Runnable)new a(this, paramInt1));
        this.tex = paramInt1;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(RecyclerHorizontalViewPager.d paramd, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164561);
      this.RlH.RlG.e(paramInt1, true, true);
      AppMethodBeat.o(164561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.RecyclerHorizontalViewPager.d
 * JD-Core Version:    0.7.0.1
 */