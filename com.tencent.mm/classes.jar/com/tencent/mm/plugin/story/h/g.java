package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-story_release"})
public final class g
{
  public static final g ARV;
  
  static
  {
    AppMethodBeat.i(119440);
    ARV = new g();
    AppMethodBeat.o(119440);
  }
  
  public static void ejX()
  {
    AppMethodBeat.i(119439);
    ad.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxHitBitrateExceed");
    com.tencent.mm.plugin.report.service.g.yhR.n(986L, 73L, 1L);
    AppMethodBeat.o(119439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.g
 * JD-Core Version:    0.7.0.1
 */