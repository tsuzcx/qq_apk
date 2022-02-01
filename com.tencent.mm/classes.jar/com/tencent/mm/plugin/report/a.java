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
  private static int OyV = 1;
  private static final f<Integer, Long> zNn = new com.tencent.mm.b.h(50);
  
  public static List<String> aUn(String paramString)
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
  
  private boolean gNF()
  {
    boolean bool2 = false;
    int i = getId();
    Log.d("MicroMsg.AbsReportStruct", "reportWithAccountReady %d %s", new Object[] { Integer.valueOf(getId()), aIF() });
    String str = aIE();
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (!Util.isNullOrNil(str)) {
        bool1 = com.tencent.mm.plugin.report.service.h.OAn.cH(getId(), str);
      }
    }
    return bool1;
  }
  
  public static int gNH()
  {
    int i = Process.myPid();
    StringBuilder localStringBuilder = new StringBuilder().append(i).append("_").append(Util.nowMilliSecond()).append("_");
    i = OyV;
    OyV = i + 1;
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
  
  private void lB(String paramString1, String paramString2)
  {
    Log.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[] { Integer.valueOf(getId()), paramString1, paramString2 });
  }
  
  public final String F(String paramString1, String paramString2, boolean paramBoolean)
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
      lB(paramString1, "value contain comma, please confirm your logic. value :".concat(String.valueOf(paramString2)));
    }
  }
  
  public abstract String aIE();
  
  public abstract String aIF();
  
  protected final boolean aUm(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      lB("", "check rpt value is null.");
      return false;
    }
    if (paramString.length() >= 7168)
    {
      lB("", "check rpt value more than 7k.");
      return false;
    }
    return true;
  }
  
  public final boolean bMH()
  {
    int i = getId();
    Log.d("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), aIF() });
    String str = aIE();
    if ((i > 0) && (!Util.isNullOrNil(str)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(getId(), str);
      return true;
    }
    return false;
  }
  
  protected final boolean bw(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      lB(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600000L)
    {
      lB(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean bx(String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      lB(paramString, String.valueOf(paramLong));
      return false;
    }
    if (paramLong >= 3600L)
    {
      lB(paramString, String.valueOf(paramLong));
      return false;
    }
    return true;
  }
  
  protected final boolean by(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600000L)
    {
      bool = false;
      lB(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  protected final boolean bz(String paramString, long paramLong)
  {
    boolean bool = true;
    if (paramLong <= 151473600L)
    {
      bool = false;
      lB(paramString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public final boolean gNE()
  {
    int i = getId();
    Log.d("MicroMsg.AbsReportStruct", "report %d %s", new Object[] { Integer.valueOf(getId()), aIF() });
    String str = aIE();
    if ((i > 0) && (!Util.isNullOrNil(str)))
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      com.tencent.mm.plugin.report.service.h.d(getId(), str, false, true);
      return true;
    }
    return false;
  }
  
  public final boolean gNG()
  {
    int i = getId();
    String str = aIE();
    Long localLong;
    if ((i > 0) && (!Util.isNullOrNil(str)))
    {
      str = i + "," + str;
      i = str.hashCode();
      localLong = (Long)zNn.get(Integer.valueOf(i));
      if (localLong == null) {
        break label156;
      }
    }
    label156:
    for (long l = localLong.longValue();; l = 0L)
    {
      boolean bool1;
      if (Util.milliSecondsToNow(l) < 300000L)
      {
        Log.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", new Object[] { str });
        bool1 = false;
      }
      boolean bool2;
      do
      {
        return bool1;
        bool2 = gNF();
        bool1 = bool2;
      } while (!bool2);
      zNn.put(Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond()));
      return bool2;
      return false;
    }
  }
  
  public abstract int getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a
 * JD-Core Version:    0.7.0.1
 */