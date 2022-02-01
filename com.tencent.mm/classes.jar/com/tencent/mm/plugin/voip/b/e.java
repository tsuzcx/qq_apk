package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class e
{
  public static final e AMd;
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long pnx = 1303L;
  
  static
  {
    AppMethodBeat.i(208661);
    AMd = new e();
    TAG = "MicroMsg.VoipPrevReportHelper";
    pnx = 1303L;
    AppMethodBeat.o(208661);
  }
  
  public static void elL()
  {
    AppMethodBeat.i(208642);
    ac.i(TAG, "markVoipRendererUsePrev");
    h.wUl.n(pnx, 0L, 1L);
    AppMethodBeat.o(208642);
  }
  
  public static void yU(long paramLong)
  {
    AppMethodBeat.i(208643);
    ac.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(208643);
  }
  
  public static void yV(long paramLong)
  {
    AppMethodBeat.i(208644);
    ac.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(208644);
  }
  
  public static void yW(long paramLong)
  {
    AppMethodBeat.i(208645);
    ac.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 3, 21, (int)paramLong, false);
    AppMethodBeat.o(208645);
  }
  
  public static void yX(long paramLong)
  {
    AppMethodBeat.i(208646);
    ac.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 4, 22, (int)paramLong, false);
    AppMethodBeat.o(208646);
  }
  
  public static void yY(long paramLong)
  {
    AppMethodBeat.i(208647);
    ac.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(208647);
  }
  
  public static void yZ(long paramLong)
  {
    AppMethodBeat.i(208648);
    ac.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(208648);
  }
  
  public static void za(long paramLong)
  {
    AppMethodBeat.i(208649);
    ac.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(208649);
  }
  
  public static void zb(long paramLong)
  {
    AppMethodBeat.i(208650);
    ac.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(208650);
  }
  
  public static void zc(long paramLong)
  {
    AppMethodBeat.i(208651);
    ac.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(208651);
  }
  
  public static void zd(long paramLong)
  {
    AppMethodBeat.i(208652);
    ac.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(208652);
  }
  
  public static void ze(long paramLong)
  {
    AppMethodBeat.i(208653);
    ac.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(208653);
  }
  
  public static void zf(long paramLong)
  {
    AppMethodBeat.i(208654);
    ac.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(208654);
  }
  
  public static void zg(long paramLong)
  {
    AppMethodBeat.i(208655);
    ac.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(208655);
  }
  
  public static void zh(long paramLong)
  {
    AppMethodBeat.i(208656);
    ac.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(208656);
  }
  
  public static void zi(long paramLong)
  {
    AppMethodBeat.i(208657);
    ac.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(208657);
  }
  
  public static void zj(long paramLong)
  {
    AppMethodBeat.i(208658);
    ac.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(208658);
  }
  
  public static void zk(long paramLong)
  {
    AppMethodBeat.i(208659);
    ac.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(208659);
  }
  
  public static void zl(long paramLong)
  {
    AppMethodBeat.i(208660);
    ac.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.wUl.c((int)pnx, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(208660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.e
 * JD-Core Version:    0.7.0.1
 */