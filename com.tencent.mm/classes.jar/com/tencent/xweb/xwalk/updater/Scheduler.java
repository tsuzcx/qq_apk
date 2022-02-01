package com.tencent.xweb.xwalk.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public abstract class Scheduler
{
  public static boolean SIT = false;
  static boolean SIU = false;
  c SIV;
  protected String TAG = hvc() + "Scheduler";
  
  public static XWebCoreScheduler Ev(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localXWebCoreScheduler = i.hvV();
        return localXWebCoreScheduler;
      }
      finally {}
      XWebCoreScheduler localXWebCoreScheduler = XWebCoreScheduler.hvW();
    }
  }
  
  public static double J(double paramDouble)
  {
    double d;
    if (paramDouble >= 0.0D)
    {
      d = paramDouble;
      if (paramDouble <= 24.0D) {}
    }
    else
    {
      d = 0.0D;
    }
    return d;
  }
  
  private static boolean OZ(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble1 > paramDouble3) || (paramDouble3 < paramDouble2))
    {
      Log.e("Scheduler", "srandTime cur hour is bigger than endhour ");
      return 0.0D;
    }
    if (paramDouble2 < paramDouble1) {}
    for (;;)
    {
      return Math.random() * (paramDouble3 - paramDouble1) + paramDouble1;
      paramDouble1 = paramDouble2;
    }
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, List<a> paramList)
  {
    paramList = paramList.iterator();
    double d1 = 0.0D;
    if (paramList.hasNext())
    {
      double d2 = ((a)paramList.next()).u(paramDouble1, paramDouble2) * paramDouble3;
      if (d2 <= d1) {
        break label60;
      }
      d1 = d2;
    }
    label60:
    for (;;)
    {
      break;
      return d1;
    }
  }
  
  public static long a(a.a parama, String paramString)
  {
    long l1 = 0L;
    if (!TextUtils.isEmpty(parama.SIz))
    {
      l1 = b(parama, paramString);
      XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.SIC > 0)
    {
      long l2 = parama.SIC * 60 * 1000;
      if (0L == l2)
      {
        XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.SCE.SCU > 0) && (parama.SCE.SCU <= 10000))
      {
        i = parama.SCE.SCU;
        label174:
        if ((parama.SCE.SCV <= 0) || (parama.SCE.SCV > 10000)) {
          break label280;
        }
      }
      label280:
      for (int j = parama.SCE.SCV;; j = 10000)
      {
        int k = j - i + 1;
        j = k;
        if (k <= 0) {
          j = 1;
        }
        double d = (XWalkEnvironment.getGrayValue() - i) * l2 / j;
        l1 = ((l2 * (XWalkEnvironment.getGrayValue() + 1 - i) / j - d) * Math.random() + d);
        break;
        i = 0;
        break label174;
      }
    }
    XWalkInitializer.addXWalkInitializeLog(paramString + " no schedule time");
    return 100L;
  }
  
  private void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = paramInt;
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduler update time after " + paramInt * 7200000L / 60000L + " minute");
      paramEditor.putLong("nTimeToUpdate", l1 + l2 * 7200000L);
      return;
    }
    finally {}
  }
  
  private boolean a(long paramLong, double paramDouble)
  {
    double d1 = e.htS();
    double d2 = e.OP(paramLong);
    SIU = false;
    Object localObject = hvL();
    if (SIU)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
      h.s(903L, hvd() + 163, 1L);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.b(d1, d2, paramDouble))
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "matched timerange zone cur time is " + d1 + " scheduleHour is " + d2 + "time range is " + locala.v(d1, d2));
        return true;
      }
    }
    return false;
  }
  
  private boolean aK(long paramLong1, long paramLong2)
  {
    long l = hvH();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2)) {
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "the most recent time to fetch config is too close");
    return false;
  }
  
  private static long b(a.a parama, String paramString)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (TextUtils.isEmpty(parama.SIz))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parama.SIA)) {
        break label469;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parama.SIA);
      paramString = (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog(paramString, " parse version release date failed " + localException.getMessage());
        h.s(903L, 158L, 1L);
        paramString = (String)localObject2;
      }
      if ((parama.SCE.SCU <= 0) || (parama.SCE.SCU > 10000)) {
        break label591;
      }
      int j = parama.SCE.SCU;
      if ((parama.SCE.SCV <= 0) || (parama.SCE.SCV > 10000)) {
        break label597;
      }
      for (k = parama.SCE.SCV;; k = 10000)
      {
        d1 = (XWalkEnvironment.getGrayValue() - j) * 10000.0D / (k - j + 1);
        j = 0;
        while ((j < localObject1.length) && (d1 > localObject1[j])) {
          j += 1;
        }
        j = 0;
        break;
      }
      Calendar.getInstance();
      d1 = e.htS();
      d2 = J(parama.SIx);
      d3 = s(parama.SIx, parama.SIy);
      j -= i;
      i = j;
      if (j > 0) {
        break label679;
      }
      if ((!parama.SIF) || (d1 <= d2)) {
        break label709;
      }
      Log.i("Scheduler", "low priority version. schedule to next day to update");
      i = 1;
      return (a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.htR());
    }
    double d1 = (new Date().getTime() - paramString.getTime()) / 86400000.0D;
    j = (int)d1;
    int i = j;
    if (d1 < 0.0D) {
      i = j - 1;
    }
    if (Math.abs(d1) > 365.0D) {
      i = 0;
    }
    for (;;)
    {
      int k;
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        return 0L;
        localObject2 = new ArrayList();
        localObject1 = parama.SIz.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.bsD((String)localObject3);
              if (!((e.a)localObject3).SEF) {
                break label273;
              }
              k = ((e.a)localObject3).intValue();
              if ((k >= 0) && (k <= 10000)) {
                ((List)localObject2).add(localObject3);
              }
            }
            else
            {
              i += 1;
              continue;
            }
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parama.SIz);
            localObject1 = null;
            break;
            label273:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parama.SIz);
            localObject1 = null;
            break;
          }
        }
        if (((List)localObject2).size() == 0)
        {
          localObject1 = null;
          break;
        }
        localObject1 = new int[((List)localObject2).size()];
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject2).size()) {
            break label429;
          }
          j = ((e.a)((List)localObject2).get(i)).intValue();
          if ((i > 0) && (j < localObject1[(i - 1)]))
          {
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parama.SIz);
            localObject1 = null;
            break;
          }
          localObject1[i] = j;
          i += 1;
        }
        label429:
        break;
      }
      label469:
      double d2;
      label591:
      label597:
      double d3;
      label679:
      label709:
      while (d1 >= d3) {
        i = 1;
      }
      return ((a(d1, d2, d3) - d1) * 3600000.0D);
    }
  }
  
  public static double bsT(String paramString)
  {
    return e(paramString, e.htS());
  }
  
  private static a bsU(String paramString)
  {
    a locala = new a();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().replace("=>", "_").split("_");
    if ((paramString == null) || (paramString.length != 2))
    {
      Log.e("getTimeRangePairItem", "strRanges error");
      return null;
    }
    locala.SIX = com.tencent.xweb.internal.i.bsy(paramString[0]);
    if (locala.SIX == null)
    {
      Log.e("getTimeRangePairItem", "parse rangefrom failed");
      return null;
    }
    locala.SIY = com.tencent.xweb.internal.i.bsy(paramString[1]);
    if (locala.SIY == null)
    {
      Log.e("getTimeRangePairItem", "parse rangeTo failed");
      return null;
    }
    return locala;
  }
  
  private static String[] bsV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split(";");
  }
  
  public static double e(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 1.0D;
      paramString = bsV(paramString);
      if ((paramString == null) || (paramString.length == 0))
      {
        SIU = true;
        return 1.0D;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = com.tencent.xweb.internal.i.bsy((String)localObject);
          if ((localObject != null) && (paramDouble >= ((com.tencent.xweb.internal.i)localObject).SDM) && (paramDouble <= ((com.tencent.xweb.internal.i)localObject).SDN)) {
            return ((com.tencent.xweb.internal.i)localObject).H(paramDouble);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void hvD()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = Ev(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.hvF().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.hvJ().SJa = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void hvE()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = Ev(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.hvF().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.hvJ().SJa = 0L;
      localXWebCoreScheduler.hvJ().SJf = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private SharedPreferences hvF()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + hvc());
  }
  
  public static long hvH()
  {
    long l1 = a.hsb().av("force_cmd_period", "tools", 0) * 60000L;
    if (OZ(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkEnvironment.getConfigFetchPeriod();
        l1 = l2;
      } while (OZ(l2));
      l2 = a.hsg();
      l1 = l2;
    } while (OZ(l2));
    return 86400000L;
  }
  
  private String hvK()
  {
    if (!TextUtils.isEmpty(hvJ().SII)) {
      return hvJ().SII;
    }
    return hve();
  }
  
  private List<a> hvL()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = hvK();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      SIU = true;
      return localArrayList;
    }
    e.htS();
    int j = localObject1.length;
    int i = 0;
    label61:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = bsU((String)localObject2);
        if (localObject2 != null) {
          break label103;
        }
        SIU = true;
      }
    }
    for (;;)
    {
      i += 1;
      break label61;
      break;
      label103:
      localArrayList.add(localObject2);
    }
  }
  
  public static boolean hvQ()
  {
    Scheduler local2 = new Scheduler()
    {
      protected final String Eu(boolean paramAnonymousBoolean)
      {
        return "0:59-1:01-0.9;2:59-3:01-0.9;3:59-4:01-0.9;4:59-5:01-0.9;5:29-5:31-0.9;5:59-6:01-0.9;6:29-6:31-0.9;6:59-7:01-0.9;7:29-7:31-0.9;7:59-8:01-0.9;0:00-6:00(1.636806683-2.276643146-2.927125626-4.16300461-4.55588817-5.203755763-5.20765858-5.528990498-5.854745609-6.309553862-6.180110438-5.203755763-4.228129614);6:00-8:00(1.037712038-1.297503247-1.297140048-0.004150848);0-24-5";
      }
      
      public final String hvc()
      {
        return "UNITEST";
      }
      
      protected final String hve()
      {
        return "6:00-24:00(0.53871206-0.533307-0.53308-0.533309-0.53334-0.533011-0.533012-0.533013-0.533014-0.533015-0.533016-0.70017-0.723018-0.750019-0.7502-0.75021-0.753022-0.533023-0.533024) => 0:00-8:00(1)";
      }
    };
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 15, 0, 0, 0);
    List localList = local2.hvL();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(2020, 6, 15, 0, 58, 5);
    double d1 = e.d((Calendar)localObject1);
    a(d1, 21.0D, e(local2.Ex(false), d1) / 5.0D, localList);
    SIU = false;
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (double d2 = 0.0D; localCalendar.get(10) <= 8.0D; d2 = d1)
    {
      double d3 = e.d(localCalendar);
      double d4 = e(local2.Ex(false), d3) / 5.0D;
      Object localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).set(2020, 6, 15, 6, 30, 0);
      double d5;
      for (d1 = 0.0D; ((Calendar)localObject2).get(5) < 16; d1 = d5 * 10000.0D + d1)
      {
        d5 = a(d3, e.d((Calendar)localObject2), d4, localList);
        ((Calendar)localObject2).add(12, 30);
      }
      localObject2 = ((SimpleDateFormat)localObject1).format(localCalendar.getTime());
      if (d2 != 0.0D) {
        Math.abs((d1 - d2) / d2);
      }
      Log.e("andrewu", "rate\t" + d1 + "\ttime\t" + (String)localObject2);
      localCalendar.add(13, 1);
    }
    Log.e("andrewu", "sParseScheduleConfigFailed = " + SIU);
    return true;
  }
  
  protected static boolean ok(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return true;
      if (paramString1 != null) {
        break;
      }
    } while (paramString1 == paramString2);
    return false;
    return paramString1.equals(paramString2);
  }
  
  public static boolean r(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 0.0D) || (paramDouble1 > 24.0D)) {}
    while ((paramDouble2 < 0.0D) || (paramDouble2 > 24.0D) || (paramDouble2 < paramDouble1)) {
      return false;
    }
    return true;
  }
  
  public static double s(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 < paramDouble1) {
      paramDouble1 = 24.0D;
    }
    do
    {
      return paramDouble1;
      if (paramDouble2 < 0.0D) {
        break;
      }
      paramDouble1 = paramDouble2;
    } while (paramDouble2 <= 32.0D);
    return 24.0D;
  }
  
  private static boolean t(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) < 1.E-005D;
  }
  
  protected abstract String Eu(boolean paramBoolean);
  
  public boolean Ew(boolean paramBoolean)
  {
    try
    {
      paramBoolean = ah(paramBoolean, 0);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String Ex(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(hvJ().SIH))) {
      return hvJ().SIH;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(hvJ().SIG))) {
      return hvJ().SIG;
    }
    return Eu(paramBoolean);
  }
  
  protected boolean a(c paramc1, c paramc2)
  {
    if ((paramc1.version != paramc2.version) || (paramc1.SIE != paramc2.SIE) || (paramc1.bUseCdn != paramc2.bUseCdn) || (paramc1.SJc != paramc2.SJc) || (!ok(paramc1.SID, paramc2.SID)) || (!ok(paramc1.SJe, paramc2.SJe)) || (!ok(paramc1.strAbi, paramc2.strAbi)) || (paramc1.SIv != paramc2.SIv)) {}
    while ((paramc1.SJc) && (!ok(paramc1.patchMd5, paramc2.patchMd5))) {
      return false;
    }
    return true;
  }
  
  public boolean a(Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l3 = paramCalendar1.getTimeInMillis();
    long l1 = paramCalendar2.getTimeInMillis();
    long l2 = e.c(paramCalendar1);
    l3 = l2 + l3;
    boolean bool1;
    boolean bool2;
    if (l1 - 180000L < l3 - 86400000L)
    {
      bool1 = true;
      if (180000L + l1 <= l3) {
        break label112;
      }
      bool2 = true;
      label59:
      if ((l2 >= 180000L) && (180000L + l2 <= 86400000L)) {
        break label118;
      }
    }
    label112:
    label118:
    for (boolean bool3 = true;; bool3 = false)
    {
      if ((bool1 == paramBoolean1) && (bool2 == paramBoolean2) && (bool3 == paramBoolean3)) {
        break label124;
      }
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label59;
    }
    label124:
    return true;
  }
  
  public boolean ah(boolean paramBoolean, int paramInt)
  {
    if (paramInt > 2) {}
    for (;;)
    {
      label363:
      try
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate abort cause depth > 2");
        paramBoolean = false;
        return paramBoolean;
      }
      finally {}
      if (!hvz())
      {
        paramBoolean = false;
      }
      else if ((hvA()) || (SIT))
      {
        h.s(903L, hvd() + 157, 1L);
        paramBoolean = true;
      }
      else
      {
        Object localObject1 = a.nS("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = e.bsC((String)localObject1);
          if ((((e.a)localObject1).SEF) && (((e.a)localObject1).doubleValue() >= 0.0D) && (((e.a)localObject1).doubleValue() <= 24.0D)) {
            ((e.a)localObject1).doubleValue();
          }
        }
        long l2 = System.currentTimeMillis();
        double d1 = hvM();
        if (SIU)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
          h.s(903L, hvd() + 163, 1L);
        }
        double d2 = hvN();
        if (SIU)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
          h.s(903L, hvd() + 163, 1L);
        }
        long l1 = hvJ().SJf;
        int i = 0;
        long l3;
        long l4;
        int j;
        if (l1 <= 1000L)
        {
          if (!paramBoolean)
          {
            paramBoolean = true;
            continue;
          }
          l1 = (3600000.0D * Math.random());
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "not have schedule time ,just random a time in one hour");
          h.s(903L, hvd() + 155, 1L);
          l1 = l2 - l1;
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
          l3 = l2 - l1;
          l4 = e.htR();
          long l5 = l4 + l2;
          if (l1 - 180000L >= l5 - 86400000L) {
            break label911;
          }
          j = 1;
          break label842;
          if (i == 0)
          {
            Log.i(this.TAG, "has no scheduler , ignore dangers time ");
            if ((l3 < 0L) || (l3 > 3600000L)) {
              break label836;
            }
            bool = true;
            h.s(903L, hvd() + 154, 1L);
            break label885;
            label416:
            if ((l3 >= 0L) || (-l3 >= d2)) {
              break label828;
            }
            paramBoolean = true;
            h.s(903L, hvd() + 161, 1L);
            if ((bool) && (!paramBoolean)) {
              h.s(903L, hvd() + 150, 1L);
            }
            if ((!bool) && (paramBoolean)) {
              h.s(903L, hvd() + 151, 1L);
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
            if (paramBoolean)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
              h.s(903L, hvd() + 152, 1L);
              paramBoolean = true;
            }
          }
          else
          {
            if (j != 0)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day ");
              hvO();
              h.s(903L, 146L, 1L);
              paramBoolean = ah(false, paramInt + 1);
              continue;
            }
            if (k != 0)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now ");
              h.s(903L, 147L, 1L);
              paramBoolean = false;
              continue;
            }
            if (m == 0) {
              continue;
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
            h.s(903L, 148L, 1L);
            paramBoolean = false;
            continue;
          }
          if (hvC())
          {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
            h.s(903L, hvd() + 153, 1L);
            paramBoolean = true;
            continue;
          }
          if (a(l1, d1 / 18000000.0D))
          {
            h.s(903L, hvd() + 162, 1L);
            paramBoolean = true;
            continue;
          }
          if ((i != 0) && ((l2 - hvJ().SJf > 0L) || (Math.abs(l2 - hvJ().SJf) > 7776000000L)))
          {
            hvO();
            h.s(903L, hvd() + 156, 1L);
            break label929;
          }
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
          break label929;
          label828:
          continue;
          label831:
          paramBoolean = false;
          continue;
          label836:
          boolean bool = false;
          break label885;
          label842:
          if (180000L + l1 <= l5) {
            break label917;
          }
        }
        label911:
        label917:
        for (int k = 1;; k = 0)
        {
          if ((l4 >= 180000L) && (l4 + 180000L <= 86400000L)) {
            break label923;
          }
          m = 1;
          break label363;
          label885:
          if ((l3 < 0L) || (l3 >= d1)) {
            break label831;
          }
          paramBoolean = true;
          break label416;
          i = 1;
          break;
          j = 0;
          break label842;
        }
        label923:
        int m = 0;
        continue;
        label929:
        paramBoolean = false;
      }
    }
  }
  
  public void ati(int paramInt) {}
  
  public void atj(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = hvF();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      hvJ().SJi = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = hvF();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      hvJ().SJc = false;
      hvJ().SIw = hvJ().SJe;
      hvJ().SIE = false;
      e(hvJ());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
      hvw();
      return;
      i = j;
      if (paramInt <= -2)
      {
        i = j;
        if (paramInt >= -5) {
          i = (int)(j + 3L);
        }
      }
    }
    hvJ().SJh = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public c d(c paramc)
  {
    int j = 1;
    c localc = hvJ();
    if (paramc == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
      if (hvz())
      {
        if (localc != null) {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "clear current scheduler version = " + localc.version);
        }
        e(paramc);
      }
      return null;
    }
    int i;
    if (a(paramc, localc))
    {
      i = 0;
      if (!ok(paramc.SIG, localc.SIG))
      {
        localc.SIG = paramc.SIG;
        i = 1;
      }
      if (!ok(paramc.SIH, localc.SIH))
      {
        localc.SIH = paramc.SIH;
        i = 1;
      }
      if (ok(paramc.SII, localc.SII)) {
        break label233;
      }
      localc.SII = paramc.SII;
      i = j;
    }
    label233:
    for (;;)
    {
      if (i != 0) {
        e(localc);
      }
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got same version to scheduler, use last version ");
      return localc;
      if (hvz())
      {
        h.s(903L, 149L, 1L);
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "got new scheduler replace current , version is " + paramc.version);
      }
      e(paramc);
      return paramc;
    }
  }
  
  public void e(c paramc)
  {
    try
    {
      this.SIV = paramc;
      if (paramc == null) {
        this.SIV = new c();
      }
      this.SIV.SIZ = hvc();
      paramc = hvF().edit();
      paramc.putString("strMd5", this.SIV.SID);
      paramc.putString("strUrl", this.SIV.SIw);
      paramc.putString("strFullPackageUrl", this.SIV.SJe);
      paramc.putString("strConfigVer", this.SIV.SIJ);
      paramc.putBoolean("bIsPatchUpdate", this.SIV.SJc);
      paramc.putBoolean("bCanUseCellular", this.SIV.SIE);
      paramc.putBoolean("bUseCdn", this.SIV.bUseCdn);
      paramc.putLong("nTimeToUpdate", this.SIV.SJf);
      paramc.putInt("version", this.SIV.version);
      paramc.putInt("nTryCnt", this.SIV.SJh);
      paramc.putInt("nPatchTargetVersion", this.SIV.nPatchTargetVersion);
      paramc.putInt("nTryUseSharedCoreCount", this.SIV.SJi);
      paramc.putString("patchMd5", this.SIV.patchMd5);
      paramc.putString("strVersionDetail", this.SIV.SJg);
      paramc.putBoolean("bTryUseSharedCore", this.SIV.bTryUseSharedCore);
      paramc.putBoolean("skipSubFileMD5Check", this.SIV.SJl);
      paramc.putString("strAbi", this.SIV.strAbi);
      paramc.putString("path", this.SIV.path);
      paramc.putInt("versionId", this.SIV.SIv);
      paramc.putFloat("timeHourStart", this.SIV.SJj);
      paramc.putFloat("timeHourEnd", this.SIV.SJk);
      paramc.putString("UPDATE_SPEED_CONFIG", this.SIV.SIG);
      paramc.putString("UPDATE_FORWARD_SPEED_CONFIG", this.SIV.SIH);
      paramc.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.SIV.SII);
      paramc.commit();
      return;
    }
    finally {}
  }
  
  protected boolean hvA()
  {
    return false;
  }
  
  public boolean hvB()
  {
    String[] arrayOfString = bsV(hvf());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {}
    label109:
    for (;;)
    {
      return false;
      double d = e.htS();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label109;
        }
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = com.tencent.xweb.internal.i.bsy((String)localObject);
          if ((localObject != null) && (d >= ((com.tencent.xweb.internal.i)localObject).SDM) && (d <= ((com.tencent.xweb.internal.i)localObject).SDN))
          {
            if (XWalkEnvironment.getTodayGrayValue() >= 10000.0D * ((com.tencent.xweb.internal.i)localObject).JIb) {
              break;
            }
            return true;
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean hvC()
  {
    Object localObject1 = a.nS("free_update_time_zone", "tools");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    double d;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (!((String)localObject1).contains("-"));
            localObject2 = ((String)localObject1).split("-");
          } while ((localObject2 == null) || (localObject2.length != 2));
          localObject1 = e.bsC(localObject2[0]);
        } while (!((e.a)localObject1).SEF);
        localObject2 = e.bsC(localObject2[1]);
      } while ((!((e.a)localObject2).SEF) || (!r(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue())));
      d = e.htS();
    } while ((d < ((e.a)localObject1).doubleValue()) || (d > ((e.a)localObject2).doubleValue()));
    return true;
  }
  
  public void hvG()
  {
    hvJ().SJa = System.currentTimeMillis();
    hvJ().SJb = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = hvF().edit();
    localEditor.putLong("nLastFetchConfigTime", hvJ().SJa);
    localEditor.putString("strLastFetchAbi", hvJ().SJb);
    localEditor.commit();
  }
  
  public boolean hvI()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(hvJ().SJb)) || (TextUtils.isEmpty(hvJ().SJb))) {
          continue;
        }
        boolean bool2 = "true".equalsIgnoreCase(b.nS("disable_abi_switch_reset_config_time", "tools"));
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
        if (!hvB()) {
          break label114;
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isInFreeFetchConfigTimeZone = true");
        continue;
      }
      finally {}
      return bool1;
      label114:
      long l1 = System.currentTimeMillis();
      if (aK(l1, hvJ().SJa))
      {
        long l2 = hvF().getLong("nLastFetchConfigTime", 0L);
        hvJ().SJa = l2;
        if (aK(l1, l2))
        {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "enough time after last time fetch config");
          continue;
        }
      }
      bool1 = false;
    }
  }
  
  /* Error */
  public c hvJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 439	com/tencent/xweb/xwalk/updater/c
    //   22: dup
    //   23: invokespecial 747	com/tencent/xweb/xwalk/updater/c:<init>	()V
    //   26: putfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   29: aload_0
    //   30: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   33: aload_0
    //   34: invokevirtual 35	com/tencent/xweb/xwalk/updater/Scheduler:hvc	()Ljava/lang/String;
    //   37: putfield 750	com/tencent/xweb/xwalk/updater/c:SIZ	Ljava/lang/String;
    //   40: aload_0
    //   41: invokespecial 422	com/tencent/xweb/xwalk/updater/Scheduler:hvF	()Landroid/content/SharedPreferences;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   49: aload_1
    //   50: ldc_w 430
    //   53: lconst_0
    //   54: invokeinterface 873 4 0
    //   59: putfield 442	com/tencent/xweb/xwalk/updater/c:SJa	J
    //   62: aload_0
    //   63: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   66: aload_1
    //   67: ldc_w 849
    //   70: ldc_w 877
    //   73: invokeinterface 880 3 0
    //   78: putfield 847	com/tencent/xweb/xwalk/updater/c:SJb	Ljava/lang/String;
    //   81: aload_1
    //   82: ldc_w 758
    //   85: invokeinterface 882 2 0
    //   90: ifne +11 -> 101
    //   93: aload_0
    //   94: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   97: astore_1
    //   98: goto -84 -> 14
    //   101: aload_0
    //   102: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   105: aload_1
    //   106: ldc_w 752
    //   109: ldc_w 877
    //   112: invokeinterface 880 3 0
    //   117: putfield 577	com/tencent/xweb/xwalk/updater/c:SID	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   124: aload_1
    //   125: ldc_w 801
    //   128: iconst_0
    //   129: invokeinterface 687 3 0
    //   134: putfield 588	com/tencent/xweb/xwalk/updater/c:SIv	I
    //   137: aload_0
    //   138: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   141: aload_1
    //   142: ldc_w 803
    //   145: ldc_w 883
    //   148: invokeinterface 887 3 0
    //   153: putfield 806	com/tencent/xweb/xwalk/updater/c:SJj	F
    //   156: aload_0
    //   157: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   160: aload_1
    //   161: ldc_w 812
    //   164: ldc_w 883
    //   167: invokeinterface 887 3 0
    //   172: putfield 815	com/tencent/xweb/xwalk/updater/c:SJk	F
    //   175: aload_0
    //   176: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   179: aload_1
    //   180: ldc_w 758
    //   183: ldc_w 877
    //   186: invokeinterface 880 3 0
    //   191: putfield 716	com/tencent/xweb/xwalk/updater/c:SIw	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   198: aload_1
    //   199: ldc_w 760
    //   202: ldc_w 877
    //   205: invokeinterface 880 3 0
    //   210: putfield 582	com/tencent/xweb/xwalk/updater/c:SJe	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   217: aload_1
    //   218: ldc_w 762
    //   221: ldc_w 877
    //   224: invokeinterface 880 3 0
    //   229: putfield 765	com/tencent/xweb/xwalk/updater/c:SIJ	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   236: aload_1
    //   237: ldc_w 767
    //   240: iconst_0
    //   241: invokeinterface 891 3 0
    //   246: putfield 574	com/tencent/xweb/xwalk/updater/c:SJc	Z
    //   249: aload_0
    //   250: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   253: aload_1
    //   254: ldc 186
    //   256: lconst_0
    //   257: invokeinterface 873 4 0
    //   262: putfield 446	com/tencent/xweb/xwalk/updater/c:SJf	J
    //   265: aload_0
    //   266: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   269: aload_1
    //   270: ldc_w 775
    //   273: iconst_0
    //   274: invokeinterface 687 3 0
    //   279: putfield 565	com/tencent/xweb/xwalk/updater/c:version	I
    //   282: aload_0
    //   283: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   286: aload_1
    //   287: ldc_w 713
    //   290: iconst_0
    //   291: invokeinterface 687 3 0
    //   296: putfield 731	com/tencent/xweb/xwalk/updater/c:SJh	I
    //   299: aload_0
    //   300: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   303: aload_1
    //   304: ldc_w 777
    //   307: iconst_0
    //   308: invokeinterface 687 3 0
    //   313: putfield 779	com/tencent/xweb/xwalk/updater/c:nPatchTargetVersion	I
    //   316: aload_0
    //   317: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   320: aload_1
    //   321: ldc_w 683
    //   324: iconst_0
    //   325: invokeinterface 687 3 0
    //   330: putfield 700	com/tencent/xweb/xwalk/updater/c:SJi	I
    //   333: aload_0
    //   334: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   337: aload_1
    //   338: ldc_w 780
    //   341: ldc_w 877
    //   344: invokeinterface 880 3 0
    //   349: putfield 591	com/tencent/xweb/xwalk/updater/c:patchMd5	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   356: aload_1
    //   357: ldc_w 782
    //   360: ldc_w 877
    //   363: invokeinterface 880 3 0
    //   368: putfield 785	com/tencent/xweb/xwalk/updater/c:SJg	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   375: aload_1
    //   376: ldc_w 773
    //   379: iconst_0
    //   380: invokeinterface 891 3 0
    //   385: putfield 568	com/tencent/xweb/xwalk/updater/c:SIE	Z
    //   388: aload_0
    //   389: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   392: aload_1
    //   393: ldc_w 774
    //   396: iconst_0
    //   397: invokeinterface 891 3 0
    //   402: putfield 571	com/tencent/xweb/xwalk/updater/c:bUseCdn	Z
    //   405: aload_0
    //   406: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   409: aload_1
    //   410: ldc_w 787
    //   413: iconst_1
    //   414: invokeinterface 891 3 0
    //   419: putfield 789	com/tencent/xweb/xwalk/updater/c:bTryUseSharedCore	Z
    //   422: aload_0
    //   423: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   426: aload_1
    //   427: ldc_w 791
    //   430: iconst_1
    //   431: invokeinterface 891 3 0
    //   436: putfield 794	com/tencent/xweb/xwalk/updater/c:SJl	Z
    //   439: aload_0
    //   440: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   443: aload_1
    //   444: ldc_w 795
    //   447: ldc_w 877
    //   450: invokeinterface 880 3 0
    //   455: putfield 585	com/tencent/xweb/xwalk/updater/c:strAbi	Ljava/lang/String;
    //   458: aload_0
    //   459: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   462: aload_1
    //   463: ldc_w 797
    //   466: ldc_w 877
    //   469: invokeinterface 880 3 0
    //   474: putfield 799	com/tencent/xweb/xwalk/updater/c:path	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   481: aload_1
    //   482: ldc_w 817
    //   485: ldc_w 877
    //   488: invokeinterface 880 3 0
    //   493: putfield 559	com/tencent/xweb/xwalk/updater/c:SIG	Ljava/lang/String;
    //   496: aload_0
    //   497: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   500: aload_1
    //   501: ldc_w 819
    //   504: ldc_w 877
    //   507: invokeinterface 880 3 0
    //   512: putfield 556	com/tencent/xweb/xwalk/updater/c:SIH	Ljava/lang/String;
    //   515: aload_0
    //   516: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   519: aload_1
    //   520: ldc_w 821
    //   523: ldc_w 877
    //   526: invokeinterface 880 3 0
    //   531: putfield 478	com/tencent/xweb/xwalk/updater/c:SII	Ljava/lang/String;
    //   534: aload_0
    //   535: getfield 746	com/tencent/xweb/xwalk/updater/Scheduler:SIV	Lcom/tencent/xweb/xwalk/updater/c;
    //   538: astore_1
    //   539: goto -525 -> 14
    //   542: astore_1
    //   543: aload_0
    //   544: monitorexit
    //   545: aload_1
    //   546: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	Scheduler
    //   13	526	1	localObject1	Object
    //   542	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	542	finally
    //   18	98	542	finally
    //   101	539	542	finally
  }
  
  public double hvM()
  {
    SIU = false;
    return bsT(Ex(false)) * 3600000.0D;
  }
  
  public double hvN()
  {
    SIU = false;
    return bsT(Ex(true)) * 3600000.0D;
  }
  
  public void hvO()
  {
    double d = e.htS();
    if ((d < hvJ().SJj) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = e.htR())
    {
      l1 = (a(0.0D, J(hvJ().SJj), s(hvJ().SJj, hvJ().SJk)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      hvJ().SJf = (l2 + l1);
      e(hvJ());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public boolean hvP()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!t(e.OP(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.htR() != e.c((Calendar)localObject))
    {
      Log.e(this.TAG, "unitest Time to next day error 0");
      return false;
    }
    localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 23, 59, 1);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 13, 0, 1);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 0");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 2, 59);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 1");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 2, 59);
    localCalendar.set(2020, 6, 15, 0, 1);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 2");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 3, 1);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, false))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 3");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 57, 1);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, true))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 4");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 56, 59);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, false))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 5");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 56, 59);
    localCalendar.set(2020, 6, 15, 22, 59);
    if (!a((Calendar)localObject, localCalendar, false, false, false))
    {
      Log.e(this.TAG, "unitTestDangerousTime error 6");
      return false;
    }
    localObject = new Scheduler()
    {
      protected final String Eu(boolean paramAnonymousBoolean)
      {
        return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
      }
      
      public final String hvc()
      {
        return "UNITEST";
      }
      
      protected final String hve()
      {
        return "18:00-20:00(0.5-0.6-0.7-1)=>0:00-3:00(0-1); 20:00 - 21:00(0.5-0.6-0.7) => 3-5(0-0.5); 15.5-17.5(0.5)=>3.5-5.5";
      }
    }.hvL();
    if (((List)localObject).size() != 3)
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 1");
      return false;
    }
    ((a)((List)localObject).get(0)).v(1.5D, 19.0D);
    if (!t(((a)((List)localObject).get(0)).u(1.5D, 19.0D), 0.325D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 2");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3249;
    if (!((a)((List)localObject).get(0)).b(1.5D, 19.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 3");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3250;
    if (((a)((List)localObject).get(0)).b(1.5D, 19.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 4");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 9899;
    if (!t(((a)((List)localObject).get(0)).u(3.0D, 20.0D), 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 5 ");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 5000;
    if (((a)((List)localObject).get(2)).b(3.9D, 17.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 6");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 4998;
    if (!((a)((List)localObject).get(2)).b(3.9D, 17.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 7");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (!((a)((List)localObject).get(1)).b(4.0D, 20.5D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 8");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (((a)((List)localObject).get(1)).b(4.0D, 20.5D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 9");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (a(4L, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 10");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (a(4L, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 11");
      return false;
    }
    Log.e(this.TAG, "unitTestRangeSchedule pass");
    return true;
  }
  
  public abstract String hvc();
  
  public int hvd()
  {
    return 0;
  }
  
  protected String hve()
  {
    return a.nS("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  protected String hvf()
  {
    return a.nS("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
  
  public void hvw()
  {
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
    e(null);
  }
  
  public String hvx()
  {
    if (hvy())
    {
      Object localObject = new Date(hvJ().SJf);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TAG).append(":has scheduler for ver = ").append(hvJ().version).append(" version id = ").append(hvJ().SIv).append(" update time in ").append(((Date)localObject).toString());
      if (!TextUtils.isEmpty(hvJ().SIG))
      {
        localObject = " update speed config:" + hvJ().SIG;
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(hvJ().SIH)) {
          break label221;
        }
        localObject = " update forward speed config:" + hvJ().SIH;
        label162:
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(hvJ().SII)) {
          break label228;
        }
      }
      label221:
      label228:
      for (localObject = " update time range config:" + hvJ().SII;; localObject = "")
      {
        return (String)localObject;
        localObject = "";
        break;
        localObject = "";
        break label162;
      }
    }
    return this.TAG + ":has no scheduler";
  }
  
  public boolean hvy()
  {
    if (!hvz()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
    return true;
  }
  
  /* Error */
  public boolean hvz()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 437	com/tencent/xweb/xwalk/updater/Scheduler:hvJ	()Lcom/tencent/xweb/xwalk/updater/c;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: invokevirtual 437	com/tencent/xweb/xwalk/updater/Scheduler:hvJ	()Lcom/tencent/xweb/xwalk/updater/c;
    //   13: getfield 565	com/tencent/xweb/xwalk/updater/c:version	I
    //   16: ifle +28 -> 44
    //   19: aload_0
    //   20: invokevirtual 437	com/tencent/xweb/xwalk/updater/Scheduler:hvJ	()Lcom/tencent/xweb/xwalk/updater/c;
    //   23: getfield 716	com/tencent/xweb/xwalk/updater/c:SIw	Ljava/lang/String;
    //   26: ifnull +18 -> 44
    //   29: aload_0
    //   30: invokevirtual 437	com/tencent/xweb/xwalk/updater/Scheduler:hvJ	()Lcom/tencent/xweb/xwalk/updater/c;
    //   33: getfield 716	com/tencent/xweb/xwalk/updater/c:SIw	Ljava/lang/String;
    //   36: invokevirtual 1014	java/lang/String:isEmpty	()Z
    //   39: istore_1
    //   40: iload_1
    //   41: ifeq +9 -> 50
    //   44: iconst_0
    //   45: istore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: iload_1
    //   49: ireturn
    //   50: iconst_1
    //   51: istore_1
    //   52: goto -6 -> 46
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Scheduler
    //   39	13	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	55	finally
  }
  
  static final class a
  {
    public com.tencent.xweb.internal.i SIX;
    public com.tencent.xweb.internal.i SIY;
    
    a()
    {
      AppMethodBeat.i(207349);
      this.SIX = new com.tencent.xweb.internal.i();
      this.SIY = new com.tencent.xweb.internal.i();
      AppMethodBeat.o(207349);
    }
    
    public final boolean b(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(207350);
      if ((paramDouble2 > this.SIX.SDN) || (paramDouble2 < this.SIX.SDM))
      {
        AppMethodBeat.o(207350);
        return false;
      }
      if ((paramDouble1 > this.SIY.SDN) || (paramDouble1 < this.SIY.SDM))
      {
        AppMethodBeat.o(207350);
        return false;
      }
      if (XWalkEnvironment.getTodayGrayValueByKey("DOWNLOAD_SCHEDULE") <= u(paramDouble1, paramDouble2) * 10000.0D * paramDouble3)
      {
        AppMethodBeat.o(207350);
        return true;
      }
      AppMethodBeat.o(207350);
      return false;
    }
    
    public final double u(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(207351);
      paramDouble2 = this.SIX.H(paramDouble2);
      paramDouble1 = this.SIY.H(paramDouble1);
      AppMethodBeat.o(207351);
      return paramDouble2 * paramDouble1;
    }
    
    public final String v(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(207352);
      String str = "[ " + this.SIX.SDM + "," + this.SIX.SDN + "] => [" + this.SIY.SDM + "," + this.SIY.SDN + "],scale=" + u(paramDouble1, paramDouble2);
      AppMethodBeat.o(207352);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.Scheduler
 * JD-Core Version:    0.7.0.1
 */