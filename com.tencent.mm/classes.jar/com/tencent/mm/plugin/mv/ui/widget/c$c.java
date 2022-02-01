package com.tencent.mm.plugin.mv.ui.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$FillingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "width", "", "plugin-mv_release"})
public final class c$c
  extends RecyclerView.v
{
  final ViewGroup parent;
  
  public c$c(ViewGroup paramViewGroup)
  {
    super(new View(paramViewGroup.getContext()));
    AppMethodBeat.i(227718);
    this.parent = paramViewGroup;
    paramViewGroup = this.amk;
    p.j(paramViewGroup, "itemView");
    Object localObject = this.amk;
    p.j(localObject, "itemView");
    localObject = a.m(((View)localObject).getContext(), b.d.FWx);
    if (localObject == null) {
      p.iCn();
    }
    paramViewGroup.setBackground((Drawable)localObject);
    AppMethodBeat.o(227718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.c.c
 * JD-Core Version:    0.7.0.1
 */