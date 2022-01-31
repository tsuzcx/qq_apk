package com.tencent.mm.plugin.report;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public abstract class a
{
  private static boolean nEB = false;
  private StringBuffer nEC = new StringBuffer();
  
  private void ey(String paramString1, String paramString2)
  {
    y.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
    this.nEC.append(paramString1).append(":").append(paramString2).append("\r\n");
  }
  
  public static void iu(boolean paramBoolean)
  {
    nEB = paramBoolean;
  }
  
  public static String n(Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0)
    {
      y.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
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
  
  public final boolean LT(String paramString)
  {
    if (bk.bl(paramString))
    {
      ey("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      ey("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  public final boolean QX()
  {
    int i = getId();
    Object localObject = uI();
    y.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), uI() });
    if ((i > 0) && (!bk.bl((String)localObject)))
    {
      h.nFQ.aC(getId(), uI());
      if (nEB)
      {
        localObject = j.bxa();
        String str1 = uI();
        String str2 = uJ();
        String str3 = "\r\n\r\n error:\r\n" + this.nEC.toString();
        if ((((j)localObject).nEB) && (((j)localObject).nGj != null))
        {
          y.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", new Object[] { str1, str2, str3 });
          ((j)localObject).nGj.put(ad.bB(str1), str2 + str3);
        }
      }
      return true;
    }
    return false;
  }
  
  public final boolean af(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      ey(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      ey(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  public final boolean ag(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      ey(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean ah(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      ey(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public abstract int getId();
  
  public abstract String uI();
  
  public abstract String uJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */