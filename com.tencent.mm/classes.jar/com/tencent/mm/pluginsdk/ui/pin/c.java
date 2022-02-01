package com.tencent.mm.pluginsdk.ui.pin;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "()V", "<set-?>", "", "pinnedHeaderPosition", "getPinnedHeaderPosition", "()I", "Landroid/graphics/Rect;", "pinnedHeaderRect", "getPinnedHeaderRect", "()Landroid/graphics/Rect;", "space", "getSpace", "ensurePinnedHeaderViewLayout", "", "pinView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemOffsets", "outRect", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getPinnedHeaderViewPosition", "adapterFirstVisible", "adapter", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "app_release"})
public final class c
  extends RecyclerView.h
  implements a
{
  private Rect Rps;
  private int Rpt;
  private final int space;
  
  public c()
  {
    AppMethodBeat.i(236539);
    this.Rpt = -1;
    this.space = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1.0F);
    AppMethodBeat.o(236539);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(236537);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null)
    {
      paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
      AppMethodBeat.o(236537);
      throw paramRect;
    }
    int i = ((GridLayoutManager)paramRecyclerView).ku();
    paramView = paramView.getLayoutParams();
    if (paramView == null)
    {
      paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
      AppMethodBeat.o(236537);
      throw paramRect;
    }
    paramView = (GridLayoutManager.LayoutParams)paramView;
    if (paramView.kw() != i)
    {
      paramRect.top = this.space;
      paramRect.bottom = this.space;
      int j = paramView.kv();
      if (j == 0)
      {
        paramRect.left = 0;
        paramRect.right = this.space;
        AppMethodBeat.o(236537);
        return;
      }
      if (j == i - 1)
      {
        paramRect.left = this.space;
        paramRect.right = 0;
        AppMethodBeat.o(236537);
        return;
      }
      paramRect.left = this.space;
      paramRect.right = this.space;
    }
    AppMethodBeat.o(236537);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(236535);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    if (paramRecyclerView.getAdapter() == null)
    {
      AppMethodBeat.o(236535);
      return;
    }
    if (((paramRecyclerView.getAdapter() instanceof b)) && (paramRecyclerView.getChildCount() > 0))
    {
      params = paramRecyclerView.getAdapter();
      if (params == null)
      {
        paramCanvas = new t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderAdapter<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(236535);
        throw paramCanvas;
      }
      Object localObject1 = (b)params;
      int i = RecyclerView.bh(paramRecyclerView.getChildAt(0));
      if (i >= 0) {
        if (!((b)localObject1).aqL(i)) {}
      }
      Object localObject2;
      for (;;)
      {
        this.Rpt = i;
        if (i == -1) {
          break label543;
        }
        params = ((b)localObject1).b((ViewGroup)paramRecyclerView, ((b)localObject1).getItemViewType(i));
        p.j(params, "adapter.onCreateViewHold…pe(pinnedHeaderPosition))");
        ((b)localObject1).d(params, i);
        params = params.amk;
        p.j(params, "pinnedHeaderViewHolder.itemView");
        if (!params.isLayoutRequested()) {
          break label292;
        }
        localObject2 = (RecyclerView.LayoutParams)params.getLayoutParams();
        if (localObject2 != null) {
          break label227;
        }
        paramCanvas = (Throwable)new NullPointerException("PinnedHeaderItemDecoration");
        AppMethodBeat.o(236535);
        throw paramCanvas;
        i -= 1;
        break;
        i = -1;
      }
      label227:
      int j = View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getMeasuredWidth() - ((RecyclerView.LayoutParams)localObject2).leftMargin - ((RecyclerView.LayoutParams)localObject2).rightMargin, 1073741824);
      label292:
      label304:
      int k;
      int n;
      int i1;
      if (((RecyclerView.LayoutParams)localObject2).height > 0)
      {
        i = View.MeasureSpec.makeMeasureSpec(((RecyclerView.LayoutParams)localObject2).height, 1073741824);
        params.measure(j, i);
        params.layout(0, 0, params.getMeasuredWidth(), params.getMeasuredHeight());
        int m = paramRecyclerView.getChildCount();
        i = 0;
        j = 0;
        if (j >= m) {
          break label414;
        }
        k = i;
        if (((b)localObject1).aqL(RecyclerView.bh(paramRecyclerView.getChildAt(j))))
        {
          localObject2 = paramRecyclerView.getChildAt(j);
          p.j(localObject2, "sectionView");
          n = ((View)localObject2).getTop();
          i1 = params.getHeight();
          if (1 <= n) {
            break label393;
          }
          k = i;
        }
      }
      for (;;)
      {
        j += 1;
        i = k;
        break label304;
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
        break;
        label393:
        k = i;
        if (i1 > n) {
          k = n - i1;
        }
      }
      label414:
      j = paramCanvas.save();
      localObject1 = params.getLayoutParams();
      if (localObject1 == null)
      {
        paramCanvas = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(236535);
        throw paramCanvas;
      }
      paramCanvas.translate(((RecyclerView.LayoutParams)localObject1).leftMargin, i);
      paramCanvas.clipRect(0, 0, paramRecyclerView.getWidth(), params.getMeasuredHeight());
      params.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      if (this.Rps == null) {
        this.Rps = new Rect();
      }
      paramCanvas = this.Rps;
      if (paramCanvas == null) {
        p.iCn();
      }
      paramCanvas.set(0, 0, paramRecyclerView.getWidth(), i + params.getMeasuredHeight());
      AppMethodBeat.o(236535);
      return;
      label543:
      this.Rps = null;
    }
    AppMethodBeat.o(236535);
  }
  
  public final Rect hmE()
  {
    return this.Rps;
  }
  
  public final int hmF()
  {
    return this.Rpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.pin.c
 * JD-Core Version:    0.7.0.1
 */