package com.tencent.mm.plugin.multitalk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/ScreenProjectReportHelper;", "", "()V", "ID", "", "TAG", "", "markClickBlackBoard", "", "markClickDoodle", "markClickFileScreenProject", "markClickIconFlipPage", "markClickMute", "markClickScreenHide", "markClickSpeakerOn", "markClickStopProject", "markClickThumb", "markClickThumbFlipPage", "markExitDuringProfileUI", "markExitProject", "markScrollFlipPage", "markStartProjectDuringProfileUI", "reportScreenProjectDone", "fileExt", "fileSize", "fileName", "totalPages", "", "cost", "errorCode", "avgTransCost", "avgDoodleTransCost", "avgXWebTransCost", "avgFps", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final long ID;
  public static final g LAS;
  
  static
  {
    AppMethodBeat.i(284661);
    LAS = new g();
    ID = 1538L;
    AppMethodBeat.o(284661);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3)
  {
    AppMethodBeat.i(284607);
    Log.i("MicroMsg.ScreenProjectReportHelper", "reportScreenProjectDone,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    h.OAn.b(21350, new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(284607);
  }
  
  public static void gjf()
  {
    AppMethodBeat.i(284610);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickFileScreenProject");
    h.OAn.p(ID, 0L, 1L);
    AppMethodBeat.o(284610);
  }
  
  public static void gjg()
  {
    AppMethodBeat.i(284612);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitDuringProfileUI");
    h.OAn.p(ID, 2L, 1L);
    AppMethodBeat.o(284612);
  }
  
  public static void gjh()
  {
    AppMethodBeat.i(284614);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markStartProjectDuringProfileUI");
    h.OAn.p(ID, 3L, 1L);
    AppMethodBeat.o(284614);
  }
  
  public static void gji()
  {
    AppMethodBeat.i(284617);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitProject");
    h.OAn.p(ID, 4L, 1L);
    AppMethodBeat.o(284617);
  }
  
  public static void gjj()
  {
    AppMethodBeat.i(284619);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickStopProject");
    h.OAn.p(ID, 5L, 1L);
    AppMethodBeat.o(284619);
  }
  
  public static void gjk()
  {
    AppMethodBeat.i(284622);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickDoodle");
    h.OAn.p(ID, 6L, 1L);
    AppMethodBeat.o(284622);
  }
  
  public static void gjl()
  {
    AppMethodBeat.i(284625);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickMute");
    h.OAn.p(ID, 7L, 1L);
    AppMethodBeat.o(284625);
  }
  
  public static void gjm()
  {
    AppMethodBeat.i(284630);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickSpeakerOn");
    h.OAn.p(ID, 8L, 1L);
    AppMethodBeat.o(284630);
  }
  
  public static void gjn()
  {
    AppMethodBeat.i(284639);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumb");
    h.OAn.p(ID, 10L, 1L);
    AppMethodBeat.o(284639);
  }
  
  public static void gjo()
  {
    AppMethodBeat.i(284646);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumbFlipPage");
    h.OAn.p(ID, 11L, 1L);
    AppMethodBeat.o(284646);
  }
  
  public static void gjp()
  {
    AppMethodBeat.i(284651);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markScrollFlipPage");
    h.OAn.p(ID, 12L, 1L);
    AppMethodBeat.o(284651);
  }
  
  public static void gjq()
  {
    AppMethodBeat.i(284655);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickIconFlipPage");
    h.OAn.p(ID, 13L, 1L);
    AppMethodBeat.o(284655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.g
 * JD-Core Version:    0.7.0.1
 */