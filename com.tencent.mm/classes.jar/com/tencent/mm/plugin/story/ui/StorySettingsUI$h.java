package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.m;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$h
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119671);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = j.BbE;
    j.b.elF().dId();
    paramView = j.BbE;
    j.b.elD().dId();
    paramView = j.BbE;
    j.b.elB().dId();
    paramView = j.BbE;
    com.tencent.mm.vfs.o.deleteDir(j.b.getAccStoryCachePath());
    a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.h
 * JD-Core Version:    0.7.0.1
 */