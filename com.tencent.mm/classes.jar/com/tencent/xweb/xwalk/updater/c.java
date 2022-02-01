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

public abstract class c
{
  static h MyH;
  public static boolean MyI = false;
  static boolean MyJ = false;
  SchedulerConfig MyK;
  protected String TAG = gdd() + "Scheduler";
  
  private static boolean Fq(long paramLong)
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
    if (!TextUtils.isEmpty(parama.Myo))
    {
      l1 = b(parama, paramString);
      XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.Myr > 0)
    {
      long l2 = parama.Myr * 60 * 1000;
      if (0L == l2)
      {
        XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.MsC.MsQ > 0) && (parama.MsC.MsQ <= 10000))
      {
        i = parama.MsC.MsQ;
        label174:
        if ((parama.MsC.MsR <= 0) || (parama.MsC.MsR > 10000)) {
          break label280;
        }
      }
      label280:
      for (int j = parama.MsC.MsR;; j = 10000)
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
  
  private boolean aF(long paramLong1, long paramLong2)
  {
    long l = gdF();
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
    if (TextUtils.isEmpty(parama.Myo))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parama.Myp)) {
        break label463;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parama.Myp);
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
      if ((parama.MsC.MsQ <= 0) || (parama.MsC.MsQ > 10000)) {
        break label585;
      }
      int j = parama.MsC.MsQ;
      if ((parama.MsC.MsR <= 0) || (parama.MsC.MsR > 10000)) {
        break label591;
      }
      for (k = parama.MsC.MsR;; k = 10000)
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
      d1 = e.gbY();
      d2 = I(parama.Mym);
      d3 = s(parama.Mym, parama.Myn);
      j -= i;
      int i = j;
      if (j > 0) {
        break label658;
      }
      if (d1 < d3) {
        break label688;
      }
      i = 1;
      return (a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.gbX());
    }
    double d1 = (new Date().getTime() - paramString.getTime()) / 86400000.0D;
    j = (int)d1;
    i = j;
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
        localObject1 = parama.Myo.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.bbp((String)localObject3);
              if (!((e.a)localObject3).Mux) {
                break label269;
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
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parama.Myo);
            localObject1 = null;
            break;
            label269:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parama.Myo);
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
            break label423;
          }
          j = ((e.a)((List)localObject2).get(i)).intValue();
          if ((i > 0) && (j < localObject1[(i - 1)]))
          {
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parama.Myo);
            localObject1 = null;
            break;
          }
          localObject1[i] = j;
          i += 1;
        }
        label423:
        break;
      }
      label463:
      double d2;
      label585:
      label591:
      double d3;
      label658:
      label688:
      return ((a(d1, d2, d3) - d1) * 3600000.0D);
    }
  }
  
  public static double bbD(String paramString)
  {
    return e(paramString, e.gbY());
  }
  
  private static a bbE(String paramString)
  {
    int i = 0;
    a locala = new a();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("getTimeRangeItem", "length error");
      return null;
    }
    double d = bbG(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      return null;
    }
    locala.MyM = d;
    d = bbG(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
      return null;
    }
    locala.MyN = d;
    if (paramString.length == 3)
    {
      paramString = e.bbo(paramString[2]);
      if (!paramString.Mux)
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
      locala.EzS = d;
    }
    for (;;)
    {
      return locala;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        while (i + 2 < paramString.length)
        {
          e.a locala1 = e.bbo(paramString[(i + 2)]);
          if (!locala1.Mux)
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
        locala.MyO = arrayOfDouble;
      }
    }
  }
  
  private static b bbF(String paramString)
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
    localb.MyP = bbE(paramString[0]);
    if (localb.MyP == null)
    {
      Log.e("getTimeRangePairItem", "parse rangefrom failed");
      return null;
    }
    localb.MyQ = bbE(paramString[1]);
    if (localb.MyQ == null)
    {
      Log.e("getTimeRangePairItem", "parse rangeTo failed");
      return null;
    }
    return localb;
  }
  
  private static double bbG(String paramString)
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
          locala = e.bbo(paramString[0]);
        } while (!locala.Mux);
        d2 = locala.doubleValue();
        d1 = d2;
        if (paramString.length != 2) {
          break;
        }
        i = e.bbp(paramString[1]).intValue();
      } while ((i < 0) || (i >= 60));
      d1 = d2 + i * 1.0D / 60.0D;
    } while ((d1 < 0.0D) || (d1 > 24.0D));
    return d1;
  }
  
  private boolean c(long paramLong, double paramDouble)
  {
    double d1 = e.gbY();
    double d2 = e.Fg(paramLong);
    MyJ = false;
    Object localObject = gdJ();
    if (MyJ)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
      g.t(903L, gde() + 163, 1L);
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
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = null; (paramString == null) || (paramString.length == 0); paramString = paramString.split(";"))
      {
        MyJ = true;
        return 1.0D;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bbE((String)localObject);
          if ((localObject != null) && (paramDouble >= ((a)localObject).MyM) && (paramDouble <= ((a)localObject).MyN)) {
            return ((a)localObject).J(paramDouble);
          }
        }
        i += 1;
      }
    }
  }
  
  private SharedPreferences gdD()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + gdd());
  }
  
  private String gdI()
  {
    if (!TextUtils.isEmpty(gdH().Myw)) {
      return gdH().Myw;
    }
    return a.mV("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  private List<b> gdJ()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = gdI();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      MyJ = true;
      return localArrayList;
    }
    e.gbY();
    int j = localObject1.length;
    int i = 0;
    label61:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = bbF((String)localObject2);
        if (localObject2 != null) {
          break label103;
        }
        MyJ = true;
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
  
  public static boolean gdO()
  {
    c local2 = new c()
    {
      public final String gdd()
      {
        return "UNITEST";
      }
      
      protected final String zR(boolean paramAnonymousBoolean)
      {
        return "0:59-1:01-0.9;2:59-3:01-0.9;3:59-4:01-0.9;4:59-5:01-0.9;5:29-5:31-0.9;5:59-6:01-0.9;6:29-6:31-0.9;6:59-7:01-0.9;7:29-7:31-0.9;7:59-8:01-0.9;0:00-6:00(1.636806683-2.276643146-2.927125626-4.16300461-4.55588817-5.203755763-5.20765858-5.528990498-5.854745609-6.309553862-6.180110438-5.203755763-4.228129614);6:00-8:00(1.037712038-1.297503247-1.297140048-0.004150848);0-24-5";
      }
    };
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 15, 0, 0, 0);
    List localList = local2.gdJ();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(2020, 6, 15, 0, 58, 5);
    double d1 = e.d((Calendar)localObject1);
    a(d1, 21.0D, e(local2.zT(false), d1) / 5.0D, localList);
    MyJ = false;
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (double d2 = 0.0D; localCalendar.get(10) <= 8.0D; d2 = d1)
    {
      double d3 = e.d(localCalendar);
      double d4 = e(local2.zT(false), d3) / 5.0D;
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
    Log.e("andrewu", "sParseScheduleConfigFailed = " + MyJ);
    return true;
  }
  
  public static h gdu()
  {
    try
    {
      if (MyH == null) {
        MyH = new h();
      }
      h localh = MyH;
      return localh;
    }
    finally {}
  }
  
  protected static boolean nl(String paramString1, String paramString2)
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
  
  protected boolean a(SchedulerConfig paramSchedulerConfig1, SchedulerConfig paramSchedulerConfig2)
  {
    if ((paramSchedulerConfig1.version != paramSchedulerConfig2.version) || (paramSchedulerConfig1.Myt != paramSchedulerConfig2.Myt) || (paramSchedulerConfig1.bUseCdn != paramSchedulerConfig2.bUseCdn) || (paramSchedulerConfig1.MyT != paramSchedulerConfig2.MyT) || (!nl(paramSchedulerConfig1.Mys, paramSchedulerConfig2.Mys)) || (!nl(paramSchedulerConfig1.MyV, paramSchedulerConfig2.MyV)) || (!nl(paramSchedulerConfig1.strAbi, paramSchedulerConfig2.strAbi)) || (paramSchedulerConfig1.Myk != paramSchedulerConfig2.Myk)) {}
    while ((paramSchedulerConfig1.MyT) && (!nl(paramSchedulerConfig1.patchMd5, paramSchedulerConfig2.patchMd5))) {
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
  
  public void aiQ(int paramInt) {}
  
  public void aiR(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = gdD();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      gdH().MyZ = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = gdD();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      gdH().MyT = false;
      gdH().Myl = gdH().MyV;
      gdH().Myt = false;
      e(gdH());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
      gdv();
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
    gdH().MyY = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public SchedulerConfig d(SchedulerConfig paramSchedulerConfig)
  {
    int j = 1;
    SchedulerConfig localSchedulerConfig = gdH();
    if (paramSchedulerConfig == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
      if (gdy())
      {
        if (localSchedulerConfig != null) {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "clear current scheduler version = " + localSchedulerConfig.version);
        }
        e(paramSchedulerConfig);
      }
      return null;
    }
    int i;
    if (a(paramSchedulerConfig, localSchedulerConfig))
    {
      i = 0;
      if (!nl(paramSchedulerConfig.Myu, localSchedulerConfig.Myu))
      {
        localSchedulerConfig.Myu = paramSchedulerConfig.Myu;
        i = 1;
      }
      if (!nl(paramSchedulerConfig.Myv, localSchedulerConfig.Myv))
      {
        localSchedulerConfig.Myv = paramSchedulerConfig.Myv;
        i = 1;
      }
      if (nl(paramSchedulerConfig.Myw, localSchedulerConfig.Myw)) {
        break label233;
      }
      localSchedulerConfig.Myw = paramSchedulerConfig.Myw;
      i = j;
    }
    label233:
    for (;;)
    {
      if (i != 0) {
        e(localSchedulerConfig);
      }
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got same version to scheduler, use last version ");
      return localSchedulerConfig;
      if (gdy())
      {
        g.t(903L, 149L, 1L);
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "got new scheduler replace current , version is " + paramSchedulerConfig.version);
      }
      e(paramSchedulerConfig);
      return paramSchedulerConfig;
    }
  }
  
  public void e(SchedulerConfig paramSchedulerConfig)
  {
    try
    {
      this.MyK = paramSchedulerConfig;
      if (paramSchedulerConfig == null) {
        this.MyK = new SchedulerConfig();
      }
      paramSchedulerConfig = gdD().edit();
      paramSchedulerConfig.putString("strMd5", this.MyK.Mys);
      paramSchedulerConfig.putString("strUrl", this.MyK.Myl);
      paramSchedulerConfig.putString("strFullPackageUrl", this.MyK.MyV);
      paramSchedulerConfig.putString("strConfigVer", this.MyK.Myx);
      paramSchedulerConfig.putBoolean("bIsPatchUpdate", this.MyK.MyT);
      paramSchedulerConfig.putBoolean("bCanUseCellular", this.MyK.Myt);
      paramSchedulerConfig.putBoolean("bUseCdn", this.MyK.bUseCdn);
      paramSchedulerConfig.putLong("nTimeToUpdate", this.MyK.MyW);
      paramSchedulerConfig.putInt("version", this.MyK.version);
      paramSchedulerConfig.putInt("nTryCnt", this.MyK.MyY);
      paramSchedulerConfig.putInt("nPatchTargetVersion", this.MyK.nPatchTargetVersion);
      paramSchedulerConfig.putInt("nTryUseSharedCoreCount", this.MyK.MyZ);
      paramSchedulerConfig.putString("patchMd5", this.MyK.patchMd5);
      paramSchedulerConfig.putString("strVersionDetail", this.MyK.MyX);
      paramSchedulerConfig.putBoolean("bTryUseSharedCore", this.MyK.bTryUseSharedCore);
      paramSchedulerConfig.putBoolean("skipSubFileMD5Check", this.MyK.Mzc);
      paramSchedulerConfig.putString("strAbi", this.MyK.strAbi);
      paramSchedulerConfig.putString("path", this.MyK.path);
      paramSchedulerConfig.putInt("versionId", this.MyK.Myk);
      paramSchedulerConfig.putFloat("timeHourStart", this.MyK.Mza);
      paramSchedulerConfig.putFloat("timeHourEnd", this.MyK.Mzb);
      paramSchedulerConfig.putString("UPDATE_SPEED_CONFIG", this.MyK.Myu);
      paramSchedulerConfig.putString("UPDATE_FORWARD_SPEED_CONFIG", this.MyK.Myv);
      paramSchedulerConfig.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.MyK.Myw);
      paramSchedulerConfig.commit();
      return;
    }
    finally {}
  }
  
  public boolean gdA()
  {
    Object localObject1 = a.mV("free_update_time_zone", "tools");
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
          localObject1 = e.bbo(localObject2[0]);
        } while (!((e.a)localObject1).Mux);
        localObject2 = e.bbo(localObject2[1]);
      } while ((!((e.a)localObject2).Mux) || (!r(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue())));
      d = e.gbY();
    } while ((d < ((e.a)localObject1).doubleValue()) || (d > ((e.a)localObject2).doubleValue()));
    return true;
  }
  
  public void gdB()
  {
    try
    {
      SharedPreferences.Editor localEditor = gdD().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      gdH().MyR = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void gdC()
  {
    try
    {
      SharedPreferences.Editor localEditor = gdD().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      gdH().MyR = 0L;
      gdH().MyW = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void gdE()
  {
    gdH().MyR = System.currentTimeMillis();
    gdH().MyS = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = gdD().edit();
    localEditor.putLong("nLastFetchConfigTime", gdH().MyR);
    localEditor.putString("strLastFetchAbi", gdH().MyS);
    localEditor.commit();
  }
  
  public long gdF()
  {
    long l1 = a.mW("force_cmd_period", "tools") * 60000L;
    if (Fq(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkEnvironment.getConfigFetchPeriod();
        l1 = l2;
      } while (Fq(l2));
      l2 = a.gao();
      l1 = l2;
    } while (Fq(l2));
    return 86400000L;
  }
  
  public boolean gdG()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(gdH().MyS)) || (TextUtils.isEmpty(gdH().MyS))) {
          continue;
        }
        boolean bool2 = "true".equalsIgnoreCase(b.mV("disable_abi_switch_reset_config_time", "tools"));
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
        long l1 = System.currentTimeMillis();
        if (!aF(l1, gdH().MyR)) {
          break label160;
        }
        long l2 = gdD().getLong("nLastFetchConfigTime", 0L);
        gdH().MyR = l2;
        if (!aF(l1, l2)) {
          break label160;
        }
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "enough time after last time fetch config");
        continue;
      }
      finally {}
      return bool1;
      label160:
      bool1 = false;
    }
  }
  
  /* Error */
  public SchedulerConfig gdH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 456	com/tencent/xweb/xwalk/updater/SchedulerConfig
    //   22: dup
    //   23: invokespecial 668	com/tencent/xweb/xwalk/updater/SchedulerConfig:<init>	()V
    //   26: putfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   29: aload_0
    //   30: invokespecial 584	com/tencent/xweb/xwalk/updater/c:gdD	()Landroid/content/SharedPreferences;
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   38: aload_1
    //   39: ldc_w 751
    //   42: lconst_0
    //   43: invokeinterface 798 4 0
    //   48: putfield 754	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyR	J
    //   51: aload_0
    //   52: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   55: aload_1
    //   56: ldc_w 764
    //   59: ldc_w 333
    //   62: invokeinterface 803 3 0
    //   67: putfield 762	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyS	Ljava/lang/String;
    //   70: aload_1
    //   71: ldc_w 676
    //   74: invokeinterface 805 2 0
    //   79: ifne +11 -> 90
    //   82: aload_0
    //   83: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   86: astore_1
    //   87: goto -73 -> 14
    //   90: aload_0
    //   91: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   94: aload_1
    //   95: ldc_w 670
    //   98: ldc_w 333
    //   101: invokeinterface 803 3 0
    //   106: putfield 556	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mys	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   113: aload_1
    //   114: ldc_w 722
    //   117: iconst_0
    //   118: invokeinterface 592 3 0
    //   123: putfield 567	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myk	I
    //   126: aload_0
    //   127: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   130: aload_1
    //   131: ldc_w 724
    //   134: ldc_w 806
    //   137: invokeinterface 810 3 0
    //   142: putfield 727	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mza	F
    //   145: aload_0
    //   146: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   149: aload_1
    //   150: ldc_w 733
    //   153: ldc_w 806
    //   156: invokeinterface 810 3 0
    //   161: putfield 736	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mzb	F
    //   164: aload_0
    //   165: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   168: aload_1
    //   169: ldc_w 676
    //   172: ldc_w 333
    //   175: invokeinterface 803 3 0
    //   180: putfield 628	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myl	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   187: aload_1
    //   188: ldc_w 678
    //   191: ldc_w 333
    //   194: invokeinterface 803 3 0
    //   199: putfield 561	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyV	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   206: aload_1
    //   207: ldc_w 680
    //   210: ldc_w 333
    //   213: invokeinterface 803 3 0
    //   218: putfield 683	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myx	Ljava/lang/String;
    //   221: aload_0
    //   222: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   225: aload_1
    //   226: ldc_w 685
    //   229: iconst_0
    //   230: invokeinterface 814 3 0
    //   235: putfield 553	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyT	Z
    //   238: aload_0
    //   239: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   242: aload_1
    //   243: ldc 176
    //   245: lconst_0
    //   246: invokeinterface 798 4 0
    //   251: putfield 695	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyW	J
    //   254: aload_0
    //   255: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   258: aload_1
    //   259: ldc_w 696
    //   262: iconst_0
    //   263: invokeinterface 592 3 0
    //   268: putfield 544	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   271: aload_0
    //   272: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   275: aload_1
    //   276: ldc_w 625
    //   279: iconst_0
    //   280: invokeinterface 592 3 0
    //   285: putfield 643	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyY	I
    //   288: aload_0
    //   289: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   292: aload_1
    //   293: ldc_w 698
    //   296: iconst_0
    //   297: invokeinterface 592 3 0
    //   302: putfield 700	com/tencent/xweb/xwalk/updater/SchedulerConfig:nPatchTargetVersion	I
    //   305: aload_0
    //   306: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   309: aload_1
    //   310: ldc_w 586
    //   313: iconst_0
    //   314: invokeinterface 592 3 0
    //   319: putfield 605	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyZ	I
    //   322: aload_0
    //   323: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   326: aload_1
    //   327: ldc_w 701
    //   330: ldc_w 333
    //   333: invokeinterface 803 3 0
    //   338: putfield 570	com/tencent/xweb/xwalk/updater/SchedulerConfig:patchMd5	Ljava/lang/String;
    //   341: aload_0
    //   342: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   345: aload_1
    //   346: ldc_w 703
    //   349: ldc_w 333
    //   352: invokeinterface 803 3 0
    //   357: putfield 706	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyX	Ljava/lang/String;
    //   360: aload_0
    //   361: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   364: aload_1
    //   365: ldc_w 691
    //   368: iconst_0
    //   369: invokeinterface 814 3 0
    //   374: putfield 547	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myt	Z
    //   377: aload_0
    //   378: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   381: aload_1
    //   382: ldc_w 692
    //   385: iconst_0
    //   386: invokeinterface 814 3 0
    //   391: putfield 550	com/tencent/xweb/xwalk/updater/SchedulerConfig:bUseCdn	Z
    //   394: aload_0
    //   395: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   398: aload_1
    //   399: ldc_w 708
    //   402: iconst_1
    //   403: invokeinterface 814 3 0
    //   408: putfield 710	com/tencent/xweb/xwalk/updater/SchedulerConfig:bTryUseSharedCore	Z
    //   411: aload_0
    //   412: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   415: aload_1
    //   416: ldc_w 712
    //   419: iconst_1
    //   420: invokeinterface 814 3 0
    //   425: putfield 715	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mzc	Z
    //   428: aload_0
    //   429: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   432: aload_1
    //   433: ldc_w 716
    //   436: ldc_w 333
    //   439: invokeinterface 803 3 0
    //   444: putfield 564	com/tencent/xweb/xwalk/updater/SchedulerConfig:strAbi	Ljava/lang/String;
    //   447: aload_0
    //   448: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   451: aload_1
    //   452: ldc_w 718
    //   455: ldc_w 333
    //   458: invokeinterface 803 3 0
    //   463: putfield 720	com/tencent/xweb/xwalk/updater/SchedulerConfig:path	Ljava/lang/String;
    //   466: aload_0
    //   467: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   470: aload_1
    //   471: ldc_w 738
    //   474: ldc_w 333
    //   477: invokeinterface 803 3 0
    //   482: putfield 656	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myu	Ljava/lang/String;
    //   485: aload_0
    //   486: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   489: aload_1
    //   490: ldc_w 740
    //   493: ldc_w 333
    //   496: invokeinterface 803 3 0
    //   501: putfield 659	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myv	Ljava/lang/String;
    //   504: aload_0
    //   505: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   508: aload_1
    //   509: ldc_w 461
    //   512: ldc_w 333
    //   515: invokeinterface 803 3 0
    //   520: putfield 459	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myw	Ljava/lang/String;
    //   523: aload_0
    //   524: getfield 667	com/tencent/xweb/xwalk/updater/c:MyK	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   527: astore_1
    //   528: goto -514 -> 14
    //   531: astore_1
    //   532: aload_0
    //   533: monitorexit
    //   534: aload_1
    //   535: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	c
    //   13	515	1	localObject1	Object
    //   531	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	531	finally
    //   18	87	531	finally
    //   90	528	531	finally
  }
  
  public double gdK()
  {
    MyJ = false;
    return bbD(zT(false)) * 3600000.0D;
  }
  
  public double gdL()
  {
    MyJ = false;
    return bbD(zT(true)) * 3600000.0D;
  }
  
  public void gdM()
  {
    double d = e.gbY();
    if ((d < gdH().Mza) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = e.gbX())
    {
      l1 = (a(0.0D, I(gdH().Mza), s(gdH().Mza, gdH().Mzb)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      gdH().MyW = (l2 + l1);
      e(gdH());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public boolean gdN()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!t(e.Fg(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.gbX() != e.c((Calendar)localObject))
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
    localObject = new c()
    {
      public final String gdd()
      {
        return "UNITEST";
      }
      
      protected final String zR(boolean paramAnonymousBoolean)
      {
        return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
      }
    }.gdJ();
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
  
  public abstract String gdd();
  
  public int gde()
  {
    return 0;
  }
  
  public void gdv()
  {
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
    e(null);
  }
  
  public String gdw()
  {
    if (gdx())
    {
      Object localObject = new Date(gdH().MyW);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TAG).append(":has scheduler for ver = ").append(gdH().version).append(" version id = ").append(gdH().Myk).append(" update time in ").append(((Date)localObject).toString());
      if (!TextUtils.isEmpty(gdH().Myu))
      {
        localObject = " update speed config:" + gdH().Myu;
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(gdH().Myv)) {
          break label221;
        }
        localObject = " update forward speed config:" + gdH().Myv;
        label162:
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(gdH().Myw)) {
          break label228;
        }
      }
      label221:
      label228:
      for (localObject = " update time range config:" + gdH().Myw;; localObject = "")
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
  
  public boolean gdx()
  {
    if (!gdy()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
    return true;
  }
  
  /* Error */
  public boolean gdy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 454	com/tencent/xweb/xwalk/updater/c:gdH	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: invokevirtual 454	com/tencent/xweb/xwalk/updater/c:gdH	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   13: getfield 544	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   16: ifle +28 -> 44
    //   19: aload_0
    //   20: invokevirtual 454	com/tencent/xweb/xwalk/updater/c:gdH	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   23: getfield 628	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myl	Ljava/lang/String;
    //   26: ifnull +18 -> 44
    //   29: aload_0
    //   30: invokevirtual 454	com/tencent/xweb/xwalk/updater/c:gdH	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   33: getfield 628	com/tencent/xweb/xwalk/updater/SchedulerConfig:Myl	Ljava/lang/String;
    //   36: invokevirtual 942	java/lang/String:isEmpty	()Z
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
    //   0	60	0	this	c
    //   39	13	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	55	finally
  }
  
  protected boolean gdz()
  {
    return false;
  }
  
  protected abstract String zR(boolean paramBoolean);
  
  public boolean zS(boolean paramBoolean)
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
        bool = gdy();
        if (!bool)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        if ((gdz()) || (MyI))
        {
          g.t(903L, gde() + 157, 1L);
          paramBoolean = true;
          continue;
        }
        Object localObject1 = a.mV("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = e.bbo((String)localObject1);
          if ((((e.a)localObject1).Mux) && (((e.a)localObject1).doubleValue() >= 0.0D) && (((e.a)localObject1).doubleValue() <= 24.0D)) {
            ((e.a)localObject1).doubleValue();
          }
        }
        l2 = System.currentTimeMillis();
        d1 = gdK();
        if (MyJ)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
          g.t(903L, gde() + 163, 1L);
        }
        d2 = gdL();
        if (MyJ)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
          g.t(903L, gde() + 163, 1L);
        }
        l1 = gdH().MyW;
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
        g.t(903L, gde() + 155, 1L);
        l1 = l2 - l1;
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
        l3 = l2 - l1;
        l4 = e.gbX();
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
        gdM();
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
              g.t(903L, gde() + 154, 1L);
              break label871;
              if ((l3 < 0L) && (-l3 < d2))
              {
                paramBoolean = true;
                g.t(903L, gde() + 161, 1L);
                if ((bool) && (!paramBoolean)) {
                  g.t(903L, gde() + 150, 1L);
                }
                if ((!bool) && (paramBoolean)) {
                  g.t(903L, gde() + 151, 1L);
                }
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
                if (paramBoolean)
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
                  g.t(903L, gde() + 152, 1L);
                  paramBoolean = true;
                  continue;
                }
                if (gdA())
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
                  g.t(903L, gde() + 153, 1L);
                  paramBoolean = true;
                  continue;
                }
                if (c(l1, d1 / 18000000.0D))
                {
                  g.t(903L, gde() + 162, 1L);
                  paramBoolean = true;
                  continue;
                }
                if ((i != 0) && ((l2 - gdH().MyW > 0L) || (Math.abs(l2 - gdH().MyW) > 7776000000L)))
                {
                  gdM();
                  g.t(903L, gde() + 156, 1L);
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
  
  public final String zT(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(gdH().Myv))) {
      return gdH().Myv;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(gdH().Myu))) {
      return gdH().Myu;
    }
    return zR(paramBoolean);
  }
  
  static final class a
  {
    public double EzS;
    public double MyM;
    public double MyN;
    public double[] MyO;
    
    a()
    {
      AppMethodBeat.i(195595);
      this.MyO = new double[0];
      this.EzS = 1.0D;
      AppMethodBeat.o(195595);
    }
    
    public final double J(double paramDouble)
    {
      int i = 0;
      if ((paramDouble < this.MyM) || (paramDouble > this.MyN)) {
        return 0.0D;
      }
      if ((this.MyO == null) || (this.MyO.length == 0)) {
        return this.EzS;
      }
      if (this.MyO.length == 1) {
        return this.MyO[0];
      }
      if (paramDouble == this.MyN) {
        return this.MyO[(this.MyO.length - 1)];
      }
      int j = this.MyO.length - 1;
      double d1 = (this.MyN - this.MyM) / j;
      paramDouble -= this.MyM;
      while (i < j)
      {
        double d3 = i + 1;
        double d2 = i;
        if (paramDouble <= d3 * d1)
        {
          d3 = this.MyO[i];
          return (this.MyO[(i + 1)] - this.MyO[i]) * (paramDouble - d2 * d1) / d1 + d3;
        }
        i += 1;
      }
      return this.MyO[(this.MyO.length - 1)];
    }
  }
  
  static final class b
  {
    public c.a MyP;
    public c.a MyQ;
    
    b()
    {
      AppMethodBeat.i(195596);
      this.MyP = new c.a();
      this.MyQ = new c.a();
      AppMethodBeat.o(195596);
    }
    
    public final boolean b(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(195597);
      if ((paramDouble2 > this.MyP.MyN) || (paramDouble2 < this.MyP.MyM))
      {
        AppMethodBeat.o(195597);
        return false;
      }
      if ((paramDouble1 > this.MyQ.MyN) || (paramDouble1 < this.MyQ.MyM))
      {
        AppMethodBeat.o(195597);
        return false;
      }
      if (XWalkEnvironment.getDeviceRd() <= u(paramDouble1, paramDouble2) * 10000.0D * paramDouble3)
      {
        AppMethodBeat.o(195597);
        return true;
      }
      AppMethodBeat.o(195597);
      return false;
    }
    
    public final double u(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(195598);
      paramDouble2 = this.MyP.J(paramDouble2);
      paramDouble1 = this.MyQ.J(paramDouble1);
      AppMethodBeat.o(195598);
      return paramDouble2 * paramDouble1;
    }
    
    public final String v(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(195599);
      String str = "[ " + this.MyP.MyM + "," + this.MyP.MyN + "] => [" + this.MyQ.MyM + "," + this.MyQ.MyN + "],scale=" + u(paramDouble1, paramDouble2);
      AppMethodBeat.o(195599);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.c
 * JD-Core Version:    0.7.0.1
 */