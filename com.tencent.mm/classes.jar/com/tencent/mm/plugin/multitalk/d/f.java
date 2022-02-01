package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/utils/ScreenProjectReportHelper;", "", "()V", "ID", "", "TAG", "", "markClickBlackBoard", "", "markClickDoodle", "markClickFileScreenProject", "markClickIconFlipPage", "markClickMute", "markClickScreenHide", "markClickSpeakerOn", "markClickStopProject", "markClickThumb", "markClickThumbFlipPage", "markExitDuringProfileUI", "markExitProject", "markScrollFlipPage", "markStartProjectDuringProfileUI", "reportScreenProjectDone", "fileExt", "fileSize", "fileName", "totalPages", "", "cost", "errorCode", "avgTransCost", "avgDoodleTransCost", "avgXWebTransCost", "avgFps", "plugin-multitalk_release"})
public final class f
{
  private static final long oIi = 1538L;
  public static final f zZd;
  
  static
  {
    AppMethodBeat.i(240122);
    zZd = new f();
    oIi = 1538L;
    AppMethodBeat.o(240122);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, int paramInt1, long paramLong2, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3)
  {
    AppMethodBeat.i(240108);
    Log.i("MicroMsg.ScreenProjectReportHelper", "reportScreenProjectDone,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    h.CyF.a(21350, new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(240108);
  }
  
  public static void eqj()
  {
    AppMethodBeat.i(240109);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickFileScreenProject");
    h.CyF.n(oIi, 0L, 1L);
    AppMethodBeat.o(240109);
  }
  
  public static void eqk()
  {
    AppMethodBeat.i(240110);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickBlackBoard");
    h.CyF.n(oIi, 1L, 1L);
    AppMethodBeat.o(240110);
  }
  
  public static void eql()
  {
    AppMethodBeat.i(240111);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitDuringProfileUI");
    h.CyF.n(oIi, 2L, 1L);
    AppMethodBeat.o(240111);
  }
  
  public static void eqm()
  {
    AppMethodBeat.i(240112);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markStartProjectDuringProfileUI");
    h.CyF.n(oIi, 3L, 1L);
    AppMethodBeat.o(240112);
  }
  
  public static void eqn()
  {
    AppMethodBeat.i(240113);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markExitProject");
    h.CyF.n(oIi, 4L, 1L);
    AppMethodBeat.o(240113);
  }
  
  public static void eqo()
  {
    AppMethodBeat.i(240114);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickStopProject");
    h.CyF.n(oIi, 5L, 1L);
    AppMethodBeat.o(240114);
  }
  
  public static void eqp()
  {
    AppMethodBeat.i(240115);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickDoodle");
    h.CyF.n(oIi, 6L, 1L);
    AppMethodBeat.o(240115);
  }
  
  public static void eqq()
  {
    AppMethodBeat.i(240116);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickMute");
    h.CyF.n(oIi, 7L, 1L);
    AppMethodBeat.o(240116);
  }
  
  public static void eqr()
  {
    AppMethodBeat.i(240117);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickSpeakerOn");
    h.CyF.n(oIi, 8L, 1L);
    AppMethodBeat.o(240117);
  }
  
  public static void eqs()
  {
    AppMethodBeat.i(240118);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumb");
    h.CyF.n(oIi, 10L, 1L);
    AppMethodBeat.o(240118);
  }
  
  public static void eqt()
  {
    AppMethodBeat.i(240119);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickThumbFlipPage");
    h.CyF.n(oIi, 11L, 1L);
    AppMethodBeat.o(240119);
  }
  
  public static void equ()
  {
    AppMethodBeat.i(240120);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markScrollFlipPage");
    h.CyF.n(oIi, 12L, 1L);
    AppMethodBeat.o(240120);
  }
  
  public static void eqv()
  {
    AppMethodBeat.i(240121);
    Log.i("MicroMsg.ScreenProjectReportHelper", "markClickIconFlipPage");
    h.CyF.n(oIi, 13L, 1L);
    AppMethodBeat.o(240121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.f
 * JD-Core Version:    0.7.0.1
 */