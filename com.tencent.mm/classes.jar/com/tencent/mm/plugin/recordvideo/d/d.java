package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
public final class d
{
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
  public static final d xHk;
  
  static
  {
    AppMethodBeat.i(75843);
    xHk = new d();
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
    AppMethodBeat.o(75843);
  }
  
  public static void dGN()
  {
    AppMethodBeat.i(75840);
    ad.d(TAG, "markRemux");
    g.yhR.n(pQX, xHc, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void dGO()
  {
    AppMethodBeat.i(75841);
    ad.d(TAG, "markConfigError");
    g.yhR.n(pQX, xHi, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void dGP()
  {
    AppMethodBeat.i(75842);
    ad.d(TAG, "markCQError");
    g.yhR.n(pQX, xHj, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */