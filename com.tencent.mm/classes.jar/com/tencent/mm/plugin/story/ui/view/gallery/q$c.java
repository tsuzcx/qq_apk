package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
public final class q$c
  implements h.c
{
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(110976);
    StoryVideoView localStoryVideoView = this.sVz.sVs;
    if (localStoryVideoView != null)
    {
      if (!localStoryVideoView.sVa)
      {
        h.qsU.idkeyStat(this.sVz.sVu, paramLong, 1L, false);
        if ((paramLong >= 141L) && (paramLong <= 145L)) {
          ab.i(this.sVz.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.sVz.sUp + ' ' + bo.dtY());
        }
      }
      AppMethodBeat.o(110976);
      return;
    }
    AppMethodBeat.o(110976);
  }
  
  public final void xE(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.q.c
 * JD-Core Version:    0.7.0.1
 */