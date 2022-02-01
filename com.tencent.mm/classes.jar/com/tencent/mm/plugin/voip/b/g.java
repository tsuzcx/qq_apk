package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class g
{
  public static final g Clr;
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long pQX = 1303L;
  
  static
  {
    AppMethodBeat.i(215990);
    Clr = new g();
    TAG = "MicroMsg.VoipPrevReportHelper";
    pQX = 1303L;
    AppMethodBeat.o(215990);
  }
  
  public static void BB(long paramLong)
  {
    AppMethodBeat.i(215972);
    ad.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(215972);
  }
  
  public static void BC(long paramLong)
  {
    AppMethodBeat.i(215973);
    ad.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(215973);
  }
  
  public static void BD(long paramLong)
  {
    AppMethodBeat.i(215974);
    ad.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 3, 21, (int)paramLong, false);
    AppMethodBeat.o(215974);
  }
  
  public static void BE(long paramLong)
  {
    AppMethodBeat.i(215975);
    ad.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 4, 22, (int)paramLong, false);
    AppMethodBeat.o(215975);
  }
  
  public static void BF(long paramLong)
  {
    AppMethodBeat.i(215976);
    ad.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(215976);
  }
  
  public static void BG(long paramLong)
  {
    AppMethodBeat.i(215977);
    ad.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(215977);
  }
  
  public static void BH(long paramLong)
  {
    AppMethodBeat.i(215978);
    ad.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(215978);
  }
  
  public static void BI(long paramLong)
  {
    AppMethodBeat.i(215979);
    ad.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(215979);
  }
  
  public static void BJ(long paramLong)
  {
    AppMethodBeat.i(215980);
    ad.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(215980);
  }
  
  public static void BK(long paramLong)
  {
    AppMethodBeat.i(215981);
    ad.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(215981);
  }
  
  public static void BL(long paramLong)
  {
    AppMethodBeat.i(215982);
    ad.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(215982);
  }
  
  public static void BM(long paramLong)
  {
    AppMethodBeat.i(215983);
    ad.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(215983);
  }
  
  public static void BN(long paramLong)
  {
    AppMethodBeat.i(215984);
    ad.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(215984);
  }
  
  public static void BO(long paramLong)
  {
    AppMethodBeat.i(215985);
    ad.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(215985);
  }
  
  public static void BP(long paramLong)
  {
    AppMethodBeat.i(215986);
    ad.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(215986);
  }
  
  public static void BQ(long paramLong)
  {
    AppMethodBeat.i(215987);
    ad.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(215987);
  }
  
  public static void BR(long paramLong)
  {
    AppMethodBeat.i(215988);
    ad.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(215988);
  }
  
  public static void BS(long paramLong)
  {
    AppMethodBeat.i(215989);
    ad.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yhR.c((int)pQX, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(215989);
  }
  
  public static void ezE()
  {
    AppMethodBeat.i(215971);
    ad.i(TAG, "markVoipRendererUsePrev");
    com.tencent.mm.plugin.report.service.g.yhR.n(pQX, 0L, 1L);
    AppMethodBeat.o(215971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.g
 * JD-Core Version:    0.7.0.1
 */