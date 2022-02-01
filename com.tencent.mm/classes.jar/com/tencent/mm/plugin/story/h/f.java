package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
public final class f
{
  public static final f ARU;
  
  static
  {
    AppMethodBeat.i(119438);
    ARU = new f();
    AppMethodBeat.o(119438);
  }
  
  public static void dGQ()
  {
    AppMethodBeat.i(119436);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    g.yhR.n(1005L, 8L, 1L);
    AppMethodBeat.o(119436);
  }
  
  public static void ejW()
  {
    AppMethodBeat.i(119437);
    ad.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
    g.yhR.n(1005L, 107L, 1L);
    AppMethodBeat.o(119437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.f
 * JD-Core Version:    0.7.0.1
 */