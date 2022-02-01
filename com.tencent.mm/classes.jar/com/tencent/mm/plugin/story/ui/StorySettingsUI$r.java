package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$r
  implements View.OnClickListener
{
  StorySettingsUI$r(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119686);
    paramView = g.agR();
    k.g(paramView, "MMKernel.storage()");
    paramView.agA().set(ah.a.GSK, Boolean.FALSE);
    h.Q((Context)this.zDI.getContext(), "在群视频，不要上滑，静候5秒", "");
    AppMethodBeat.o(119686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.r
 * JD-Core Version:    0.7.0.1
 */