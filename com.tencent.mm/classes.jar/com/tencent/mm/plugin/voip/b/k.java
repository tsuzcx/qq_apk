package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraOnError", "markCameraPboSizeHeight", "height", "markCameraPboSizeWidth", "width", "markCameraRendererPerFrameNewFullScreenCost", "cost", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty", "markCameraRendererPerFrameNewMiniWindowCost", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markFaceBeautySendDataIlleagel", "markFaceBeautySendDataNull", "markFullScreenPercent", "percent", "markHWEncodeAvgCost", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markInitCameraRendererSucc", "markInitServiceRendererSucc", "markMMFaceBeautyAlgoUse", "markMiniWindowsPercent", "markNoFaceBeautyAlgoUse", "markRenderAvgCost", "markRenderModeChangeAuto", "markRenderModeChangeManual", "markRendererUseSurfaceView", "markRendererUseTextureView", "markSoftEncodeAvgCost", "markSoftRgb2YuvAvgCost", "markTexture2BytearrayAvgCost", "markVoipRendererUseNew", "markYTFaceBeautyAlgoUse", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class k
{
  public static final k ClI;
  
  static
  {
    AppMethodBeat.i(216058);
    ClI = new k();
    AppMethodBeat.o(216058);
  }
  
  public static void BB(long paramLong)
  {
    AppMethodBeat.i(216028);
    ad.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 11, 50, (int)paramLong, false);
    AppMethodBeat.o(216028);
  }
  
  public static void BC(long paramLong)
  {
    AppMethodBeat.i(216029);
    ad.i("MicroMsg.VoipReportHelper", "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 12, 51, (int)paramLong, false);
    AppMethodBeat.o(216029);
  }
  
  public static void BD(long paramLong)
  {
    AppMethodBeat.i(216037);
    ad.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 20, 38, (int)paramLong, false);
    AppMethodBeat.o(216037);
  }
  
  public static void BE(long paramLong)
  {
    AppMethodBeat.i(216038);
    ad.i("MicroMsg.VoipReportHelper", "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 21, 39, (int)paramLong, false);
    AppMethodBeat.o(216038);
  }
  
  public static void BF(long paramLong)
  {
    AppMethodBeat.i(216039);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 24, 22, (int)paramLong, false);
    AppMethodBeat.o(216039);
  }
  
  public static void BG(long paramLong)
  {
    AppMethodBeat.i(216040);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 25, 23, (int)paramLong, false);
    AppMethodBeat.o(216040);
  }
  
  public static void BH(long paramLong)
  {
    AppMethodBeat.i(216041);
    ad.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 28, 26, (int)paramLong, false);
    AppMethodBeat.o(216041);
  }
  
  public static void BI(long paramLong)
  {
    AppMethodBeat.i(216042);
    ad.i("MicroMsg.VoipReportHelper", "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 29, 27, (int)paramLong, false);
    AppMethodBeat.o(216042);
  }
  
  public static void BJ(long paramLong)
  {
    AppMethodBeat.i(216043);
    ad.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 32, 30, (int)paramLong, false);
    AppMethodBeat.o(216043);
  }
  
  public static void BK(long paramLong)
  {
    AppMethodBeat.i(216044);
    ad.i("MicroMsg.VoipReportHelper", "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 33, 31, (int)paramLong, false);
    AppMethodBeat.o(216044);
  }
  
  public static void BP(long paramLong)
  {
    AppMethodBeat.i(216049);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 42, 40, (int)paramLong, false);
    AppMethodBeat.o(216049);
  }
  
  public static void BQ(long paramLong)
  {
    AppMethodBeat.i(216050);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 43, 41, (int)paramLong, false);
    AppMethodBeat.o(216050);
  }
  
  public static void BR(long paramLong)
  {
    AppMethodBeat.i(216051);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 48, 52, (int)paramLong, false);
    AppMethodBeat.o(216051);
  }
  
  public static void BS(long paramLong)
  {
    AppMethodBeat.i(216052);
    ad.i("MicroMsg.VoipReportHelper", "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 49, 53, (int)paramLong, false);
    AppMethodBeat.o(216052);
  }
  
  public static void BT(long paramLong)
  {
    AppMethodBeat.i(216022);
    ad.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,width=".concat(String.valueOf(paramLong)));
    g.yhR.n(1304L, 5L, paramLong);
    AppMethodBeat.o(216022);
  }
  
  public static void BU(long paramLong)
  {
    AppMethodBeat.i(216023);
    ad.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc,height=".concat(String.valueOf(paramLong)));
    g.yhR.n(1304L, 6L, paramLong);
    AppMethodBeat.o(216023);
  }
  
  public static void BV(long paramLong)
  {
    AppMethodBeat.i(216030);
    ad.i("MicroMsg.VoipReportHelper", "markFullScreenPercent,percent=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 13, 70, (int)paramLong, false);
    AppMethodBeat.o(216030);
  }
  
  public static void BW(long paramLong)
  {
    AppMethodBeat.i(216031);
    ad.i("MicroMsg.VoipReportHelper", "markMiniWindowsPercent,percent=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 14, 71, (int)paramLong, false);
    AppMethodBeat.o(216031);
  }
  
  public static void BX(long paramLong)
  {
    AppMethodBeat.i(216045);
    ad.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(216045);
  }
  
  public static void BY(long paramLong)
  {
    AppMethodBeat.i(216046);
    ad.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 37, 35, (int)paramLong, false);
    AppMethodBeat.o(216046);
  }
  
  public static void BZ(long paramLong)
  {
    AppMethodBeat.i(216047);
    ad.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 72, 74, (int)paramLong, false);
    AppMethodBeat.o(216047);
  }
  
  public static void Ca(long paramLong)
  {
    AppMethodBeat.i(216048);
    ad.i("MicroMsg.VoipReportHelper", "markCameraRendererPerFrameNewMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 73, 75, (int)paramLong, false);
    AppMethodBeat.o(216048);
  }
  
  public static void Cb(long paramLong)
  {
    AppMethodBeat.i(216053);
    h localh = h.Cls;
    if (!h.ezG())
    {
      ad.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 78, 79, (int)paramLong, false);
      AppMethodBeat.o(216053);
      return;
    }
    ad.i("MicroMsg.VoipReportHelper", "markSoftRgb2YuvAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 81, 82, (int)paramLong, false);
    AppMethodBeat.o(216053);
  }
  
  public static void Cc(long paramLong)
  {
    AppMethodBeat.i(216054);
    h localh = h.Cls;
    if (h.ezH())
    {
      ad.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 111, 112, (int)paramLong, false);
      AppMethodBeat.o(216054);
      return;
    }
    localh = h.Cls;
    if (!h.ezG())
    {
      ad.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 84, 85, (int)paramLong, false);
      AppMethodBeat.o(216054);
      return;
    }
    ad.i("MicroMsg.VoipReportHelper", "markSoftEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 87, 88, (int)paramLong, false);
    AppMethodBeat.o(216054);
  }
  
  public static void Cd(long paramLong)
  {
    AppMethodBeat.i(216055);
    h localh = h.Cls;
    if (h.ezH())
    {
      ad.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu crop trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 108, 109, (int)paramLong, false);
      AppMethodBeat.o(216055);
      return;
    }
    localh = h.Cls;
    if (!h.ezG())
    {
      ad.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 90, 91, (int)paramLong, false);
      AppMethodBeat.o(216055);
      return;
    }
    ad.i("MicroMsg.VoipReportHelper", "markHWEncodeAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 93, 94, (int)paramLong, false);
    AppMethodBeat.o(216055);
  }
  
  public static void Ce(long paramLong)
  {
    AppMethodBeat.i(216056);
    h localh = h.Cls;
    if (!h.ezG())
    {
      ad.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 96, 97, (int)paramLong, false);
      AppMethodBeat.o(216056);
      return;
    }
    ad.i("MicroMsg.VoipReportHelper", "markRenderAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 99, 100, (int)paramLong, false);
    AppMethodBeat.o(216056);
  }
  
  public static void Cf(long paramLong)
  {
    AppMethodBeat.i(216057);
    h localh = h.Cls;
    if (!h.ezG())
    {
      ad.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, cpu trans cost=".concat(String.valueOf(paramLong)));
      g.yhR.c(1304, 102, 103, (int)paramLong, false);
      AppMethodBeat.o(216057);
      return;
    }
    ad.i("MicroMsg.VoipReportHelper", "markTexture2BytearrayAvgCost, gpu trans cost=".concat(String.valueOf(paramLong)));
    g.yhR.c(1304, 105, 106, (int)paramLong, false);
    AppMethodBeat.o(216057);
  }
  
  public static void eAa()
  {
    AppMethodBeat.i(216035);
    ad.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataNull");
    g.yhR.n(1304L, 18L, 1L);
    AppMethodBeat.o(216035);
  }
  
  public static void eAb()
  {
    AppMethodBeat.i(216036);
    ad.i("MicroMsg.VoipReportHelper", "markFaceBeautySendDataIlleagel");
    g.yhR.n(1304L, 19L, 1L);
    AppMethodBeat.o(216036);
  }
  
  public static void ezP()
  {
    AppMethodBeat.i(216018);
    ad.i("MicroMsg.VoipReportHelper", "markVoipRendererUseNew");
    g.yhR.n(1304L, 1L, 1L);
    AppMethodBeat.o(216018);
  }
  
  public static void ezQ()
  {
    AppMethodBeat.i(216019);
    ad.i("MicroMsg.VoipReportHelper", "markCameraOnError");
    g.yhR.n(1304L, 2L, 1L);
    AppMethodBeat.o(216019);
  }
  
  public static void ezR()
  {
    AppMethodBeat.i(216020);
    ad.i("MicroMsg.VoipReportHelper", "markInitCameraRendererSucc");
    g.yhR.n(1304L, 3L, 1L);
    AppMethodBeat.o(216020);
  }
  
  public static void ezS()
  {
    AppMethodBeat.i(216021);
    ad.i("MicroMsg.VoipReportHelper", "markInitServiceRendererSucc");
    g.yhR.n(1304L, 4L, 1L);
    AppMethodBeat.o(216021);
  }
  
  public static void ezT()
  {
    AppMethodBeat.i(216024);
    ad.i("MicroMsg.VoipReportHelper", "markRendererUseSurfaceView");
    g.yhR.n(1304L, 7L, 1L);
    AppMethodBeat.o(216024);
  }
  
  public static void ezU()
  {
    AppMethodBeat.i(216025);
    ad.i("MicroMsg.VoipReportHelper", "markRendererUseTextureView");
    g.yhR.n(1304L, 8L, 1L);
    AppMethodBeat.o(216025);
  }
  
  public static void ezV()
  {
    AppMethodBeat.i(216026);
    ad.i("MicroMsg.VoipReportHelper", "markRenderModeChangeAuto");
    g.yhR.n(1304L, 9L, 1L);
    AppMethodBeat.o(216026);
  }
  
  public static void ezW()
  {
    AppMethodBeat.i(216027);
    ad.i("MicroMsg.VoipReportHelper", "markRenderModeChangeManual");
    g.yhR.n(1304L, 10L, 1L);
    AppMethodBeat.o(216027);
  }
  
  public static void ezX()
  {
    AppMethodBeat.i(216032);
    ad.i("MicroMsg.VoipReportHelper", "markNoFaceBeautyAlgoUse");
    g.yhR.n(1304L, 15L, 1L);
    AppMethodBeat.o(216032);
  }
  
  public static void ezY()
  {
    AppMethodBeat.i(216033);
    ad.i("MicroMsg.VoipReportHelper", "markYTFaceBeautyAlgoUse");
    g.yhR.n(1304L, 16L, 1L);
    AppMethodBeat.o(216033);
  }
  
  public static void ezZ()
  {
    AppMethodBeat.i(216034);
    ad.i("MicroMsg.VoipReportHelper", "markMMFaceBeautyAlgoUse");
    g.yhR.n(1304L, 17L, 1L);
    AppMethodBeat.o(216034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.k
 * JD-Core Version:    0.7.0.1
 */