package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$f
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110051);
    paramView = new Intent((Context)this.sHQ, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
    this.sHQ.startActivity(paramView);
    AppMethodBeat.o(110051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.f
 * JD-Core Version:    0.7.0.1
 */