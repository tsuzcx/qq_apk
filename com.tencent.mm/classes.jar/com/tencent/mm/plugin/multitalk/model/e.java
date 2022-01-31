package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class e
{
  public static int oTg = 0;
  public static int oTh = 0;
  public static int oTi = 0;
  public static int oTj = 0;
  public static int oTk = 0;
  
  public static final void Uu(String paramString)
  {
    AppMethodBeat.i(53919);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[] { paramString, Integer.valueOf(oTg), Integer.valueOf(oTh), Integer.valueOf(oTi), Integer.valueOf(oTj), Integer.valueOf(oTk) });
    h.qsU.e(12729, new Object[] { paramString, Integer.valueOf(oTg), Integer.valueOf(oTh), Integer.valueOf(oTi), Integer.valueOf(oTj), Integer.valueOf(oTk) });
    eL(9, oTg);
    eL(10, oTk);
    eL(11, oTh);
    eL(12, oTi);
    eL(13, oTj);
    oTg = 0;
    oTh = 0;
    oTi = 0;
    oTj = 0;
    oTk = 0;
    AppMethodBeat.o(53919);
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(53917);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.qsU.e(12727, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(53917);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString)
  {
    AppMethodBeat.i(53911);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.qsU.e(12725, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(53911);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(53912);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.qsU.e(12725, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(53912);
      return;
    }
  }
  
  public static final void aR(int paramInt, String paramString)
  {
    AppMethodBeat.i(53915);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    h.qsU.e(12723, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(53915);
  }
  
  public static final void bSR()
  {
    AppMethodBeat.i(53913);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
    h.qsU.e(12722, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(53913);
  }
  
  public static final void bSS()
  {
    AppMethodBeat.i(53914);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
    h.qsU.e(12722, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(53914);
  }
  
  public static final void bST()
  {
    AppMethodBeat.i(53921);
    h.qsU.idkeyStat(220L, 0L, 1L, false);
    AppMethodBeat.o(53921);
  }
  
  public static final void bSU()
  {
    AppMethodBeat.i(53923);
    h.qsU.idkeyStat(220L, 1L, 1L, false);
    AppMethodBeat.o(53923);
  }
  
  public static final void bSV()
  {
    AppMethodBeat.i(53927);
    h.qsU.e(14849, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(53927);
  }
  
  public static final void bSW()
  {
    AppMethodBeat.i(53928);
    h.qsU.e(14849, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(53928);
  }
  
  public static final void bSX()
  {
    AppMethodBeat.i(53929);
    h.qsU.e(14849, new Object[] { Integer.valueOf(3) });
    AppMethodBeat.o(53929);
  }
  
  public static final void bSY()
  {
    AppMethodBeat.i(53930);
    h.qsU.e(14849, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(53930);
  }
  
  public static final void bSZ()
  {
    AppMethodBeat.i(53931);
    h.qsU.e(14849, new Object[] { Integer.valueOf(5) });
    AppMethodBeat.o(53931);
  }
  
  public static final void bTa()
  {
    AppMethodBeat.i(53932);
    h.qsU.e(14849, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(53932);
  }
  
  public static final void bTb()
  {
    AppMethodBeat.i(53933);
    h.qsU.e(14849, new Object[] { Integer.valueOf(7) });
    AppMethodBeat.o(53933);
  }
  
  public static final void bTc()
  {
    AppMethodBeat.i(53934);
    h.qsU.e(14849, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(53934);
  }
  
  public static final void bTd()
  {
    AppMethodBeat.i(53935);
    h.qsU.e(14849, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(53935);
  }
  
  public static final void bTe()
  {
    AppMethodBeat.i(53936);
    h.qsU.e(14849, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(53936);
  }
  
  private static void eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53926);
    h.qsU.idkeyStat(220L, paramInt1, paramInt2, false);
    AppMethodBeat.o(53926);
  }
  
  public static final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156500);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkGroupId %s %s", new Object[] { paramString2, paramString1 });
    h.qsU.e(17771, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramString2, paramString1 });
    AppMethodBeat.o(156500);
  }
  
  public static final void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(53920);
    if ((paramBoolean1) && (paramBoolean2))
    {
      h.qsU.e(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(53920);
      return;
    }
    if (paramBoolean1)
    {
      h.qsU.e(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(2) });
      AppMethodBeat.o(53920);
      return;
    }
    if (paramBoolean2)
    {
      h.qsU.e(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(53920);
      return;
    }
    h.qsU.e(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(2) });
    AppMethodBeat.o(53920);
  }
  
  public static final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(53922);
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
    h.qsU.b(localArrayList, false);
    AppMethodBeat.o(53922);
  }
  
  public static final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(53924);
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
    h.qsU.b(localArrayList, false);
    AppMethodBeat.o(53924);
  }
  
  public static final void q(long paramLong, String paramString)
  {
    AppMethodBeat.i(53916);
    ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
    h.qsU.e(12726, new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(53916);
  }
  
  public static final void r(long paramLong, String paramString)
  {
    AppMethodBeat.i(53918);
    if (paramLong > 1000L) {}
    for (paramLong /= 1000L;; paramLong = 1L)
    {
      ab.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
      h.qsU.e(12728, new Object[] { Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(53918);
      return;
    }
  }
  
  public static final void zD(int paramInt)
  {
    AppMethodBeat.i(53925);
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
    h.qsU.b(localArrayList, false);
    AppMethodBeat.o(53925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.e
 * JD-Core Version:    0.7.0.1
 */