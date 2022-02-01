package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long pnx = 1092L;
  private static final long wyh = 1L;
  private static final long wyi = 2L;
  private static final long wyj = 4L;
  private static final long wyk = 5L;
  private static final long wyl = 7L;
  private static final long wym = 9L;
  private static final long wyn = 10L;
  private static final long wyo = 11L;
  private static final long wyp = 12L;
  public static final d zAt;
  
  static
  {
    AppMethodBeat.i(119424);
    zAt = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    pnx = 1092L;
    wyh = 1L;
    wyi = 2L;
    wyj = 4L;
    wyk = 5L;
    wyl = 7L;
    wym = 9L;
    wyn = 10L;
    wyo = 11L;
    wyp = 12L;
    AppMethodBeat.o(119424);
  }
  
  public static void dXv()
  {
    AppMethodBeat.i(119419);
    ac.d(TAG, "markZipFail");
    h.wUl.n(pnx, wyj, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void dXw()
  {
    AppMethodBeat.i(119420);
    ac.d(TAG, "markZipTimes");
    h.wUl.n(pnx, wyk, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void dXx()
  {
    AppMethodBeat.i(119421);
    ac.d(TAG, "markZipSucc");
    h.wUl.n(pnx, wyn, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void dXy()
  {
    AppMethodBeat.i(119422);
    ac.d(TAG, "markZipAllCheckTimes");
    h.wUl.n(pnx, wyl, 1L);
    AppMethodBeat.o(119422);
  }
  
  public static void yq(long paramLong)
  {
    AppMethodBeat.i(119423);
    ac.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    h.wUl.n(pnx, 13L, 1L);
    h.wUl.n(pnx, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.d
 * JD-Core Version:    0.7.0.1
 */