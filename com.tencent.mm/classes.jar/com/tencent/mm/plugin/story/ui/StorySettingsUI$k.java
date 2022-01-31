package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$k
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110057);
    if (!ae.glM) {}
    for (boolean bool = true;; bool = false)
    {
      ae.glM = bool;
      h.J((Context)this.sHQ.getContext(), "ok value Test Fail:" + ae.glM, "嗯");
      AppMethodBeat.o(110057);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.k
 * JD-Core Version:    0.7.0.1
 */