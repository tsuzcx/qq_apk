package com.tencent.mm.plugin.story.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final long MILLSECONDS_OF_DAY;
  private static final long MILLSECONDS_OF_HOUR;
  private static final long MILLSECONDS_OF_MINUTE;
  private static final long MILLSECONDS_OF_SECOND;
  public static final a.a Sjk;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118623);
    Sjk = new a.a((byte)0);
    TAG = "MicroMsg.StoryTimeUtil";
    MILLSECONDS_OF_SECOND = 1000L;
    MILLSECONDS_OF_MINUTE = MILLSECONDS_OF_SECOND * 60L;
    MILLSECONDS_OF_HOUR = MILLSECONDS_OF_MINUTE * 60L;
    MILLSECONDS_OF_DAY = 24L * MILLSECONDS_OF_HOUR;
    AppMethodBeat.o(118623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.a
 * JD-Core Version:    0.7.0.1
 */