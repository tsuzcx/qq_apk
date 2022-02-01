package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"})
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
  public static final d BXS;
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long oIi = 1092L;
  
  static
  {
    AppMethodBeat.i(75843);
    BXS = new d();
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
    AppMethodBeat.o(75843);
  }
  
  public static void eLa()
  {
    AppMethodBeat.i(75840);
    Log.d(TAG, "markRemux");
    h.CyF.n(oIi, BXK, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void eLb()
  {
    AppMethodBeat.i(75841);
    Log.d(TAG, "markConfigError");
    h.CyF.n(oIi, BXQ, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void eLc()
  {
    AppMethodBeat.i(75842);
    Log.d(TAG, "markCQError");
    h.CyF.n(oIi, BXR, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.d
 * JD-Core Version:    0.7.0.1
 */