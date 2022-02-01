package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
public final class d
{
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
  public static final d xXf;
  
  static
  {
    AppMethodBeat.i(75843);
    xXf = new d();
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
    AppMethodBeat.o(75843);
  }
  
  public static void dKe()
  {
    AppMethodBeat.i(75840);
    ae.d(TAG, "markRemux");
    g.yxI.n(pXC, xWX, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void dKf()
  {
    AppMethodBeat.i(75841);
    ae.d(TAG, "markConfigError");
    g.yxI.n(pXC, xXd, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void dKg()
  {
    AppMethodBeat.i(75842);
    ae.d(TAG, "markCQError");
    g.yxI.n(pXC, xXe, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */