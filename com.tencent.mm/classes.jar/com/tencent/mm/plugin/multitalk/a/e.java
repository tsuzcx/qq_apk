package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e
{
  public static int mtv = 0;
  public static int mtw = 0;
  public static int mtx = 0;
  public static int mty = 0;
  public static int mtz = 0;
  
  public static final void IF(String paramString)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[] { paramString, Integer.valueOf(mtv), Integer.valueOf(mtw), Integer.valueOf(mtx), Integer.valueOf(mty), Integer.valueOf(mtz) });
    h.nFQ.f(12729, new Object[] { paramString, Integer.valueOf(mtv), Integer.valueOf(mtw), Integer.valueOf(mtx), Integer.valueOf(mty), Integer.valueOf(mtz) });
    dl(9, mtv);
    dl(10, mtz);
    dl(11, mtw);
    dl(12, mtx);
    dl(13, mty);
    mtv = 0;
    mtw = 0;
    mtx = 0;
    mty = 0;
    mtz = 0;
  }
  
  public static final void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString, int paramInt3)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.nFQ.f(12727, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt3) });
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.nFQ.f(12725, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(paramLong), paramString });
      return;
    }
  }
  
  public static final void a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      h.nFQ.f(12725, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public static final void av(int paramInt, String paramString)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
    h.nFQ.f(12723, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public static final void bkR()
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
    h.nFQ.f(12722, new Object[] { Integer.valueOf(1) });
  }
  
  public static final void bkS()
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
    h.nFQ.f(12722, new Object[] { Integer.valueOf(2) });
  }
  
  public static final void bkT()
  {
    h.nFQ.a(220L, 0L, 1L, false);
  }
  
  public static final void bkU()
  {
    h.nFQ.a(220L, 1L, 1L, false);
  }
  
  public static final void bkV()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(1) });
  }
  
  public static final void bkW()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(2) });
  }
  
  public static final void bkX()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(3) });
  }
  
  public static final void bkY()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(4) });
  }
  
  public static final void bkZ()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(5) });
  }
  
  public static final void bla()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(6) });
  }
  
  public static final void blb()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(7) });
  }
  
  public static final void blc()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(8) });
  }
  
  public static final void bld()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(9) });
  }
  
  public static final void ble()
  {
    h.nFQ.f(14849, new Object[] { Integer.valueOf(10) });
  }
  
  public static final void d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      h.nFQ.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(1) });
      return;
    }
    if (paramBoolean1)
    {
      h.nFQ.f(12917, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(2) });
      return;
    }
    if (paramBoolean2)
    {
      h.nFQ.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(1) });
      return;
    }
    h.nFQ.f(12917, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(2) });
  }
  
  private static void dl(int paramInt1, int paramInt2)
  {
    h.nFQ.a(220L, paramInt1, paramInt2, false);
  }
  
  public static final void hJ(boolean paramBoolean)
  {
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
    h.nFQ.b(localArrayList, false);
  }
  
  public static final void hK(boolean paramBoolean)
  {
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
    h.nFQ.b(localArrayList, false);
  }
  
  public static final void q(long paramLong, String paramString)
  {
    y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
    h.nFQ.f(12726, new Object[] { Long.valueOf(paramLong), paramString });
  }
  
  public static final void r(long paramLong, String paramString)
  {
    if (paramLong > 1000L) {}
    for (paramLong /= 1000L;; paramLong = 1L)
    {
      y.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[] { Long.valueOf(paramLong), paramString });
      h.nFQ.f(12728, new Object[] { Long.valueOf(paramLong), paramString });
      return;
    }
  }
  
  public static final void un(int paramInt)
  {
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
    h.nFQ.b(localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.e
 * JD-Core Version:    0.7.0.1
 */