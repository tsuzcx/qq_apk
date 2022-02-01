package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static final f<Integer, Long> rbH = new h(50);
  private static int ygB = 1;
  
  public static List<String> awA(String paramString)
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
      ad.printErrStackTrace("MicroMsg.AbsReportStruct", paramString, "check to report list error [%s]", new Object[] { paramString.toString() });
      localArrayList1 = null;
    }
  }
  
  public static int dJZ()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(bt.flT()).append("_");
    i = ygB;
    ygB = i + 1;
    return Math.abs(i.hashCode());
  }
  
  protected static boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (bt.getInt(paramString, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void iW(String paramString1, String paramString2)
  {
    ad.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
  }
  
  public static String u(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      ad.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
  
  public abstract String RD();
  
  public abstract String RE();
  
  public final boolean aLk()
  {
    int i = getId();
    String str = RD();
    ad.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), RD() });
    if ((i > 0) && (!bt.isNullOrNil(str)))
    {
      g.yhR.kvStat(getId(), RD());
      return true;
    }
    return false;
  }
  
  protected final boolean awz(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      iW("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      iW("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  protected final boolean bf(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      iW(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      iW(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bg(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      iW(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean bh(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      iW(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean dJX()
  {
    int i = getId();
    Object localObject = RD();
    ad.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), RD() });
    if ((i > 0) && (!bt.isNullOrNil((String)localObject)))
    {
      localObject = g.yhR;
      g.c(getId(), RD(), false, true);
      return true;
    }
    return false;
  }
  
  public final boolean dJY()
  {
    int i = getId();
    String str = RD();
    Long localLong;
    if ((i > 0) && (!bt.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)rbH.get(Integer.valueOf(i));
      if (localLong == null) {
        break label138;
      }
    }
    label138:
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bt.Df(l) < 300000L)
      {
        ad.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        return false;
      }
      rbH.put(Integer.valueOf(i), Long.valueOf(bt.flT()));
      return aLk();
      return false;
    }
  }
  
  public abstract int getId();
  
  public final String t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bt.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((paramBoolean) && ((i.DEBUG) || (i.IS_FLAVOR_RED))) {
      Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2, false);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      iW(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */