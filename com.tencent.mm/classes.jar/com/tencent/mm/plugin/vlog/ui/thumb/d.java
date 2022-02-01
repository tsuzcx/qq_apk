package com.tencent.mm.plugin.vlog.ui.thumb;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(281605);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int j = a.fromDPToPix(paramRecyclerView.getContext(), 8);
    int k = RecyclerView.bA(paramView);
    if (k == 0) {}
    for (;;)
    {
      if (i == 0)
      {
        paramRect.left = (-j);
        paramRect.right = (-j);
      }
      AppMethodBeat.o(281605);
      return;
      paramView = paramRecyclerView.getAdapter();
      s.checkNotNull(paramView);
      if (k != paramView.getItemCount() - 1) {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.d
 * JD-Core Version:    0.7.0.1
 */