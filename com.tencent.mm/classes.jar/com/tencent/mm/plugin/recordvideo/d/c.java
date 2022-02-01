package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
public final class c
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
  public static final c vpz;
  
  static
  {
    AppMethodBeat.i(75843);
    vpz = new c();
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
    AppMethodBeat.o(75843);
  }
  
  public static void diA()
  {
    AppMethodBeat.i(75840);
    ad.d(TAG, "markRemux");
    h.vKh.m(oJZ, vpr, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void diB()
  {
    AppMethodBeat.i(75841);
    ad.d(TAG, "markConfigError");
    h.vKh.m(oJZ, vpx, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void diC()
  {
    AppMethodBeat.i(75842);
    ad.d(TAG, "markCQError");
    h.vKh.m(oJZ, vpy, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */