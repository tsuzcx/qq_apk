package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipPrevReportHelper;", "", "()V", "ID", "", "TAG", "", "markAddViewFullScreenToRendererCost", "", "data", "markAddViewFullScreenToRendererCostFirst", "markAddViewFullScreenToRendererCostInvite", "markAddViewMiniWindowToRendererCost", "markAddViewMiniWindowToRendererCostFirst", "markAddViewMiniWindowToRendererCostInvite", "markBatteryPropertyCurrentInHW", "markBatteryPropertyCurrentInSW", "markCameraRendererPerFrameMiniWindowCostWithFaceBeauty", "cost", "markCameraRendererPerFramePrevFullScreenCost", "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty", "markCameraRendererPerFramePrevMiniWindowCost", "markDecodeModeChangeToHW", "count", "markDecodeModeChangeToSW", "markHWRendererPerFrameFullScreenCost", "markHWRendererPerFrameMiniWindowCost", "markVoipRendererUsePrev", "markYuvRendererPerFrameFullScreenCost", "markYuvRendererPerFrameMiniWindowCost", "plugin-voip_release"})
public final class f
{
  public static final f HgY;
  private static final String TAG = "MicroMsg.VoipPrevReportHelper";
  private static final long oIi = 1303L;
  
  static
  {
    AppMethodBeat.i(236069);
    HgY = new f();
    TAG = "MicroMsg.VoipPrevReportHelper";
    oIi = 1303L;
    AppMethodBeat.o(236069);
  }
  
  public static void LA(long paramLong)
  {
    AppMethodBeat.i(236065);
    Log.i(TAG, "markAddViewFullScreenToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 35, 33, (int)paramLong, false);
    AppMethodBeat.o(236065);
  }
  
  public static void LB(long paramLong)
  {
    AppMethodBeat.i(236066);
    Log.i(TAG, "markAddViewMiniWindowToRendererCostInvite, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 36, 34, (int)paramLong, false);
    AppMethodBeat.o(236066);
  }
  
  public static void LC(long paramLong)
  {
    AppMethodBeat.i(236067);
    Log.i(TAG, "markAddViewFullScreenToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 39, 43, (int)paramLong, false);
    AppMethodBeat.o(236067);
  }
  
  public static void LD(long paramLong)
  {
    AppMethodBeat.i(236068);
    Log.i(TAG, "markAddViewMiniWindowToRendererCostFirst, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 40, 44, (int)paramLong, false);
    AppMethodBeat.o(236068);
  }
  
  public static void Lm(long paramLong)
  {
    AppMethodBeat.i(236051);
    Log.i(TAG, "markDecodeModeChangeToHW,count=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 1, 41, (int)paramLong, false);
    AppMethodBeat.o(236051);
  }
  
  public static void Ln(long paramLong)
  {
    AppMethodBeat.i(236052);
    Log.i(TAG, "markDecodeModeChangeToSW,count=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 2, 42, (int)paramLong, false);
    AppMethodBeat.o(236052);
  }
  
  public static void Lo(long paramLong)
  {
    AppMethodBeat.i(236053);
    Log.i(TAG, "markBatteryPropertyCurrentInHW,data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 3, 21, (int)paramLong, false);
    AppMethodBeat.o(236053);
  }
  
  public static void Lp(long paramLong)
  {
    AppMethodBeat.i(236054);
    Log.i(TAG, "markBatteryPropertyCurrentInSW, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 4, 22, (int)paramLong, false);
    AppMethodBeat.o(236054);
  }
  
  public static void Lq(long paramLong)
  {
    AppMethodBeat.i(236055);
    Log.i(TAG, "markAddViewFullScreenToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 7, 5, (int)paramLong, false);
    AppMethodBeat.o(236055);
  }
  
  public static void Lr(long paramLong)
  {
    AppMethodBeat.i(236056);
    Log.i(TAG, "markAddViewMiniWindowToRendererCost, data=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 8, 6, (int)paramLong, false);
    AppMethodBeat.o(236056);
  }
  
  public static void Ls(long paramLong)
  {
    AppMethodBeat.i(236057);
    Log.i(TAG, "markYuvRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 11, 9, (int)paramLong, false);
    AppMethodBeat.o(236057);
  }
  
  public static void Lt(long paramLong)
  {
    AppMethodBeat.i(236058);
    Log.i(TAG, "markYuvRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 12, 10, (int)paramLong, false);
    AppMethodBeat.o(236058);
  }
  
  public static void Lu(long paramLong)
  {
    AppMethodBeat.i(236059);
    Log.i(TAG, "markHWRendererPerFrameFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 15, 13, (int)paramLong, false);
    AppMethodBeat.o(236059);
  }
  
  public static void Lv(long paramLong)
  {
    AppMethodBeat.i(236060);
    Log.i(TAG, "markHWRendererPerFrameMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 16, 14, (int)paramLong, false);
    AppMethodBeat.o(236060);
  }
  
  public static void Lw(long paramLong)
  {
    AppMethodBeat.i(236061);
    Log.i(TAG, "markCameraRendererPerFrameNewFullScreenCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 19, 17, (int)paramLong, false);
    AppMethodBeat.o(236061);
  }
  
  public static void Lx(long paramLong)
  {
    AppMethodBeat.i(236062);
    Log.i(TAG, "markCameraRendererPerFrameNewMiniWindowCost,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 20, 18, (int)paramLong, false);
    AppMethodBeat.o(236062);
  }
  
  public static void Ly(long paramLong)
  {
    AppMethodBeat.i(236063);
    Log.i(TAG, "markHWRendererPerFrameMiniWindowCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 49, 51, (int)paramLong, false);
    AppMethodBeat.o(236063);
  }
  
  public static void Lz(long paramLong)
  {
    AppMethodBeat.i(236064);
    Log.i(TAG, "markCameraRendererPerFramePrevFullScreenCostWithFaceBeauty,cost=".concat(String.valueOf(paramLong)));
    h.CyF.b((int)oIi, 50, 52, (int)paramLong, false);
    AppMethodBeat.o(236064);
  }
  
  public static void fKd()
  {
    AppMethodBeat.i(236050);
    Log.i(TAG, "markVoipRendererUsePrev");
    h.CyF.n(oIi, 0L, 1L);
    AppMethodBeat.o(236050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.f
 * JD-Core Version:    0.7.0.1
 */