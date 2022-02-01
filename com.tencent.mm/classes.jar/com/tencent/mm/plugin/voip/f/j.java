package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRemovePreviewCallback", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j UMb;
  
  static
  {
    AppMethodBeat.i(292764);
    UMb = new j();
    AppMethodBeat.o(292764);
  }
  
  public static void ibP()
  {
    AppMethodBeat.i(292530);
    Log.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 1L, 1L);
    AppMethodBeat.o(292530);
  }
  
  public static void ibQ()
  {
    AppMethodBeat.i(292537);
    Log.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 2L, 1L);
    AppMethodBeat.o(292537);
  }
  
  public static void ibR()
  {
    AppMethodBeat.i(292543);
    Log.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 3L, 1L);
    AppMethodBeat.o(292543);
  }
  
  public static void ibS()
  {
    AppMethodBeat.i(292550);
    Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 4L, 1L);
    AppMethodBeat.o(292550);
  }
  
  public static void ibT()
  {
    AppMethodBeat.i(292572);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 7L, 1L);
    AppMethodBeat.o(292572);
  }
  
  public static void ibU()
  {
    AppMethodBeat.i(292576);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 8L, 1L);
    AppMethodBeat.o(292576);
  }
  
  public static void ibV()
  {
    AppMethodBeat.i(292582);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 9L, 1L);
    AppMethodBeat.o(292582);
  }
  
  public static void ibW()
  {
    AppMethodBeat.i(292591);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 10L, 1L);
    AppMethodBeat.o(292591);
  }
  
  public static void ibX()
  {
    AppMethodBeat.i(292626);
    Log.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 15L, 1L);
    AppMethodBeat.o(292626);
  }
  
  public static void ibY()
  {
    AppMethodBeat.i(292634);
    Log.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 16L, 1L);
    AppMethodBeat.o(292634);
  }
  
  public static void ibZ()
  {
    AppMethodBeat.i(292642);
    Log.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 17L, 1L);
    AppMethodBeat.o(292642);
  }
  
  public static void ica()
  {
    AppMethodBeat.i(292648);
    Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 18L, 1L);
    AppMethodBeat.o(292648);
  }
  
  public static void wY(long paramLong)
  {
    AppMethodBeat.i(292557);
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 5L, paramLong);
    AppMethodBeat.o(292557);
  }
  
  public static void wZ(long paramLong)
  {
    AppMethodBeat.i(292565);
    com.tencent.mm.plugin.report.service.h.OAn.p(1304L, 6L, paramLong);
    AppMethodBeat.o(292565);
  }
  
  public static void xa(long paramLong)
  {
    AppMethodBeat.i(292599);
    Log.i("MicroMsg.VoipReportHelper", s.X("markDecodeModeChangeToHW,count=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(292599);
  }
  
  public static void xb(long paramLong)
  {
    AppMethodBeat.i(292607);
    Log.i("MicroMsg.VoipReportHelper", s.X("markDecodeModeChangeToSW,count=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(292607);
  }
  
  public static void xc(long paramLong)
  {
    AppMethodBeat.i(292614);
    Log.i("MicroMsg.VoipReportHelper", s.X("markFullScreenPercent,percent=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(292614);
  }
  
  public static void xd(long paramLong)
  {
    AppMethodBeat.i(292619);
    Log.i("MicroMsg.VoipReportHelper", s.X("markMiniWindowsPercent,percent=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(292619);
  }
  
  public static void xe(long paramLong)
  {
    AppMethodBeat.i(292654);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewFullScreenToRendererCost, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(292654);
  }
  
  public static void xf(long paramLong)
  {
    AppMethodBeat.i(292659);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewMiniWindowToRendererCost, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(292659);
  }
  
  public static void xg(long paramLong)
  {
    AppMethodBeat.i(292666);
    Log.i("MicroMsg.VoipReportHelper", s.X("markYuvRendererPerFrameFullScreenCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(292666);
  }
  
  public static void xh(long paramLong)
  {
    AppMethodBeat.i(292676);
    Log.i("MicroMsg.VoipReportHelper", s.X("markYuvRendererPerFrameMiniWindowCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(292676);
  }
  
  public static void xi(long paramLong)
  {
    AppMethodBeat.i(292685);
    Log.i("MicroMsg.VoipReportHelper", s.X("markHWRendererPerFrameFullScreenCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(292685);
  }
  
  public static void xj(long paramLong)
  {
    AppMethodBeat.i(292690);
    Log.i("MicroMsg.VoipReportHelper", s.X("markHWRendererPerFrameMiniWindowCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(292690);
  }
  
  public static void xk(long paramLong)
  {
    AppMethodBeat.i(292694);
    Log.i("MicroMsg.VoipReportHelper", s.X("markCameraRendererPerFrameNewFullScreenCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(292694);
  }
  
  public static void xl(long paramLong)
  {
    AppMethodBeat.i(292701);
    Log.i("MicroMsg.VoipReportHelper", s.X("markCameraRendererPerFrameNewMiniWindowCost,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(292701);
  }
  
  public static void xm(long paramLong)
  {
    AppMethodBeat.i(292706);
    Log.i("MicroMsg.VoipReportHelper", s.X("markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(292706);
  }
  
  public static void xn(long paramLong)
  {
    AppMethodBeat.i(292713);
    Log.i("MicroMsg.VoipReportHelper", s.X("markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(292713);
  }
  
  public static void xo(long paramLong)
  {
    AppMethodBeat.i(292718);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewFullScreenToRendererCostInvite, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(292718);
  }
  
  public static void xp(long paramLong)
  {
    AppMethodBeat.i(292727);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewMiniWindowToRendererCostInvite, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(292727);
  }
  
  public static void xq(long paramLong)
  {
    AppMethodBeat.i(292732);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewFullScreenToRendererCostFirst, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(292732);
  }
  
  public static void xr(long paramLong)
  {
    AppMethodBeat.i(292736);
    Log.i("MicroMsg.VoipReportHelper", s.X("markAddViewMiniWindowToRendererCostFirst, data=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(292736);
  }
  
  public static void xs(long paramLong)
  {
    AppMethodBeat.i(292739);
    Log.i("MicroMsg.VoipReportHelper", s.X("markSoftRgb2YuvAvgCost, gpu trans cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 81, 82, (int)paramLong, false);
    AppMethodBeat.o(292739);
  }
  
  public static void xt(long paramLong)
  {
    AppMethodBeat.i(292749);
    h localh = h.ULL;
    if (h.ibC())
    {
      Log.i("MicroMsg.VoipReportHelper", s.X("markSoftEncodeAvgCost, gpu crop trans cost=", Long.valueOf(paramLong)));
      com.tencent.mm.plugin.report.service.h.OAn.c(1304, 111, 112, (int)paramLong, false);
      AppMethodBeat.o(292749);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", s.X("markSoftEncodeAvgCost, gpu trans cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 87, 88, (int)paramLong, false);
    AppMethodBeat.o(292749);
  }
  
  public static void xu(long paramLong)
  {
    AppMethodBeat.i(292755);
    h localh = h.ULL;
    if (h.ibC())
    {
      Log.i("MicroMsg.VoipReportHelper", s.X("markHWEncodeAvgCost, gpu crop trans cost=", Long.valueOf(paramLong)));
      com.tencent.mm.plugin.report.service.h.OAn.c(1304, 108, 109, (int)paramLong, false);
      AppMethodBeat.o(292755);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", s.X("markHWEncodeAvgCost, gpu trans cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 93, 94, (int)paramLong, false);
    AppMethodBeat.o(292755);
  }
  
  public static void xv(long paramLong)
  {
    AppMethodBeat.i(292757);
    Log.i("MicroMsg.VoipReportHelper", s.X("markRenderAvgCost, gpu trans cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 99, 100, (int)paramLong, false);
    AppMethodBeat.o(292757);
  }
  
  public static void xw(long paramLong)
  {
    AppMethodBeat.i(292760);
    Log.i("MicroMsg.VoipReportHelper", s.X("markTexture2BytearrayAvgCost, gpu trans cost=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.c(1304, 105, 106, (int)paramLong, false);
    AppMethodBeat.o(292760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.j
 * JD-Core Version:    0.7.0.1
 */