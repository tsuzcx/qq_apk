package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  private static final long BXJ = 1L;
  private static final long BXK = 2L;
  private static final long BXL = 4L;
  private static final long BXM = 5L;
  private static final long BXN = 7L;
  private static final long BXO = 9L;
  private static final long BXP = 10L;
  private static final long BXQ = 11L;
  private static final long BXR = 12L;
  public static final d Fug;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long oIi = 1092L;
  
  static
  {
    AppMethodBeat.i(119424);
    Fug = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    oIi = 1092L;
    BXJ = 1L;
    BXK = 2L;
    BXL = 4L;
    BXM = 5L;
    BXN = 7L;
    BXO = 9L;
    BXP = 10L;
    BXQ = 11L;
    BXR = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void Kr(long paramLong)
  {
    AppMethodBeat.i(119423);
    Log.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    h.CyF.n(oIi, 13L, 1L);
    h.CyF.n(oIi, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
  
  public static void fpT()
  {
    AppMethodBeat.i(119419);
    Log.d(TAG, "markZipFail");
    h.CyF.n(oIi, BXL, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void fpU()
  {
    AppMethodBeat.i(119420);
    Log.d(TAG, "markZipTimes");
    h.CyF.n(oIi, BXM, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void fpV()
  {
    AppMethodBeat.i(119421);
    Log.d(TAG, "markZipSucc");
    h.CyF.n(oIi, BXP, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void fpW()
  {
    AppMethodBeat.i(119422);
    Log.d(TAG, "markZipAllCheckTimes");
    h.CyF.n(oIi, BXN, 1L);
    AppMethodBeat.o(119422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */