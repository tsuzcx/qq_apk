package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryHeaderStageGroup$1
  implements View.OnClickListener
{
  StoryHeaderStageGroup$1(StoryHeaderStageGroup paramStoryHeaderStageGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120170);
    paramView = this.yvL.getOnDeleteClick();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(120170);
      return;
    }
    AppMethodBeat.o(120170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup.1
 * JD-Core Version:    0.7.0.1
 */