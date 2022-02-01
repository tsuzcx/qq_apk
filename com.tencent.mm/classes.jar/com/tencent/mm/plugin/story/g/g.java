package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryRemuxIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCreateThumbFailed", "", "markRemuxProcessType", "isForeground", "", "markStoryRemuxHitBitrateExceed", "markStoryRemuxResult", "isLocalCapture", "bitrate", "", "fps", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g SqY;
  
  static
  {
    AppMethodBeat.i(119440);
    SqY = new g();
    AppMethodBeat.o(119440);
  }
  
  public static void hxU()
  {
    AppMethodBeat.i(119439);
    Log.i("MicroMsg.StoryRemuxIDKeyStat", "markStoryRemuxHitBitrateExceed");
    h.OAn.p(986L, 73L, 1L);
    AppMethodBeat.o(119439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.g
 * JD-Core Version:    0.7.0.1
 */