package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentInputView$5
  implements View.OnClickListener
{
  StoryCommentInputView$5(StoryCommentInputView paramStoryCommentInputView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151169);
    if (StoryCommentInputView.l(this.sMv) == 0)
    {
      StoryCommentInputView.a(this.sMv, 2);
      StoryCommentInputView.b(this.sMv, true);
      StoryCommentInputView.g(this.sMv).setImageDrawable(aj.g(this.hEq, 2131231476, -1));
      AppMethodBeat.o(151169);
      return;
    }
    if (StoryCommentInputView.k(this.sMv))
    {
      StoryCommentInputView.a(this.sMv, 0);
      StoryCommentInputView.b(this.sMv, false);
    }
    for (;;)
    {
      StoryCommentInputView.g(this.sMv).setImageDrawable(aj.g(this.hEq, 2131231457, -1));
      AppMethodBeat.o(151169);
      return;
      StoryCommentInputView.a(this.sMv, 0);
      StoryCommentInputView.d(this.sMv).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.5
 * JD-Core Version:    0.7.0.1
 */