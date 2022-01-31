package com.tencent.mm.plugin.story.e;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class b
{
  private static final String TAG = "MicroMsg.StoryTimeUtil";
  private static final long sst = 1000L;
  private static final long ssu = 60000L;
  private static final long ssv = 3600000L;
  private static final long ssw = 86400000L;
  public static final b.a ssx;
  
  static
  {
    AppMethodBeat.i(108992);
    ssx = new b.a((byte)0);
    TAG = "MicroMsg.StoryTimeUtil";
    sst = 1000L;
    ssu = sst * 60L;
    ssv = ssu * 60L;
    ssw = 24L * ssv;
    AppMethodBeat.o(108992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.b
 * JD-Core Version:    0.7.0.1
 */