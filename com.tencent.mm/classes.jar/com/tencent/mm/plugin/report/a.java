package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static int Cxo = 1;
  private static final f<Integer, Long> sLp = new com.tencent.mm.b.h(50);
  
  public static List<String> aMr(String paramString)
  {
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      int j = (int)Math.ceil(paramString.length() / 5120.0D);
      int i = 0;
      ArrayList localArrayList1;
      for (;;)
      {
        localArrayList1 = localArrayList2;
        if (i >= j) {
          break;
        }
        localArrayList2.add(paramString.substring(i * 5120, Math.min((i + 1) * 5120, paramString.length())));
        i += 1;
      }
      return localArrayList1;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AbsReportStruct", paramString, "check to report list error [%s]", new Object[] { paramString.toString() });
      localArrayList1 = null;
    }
  }
  
  public static int eOr()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(Util.nowMilliSecond()).append("_");
    i = Cxo;
    Cxo = i + 1;
    return Math.abs(i.hashCode());
  }
  
  protected static boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (Util.getInt(paramString, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String t(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      Log.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  protected final boolean aMq(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      jN("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      jN("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  public abstract String abV();
  
  public abstract String abW();
  
  public final boolean bfK()
  {
    int i = getId();
    String str = abV();
    Log.d("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), abV() });
    if ((i > 0) && (!Util.isNullOrNil(str)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(getId(), abV());
      return true;
    }
    return false;
  }
  
  protected final boolean bi(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      jN(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      jN(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bj(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      jN(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean bk(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      jN(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean eOp()
  {
    int i = getId();
    Object localObject = abV();
    Log.d("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), abV() });
    if ((i > 0) && (!Util.isNullOrNil((String)localObject)))
    {
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      com.tencent.mm.plugin.report.service.h.c(getId(), abV(), false, true);
      return true;
    }
    return false;
  }
  
  public final boolean eOq()
  {
    int i = getId();
    String str = abV();
    Long localLong;
    if ((i > 0) && (!Util.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)sLp.get(Integer.valueOf(i));
      if (localLong == null) {
        break label138;
      }
    }
    label138:
    for (long l = localLong.longValue();; l = 0L)
    {
      if (Util.milliSecondsToNow(l) < 300000L)
      {
        Log.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        return false;
      }
      sLp.put(Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond()));
      return bfK();
      return false;
    }
  }
  
  public abstract int getId();
  
  protected final void jN(String paramString1, String paramString2)
  {
    Log.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
  }
  
  public final String x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (Util.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((!WeChatSomeFeatureSwitch.blockCNMobile()) && (paramBoolean) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))) {
      Assert.fail("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      jN(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */