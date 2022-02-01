package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvCommentView$f
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(286919);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int j = RecyclerView.bA(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null) {}
    for (int i = -1; j < i; i = paramView.getItemCount())
    {
      paramRect.top = MusicMvCommentView.grB();
      AppMethodBeat.o(286919);
      return;
    }
    paramRect.top = 0;
    AppMethodBeat.o(286919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.f
 * JD-Core Version:    0.7.0.1
 */