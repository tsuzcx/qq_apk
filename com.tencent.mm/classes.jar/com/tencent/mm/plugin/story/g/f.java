package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryRemuxDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markFail", "", "isCaptureVideo", "", "markMixErrorData", "markMixVideoNotExist", "markRemuxStart", "markRemuxStartUniq", "markSuccess", "markSuccessCost", "time", "markSuccessRetryTimes", "times", "", "postDone", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f SqX;
  
  static
  {
    AppMethodBeat.i(119438);
    SqX = new f();
    AppMethodBeat.o(119438);
  }
  
  public static void gJl()
  {
    AppMethodBeat.i(119436);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "markMixErrorData");
    h.OAn.p(1005L, 8L, 1L);
    AppMethodBeat.o(119436);
  }
  
  public static void hxT()
  {
    AppMethodBeat.i(119437);
    Log.i("MicroMsg.StoryRemuxDetailIDKeyStat", "post done");
    h.OAn.p(1005L, 107L, 1L);
    AppMethodBeat.o(119437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f
 * JD-Core Version:    0.7.0.1
 */