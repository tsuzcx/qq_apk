package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScroller", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "CenterSmoothScroller", "plugin-recordvideo_release"})
public final class FinderFilterLayoutManager
  extends LinearLayoutManager
{
  private final a wuQ;
  
  public FinderFilterLayoutManager(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(199328);
    this.wuQ = new a(paramContext);
    AppMethodBeat.o(199328);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(199327);
    k.h(paramRecyclerView, "recyclerView");
    this.wuQ.cz(paramInt);
    a((RecyclerView.s)this.wuQ);
    AppMethodBeat.o(199327);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-recordvideo_release"})
  public final class a
    extends ae
  {
    public a()
    {
      super();
      AppMethodBeat.i(199326);
      AppMethodBeat.o(199326);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(199325);
      k.h(paramDisplayMetrics, "displayMetrics");
      float f = 100.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(199325);
      return f;
    }
    
    public final int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager
 * JD-Core Version:    0.7.0.1
 */