package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  public static final d ARS;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long pQX = 1092L;
  private static final long xHb = 1L;
  private static final long xHc = 2L;
  private static final long xHd = 4L;
  private static final long xHe = 5L;
  private static final long xHf = 7L;
  private static final long xHg = 9L;
  private static final long xHh = 10L;
  private static final long xHi = 11L;
  private static final long xHj = 12L;
  
  static
  {
    AppMethodBeat.i(119424);
    ARS = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    pQX = 1092L;
    xHb = 1L;
    xHc = 2L;
    xHd = 4L;
    xHe = 5L;
    xHf = 7L;
    xHg = 9L;
    xHh = 10L;
    xHi = 11L;
    xHj = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void AO(long paramLong)
  {
    AppMethodBeat.i(119423);
    ad.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    g.yhR.n(pQX, 13L, 1L);
    g.yhR.n(pQX, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
  
  public static void ejK()
  {
    AppMethodBeat.i(119419);
    ad.d(TAG, "markZipFail");
    g.yhR.n(pQX, xHd, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void ejL()
  {
    AppMethodBeat.i(119420);
    ad.d(TAG, "markZipTimes");
    g.yhR.n(pQX, xHe, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void ejM()
  {
    AppMethodBeat.i(119421);
    ad.d(TAG, "markZipSucc");
    g.yhR.n(pQX, xHh, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void ejN()
  {
    AppMethodBeat.i(119422);
    ad.d(TAG, "markZipAllCheckTimes");
    g.yhR.n(pQX, xHf, 1L);
    AppMethodBeat.o(119422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */