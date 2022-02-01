package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "CenterSmoothScroller", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorCaptionLayoutManager
  extends LinearLayoutManager
{
  public EditorCaptionLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(283143);
    AppMethodBeat.o(283143);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(283151);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView = paramRecyclerView.getContext();
    s.s(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new a(paramRecyclerView);
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(283151);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager$CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends o
  {
    public a()
    {
      super();
      AppMethodBeat.i(283127);
      AppMethodBeat.o(283127);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(283138);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 200.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(283138);
      return f;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorCaptionLayoutManager
 * JD-Core Version:    0.7.0.1
 */