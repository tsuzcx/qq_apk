package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "isUseStaticParamsCheckVoip", "markDiffServiceWithIntent", "", "markEngineIsClose", "markFakeCallingHappened", "markForbiddenCallingAfterCancel", "markForbiddenCallingNoneAfterCancel", "markForbiddenCauseEngineClose", "isAfterCancel", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markResponseActivityWhileServiceZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "isEngineClose", "reportKvStatVoipActivity", "caller", "plugin-voip_release"})
public final class d
{
  private static long HgR;
  private static long HgS;
  private static long HgT;
  public static final d HgU;
  
  static
  {
    AppMethodBeat.i(236049);
    HgU = new d();
    AppMethodBeat.o(236049);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    AppMethodBeat.i(236038);
    Log.i("MicroMsg.VoipActivityReport", "markVideoActivityOnCreate ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      h.CyF.n(1433L, 0L, 1L);
      AppMethodBeat.o(236038);
      return;
      if (HgR != 0L)
      {
        long l = Util.ticksToNow(HgR);
        Log.i("MicroMsg.VoipActivityReport", "markOnCreateFromVoipService cost ".concat(String.valueOf(l)));
        h.CyF.b(1433, 6, 7, (int)l, false);
        if (paramBoolean1) {
          a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
        }
        HgR = 0L;
        continue;
        if (HgS != 0L)
        {
          l = Util.ticksToNow(HgS);
          Log.i("MicroMsg.VoipActivityReport", "markOnCreateNormal cost ".concat(String.valueOf(l)));
          h.CyF.b(1433, 9, 10, (int)l, false);
          if (paramBoolean1) {
            a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
          }
          HgS = 0L;
          continue;
          h.CyF.n(1433L, 15L, 1L);
          if (paramBoolean1)
          {
            a(paramLong1, paramInt, -1L, paramLong2, paramBoolean2);
            continue;
            if (HgT != 0L)
            {
              l = Util.ticksToNow(HgT);
              Log.i("MicroMsg.VoipActivityReport", "markOnCreateForeground cost ".concat(String.valueOf(l)));
              h.CyF.b(1433, 12, 13, (int)l, false);
              if (paramBoolean1) {
                a(paramLong1, paramInt, l, paramLong2, paramBoolean2);
              }
              HgT = 0L;
            }
          }
        }
      }
    }
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(236037);
    h localh;
    if (paramLong3 == 0L) {
      switch (paramInt)
      {
      default: 
        localh = h.CyF;
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      localh.a(20486, true, true, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i) });
      AppMethodBeat.o(236037);
      return;
      h.CyF.n(1433L, 16L, 1L);
      break;
      h.CyF.n(1433L, 17L, 1L);
      break;
      h.CyF.n(1433L, 18L, 1L);
      break;
      h.CyF.n(1433L, 19L, 1L);
      break;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        h.CyF.n(1433L, 20L, 1L);
        break;
      case 1: 
        h.CyF.n(1433L, 21L, 1L);
        break;
      case 2: 
        h.CyF.n(1433L, 22L, 1L);
        break;
      case 3: 
        h.CyF.n(1433L, 23L, 1L);
        break;
      }
    }
  }
  
  public static final boolean fJQ()
  {
    AppMethodBeat.i(236035);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(236035);
      return true;
    }
    boolean bool = ((b)g.af(b.class)).a(b.a.rWY, false);
    AppMethodBeat.o(236035);
    return bool;
  }
  
  public static final boolean fJR()
  {
    AppMethodBeat.i(236036);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(236036);
      return true;
    }
    boolean bool = ((b)g.af(b.class)).a(b.a.rWZ, false);
    AppMethodBeat.o(236036);
    return bool;
  }
  
  public static void fJS()
  {
    AppMethodBeat.i(236039);
    Log.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
    h.CyF.n(1433L, 1L, 1L);
    AppMethodBeat.o(236039);
  }
  
  public static void fJT()
  {
    AppMethodBeat.i(236040);
    Log.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
    h.CyF.n(1433L, 2L, 1L);
    AppMethodBeat.o(236040);
  }
  
  public static void fJU()
  {
    AppMethodBeat.i(236041);
    HgR = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
    h.CyF.n(1433L, 3L, 1L);
    AppMethodBeat.o(236041);
  }
  
  public static void fJV()
  {
    AppMethodBeat.i(236042);
    HgS = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
    h.CyF.n(1433L, 4L, 1L);
    AppMethodBeat.o(236042);
  }
  
  public static void fJW()
  {
    AppMethodBeat.i(236043);
    HgT = Util.currentTicks();
    Log.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
    h.CyF.n(1433L, 5L, 1L);
    AppMethodBeat.o(236043);
  }
  
  public static final void fJX()
  {
    AppMethodBeat.i(236044);
    Log.i("MicroMsg.VoipActivityReport", "markEngineIsClose");
    h.CyF.n(1433L, 25L, 1L);
    AppMethodBeat.o(236044);
  }
  
  public static void fJY()
  {
    AppMethodBeat.i(236045);
    Log.i("MicroMsg.VoipActivityReport", "markDiffServiceWithIntent");
    h.CyF.n(1433L, 26L, 1L);
    AppMethodBeat.o(236045);
  }
  
  public static void fJZ()
  {
    AppMethodBeat.i(236046);
    Log.i("MicroMsg.VoipActivityReport", "markResponseActivityWhileServiceZero");
    h.CyF.n(1433L, 27L, 1L);
    AppMethodBeat.o(236046);
  }
  
  public static void fKa()
  {
    AppMethodBeat.i(236047);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingAfterCancel");
    h.CyF.n(1433L, 28L, 1L);
    AppMethodBeat.o(236047);
  }
  
  public static void fKb()
  {
    AppMethodBeat.i(236048);
    Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingNoneAfterCancel");
    h.CyF.n(1433L, 29L, 1L);
    AppMethodBeat.o(236048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.d
 * JD-Core Version:    0.7.0.1
 */