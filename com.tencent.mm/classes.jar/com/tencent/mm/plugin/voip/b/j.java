package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRemovePreviewCallback", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class j
{
  public static final j Hhp;
  
  static
  {
    AppMethodBeat.i(236142);
    Hhp = new j();
    AppMethodBeat.o(236142);
  }
  
  public static void LA(long paramLong)
  {
    AppMethodBeat.i(236132);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(236132);
  }
  
  public static void LB(long paramLong)
  {
    AppMethodBeat.i(236133);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(236133);
  }
  
  public static void LC(long paramLong)
  {
    AppMethodBeat.i(236134);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(236134);
  }
  
  public static void LD(long paramLong)
  {
    AppMethodBeat.i(236135);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(236135);
  }
  
  public static void LE(long paramLong)
  {
    AppMethodBeat.i(236105);
    Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,width=".concat(String.valueOf(paramLong)));
    h.CyF.n(1304L, 5L, paramLong);
    AppMethodBeat.o(236105);
  }
  
  public static void LF(long paramLong)
  {
    AppMethodBeat.i(236106);
    Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,height=".concat(String.valueOf(paramLong)));
    h.CyF.n(1304L, 6L, paramLong);
    AppMethodBeat.o(236106);
  }
  
  public static void LG(long paramLong)
  {
    AppMethodBeat.i(236113);
    Log.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(236113);
  }
  
  public static void LH(long paramLong)
  {
    AppMethodBeat.i(236114);
    Log.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(236114);
  }
  
  public static void LI(long paramLong)
  {
    AppMethodBeat.i(236128);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(236128);
  }
  
  public static void LJ(long paramLong)
  {
    AppMethodBeat.i(236129);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(236129);
  }
  
  public static void LK(long paramLong)
  {
    AppMethodBeat.i(236130);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(236130);
  }
  
  public static void LL(long paramLong)
  {
    AppMethodBeat.i(236131);
    Log.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(236131);
  }
  
  public static void LM(long paramLong)
  {
    AppMethodBeat.i(236136);
    g localg = g.HgZ;
    if (!g.fKi())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 78, 79, (int)paramLong, false);
      AppMethodBeat.o(236136);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 81, 82, (int)paramLong, false);
    AppMethodBeat.o(236136);
  }
  
  public static void LN(long paramLong)
  {
    AppMethodBeat.i(236137);
    g localg = g.HgZ;
    if (g.fKj())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 111, 112, (int)paramLong, false);
      AppMethodBeat.o(236137);
      return;
    }
    localg = g.HgZ;
    if (!g.fKi())
    {
      Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 84, 85, (int)paramLong, false);
      AppMethodBeat.o(236137);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 87, 88, (int)paramLong, false);
    AppMethodBeat.o(236137);
  }
  
  public static void LO(long paramLong)
  {
    AppMethodBeat.i(236138);
    g localg = g.HgZ;
    if (g.fKj())
    {
      Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 108, 109, (int)paramLong, false);
      AppMethodBeat.o(236138);
      return;
    }
    localg = g.HgZ;
    if (!g.fKi())
    {
      Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 90, 91, (int)paramLong, false);
      AppMethodBeat.o(236138);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 93, 94, (int)paramLong, false);
    AppMethodBeat.o(236138);
  }
  
  public static void LP(long paramLong)
  {
    AppMethodBeat.i(236139);
    g localg = g.HgZ;
    if (!g.fKi())
    {
      Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 96, 97, (int)paramLong, false);
      AppMethodBeat.o(236139);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 99, 100, (int)paramLong, false);
    AppMethodBeat.o(236139);
  }
  
  public static void LQ(long paramLong)
  {
    AppMethodBeat.i(236140);
    g localg = g.HgZ;
    if (!g.fKi())
    {
      Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      h.CyF.b(1304, 102, 103, (int)paramLong, false);
      AppMethodBeat.o(236140);
      return;
    }
    Log.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 105, 106, (int)paramLong, false);
    AppMethodBeat.o(236140);
  }
  
  public static void Lm(long paramLong)
  {
    AppMethodBeat.i(236111);
    Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(236111);
  }
  
  public static void Ln(long paramLong)
  {
    AppMethodBeat.i(236112);
    Log.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(236112);
  }
  
  public static void Lo(long paramLong)
  {
    AppMethodBeat.i(236120);
    Log.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 20, 38, (int)paramLong, false);
    AppMethodBeat.o(236120);
  }
  
  public static void Lp(long paramLong)
  {
    AppMethodBeat.i(236121);
    Log.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 21, 39, (int)paramLong, false);
    AppMethodBeat.o(236121);
  }
  
  public static void Lq(long paramLong)
  {
    AppMethodBeat.i(236122);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(236122);
  }
  
  public static void Lr(long paramLong)
  {
    AppMethodBeat.i(236123);
    Log.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(236123);
  }
  
  public static void Ls(long paramLong)
  {
    AppMethodBeat.i(236124);
    Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(236124);
  }
  
  public static void Lt(long paramLong)
  {
    AppMethodBeat.i(236125);
    Log.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(236125);
  }
  
  public static void Lu(long paramLong)
  {
    AppMethodBeat.i(236126);
    Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(236126);
  }
  
  public static void Lv(long paramLong)
  {
    AppMethodBeat.i(236127);
    Log.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(236127);
  }
  
  public static void fKA()
  {
    AppMethodBeat.i(236116);
    Log.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    h.CyF.n(1304L, 16L, 1L);
    AppMethodBeat.o(236116);
  }
  
  public static void fKB()
  {
    AppMethodBeat.i(236117);
    Log.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    h.CyF.n(1304L, 17L, 1L);
    AppMethodBeat.o(236117);
  }
  
  public static void fKC()
  {
    AppMethodBeat.i(236118);
    Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    h.CyF.n(1304L, 18L, 1L);
    AppMethodBeat.o(236118);
  }
  
  public static void fKD()
  {
    AppMethodBeat.i(236119);
    Log.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
    h.CyF.n(1304L, 19L, 1L);
    AppMethodBeat.o(236119);
  }
  
  public static final void fKE()
  {
    AppMethodBeat.i(236141);
    Log.i("MicroMsg.VoipReportHelper", "markRemovePreviewCallback");
    h.CyF.n(1304L, 114L, 1L);
    AppMethodBeat.o(236141);
  }
  
  public static void fKr()
  {
    AppMethodBeat.i(236101);
    Log.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    h.CyF.n(1304L, 1L, 1L);
    AppMethodBeat.o(236101);
  }
  
  public static void fKs()
  {
    AppMethodBeat.i(236102);
    Log.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    h.CyF.n(1304L, 2L, 1L);
    AppMethodBeat.o(236102);
  }
  
  public static void fKt()
  {
    AppMethodBeat.i(236103);
    Log.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    h.CyF.n(1304L, 3L, 1L);
    AppMethodBeat.o(236103);
  }
  
  public static void fKu()
  {
    AppMethodBeat.i(236104);
    Log.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    h.CyF.n(1304L, 4L, 1L);
    AppMethodBeat.o(236104);
  }
  
  public static void fKv()
  {
    AppMethodBeat.i(236107);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    h.CyF.n(1304L, 7L, 1L);
    AppMethodBeat.o(236107);
  }
  
  public static void fKw()
  {
    AppMethodBeat.i(236108);
    Log.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    h.CyF.n(1304L, 8L, 1L);
    AppMethodBeat.o(236108);
  }
  
  public static void fKx()
  {
    AppMethodBeat.i(236109);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    h.CyF.n(1304L, 9L, 1L);
    AppMethodBeat.o(236109);
  }
  
  public static void fKy()
  {
    AppMethodBeat.i(236110);
    Log.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    h.CyF.n(1304L, 10L, 1L);
    AppMethodBeat.o(236110);
  }
  
  public static void fKz()
  {
    AppMethodBeat.i(236115);
    Log.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    h.CyF.n(1304L, 15L, 1L);
    AppMethodBeat.o(236115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.j
 * JD-Core Version:    0.7.0.1
 */