package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "CenterSmoothScroller", "plugin-vlog_release"})
public final class EditorCaptionLayoutManager
  extends LinearLayoutManager
{
  public EditorCaptionLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(191611);
    AppMethodBeat.o(191611);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(191610);
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(191610);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-vlog_release"})
  public final class a
    extends ae
  {
    public a()
    {
      super();
      AppMethodBeat.i(191609);
      AppMethodBeat.o(191609);
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(191608);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 200.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(191608);
      return f;
    }
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorCaptionLayoutManager
 * JD-Core Version:    0.7.0.1
 */