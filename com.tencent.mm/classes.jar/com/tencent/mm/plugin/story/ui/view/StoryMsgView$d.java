package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryMsgView$d
  implements View.OnClickListener
{
  StoryMsgView$d(StoryMsgView paramStoryMsgView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120259);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    StoryMsgView.a(this.FDL);
    a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgView.d
 * JD-Core Version:    0.7.0.1
 */