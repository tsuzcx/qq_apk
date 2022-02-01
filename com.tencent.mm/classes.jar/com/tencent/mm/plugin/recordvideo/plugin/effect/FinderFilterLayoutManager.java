package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScroller", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "CenterSmoothScroller", "plugin-recordvideo_release"})
public final class FinderFilterLayoutManager
  extends LinearLayoutManager
{
  private final a xSH;
  
  public FinderFilterLayoutManager(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(206630);
    this.xSH = new a(paramContext);
    AppMethodBeat.o(206630);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(206629);
    p.h(paramRecyclerView, "recyclerView");
    this.xSH.cz(paramInt);
    a((RecyclerView.s)this.xSH);
    AppMethodBeat.o(206629);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-recordvideo_release"})
  public final class a
    extends ae
  {
    public a()
    {
      super();
      AppMethodBeat.i(206628);
      AppMethodBeat.o(206628);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(206627);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 100.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(206627);
      return f;
    }
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager
 * JD-Core Version:    0.7.0.1
 */