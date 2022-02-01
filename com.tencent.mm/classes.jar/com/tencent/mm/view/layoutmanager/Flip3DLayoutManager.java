package com.tencent.mm.view.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "enableHorizontalScroll", "enableVerticalScroll", "canScrollHorizontally", "canScrollVertically", "", "enable", "onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateSelectedChild", "Companion", "libmmui_release"})
public final class Flip3DLayoutManager
  extends LinearLayoutManager
{
  public static final a YQT;
  private boolean YQR;
  public boolean YQS;
  
  static
  {
    AppMethodBeat.i(219128);
    YQT = new a((byte)0);
    AppMethodBeat.o(219128);
  }
  
  public Flip3DLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(219127);
    this.YQR = true;
    this.YQS = true;
    AppMethodBeat.o(219127);
  }
  
  private final void ihQ()
  {
    AppMethodBeat.i(219125);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null)
      {
        i += 1;
      }
      else
      {
        p.j(localView, "getChildAt(i) ?: continue");
        int k = (localView.getLeft() + localView.getRight()) / 2;
        float f1 = getWidth() / 2.0F;
        float f2 = (k - f1) / getWidth() * 45.0F;
        localView.setPivotX(f1);
        localView.setPivotY(getHeight() / 2.0F);
        if (f2 < 0.0F) {
          localView.setPivotX(getWidth());
        }
        for (;;)
        {
          localView.setRotationY(f2);
          break;
          localView.setPivotX(0.0F);
        }
      }
    }
    AppMethodBeat.o(219125);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(219113);
    if ((super.canScrollHorizontally()) && (this.YQS))
    {
      AppMethodBeat.o(219113);
      return true;
    }
    AppMethodBeat.o(219113);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(219114);
    if ((super.canScrollVertically()) && (this.YQR))
    {
      AppMethodBeat.o(219114);
      return true;
    }
    AppMethodBeat.o(219114);
    return false;
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(219104);
    super.onLayoutCompleted(params);
    ihQ();
    Log.i("MicroMsg.Flip3DLayoutManager", "onLayoutCompleted childCount:" + getChildCount());
    AppMethodBeat.o(219104);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(219106);
    p.k(paramn, "recycler");
    p.k(params, "state");
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    ihQ();
    Log.i("MicroMsg.Flip3DLayoutManager", "scrollHorizontallyBy childCount:" + getChildCount() + ", dx:" + paramInt);
    AppMethodBeat.o(219106);
    return i;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(219108);
    super.scrollToPosition(paramInt);
    Log.i("MicroMsg.Flip3DLayoutManager", "scrollToPosition childCount:" + getChildCount() + ", position:" + paramInt);
    AppMethodBeat.o(219108);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(219111);
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    Log.i("MicroMsg.Flip3DLayoutManager", "smoothScrollToPosition childCount:" + getChildCount() + ", position:" + paramInt);
    AppMethodBeat.o(219111);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.layoutmanager.Flip3DLayoutManager
 * JD-Core Version:    0.7.0.1
 */