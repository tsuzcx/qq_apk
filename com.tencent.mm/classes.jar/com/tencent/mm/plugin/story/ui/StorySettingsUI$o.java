package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.ui.base.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$o
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119683);
    if (!ab.iwM) {}
    for (boolean bool = true;; bool = false)
    {
      ab.iwM = bool;
      h.Q((Context)this.zDI.getContext(), "ok value Test Fail:" + ab.iwM, "嗯");
      AppMethodBeat.o(119683);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.o
 * JD-Core Version:    0.7.0.1
 */