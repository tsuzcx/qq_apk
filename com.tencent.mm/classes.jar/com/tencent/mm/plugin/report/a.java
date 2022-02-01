package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a
{
  private static final f<Integer, Long> pJy = new com.tencent.mm.b.h(50);
  private static boolean vIQ = false;
  private static int vIS = 1;
  private StringBuffer vIR = new StringBuffer();
  
  public static List<String> amt(String paramString)
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
  
  public static int dkE()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(bt.eGO()).append("_");
    i = vIS;
    vIS = i + 1;
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
  
  private void ip(String paramString1, String paramString2)
  {
    ad.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
    this.vIR.append(paramString1).append(":").append(paramString2).append("\r\n");
  }
  
  public static void oQ(boolean paramBoolean)
  {
    vIQ = paramBoolean;
  }
  
  public static String s(Object... paramVarArgs)
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
  
  public abstract String PV();
  
  public abstract String PW();
  
  public final boolean aBj()
  {
    int i = getId();
    String str = PV();
    ad.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), PV() });
    if ((i > 0) && (!bt.isNullOrNil(str)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(getId(), PV());
      if (vIQ) {
        k.dkR().am(PV(), PW(), "\r\n\r\n error:\r\n" + this.vIR.toString());
      }
      return true;
    }
    return false;
  }
  
  protected final boolean ams(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      ip("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      ip("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  protected final boolean ba(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      ip(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      ip(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bb(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      ip(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean bc(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      ip(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean dkD()
  {
    int i = getId();
    String str = PV();
    Long localLong;
    if ((i > 0) && (!bt.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)pJy.get(Integer.valueOf(i));
      if (localLong == null) {
        break label138;
      }
    }
    label138:
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bt.vM(l) < 300000L)
      {
        ad.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        return false;
      }
      pJy.put(Integer.valueOf(i), Long.valueOf(bt.eGO()));
      return aBj();
      return false;
    }
  }
  
  public final boolean fYy()
  {
    int i = getId();
    Object localObject = PV();
    ad.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), PV() });
    if ((i > 0) && (!bt.isNullOrNil((String)localObject)))
    {
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      com.tencent.mm.plugin.report.service.h.c(getId(), PV(), false, true);
      if (vIQ) {
        k.dkR().am(PV(), PW(), "\r\n\r\n error:\r\n" + this.vIR.toString());
      }
      return true;
    }
    return false;
  }
  
  public abstract int getId();
  
  public final String t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bt.isNullOrNil(paramString2)) {}
    while (!paramString2.contains(",")) {
      return paramString2;
    }
    if ((paramBoolean) && ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))) {
      Assert.assertTrue("value contain comma, please confirm your logic.log id:" + getId() + " field:" + paramString1 + " value:" + paramString2, false);
    }
    for (;;)
    {
      return paramString2.replace(',', ' ');
      ip(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */