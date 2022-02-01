package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.l;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"})
public final class d
{
  private static final a[] wxd;
  private static final Map<Integer, Integer> wxe;
  private static final int[] wxf;
  private static long wxg;
  private static long wxh;
  private static long wxi;
  private static long wxj;
  private static int wxk;
  public static final d wxl;
  
  static
  {
    AppMethodBeat.i(191040);
    wxl = new d();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a(i);
      i += 1;
    }
    wxd = arrayOfa;
    wxe = d.a.ae.a(new o[] { u.R(Integer.valueOf(0), Integer.valueOf(0)), u.R(Integer.valueOf(1), Integer.valueOf(3)), u.R(Integer.valueOf(2), Integer.valueOf(6)), u.R(Integer.valueOf(3), Integer.valueOf(9)), u.R(Integer.valueOf(4), Integer.valueOf(12)) });
    wxf = new int[2];
    AppMethodBeat.o(191040);
  }
  
  public static void Lt(int paramInt)
  {
    AppMethodBeat.i(191036);
    if (wxk == 0) {
      wxg = System.currentTimeMillis();
    }
    long l;
    if (paramInt != wxk)
    {
      if (paramInt != 1) {
        break label73;
      }
      Lu(0);
      l = System.currentTimeMillis() - wxg;
      wxi += l;
      wxh = l + wxh;
    }
    for (;;)
    {
      wxg = System.currentTimeMillis();
      wxk = paramInt;
      AppMethodBeat.o(191036);
      return;
      label73:
      if (paramInt == 2)
      {
        Lu(1);
        l = System.currentTimeMillis() - wxg;
        wxj += l;
        wxh = l + wxh;
      }
    }
  }
  
  private static void Lu(int paramInt)
  {
    int[] arrayOfInt = wxf;
    arrayOfInt[paramInt] += 1;
  }
  
  private static void ao(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191039);
    com.tencent.mm.sdk.platformtools.ae.i("MultitalkReportHelper", "report avg key: " + paramInt + " value: " + paramLong);
    g.yxI.c(1438, paramInt, paramInt + 1, (int)paramLong, false);
    AppMethodBeat.o(191039);
  }
  
  public static void append(int paramInt, long paramLong)
  {
    a locala = wxd[paramInt];
    locala.gwU += 1;
    locala.wxm += paramLong;
  }
  
  public static void dtD()
  {
    AppMethodBeat.i(191037);
    long l;
    if (wxk == 1)
    {
      l = System.currentTimeMillis() - wxg;
      wxi += l;
      wxh = l + wxh;
      AppMethodBeat.o(191037);
      return;
    }
    if (wxk == 2)
    {
      l = System.currentTimeMillis() - wxg;
      wxj += l;
      wxh = l + wxh;
    }
    AppMethodBeat.o(191037);
  }
  
  public static void report()
  {
    AppMethodBeat.i(191038);
    Object localObject1 = wxd;
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      if (((a)localObject3).gwU > 5) {}
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
      localObject3 = (Integer)wxe.get(Integer.valueOf(((a)localObject2).idx));
      if (localObject3 != null) {
        ao(((Number)localObject3).intValue(), ((a)localObject2).wxm / ((a)localObject2).gwU);
      }
    }
    if (wxh > 0L)
    {
      ao(15, wxf[0]);
      ao(18, wxf[1]);
      ao(21, ((float)wxi / (float)wxh * 100.0F));
      ao(24, ((float)wxj / (float)wxh * 100.0F));
    }
    reset();
    AppMethodBeat.o(191038);
  }
  
  public static void reset()
  {
    a[] arrayOfa = wxd;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.wxm = 0L;
      locala.gwU = 0;
      i += 1;
    }
    j = wxf.length;
    i = 0;
    while (i < j)
    {
      wxf[i] = 0;
      i += 1;
    }
    wxg = 0L;
    wxh = 0L;
    wxj = 0L;
    wxi = 0L;
    wxk = 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
  public static final class a
  {
    int gwU;
    final int idx;
    long wxm;
    
    public a(int paramInt)
    {
      this.idx = paramInt;
      this.wxm = 0L;
      this.gwU = 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.idx != paramObject.idx) || (this.wxm != paramObject.wxm) || (this.gwU != paramObject.gwU)) {}
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
      long l = this.wxm;
      return (i * 31 + (int)(l ^ l >>> 32)) * 31 + this.gwU;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191035);
      String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.wxm + ", times=" + this.gwU + ")";
      AppMethodBeat.o(191035);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.d
 * JD-Core Version:    0.7.0.1
 */