package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$2
  implements View.OnClickListener
{
  StoryCommentView$2(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151180);
    ab.i(StoryCommentView.access$getTAG$cp(), "commentEditGroup click");
    this.sMZ.oq(1);
    paramView = i.sFa;
    i.FU(8);
    AppMethodBeat.o(151180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.2
 * JD-Core Version:    0.7.0.1
 */