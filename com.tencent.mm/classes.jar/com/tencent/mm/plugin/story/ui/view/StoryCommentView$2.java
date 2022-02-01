package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$2
  implements View.OnClickListener
{
  StoryCommentView$2(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120133);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i(StoryCommentView.access$getTAG$cp(), "commentEditGroup click");
    this.FCE.xN(1);
    paramView = h.FuH;
    h.aaT(8);
    a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.2
 * JD-Core Version:    0.7.0.1
 */