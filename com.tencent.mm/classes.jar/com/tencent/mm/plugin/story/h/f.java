package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
public final class f
{
  public static final f zAv;
  
  static
  {
    AppMethodBeat.i(119438);
    zAv = new f();
    AppMethodBeat.o(119438);
  }
  
  public static void dXH()
  {
    AppMethodBeat.i(119437);
    ac.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
    h.wUl.n(1005L, 107L, 1L);
    AppMethodBeat.o(119437);
  }
  
  public static void dww()
  {
    AppMethodBeat.i(119436);
    ac.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    h.wUl.n(1005L, 8L, 1L);
    AppMethodBeat.o(119436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.f
 * JD-Core Version:    0.7.0.1
 */