package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-story_release"})
public final class h
{
  public static final h sEz;
  
  static
  {
    AppMethodBeat.i(109823);
    sEz = new h();
    AppMethodBeat.o(109823);
  }
  
  public static void cDf()
  {
    AppMethodBeat.i(109820);
    ab.i("MicroMsg.StoryRemuxIDKeyStat", "markCreateThumbFailed");
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 9L, 1L);
    AppMethodBeat.o(109820);
  }
  
  public static void cDg()
  {
    AppMethodBeat.i(109822);
    ab.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxHitBitrateExceed");
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 73L, 1L);
    AppMethodBeat.o(109822);
  }
  
  public static void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109821);
    ab.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxResult, isLocalCapture:" + paramBoolean + ", bitrate:" + paramInt1 + ", fps:" + paramInt2);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.qsU.j(986L, 56L, 1L);
      com.tencent.mm.plugin.report.service.h.qsU.j(986L, 60L, paramInt1);
      com.tencent.mm.plugin.report.service.h.qsU.j(986L, 63L, paramInt2);
      AppMethodBeat.o(109821);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 57L, 1L);
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 66L, paramInt1);
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 69L, paramInt2);
    AppMethodBeat.o(109821);
  }
  
  public static void mh(boolean paramBoolean)
  {
    AppMethodBeat.i(109819);
    ab.i("MicroMsg.StoryRemuxIDKeyStat", "markRemuxProcessType, isForeground:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.qsU.j(986L, 5L, 1L);
      AppMethodBeat.o(109819);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.j(986L, 6L, 1L);
    AppMethodBeat.o(109819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.h
 * JD-Core Version:    0.7.0.1
 */