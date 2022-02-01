package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class f
{
  public static final f NXN;
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long rJY = 1303L;
  
  static
  {
    AppMethodBeat.i(237239);
    NXN = new f();
    TAG = "MicroMsg.VoipPrevReportHelper";
    rJY = 1303L;
    AppMethodBeat.o(237239);
  }
  
  public static void SK(long paramLong)
  {
    AppMethodBeat.i(237204);
    Log.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(237204);
  }
  
  public static void SL(long paramLong)
  {
    AppMethodBeat.i(237206);
    Log.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(237206);
  }
  
  public static void SO(long paramLong)
  {
    AppMethodBeat.i(237212);
    Log.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(237212);
  }
  
  public static void SP(long paramLong)
  {
    AppMethodBeat.i(237214);
    Log.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(237214);
  }
  
  public static void SQ(long paramLong)
  {
    AppMethodBeat.i(237216);
    Log.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(237216);
  }
  
  public static void SR(long paramLong)
  {
    AppMethodBeat.i(237218);
    Log.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(237218);
  }
  
  public static void SS(long paramLong)
  {
    AppMethodBeat.i(237220);
    Log.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(237220);
  }
  
  public static void ST(long paramLong)
  {
    AppMethodBeat.i(237222);
    Log.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(237222);
  }
  
  public static void SU(long paramLong)
  {
    AppMethodBeat.i(237224);
    Log.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(237224);
  }
  
  public static void SV(long paramLong)
  {
    AppMethodBeat.i(237225);
    Log.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(237225);
  }
  
  public static void SW(long paramLong)
  {
    AppMethodBeat.i(237227);
    Log.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(237227);
  }
  
  public static void SX(long paramLong)
  {
    AppMethodBeat.i(237229);
    Log.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(237229);
  }
  
  public static void SY(long paramLong)
  {
    AppMethodBeat.i(237232);
    Log.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(237232);
  }
  
  public static void SZ(long paramLong)
  {
    AppMethodBeat.i(237234);
    Log.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(237234);
  }
  
  public static void Ta(long paramLong)
  {
    AppMethodBeat.i(237237);
    Log.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(237237);
  }
  
  public static void Tb(long paramLong)
  {
    AppMethodBeat.i(237238);
    Log.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.IzE.c((int)rJY, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(237238);
  }
  
  public static void gCC()
  {
    AppMethodBeat.i(237202);
    Log.i(TAG, "markVoipRendererUsePrev");
    h.IzE.p(rJY, 0L, 1L);
    AppMethodBeat.o(237202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.f
 * JD-Core Version:    0.7.0.1
 */