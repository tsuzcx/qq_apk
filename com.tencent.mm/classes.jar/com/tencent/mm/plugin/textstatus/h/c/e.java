package com.tencent.mm.plugin.textstatus.h.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/FooterPagerSnapHelper;", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "isEnableFooter", "", "(Z)V", "findSnapViewInner", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "interceptFindClosedChild", "child", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private final boolean Tnt = true;
  
  public final boolean a(View paramView, RecyclerView.LayoutManager paramLayoutManager, androidx.recyclerview.widget.s params)
  {
    RecyclerView.v localv = null;
    int j = 0;
    AppMethodBeat.i(290660);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(params, "helper");
    if (!this.Tnt)
    {
      AppMethodBeat.o(290660);
      return false;
    }
    if (paramView == null) {}
    for (;;)
    {
      int i = j;
      if (localv != null)
      {
        i = j;
        if (localv.KJ() == paramLayoutManager.getItemCount() - 1) {
          i = 1;
        }
      }
      if (i == 0) {
        break;
      }
      i = params.bw(paramView);
      j = params.bs(paramView);
      if (params.JE() + params.JG() - j <= i / 2) {
        break;
      }
      AppMethodBeat.o(290660);
      return true;
      RecyclerView localRecyclerView = this.mkw;
      if (localRecyclerView != null) {
        localv = localRecyclerView.bj(paramView);
      }
    }
    boolean bool = super.a(paramView, paramLayoutManager, params);
    AppMethodBeat.o(290660);
    return bool;
  }
  
  public final View h(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(290650);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(290650);
      return null;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(290650);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(290650);
      return paramLayoutManager;
    }
    AppMethodBeat.o(290650);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c.e
 * JD-Core Version:    0.7.0.1
 */