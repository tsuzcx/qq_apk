package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$13
  implements View.OnClickListener
{
  StoryCommentView$13(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138914);
    ab.i(StoryCommentView.access$getTAG$cp(), "CommentBubble click");
    StoryCommentView.a(this.sMZ, true);
    AppMethodBeat.o(138914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.13
 * JD-Core Version:    0.7.0.1
 */