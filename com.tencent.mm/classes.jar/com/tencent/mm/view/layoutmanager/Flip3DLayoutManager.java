package com.tencent.mm.view.layoutmanager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "enableHorizontalScroll", "enableVerticalScroll", "canScrollHorizontally", "canScrollVertically", "", "enable", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "updateSelectedChild", "libmmui_release"})
public final class Flip3DLayoutManager
  extends LinearLayoutManager
{
  private boolean Rpx;
  public boolean Rpy;
  
  public Flip3DLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(205029);
    this.Rpx = true;
    this.Rpy = true;
    AppMethodBeat.o(205029);
  }
  
  private final void hgp()
  {
    AppMethodBeat.i(205028);
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
        p.g(localView, "getChildAt(i) ?: continue");
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
    AppMethodBeat.o(205028);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(205026);
    if ((super.canScrollHorizontally()) && (this.Rpy))
    {
      AppMethodBeat.o(205026);
      return true;
    }
    AppMethodBeat.o(205026);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(205027);
    if ((super.canScrollVertically()) && (this.Rpx))
    {
      AppMethodBeat.o(205027);
      return true;
    }
    AppMethodBeat.o(205027);
    return false;
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(205024);
    super.onLayoutCompleted(params);
    hgp();
    AppMethodBeat.o(205024);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(205025);
    p.h(paramn, "recycler");
    p.h(params, "state");
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    hgp();
    AppMethodBeat.o(205025);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.layoutmanager.Flip3DLayoutManager
 * JD-Core Version:    0.7.0.1
 */