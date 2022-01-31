package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static boolean qrC = false;
  private static int qrE = 1;
  private StringBuffer qrD = new StringBuffer();
  
  public static List<String> Yq(String paramString)
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
      ab.printErrStackTrace("MicroMsg.AbsReportStruct", paramString, "check to report list error [%s]", new Object[] { paramString.toString() });
      localArrayList1 = null;
    }
  }
  
  public static int chG()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(bo.aoy()).append("_");
    i = qrE;
    qrE = i + 1;
    return Math.abs(i.hashCode());
  }
  
  private void fZ(String paramString1, String paramString2)
  {
    ab.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
    this.qrD.append(paramString1).append(":").append(paramString2).append("\r\n");
  }
  
  protected static boolean getBoolean(String paramString)
  {
    boolean bool = false;
    if (bo.getInt(paramString, 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void ky(boolean paramBoolean)
  {
    qrC = paramBoolean;
  }
  
  public static String s(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      ab.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
  
  public abstract String Ff();
  
  public abstract String Fg();
  
  protected final boolean Yp(String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      fZ("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      fZ("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  protected final boolean aA(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      fZ(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean ake()
  {
    int i = getId();
    String str = Ff();
    ab.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), Ff() });
    if ((i > 0) && (!bo.isNullOrNil(str)))
    {
      h.qsU.kvStat(getId(), Ff());
      if (qrC) {
        j.chT().ad(Ff(), Fg(), "\r\n\r\n error:\r\n" + this.qrD.toString());
      }
      return true;
    }
    return false;
  }
  
  protected final boolean ay(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      fZ(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      fZ(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean az(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      fZ(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public abstract int getId();
  
  protected final String t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bo.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((paramBoolean) && ((f.DEBUG) || (f.IS_FLAVOR_RED))) {
      Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2, false);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      fZ(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */