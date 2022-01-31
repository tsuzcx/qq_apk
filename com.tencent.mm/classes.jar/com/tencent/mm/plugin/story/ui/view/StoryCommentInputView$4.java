package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentInputView$4
  implements View.OnClickListener
{
  StoryCommentInputView$4(StoryCommentInputView paramStoryCommentInputView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110391);
    if (!StoryCommentInputView.k(this.sMv))
    {
      StoryCommentInputView.a(this.sMv, 2);
      StoryCommentInputView.b(this.sMv, true);
      StoryCommentInputView.g(this.sMv).setImageDrawable(aj.g(this.hEq, 2131231476, -1));
    }
    AppMethodBeat.o(110391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.4
 * JD-Core Version:    0.7.0.1
 */