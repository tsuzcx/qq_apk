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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"})
public final class d
{
  private static final a[] zYS;
  private static final Map<Integer, Integer> zYT;
  private static final int[] zYU;
  private static long zYV;
  private static long zYW;
  private static long zYX;
  private static long zYY;
  private static int zYZ;
  public static final d zZa;
  
  static
  {
    AppMethodBeat.i(240097);
    zZa = new d();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a(i);
      i += 1;
    }
    zYS = arrayOfa;
    zYT = ae.e(new o[] { s.U(Integer.valueOf(0), Integer.valueOf(0)), s.U(Integer.valueOf(1), Integer.valueOf(3)), s.U(Integer.valueOf(2), Integer.valueOf(6)), s.U(Integer.valueOf(3), Integer.valueOf(9)), s.U(Integer.valueOf(4), Integer.valueOf(12)) });
    zYU = new int[2];
    AppMethodBeat.o(240097);
  }
  
  public static void RC(int paramInt)
  {
    AppMethodBeat.i(240093);
    if (zYZ == 0) {
      zYV = System.currentTimeMillis();
    }
    long l;
    if (paramInt != zYZ)
    {
      if (paramInt != 1) {
        break label73;
      }
      RD(0);
      l = System.currentTimeMillis() - zYV;
      zYX += l;
      zYW = l + zYW;
    }
    for (;;)
    {
      zYV = System.currentTimeMillis();
      zYZ = paramInt;
      AppMethodBeat.o(240093);
      return;
      label73:
      if (paramInt == 2)
      {
        RD(1);
        l = System.currentTimeMillis() - zYV;
        zYY += l;
        zYW = l + zYW;
      }
    }
  }
  
  private static void RD(int paramInt)
  {
    int[] arrayOfInt = zYU;
    arrayOfInt[paramInt] += 1;
  }
  
  public static void append(int paramInt, long paramLong)
  {
    a locala = zYS[paramInt];
    locala.hjI += 1;
    locala.zZb += paramLong;
  }
  
  private static void au(int paramInt, long paramLong)
  {
    AppMethodBeat.i(240096);
    Log.i("MultitalkReportHelper", "report avg key: " + paramInt + " value: " + paramLong);
    h.CyF.b(1438, paramInt, paramInt + 1, (int)paramLong, false);
    AppMethodBeat.o(240096);
  }
  
  public static void eof()
  {
    AppMethodBeat.i(240094);
    long l;
    if (zYZ == 1)
    {
      l = System.currentTimeMillis() - zYV;
      zYX += l;
      zYW = l + zYW;
      AppMethodBeat.o(240094);
      return;
    }
    if (zYZ == 2)
    {
      l = System.currentTimeMillis() - zYV;
      zYY += l;
      zYW = l + zYW;
    }
    AppMethodBeat.o(240094);
  }
  
  public static void report()
  {
    AppMethodBeat.i(240095);
    Object localObject1 = zYS;
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      if (((a)localObject3).hjI > 5) {}
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
      localObject3 = (Integer)zYT.get(Integer.valueOf(((a)localObject2).idx));
      if (localObject3 != null) {
        au(((Number)localObject3).intValue(), ((a)localObject2).zZb / ((a)localObject2).hjI);
      }
    }
    if (zYW > 0L)
    {
      au(15, zYU[0]);
      au(18, zYU[1]);
      au(21, ((float)zYX / (float)zYW * 100.0F));
      au(24, ((float)zYY / (float)zYW * 100.0F));
    }
    reset();
    AppMethodBeat.o(240095);
  }
  
  public static void reset()
  {
    a[] arrayOfa = zYS;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.zZb = 0L;
      locala.hjI = 0;
      i += 1;
    }
    j = zYU.length;
    i = 0;
    while (i < j)
    {
      zYU[i] = 0;
      i += 1;
    }
    zYV = 0L;
    zYW = 0L;
    zYY = 0L;
    zYX = 0L;
    zYZ = 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
  public static final class a
  {
    int hjI;
    final int idx;
    long zZb;
    
    public a(int paramInt)
    {
      this.idx = paramInt;
      this.zZb = 0L;
      this.hjI = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.idx != paramObject.idx) || (this.zZb != paramObject.zZb) || (this.hjI != paramObject.hjI)) {}
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
      long l = this.zZb;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.hjI;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(240092);
      String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.zZb + ", times=" + this.hjI + ")";
      AppMethodBeat.o(240092);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.d
 * JD-Core Version:    0.7.0.1
 */