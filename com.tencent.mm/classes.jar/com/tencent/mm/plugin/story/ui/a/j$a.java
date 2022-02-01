package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;Landroid/view/View;)V", "avatarItem", "Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "getAvatarItem", "()Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "plugin-story_release"})
public final class j$a
  extends RecyclerView.w
{
  final StoryAvatarItemView zEz;
  
  public j$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119774);
    paramView = localObject.findViewById(2131305445);
    k.g(paramView, "itemView.findViewById(R.…ory_header_tip_item_view)");
    this.zEz = ((StoryAvatarItemView)paramView);
    AppMethodBeat.o(119774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.j.a
 * JD-Core Version:    0.7.0.1
 */