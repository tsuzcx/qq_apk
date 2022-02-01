package com.tencent.mm.plugin.multitalk.e;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkPerformanceReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkPerformanceReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkPerformanceReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e LAH;
  private static final a[] LAI;
  private static final Map<Integer, Integer> LAJ;
  private static final int[] LAK;
  public static long LAL;
  public static long LAM;
  public static long LAN;
  public static long LAP;
  public static int LAQ;
  
  static
  {
    AppMethodBeat.i(284652);
    LAH = new e();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a(i);
      i += 1;
    }
    LAI = arrayOfa;
    LAJ = ak.e(new r[] { v.Y(Integer.valueOf(0), Integer.valueOf(0)), v.Y(Integer.valueOf(1), Integer.valueOf(3)), v.Y(Integer.valueOf(2), Integer.valueOf(6)), v.Y(Integer.valueOf(3), Integer.valueOf(9)), v.Y(Integer.valueOf(4), Integer.valueOf(12)) });
    LAK = new int[2];
    AppMethodBeat.o(284652);
  }
  
  public static void aJ(int paramInt, long paramLong)
  {
    a locala = LAI[paramInt];
    locala.oZt += 1;
    locala.Frl += paramLong;
  }
  
  private static void aK(int paramInt, long paramLong)
  {
    AppMethodBeat.i(284644);
    Log.i("MultitalkReportHelper", "report avg key: " + paramInt + " value: " + paramLong);
    h.OAn.c(1438, paramInt, paramInt + 1, (int)paramLong, false);
    AppMethodBeat.o(284644);
  }
  
  public static void acf(int paramInt)
  {
    AppMethodBeat.i(284616);
    if (LAQ == 0) {
      LAL = System.currentTimeMillis();
    }
    if (paramInt != LAQ) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      LAL = System.currentTimeMillis();
      LAQ = paramInt;
      AppMethodBeat.o(284616);
      return;
      acg(0);
      long l = System.currentTimeMillis() - LAL;
      LAN += l;
      LAM = l + LAM;
      continue;
      acg(1);
      l = System.currentTimeMillis() - LAL;
      LAP += l;
      LAM = l + LAM;
    }
  }
  
  private static void acg(int paramInt)
  {
    int[] arrayOfInt = LAK;
    arrayOfInt[paramInt] += 1;
  }
  
  public static void report()
  {
    AppMethodBeat.i(284626);
    Object localObject1 = LAI;
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      if (((a)localObject3).oZt > 5) {}
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
      localObject3 = (Integer)LAJ.get(Integer.valueOf(((a)localObject2).idx));
      if (localObject3 != null) {
        aK(((Number)localObject3).intValue(), ((a)localObject2).Frl / ((a)localObject2).oZt);
      }
    }
    if (LAM > 0L)
    {
      aK(15, LAK[0]);
      aK(18, LAK[1]);
      aK(21, ((float)LAN / (float)LAM * 100.0F));
      aK(24, ((float)LAP / (float)LAM * 100.0F));
    }
    reset();
    AppMethodBeat.o(284626);
  }
  
  public static void reset()
  {
    a[] arrayOfa = LAI;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.Frl = 0L;
      locala.oZt = 0;
      i += 1;
    }
    int k = LAK.length - 1;
    if (k >= 0) {}
    for (i = 0;; i = j)
    {
      j = i + 1;
      LAK[i] = 0;
      if (j > k)
      {
        LAL = 0L;
        LAM = 0L;
        LAP = 0L;
        LAN = 0L;
        LAQ = 0;
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkPerformanceReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long Frl;
    final int idx;
    int oZt;
    
    public a(int paramInt)
    {
      this.idx = paramInt;
      this.Frl = 0L;
      this.oZt = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.idx != paramObject.idx) {
          return false;
        }
        if (this.Frl != paramObject.Frl) {
          return false;
        }
      } while (this.oZt == paramObject.oZt);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(284606);
      int i = this.idx;
      int j = q.a..ExternalSyntheticBackport0.m(this.Frl);
      int k = this.oZt;
      AppMethodBeat.o(284606);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(284602);
      String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.Frl + ", times=" + this.oZt + ')';
      AppMethodBeat.o(284602);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.e
 * JD-Core Version:    0.7.0.1
 */