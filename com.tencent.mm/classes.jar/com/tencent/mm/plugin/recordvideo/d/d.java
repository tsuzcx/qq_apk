package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
public final class d
{
  private static final long HUA = 5L;
  private static final long HUB = 7L;
  private static final long HUC = 9L;
  private static final long HUD = 10L;
  private static final long HUE = 11L;
  private static final long HUF = 12L;
  public static final d HUG;
  private static final long HUx = 1L;
  private static final long HUy = 2L;
  private static final long HUz = 4L;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long rJY = 1092L;
  
  static
  {
    AppMethodBeat.i(75843);
    HUG = new d();
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
    AppMethodBeat.o(75843);
  }
  
  public static void fxt()
  {
    AppMethodBeat.i(75840);
    Log.d(TAG, "markRemux");
    h.IzE.p(rJY, HUy, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void fxu()
  {
    AppMethodBeat.i(75841);
    Log.d(TAG, "markConfigError");
    h.IzE.p(rJY, HUE, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void fxv()
  {
    AppMethodBeat.i(75842);
    Log.d(TAG, "markCQError");
    h.IzE.p(rJY, HUF, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */