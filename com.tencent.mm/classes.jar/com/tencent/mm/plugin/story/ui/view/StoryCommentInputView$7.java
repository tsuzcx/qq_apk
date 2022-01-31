package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentInputView$7
  implements View.OnClickListener
{
  StoryCommentInputView$7(StoryCommentInputView paramStoryCommentInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151171);
    StoryCommentInputView.b(this.sMv, false);
    paramView = this.sMv.getCommentInputCallback();
    if (paramView != null)
    {
      paramView.h("", Boolean.FALSE);
      AppMethodBeat.o(151171);
      return;
    }
    AppMethodBeat.o(151171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.7
 * JD-Core Version:    0.7.0.1
 */