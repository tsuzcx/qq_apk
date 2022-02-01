package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "markFakeCallingHappened", "", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "reportKvStatVoipActivity", "caller", "plugin-voip_release"})
public final class e
{
  private static long CCO;
  private static long CCP;
  private static long CCQ;
  public static final e CCR;
  
  static
  {
    AppMethodBeat.i(210391);
    CCR = new e();
    AppMethodBeat.o(210391);
  }
  
  public static void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210385);
    ae.i("MicroMsg.VoipActivityReport", "markVideoActivityOnCreate ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 0L, 1L);
      AppMethodBeat.o(210385);
      return;
      if (CCO != 0L)
      {
        long l = bu.aO(CCO);
        ae.i("MicroMsg.VoipActivityReport", "markOnCreateFromVoipService cost ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.g.yxI.c(1433, 6, 7, (int)l, false);
        if (paramBoolean) {
          a(paramLong1, paramInt, l, paramLong2);
        }
        CCO = 0L;
        continue;
        if (CCP != 0L)
        {
          l = bu.aO(CCP);
          ae.i("MicroMsg.VoipActivityReport", "markOnCreateNormal cost ".concat(String.valueOf(l)));
          com.tencent.mm.plugin.report.service.g.yxI.c(1433, 9, 10, (int)l, false);
          if (paramBoolean) {
            a(paramLong1, paramInt, l, paramLong2);
          }
          CCP = 0L;
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 15L, 1L);
          if (paramBoolean)
          {
            a(paramLong1, paramInt, -1L, paramLong2);
            continue;
            if (CCQ != 0L)
            {
              l = bu.aO(CCQ);
              ae.i("MicroMsg.VoipActivityReport", "markOnCreateForeground cost ".concat(String.valueOf(l)));
              com.tencent.mm.plugin.report.service.g.yxI.c(1433, 12, 13, (int)l, false);
              if (paramBoolean) {
                a(paramLong1, paramInt, l, paramLong2);
              }
              CCQ = 0L;
            }
          }
        }
      }
    }
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(210384);
    if (paramLong3 == 0L) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.a(20486, true, true, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(210384);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 16L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 17L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 18L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 19L, 1L);
      continue;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 20L, 1L);
        break;
      case 1: 
        com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 21L, 1L);
        break;
      case 2: 
        com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 22L, 1L);
        break;
      case 3: 
        com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 23L, 1L);
      }
    }
  }
  
  public static final boolean eDf()
  {
    AppMethodBeat.i(210383);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG))
    {
      AppMethodBeat.o(210383);
      return true;
    }
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qDW, false);
    AppMethodBeat.o(210383);
    return bool;
  }
  
  public static void eDg()
  {
    AppMethodBeat.i(210386);
    ae.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
    com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 1L, 1L);
    AppMethodBeat.o(210386);
  }
  
  public static void eDh()
  {
    AppMethodBeat.i(210387);
    ae.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
    com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 2L, 1L);
    AppMethodBeat.o(210387);
  }
  
  public static void eDi()
  {
    AppMethodBeat.i(210388);
    CCO = bu.HQ();
    ae.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
    com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 3L, 1L);
    AppMethodBeat.o(210388);
  }
  
  public static void eDj()
  {
    AppMethodBeat.i(210389);
    CCP = bu.HQ();
    ae.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
    com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 4L, 1L);
    AppMethodBeat.o(210389);
  }
  
  public static void eDk()
  {
    AppMethodBeat.i(210390);
    CCQ = bu.HQ();
    ae.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
    com.tencent.mm.plugin.report.service.g.yxI.n(1433L, 5L, 1L);
    AppMethodBeat.o(210390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.e
 * JD-Core Version:    0.7.0.1
 */