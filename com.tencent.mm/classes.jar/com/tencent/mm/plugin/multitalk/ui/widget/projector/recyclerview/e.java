package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentWidth", "", "getContext", "()Landroid/content/Context;", "setContext", "itemPadding", "itemWidth", "applyWidthSize", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.h
{
  public int contentWidth;
  private Context context;
  private int itemPadding;
  public int wLI;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(285886);
    this.context = paramContext;
    this.itemPadding = (f.Grd / 2);
    AppMethodBeat.o(285886);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(285897);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int j = RecyclerView.bA(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView == null) {}
    for (int i = 0; j == 0; i = paramView.getItemCount())
    {
      paramRect.set((paramRecyclerView.getWidth() - this.wLI) / 2, 0, this.itemPadding, 0);
      AppMethodBeat.o(285897);
      return;
    }
    if (j == i - 1)
    {
      i = (paramRecyclerView.getWidth() - this.wLI) / 2;
      paramRect.set(this.itemPadding, 0, i, 0);
      AppMethodBeat.o(285897);
      return;
    }
    paramRect.set(this.itemPadding, 0, this.itemPadding, 0);
    AppMethodBeat.o(285897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */