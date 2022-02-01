package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class k
{
  public static final k CDm;
  
  static
  {
    AppMethodBeat.i(210479);
    CDm = new k();
    AppMethodBeat.o(210479);
  }
  
  public static void BZ(long paramLong)
  {
    AppMethodBeat.i(210449);
    ae.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(210449);
  }
  
  public static void CA(long paramLong)
  {
    AppMethodBeat.i(210475);
    h localh = h.CCW;
    if (h.eDp())
    {
      ae.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 111, 112, (int)paramLong, false);
      AppMethodBeat.o(210475);
      return;
    }
    localh = h.CCW;
    if (!h.eDo())
    {
      ae.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 84, 85, (int)paramLong, false);
      AppMethodBeat.o(210475);
      return;
    }
    ae.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 87, 88, (int)paramLong, false);
    AppMethodBeat.o(210475);
  }
  
  public static void CB(long paramLong)
  {
    AppMethodBeat.i(210476);
    h localh = h.CCW;
    if (h.eDp())
    {
      ae.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 108, 109, (int)paramLong, false);
      AppMethodBeat.o(210476);
      return;
    }
    localh = h.CCW;
    if (!h.eDo())
    {
      ae.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 90, 91, (int)paramLong, false);
      AppMethodBeat.o(210476);
      return;
    }
    ae.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 93, 94, (int)paramLong, false);
    AppMethodBeat.o(210476);
  }
  
  public static void CC(long paramLong)
  {
    AppMethodBeat.i(210477);
    h localh = h.CCW;
    if (!h.eDo())
    {
      ae.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 96, 97, (int)paramLong, false);
      AppMethodBeat.o(210477);
      return;
    }
    ae.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 99, 100, (int)paramLong, false);
    AppMethodBeat.o(210477);
  }
  
  public static void CD(long paramLong)
  {
    AppMethodBeat.i(210478);
    h localh = h.CCW;
    if (!h.eDo())
    {
      ae.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 102, 103, (int)paramLong, false);
      AppMethodBeat.o(210478);
      return;
    }
    ae.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 105, 106, (int)paramLong, false);
    AppMethodBeat.o(210478);
  }
  
  public static void Ca(long paramLong)
  {
    AppMethodBeat.i(210450);
    ae.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(210450);
  }
  
  public static void Cb(long paramLong)
  {
    AppMethodBeat.i(210458);
    ae.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 20, 38, (int)paramLong, false);
    AppMethodBeat.o(210458);
  }
  
  public static void Cc(long paramLong)
  {
    AppMethodBeat.i(210459);
    ae.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 21, 39, (int)paramLong, false);
    AppMethodBeat.o(210459);
  }
  
  public static void Cd(long paramLong)
  {
    AppMethodBeat.i(210460);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(210460);
  }
  
  public static void Ce(long paramLong)
  {
    AppMethodBeat.i(210461);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(210461);
  }
  
  public static void Cf(long paramLong)
  {
    AppMethodBeat.i(210462);
    ae.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(210462);
  }
  
  public static void Cg(long paramLong)
  {
    AppMethodBeat.i(210463);
    ae.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(210463);
  }
  
  public static void Ch(long paramLong)
  {
    AppMethodBeat.i(210464);
    ae.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(210464);
  }
  
  public static void Ci(long paramLong)
  {
    AppMethodBeat.i(210465);
    ae.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(210465);
  }
  
  public static void Cn(long paramLong)
  {
    AppMethodBeat.i(210470);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(210470);
  }
  
  public static void Co(long paramLong)
  {
    AppMethodBeat.i(210471);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(210471);
  }
  
  public static void Cp(long paramLong)
  {
    AppMethodBeat.i(210472);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(210472);
  }
  
  public static void Cq(long paramLong)
  {
    AppMethodBeat.i(210473);
    ae.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(210473);
  }
  
  public static void Cr(long paramLong)
  {
    AppMethodBeat.i(210443);
    ae.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,width=".concat(String.valueOf(paramLong)));
    g.yxI.n(1304L, 5L, paramLong);
    AppMethodBeat.o(210443);
  }
  
  public static void Cs(long paramLong)
  {
    AppMethodBeat.i(210444);
    ae.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,height=".concat(String.valueOf(paramLong)));
    g.yxI.n(1304L, 6L, paramLong);
    AppMethodBeat.o(210444);
  }
  
  public static void Ct(long paramLong)
  {
    AppMethodBeat.i(210451);
    ae.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(210451);
  }
  
  public static void Cu(long paramLong)
  {
    AppMethodBeat.i(210452);
    ae.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(210452);
  }
  
  public static void Cv(long paramLong)
  {
    AppMethodBeat.i(210466);
    ae.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(210466);
  }
  
  public static void Cw(long paramLong)
  {
    AppMethodBeat.i(210467);
    ae.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(210467);
  }
  
  public static void Cx(long paramLong)
  {
    AppMethodBeat.i(210468);
    ae.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(210468);
  }
  
  public static void Cy(long paramLong)
  {
    AppMethodBeat.i(210469);
    ae.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(210469);
  }
  
  public static void Cz(long paramLong)
  {
    AppMethodBeat.i(210474);
    h localh = h.CCW;
    if (!h.eDo())
    {
      ae.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yxI.c(1304, 78, 79, (int)paramLong, false);
      AppMethodBeat.o(210474);
      return;
    }
    ae.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yxI.c(1304, 81, 82, (int)paramLong, false);
    AppMethodBeat.o(210474);
  }
  
  public static void eDA()
  {
    AppMethodBeat.i(210442);
    ae.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    g.yxI.n(1304L, 4L, 1L);
    AppMethodBeat.o(210442);
  }
  
  public static void eDB()
  {
    AppMethodBeat.i(210445);
    ae.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    g.yxI.n(1304L, 7L, 1L);
    AppMethodBeat.o(210445);
  }
  
  public static void eDC()
  {
    AppMethodBeat.i(210446);
    ae.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    g.yxI.n(1304L, 8L, 1L);
    AppMethodBeat.o(210446);
  }
  
  public static void eDD()
  {
    AppMethodBeat.i(210447);
    ae.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    g.yxI.n(1304L, 9L, 1L);
    AppMethodBeat.o(210447);
  }
  
  public static void eDE()
  {
    AppMethodBeat.i(210448);
    ae.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    g.yxI.n(1304L, 10L, 1L);
    AppMethodBeat.o(210448);
  }
  
  public static void eDF()
  {
    AppMethodBeat.i(210453);
    ae.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    g.yxI.n(1304L, 15L, 1L);
    AppMethodBeat.o(210453);
  }
  
  public static void eDG()
  {
    AppMethodBeat.i(210454);
    ae.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    g.yxI.n(1304L, 16L, 1L);
    AppMethodBeat.o(210454);
  }
  
  public static void eDH()
  {
    AppMethodBeat.i(210455);
    ae.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    g.yxI.n(1304L, 17L, 1L);
    AppMethodBeat.o(210455);
  }
  
  public static void eDI()
  {
    AppMethodBeat.i(210456);
    ae.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    g.yxI.n(1304L, 18L, 1L);
    AppMethodBeat.o(210456);
  }
  
  public static void eDJ()
  {
    AppMethodBeat.i(210457);
    ae.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
    g.yxI.n(1304L, 19L, 1L);
    AppMethodBeat.o(210457);
  }
  
  public static void eDx()
  {
    AppMethodBeat.i(210439);
    ae.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    g.yxI.n(1304L, 1L, 1L);
    AppMethodBeat.o(210439);
  }
  
  public static void eDy()
  {
    AppMethodBeat.i(210440);
    ae.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    g.yxI.n(1304L, 2L, 1L);
    AppMethodBeat.o(210440);
  }
  
  public static void eDz()
  {
    AppMethodBeat.i(210441);
    ae.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    g.yxI.n(1304L, 3L, 1L);
    AppMethodBeat.o(210441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.k
 * JD-Core Version:    0.7.0.1
 */