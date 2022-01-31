package com.tencent.mm.plugin.story.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$y
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110071);
    paramView = j.svi;
    j.b.cAF().csu();
    paramView = j.svi;
    j.b.cAD().csu();
    paramView = j.svi;
    j.b.cAB().csu();
    paramView = j.svi;
    e.cO(j.b.getAccStoryCachePath());
    AppMethodBeat.o(110071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.y
 * JD-Core Version:    0.7.0.1
 */