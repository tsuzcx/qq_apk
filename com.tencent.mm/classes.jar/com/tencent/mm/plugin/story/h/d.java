package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  private static final long HUA = 5L;
  private static final long HUB = 7L;
  private static final long HUC = 9L;
  private static final long HUD = 10L;
  private static final long HUE = 11L;
  private static final long HUF = 12L;
  private static final long HUx = 1L;
  private static final long HUy = 2L;
  private static final long HUz = 4L;
  public static final d LOh;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long rJY = 1092L;
  
  static
  {
    AppMethodBeat.i(119424);
    LOh = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    rJY = 1092L;
    HUx = 1L;
    HUy = 2L;
    HUz = 4L;
    HUA = 5L;
    HUB = 7L;
    HUC = 9L;
    HUD = 10L;
    HUE = 11L;
    HUF = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void RL(long paramLong)
  {
    AppMethodBeat.i(119423);
    Log.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    h.IzE.p(rJY, 13L, 1L);
    h.IzE.p(rJY, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
  
  public static void geo()
  {
    AppMethodBeat.i(119419);
    Log.d(TAG, "markZipFail");
    h.IzE.p(rJY, HUz, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void gep()
  {
    AppMethodBeat.i(119420);
    Log.d(TAG, "markZipTimes");
    h.IzE.p(rJY, HUA, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void geq()
  {
    AppMethodBeat.i(119421);
    Log.d(TAG, "markZipSucc");
    h.IzE.p(rJY, HUD, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void ger()
  {
    AppMethodBeat.i(119422);
    Log.d(TAG, "markZipAllCheckTimes");
    h.IzE.p(rJY, HUB, 1L);
    AppMethodBeat.o(119422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */