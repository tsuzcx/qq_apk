package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long oJZ = 1092L;
  private static final long vpq = 1L;
  private static final long vpr = 2L;
  private static final long vps = 4L;
  private static final long vpt = 5L;
  private static final long vpu = 7L;
  private static final long vpv = 9L;
  private static final long vpw = 10L;
  private static final long vpx = 11L;
  private static final long vpy = 12L;
  public static final d ymU;
  
  static
  {
    AppMethodBeat.i(119424);
    ymU = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    oJZ = 1092L;
    vpq = 1L;
    vpr = 2L;
    vps = 4L;
    vpt = 5L;
    vpu = 7L;
    vpv = 9L;
    vpw = 10L;
    vpx = 11L;
    vpy = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void dIU()
  {
    AppMethodBeat.i(119419);
    ad.d(TAG, "markZipFail");
    h.vKh.m(oJZ, vps, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void dIV()
  {
    AppMethodBeat.i(119420);
    ad.d(TAG, "markZipTimes");
    h.vKh.m(oJZ, vpt, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void dIW()
  {
    AppMethodBeat.i(119421);
    ad.d(TAG, "markZipSucc");
    h.vKh.m(oJZ, vpw, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void dIX()
  {
    AppMethodBeat.i(119422);
    ad.d(TAG, "markZipAllCheckTimes");
    h.vKh.m(oJZ, vpu, 1L);
    AppMethodBeat.o(119422);
  }
  
  public static void tN(long paramLong)
  {
    AppMethodBeat.i(119423);
    ad.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    h.vKh.m(oJZ, 13L, 1L);
    h.vKh.m(oJZ, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */