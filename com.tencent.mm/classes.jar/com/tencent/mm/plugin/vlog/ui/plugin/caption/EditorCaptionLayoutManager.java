package com.tencent.mm.plugin.vlog.ui.plugin.caption;

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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "CenterSmoothScroller", "plugin-vlog_release"})
public final class EditorCaptionLayoutManager
  extends LinearLayoutManager
{
  public EditorCaptionLayoutManager(Context paramContext)
  {
    super(1);
    AppMethodBeat.i(207866);
    AppMethodBeat.o(207866);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(207865);
    k.h(paramRecyclerView, "recyclerView");
    paramRecyclerView = paramRecyclerView.getContext();
    k.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cz(paramInt);
    a((RecyclerView.s)paramRecyclerView);
    AppMethodBeat.o(207865);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-vlog_release"})
  public final class a
    extends ae
  {
    public a()
    {
      super();
      AppMethodBeat.i(207864);
      AppMethodBeat.o(207864);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(207863);
      k.h(paramDisplayMetrics, "displayMetrics");
      float f = 100.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(207863);
      return f;
    }
    
    public final int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorCaptionLayoutManager
 * JD-Core Version:    0.7.0.1
 */