package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$g
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110052);
    paramView = com.tencent.mm.plugin.story.model.l.svv;
    paramView = com.tencent.mm.plugin.story.model.l.cAU();
    h.J((Context)this.sHQ.getContext(), paramView, "嗯");
    AppMethodBeat.o(110052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.g
 * JD-Core Version:    0.7.0.1
 */