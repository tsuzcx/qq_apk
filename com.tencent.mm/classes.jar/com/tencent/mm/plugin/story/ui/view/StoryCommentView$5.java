package com.tencent.mm.plugin.story.ui.view;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class StoryCommentView$5
  implements View.OnLongClickListener
{
  StoryCommentView$5(StoryCommentView paramStoryCommentView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(151183);
    if (StoryCommentView.a(this.sMZ) == 3)
    {
      AppMethodBeat.o(151183);
      return false;
    }
    paramView = this.sMZ.getOutsideClickListener();
    if (paramView != null)
    {
      paramView = (Boolean)paramView.invoke();
      if (paramView != null)
      {
        boolean bool = paramView.booleanValue();
        AppMethodBeat.o(151183);
        return bool;
      }
    }
    AppMethodBeat.o(151183);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.5
 * JD-Core Version:    0.7.0.1
 */