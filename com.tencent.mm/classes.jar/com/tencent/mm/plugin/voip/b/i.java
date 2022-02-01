package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class i
{
  public static final i AMu;
  
  static
  {
    AppMethodBeat.i(208722);
    AMu = new i();
    AppMethodBeat.o(208722);
  }
  
  public static void elU()
  {
    AppMethodBeat.i(208687);
    ac.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    h.wUl.n(1304L, 1L, 1L);
    AppMethodBeat.o(208687);
  }
  
  public static void elV()
  {
    AppMethodBeat.i(208688);
    ac.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    h.wUl.n(1304L, 2L, 1L);
    AppMethodBeat.o(208688);
  }
  
  public static void elW()
  {
    AppMethodBeat.i(208689);
    ac.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    h.wUl.n(1304L, 3L, 1L);
    AppMethodBeat.o(208689);
  }
  
  public static void elX()
  {
    AppMethodBeat.i(208690);
    ac.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    h.wUl.n(1304L, 4L, 1L);
    AppMethodBeat.o(208690);
  }
  
  public static void elY()
  {
    AppMethodBeat.i(208693);
    ac.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    h.wUl.n(1304L, 7L, 1L);
    AppMethodBeat.o(208693);
  }
  
  public static void elZ()
  {
    AppMethodBeat.i(208694);
    ac.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    h.wUl.n(1304L, 8L, 1L);
    AppMethodBeat.o(208694);
  }
  
  public static void ema()
  {
    AppMethodBeat.i(208695);
    ac.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    h.wUl.n(1304L, 9L, 1L);
    AppMethodBeat.o(208695);
  }
  
  public static void emb()
  {
    AppMethodBeat.i(208696);
    ac.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    h.wUl.n(1304L, 10L, 1L);
    AppMethodBeat.o(208696);
  }
  
  public static void emc()
  {
    AppMethodBeat.i(208701);
    ac.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    h.wUl.n(1304L, 15L, 1L);
    AppMethodBeat.o(208701);
  }
  
  public static void emd()
  {
    AppMethodBeat.i(208702);
    ac.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    h.wUl.n(1304L, 16L, 1L);
    AppMethodBeat.o(208702);
  }
  
  public static void eme()
  {
    AppMethodBeat.i(208703);
    ac.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    h.wUl.n(1304L, 17L, 1L);
    AppMethodBeat.o(208703);
  }
  
  public static void emf()
  {
    AppMethodBeat.i(208704);
    ac.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    h.wUl.n(1304L, 18L, 1L);
    AppMethodBeat.o(208704);
  }
  
  public static void emg()
  {
    AppMethodBeat.i(208705);
    ac.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
    h.wUl.n(1304L, 19L, 1L);
    AppMethodBeat.o(208705);
  }
  
  public static void yU(long paramLong)
  {
    AppMethodBeat.i(208697);
    ac.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(208697);
  }
  
  public static void yV(long paramLong)
  {
    AppMethodBeat.i(208698);
    ac.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(208698);
  }
  
  public static void yW(long paramLong)
  {
    AppMethodBeat.i(208706);
    ac.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 20, 38, (int)paramLong, false);
    AppMethodBeat.o(208706);
  }
  
  public static void yX(long paramLong)
  {
    AppMethodBeat.i(208707);
    ac.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 21, 39, (int)paramLong, false);
    AppMethodBeat.o(208707);
  }
  
  public static void yY(long paramLong)
  {
    AppMethodBeat.i(208708);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(208708);
  }
  
  public static void yZ(long paramLong)
  {
    AppMethodBeat.i(208709);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(208709);
  }
  
  public static void za(long paramLong)
  {
    AppMethodBeat.i(208710);
    ac.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(208710);
  }
  
  public static void zb(long paramLong)
  {
    AppMethodBeat.i(208711);
    ac.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(208711);
  }
  
  public static void zc(long paramLong)
  {
    AppMethodBeat.i(208712);
    ac.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(208712);
  }
  
  public static void zd(long paramLong)
  {
    AppMethodBeat.i(208713);
    ac.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(208713);
  }
  
  public static void zi(long paramLong)
  {
    AppMethodBeat.i(208718);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(208718);
  }
  
  public static void zj(long paramLong)
  {
    AppMethodBeat.i(208719);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(208719);
  }
  
  public static void zk(long paramLong)
  {
    AppMethodBeat.i(208720);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(208720);
  }
  
  public static void zl(long paramLong)
  {
    AppMethodBeat.i(208721);
    ac.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(208721);
  }
  
  public static void zm(long paramLong)
  {
    AppMethodBeat.i(208691);
    ac.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,width=".concat(String.valueOf(paramLong)));
    h.wUl.n(1304L, 5L, paramLong);
    AppMethodBeat.o(208691);
  }
  
  public static void zn(long paramLong)
  {
    AppMethodBeat.i(208692);
    ac.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,height=".concat(String.valueOf(paramLong)));
    h.wUl.n(1304L, 6L, paramLong);
    AppMethodBeat.o(208692);
  }
  
  public static void zo(long paramLong)
  {
    AppMethodBeat.i(208699);
    ac.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(208699);
  }
  
  public static void zp(long paramLong)
  {
    AppMethodBeat.i(208700);
    ac.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(208700);
  }
  
  public static void zq(long paramLong)
  {
    AppMethodBeat.i(208714);
    ac.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(208714);
  }
  
  public static void zr(long paramLong)
  {
    AppMethodBeat.i(208715);
    ac.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(208715);
  }
  
  public static void zs(long paramLong)
  {
    AppMethodBeat.i(208716);
    ac.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(208716);
  }
  
  public static void zt(long paramLong)
  {
    AppMethodBeat.i(208717);
    ac.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(208717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.i
 * JD-Core Version:    0.7.0.1
 */