package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static final f<Integer, Long> qsf = new com.tencent.mm.b.h(50);
  private static boolean wSU = false;
  private static int wSW = 1;
  private StringBuffer wSV = new StringBuffer();
  
  public static List<String> arA(String paramString)
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
      ac.printErrStackTrace("MicroMsg.AbsReportStruct", paramString, "check to report list error [%s]", new Object[] { paramString.toString() });
      localArrayList1 = null;
    }
  }
  
  public static int dyH()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(bs.eWj()).append("_");
    i = wSW;
    wSW = i + 1;
    return Math.abs(i.hashCode());
  }
  
  protected static boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (bs.getInt(paramString, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void iJ(String paramString1, String paramString2)
  {
    ac.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
    this.wSV.append(paramString1).append(":").append(paramString2).append("\r\n");
  }
  
  public static void pO(boolean paramBoolean)
  {
    wSU = paramBoolean;
  }
  
  public static String u(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      ac.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
  
  public abstract String PR();
  
  public abstract String PS();
  
  public final boolean aHZ()
  {
    int i = getId();
    String str = PR();
    ac.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), PR() });
    if ((i > 0) && (!bs.isNullOrNil(str)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(getId(), PR());
      if (wSU) {
        k.dyU().an(PR(), PS(), "\r\n\r\n error:\r\n" + this.wSV.toString());
      }
      return true;
    }
    return false;
  }
  
  protected final boolean arz(String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      iJ("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      iJ("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  protected final boolean bc(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      iJ(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      iJ(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bd(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      iJ(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean be(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      iJ(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean dyF()
  {
    int i = getId();
    Object localObject = PR();
    ac.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), PR() });
    if ((i > 0) && (!bs.isNullOrNil((String)localObject)))
    {
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      com.tencent.mm.plugin.report.service.h.c(getId(), PR(), false, true);
      if (wSU) {
        k.dyU().an(PR(), PS(), "\r\n\r\n error:\r\n" + this.wSV.toString());
      }
      return true;
    }
    return false;
  }
  
  public final boolean dyG()
  {
    int i = getId();
    String str = PR();
    Long localLong;
    if ((i > 0) && (!bs.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)qsf.get(Integer.valueOf(i));
      if (localLong == null) {
        break label139;
      }
    }
    label139:
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bs.Ap(l) < 300000L)
      {
        ac.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        return false;
      }
      qsf.put(Integer.valueOf(i), Long.valueOf(bs.eWj()));
      return aHZ();
      return false;
    }
  }
  
  public abstract int getId();
  
  public final String t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bs.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((paramBoolean) && ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))) {
      Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2, false);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      iJ(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */