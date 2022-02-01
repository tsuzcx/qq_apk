package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.l;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"})
public final class d
{
  private static final Map<Integer, Integer> whA;
  private static final int[] whB;
  private static long whC;
  private static long whD;
  private static long whE;
  private static long whF;
  private static int whG;
  public static final d whH;
  private static final a[] whz;
  
  static
  {
    AppMethodBeat.i(206766);
    whH = new d();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a(i);
      i += 1;
    }
    whz = arrayOfa;
    whA = ae.a(new o[] { u.S(Integer.valueOf(0), Integer.valueOf(0)), u.S(Integer.valueOf(1), Integer.valueOf(3)), u.S(Integer.valueOf(2), Integer.valueOf(6)), u.S(Integer.valueOf(3), Integer.valueOf(9)), u.S(Integer.valueOf(4), Integer.valueOf(12)) });
    whB = new int[2];
    AppMethodBeat.o(206766);
  }
  
  public static void KO(int paramInt)
  {
    AppMethodBeat.i(206762);
    if (whG == 0) {
      whC = System.currentTimeMillis();
    }
    long l;
    if (paramInt != whG)
    {
      if (paramInt != 1) {
        break label73;
      }
      KP(0);
      l = System.currentTimeMillis() - whC;
      whE += l;
      whD = l + whD;
    }
    for (;;)
    {
      whC = System.currentTimeMillis();
      whG = paramInt;
      AppMethodBeat.o(206762);
      return;
      label73:
      if (paramInt == 2)
      {
        KP(1);
        l = System.currentTimeMillis() - whC;
        whF += l;
        whD = l + whD;
      }
    }
  }
  
  private static void KP(int paramInt)
  {
    int[] arrayOfInt = whB;
    arrayOfInt[paramInt] += 1;
  }
  
  private static void ao(int paramInt, long paramLong)
  {
    AppMethodBeat.i(206765);
    ad.i("MultitalkReportHelper", "report avg key: " + paramInt + " value: " + paramLong);
    g.yhR.c(1438, paramInt, paramInt + 1, (int)paramLong, false);
    AppMethodBeat.o(206765);
  }
  
  public static void append(int paramInt, long paramLong)
  {
    a locala = whz[paramInt];
    locala.gun += 1;
    locala.whI += paramLong;
  }
  
  public static void dqq()
  {
    AppMethodBeat.i(206763);
    long l;
    if (whG == 1)
    {
      l = System.currentTimeMillis() - whC;
      whE += l;
      whD = l + whD;
      AppMethodBeat.o(206763);
      return;
    }
    if (whG == 2)
    {
      l = System.currentTimeMillis() - whC;
      whF += l;
      whD = l + whD;
    }
    AppMethodBeat.o(206763);
  }
  
  public static void report()
  {
    AppMethodBeat.i(206764);
    Object localObject1 = whz;
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      if (((a)localObject3).gun > 5) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject2).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = (Integer)whA.get(Integer.valueOf(((a)localObject2).idx));
      if (localObject3 != null) {
        ao(((Number)localObject3).intValue(), ((a)localObject2).whI / ((a)localObject2).gun);
      }
    }
    if (whD > 0L)
    {
      ao(15, whB[0]);
      ao(18, whB[1]);
      ao(21, ((float)whE / (float)whD * 100.0F));
      ao(24, ((float)whF / (float)whD * 100.0F));
    }
    reset();
    AppMethodBeat.o(206764);
  }
  
  public static void reset()
  {
    a[] arrayOfa = whz;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.whI = 0L;
      locala.gun = 0;
      i += 1;
    }
    j = whB.length;
    i = 0;
    while (i < j)
    {
      whB[i] = 0;
      i += 1;
    }
    whC = 0L;
    whD = 0L;
    whF = 0L;
    whE = 0L;
    whG = 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
  public static final class a
  {
    int gun;
    final int idx;
    long whI;
    
    public a(int paramInt)
    {
      this.idx = paramInt;
      this.whI = 0L;
      this.gun = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.idx != paramObject.idx) || (this.whI != paramObject.whI) || (this.gun != paramObject.gun)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.idx;
      long l = this.whI;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.gun;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206761);
      String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.whI + ", times=" + this.gun + ")";
      AppMethodBeat.o(206761);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.d
 * JD-Core Version:    0.7.0.1
 */