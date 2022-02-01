package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;Landroid/view/View;)V", "view", "getView", "()Landroid/view/View;", "plugin-story_release"})
public final class a$a
  extends RecyclerView.w
{
  final View view;
  
  public a$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119714);
    paramView = localObject.findViewById(2131305334);
    k.g(paramView, "itemView.findViewById(R.…y_control_page_indicator)");
    this.view = paramView;
    AppMethodBeat.o(119714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */