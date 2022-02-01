package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$z
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(178049);
    paramView = g.agR();
    k.g(paramView, "MMKernel.storage()");
    paramView.agA().set(ah.a.GTd, Long.valueOf(0L));
    AppMethodBeat.o(178049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.z
 * JD-Core Version:    0.7.0.1
 */