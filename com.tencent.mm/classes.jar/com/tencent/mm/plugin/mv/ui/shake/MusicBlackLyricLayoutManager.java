package com.tencent.mm.plugin.mv.ui.shake;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/shake/MusicBlackLyricLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToPosition", "position", "scrollVerticallyBy", "dy", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicBlackLyricLayoutManager
  extends LinearLayoutManager
{
  private final Context context;
  
  private MusicBlackLyricLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(287342);
    this.context = paramContext;
    AppMethodBeat.o(287342);
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(287357);
    super.onLayoutCompleted(params);
    AppMethodBeat.o(287357);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(287366);
    bo(paramInt, a.fromDPToPix(this.context, 30));
    AppMethodBeat.o(287366);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(287373);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(287373);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(287353);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView = new a(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(287353);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/shake/MusicBlackLyricLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends o
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(287426);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 600.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(287426);
      return f;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.MusicBlackLyricLayoutManager
 * JD-Core Version:    0.7.0.1
 */