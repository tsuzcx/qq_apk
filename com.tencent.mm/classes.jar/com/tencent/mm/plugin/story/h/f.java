package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
public final class f
{
  public static final f Bjs;
  
  static
  {
    AppMethodBeat.i(119438);
    Bjs = new f();
    AppMethodBeat.o(119438);
  }
  
  public static void dKh()
  {
    AppMethodBeat.i(119436);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    g.yxI.n(1005L, 8L, 1L);
    AppMethodBeat.o(119436);
  }
  
  public static void enF()
  {
    AppMethodBeat.i(119437);
    ae.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
    g.yxI.n(1005L, 107L, 1L);
    AppMethodBeat.o(119437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.f
 * JD-Core Version:    0.7.0.1
 */