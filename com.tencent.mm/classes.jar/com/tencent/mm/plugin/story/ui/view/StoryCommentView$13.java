package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$13
  implements View.OnClickListener
{
  StoryCommentView$13(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120146);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i(StoryCommentView.access$getTAG$cp(), "CommentBubble click");
    StoryCommentView.a(this.FCE, true);
    a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.13
 * JD-Core Version:    0.7.0.1
 */