package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markX264Disable", "markX264FailTimes", "markX264Times", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportX264CostTime", "reportZipTime", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final long ID;
  private static final long NRq;
  private static final long NRr;
  private static final long NRs;
  private static final long NRt;
  private static final long NRu;
  private static final long NRv;
  private static final long NRw;
  private static final long NRx;
  private static final long NRy;
  public static final d SqV;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(119424);
    SqV = new d();
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
    AppMethodBeat.o(119424);
  }
  
  public static void hxH()
  {
    AppMethodBeat.i(119419);
    Log.d(TAG, "markZipFail");
    h.OAn.p(ID, NRs, 1L);
    AppMethodBeat.o(119419);
  }
  
  public static void hxI()
  {
    AppMethodBeat.i(119420);
    Log.d(TAG, "markZipTimes");
    h.OAn.p(ID, NRt, 1L);
    AppMethodBeat.o(119420);
  }
  
  public static void hxJ()
  {
    AppMethodBeat.i(119421);
    Log.d(TAG, "markZipSucc");
    h.OAn.p(ID, NRw, 1L);
    AppMethodBeat.o(119421);
  }
  
  public static void hxK()
  {
    AppMethodBeat.i(119422);
    Log.d(TAG, "markZipAllCheckTimes");
    h.OAn.p(ID, NRu, 1L);
    AppMethodBeat.o(119422);
  }
  
  public static void vU(long paramLong)
  {
    AppMethodBeat.i(119423);
    Log.d(TAG, s.X("reportZipTime ", Long.valueOf(paramLong)));
    h.OAn.p(ID, 13L, 1L);
    h.OAn.p(ID, 14L, paramLong);
    AppMethodBeat.o(119423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.d
 * JD-Core Version:    0.7.0.1
 */