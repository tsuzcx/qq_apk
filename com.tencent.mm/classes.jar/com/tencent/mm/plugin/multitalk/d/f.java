package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/utils/ScreenProjectReportHelper;", "", "()V", "ID", "", "TAG", "", "markClickBlackBoard", "", "markClickDoodle", "markClickFileScreenProject", "markClickIconFlipPage", "markClickMute", "markClickScreenHide", "markClickSpeakerOn", "markClickStopProject", "markClickThumb", "markClickThumbFlipPage", "markExitDuringProfileUI", "markExitProject", "markScrollFlipPage", "markStartProjectDuringProfileUI", "reportScreenProjectDone", "fileExt", "fileSize", "fileName", "totalPages", "", "cost", "errorCode", "avgTransCost", "avgDoodleTransCost", "avgXWebTransCost", "avgFps", "plugin-multitalk_release"})
public final class f
{
  public static final f FEQ;
  private static final long rJY = 1538L;
  
  static
  {
    AppMethodBeat.i(200322);
    FEQ = new f();
    rJY = 1538L;
    AppMethodBeat.o(200322);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3)
  {
    AppMethodBeat.i(200293);
    Log.i("MicroMsg.ScreenProjectReportHelper", "reportScreenProjectDone,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    h.IzE.a(21350, new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(200293);
  }
  
  public static void faa()
  {
    AppMethodBeat.i(200295);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickFileScreenProject");
    h.IzE.p(rJY, 0L, 1L);
    AppMethodBeat.o(200295);
  }
  
  public static void fab()
  {
    AppMethodBeat.i(200297);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitDuringProfileUI");
    h.IzE.p(rJY, 2L, 1L);
    AppMethodBeat.o(200297);
  }
  
  public static void fac()
  {
    AppMethodBeat.i(200299);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markStartProjectDuringProfileUI");
    h.IzE.p(rJY, 3L, 1L);
    AppMethodBeat.o(200299);
  }
  
  public static void fad()
  {
    AppMethodBeat.i(200304);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitProject");
    h.IzE.p(rJY, 4L, 1L);
    AppMethodBeat.o(200304);
  }
  
  public static void fae()
  {
    AppMethodBeat.i(200306);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickStopProject");
    h.IzE.p(rJY, 5L, 1L);
    AppMethodBeat.o(200306);
  }
  
  public static void faf()
  {
    AppMethodBeat.i(200308);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickDoodle");
    h.IzE.p(rJY, 6L, 1L);
    AppMethodBeat.o(200308);
  }
  
  public static void fag()
  {
    AppMethodBeat.i(200309);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickMute");
    h.IzE.p(rJY, 7L, 1L);
    AppMethodBeat.o(200309);
  }
  
  public static void fah()
  {
    AppMethodBeat.i(200310);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickSpeakerOn");
    h.IzE.p(rJY, 8L, 1L);
    AppMethodBeat.o(200310);
  }
  
  public static void fai()
  {
    AppMethodBeat.i(200312);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumb");
    h.IzE.p(rJY, 10L, 1L);
    AppMethodBeat.o(200312);
  }
  
  public static void faj()
  {
    AppMethodBeat.i(200313);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumbFlipPage");
    h.IzE.p(rJY, 11L, 1L);
    AppMethodBeat.o(200313);
  }
  
  public static void fak()
  {
    AppMethodBeat.i(200315);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markScrollFlipPage");
    h.IzE.p(rJY, 12L, 1L);
    AppMethodBeat.o(200315);
  }
  
  public static void fal()
  {
    AppMethodBeat.i(200317);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickIconFlipPage");
    h.IzE.p(rJY, 13L, 1L);
    AppMethodBeat.o(200317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.f
 * JD-Core Version:    0.7.0.1
 */