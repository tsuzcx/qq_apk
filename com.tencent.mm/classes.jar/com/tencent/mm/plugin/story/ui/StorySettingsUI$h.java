package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StorySettingsUI$h
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119671);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = StoryCore.SjP;
    StoryCore.b.hvV().gGK();
    paramView = StoryCore.SjP;
    StoryCore.b.hvT().gGK();
    paramView = StoryCore.SjP;
    StoryCore.b.hvR().gGK();
    paramView = StoryCore.SjP;
    y.ew(StoryCore.b.getAccStoryCachePath(), true);
    a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.h
 * JD-Core Version:    0.7.0.1
 */