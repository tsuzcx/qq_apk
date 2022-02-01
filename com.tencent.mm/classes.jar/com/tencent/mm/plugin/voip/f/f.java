package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "isUseStaticParamsCheckVoip", "markDiffServiceWithIntent", "", "markEngineIsClose", "markFakeCallingHappened", "markForbiddenCallingAfterCancel", "markForbiddenCallingNoneAfterCancel", "markForbiddenCauseEngineClose", "isAfterCancel", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markResponseActivityWhileServiceZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "isEngineClose", "reportKvStatVoipActivity", "caller", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f ULF;
  private static long ULG;
  private static long ULH;
  private static long ULI;
  
  static
  {
    AppMethodBeat.i(292780);
    ULF = new f();
    AppMethodBeat.o(292780);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    AppMethodBeat.i(292655);
    Log.i("MicroMsg.VoipActivityReport", s.X("markVideoActivityOnCreate ", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 0L, 1L);
      AppMethodBeat.o(292655);
      return;
      if (ULG != 0L)
      {
        long l = Util.ticksToNow(ULG);
        Log.i("MicroMsg.VoipActivityReport", s.X("markOnCreateFromVoipService cost ", Long.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.OAn.c(1433, 6, 7, (int)l, false);
        if (paramBoolean1) {
          a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
        }
        ULG = 0L;
        continue;
        if (ULH != 0L)
        {
          l = Util.ticksToNow(ULH);
          Log.i("MicroMsg.VoipActivityReport", s.X("markOnCreateNormal cost ", Long.valueOf(l)));
          com.tencent.mm.plugin.report.service.h.OAn.c(1433, 9, 10, (int)l, false);
          if (paramBoolean1) {
            a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
          }
          ULH = 0L;
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 15L, 1L);
          if (paramBoolean1)
          {
            a(paramLong1, paramInt, -1L, paramLong2, paramBoolean2);
            continue;
            if (ULI != 0L)
            {
              l = Util.ticksToNow(ULI);
              Log.i("MicroMsg.VoipActivityReport", s.X("markOnCreateForeground cost ", Long.valueOf(l)));
              com.tencent.mm.plugin.report.service.h.OAn.c(1433, 12, 13, (int)l, false);
              if (paramBoolean1) {
                a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
              }
              ULI = 0L;
            }
          }
        }
      }
    }
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(292630);
    com.tencent.mm.plugin.report.service.h localh;
    if (paramLong3 == 0L) {
      switch (paramInt)
      {
      default: 
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      localh.a(20486, true, true, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i) });
      AppMethodBeat.o(292630);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 16L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 17L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 18L, 1L);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 19L, 1L);
      break;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 20L, 1L);
        break;
      case 1: 
        com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 21L, 1L);
        break;
      case 2: 
        com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 22L, 1L);
        break;
      case 3: 
        com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 23L, 1L);
        break;
      }
    }
  }
  
  public static final boolean ibe()
  {
    AppMethodBeat.i(292588);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(292588);
      return true;
    }
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ySB, false);
    AppMethodBeat.o(292588);
    return bool;
  }
  
  public static final boolean ibf()
  {
    AppMethodBeat.i(292605);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(292605);
      return true;
    }
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ySC, false);
    AppMethodBeat.o(292605);
    return bool;
  }
  
  public static void ibg()
  {
    AppMethodBeat.i(292668);
    Log.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 1L, 1L);
    AppMethodBeat.o(292668);
  }
  
  public static void ibh()
  {
    AppMethodBeat.i(292682);
    Log.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 2L, 1L);
    AppMethodBeat.o(292682);
  }
  
  public static void ibi()
  {
    AppMethodBeat.i(292697);
    ULG = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 3L, 1L);
    AppMethodBeat.o(292697);
  }
  
  public static void ibj()
  {
    AppMethodBeat.i(292710);
    ULH = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 4L, 1L);
    AppMethodBeat.o(292710);
  }
  
  public static void ibk()
  {
    AppMethodBeat.i(292721);
    ULI = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 5L, 1L);
    AppMethodBeat.o(292721);
  }
  
  public static final void ibl()
  {
    AppMethodBeat.i(292734);
    Log.i("MicroMsg.VoipActivityReport", "markEngineIsClose");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 25L, 1L);
    AppMethodBeat.o(292734);
  }
  
  public static void ibm()
  {
    AppMethodBeat.i(292741);
    Log.i("MicroMsg.VoipActivityReport", "markDiffServiceWithIntent");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 26L, 1L);
    AppMethodBeat.o(292741);
  }
  
  public static void ibn()
  {
    AppMethodBeat.i(292754);
    Log.i("MicroMsg.VoipActivityReport", "markResponseActivityWhileServiceZero");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 27L, 1L);
    AppMethodBeat.o(292754);
  }
  
  public static void ibo()
  {
    AppMethodBeat.i(292758);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingAfterCancel");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 28L, 1L);
    AppMethodBeat.o(292758);
  }
  
  public static void ibp()
  {
    AppMethodBeat.i(292768);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingNoneAfterCancel");
    com.tencent.mm.plugin.report.service.h.OAn.p(1433L, 29L, 1L);
    AppMethodBeat.o(292768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.f
 * JD-Core Version:    0.7.0.1
 */