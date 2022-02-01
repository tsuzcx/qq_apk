package com.tencent.mm.view.layoutmanager;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "enableHorizontalScroll", "enableVerticalScroll", "canScrollHorizontally", "canScrollVertically", "", "enable", "onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateSelectedChild", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Flip3DLayoutManager
  extends LinearLayoutManager
{
  public static final Flip3DLayoutManager.a agMx;
  private boolean agMy;
  public boolean agMz;
  
  static
  {
    AppMethodBeat.i(234734);
    agMx = new Flip3DLayoutManager.a((byte)0);
    AppMethodBeat.o(234734);
  }
  
  public Flip3DLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(234728);
    this.agMy = true;
    this.agMz = true;
    AppMethodBeat.o(234728);
  }
  
  private final void jNd()
  {
    AppMethodBeat.i(234731);
    int k = getChildCount();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = getChildAt(i);
      float f2;
      if (localView != null)
      {
        i = (localView.getLeft() + localView.getRight()) / 2;
        float f1 = getWidth() / 2.0F;
        f2 = (i - f1) / getWidth() * 45.0F;
        localView.setPivotX(f1);
        localView.setPivotY(getHeight() / 2.0F);
        if (f2 >= 0.0F) {
          break label124;
        }
        localView.setPivotX(getWidth());
      }
      for (;;)
      {
        localView.setRotationY(f2);
        if (j < k) {
          break;
        }
        AppMethodBeat.o(234731);
        return;
        label124:
        localView.setPivotX(0.0F);
      }
      i = j;
    }
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(234758);
    if ((super.canScrollHorizontally()) && (this.agMz))
    {
      AppMethodBeat.o(234758);
      return true;
    }
    AppMethodBeat.o(234758);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(234761);
    if ((super.canScrollVertically()) && (this.agMy))
    {
      AppMethodBeat.o(234761);
      return true;
    }
    AppMethodBeat.o(234761);
    return false;
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(234738);
    super.onLayoutCompleted(params);
    jNd();
    Log.i("MicroMsg.Flip3DLayoutManager", s.X("onLayoutCompleted childCount:", Integer.valueOf(getChildCount())));
    AppMethodBeat.o(234738);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(234743);
    s.u(paramn, "recycler");
    s.u(params, "state");
    int i = super.scrollHorizontallyBy(paramInt, paramn, params);
    jNd();
    Log.i("MicroMsg.Flip3DLayoutManager", "scrollHorizontallyBy childCount:" + getChildCount() + ", dx:" + paramInt);
    AppMethodBeat.o(234743);
    return i;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(234748);
    super.scrollToPosition(paramInt);
    Log.i("MicroMsg.Flip3DLayoutManager", "scrollToPosition childCount:" + getChildCount() + ", position:" + paramInt);
    AppMethodBeat.o(234748);
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(234754);
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    Log.i("MicroMsg.Flip3DLayoutManager", "smoothScrollToPosition childCount:" + getChildCount() + ", position:" + paramInt);
    AppMethodBeat.o(234754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.layoutmanager.Flip3DLayoutManager
 * JD-Core Version:    0.7.0.1
 */