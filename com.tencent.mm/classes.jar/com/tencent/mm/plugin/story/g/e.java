package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryImageVideoIDKey;", "", "()V", "ID", "", "getID", "()J", "Key_CQError", "getKey_CQError", "Key_ConfigError", "getKey_ConfigError", "Key_RemuxFail", "getKey_RemuxFail", "Key_RemuxSucc", "getKey_RemuxSucc", "Key_RemuxTimes", "getKey_RemuxTimes", "Key_ZipAllCheckTimes", "getKey_ZipAllCheckTimes", "Key_ZipFail", "getKey_ZipFail", "Key_ZipSucc", "getKey_ZipSucc", "Key_ZipTimes", "getKey_ZipTimes", "TAG", "", "getTAG", "()Ljava/lang/String;", "markCQError", "", "markConfigError", "markRemux", "markRemuxFail", "markRemuxSucc", "markZipAllCheckTimes", "markZipFail", "markZipSucc", "markZipTimes", "reportCodecTime", "t", "reportZipTime", "plugin-story_release"})
public final class e
{
  private static final String TAG = "MicroMsg.StoryImageVideoIDKey";
  private static final long ltw = 1092L;
  private static final long sEn = 1L;
  private static final long sEo = 2L;
  private static final long sEp = 4L;
  private static final long sEq = 5L;
  private static final long sEr = 7L;
  private static final long sEs = 9L;
  private static final long sEt = 10L;
  private static final long sEu = 11L;
  private static final long sEv = 12L;
  public static final e sEw;
  
  static
  {
    AppMethodBeat.i(155317);
    sEw = new e();
    TAG = "MicroMsg.StoryImageVideoIDKey";
    ltw = 1092L;
    sEn = 1L;
    sEo = 2L;
    sEp = 4L;
    sEq = 5L;
    sEr = 7L;
    sEs = 9L;
    sEt = 10L;
    sEu = 11L;
    sEv = 12L;
    AppMethodBeat.o(155317);
  }
  
  public static void cCJ()
  {
    AppMethodBeat.i(155306);
    ab.d(TAG, "markRemuxFail");
    h.qsU.j(ltw, sEn, 1L);
    AppMethodBeat.o(155306);
  }
  
  public static void cCK()
  {
    AppMethodBeat.i(155307);
    ab.d(TAG, "markRemux");
    h.qsU.j(ltw, sEo, 1L);
    AppMethodBeat.o(155307);
  }
  
  public static void cCL()
  {
    AppMethodBeat.i(155308);
    ab.d(TAG, "markRemuxSucc");
    h.qsU.j(ltw, sEs, 1L);
    AppMethodBeat.o(155308);
  }
  
  public static void cCM()
  {
    AppMethodBeat.i(155309);
    ab.d(TAG, "markZipFail");
    h.qsU.j(ltw, sEp, 1L);
    AppMethodBeat.o(155309);
  }
  
  public static void cCN()
  {
    AppMethodBeat.i(155310);
    ab.d(TAG, "markZipTimes");
    h.qsU.j(ltw, sEq, 1L);
    AppMethodBeat.o(155310);
  }
  
  public static void cCO()
  {
    AppMethodBeat.i(155311);
    ab.d(TAG, "markZipSucc");
    h.qsU.j(ltw, sEt, 1L);
    AppMethodBeat.o(155311);
  }
  
  public static void cCP()
  {
    AppMethodBeat.i(155312);
    ab.d(TAG, "markZipAllCheckTimes");
    h.qsU.j(ltw, sEr, 1L);
    AppMethodBeat.o(155312);
  }
  
  public static void cCQ()
  {
    AppMethodBeat.i(155313);
    ab.d(TAG, "markConfigError");
    h.qsU.j(ltw, sEu, 1L);
    AppMethodBeat.o(155313);
  }
  
  public static void cCR()
  {
    AppMethodBeat.i(155314);
    ab.d(TAG, "markCQError");
    h.qsU.j(ltw, sEv, 1L);
    AppMethodBeat.o(155314);
  }
  
  public static void mK(long paramLong)
  {
    AppMethodBeat.i(155315);
    ab.d(TAG, "reportZipTime ".concat(String.valueOf(paramLong)));
    h.qsU.j(ltw, 13L, 1L);
    h.qsU.j(ltw, 14L, paramLong);
    AppMethodBeat.o(155315);
  }
  
  public static void mL(long paramLong)
  {
    AppMethodBeat.i(155316);
    ab.d(TAG, "reportCodecTime ".concat(String.valueOf(paramLong)));
    h.qsU.j(ltw, 16L, 1L);
    h.qsU.j(ltw, 17L, paramLong);
    AppMethodBeat.o(155316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.e
 * JD-Core Version:    0.7.0.1
 */