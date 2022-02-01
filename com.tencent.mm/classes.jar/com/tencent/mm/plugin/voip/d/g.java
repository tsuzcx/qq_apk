package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipRenderReport;", "", "()V", "TAG", "", "currentRenderSoft", "", "getCurrentRenderSoft", "()Z", "setCurrentRenderSoft", "(Z)V", "isTimerInit", "setTimerInit", "lastLogTime", "", "localRenderFps", "", "getLocalRenderFps", "()I", "setLocalRenderFps", "(I)V", "localRenderTick", "getLocalRenderTick", "()J", "setLocalRenderTick", "(J)V", "modeChangedTick", "getModeChangedTick", "setModeChangedTick", "remoteRenderHardFps", "getRemoteRenderHardFps", "setRemoteRenderHardFps", "remoteRenderSoftFps", "getRemoteRenderSoftFps", "setRemoteRenderSoftFps", "remoteRenderTick", "getRemoteRenderTick", "setRemoteRenderTick", "renderTicker", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRenderTicker", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setRenderTicker", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "addLocalRenderPerFrameCost", "", "addRemoteRenderPerSoftFrameCost", "initTimerTicker", "release", "renderModeChanged", "soft", "reportRenderFps", "startRunLocalRender", "startRunRemoteRender", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static int UHh;
  public static int UHj;
  public static int UHl;
  public static final g UHs;
  private static long UHt;
  public static boolean UHu;
  private static MTimerHandler UHv;
  private static boolean UHw;
  public static long UHx;
  public static long UHy;
  private static long hvL;
  
  static
  {
    AppMethodBeat.i(292802);
    UHs = new g();
    AppMethodBeat.o(292802);
  }
  
  public static void Gx(boolean paramBoolean)
  {
    AppMethodBeat.i(292783);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      UHu = paramBoolean;
      UHt = Util.currentTicks();
      AppMethodBeat.o(292783);
      return;
    }
  }
  
  private static void iac()
  {
    AppMethodBeat.i(292765);
    if (UHw)
    {
      AppMethodBeat.o(292765);
      return;
    }
    UHw = true;
    hvL = Util.currentTicks();
    MTimerHandler localMTimerHandler = new MTimerHandler("renderReportTicker", g..ExternalSyntheticLambda0.INSTANCE, true);
    UHv = localMTimerHandler;
    localMTimerHandler.startTimer(0L, 1000L);
    AppMethodBeat.o(292765);
  }
  
  public static void iad()
  {
    AppMethodBeat.i(292771);
    iac();
    UHx = Util.currentTicks();
    AppMethodBeat.o(292771);
  }
  
  public static void iae()
  {
    AppMethodBeat.i(292779);
    iac();
    UHy = Util.currentTicks();
    AppMethodBeat.o(292779);
  }
  
  private static final boolean iaf()
  {
    AppMethodBeat.i(292797);
    f localf;
    int i;
    if ((UHt != 0L) && (Util.ticksToNow(UHt) >= 1000L))
    {
      if (!UHu) {
        break label159;
      }
      localf = f.UGZ;
      i = f.hZV();
      localf = f.UGZ;
      f.aqK((i + UHj) / 2);
    }
    for (;;)
    {
      localf = f.UGZ;
      i = f.hZT();
      localf = f.UGZ;
      f.aqI((i + UHh) / 2);
      if (Util.ticksToNow(hvL) >= 10000L)
      {
        Log.i("MicroMsg.VoipRenderReport", "report last fps, localRenderFps:" + UHh + ", remoteRenderSoftFps:" + UHj + ", remoteRenderHardFps:" + UHl);
        hvL = Util.currentTicks();
      }
      UHj = 0;
      UHh = 0;
      UHl = 0;
      AppMethodBeat.o(292797);
      return true;
      label159:
      localf = f.UGZ;
      i = f.hZX();
      localf = f.UGZ;
      f.aqM((i + UHl) / 2);
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(292789);
    UHw = false;
    UHh = 0;
    UHj = 0;
    UHl = 0;
    UHt = 0L;
    UHu = false;
    MTimerHandler localMTimerHandler = UHv;
    if (localMTimerHandler != null) {
      localMTimerHandler.quitSafely();
    }
    UHv = null;
    AppMethodBeat.o(292789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.g
 * JD-Core Version:    0.7.0.1
 */