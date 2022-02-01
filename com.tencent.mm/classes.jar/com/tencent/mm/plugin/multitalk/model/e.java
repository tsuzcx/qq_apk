package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class e
{
  public static int tOA = 0;
  public static int tOx = 0;
  public static int tOy = 0;
  public static int tOz = 0;
  public static int tji = 0;
  
  public static final void Hd(int paramInt)
  {
    AppMethodBeat.i(178879);
    h.vKh.idkeyStat(220L, 35L, 1L, false);
    h.vKh.idkeyStat(220L, 36L, paramInt, false);
    AppMethodBeat.o(178879);
  }
  
  public static final void He(int paramInt)
  {
    AppMethodBeat.i(178883);
    h.vKh.idkeyStat(220L, 23L, 1L, false);
    h.vKh.idkeyStat(220L, 24L, paramInt, false);
    AppMethodBeat.o(178883);
  }
  
  public static final void Hf(int paramInt)
  {
    AppMethodBeat.i(178884);
    h.vKh.idkeyStat(220L, 19L, 1L, false);
    h.vKh.idkeyStat(220L, 20L, paramInt, false);
    AppMethodBeat.o(178884);
  }
  
  public static final void Hg(int paramInt)
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
    h.vKh.b(localArrayList, false);
    AppMethodBeat.o(114457);
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(114448);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.vKh.f(12727, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(114448);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString)
  {
    AppMethodBeat.i(114442);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString });
    h.vKh.idkeyStat(220L, 34L, 1L, false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.vKh.f(12725, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114442);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(114443);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.vKh.f(12725, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(114443);
      return;
    }
  }
  
  public static final void ahB(String paramString)
  {
    AppMethodBeat.i(114450);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[] { paramString, Integer.valueOf(tOx), Integer.valueOf(tOy), Integer.valueOf(tOz), Integer.valueOf(tji), Integer.valueOf(tOA) });
    h.vKh.f(12729, new Object[] { paramString, Integer.valueOf(tOx), Integer.valueOf(tOy), Integer.valueOf(tOz), Integer.valueOf(tji), Integer.valueOf(tOA) });
    gh(9, tOx);
    gh(10, tOA);
    gh(11, tOy);
    gh(12, tOz);
    gh(13, tji);
    tOx = 0;
    tOy = 0;
    tOz = 0;
    tji = 0;
    tOA = 0;
    AppMethodBeat.o(114450);
  }
  
  public static final void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(114446);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    h.vKh.f(12723, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(114446);
  }
  
  public static final void cRR()
  {
    AppMethodBeat.i(114444);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
    h.vKh.f(12722, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114444);
  }
  
  public static final void cRS()
  {
    AppMethodBeat.i(114445);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
    h.vKh.f(12722, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114445);
  }
  
  public static final void cRT()
  {
    AppMethodBeat.i(178880);
    h.vKh.idkeyStat(220L, 27L, 1L, false);
    AppMethodBeat.o(178880);
  }
  
  public static final void cRU()
  {
    AppMethodBeat.i(178881);
    h.vKh.idkeyStat(220L, 26L, 1L, false);
    AppMethodBeat.o(178881);
  }
  
  public static final void cRV()
  {
    AppMethodBeat.i(178887);
    h.vKh.idkeyStat(220L, 25L, 1L, false);
    AppMethodBeat.o(178887);
  }
  
  public static final void cRW()
  {
    AppMethodBeat.i(114453);
    h.vKh.idkeyStat(220L, 0L, 1L, false);
    AppMethodBeat.o(114453);
  }
  
  public static final void cRX()
  {
    AppMethodBeat.i(114455);
    h.vKh.idkeyStat(220L, 1L, 1L, false);
    AppMethodBeat.o(114455);
  }
  
  public static final void cRY()
  {
    AppMethodBeat.i(114459);
    h.vKh.f(14849, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114459);
  }
  
  public static final void cRZ()
  {
    AppMethodBeat.i(114460);
    h.vKh.f(14849, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114460);
  }
  
  public static final void cSa()
  {
    AppMethodBeat.i(114461);
    h.vKh.f(14849, new Object[] { Integer.valueOf(3) });
    AppMethodBeat.o(114461);
  }
  
  public static final void cSb()
  {
    AppMethodBeat.i(114462);
    h.vKh.f(14849, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(114462);
  }
  
  public static final void cSc()
  {
    AppMethodBeat.i(114463);
    h.vKh.f(14849, new Object[] { Integer.valueOf(5) });
    AppMethodBeat.o(114463);
  }
  
  public static final void cSd()
  {
    AppMethodBeat.i(114464);
    h.vKh.f(14849, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(114464);
  }
  
  public static final void cSe()
  {
    AppMethodBeat.i(114465);
    h.vKh.f(14849, new Object[] { Integer.valueOf(7) });
    AppMethodBeat.o(114465);
  }
  
  public static final void cSf()
  {
    AppMethodBeat.i(114466);
    h.vKh.f(14849, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(114466);
  }
  
  public static final void cSg()
  {
    AppMethodBeat.i(114467);
    h.vKh.f(14849, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(114467);
  }
  
  public static final void cSh()
  {
    AppMethodBeat.i(114468);
    h.vKh.f(14849, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(114468);
  }
  
  public static final void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114451);
    if ((paramBoolean1) && (paramBoolean2))
    {
      h.vKh.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean1)
    {
      h.vKh.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(2) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean2)
    {
      h.vKh.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    h.vKh.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(2) });
    AppMethodBeat.o(114451);
  }
  
  private static void gh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114458);
    h.vKh.idkeyStat(220L, paramInt1, paramInt2, false);
    AppMethodBeat.o(114458);
  }
  
  public static final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114452);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkGroupId %s %s", new Object[] { paramString2, paramString1 });
    h.vKh.f(17771, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramString2, paramString1 });
    AppMethodBeat.o(114452);
  }
  
  public static final void k(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(178878);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkMoreArrowClick %s,%s, %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    h.vKh.f(19424, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(178878);
  }
  
  public static final void nA(boolean paramBoolean)
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
    h.vKh.b(localArrayList, false);
    AppMethodBeat.o(114454);
  }
  
  public static final void nB(boolean paramBoolean)
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
    h.vKh.b(localArrayList, false);
    AppMethodBeat.o(114456);
  }
  
  public static final void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(178882);
    if (paramBoolean)
    {
      h.vKh.idkeyStat(220L, 21L, 1L, false);
      AppMethodBeat.o(178882);
      return;
    }
    h.vKh.idkeyStat(220L, 22L, 1L, false);
    AppMethodBeat.o(178882);
  }
  
  public static final void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(178885);
    if (paramBoolean)
    {
      h.vKh.idkeyStat(220L, 30L, 1L, false);
      AppMethodBeat.o(178885);
      return;
    }
    h.vKh.idkeyStat(220L, 31L, 1L, false);
    AppMethodBeat.o(178885);
  }
  
  public static final void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(178886);
    if (paramBoolean)
    {
      h.vKh.idkeyStat(220L, 33L, 1L, false);
      AppMethodBeat.o(178886);
      return;
    }
    h.vKh.idkeyStat(220L, 32L, 1L, false);
    AppMethodBeat.o(178886);
  }
  
  public static final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(114447);
    ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
    h.vKh.f(12726, new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(114447);
  }
  
  public static final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(114449);
    if (paramLong > 1000L) {}
    for (paramLong /= 1000L;; paramLong = 1L)
    {
      ad.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
      h.vKh.f(12728, new Object[] { Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114449);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.e
 * JD-Core Version:    0.7.0.1
 */