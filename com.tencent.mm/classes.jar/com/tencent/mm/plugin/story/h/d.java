package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  public static final d Bjq;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long pXC = 1092L;
  private static final long xWW = 1L;
  private static final long xWX = 2L;
  private static final long xWY = 4L;
  private static final long xWZ = 5L;
  private static final long xXa = 7L;
  private static final long xXb = 9L;
  private static final long xXc = 10L;
  private static final long xXd = 11L;
  private static final long xXe = 12L;
  
  static
  {
    AppMethodBeat.i(119424);
    Bjq = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    pXC = 1092L;
    xWW = 1L;
    xWX = 2L;
    xWY = 4L;
    xWZ = 5L;
    xXa = 7L;
    xXb = 9L;
    xXc = 10L;
    xXd = 11L;
    xXe = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void Bm(long paramLong)
  {
    AppMethodBeat.i(119423);
    ae.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    g.yxI.n(pXC, 13L, 1L);
    g.yxI.n(pXC, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
  
  public static void ent()
  {
    AppMethodBeat.i(119419);
    ae.d(TAG, "markZipFail");
    g.yxI.n(pXC, xWY, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void enu()
  {
    AppMethodBeat.i(119420);
    ae.d(TAG, "markZipTimes");
    g.yxI.n(pXC, xWZ, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void env()
  {
    AppMethodBeat.i(119421);
    ae.d(TAG, "markZipSucc");
    g.yxI.n(pXC, xXc, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void enw()
  {
    AppMethodBeat.i(119422);
    ae.d(TAG, "markZipAllCheckTimes");
    g.yxI.n(pXC, xXa, 1L);
    AppMethodBeat.o(119422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */