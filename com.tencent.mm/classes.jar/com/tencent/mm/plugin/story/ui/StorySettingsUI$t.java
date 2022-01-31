package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$t
  implements View.OnClickListener
{
  StorySettingsUI$t(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(156676);
    paramView = i.suJ;
    i.cAq();
    h.J((Context)this.sHQ.getContext(), "ok！", "");
    AppMethodBeat.o(156676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.t
 * JD-Core Version:    0.7.0.1
 */