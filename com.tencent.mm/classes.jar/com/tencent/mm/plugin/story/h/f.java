package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"})
public final class f
{
  public static final f LOj;
  
  static
  {
    AppMethodBeat.i(119438);
    LOj = new f();
    AppMethodBeat.o(119438);
  }
  
  public static void fxw()
  {
    AppMethodBeat.i(119436);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    h.IzE.p(1005L, 8L, 1L);
    AppMethodBeat.o(119436);
  }
  
  public static void geB()
  {
    AppMethodBeat.i(119437);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
    h.IzE.p(1005L, 107L, 1L);
    AppMethodBeat.o(119437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.f
 * JD-Core Version:    0.7.0.1
 */