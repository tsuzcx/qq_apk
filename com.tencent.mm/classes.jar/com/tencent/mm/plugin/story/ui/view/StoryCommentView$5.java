package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class StoryCommentView$5
  implements View.OnLongClickListener
{
  StoryCommentView$5(StoryCommentView paramStoryCommentView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(120136);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    boolean bool;
    if (StoryCommentView.a(this.FCE) == 3) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(120136);
      return bool;
      paramView = this.FCE.getOutsideClickListener();
      if (paramView != null)
      {
        paramView = (Boolean)paramView.invoke();
        if (paramView != null)
        {
          bool = paramView.booleanValue();
          continue;
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.5
 * JD-Core Version:    0.7.0.1
 */