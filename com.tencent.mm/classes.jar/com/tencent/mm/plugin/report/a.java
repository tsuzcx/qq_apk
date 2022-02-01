package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static final f<Integer, Long> rjN = new h(50);
  private static int yws = 1;
  
  public static List<String> axP(String paramString)
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
      ae.printErrStackTrace("MicroMsg.AbsReportStruct", paramString, "check to report list error [%s]", new Object[] { paramString.toString() });
      localArrayList1 = null;
    }
  }
  
  public static int dNr()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(bu.fpO()).append("_");
    i = yws;
    yws = i + 1;
    return Math.abs(i.hashCode());
  }
  
  protected static boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (bu.getInt(paramString, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void jc(String paramString1, String paramString2)
  {
    ae.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
  }
  
  public static String t(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      ae.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
  
  public abstract String RC();
  
  public abstract String RD();
  
  public final boolean aLH()
  {
    int i = getId();
    String str = RC();
    ae.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), RC() });
    if ((i > 0) && (!bu.isNullOrNil(str)))
    {
      g.yxI.kvStat(getId(), RC());
      return true;
    }
    return false;
  }
  
  protected final boolean axO(String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      jc("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      jc("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  protected final boolean bg(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      jc(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      jc(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bh(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      jc(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean bi(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      jc(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean dNp()
  {
    int i = getId();
    Object localObject = RC();
    ae.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), RC() });
    if ((i > 0) && (!bu.isNullOrNil((String)localObject)))
    {
      localObject = g.yxI;
      g.c(getId(), RC(), false, true);
      return true;
    }
    return false;
  }
  
  public final boolean dNq()
  {
    int i = getId();
    String str = RC();
    Long localLong;
    if ((i > 0) && (!bu.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)rjN.get(Integer.valueOf(i));
      if (localLong == null) {
        break label138;
      }
    }
    label138:
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bu.DD(l) < 300000L)
      {
        ae.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        return false;
      }
      rjN.put(Integer.valueOf(i), Long.valueOf(bu.fpO()));
      return aLH();
      return false;
    }
  }
  
  public abstract int getId();
  
  public final String t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bu.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((paramBoolean) && ((j.DEBUG) || (j.IS_FLAVOR_RED))) {
      Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2, false);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      jc(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */