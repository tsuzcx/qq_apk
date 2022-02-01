package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
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
  public static final d wyq;
  
  static
  {
    AppMethodBeat.i(75843);
    wyq = new d();
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
    AppMethodBeat.o(75843);
  }
  
  public static void dwt()
  {
    AppMethodBeat.i(75840);
    ac.d(TAG, "markRemux");
    h.wUl.n(pnx, wyi, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void dwu()
  {
    AppMethodBeat.i(75841);
    ac.d(TAG, "markConfigError");
    h.wUl.n(pnx, wyo, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void dwv()
  {
    AppMethodBeat.i(75842);
    ac.d(TAG, "markCQError");
    h.wUl.n(pnx, wyp, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */