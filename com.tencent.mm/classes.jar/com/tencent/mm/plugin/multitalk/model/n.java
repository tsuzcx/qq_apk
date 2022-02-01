package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;

public final class n
{
  public static int vGi = 0;
  public static int wqK = 0;
  public static int wqL = 0;
  public static int wqM = 0;
  public static int wqN = 0;
  
  public static final void Le(int paramInt)
  {
    AppMethodBeat.i(178879);
    g.yxI.idkeyStat(220L, 35L, 1L, false);
    g.yxI.idkeyStat(220L, 36L, paramInt, false);
    AppMethodBeat.o(178879);
  }
  
  public static final void Lf(int paramInt)
  {
    AppMethodBeat.i(178883);
    g.yxI.idkeyStat(220L, 23L, 1L, false);
    g.yxI.idkeyStat(220L, 24L, paramInt, false);
    AppMethodBeat.o(178883);
  }
  
  public static final void Lg(int paramInt)
  {
    AppMethodBeat.i(178884);
    g.yxI.idkeyStat(220L, 19L, 1L, false);
    g.yxI.idkeyStat(220L, 20L, paramInt, false);
    AppMethodBeat.o(178884);
  }
  
  public static final void Lh(int paramInt)
  {
    AppMethodBeat.i(114457);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(220);
    localIDKey.SetKey(7);
    localIDKey.SetValue(paramInt);
    localArrayList.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(220);
    localIDKey.SetKey(8);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    g.yxI.b(localArrayList, false);
    AppMethodBeat.o(114457);
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(114448);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      g.yxI.f(12727, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(114448);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString)
  {
    AppMethodBeat.i(114442);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString });
    g.yxI.idkeyStat(220L, 34L, 1L, false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      g.yxI.f(12725, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114442);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(114443);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      g.yxI.f(12725, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(114443);
      return;
    }
  }
  
  public static final void asA(String paramString)
  {
    AppMethodBeat.i(114450);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[] { paramString, Integer.valueOf(wqK), Integer.valueOf(wqL), Integer.valueOf(wqM), Integer.valueOf(vGi), Integer.valueOf(wqN) });
    g.yxI.f(12729, new Object[] { paramString, Integer.valueOf(wqK), Integer.valueOf(wqL), Integer.valueOf(wqM), Integer.valueOf(vGi), Integer.valueOf(wqN) });
    gG(9, wqK);
    gG(10, wqN);
    gG(11, wqL);
    gG(12, wqM);
    gG(13, vGi);
    wqK = 0;
    wqL = 0;
    wqM = 0;
    vGi = 0;
    wqN = 0;
    AppMethodBeat.o(114450);
  }
  
  public static final void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(114446);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    g.yxI.f(12723, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(114446);
  }
  
  public static final void dsD()
  {
    AppMethodBeat.i(114444);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
    g.yxI.f(12722, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114444);
  }
  
  public static final void dsE()
  {
    AppMethodBeat.i(114445);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
    g.yxI.f(12722, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114445);
  }
  
  public static final void dsF()
  {
    AppMethodBeat.i(178880);
    g.yxI.idkeyStat(220L, 27L, 1L, false);
    AppMethodBeat.o(178880);
  }
  
  public static final void dsG()
  {
    AppMethodBeat.i(178881);
    g.yxI.idkeyStat(220L, 26L, 1L, false);
    AppMethodBeat.o(178881);
  }
  
  public static final void dsH()
  {
    AppMethodBeat.i(178887);
    g.yxI.idkeyStat(220L, 25L, 1L, false);
    AppMethodBeat.o(178887);
  }
  
  public static final void dsI()
  {
    AppMethodBeat.i(114453);
    g.yxI.idkeyStat(220L, 0L, 1L, false);
    AppMethodBeat.o(114453);
  }
  
  public static final void dsJ()
  {
    AppMethodBeat.i(114455);
    g.yxI.idkeyStat(220L, 1L, 1L, false);
    AppMethodBeat.o(114455);
  }
  
  public static final void dsK()
  {
    AppMethodBeat.i(114459);
    g.yxI.f(14849, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114459);
  }
  
  public static final void dsL()
  {
    AppMethodBeat.i(114460);
    g.yxI.f(14849, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114460);
  }
  
  public static final void dsM()
  {
    AppMethodBeat.i(114461);
    g.yxI.f(14849, new Object[] { Integer.valueOf(3) });
    AppMethodBeat.o(114461);
  }
  
  public static final void dsN()
  {
    AppMethodBeat.i(114462);
    g.yxI.f(14849, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(114462);
  }
  
  public static final void dsO()
  {
    AppMethodBeat.i(114463);
    g.yxI.f(14849, new Object[] { Integer.valueOf(5) });
    AppMethodBeat.o(114463);
  }
  
  public static final void dsP()
  {
    AppMethodBeat.i(114464);
    g.yxI.f(14849, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(114464);
  }
  
  public static final void dsQ()
  {
    AppMethodBeat.i(114465);
    g.yxI.f(14849, new Object[] { Integer.valueOf(7) });
    AppMethodBeat.o(114465);
  }
  
  public static final void dsR()
  {
    AppMethodBeat.i(114466);
    g.yxI.f(14849, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(114466);
  }
  
  public static final void dsS()
  {
    AppMethodBeat.i(114467);
    g.yxI.f(14849, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(114467);
  }
  
  private static void gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114458);
    g.yxI.idkeyStat(220L, paramInt1, paramInt2, false);
    AppMethodBeat.o(114458);
  }
  
  public static final void i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114451);
    if ((paramBoolean1) && (paramBoolean2))
    {
      g.yxI.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean1)
    {
      g.yxI.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(2) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean2)
    {
      g.yxI.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    g.yxI.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(2) });
    AppMethodBeat.o(114451);
  }
  
  public static final void jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114452);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkGroupId %s %s", new Object[] { paramString2, paramString1 });
    g.yxI.f(17771, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramString2, paramString1 });
    AppMethodBeat.o(114452);
  }
  
  public static final void m(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(178878);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkMoreArrowClick %s,%s, %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    g.yxI.f(19424, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(178878);
  }
  
  public static final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(178882);
    if (paramBoolean)
    {
      g.yxI.idkeyStat(220L, 21L, 1L, false);
      AppMethodBeat.o(178882);
      return;
    }
    g.yxI.idkeyStat(220L, 22L, 1L, false);
    AppMethodBeat.o(178882);
  }
  
  public static final void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(178885);
    if (paramBoolean)
    {
      g.yxI.idkeyStat(220L, 30L, 1L, false);
      AppMethodBeat.o(178885);
      return;
    }
    g.yxI.idkeyStat(220L, 31L, 1L, false);
    AppMethodBeat.o(178885);
  }
  
  public static final void oW(boolean paramBoolean)
  {
    AppMethodBeat.i(178886);
    if (paramBoolean)
    {
      g.yxI.idkeyStat(220L, 33L, 1L, false);
      AppMethodBeat.o(178886);
      return;
    }
    g.yxI.idkeyStat(220L, 32L, 1L, false);
    AppMethodBeat.o(178886);
  }
  
  public static final void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(114454);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(220);
    localIDKey.SetKey(3);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    if (paramBoolean)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(220);
      localIDKey.SetKey(4);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    g.yxI.b(localArrayList, false);
    AppMethodBeat.o(114454);
  }
  
  public static final void oY(boolean paramBoolean)
  {
    AppMethodBeat.i(114456);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(220);
    localIDKey.SetKey(5);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    if (paramBoolean)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(220);
      localIDKey.SetKey(6);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    g.yxI.b(localArrayList, false);
    AppMethodBeat.o(114456);
  }
  
  public static final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(114447);
    ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
    g.yxI.f(12726, new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(114447);
  }
  
  public static final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(114449);
    if (paramLong > 1000L) {}
    for (paramLong /= 1000L;; paramLong = 1L)
    {
      ae.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
      g.yxI.f(12728, new Object[] { Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114449);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.n
 * JD-Core Version:    0.7.0.1
 */