package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRemovePreviewCallback", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class j
{
  public static final j NYe;
  
  static
  {
    AppMethodBeat.i(236484);
    NYe = new j();
    AppMethodBeat.o(236484);
  }
  
  public static void SK(long paramLong)
  {
    AppMethodBeat.i(236435);
    Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(236435);
  }
  
  public static void SL(long paramLong)
  {
    AppMethodBeat.i(236437);
    Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(236437);
  }
  
  public static void SO(long paramLong)
  {
    AppMethodBeat.i(236453);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(236453);
  }
  
  public static void SP(long paramLong)
  {
    AppMethodBeat.i(236454);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(236454);
  }
  
  public static void SQ(long paramLong)
  {
    AppMethodBeat.i(236455);
    Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(236455);
  }
  
  public static void SR(long paramLong)
  {
    AppMethodBeat.i(236456);
    Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(236456);
  }
  
  public static void SS(long paramLong)
  {
    AppMethodBeat.i(236457);
    Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(236457);
  }
  
  public static void ST(long paramLong)
  {
    AppMethodBeat.i(236458);
    Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(236458);
  }
  
  public static void SY(long paramLong)
  {
    AppMethodBeat.i(236463);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(236463);
  }
  
  public static void SZ(long paramLong)
  {
    AppMethodBeat.i(236464);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(236464);
  }
  
  public static void Ta(long paramLong)
  {
    AppMethodBeat.i(236465);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(236465);
  }
  
  public static void Tb(long paramLong)
  {
    AppMethodBeat.i(236467);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(236467);
  }
  
  public static void Tc(long paramLong)
  {
    AppMethodBeat.i(236425);
    h.IzE.p(1304L, 5L, paramLong);
    AppMethodBeat.o(236425);
  }
  
  public static void Td(long paramLong)
  {
    AppMethodBeat.i(236426);
    h.IzE.p(1304L, 6L, paramLong);
    AppMethodBeat.o(236426);
  }
  
  public static void Te(long paramLong)
  {
    AppMethodBeat.i(236439);
    Log.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(236439);
  }
  
  public static void Tf(long paramLong)
  {
    AppMethodBeat.i(236440);
    Log.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(236440);
  }
  
  public static void Tg(long paramLong)
  {
    AppMethodBeat.i(236459);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(236459);
  }
  
  public static void Th(long paramLong)
  {
    AppMethodBeat.i(236460);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(236460);
  }
  
  public static void Ti(long paramLong)
  {
    AppMethodBeat.i(236461);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(236461);
  }
  
  public static void Tj(long paramLong)
  {
    AppMethodBeat.i(236462);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(236462);
  }
  
  public static void Tk(long paramLong)
  {
    AppMethodBeat.i(236469);
    g localg = g.NXO;
    if (!g.gCH())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 78, 79, (int)paramLong, false);
      AppMethodBeat.o(236469);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 81, 82, (int)paramLong, false);
    AppMethodBeat.o(236469);
  }
  
  public static void Tl(long paramLong)
  {
    AppMethodBeat.i(236472);
    g localg = g.NXO;
    if (g.gCI())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 111, 112, (int)paramLong, false);
      AppMethodBeat.o(236472);
      return;
    }
    localg = g.NXO;
    if (!g.gCH())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 84, 85, (int)paramLong, false);
      AppMethodBeat.o(236472);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 87, 88, (int)paramLong, false);
    AppMethodBeat.o(236472);
  }
  
  public static void Tm(long paramLong)
  {
    AppMethodBeat.i(236474);
    g localg = g.NXO;
    if (g.gCI())
    {
      Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 108, 109, (int)paramLong, false);
      AppMethodBeat.o(236474);
      return;
    }
    localg = g.NXO;
    if (!g.gCH())
    {
      Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 90, 91, (int)paramLong, false);
      AppMethodBeat.o(236474);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 93, 94, (int)paramLong, false);
    AppMethodBeat.o(236474);
  }
  
  public static void Tn(long paramLong)
  {
    AppMethodBeat.i(236476);
    g localg = g.NXO;
    if (!g.gCH())
    {
      Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 96, 97, (int)paramLong, false);
      AppMethodBeat.o(236476);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 99, 100, (int)paramLong, false);
    AppMethodBeat.o(236476);
  }
  
  public static void To(long paramLong)
  {
    AppMethodBeat.i(236480);
    g localg = g.NXO;
    if (!g.gCH())
    {
      Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.IzE.c(1304, 102, 103, (int)paramLong, false);
      AppMethodBeat.o(236480);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.IzE.c(1304, 105, 106, (int)paramLong, false);
    AppMethodBeat.o(236480);
  }
  
  public static void gCR()
  {
    AppMethodBeat.i(236420);
    Log.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    h.IzE.p(1304L, 1L, 1L);
    AppMethodBeat.o(236420);
  }
  
  public static void gCS()
  {
    AppMethodBeat.i(236421);
    Log.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    h.IzE.p(1304L, 2L, 1L);
    AppMethodBeat.o(236421);
  }
  
  public static void gCT()
  {
    AppMethodBeat.i(236423);
    Log.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    h.IzE.p(1304L, 3L, 1L);
    AppMethodBeat.o(236423);
  }
  
  public static void gCU()
  {
    AppMethodBeat.i(236424);
    Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    h.IzE.p(1304L, 4L, 1L);
    AppMethodBeat.o(236424);
  }
  
  public static void gCV()
  {
    AppMethodBeat.i(236428);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    h.IzE.p(1304L, 7L, 1L);
    AppMethodBeat.o(236428);
  }
  
  public static void gCW()
  {
    AppMethodBeat.i(236430);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    h.IzE.p(1304L, 8L, 1L);
    AppMethodBeat.o(236430);
  }
  
  public static void gCX()
  {
    AppMethodBeat.i(236432);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    h.IzE.p(1304L, 9L, 1L);
    AppMethodBeat.o(236432);
  }
  
  public static void gCY()
  {
    AppMethodBeat.i(236434);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    h.IzE.p(1304L, 10L, 1L);
    AppMethodBeat.o(236434);
  }
  
  public static void gCZ()
  {
    AppMethodBeat.i(236442);
    Log.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    h.IzE.p(1304L, 15L, 1L);
    AppMethodBeat.o(236442);
  }
  
  public static void gDa()
  {
    AppMethodBeat.i(236444);
    Log.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    h.IzE.p(1304L, 16L, 1L);
    AppMethodBeat.o(236444);
  }
  
  public static void gDb()
  {
    AppMethodBeat.i(236446);
    Log.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    h.IzE.p(1304L, 17L, 1L);
    AppMethodBeat.o(236446);
  }
  
  public static void gDc()
  {
    AppMethodBeat.i(236448);
    Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    h.IzE.p(1304L, 18L, 1L);
    AppMethodBeat.o(236448);
  }
  
  public static void gDd()
  {
    AppMethodBeat.i(236449);
    Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
    h.IzE.p(1304L, 19L, 1L);
    AppMethodBeat.o(236449);
  }
  
  public static final void gDe()
  {
    AppMethodBeat.i(236482);
    Log.i("MicroMsg.VoipReportHelper", "markRemovePreviewCallback");
    h.IzE.p(1304L, 114L, 1L);
    AppMethodBeat.o(236482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.j
 * JD-Core Version:    0.7.0.1
 */