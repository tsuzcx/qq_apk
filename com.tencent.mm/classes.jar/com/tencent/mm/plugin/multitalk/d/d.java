package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"})
public final class d
{
  private static final a[] FEF;
  private static final Map<Integer, Integer> FEG;
  private static final int[] FEH;
  private static long FEI;
  private static long FEJ;
  private static long FEK;
  private static long FEL;
  private static int FEM;
  public static final d FEN;
  
  static
  {
    AppMethodBeat.i(199685);
    FEN = new d();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a(i);
      i += 1;
    }
    FEF = arrayOfa;
    FEG = ae.e(new o[] { s.M(Integer.valueOf(0), Integer.valueOf(0)), s.M(Integer.valueOf(1), Integer.valueOf(3)), s.M(Integer.valueOf(2), Integer.valueOf(6)), s.M(Integer.valueOf(3), Integer.valueOf(9)), s.M(Integer.valueOf(4), Integer.valueOf(12)) });
    FEH = new int[2];
    AppMethodBeat.o(199685);
  }
  
  public static void XS(int paramInt)
  {
    AppMethodBeat.i(199663);
    if (FEM == 0) {
      FEI = System.currentTimeMillis();
    }
    long l;
    if (paramInt != FEM)
    {
      if (paramInt != 1) {
        break label73;
      }
      XT(0);
      l = System.currentTimeMillis() - FEI;
      FEK += l;
      FEJ = l + FEJ;
    }
    for (;;)
    {
      FEI = System.currentTimeMillis();
      FEM = paramInt;
      AppMethodBeat.o(199663);
      return;
      label73:
      if (paramInt == 2)
      {
        XT(1);
        l = System.currentTimeMillis() - FEI;
        FEL += l;
        FEJ = l + FEJ;
      }
    }
  }
  
  private static void XT(int paramInt)
  {
    int[] arrayOfInt = FEH;
    arrayOfInt[paramInt] += 1;
  }
  
  public static void aC(int paramInt, long paramLong)
  {
    a locala = FEF[paramInt];
    locala.mgw += 1;
    locala.FEO += paramLong;
  }
  
  private static void aD(int paramInt, long paramLong)
  {
    AppMethodBeat.i(199681);
    Log.i("MultitalkReportHelper", "report avg key: " + paramInt + " value: " + paramLong);
    h.IzE.c(1438, paramInt, paramInt + 1, (int)paramLong, false);
    AppMethodBeat.o(199681);
  }
  
  public static void eXV()
  {
    AppMethodBeat.i(199665);
    long l;
    if (FEM == 1)
    {
      l = System.currentTimeMillis() - FEI;
      FEK += l;
      FEJ = l + FEJ;
      AppMethodBeat.o(199665);
      return;
    }
    if (FEM == 2)
    {
      l = System.currentTimeMillis() - FEI;
      FEL += l;
      FEJ = l + FEJ;
    }
    AppMethodBeat.o(199665);
  }
  
  public static void report()
  {
    AppMethodBeat.i(199677);
    Object localObject1 = FEF;
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      if (((a)localObject3).mgw > 5) {}
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
      localObject3 = (Integer)FEG.get(Integer.valueOf(((a)localObject2).idx));
      if (localObject3 != null) {
        aD(((Number)localObject3).intValue(), ((a)localObject2).FEO / ((a)localObject2).mgw);
      }
    }
    if (FEJ > 0L)
    {
      aD(15, FEH[0]);
      aD(18, FEH[1]);
      aD(21, ((float)FEK / (float)FEJ * 100.0F));
      aD(24, ((float)FEL / (float)FEJ * 100.0F));
    }
    reset();
    AppMethodBeat.o(199677);
  }
  
  public static void reset()
  {
    a[] arrayOfa = FEF;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.FEO = 0L;
      locala.mgw = 0;
      i += 1;
    }
    j = FEH.length;
    i = 0;
    while (i < j)
    {
      FEH[i] = 0;
      i += 1;
    }
    FEI = 0L;
    FEJ = 0L;
    FEL = 0L;
    FEK = 0L;
    FEM = 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
  public static final class a
  {
    long FEO;
    final int idx;
    int mgw;
    
    public a(int paramInt)
    {
      this.idx = paramInt;
      this.FEO = 0L;
      this.mgw = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.idx != paramObject.idx) || (this.FEO != paramObject.FEO) || (this.mgw != paramObject.mgw)) {}
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
      long l = this.FEO;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.mgw;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199638);
      String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.FEO + ", times=" + this.mgw + ")";
      AppMethodBeat.o(199638);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.d
 * JD-Core Version:    0.7.0.1
 */