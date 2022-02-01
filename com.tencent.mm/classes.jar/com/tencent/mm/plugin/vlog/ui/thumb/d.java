package com.tencent.mm.plugin.vlog.ui.thumb;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class d
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(249828);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int i = a.fromDPToPix(paramRecyclerView.getContext(), 8);
    int j = RecyclerView.bh(paramView);
    if (j != 0)
    {
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        p.iCn();
      }
      p.j(paramView, "parent.adapter!!");
      if (j != paramView.getItemCount() - 1)
      {
        paramRect.left = (-i);
        paramRect.right = (-i);
      }
    }
    AppMethodBeat.o(249828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.d
 * JD-Core Version:    0.7.0.1
 */