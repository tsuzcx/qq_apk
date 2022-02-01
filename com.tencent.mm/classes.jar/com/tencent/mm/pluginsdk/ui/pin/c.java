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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "()V", "<set-?>", "", "pinnedHeaderPosition", "getPinnedHeaderPosition", "()I", "Landroid/graphics/Rect;", "pinnedHeaderRect", "getPinnedHeaderRect", "()Landroid/graphics/Rect;", "space", "getSpace", "ensurePinnedHeaderViewLayout", "", "pinView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemOffsets", "outRect", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getPinnedHeaderViewPosition", "adapterFirstVisible", "adapter", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.h
  implements a
{
  private Rect YlI;
  private int YlJ;
  private final int space;
  
  public c()
  {
    AppMethodBeat.i(245090);
    this.YlJ = -1;
    this.space = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1.0F);
    AppMethodBeat.o(245090);
  }
  
  private static int a(int paramInt, b<RecyclerView.v> paramb)
  {
    AppMethodBeat.i(245091);
    if (paramInt >= 0) {}
    for (;;)
    {
      int i = paramInt - 1;
      if (paramb.awR(paramInt))
      {
        AppMethodBeat.o(245091);
        return paramInt;
      }
      if (i < 0)
      {
        AppMethodBeat.o(245091);
        return -1;
      }
      paramInt = i;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(245101);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null)
    {
      paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
      AppMethodBeat.o(245101);
      throw paramRect;
    }
    int i = ((GridLayoutManager)paramRecyclerView).bWl;
    paramView = paramView.getLayoutParams();
    if (paramView == null)
    {
      paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
      AppMethodBeat.o(245101);
      throw paramRect;
    }
    paramView = (GridLayoutManager.LayoutParams)paramView;
    if (paramView.bWt != i)
    {
      paramRect.top = this.space;
      paramRect.bottom = this.space;
      int j = paramView.bWs;
      if (j == 0)
      {
        paramRect.left = 0;
        paramRect.right = this.space;
        AppMethodBeat.o(245101);
        return;
      }
      if (j == i - 1)
      {
        paramRect.left = this.space;
        paramRect.right = 0;
        AppMethodBeat.o(245101);
        return;
      }
      paramRect.left = this.space;
      paramRect.right = this.space;
    }
    AppMethodBeat.o(245101);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(245098);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    if (paramRecyclerView.getAdapter() == null)
    {
      AppMethodBeat.o(245098);
      return;
    }
    Object localObject;
    int i;
    int j;
    int k;
    label281:
    int m;
    if (((paramRecyclerView.getAdapter() instanceof b)) && (paramRecyclerView.getChildCount() > 0))
    {
      params = paramRecyclerView.getAdapter();
      if (params == null)
      {
        paramCanvas = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderAdapter<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(245098);
        throw paramCanvas;
      }
      localObject = (b)params;
      i = a(RecyclerView.bA(paramRecyclerView.getChildAt(0)), (b)localObject);
      this.YlJ = i;
      if (i != -1)
      {
        params = ((b)localObject).b((ViewGroup)paramRecyclerView, ((b)localObject).getItemViewType(i));
        s.s(params, "adapter.onCreateViewHold…pe(pinnedHeaderPosition))");
        ((b)localObject).d(params, i);
        params = params.caK;
        s.s(params, "pinnedHeaderViewHolder.itemView");
        if (params.isLayoutRequested())
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)params.getLayoutParams();
          if (localLayoutParams == null)
          {
            paramCanvas = new NullPointerException("PinnedHeaderItemDecoration");
            AppMethodBeat.o(245098);
            throw paramCanvas;
          }
          j = View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getMeasuredWidth() - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824);
          if (localLayoutParams.height > 0)
          {
            i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
            params.measure(j, i);
            params.layout(0, 0, params.getMeasuredWidth(), params.getMeasuredHeight());
          }
        }
        else
        {
          int n = paramRecyclerView.getChildCount();
          if (n <= 0) {
            break label534;
          }
          j = 0;
          k = 0;
          m = j + 1;
          i = k;
          if (((b)localObject).awR(RecyclerView.bA(paramRecyclerView.getChildAt(j))))
          {
            int i1 = paramRecyclerView.getChildAt(j).getTop();
            int i2 = params.getHeight();
            if (i1 <= 0) {
              break label414;
            }
            if (i1 >= i2) {
              break label408;
            }
            j = 1;
            label340:
            i = k;
            if (j != 0) {
              i = i1 - i2;
            }
          }
          if (m < n) {
            break label523;
          }
        }
      }
    }
    for (;;)
    {
      j = paramCanvas.save();
      localObject = params.getLayoutParams();
      if (localObject == null)
      {
        paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(245098);
        throw paramCanvas;
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
        break;
        label408:
        j = 0;
        break label340;
        label414:
        j = 0;
        break label340;
      }
      paramCanvas.translate(((RecyclerView.LayoutParams)localObject).leftMargin, i);
      paramCanvas.clipRect(0, 0, paramRecyclerView.getWidth(), params.getMeasuredHeight());
      params.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      if (this.YlI == null) {
        this.YlI = new Rect();
      }
      paramCanvas = this.YlI;
      s.checkNotNull(paramCanvas);
      paramCanvas.set(0, 0, paramRecyclerView.getWidth(), params.getMeasuredHeight() + i);
      AppMethodBeat.o(245098);
      return;
      this.YlI = null;
      AppMethodBeat.o(245098);
      return;
      label523:
      j = m;
      k = i;
      break label281;
      label534:
      i = 0;
    }
  }
  
  public final Rect iNu()
  {
    return this.YlI;
  }
  
  public final int iNv()
  {
    return this.YlJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.pin.c
 * JD-Core Version:    0.7.0.1
 */