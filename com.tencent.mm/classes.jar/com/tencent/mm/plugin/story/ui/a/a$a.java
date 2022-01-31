package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;Landroid/view/View;)V", "view", "getView", "()Landroid/view/View;", "plugin-story_release"})
public final class a$a
  extends RecyclerView.v
{
  final View view;
  
  public a$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110087);
    paramView = localObject.findViewById(2131828439);
    j.p(paramView, "itemView.findViewById(R.…y_control_page_indicator)");
    this.view = paramView;
    AppMethodBeat.o(110087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */