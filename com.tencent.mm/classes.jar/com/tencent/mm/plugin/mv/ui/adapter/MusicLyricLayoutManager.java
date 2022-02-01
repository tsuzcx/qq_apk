package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.mv.b.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "alphaStartOffset", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "position", "updateChild", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicLyricLayoutManager
  extends LinearLayoutManager
{
  private final int MaH;
  
  private MusicLyricLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(287284);
    this.MaH = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(287284);
  }
  
  private final void dDo()
  {
    AppMethodBeat.i(287294);
    int n = getChildCount();
    int i;
    int k;
    View localView;
    int j;
    int i1;
    int m;
    Object localObject;
    if (n > 0)
    {
      i = 0;
      k = i + 1;
      localView = getChildAt(i);
      if (localView != null)
      {
        j = (localView.getTop() + localView.getBottom()) / 2;
        i1 = getHeight() / 2;
        m = localView.getMeasuredHeight();
        localObject = localView.findViewById(b.e.LSW);
        if (!(localObject instanceof TextView)) {
          break label170;
        }
        localObject = (TextView)localObject;
        if (localObject != null) {
          break label176;
        }
        i = 0;
        label95:
        if (i <= 1) {
          break label199;
        }
        i = m / 2;
        j = (localView.getBottom() + j) / 2;
      }
    }
    for (;;)
    {
      if (i - Math.abs(j - i1) > this.MaH) {
        localView.setAlpha(Math.min(1.0F - Math.abs(j - i1) / (i - this.MaH), 1.0F));
      }
      for (;;)
      {
        if (k < n) {
          break label194;
        }
        AppMethodBeat.o(287294);
        return;
        label170:
        localObject = null;
        break;
        label176:
        i = ((TextView)localObject).getLineCount();
        break label95;
        localView.setAlpha(0.0F);
      }
      label194:
      i = k;
      break;
      label199:
      i = m;
    }
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(287299);
    super.onLayoutCompleted(params);
    dDo();
    AppMethodBeat.o(287299);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(287302);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    dDo();
    AppMethodBeat.o(287302);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(287308);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView = new a(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(287308);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends o
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(287265);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 600.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(287265);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager
 * JD-Core Version:    0.7.0.1
 */