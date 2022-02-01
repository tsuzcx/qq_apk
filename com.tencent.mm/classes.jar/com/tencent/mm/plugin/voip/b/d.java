package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class d
{
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long oJZ = 1303L;
  public static final d ztm;
  
  static
  {
    AppMethodBeat.i(192313);
    ztm = new d();
    TAG = "MicroMsg.VoipPrevReportHelper";
    oJZ = 1303L;
    AppMethodBeat.o(192313);
  }
  
  public static void dWt()
  {
    AppMethodBeat.i(192294);
    ad.i(TAG, "markVoipRendererUsePrev");
    h.vKh.m(oJZ, 0L, 1L);
    AppMethodBeat.o(192294);
  }
  
  public static void uA(long paramLong)
  {
    AppMethodBeat.i(192304);
    ad.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(192304);
  }
  
  public static void uB(long paramLong)
  {
    AppMethodBeat.i(192305);
    ad.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(192305);
  }
  
  public static void uC(long paramLong)
  {
    AppMethodBeat.i(192306);
    ad.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(192306);
  }
  
  public static void uD(long paramLong)
  {
    AppMethodBeat.i(192307);
    ad.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(192307);
  }
  
  public static void uE(long paramLong)
  {
    AppMethodBeat.i(192308);
    ad.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(192308);
  }
  
  public static void uF(long paramLong)
  {
    AppMethodBeat.i(192309);
    ad.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(192309);
  }
  
  public static void uG(long paramLong)
  {
    AppMethodBeat.i(192310);
    ad.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(192310);
  }
  
  public static void uH(long paramLong)
  {
    AppMethodBeat.i(192311);
    ad.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(192311);
  }
  
  public static void uI(long paramLong)
  {
    AppMethodBeat.i(192312);
    ad.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(192312);
  }
  
  public static void ur(long paramLong)
  {
    AppMethodBeat.i(192295);
    ad.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(192295);
  }
  
  public static void us(long paramLong)
  {
    AppMethodBeat.i(192296);
    ad.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(192296);
  }
  
  public static void ut(long paramLong)
  {
    AppMethodBeat.i(192297);
    ad.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 3, 21, (int)paramLong, false);
    AppMethodBeat.o(192297);
  }
  
  public static void uu(long paramLong)
  {
    AppMethodBeat.i(192298);
    ad.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 4, 22, (int)paramLong, false);
    AppMethodBeat.o(192298);
  }
  
  public static void uv(long paramLong)
  {
    AppMethodBeat.i(192299);
    ad.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(192299);
  }
  
  public static void uw(long paramLong)
  {
    AppMethodBeat.i(192300);
    ad.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(192300);
  }
  
  public static void ux(long paramLong)
  {
    AppMethodBeat.i(192301);
    ad.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(192301);
  }
  
  public static void uy(long paramLong)
  {
    AppMethodBeat.i(192302);
    ad.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(192302);
  }
  
  public static void uz(long paramLong)
  {
    AppMethodBeat.i(192303);
    ad.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.vKh.c((int)oJZ, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(192303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.d
 * JD-Core Version:    0.7.0.1
 */