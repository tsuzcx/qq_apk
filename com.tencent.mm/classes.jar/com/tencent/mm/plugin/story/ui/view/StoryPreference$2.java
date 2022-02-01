package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryPreference$2
  implements View.OnClickListener
{
  StoryPreference$2(StoryPreference paramStoryPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120287);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    StoryPreference.a(this.Btu, 1);
    a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPreference.2
 * JD-Core Version:    0.7.0.1
 */