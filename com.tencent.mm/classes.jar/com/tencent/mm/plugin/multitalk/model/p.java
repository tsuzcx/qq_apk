package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class p
{
  public static int EFF = 0;
  public static int FrG = 0;
  public static int FrH = 0;
  public static int FrI = 0;
  public static int FrJ = 0;
  public static int FrK = 0;
  public static int FrL = 0;
  public static int FrM = 0;
  public static int FrN = 0;
  
  public static final void G(long paramLong, String paramString)
  {
    AppMethodBeat.i(114447);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
    h.IzE.a(12726, new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(114447);
  }
  
  public static final void H(long paramLong, String paramString)
  {
    AppMethodBeat.i(114449);
    if (paramLong > 1000L) {}
    for (paramLong /= 1000L;; paramLong = 1L)
    {
      Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
      h.IzE.a(12728, new Object[] { Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114449);
      return;
    }
  }
  
  public static final void Xs(int paramInt)
  {
    AppMethodBeat.i(178879);
    h.IzE.idkeyStat(220L, 35L, 1L, false);
    h.IzE.idkeyStat(220L, 36L, paramInt, false);
    AppMethodBeat.o(178879);
  }
  
  public static final void Xt(int paramInt)
  {
    AppMethodBeat.i(178883);
    h.IzE.idkeyStat(220L, 23L, 1L, false);
    h.IzE.idkeyStat(220L, 24L, paramInt, false);
    AppMethodBeat.o(178883);
  }
  
  public static final void Xu(int paramInt)
  {
    AppMethodBeat.i(178884);
    h.IzE.idkeyStat(220L, 19L, 1L, false);
    h.IzE.idkeyStat(220L, 20L, paramInt, false);
    AppMethodBeat.o(178884);
  }
  
  public static final void Xv(int paramInt)
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
    h.IzE.b(localArrayList, false);
    AppMethodBeat.o(114457);
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(114448);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.IzE.a(12727, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(114448);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString)
  {
    AppMethodBeat.i(114442);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString });
    h.IzE.idkeyStat(220L, 34L, 1L, false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.IzE.a(12725, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(paramLong), paramString });
      AppMethodBeat.o(114442);
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(114443);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.IzE.a(12725, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(114443);
      return;
    }
  }
  
  public static final void aQh(String paramString)
  {
    AppMethodBeat.i(114450);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(FrG), Integer.valueOf(FrH), Integer.valueOf(FrI), Integer.valueOf(EFF), Integer.valueOf(FrJ), Integer.valueOf(FrK), Integer.valueOf(FrL), Integer.valueOf(FrM), Integer.valueOf(FrN) });
    h.IzE.a(12729, new Object[] { paramString, Integer.valueOf(FrG), Integer.valueOf(FrH), Integer.valueOf(FrI), Integer.valueOf(EFF), Integer.valueOf(FrJ), Integer.valueOf(FrK), Integer.valueOf(FrL), Integer.valueOf(FrM), Integer.valueOf(FrN) });
    in(9, FrG);
    in(10, FrJ);
    in(11, FrH);
    in(12, FrI);
    in(13, EFF);
    FrG = 0;
    FrH = 0;
    FrI = 0;
    EFF = 0;
    FrJ = 0;
    FrK = 0;
    FrL = 0;
    FrM = 0;
    FrN = 0;
    AppMethodBeat.o(114450);
  }
  
  public static final void bG(int paramInt, String paramString)
  {
    AppMethodBeat.i(114446);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    h.IzE.a(12723, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(114446);
  }
  
  public static final void eWK()
  {
    AppMethodBeat.i(114444);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
    h.IzE.a(12722, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114444);
  }
  
  public static final void eWL()
  {
    AppMethodBeat.i(114445);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
    h.IzE.a(12722, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114445);
  }
  
  public static final void eWM()
  {
    AppMethodBeat.i(178880);
    h.IzE.idkeyStat(220L, 27L, 1L, false);
    AppMethodBeat.o(178880);
  }
  
  public static final void eWN()
  {
    AppMethodBeat.i(178881);
    h.IzE.idkeyStat(220L, 26L, 1L, false);
    AppMethodBeat.o(178881);
  }
  
  public static final void eWO()
  {
    AppMethodBeat.i(178887);
    h.IzE.idkeyStat(220L, 25L, 1L, false);
    AppMethodBeat.o(178887);
  }
  
  public static final void eWP()
  {
    AppMethodBeat.i(114453);
    h.IzE.idkeyStat(220L, 0L, 1L, false);
    AppMethodBeat.o(114453);
  }
  
  public static final void eWQ()
  {
    AppMethodBeat.i(114455);
    h.IzE.idkeyStat(220L, 1L, 1L, false);
    AppMethodBeat.o(114455);
  }
  
  public static final void eWR()
  {
    AppMethodBeat.i(114459);
    h.IzE.a(14849, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(114459);
  }
  
  public static final void eWS()
  {
    AppMethodBeat.i(114460);
    h.IzE.a(14849, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(114460);
  }
  
  public static final void eWT()
  {
    AppMethodBeat.i(114461);
    h.IzE.a(14849, new Object[] { Integer.valueOf(3) });
    AppMethodBeat.o(114461);
  }
  
  public static final void eWU()
  {
    AppMethodBeat.i(114462);
    h.IzE.a(14849, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(114462);
  }
  
  public static final void eWV()
  {
    AppMethodBeat.i(114463);
    h.IzE.a(14849, new Object[] { Integer.valueOf(5) });
    AppMethodBeat.o(114463);
  }
  
  public static final void eWW()
  {
    AppMethodBeat.i(114464);
    h.IzE.a(14849, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(114464);
  }
  
  public static final void eWX()
  {
    AppMethodBeat.i(114465);
    h.IzE.a(14849, new Object[] { Integer.valueOf(7) });
    AppMethodBeat.o(114465);
  }
  
  public static final void eWY()
  {
    AppMethodBeat.i(114466);
    h.IzE.a(14849, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(114466);
  }
  
  public static final void eWZ()
  {
    AppMethodBeat.i(114467);
    h.IzE.a(14849, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(114467);
  }
  
  public static final void iZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114452);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkGroupId %s %s", new Object[] { paramString2, paramString1 });
    h.IzE.a(17771, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramString2, paramString1 });
    AppMethodBeat.o(114452);
  }
  
  private static void in(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114458);
    h.IzE.idkeyStat(220L, paramInt1, paramInt2, false);
    AppMethodBeat.o(114458);
  }
  
  public static final void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(114451);
    if ((paramBoolean1) && (paramBoolean2))
    {
      h.IzE.a(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean1)
    {
      h.IzE.a(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(2) });
      AppMethodBeat.o(114451);
      return;
    }
    if (paramBoolean2)
    {
      h.IzE.a(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(114451);
      return;
    }
    h.IzE.a(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(2) });
    AppMethodBeat.o(114451);
  }
  
  public static final void p(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(178878);
    Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkMoreArrowClick %s,%s, %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    h.IzE.a(19424, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(178878);
  }
  
  public static final void q(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199354);
    Log.i("MicroMsg.MT.MultiTalkKvReportUtil", "reportScreenProjectFuncReport %s,%s, %s,%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.IzE.a(21344, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(199354);
  }
  
  public static final void uF(boolean paramBoolean)
  {
    AppMethodBeat.i(178882);
    if (paramBoolean)
    {
      h.IzE.idkeyStat(220L, 21L, 1L, false);
      AppMethodBeat.o(178882);
      return;
    }
    h.IzE.idkeyStat(220L, 22L, 1L, false);
    AppMethodBeat.o(178882);
  }
  
  public static final void uG(boolean paramBoolean)
  {
    AppMethodBeat.i(178885);
    if (paramBoolean)
    {
      h.IzE.idkeyStat(220L, 30L, 1L, false);
      AppMethodBeat.o(178885);
      return;
    }
    h.IzE.idkeyStat(220L, 31L, 1L, false);
    AppMethodBeat.o(178885);
  }
  
  public static final void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(178886);
    if (paramBoolean)
    {
      h.IzE.idkeyStat(220L, 33L, 1L, false);
      AppMethodBeat.o(178886);
      return;
    }
    h.IzE.idkeyStat(220L, 32L, 1L, false);
    AppMethodBeat.o(178886);
  }
  
  public static final void uI(boolean paramBoolean)
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
    h.IzE.b(localArrayList, false);
    AppMethodBeat.o(114454);
  }
  
  public static final void uJ(boolean paramBoolean)
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
    h.IzE.b(localArrayList, false);
    AppMethodBeat.o(114456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */