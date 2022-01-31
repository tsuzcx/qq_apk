package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$r
  implements View.OnClickListener
{
  StorySettingsUI$r(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155327);
    com.tencent.mm.plugin.sns.ui.aq.rTs = 2;
    h.J((Context)this.sHQ.getContext(), "已调整到单图下载，即刻生效！", "");
    AppMethodBeat.o(155327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.r
 * JD-Core Version:    0.7.0.1
 */