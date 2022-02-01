package com.tencent.mm.plugin.recordvideo.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final long ID;
  public static final d NRp;
  private static final long NRq;
  private static final long NRr;
  private static final long NRs;
  private static final long NRt;
  private static final long NRu;
  private static final long NRv;
  private static final long NRw;
  private static final long NRx;
  private static final long NRy;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(75843);
    NRp = new d();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    ID = 1092L;
    NRq = 1L;
    NRr = 2L;
    NRs = 4L;
    NRt = 5L;
    NRu = 7L;
    NRv = 9L;
    NRw = 10L;
    NRx = 11L;
    NRy = 12L;
    AppMethodBeat.o(75843);
  }
  
  public static void gJi()
  {
    AppMethodBeat.i(75840);
    Log.d(TAG, "markRemux");
    h.OAn.p(ID, NRr, 1L);
    AppMethodBeat.o(75840);
  }
  
  public static void gJj()
  {
    AppMethodBeat.i(75841);
    Log.d(TAG, "markConfigError");
    h.OAn.p(ID, NRx, 1L);
    AppMethodBeat.o(75841);
  }
  
  public static void gJk()
  {
    AppMethodBeat.i(75842);
    Log.d(TAG, "markCQError");
    h.OAn.p(ID, NRy, 1L);
    AppMethodBeat.o(75842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.d
 * JD-Core Version:    0.7.0.1
 */