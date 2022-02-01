package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class g
{
  public static final g CCV;
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long pXC = 1303L;
  
  static
  {
    AppMethodBeat.i(210411);
    CCV = new g();
    TAG = "MicroMsg.VoipPrevReportHelper";
    pXC = 1303L;
    AppMethodBeat.o(210411);
  }
  
  public static void BZ(long paramLong)
  {
    AppMethodBeat.i(210393);
    ae.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(210393);
  }
  
  public static void Ca(long paramLong)
  {
    AppMethodBeat.i(210394);
    ae.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(210394);
  }
  
  public static void Cb(long paramLong)
  {
    AppMethodBeat.i(210395);
    ae.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 3, 21, (int)paramLong, false);
    AppMethodBeat.o(210395);
  }
  
  public static void Cc(long paramLong)
  {
    AppMethodBeat.i(210396);
    ae.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 4, 22, (int)paramLong, false);
    AppMethodBeat.o(210396);
  }
  
  public static void Cd(long paramLong)
  {
    AppMethodBeat.i(210397);
    ae.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(210397);
  }
  
  public static void Ce(long paramLong)
  {
    AppMethodBeat.i(210398);
    ae.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(210398);
  }
  
  public static void Cf(long paramLong)
  {
    AppMethodBeat.i(210399);
    ae.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(210399);
  }
  
  public static void Cg(long paramLong)
  {
    AppMethodBeat.i(210400);
    ae.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(210400);
  }
  
  public static void Ch(long paramLong)
  {
    AppMethodBeat.i(210401);
    ae.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(210401);
  }
  
  public static void Ci(long paramLong)
  {
    AppMethodBeat.i(210402);
    ae.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(210402);
  }
  
  public static void Cj(long paramLong)
  {
    AppMethodBeat.i(210403);
    ae.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(210403);
  }
  
  public static void Ck(long paramLong)
  {
    AppMethodBeat.i(210404);
    ae.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(210404);
  }
  
  public static void Cl(long paramLong)
  {
    AppMethodBeat.i(210405);
    ae.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(210405);
  }
  
  public static void Cm(long paramLong)
  {
    AppMethodBeat.i(210406);
    ae.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(210406);
  }
  
  public static void Cn(long paramLong)
  {
    AppMethodBeat.i(210407);
    ae.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(210407);
  }
  
  public static void Co(long paramLong)
  {
    AppMethodBeat.i(210408);
    ae.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(210408);
  }
  
  public static void Cp(long paramLong)
  {
    AppMethodBeat.i(210409);
    ae.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(210409);
  }
  
  public static void Cq(long paramLong)
  {
    AppMethodBeat.i(210410);
    ae.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.g.yxI.c((int)pXC, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(210410);
  }
  
  public static void eDm()
  {
    AppMethodBeat.i(210392);
    ae.i(TAG, "markVoipRendererUsePrev");
    com.tencent.mm.plugin.report.service.g.yxI.n(pXC, 0L, 1L);
    AppMethodBeat.o(210392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.g
 * JD-Core Version:    0.7.0.1
 */