package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "markFakeCallingHappened", "", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "reportKvStatVoipActivity", "caller", "plugin-voip_release"})
public final class e
{
  private static long Clk;
  private static long Cll;
  private static long Clm;
  public static final e Cln;
  
  static
  {
    AppMethodBeat.i(215970);
    Cln = new e();
    AppMethodBeat.o(215970);
  }
  
  public static void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215964);
    ad.i("MicroMsg.VoipActivityReport", "markVideoActivityOnCreate ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 0L, 1L);
      AppMethodBeat.o(215964);
      return;
      if (Clk != 0L)
      {
        long l = bt.aO(Clk);
        ad.i("MicroMsg.VoipActivityReport", "markOnCreateFromVoipService cost ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.g.yhR.c(1433, 6, 7, (int)l, false);
        if (paramBoolean) {
          a(paramLong1, paramInt, l, paramLong2);
        }
        Clk = 0L;
        continue;
        if (Cll != 0L)
        {
          l = bt.aO(Cll);
          ad.i("MicroMsg.VoipActivityReport", "markOnCreateNormal cost ".concat(String.valueOf(l)));
          com.tencent.mm.plugin.report.service.g.yhR.c(1433, 9, 10, (int)l, false);
          if (paramBoolean) {
            a(paramLong1, paramInt, l, paramLong2);
          }
          Cll = 0L;
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 15L, 1L);
          if (paramBoolean)
          {
            a(paramLong1, paramInt, -1L, paramLong2);
            continue;
            if (Clm != 0L)
            {
              l = bt.aO(Clm);
              ad.i("MicroMsg.VoipActivityReport", "markOnCreateForeground cost ".concat(String.valueOf(l)));
              com.tencent.mm.plugin.report.service.g.yhR.c(1433, 12, 13, (int)l, false);
              if (paramBoolean) {
                a(paramLong1, paramInt, l, paramLong2);
              }
              Clm = 0L;
            }
          }
        }
      }
    }
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(215963);
    if (paramLong3 == 0L) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.a(20486, true, true, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(215963);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 16L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 17L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 18L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 19L, 1L);
      continue;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 20L, 1L);
        break;
      case 1: 
        com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 21L, 1L);
        break;
      case 2: 
        com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 22L, 1L);
        break;
      case 3: 
        com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 23L, 1L);
      }
    }
  }
  
  public static void ezA()
  {
    AppMethodBeat.i(215967);
    Clk = bt.HI();
    ad.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
    com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 3L, 1L);
    AppMethodBeat.o(215967);
  }
  
  public static void ezB()
  {
    AppMethodBeat.i(215968);
    Cll = bt.HI();
    ad.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
    com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 4L, 1L);
    AppMethodBeat.o(215968);
  }
  
  public static void ezC()
  {
    AppMethodBeat.i(215969);
    Clm = bt.HI();
    ad.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
    com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 5L, 1L);
    AppMethodBeat.o(215969);
  }
  
  public static final boolean ezx()
  {
    AppMethodBeat.i(215962);
    if ((i.IS_FLAVOR_RED) || (i.DEBUG))
    {
      AppMethodBeat.o(215962);
      return true;
    }
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwW, false);
    AppMethodBeat.o(215962);
    return bool;
  }
  
  public static void ezy()
  {
    AppMethodBeat.i(215965);
    ad.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
    com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 1L, 1L);
    AppMethodBeat.o(215965);
  }
  
  public static void ezz()
  {
    AppMethodBeat.i(215966);
    ad.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
    com.tencent.mm.plugin.report.service.g.yhR.n(1433L, 2L, 1L);
    AppMethodBeat.o(215966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.e
 * JD-Core Version:    0.7.0.1
 */