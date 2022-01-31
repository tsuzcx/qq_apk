package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.story.model.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
public final class f$c
  extends f.a
{
  public f$c(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(138854);
    AppMethodBeat.o(138854);
  }
  
  public final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(138853);
    j.q(parama, "comment");
    super.a(paramInt, parama);
    if (parama.sxz) {
      b.e(this.sHE);
    }
    AppMethodBeat.o(138853);
  }
  
  public final View cFo()
  {
    AppMethodBeat.i(138852);
    View localView = this.aku.findViewById(2131828323);
    j.p(localView, "itemView.findViewById(R.…omment_bubble_background)");
    AppMethodBeat.o(138852);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.c
 * JD-Core Version:    0.7.0.1
 */