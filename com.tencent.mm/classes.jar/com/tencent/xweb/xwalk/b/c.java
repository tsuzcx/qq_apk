package com.tencent.xweb.xwalk.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.i;
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

public abstract class c
{
  public static boolean aakL = false;
  static boolean aakM = false;
  protected String TAG = iyV() + "Scheduler";
  d aakN;
  
  public static k IY(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localk = j.izU();
        return localk;
      }
      finally {}
      k localk = k.izV();
    }
  }
  
  public static double L(double paramDouble)
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
  
  private static boolean Xp(long paramLong)
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
      double d2 = ((a)paramList.next()).s(paramDouble1, paramDouble2) * paramDouble3;
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
    if (!TextUtils.isEmpty(parama.aakr))
    {
      l1 = b(parama, paramString);
      XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.aaku > 0)
    {
      long l2 = parama.aaku * 60 * 1000;
      if (0L == l2)
      {
        XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.aadO.aaee > 0) && (parama.aadO.aaee <= 10000))
      {
        i = parama.aadO.aaee;
        label174:
        if ((parama.aadO.aaef <= 0) || (parama.aadO.aaef > 10000)) {
          break label280;
        }
      }
      label280:
      for (int j = parama.aadO.aaef;; j = 10000)
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
    double d1 = e.ixB();
    double d2 = e.Xf(paramLong);
    aakM = false;
    Object localObject = izI();
    if (aakM)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
      h.u(903L, iyW() + 163, 1L);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.b(d1, d2, paramDouble))
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "matched timerange zone cur time is " + d1 + " scheduleHour is " + d2 + "time range is " + locala.t(d1, d2));
        return true;
      }
    }
    return false;
  }
  
  private static long b(a.a parama, String paramString)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (TextUtils.isEmpty(parama.aakr))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parama.aaks)) {
        break label469;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parama.aaks);
      paramString = (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog(paramString, " parse version release date failed " + localException.getMessage());
        h.u(903L, 158L, 1L);
        paramString = (String)localObject2;
      }
      if ((parama.aadO.aaee <= 0) || (parama.aadO.aaee > 10000)) {
        break label591;
      }
      int j = parama.aadO.aaee;
      if ((parama.aadO.aaef <= 0) || (parama.aadO.aaef > 10000)) {
        break label597;
      }
      for (k = parama.aadO.aaef;; k = 10000)
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
      d1 = e.ixB();
      d2 = L(parama.aakp);
      d3 = q(parama.aakp, parama.aakq);
      j -= i;
      i = j;
      if (j > 0) {
        break label679;
      }
      if ((!parama.aakx) || (d1 <= d2)) {
        break label709;
      }
      Log.i("Scheduler", "low priority version. schedule to next day to update");
      i = 1;
      return (a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.ixA());
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
        localObject1 = parama.aakr.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.bFC((String)localObject3);
              if (!((e.a)localObject3).aafP) {
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
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parama.aakr);
            localObject1 = null;
            break;
            label273:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parama.aakr);
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
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parama.aakr);
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
  
  public static double bFU(String paramString)
  {
    return f(paramString, e.ixB());
  }
  
  private static a bFV(String paramString)
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
    locala.aakP = i.bFx(paramString[0]);
    if (locala.aakP == null)
    {
      Log.e("getTimeRangePairItem", "parse rangefrom failed");
      return null;
    }
    locala.aakQ = i.bFx(paramString[1]);
    if (locala.aakQ == null)
    {
      Log.e("getTimeRangePairItem", "parse rangeTo failed");
      return null;
    }
    return locala;
  }
  
  private static String[] bFW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split(";");
  }
  
  private boolean bc(long paramLong1, long paramLong2)
  {
    long l = izE();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2)) {
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "the most recent time to fetch config is too close");
    return false;
  }
  
  public static double f(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 1.0D;
      paramString = bFW(paramString);
      if ((paramString == null) || (paramString.length == 0))
      {
        aakM = true;
        return 1.0D;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = i.bFx((String)localObject);
          if ((localObject != null) && (paramDouble >= ((i)localObject).aaeW) && (paramDouble <= ((i)localObject).aaeX)) {
            return ((i)localObject).J(paramDouble);
          }
        }
        i += 1;
      }
    }
  }
  
  public static void izA()
  {
    try
    {
      k localk = IY(false);
      SharedPreferences.Editor localEditor = localk.izC().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localk.izG().aakS = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void izB()
  {
    try
    {
      k localk = IY(false);
      SharedPreferences.Editor localEditor = localk.izC().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localk.izG().aakS = 0L;
      localk.izG().aakX = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private SharedPreferences izC()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + iyV());
  }
  
  public static long izE()
  {
    long l1 = a.ivJ().aG("force_cmd_period", "tools", 0) * 60000L;
    if (Xp(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkEnvironment.getConfigFetchPeriod();
        l1 = l2;
      } while (Xp(l2));
      l2 = a.ivO();
      l1 = l2;
    } while (Xp(l2));
    return 86400000L;
  }
  
  private String izH()
  {
    if (!TextUtils.isEmpty(izG().aakA)) {
      return izG().aakA;
    }
    return iyX();
  }
  
  private List<a> izI()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = izH();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      aakM = true;
      return localArrayList;
    }
    e.ixB();
    int j = localObject1.length;
    int i = 0;
    label61:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = bFV((String)localObject2);
        if (localObject2 != null) {
          break label103;
        }
        aakM = true;
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
  
  public static boolean izN()
  {
    c local2 = new c()
    {
      protected final String IX(boolean paramAnonymousBoolean)
      {
        return "0:59-1:01-0.9;2:59-3:01-0.9;3:59-4:01-0.9;4:59-5:01-0.9;5:29-5:31-0.9;5:59-6:01-0.9;6:29-6:31-0.9;6:59-7:01-0.9;7:29-7:31-0.9;7:59-8:01-0.9;0:00-6:00(1.636806683-2.276643146-2.927125626-4.16300461-4.55588817-5.203755763-5.20765858-5.528990498-5.854745609-6.309553862-6.180110438-5.203755763-4.228129614);6:00-8:00(1.037712038-1.297503247-1.297140048-0.004150848);0-24-5";
      }
      
      public final String iyV()
      {
        return "UNITEST";
      }
      
      protected final String iyX()
      {
        return "6:00-24:00(0.53871206-0.533307-0.53308-0.533309-0.53334-0.533011-0.533012-0.533013-0.533014-0.533015-0.533016-0.70017-0.723018-0.750019-0.7502-0.75021-0.753022-0.533023-0.533024) => 0:00-8:00(1)";
      }
    };
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 15, 0, 0, 0);
    List localList = local2.izI();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(2020, 6, 15, 0, 58, 5);
    double d1 = e.d((Calendar)localObject1);
    a(d1, 21.0D, f(local2.Ja(false), d1) / 5.0D, localList);
    aakM = false;
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (double d2 = 0.0D; localCalendar.get(10) <= 8.0D; d2 = d1)
    {
      double d3 = e.d(localCalendar);
      double d4 = f(local2.Ja(false), d3) / 5.0D;
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
    Log.e("andrewu", "sParseScheduleConfigFailed = " + aakM);
    return true;
  }
  
  public static boolean p(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 0.0D) || (paramDouble1 > 24.0D)) {}
    while ((paramDouble2 < 0.0D) || (paramDouble2 > 24.0D) || (paramDouble2 < paramDouble1)) {
      return false;
    }
    return true;
  }
  
  protected static boolean pg(String paramString1, String paramString2)
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
  
  public static double q(double paramDouble1, double paramDouble2)
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
  
  private static boolean r(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) < 1.E-005D;
  }
  
  protected abstract String IX(boolean paramBoolean);
  
  public boolean IZ(boolean paramBoolean)
  {
    try
    {
      paramBoolean = av(paramBoolean, 0);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String Ja(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(izG().aakz))) {
      return izG().aakz;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(izG().aaky))) {
      return izG().aaky;
    }
    return IX(paramBoolean);
  }
  
  protected boolean a(d paramd1, d paramd2)
  {
    if ((paramd1.version != paramd2.version) || (paramd1.aakw != paramd2.aakw) || (paramd1.aajx != paramd2.aajx) || (paramd1.aakU != paramd2.aakU) || (!pg(paramd1.aakv, paramd2.aakv)) || (!pg(paramd1.aakW, paramd2.aakW)) || (!pg(paramd1.strAbi, paramd2.strAbi)) || (paramd1.aakn != paramd2.aakn)) {}
    while ((paramd1.aakU) && (!pg(paramd1.patchMd5, paramd2.patchMd5))) {
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
  
  public void aDe(int paramInt) {}
  
  public void aDf(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = izC();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      izG().aala = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = izC();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      izG().aakU = false;
      izG().aako = izG().aakW;
      izG().aakw = false;
      e(izG());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
      izt();
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
    izG().aakZ = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean av(boolean paramBoolean, int paramInt)
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
      if (!izw())
      {
        paramBoolean = false;
      }
      else if ((izx()) || (aakL))
      {
        h.u(903L, iyW() + 157, 1L);
        paramBoolean = true;
      }
      else
      {
        Object localObject1 = a.oO("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = e.bFB((String)localObject1);
          if ((((e.a)localObject1).aafP) && (((e.a)localObject1).doubleValue() >= 0.0D) && (((e.a)localObject1).doubleValue() <= 24.0D)) {
            ((e.a)localObject1).doubleValue();
          }
        }
        long l2 = System.currentTimeMillis();
        double d1 = izJ();
        if (aakM)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
          h.u(903L, iyW() + 163, 1L);
        }
        double d2 = izK();
        if (aakM)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
          h.u(903L, iyW() + 163, 1L);
        }
        long l1 = izG().aakX;
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
          h.u(903L, iyW() + 155, 1L);
          l1 = l2 - l1;
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
          l3 = l2 - l1;
          l4 = e.ixA();
          long l5 = l4 + l2;
          if (l1 - 180000L >= l5 - 86400000L) {
            break label906;
          }
          j = 1;
          break label837;
          if (i == 0)
          {
            Log.i(this.TAG, "has no scheduler , ignore dangers time ");
            if ((l3 < 0L) || (l3 > 3600000L)) {
              break label831;
            }
            bool = true;
            h.u(903L, iyW() + 154, 1L);
            break label880;
            label416:
            if ((l3 >= 0L) || (-l3 >= d2)) {
              break label823;
            }
            paramBoolean = true;
            h.u(903L, iyW() + 161, 1L);
            if ((bool) && (!paramBoolean)) {
              h.u(903L, iyW() + 150, 1L);
            }
            if ((!bool) && (paramBoolean)) {
              h.u(903L, iyW() + 151, 1L);
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
            if (paramBoolean)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
              h.u(903L, iyW() + 152, 1L);
              paramBoolean = true;
            }
          }
          else
          {
            if (j != 0)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day ");
              izL();
              h.u(903L, 146L, 1L);
              paramBoolean = av(false, paramInt + 1);
              continue;
            }
            if (k != 0)
            {
              XWalkInitializer.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now ");
              h.u(903L, 147L, 1L);
              paramBoolean = false;
              continue;
            }
            if (m == 0) {
              continue;
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
            h.u(903L, 148L, 1L);
            paramBoolean = false;
            continue;
          }
          if (izz())
          {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
            h.u(903L, iyW() + 153, 1L);
            paramBoolean = true;
            continue;
          }
          if (a(l1, d1 / 18000000.0D))
          {
            h.u(903L, iyW() + 162, 1L);
            paramBoolean = true;
            continue;
          }
          if ((i != 0) && (Math.abs(l2 - izG().aakX) > 7776000000L))
          {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is far beyond");
            izL();
            h.u(903L, iyW() + 156, 1L);
            break label924;
          }
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
          break label924;
          label823:
          continue;
          label826:
          paramBoolean = false;
          continue;
          label831:
          boolean bool = false;
          break label880;
          label837:
          if (180000L + l1 <= l5) {
            break label912;
          }
        }
        label906:
        label912:
        for (int k = 1;; k = 0)
        {
          if ((l4 >= 180000L) && (l4 + 180000L <= 86400000L)) {
            break label918;
          }
          m = 1;
          break label363;
          label880:
          if ((l3 < 0L) || (l3 >= d1)) {
            break label826;
          }
          paramBoolean = true;
          break label416;
          i = 1;
          break;
          j = 0;
          break label837;
        }
        label918:
        int m = 0;
        continue;
        label924:
        paramBoolean = false;
      }
    }
  }
  
  public d d(d paramd)
  {
    int j = 1;
    d locald = izG();
    if (paramd == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
      if (izw())
      {
        if (locald != null) {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "clear current scheduler version = " + locald.version);
        }
        e(paramd);
      }
      return null;
    }
    int i;
    if (a(paramd, locald))
    {
      i = 0;
      if (!pg(paramd.aaky, locald.aaky))
      {
        locald.aaky = paramd.aaky;
        i = 1;
      }
      if (!pg(paramd.aakz, locald.aakz))
      {
        locald.aakz = paramd.aakz;
        i = 1;
      }
      if (pg(paramd.aakA, locald.aakA)) {
        break label233;
      }
      locald.aakA = paramd.aakA;
      i = j;
    }
    label233:
    for (;;)
    {
      if (i != 0) {
        e(locald);
      }
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got same version to scheduler, use last version ");
      return locald;
      if (izw())
      {
        h.u(903L, 149L, 1L);
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "got new scheduler replace current , version is " + paramd.version);
      }
      e(paramd);
      return paramd;
    }
  }
  
  public void e(d paramd)
  {
    try
    {
      this.aakN = paramd;
      if (paramd == null) {
        this.aakN = new d();
      }
      this.aakN.aakR = iyV();
      paramd = izC().edit();
      paramd.putString("strMd5", this.aakN.aakv);
      paramd.putString("strUrl", this.aakN.aako);
      paramd.putString("strFullPackageUrl", this.aakN.aakW);
      paramd.putString("strConfigVer", this.aakN.aakB);
      paramd.putBoolean("bIsPatchUpdate", this.aakN.aakU);
      paramd.putBoolean("bCanUseCellular", this.aakN.aakw);
      paramd.putBoolean("bUseCdn", this.aakN.aajx);
      paramd.putLong("nTimeToUpdate", this.aakN.aakX);
      paramd.putInt("version", this.aakN.version);
      paramd.putInt("nTryCnt", this.aakN.aakZ);
      paramd.putInt("nPatchTargetVersion", this.aakN.aajt);
      paramd.putInt("nTryUseSharedCoreCount", this.aakN.aala);
      paramd.putString("patchMd5", this.aakN.patchMd5);
      paramd.putString("strVersionDetail", this.aakN.aakY);
      paramd.putBoolean("bTryUseSharedCore", this.aakN.aajy);
      paramd.putBoolean("skipSubFileMD5Check", this.aakN.aald);
      paramd.putString("strAbi", this.aakN.strAbi);
      paramd.putString("path", this.aakN.path);
      paramd.putInt("versionId", this.aakN.aakn);
      paramd.putFloat("timeHourStart", this.aakN.aalb);
      paramd.putFloat("timeHourEnd", this.aakN.aalc);
      paramd.putString("UPDATE_SPEED_CONFIG", this.aakN.aaky);
      paramd.putString("UPDATE_FORWARD_SPEED_CONFIG", this.aakN.aakz);
      paramd.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.aakN.aakA);
      paramd.commit();
      return;
    }
    finally {}
  }
  
  public abstract String iyV();
  
  public int iyW()
  {
    return 0;
  }
  
  protected String iyX()
  {
    return a.oO("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  protected String iyY()
  {
    return a.oO("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
  
  public void izD()
  {
    izG().aakS = System.currentTimeMillis();
    izG().aakT = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = izC().edit();
    localEditor.putLong("nLastFetchConfigTime", izG().aakS);
    localEditor.putString("strLastFetchAbi", izG().aakT);
    localEditor.commit();
  }
  
  public boolean izF()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(izG().aakT)) || (TextUtils.isEmpty(izG().aakT))) {
          continue;
        }
        boolean bool2 = "true".equalsIgnoreCase(b.oO("disable_abi_switch_reset_config_time", "tools"));
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
        if (!izy()) {
          break label114;
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isInFreeFetchConfigTimeZone = true");
        continue;
      }
      finally {}
      return bool1;
      label114:
      long l1 = System.currentTimeMillis();
      if (bc(l1, izG().aakS))
      {
        long l2 = izC().getLong("nLastFetchConfigTime", 0L);
        izG().aakS = l2;
        if (bc(l1, l2))
        {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "enough time after last time fetch config");
          continue;
        }
      }
      bool1 = false;
    }
  }
  
  /* Error */
  public d izG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 441	com/tencent/xweb/xwalk/b/d
    //   22: dup
    //   23: invokespecial 751	com/tencent/xweb/xwalk/b/d:<init>	()V
    //   26: putfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   29: aload_0
    //   30: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   33: aload_0
    //   34: invokevirtual 35	com/tencent/xweb/xwalk/b/c:iyV	()Ljava/lang/String;
    //   37: putfield 754	com/tencent/xweb/xwalk/b/d:aakR	Ljava/lang/String;
    //   40: aload_0
    //   41: invokespecial 424	com/tencent/xweb/xwalk/b/c:izC	()Landroid/content/SharedPreferences;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   49: aload_1
    //   50: ldc_w 432
    //   53: lconst_0
    //   54: invokeinterface 865 4 0
    //   59: putfield 444	com/tencent/xweb/xwalk/b/d:aakS	J
    //   62: aload_0
    //   63: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   66: aload_1
    //   67: ldc_w 840
    //   70: ldc_w 869
    //   73: invokeinterface 872 3 0
    //   78: putfield 838	com/tencent/xweb/xwalk/b/d:aakT	Ljava/lang/String;
    //   81: aload_1
    //   82: ldc_w 762
    //   85: invokeinterface 875 2 0
    //   90: ifne +11 -> 101
    //   93: aload_0
    //   94: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   97: astore_1
    //   98: goto -84 -> 14
    //   101: aload_0
    //   102: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   105: aload_1
    //   106: ldc_w 756
    //   109: ldc_w 869
    //   112: invokeinterface 872 3 0
    //   117: putfield 579	com/tencent/xweb/xwalk/b/d:aakv	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   124: aload_1
    //   125: ldc_w 808
    //   128: iconst_0
    //   129: invokeinterface 612 3 0
    //   134: putfield 590	com/tencent/xweb/xwalk/b/d:aakn	I
    //   137: aload_0
    //   138: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   141: aload_1
    //   142: ldc_w 810
    //   145: ldc_w 876
    //   148: invokeinterface 880 3 0
    //   153: putfield 813	com/tencent/xweb/xwalk/b/d:aalb	F
    //   156: aload_0
    //   157: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   160: aload_1
    //   161: ldc_w 819
    //   164: ldc_w 876
    //   167: invokeinterface 880 3 0
    //   172: putfield 822	com/tencent/xweb/xwalk/b/d:aalc	F
    //   175: aload_0
    //   176: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   179: aload_1
    //   180: ldc_w 762
    //   183: ldc_w 869
    //   186: invokeinterface 872 3 0
    //   191: putfield 641	com/tencent/xweb/xwalk/b/d:aako	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   198: aload_1
    //   199: ldc_w 764
    //   202: ldc_w 869
    //   205: invokeinterface 872 3 0
    //   210: putfield 584	com/tencent/xweb/xwalk/b/d:aakW	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   217: aload_1
    //   218: ldc_w 766
    //   221: ldc_w 869
    //   224: invokeinterface 872 3 0
    //   229: putfield 769	com/tencent/xweb/xwalk/b/d:aakB	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   236: aload_1
    //   237: ldc_w 771
    //   240: iconst_0
    //   241: invokeinterface 884 3 0
    //   246: putfield 576	com/tencent/xweb/xwalk/b/d:aakU	Z
    //   249: aload_0
    //   250: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   253: aload_1
    //   254: ldc 186
    //   256: lconst_0
    //   257: invokeinterface 865 4 0
    //   262: putfield 448	com/tencent/xweb/xwalk/b/d:aakX	J
    //   265: aload_0
    //   266: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   269: aload_1
    //   270: ldc_w 780
    //   273: iconst_0
    //   274: invokeinterface 612 3 0
    //   279: putfield 567	com/tencent/xweb/xwalk/b/d:version	I
    //   282: aload_0
    //   283: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   286: aload_1
    //   287: ldc_w 638
    //   290: iconst_0
    //   291: invokeinterface 612 3 0
    //   296: putfield 656	com/tencent/xweb/xwalk/b/d:aakZ	I
    //   299: aload_0
    //   300: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   303: aload_1
    //   304: ldc_w 782
    //   307: iconst_0
    //   308: invokeinterface 612 3 0
    //   313: putfield 785	com/tencent/xweb/xwalk/b/d:aajt	I
    //   316: aload_0
    //   317: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   320: aload_1
    //   321: ldc_w 608
    //   324: iconst_0
    //   325: invokeinterface 612 3 0
    //   330: putfield 625	com/tencent/xweb/xwalk/b/d:aala	I
    //   333: aload_0
    //   334: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   337: aload_1
    //   338: ldc_w 786
    //   341: ldc_w 869
    //   344: invokeinterface 872 3 0
    //   349: putfield 593	com/tencent/xweb/xwalk/b/d:patchMd5	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   356: aload_1
    //   357: ldc_w 788
    //   360: ldc_w 869
    //   363: invokeinterface 872 3 0
    //   368: putfield 791	com/tencent/xweb/xwalk/b/d:aakY	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   375: aload_1
    //   376: ldc_w 777
    //   379: iconst_0
    //   380: invokeinterface 884 3 0
    //   385: putfield 570	com/tencent/xweb/xwalk/b/d:aakw	Z
    //   388: aload_0
    //   389: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   392: aload_1
    //   393: ldc_w 779
    //   396: iconst_0
    //   397: invokeinterface 884 3 0
    //   402: putfield 573	com/tencent/xweb/xwalk/b/d:aajx	Z
    //   405: aload_0
    //   406: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   409: aload_1
    //   410: ldc_w 793
    //   413: iconst_1
    //   414: invokeinterface 884 3 0
    //   419: putfield 796	com/tencent/xweb/xwalk/b/d:aajy	Z
    //   422: aload_0
    //   423: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   426: aload_1
    //   427: ldc_w 798
    //   430: iconst_1
    //   431: invokeinterface 884 3 0
    //   436: putfield 801	com/tencent/xweb/xwalk/b/d:aald	Z
    //   439: aload_0
    //   440: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   443: aload_1
    //   444: ldc_w 802
    //   447: ldc_w 869
    //   450: invokeinterface 872 3 0
    //   455: putfield 587	com/tencent/xweb/xwalk/b/d:strAbi	Ljava/lang/String;
    //   458: aload_0
    //   459: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   462: aload_1
    //   463: ldc_w 804
    //   466: ldc_w 869
    //   469: invokeinterface 872 3 0
    //   474: putfield 806	com/tencent/xweb/xwalk/b/d:path	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   481: aload_1
    //   482: ldc_w 824
    //   485: ldc_w 869
    //   488: invokeinterface 872 3 0
    //   493: putfield 561	com/tencent/xweb/xwalk/b/d:aaky	Ljava/lang/String;
    //   496: aload_0
    //   497: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   500: aload_1
    //   501: ldc_w 826
    //   504: ldc_w 869
    //   507: invokeinterface 872 3 0
    //   512: putfield 558	com/tencent/xweb/xwalk/b/d:aakz	Ljava/lang/String;
    //   515: aload_0
    //   516: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   519: aload_1
    //   520: ldc_w 828
    //   523: ldc_w 869
    //   526: invokeinterface 872 3 0
    //   531: putfield 480	com/tencent/xweb/xwalk/b/d:aakA	Ljava/lang/String;
    //   534: aload_0
    //   535: getfield 750	com/tencent/xweb/xwalk/b/c:aakN	Lcom/tencent/xweb/xwalk/b/d;
    //   538: astore_1
    //   539: goto -525 -> 14
    //   542: astore_1
    //   543: aload_0
    //   544: monitorexit
    //   545: aload_1
    //   546: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	c
    //   13	526	1	localObject1	Object
    //   542	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	542	finally
    //   18	98	542	finally
    //   101	539	542	finally
  }
  
  public double izJ()
  {
    aakM = false;
    return bFU(Ja(false)) * 3600000.0D;
  }
  
  public double izK()
  {
    aakM = false;
    return bFU(Ja(true)) * 3600000.0D;
  }
  
  public void izL()
  {
    double d = e.ixB();
    if ((d < izG().aalb) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = e.ixA())
    {
      l1 = (a(0.0D, L(izG().aalb), q(izG().aalb, izG().aalc)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      izG().aakX = (l2 + l1);
      e(izG());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public boolean izM()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!r(e.Xf(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.ixA() != e.c((Calendar)localObject))
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
      protected final String IX(boolean paramAnonymousBoolean)
      {
        return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
      }
      
      public final String iyV()
      {
        return "UNITEST";
      }
      
      protected final String iyX()
      {
        return "18:00-20:00(0.5-0.6-0.7-1)=>0:00-3:00(0-1); 20:00 - 21:00(0.5-0.6-0.7) => 3-5(0-0.5); 15.5-17.5(0.5)=>3.5-5.5";
      }
    }.izI();
    if (((List)localObject).size() != 3)
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 1");
      return false;
    }
    ((a)((List)localObject).get(0)).t(1.5D, 19.0D);
    if (!r(((a)((List)localObject).get(0)).s(1.5D, 19.0D), 0.325D))
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
    if (!r(((a)((List)localObject).get(0)).s(3.0D, 20.0D), 1.0D))
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
  
  public void izt()
  {
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
    e(null);
  }
  
  public String izu()
  {
    if (izv())
    {
      Object localObject = new Date(izG().aakX);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TAG).append(":has scheduler for ver = ").append(izG().version).append(" version id = ").append(izG().aakn).append(" update time in ").append(((Date)localObject).toString());
      if (!TextUtils.isEmpty(izG().aaky))
      {
        localObject = " update speed config:" + izG().aaky;
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(izG().aakz)) {
          break label221;
        }
        localObject = " update forward speed config:" + izG().aakz;
        label162:
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(izG().aakA)) {
          break label228;
        }
      }
      label221:
      label228:
      for (localObject = " update time range config:" + izG().aakA;; localObject = "")
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
  
  public boolean izv()
  {
    if (!izw()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
    return true;
  }
  
  /* Error */
  public boolean izw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 439	com/tencent/xweb/xwalk/b/c:izG	()Lcom/tencent/xweb/xwalk/b/d;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: invokevirtual 439	com/tencent/xweb/xwalk/b/c:izG	()Lcom/tencent/xweb/xwalk/b/d;
    //   13: getfield 567	com/tencent/xweb/xwalk/b/d:version	I
    //   16: ifle +28 -> 44
    //   19: aload_0
    //   20: invokevirtual 439	com/tencent/xweb/xwalk/b/c:izG	()Lcom/tencent/xweb/xwalk/b/d;
    //   23: getfield 641	com/tencent/xweb/xwalk/b/d:aako	Ljava/lang/String;
    //   26: ifnull +18 -> 44
    //   29: aload_0
    //   30: invokevirtual 439	com/tencent/xweb/xwalk/b/c:izG	()Lcom/tencent/xweb/xwalk/b/d;
    //   33: getfield 641	com/tencent/xweb/xwalk/b/d:aako	Ljava/lang/String;
    //   36: invokevirtual 1005	java/lang/String:isEmpty	()Z
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
  
  protected boolean izx()
  {
    return false;
  }
  
  public boolean izy()
  {
    String[] arrayOfString = bFW(iyY());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {}
    label109:
    for (;;)
    {
      return false;
      double d = e.ixB();
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
          localObject = i.bFx((String)localObject);
          if ((localObject != null) && (d >= ((i)localObject).aaeW) && (d <= ((i)localObject).aaeX))
          {
            if (XWalkEnvironment.getTodayGrayValue() >= 10000.0D * ((i)localObject).QHt) {
              break;
            }
            return true;
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean izz()
  {
    Object localObject1 = a.oO("free_update_time_zone", "tools");
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
          localObject1 = e.bFB(localObject2[0]);
        } while (!((e.a)localObject1).aafP);
        localObject2 = e.bFB(localObject2[1]);
      } while ((!((e.a)localObject2).aafP) || (!p(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue())));
      d = e.ixB();
    } while ((d < ((e.a)localObject1).doubleValue()) || (d > ((e.a)localObject2).doubleValue()));
    return true;
  }
  
  static final class a
  {
    public i aakP;
    public i aakQ;
    
    a()
    {
      AppMethodBeat.i(205322);
      this.aakP = new i();
      this.aakQ = new i();
      AppMethodBeat.o(205322);
    }
    
    public final boolean b(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(205323);
      if ((paramDouble2 > this.aakP.aaeX) || (paramDouble2 < this.aakP.aaeW))
      {
        AppMethodBeat.o(205323);
        return false;
      }
      if ((paramDouble1 > this.aakQ.aaeX) || (paramDouble1 < this.aakQ.aaeW))
      {
        AppMethodBeat.o(205323);
        return false;
      }
      if (XWalkEnvironment.getTodayGrayValueByKey("DOWNLOAD_SCHEDULE") <= s(paramDouble1, paramDouble2) * 10000.0D * paramDouble3)
      {
        AppMethodBeat.o(205323);
        return true;
      }
      AppMethodBeat.o(205323);
      return false;
    }
    
    public final double s(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(205324);
      paramDouble2 = this.aakP.J(paramDouble2);
      paramDouble1 = this.aakQ.J(paramDouble1);
      AppMethodBeat.o(205324);
      return paramDouble2 * paramDouble1;
    }
    
    public final String t(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(205325);
      String str = "[ " + this.aakP.aaeW + "," + this.aakP.aaeX + "] => [" + this.aakQ.aaeW + "," + this.aakQ.aaeX + "],scale=" + s(paramDouble1, paramDouble2);
      AppMethodBeat.o(205325);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.c
 * JD-Core Version:    0.7.0.1
 */