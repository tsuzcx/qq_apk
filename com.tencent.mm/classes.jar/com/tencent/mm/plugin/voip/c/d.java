package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "isUseStaticParamsCheckVoip", "markDiffServiceWithIntent", "", "markEngineIsClose", "markFakeCallingHappened", "markForbiddenCallingAfterCancel", "markForbiddenCallingNoneAfterCancel", "markForbiddenCauseEngineClose", "isAfterCancel", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markResponseActivityWhileServiceZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "isEngineClose", "reportKvStatVoipActivity", "caller", "plugin-voip_release"})
public final class d
{
  private static long NXG;
  private static long NXH;
  private static long NXI;
  public static final d NXJ;
  
  static
  {
    AppMethodBeat.i(241938);
    NXJ = new d();
    AppMethodBeat.o(241938);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    AppMethodBeat.i(241921);
    Log.i("MicroMsg.VoipActivityReport", "markVideoActivityOnCreate ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 0L, 1L);
      AppMethodBeat.o(241921);
      return;
      if (NXG != 0L)
      {
        long l = Util.ticksToNow(NXG);
        Log.i("MicroMsg.VoipActivityReport", "markOnCreateFromVoipService cost ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.IzE.c(1433, 6, 7, (int)l, false);
        if (paramBoolean1) {
          a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
        }
        NXG = 0L;
        continue;
        if (NXH != 0L)
        {
          l = Util.ticksToNow(NXH);
          Log.i("MicroMsg.VoipActivityReport", "markOnCreateNormal cost ".concat(String.valueOf(l)));
          com.tencent.mm.plugin.report.service.h.IzE.c(1433, 9, 10, (int)l, false);
          if (paramBoolean1) {
            a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
          }
          NXH = 0L;
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 15L, 1L);
          if (paramBoolean1)
          {
            a(paramLong1, paramInt, -1L, paramLong2, paramBoolean2);
            continue;
            if (NXI != 0L)
            {
              l = Util.ticksToNow(NXI);
              Log.i("MicroMsg.VoipActivityReport", "markOnCreateForeground cost ".concat(String.valueOf(l)));
              com.tencent.mm.plugin.report.service.h.IzE.c(1433, 12, 13, (int)l, false);
              if (paramBoolean1) {
                a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
              }
              NXI = 0L;
            }
          }
        }
      }
    }
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(241920);
    com.tencent.mm.plugin.report.service.h localh;
    if (paramLong3 == 0L) {
      switch (paramInt)
      {
      default: 
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      localh.a(20486, true, true, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i) });
      AppMethodBeat.o(241920);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 16L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 17L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 18L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 19L, 1L);
      break;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 20L, 1L);
        break;
      case 1: 
        com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 21L, 1L);
        break;
      case 2: 
        com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 22L, 1L);
        break;
      case 3: 
        com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 23L, 1L);
        break;
      }
    }
  }
  
  public static final boolean gCo()
  {
    AppMethodBeat.i(241918);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(241918);
      return true;
    }
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vDK, false);
    AppMethodBeat.o(241918);
    return bool;
  }
  
  public static final boolean gCp()
  {
    AppMethodBeat.i(241919);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(241919);
      return true;
    }
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vDL, false);
    AppMethodBeat.o(241919);
    return bool;
  }
  
  public static void gCq()
  {
    AppMethodBeat.i(241922);
    Log.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 1L, 1L);
    AppMethodBeat.o(241922);
  }
  
  public static void gCr()
  {
    AppMethodBeat.i(241923);
    Log.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 2L, 1L);
    AppMethodBeat.o(241923);
  }
  
  public static void gCs()
  {
    AppMethodBeat.i(241925);
    NXG = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 3L, 1L);
    AppMethodBeat.o(241925);
  }
  
  public static void gCt()
  {
    AppMethodBeat.i(241926);
    NXH = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 4L, 1L);
    AppMethodBeat.o(241926);
  }
  
  public static void gCu()
  {
    AppMethodBeat.i(241927);
    NXI = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 5L, 1L);
    AppMethodBeat.o(241927);
  }
  
  public static final void gCv()
  {
    AppMethodBeat.i(241929);
    Log.i("MicroMsg.VoipActivityReport", "markEngineIsClose");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 25L, 1L);
    AppMethodBeat.o(241929);
  }
  
  public static void gCw()
  {
    AppMethodBeat.i(241930);
    Log.i("MicroMsg.VoipActivityReport", "markDiffServiceWithIntent");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 26L, 1L);
    AppMethodBeat.o(241930);
  }
  
  public static void gCx()
  {
    AppMethodBeat.i(241931);
    Log.i("MicroMsg.VoipActivityReport", "markResponseActivityWhileServiceZero");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 27L, 1L);
    AppMethodBeat.o(241931);
  }
  
  public static void gCy()
  {
    AppMethodBeat.i(241933);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingAfterCancel");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 28L, 1L);
    AppMethodBeat.o(241933);
  }
  
  public static void gCz()
  {
    AppMethodBeat.i(241935);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingNoneAfterCancel");
    com.tencent.mm.plugin.report.service.h.IzE.p(1433L, 29L, 1L);
    AppMethodBeat.o(241935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.d
 * JD-Core Version:    0.7.0.1
 */