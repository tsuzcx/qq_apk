package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$s
  implements View.OnClickListener
{
  StorySettingsUI$s(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(155328);
    switch (aq.rTs)
    {
    default: 
      boolean bool = CdnLogic.getSnsImagePrivateProtocolAvalible();
      if (1 == g.Nq().getInt("SnsGroupImageDownloadSwitch", 0)) {
        i = 1;
      }
      if (((bool) && (i != 0)) || (((!f.IS_FLAVOR_RED) && (!f.DEBUG)) || ((-1 == aq.rTs) || (1 == aq.rTt))))
      {
        h.J((Context)this.sHQ.getContext(), "套图下载", "");
        AppMethodBeat.o(155328);
        return;
      }
      break;
    case 1: 
      h.J((Context)this.sHQ.getContext(), "套图下载", "");
      AppMethodBeat.o(155328);
      return;
    case 2: 
      h.J((Context)this.sHQ.getContext(), "单图下载", "");
      AppMethodBeat.o(155328);
      return;
    }
    h.J((Context)this.sHQ.getContext(), "单图下载", "");
    AppMethodBeat.o(155328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.s
 * JD-Core Version:    0.7.0.1
 */