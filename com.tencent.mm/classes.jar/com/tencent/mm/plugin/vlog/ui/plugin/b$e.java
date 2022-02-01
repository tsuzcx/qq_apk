package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class b$e
  extends RecyclerView.h
{
  private final float offset;
  
  b$e()
  {
    AppMethodBeat.i(191605);
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.offset = localContext.getResources().getDimension(2131165289);
    AppMethodBeat.o(191605);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(191604);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    super.a(paramRect, paramView, paramRecyclerView, paramt);
    paramView = paramRecyclerView.bh(paramView);
    p.g(paramView, "parent.getChildViewHolder(view)");
    int i = paramView.lN();
    paramRect.left = ((int)this.offset);
    if (i + 1 == this.Cem.Cej.size()) {
      paramRect.right = ((int)this.offset);
    }
    AppMethodBeat.o(191604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b.e
 * JD-Core Version:    0.7.0.1
 */