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
import com.tencent.xweb.util.g;
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
  public static boolean MVM = false;
  static boolean MVN = false;
  c MVO;
  protected String TAG = ghF() + "Scheduler";
  
  public static XWebCoreScheduler Af(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localXWebCoreScheduler = h.giv();
        return localXWebCoreScheduler;
      }
      finally {}
      XWebCoreScheduler localXWebCoreScheduler = XWebCoreScheduler.giw();
    }
  }
  
  private static boolean FS(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static double I(double paramDouble)
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
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, List<b> paramList)
  {
    paramList = paramList.iterator();
    double d1 = 0.0D;
    if (paramList.hasNext())
    {
      double d2 = ((b)paramList.next()).u(paramDouble1, paramDouble2) * paramDouble3;
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
    if (!TextUtils.isEmpty(parama.MVs))
    {
      l1 = b(parama, paramString);
      XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.MVv > 0)
    {
      long l2 = parama.MVv * 60 * 1000;
      if (0L == l2)
      {
        XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.MPG.MPU > 0) && (parama.MPG.MPU <= 10000))
      {
        i = parama.MPG.MPU;
        label174:
        if ((parama.MPG.MPV <= 0) || (parama.MPG.MPV > 10000)) {
          break label280;
        }
      }
      label280:
      for (int j = parama.MPG.MPV;; j = 10000)
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
  
  private boolean aE(long paramLong1, long paramLong2)
  {
    long l = gih();
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
    if (TextUtils.isEmpty(parama.MVs))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parama.MVt)) {
        break label468;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parama.MVt);
      paramString = (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog(paramString, " parse version release date failed " + localException.getMessage());
        g.t(903L, 158L, 1L);
        paramString = (String)localObject2;
      }
      if ((parama.MPG.MPU <= 0) || (parama.MPG.MPU > 10000)) {
        break label590;
      }
      int j = parama.MPG.MPU;
      if ((parama.MPG.MPV <= 0) || (parama.MPG.MPV > 10000)) {
        break label596;
      }
      for (k = parama.MPG.MPV;; k = 10000)
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
      d1 = e.ggA();
      d2 = I(parama.MVq);
      d3 = s(parama.MVq, parama.MVr);
      j -= i;
      i = j;
      if (j > 0) {
        break label678;
      }
      if ((!parama.MVy) || (d1 <= d2)) {
        break label708;
      }
      Log.i("Scheduler", "low priority version. schedule to next day to update");
      i = 1;
      return (a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.ggz());
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
        localObject1 = parama.MVs.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.bcS((String)localObject3);
              if (!((e.a)localObject3).MRB) {
                break label272;
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
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parama.MVs);
            localObject1 = null;
            break;
            label272:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parama.MVs);
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
            break label428;
          }
          j = ((e.a)((List)localObject2).get(i)).intValue();
          if ((i > 0) && (j < localObject1[(i - 1)]))
          {
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parama.MVs);
            localObject1 = null;
            break;
          }
          localObject1[i] = j;
          i += 1;
        }
        label428:
        break;
      }
      label468:
      double d2;
      label590:
      label596:
      double d3;
      label678:
      label708:
      while (d1 >= d3) {
        i = 1;
      }
      return ((a(d1, d2, d3) - d1) * 3600000.0D);
    }
  }
  
  public static double bdg(String paramString)
  {
    return e(paramString, e.ggA());
  }
  
  private static a bdh(String paramString)
  {
    int i = 0;
    a locala = new a();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("getTimeRangeItem", "length error");
      return null;
    }
    double d = bdj(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      return null;
    }
    locala.MVQ = d;
    d = bdj(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
      return null;
    }
    locala.MVR = d;
    if (paramString.length == 3)
    {
      paramString = e.bcR(paramString[2]);
      if (!paramString.MRB)
      {
        Log.e("getTimeRangeItem", "scale parse error");
        return null;
      }
      d = paramString.doubleValue();
      if ((d < 0.0D) || (d > 1000000.0000999999D))
      {
        Log.e("getTimeRangeItem", "scale parse value error");
        return null;
      }
      locala.ESo = d;
    }
    for (;;)
    {
      return locala;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        while (i + 2 < paramString.length)
        {
          e.a locala1 = e.bcR(paramString[(i + 2)]);
          if (!locala1.MRB)
          {
            Log.e("getTimeRangeItem", "scales parse error");
            return null;
          }
          d = locala1.doubleValue();
          if ((d < 0.0D) || (d > 1000000.0000999999D))
          {
            Log.e("getTimeRangeItem", "scales parse value error");
            return null;
          }
          arrayOfDouble[i] = d;
          i += 1;
        }
        locala.MVS = arrayOfDouble;
      }
    }
  }
  
  private static b bdi(String paramString)
  {
    b localb = new b();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().replace("=>", "_").split("_");
    if ((paramString == null) || (paramString.length != 2))
    {
      Log.e("getTimeRangePairItem", "strRanges error");
      return null;
    }
    localb.MVT = bdh(paramString[0]);
    if (localb.MVT == null)
    {
      Log.e("getTimeRangePairItem", "parse rangefrom failed");
      return null;
    }
    localb.MVU = bdh(paramString[1]);
    if (localb.MVU == null)
    {
      Log.e("getTimeRangePairItem", "parse rangeTo failed");
      return null;
    }
    return localb;
  }
  
  private static double bdj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    double d1;
    do
    {
      double d2;
      int i;
      do
      {
        e.a locala;
        do
        {
          do
          {
            return -1.0D;
            paramString = paramString.split(":");
          } while ((paramString == null) || (paramString.length == 0));
          locala = e.bcR(paramString[0]);
        } while (!locala.MRB);
        d2 = locala.doubleValue();
        d1 = d2;
        if (paramString.length != 2) {
          break;
        }
        i = e.bcS(paramString[1]).intValue();
      } while ((i < 0) || (i >= 60));
      d1 = d2 + i * 1.0D / 60.0D;
    } while ((d1 < 0.0D) || (d1 > 24.0D));
    return d1;
  }
  
  private static String[] bdk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split(";");
  }
  
  private boolean c(long paramLong, double paramDouble)
  {
    double d1 = e.ggA();
    double d2 = e.FI(paramLong);
    MVN = false;
    Object localObject = gil();
    if (MVN)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
      g.t(903L, ghG() + 163, 1L);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.b(d1, d2, paramDouble))
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "matched timerange zone cur time is " + d1 + " scheduleHour is " + d2 + "time range is " + localb.v(d1, d2));
        return true;
      }
    }
    return false;
  }
  
  public static double e(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 1.0D;
      paramString = bdk(paramString);
      if ((paramString == null) || (paramString.length == 0))
      {
        MVN = true;
        return 1.0D;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bdh((String)localObject);
          if ((localObject != null) && (paramDouble >= ((a)localObject).MVQ) && (paramDouble <= ((a)localObject).MVR)) {
            return ((a)localObject).J(paramDouble);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void gid()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = Af(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.gif().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.gij().MVW = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void gie()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = Af(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.gif().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.gij().MVW = 0L;
      localXWebCoreScheduler.gij().MWb = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private SharedPreferences gif()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + ghF());
  }
  
  public static long gih()
  {
    long l1 = a.nc("force_cmd_period", "tools") * 60000L;
    if (FS(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkEnvironment.getConfigFetchPeriod();
        l1 = l2;
      } while (FS(l2));
      l2 = a.geQ();
      l1 = l2;
    } while (FS(l2));
    return 86400000L;
  }
  
  private String gik()
  {
    if (!TextUtils.isEmpty(gij().MVB)) {
      return gij().MVB;
    }
    return gEo();
  }
  
  private List<b> gil()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = gik();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      MVN = true;
      return localArrayList;
    }
    e.ggA();
    int j = localObject1.length;
    int i = 0;
    label61:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = bdi((String)localObject2);
        if (localObject2 != null) {
          break label103;
        }
        MVN = true;
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
  
  public static boolean giq()
  {
    Scheduler local2 = new Scheduler()
    {
      protected final String Ae(boolean paramAnonymousBoolean)
      {
        return "0:59-1:01-0.9;2:59-3:01-0.9;3:59-4:01-0.9;4:59-5:01-0.9;5:29-5:31-0.9;5:59-6:01-0.9;6:29-6:31-0.9;6:59-7:01-0.9;7:29-7:31-0.9;7:59-8:01-0.9;0:00-6:00(1.636806683-2.276643146-2.927125626-4.16300461-4.55588817-5.203755763-5.20765858-5.528990498-5.854745609-6.309553862-6.180110438-5.203755763-4.228129614);6:00-8:00(1.037712038-1.297503247-1.297140048-0.004150848);0-24-5";
      }
      
      protected final String gEo()
      {
        return "6:00-24:00(0.53871206-0.533307-0.53308-0.533309-0.53334-0.533011-0.533012-0.533013-0.533014-0.533015-0.533016-0.70017-0.723018-0.750019-0.7502-0.75021-0.753022-0.533023-0.533024) => 0:00-8:00(1)";
      }
      
      public final String ghF()
      {
        return "UNITEST";
      }
    };
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 15, 0, 0, 0);
    List localList = local2.gil();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(2020, 6, 15, 0, 58, 5);
    double d1 = e.d((Calendar)localObject1);
    a(d1, 21.0D, e(local2.Ah(false), d1) / 5.0D, localList);
    MVN = false;
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (double d2 = 0.0D; localCalendar.get(10) <= 8.0D; d2 = d1)
    {
      double d3 = e.d(localCalendar);
      double d4 = e(local2.Ah(false), d3) / 5.0D;
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
    Log.e("andrewu", "sParseScheduleConfigFailed = " + MVN);
    return true;
  }
  
  protected static boolean nr(String paramString1, String paramString2)
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
  
  protected abstract String Ae(boolean paramBoolean);
  
  public boolean Ag(boolean paramBoolean)
  {
    for (;;)
    {
      boolean bool;
      long l2;
      double d1;
      double d2;
      long l1;
      int i;
      long l3;
      long l4;
      long l5;
      int j;
      label347:
      try
      {
        bool = ghZ();
        if (!bool)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        if ((gia()) || (MVM))
        {
          g.t(903L, ghG() + 157, 1L);
          paramBoolean = true;
          continue;
        }
        Object localObject1 = a.nb("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = e.bcR((String)localObject1);
          if ((((e.a)localObject1).MRB) && (((e.a)localObject1).doubleValue() >= 0.0D) && (((e.a)localObject1).doubleValue() <= 24.0D)) {
            ((e.a)localObject1).doubleValue();
          }
        }
        l2 = System.currentTimeMillis();
        d1 = gim();
        if (MVN)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
          g.t(903L, ghG() + 163, 1L);
        }
        d2 = gin();
        if (MVN)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
          g.t(903L, ghG() + 163, 1L);
        }
        l1 = gij().MWb;
        i = 0;
        if (l1 > 1000L) {
          break label847;
        }
        if (!paramBoolean)
        {
          paramBoolean = true;
          continue;
        }
        l1 = (3600000.0D * Math.random());
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "not have schedule time ,just random a time in one hour");
        g.t(903L, ghG() + 155, 1L);
        l1 = l2 - l1;
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
        l3 = l2 - l1;
        l4 = e.ggz();
        l5 = l4 + l2;
        if (l1 - 180000L >= l5 - 86400000L) {
          break label853;
        }
        j = 1;
      }
      finally {}
      if (j != 0)
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day ");
        gio();
        g.t(903L, 146L, 1L);
        paramBoolean = false;
      }
      else
      {
        int k;
        if (k != 0)
        {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now ");
          g.t(903L, 147L, 1L);
          paramBoolean = false;
        }
        else
        {
          int m;
          if (m != 0)
          {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
            g.t(903L, 148L, 1L);
            paramBoolean = false;
          }
          else
          {
            if ((l3 >= 0L) && (l3 <= 3600000L))
            {
              bool = true;
              g.t(903L, ghG() + 154, 1L);
              break label871;
              if ((l3 < 0L) && (-l3 < d2))
              {
                paramBoolean = true;
                g.t(903L, ghG() + 161, 1L);
                if ((bool) && (!paramBoolean)) {
                  g.t(903L, ghG() + 150, 1L);
                }
                if ((!bool) && (paramBoolean)) {
                  g.t(903L, ghG() + 151, 1L);
                }
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
                if (paramBoolean)
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
                  g.t(903L, ghG() + 152, 1L);
                  paramBoolean = true;
                  continue;
                }
                if (gic())
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
                  g.t(903L, ghG() + 153, 1L);
                  paramBoolean = true;
                  continue;
                }
                if (c(l1, d1 / 18000000.0D))
                {
                  g.t(903L, ghG() + 162, 1L);
                  paramBoolean = true;
                  continue;
                }
                if ((i != 0) && ((l2 - gij().MWb > 0L) || (Math.abs(l2 - gij().MWb) > 7776000000L)))
                {
                  gio();
                  g.t(903L, ghG() + 156, 1L);
                  break label891;
                }
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
                break label891;
              }
            }
            label804:
            label847:
            label853:
            label865:
            label871:
            while ((l3 < 0L) || (l3 >= d1))
            {
              for (;;)
              {
                paramBoolean = false;
              }
              bool = false;
              continue;
              if (180000L + l1 > l5) {}
              for (k = 1;; k = 0)
              {
                if ((l4 >= 180000L) && (l4 + 180000L <= 86400000L)) {
                  break label865;
                }
                m = 1;
                break label347;
                i = 1;
                break;
                j = 0;
                break label804;
              }
              m = 0;
              break label347;
            }
            paramBoolean = true;
            continue;
            label891:
            paramBoolean = false;
          }
        }
      }
    }
  }
  
  public final String Ah(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(gij().MVA))) {
      return gij().MVA;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(gij().MVz))) {
      return gij().MVz;
    }
    return Ae(paramBoolean);
  }
  
  protected boolean a(c paramc1, c paramc2)
  {
    if ((paramc1.version != paramc2.version) || (paramc1.MVx != paramc2.MVx) || (paramc1.bUseCdn != paramc2.bUseCdn) || (paramc1.MVY != paramc2.MVY) || (!nr(paramc1.MVw, paramc2.MVw)) || (!nr(paramc1.MWa, paramc2.MWa)) || (!nr(paramc1.strAbi, paramc2.strAbi)) || (paramc1.MVo != paramc2.MVo)) {}
    while ((paramc1.MVY) && (!nr(paramc1.patchMd5, paramc2.patchMd5))) {
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
  
  public void ajA(int paramInt) {}
  
  public void ajB(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = gif();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      gij().MWe = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = gif();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      gij().MVY = false;
      gij().MVp = gij().MWa;
      gij().MVx = false;
      e(gij());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
      ghW();
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
    gij().MWd = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public c d(c paramc)
  {
    int j = 1;
    c localc = gij();
    if (paramc == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
      if (ghZ())
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
      if (!nr(paramc.MVz, localc.MVz))
      {
        localc.MVz = paramc.MVz;
        i = 1;
      }
      if (!nr(paramc.MVA, localc.MVA))
      {
        localc.MVA = paramc.MVA;
        i = 1;
      }
      if (nr(paramc.MVB, localc.MVB)) {
        break label233;
      }
      localc.MVB = paramc.MVB;
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
      if (ghZ())
      {
        g.t(903L, 149L, 1L);
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
      this.MVO = paramc;
      if (paramc == null) {
        this.MVO = new c();
      }
      this.MVO.MVV = ghF();
      paramc = gif().edit();
      paramc.putString("strMd5", this.MVO.MVw);
      paramc.putString("strUrl", this.MVO.MVp);
      paramc.putString("strFullPackageUrl", this.MVO.MWa);
      paramc.putString("strConfigVer", this.MVO.MVC);
      paramc.putBoolean("bIsPatchUpdate", this.MVO.MVY);
      paramc.putBoolean("bCanUseCellular", this.MVO.MVx);
      paramc.putBoolean("bUseCdn", this.MVO.bUseCdn);
      paramc.putLong("nTimeToUpdate", this.MVO.MWb);
      paramc.putInt("version", this.MVO.version);
      paramc.putInt("nTryCnt", this.MVO.MWd);
      paramc.putInt("nPatchTargetVersion", this.MVO.nPatchTargetVersion);
      paramc.putInt("nTryUseSharedCoreCount", this.MVO.MWe);
      paramc.putString("patchMd5", this.MVO.patchMd5);
      paramc.putString("strVersionDetail", this.MVO.MWc);
      paramc.putBoolean("bTryUseSharedCore", this.MVO.bTryUseSharedCore);
      paramc.putBoolean("skipSubFileMD5Check", this.MVO.MWh);
      paramc.putString("strAbi", this.MVO.strAbi);
      paramc.putString("path", this.MVO.path);
      paramc.putInt("versionId", this.MVO.MVo);
      paramc.putFloat("timeHourStart", this.MVO.MWf);
      paramc.putFloat("timeHourEnd", this.MVO.MWg);
      paramc.putString("UPDATE_SPEED_CONFIG", this.MVO.MVz);
      paramc.putString("UPDATE_FORWARD_SPEED_CONFIG", this.MVO.MVA);
      paramc.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.MVO.MVB);
      paramc.commit();
      return;
    }
    finally {}
  }
  
  protected String gEo()
  {
    return a.nb("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  public abstract String ghF();
  
  public int ghG()
  {
    return 0;
  }
  
  protected String ghH()
  {
    return a.nb("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
  
  public void ghW()
  {
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
    e(null);
  }
  
  public String ghX()
  {
    if (ghY())
    {
      Object localObject = new Date(gij().MWb);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TAG).append(":has scheduler for ver = ").append(gij().version).append(" version id = ").append(gij().MVo).append(" update time in ").append(((Date)localObject).toString());
      if (!TextUtils.isEmpty(gij().MVz))
      {
        localObject = " update speed config:" + gij().MVz;
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(gij().MVA)) {
          break label221;
        }
        localObject = " update forward speed config:" + gij().MVA;
        label162:
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(gij().MVB)) {
          break label228;
        }
      }
      label221:
      label228:
      for (localObject = " update time range config:" + gij().MVB;; localObject = "")
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
  
  public boolean ghY()
  {
    if (!ghZ()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
    return true;
  }
  
  /* Error */
  public boolean ghZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 485	com/tencent/xweb/xwalk/updater/Scheduler:gij	()Lcom/tencent/xweb/xwalk/updater/c;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: invokevirtual 485	com/tencent/xweb/xwalk/updater/Scheduler:gij	()Lcom/tencent/xweb/xwalk/updater/c;
    //   13: getfield 673	com/tencent/xweb/xwalk/updater/c:version	I
    //   16: ifle +28 -> 44
    //   19: aload_0
    //   20: invokevirtual 485	com/tencent/xweb/xwalk/updater/Scheduler:gij	()Lcom/tencent/xweb/xwalk/updater/c;
    //   23: getfield 744	com/tencent/xweb/xwalk/updater/c:MVp	Ljava/lang/String;
    //   26: ifnull +18 -> 44
    //   29: aload_0
    //   30: invokevirtual 485	com/tencent/xweb/xwalk/updater/Scheduler:gij	()Lcom/tencent/xweb/xwalk/updater/c;
    //   33: getfield 744	com/tencent/xweb/xwalk/updater/c:MVp	Ljava/lang/String;
    //   36: invokevirtual 880	java/lang/String:isEmpty	()Z
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
  
  protected boolean gia()
  {
    return false;
  }
  
  public boolean gib()
  {
    String[] arrayOfString = bdk(ghH());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {}
    label109:
    for (;;)
    {
      return false;
      double d = e.ggA();
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
          localObject = bdh((String)localObject);
          if ((localObject != null) && (d >= ((a)localObject).MVQ) && (d <= ((a)localObject).MVR))
          {
            if (XWalkEnvironment.getTodayGrayValue() >= 10000.0D * ((a)localObject).ESo) {
              break;
            }
            return true;
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean gic()
  {
    Object localObject1 = a.nb("free_update_time_zone", "tools");
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
          localObject1 = e.bcR(localObject2[0]);
        } while (!((e.a)localObject1).MRB);
        localObject2 = e.bcR(localObject2[1]);
      } while ((!((e.a)localObject2).MRB) || (!r(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue())));
      d = e.ggA();
    } while ((d < ((e.a)localObject1).doubleValue()) || (d > ((e.a)localObject2).doubleValue()));
    return true;
  }
  
  public void gig()
  {
    gij().MVW = System.currentTimeMillis();
    gij().MVX = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = gif().edit();
    localEditor.putLong("nLastFetchConfigTime", gij().MVW);
    localEditor.putString("strLastFetchAbi", gij().MVX);
    localEditor.commit();
  }
  
  public boolean gii()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(gij().MVX)) || (TextUtils.isEmpty(gij().MVX))) {
          continue;
        }
        boolean bool2 = "true".equalsIgnoreCase(b.nb("disable_abi_switch_reset_config_time", "tools"));
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
        if (!gib()) {
          break label114;
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isInFreeFetchConfigTimeZone = true");
        continue;
      }
      finally {}
      return bool1;
      label114:
      long l1 = System.currentTimeMillis();
      if (aE(l1, gij().MVW))
      {
        long l2 = gif().getLong("nLastFetchConfigTime", 0L);
        gij().MVW = l2;
        if (aE(l1, l2))
        {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "enough time after last time fetch config");
          continue;
        }
      }
      bool1 = false;
    }
  }
  
  /* Error */
  public c gij()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 487	com/tencent/xweb/xwalk/updater/c
    //   22: dup
    //   23: invokespecial 775	com/tencent/xweb/xwalk/updater/c:<init>	()V
    //   26: putfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   29: aload_0
    //   30: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   33: aload_0
    //   34: invokevirtual 38	com/tencent/xweb/xwalk/updater/Scheduler:ghF	()Ljava/lang/String;
    //   37: putfield 778	com/tencent/xweb/xwalk/updater/c:MVV	Ljava/lang/String;
    //   40: aload_0
    //   41: invokespecial 470	com/tencent/xweb/xwalk/updater/Scheduler:gif	()Landroid/content/SharedPreferences;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   49: aload_1
    //   50: ldc_w 478
    //   53: lconst_0
    //   54: invokeinterface 926 4 0
    //   59: putfield 490	com/tencent/xweb/xwalk/updater/c:MVW	J
    //   62: aload_0
    //   63: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   66: aload_1
    //   67: ldc_w 902
    //   70: ldc_w 352
    //   73: invokeinterface 931 3 0
    //   78: putfield 900	com/tencent/xweb/xwalk/updater/c:MVX	Ljava/lang/String;
    //   81: aload_1
    //   82: ldc_w 786
    //   85: invokeinterface 933 2 0
    //   90: ifne +11 -> 101
    //   93: aload_0
    //   94: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   97: astore_1
    //   98: goto -84 -> 14
    //   101: aload_0
    //   102: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   105: aload_1
    //   106: ldc_w 780
    //   109: ldc_w 352
    //   112: invokeinterface 931 3 0
    //   117: putfield 685	com/tencent/xweb/xwalk/updater/c:MVw	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   124: aload_1
    //   125: ldc_w 829
    //   128: iconst_0
    //   129: invokeinterface 715 3 0
    //   134: putfield 696	com/tencent/xweb/xwalk/updater/c:MVo	I
    //   137: aload_0
    //   138: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   141: aload_1
    //   142: ldc_w 831
    //   145: ldc_w 934
    //   148: invokeinterface 938 3 0
    //   153: putfield 834	com/tencent/xweb/xwalk/updater/c:MWf	F
    //   156: aload_0
    //   157: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   160: aload_1
    //   161: ldc_w 840
    //   164: ldc_w 934
    //   167: invokeinterface 938 3 0
    //   172: putfield 843	com/tencent/xweb/xwalk/updater/c:MWg	F
    //   175: aload_0
    //   176: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   179: aload_1
    //   180: ldc_w 786
    //   183: ldc_w 352
    //   186: invokeinterface 931 3 0
    //   191: putfield 744	com/tencent/xweb/xwalk/updater/c:MVp	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   198: aload_1
    //   199: ldc_w 788
    //   202: ldc_w 352
    //   205: invokeinterface 931 3 0
    //   210: putfield 690	com/tencent/xweb/xwalk/updater/c:MWa	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   217: aload_1
    //   218: ldc_w 790
    //   221: ldc_w 352
    //   224: invokeinterface 931 3 0
    //   229: putfield 793	com/tencent/xweb/xwalk/updater/c:MVC	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   236: aload_1
    //   237: ldc_w 795
    //   240: iconst_0
    //   241: invokeinterface 942 3 0
    //   246: putfield 682	com/tencent/xweb/xwalk/updater/c:MVY	Z
    //   249: aload_0
    //   250: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   253: aload_1
    //   254: ldc 187
    //   256: lconst_0
    //   257: invokeinterface 926 4 0
    //   262: putfield 494	com/tencent/xweb/xwalk/updater/c:MWb	J
    //   265: aload_0
    //   266: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   269: aload_1
    //   270: ldc_w 803
    //   273: iconst_0
    //   274: invokeinterface 715 3 0
    //   279: putfield 673	com/tencent/xweb/xwalk/updater/c:version	I
    //   282: aload_0
    //   283: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   286: aload_1
    //   287: ldc_w 741
    //   290: iconst_0
    //   291: invokeinterface 715 3 0
    //   296: putfield 759	com/tencent/xweb/xwalk/updater/c:MWd	I
    //   299: aload_0
    //   300: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   303: aload_1
    //   304: ldc_w 805
    //   307: iconst_0
    //   308: invokeinterface 715 3 0
    //   313: putfield 807	com/tencent/xweb/xwalk/updater/c:nPatchTargetVersion	I
    //   316: aload_0
    //   317: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   320: aload_1
    //   321: ldc_w 711
    //   324: iconst_0
    //   325: invokeinterface 715 3 0
    //   330: putfield 728	com/tencent/xweb/xwalk/updater/c:MWe	I
    //   333: aload_0
    //   334: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   337: aload_1
    //   338: ldc_w 808
    //   341: ldc_w 352
    //   344: invokeinterface 931 3 0
    //   349: putfield 699	com/tencent/xweb/xwalk/updater/c:patchMd5	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   356: aload_1
    //   357: ldc_w 810
    //   360: ldc_w 352
    //   363: invokeinterface 931 3 0
    //   368: putfield 813	com/tencent/xweb/xwalk/updater/c:MWc	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   375: aload_1
    //   376: ldc_w 801
    //   379: iconst_0
    //   380: invokeinterface 942 3 0
    //   385: putfield 676	com/tencent/xweb/xwalk/updater/c:MVx	Z
    //   388: aload_0
    //   389: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   392: aload_1
    //   393: ldc_w 802
    //   396: iconst_0
    //   397: invokeinterface 942 3 0
    //   402: putfield 679	com/tencent/xweb/xwalk/updater/c:bUseCdn	Z
    //   405: aload_0
    //   406: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   409: aload_1
    //   410: ldc_w 815
    //   413: iconst_1
    //   414: invokeinterface 942 3 0
    //   419: putfield 817	com/tencent/xweb/xwalk/updater/c:bTryUseSharedCore	Z
    //   422: aload_0
    //   423: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   426: aload_1
    //   427: ldc_w 819
    //   430: iconst_1
    //   431: invokeinterface 942 3 0
    //   436: putfield 822	com/tencent/xweb/xwalk/updater/c:MWh	Z
    //   439: aload_0
    //   440: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   443: aload_1
    //   444: ldc_w 823
    //   447: ldc_w 352
    //   450: invokeinterface 931 3 0
    //   455: putfield 693	com/tencent/xweb/xwalk/updater/c:strAbi	Ljava/lang/String;
    //   458: aload_0
    //   459: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   462: aload_1
    //   463: ldc_w 825
    //   466: ldc_w 352
    //   469: invokeinterface 931 3 0
    //   474: putfield 827	com/tencent/xweb/xwalk/updater/c:path	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   481: aload_1
    //   482: ldc_w 845
    //   485: ldc_w 352
    //   488: invokeinterface 931 3 0
    //   493: putfield 667	com/tencent/xweb/xwalk/updater/c:MVz	Ljava/lang/String;
    //   496: aload_0
    //   497: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   500: aload_1
    //   501: ldc_w 847
    //   504: ldc_w 352
    //   507: invokeinterface 931 3 0
    //   512: putfield 664	com/tencent/xweb/xwalk/updater/c:MVA	Ljava/lang/String;
    //   515: aload_0
    //   516: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
    //   519: aload_1
    //   520: ldc_w 849
    //   523: ldc_w 352
    //   526: invokeinterface 931 3 0
    //   531: putfield 522	com/tencent/xweb/xwalk/updater/c:MVB	Ljava/lang/String;
    //   534: aload_0
    //   535: getfield 774	com/tencent/xweb/xwalk/updater/Scheduler:MVO	Lcom/tencent/xweb/xwalk/updater/c;
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
  
  public double gim()
  {
    MVN = false;
    return bdg(Ah(false)) * 3600000.0D;
  }
  
  public double gin()
  {
    MVN = false;
    return bdg(Ah(true)) * 3600000.0D;
  }
  
  public void gio()
  {
    double d = e.ggA();
    if ((d < gij().MWf) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = e.ggz())
    {
      l1 = (a(0.0D, I(gij().MWf), s(gij().MWf, gij().MWg)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      gij().MWb = (l2 + l1);
      e(gij());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public boolean gip()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!t(e.FI(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.ggz() != e.c((Calendar)localObject))
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
      protected final String Ae(boolean paramAnonymousBoolean)
      {
        return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
      }
      
      protected final String gEo()
      {
        return "18:00-20:00(0.5-0.6-0.7-1)=>0:00-3:00(0-1); 20:00 - 21:00(0.5-0.6-0.7) => 3-5(0-0.5); 15.5-17.5(0.5)=>3.5-5.5";
      }
      
      public final String ghF()
      {
        return "UNITEST";
      }
    }.gil();
    if (((List)localObject).size() != 3)
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 1");
      return false;
    }
    ((b)((List)localObject).get(0)).v(1.5D, 19.0D);
    if (!t(((b)((List)localObject).get(0)).u(1.5D, 19.0D), 0.325D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 2");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3249;
    if (!((b)((List)localObject).get(0)).b(1.5D, 19.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 3");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3250;
    if (((b)((List)localObject).get(0)).b(1.5D, 19.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 4");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 9899;
    if (!t(((b)((List)localObject).get(0)).u(3.0D, 20.0D), 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 5 ");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 5000;
    if (((b)((List)localObject).get(2)).b(3.9D, 17.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 6");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 4998;
    if (!((b)((List)localObject).get(2)).b(3.9D, 17.0D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 7");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (!((b)((List)localObject).get(1)).b(4.0D, 20.5D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 8");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (((b)((List)localObject).get(1)).b(4.0D, 20.5D, 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 9");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (c(4L, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 10");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (c(4L, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 11");
      return false;
    }
    Log.e(this.TAG, "unitTestRangeSchedule pass");
    return true;
  }
  
  static final class a
  {
    public double ESo;
    public double MVQ;
    public double MVR;
    public double[] MVS;
    
    a()
    {
      AppMethodBeat.i(207616);
      this.MVS = new double[0];
      this.ESo = 1.0D;
      AppMethodBeat.o(207616);
    }
    
    public final double J(double paramDouble)
    {
      int i = 0;
      if ((paramDouble < this.MVQ) || (paramDouble > this.MVR)) {
        return 0.0D;
      }
      if ((this.MVS == null) || (this.MVS.length == 0)) {
        return this.ESo;
      }
      if (this.MVS.length == 1) {
        return this.MVS[0];
      }
      if (paramDouble == this.MVR) {
        return this.MVS[(this.MVS.length - 1)];
      }
      int j = this.MVS.length - 1;
      double d1 = (this.MVR - this.MVQ) / j;
      paramDouble -= this.MVQ;
      while (i < j)
      {
        double d3 = i + 1;
        double d2 = i;
        if (paramDouble <= d3 * d1)
        {
          d3 = this.MVS[i];
          return (this.MVS[(i + 1)] - this.MVS[i]) * (paramDouble - d2 * d1) / d1 + d3;
        }
        i += 1;
      }
      return this.MVS[(this.MVS.length - 1)];
    }
  }
  
  static final class b
  {
    public Scheduler.a MVT;
    public Scheduler.a MVU;
    
    b()
    {
      AppMethodBeat.i(207617);
      this.MVT = new Scheduler.a();
      this.MVU = new Scheduler.a();
      AppMethodBeat.o(207617);
    }
    
    public final boolean b(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(207618);
      if ((paramDouble2 > this.MVT.MVR) || (paramDouble2 < this.MVT.MVQ))
      {
        AppMethodBeat.o(207618);
        return false;
      }
      if ((paramDouble1 > this.MVU.MVR) || (paramDouble1 < this.MVU.MVQ))
      {
        AppMethodBeat.o(207618);
        return false;
      }
      if (XWalkEnvironment.getTodayGrayValue() <= u(paramDouble1, paramDouble2) * 10000.0D * paramDouble3)
      {
        AppMethodBeat.o(207618);
        return true;
      }
      AppMethodBeat.o(207618);
      return false;
    }
    
    public final double u(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(207619);
      paramDouble2 = this.MVT.J(paramDouble2);
      paramDouble1 = this.MVU.J(paramDouble1);
      AppMethodBeat.o(207619);
      return paramDouble2 * paramDouble1;
    }
    
    public final String v(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(207620);
      String str = "[ " + this.MVT.MVQ + "," + this.MVT.MVR + "] => [" + this.MVU.MVQ + "," + this.MVU.MVR + "],scale=" + u(paramDouble1, paramDouble2);
      AppMethodBeat.o(207620);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.Scheduler
 * JD-Core Version:    0.7.0.1
 */