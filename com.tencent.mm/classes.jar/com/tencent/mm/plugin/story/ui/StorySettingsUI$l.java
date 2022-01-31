package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$l
  implements View.OnClickListener
{
  StorySettingsUI$l(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110059);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLv, Boolean.FALSE);
    h.J((Context)this.sHQ.getContext(), "在群视频，不要上滑，静候5秒", "");
    AppMethodBeat.o(110059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.l
 * JD-Core Version:    0.7.0.1
 */