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
  static g KId;
  public static boolean KIe = false;
  static boolean KIf = false;
  SchedulerConfig KIg;
  protected String TAG = fLH() + "Scheduler";
  
  private boolean Co(long paramLong)
  {
    return r(e.fKD(), e.Ce(paramLong));
  }
  
  private static boolean Cp(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static double H(double paramDouble)
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
  
  public static long a(a.a parama, String paramString)
  {
    long l1 = 0L;
    if (!TextUtils.isEmpty(parama.KHO))
    {
      l1 = b(parama, paramString);
      XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.KHR > 0)
    {
      long l2 = parama.KHR * 60 * 1000;
      if (0L == l2)
      {
        XWalkInitializer.addXWalkInitializeLog(paramString + " schedul after " + l1 / 60L / 1000L + " minute to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.KCh.KCt > 0) && (parama.KCh.KCt <= 10000))
      {
        i = parama.KCh.KCt;
        label174:
        if ((parama.KCh.KCu <= 0) || (parama.KCh.KCu > 10000)) {
          break label280;
        }
      }
      label280:
      for (int j = parama.KCh.KCu;; j = 10000)
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
  
  private boolean aA(long paramLong1, long paramLong2)
  {
    long l = fMk();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2)) {
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "the most recent time to fetch config is too close");
    return false;
  }
  
  public static double aVA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 1.0D;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (String[] arrayOfString = null; (arrayOfString == null) || (arrayOfString.length == 0); arrayOfString = paramString.split(";"))
    {
      KIf = true;
      return 1.0D;
    }
    double d1 = e.fKD();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = arrayOfString[i];
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty(paramString)) {
          paramString = null;
        }
        while ((paramString != null) && (paramString.length == 3) && (d1 >= paramString[0]) && (d1 <= paramString[1]))
        {
          return paramString[2];
          paramString = paramString.trim().split("-");
          if ((paramString == null) || (paramString.length != 3))
          {
            KIf = true;
            Log.e("getTimeSpeedItem", "length error");
            paramString = null;
          }
          else
          {
            double d2 = aVD(paramString[0]);
            if ((d2 < 0.0D) || (d2 > 24.0D))
            {
              KIf = true;
              Log.e("getTimeSpeedItem", "timeStart  parse error");
              paramString = null;
            }
            else
            {
              double d3 = aVD(paramString[1]);
              if ((d3 < 0.0D) || (d3 > 24.0D))
              {
                KIf = true;
                Log.e("getTimeSpeedItem", "timeEnd  parse error");
                paramString = null;
              }
              else
              {
                paramString = e.aVl(paramString[2]);
                if (!paramString.KDX)
                {
                  KIf = true;
                  Log.e("getTimeSpeedItem", "retScale.doubleValue parse error");
                  paramString = null;
                }
                else
                {
                  double d4 = paramString.doubleValue();
                  if (d4 < 0.0D)
                  {
                    KIf = true;
                    Log.e("getTimeSpeedItem", "retScale.doubleValue parse error2");
                    paramString = null;
                  }
                  else
                  {
                    paramString = new double[3];
                    paramString[0] = d2;
                    paramString[1] = d3;
                    paramString[2] = d4;
                  }
                }
              }
            }
          }
        }
      }
      i += 1;
    }
    return 1.0D;
  }
  
  private static a aVB(String paramString)
  {
    int i = 0;
    a locala = new a();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("getTimeRangeItem", "length error");
      return null;
    }
    double d = aVD(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      return null;
    }
    locala.KIi = d;
    d = aVD(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
      return null;
    }
    locala.KIj = d;
    if (paramString.length == 3)
    {
      paramString = e.aVl(paramString[2]);
      if (!paramString.KDX)
      {
        Log.e("getTimeRangeItem", "scale parse error");
        return null;
      }
      d = paramString.doubleValue();
      if ((d < 0.0D) || (d > 1.0001D))
      {
        Log.e("getTimeRangeItem", "scale parse value error");
        return null;
      }
      locala.CVW = d;
    }
    for (;;)
    {
      return locala;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        while (i + 2 < paramString.length)
        {
          e.a locala1 = e.aVl(paramString[(i + 2)]);
          if (!locala1.KDX)
          {
            Log.e("getTimeRangeItem", "scales parse error");
            return null;
          }
          d = locala1.doubleValue();
          if ((d < 0.0D) || (d > 1.0001D))
          {
            Log.e("getTimeRangeItem", "scales parse value error");
            return null;
          }
          arrayOfDouble[i] = d;
          i += 1;
        }
        locala.KIk = arrayOfDouble;
      }
    }
  }
  
  private static b aVC(String paramString)
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
    localb.KIl = aVB(paramString[0]);
    if (localb.KIl == null)
    {
      Log.e("getTimeRangePairItem", "parse rangefrom failed");
      return null;
    }
    localb.KIm = aVB(paramString[1]);
    if (localb.KIm == null)
    {
      Log.e("getTimeRangePairItem", "parse rangeTo failed");
      return null;
    }
    return localb;
  }
  
  private static double aVD(String paramString)
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
          locala = e.aVl(paramString[0]);
        } while (!locala.KDX);
        d2 = locala.doubleValue();
        d1 = d2;
        if (paramString.length != 2) {
          break;
        }
        i = e.aVm(paramString[1]).intValue();
      } while ((i < 0) || (i >= 60));
      d1 = d2 + i * 1.0D / 60.0D;
    } while ((d1 < 0.0D) || (d1 > 24.0D));
    return d1;
  }
  
  private static long b(a.a parama, String paramString)
  {
    int m = 0;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (TextUtils.isEmpty(parama.KHO))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parama.KHP)) {
        break label460;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parama.KHP);
      paramString = (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog(paramString, " parse version release date failed " + localException.getMessage());
        com.tencent.xweb.util.g.r(903L, 158L, 1L);
        paramString = (String)localObject2;
      }
      if ((parama.KCh.KCt <= 0) || (parama.KCh.KCt > 10000)) {
        break label583;
      }
      j = parama.KCh.KCt;
      if ((parama.KCh.KCu <= 0) || (parama.KCh.KCu > 10000)) {
        break label589;
      }
      for (k = parama.KCh.KCu;; k = 10000)
      {
        d1 = (XWalkEnvironment.getGrayValue() - j) * 10000.0D / (k - j + 1);
        j = m;
        while ((j < localObject1.length) && (d1 > localObject1[j])) {
          j += 1;
        }
        j = 0;
        break;
      }
      Calendar.getInstance();
      d1 = e.fKD();
      d2 = H(parama.KHM);
      d3 = t(parama.KHM, parama.KHN);
      j -= i;
      int i = j;
      if (j > 0) {
        break label656;
      }
      if (d1 < d3) {
        break label686;
      }
      i = 1;
      return (a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.fKC());
    }
    double d1 = (new Date().getTime() - paramString.getTime()) / 86400000.0D;
    i = (int)d1;
    if ((d1 < 1.0D) || (d1 > 365.0D)) {
      i = 0;
    }
    for (;;)
    {
      int j;
      int k;
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        return 0L;
        localObject2 = new ArrayList();
        localObject1 = parama.KHO.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.aVm((String)localObject3);
              if (!((e.a)localObject3).KDX) {
                break label264;
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
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parama.KHO);
            localObject1 = null;
            break;
            label264:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parama.KHO);
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
            break label420;
          }
          j = ((e.a)((List)localObject2).get(i)).intValue();
          if ((i > 0) && (j < localObject1[(i - 1)]))
          {
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parama.KHO);
            localObject1 = null;
            break;
          }
          localObject1[i] = j;
          i += 1;
        }
        label420:
        break;
      }
      label460:
      label589:
      double d2;
      label583:
      double d3;
      label656:
      label686:
      return ((a(d1, d2, d3) - d1) * 3600000.0D);
    }
  }
  
  public static g fLZ()
  {
    try
    {
      if (KId == null) {
        KId = new g();
      }
      g localg = KId;
      return localg;
    }
    finally {}
  }
  
  private SharedPreferences fMi()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + fLH());
  }
  
  private List<b> fMn()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = fLJ();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      KIf = true;
      return localArrayList;
    }
    e.fKD();
    int j = localObject1.length;
    int i = 0;
    label60:
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = aVC((String)localObject2);
        if (localObject2 != null) {
          break label102;
        }
        KIf = true;
      }
    }
    for (;;)
    {
      i += 1;
      break label60;
      break;
      label102:
      localArrayList.add(localObject2);
    }
  }
  
  protected static boolean mN(String paramString1, String paramString2)
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
  
  private boolean r(double paramDouble1, double paramDouble2)
  {
    KIf = false;
    Object localObject = fMn();
    if (KIf)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
      com.tencent.xweb.util.g.r(903L, fLI() + 163, 1L);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.v(paramDouble1, paramDouble2))
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "matched timerange zone cur time is " + paramDouble1 + " scheduleHour is " + paramDouble2 + "time range is " + localb.x(paramDouble1, paramDouble2));
        return true;
      }
    }
    return false;
  }
  
  public static boolean s(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 0.0D) || (paramDouble1 > 24.0D)) {}
    while ((paramDouble2 < 0.0D) || (paramDouble2 > 24.0D) || (paramDouble2 < paramDouble1)) {
      return false;
    }
    return true;
  }
  
  public static double t(double paramDouble1, double paramDouble2)
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
  
  private static boolean u(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) < 1.E-005D;
  }
  
  protected boolean a(SchedulerConfig paramSchedulerConfig1, SchedulerConfig paramSchedulerConfig2)
  {
    if ((paramSchedulerConfig1.version != paramSchedulerConfig2.version) || (paramSchedulerConfig1.KHT != paramSchedulerConfig2.KHT) || (paramSchedulerConfig1.bUseCdn != paramSchedulerConfig2.bUseCdn) || (paramSchedulerConfig1.KIp != paramSchedulerConfig2.KIp) || (!mN(paramSchedulerConfig1.KHS, paramSchedulerConfig2.KHS)) || (!mN(paramSchedulerConfig1.KIq, paramSchedulerConfig2.KIq)) || (!mN(paramSchedulerConfig1.strAbi, paramSchedulerConfig2.strAbi)) || (paramSchedulerConfig1.KHK != paramSchedulerConfig2.KHK)) {}
    while ((paramSchedulerConfig1.KIp) && (!mN(paramSchedulerConfig1.patchMd5, paramSchedulerConfig2.patchMd5))) {
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
  
  public void agp(int paramInt) {}
  
  public void agq(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = fMi();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      fMm().KIu = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = fMi();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      fMm().KIp = false;
      fMm().KHL = fMm().KIq;
      fMm().KHT = false;
      e(fMm());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
      fMa();
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
    fMm().KIt = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public SchedulerConfig d(SchedulerConfig paramSchedulerConfig)
  {
    SchedulerConfig localSchedulerConfig = fMm();
    if (paramSchedulerConfig == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
      if (fMd())
      {
        if (localSchedulerConfig != null) {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "clear current scheduler version = " + localSchedulerConfig.version);
        }
        e(paramSchedulerConfig);
      }
      return null;
    }
    if (a(paramSchedulerConfig, localSchedulerConfig))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got same version to scheduler, use last version ");
      return localSchedulerConfig;
    }
    if (fMd())
    {
      com.tencent.xweb.util.g.r(903L, 149L, 1L);
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "got new scheduler replace current , version is " + paramSchedulerConfig.version);
    }
    e(paramSchedulerConfig);
    return paramSchedulerConfig;
  }
  
  public void e(SchedulerConfig paramSchedulerConfig)
  {
    try
    {
      this.KIg = paramSchedulerConfig;
      if (paramSchedulerConfig == null) {
        this.KIg = new SchedulerConfig();
      }
      paramSchedulerConfig = fMi().edit();
      paramSchedulerConfig.putString("strMd5", this.KIg.KHS);
      paramSchedulerConfig.putString("strUrl", this.KIg.KHL);
      paramSchedulerConfig.putString("strFullPackageUrl", this.KIg.KIq);
      paramSchedulerConfig.putString("strConfigVer", this.KIg.KHU);
      paramSchedulerConfig.putBoolean("bIsPatchUpdate", this.KIg.KIp);
      paramSchedulerConfig.putBoolean("bCanUseCellular", this.KIg.KHT);
      paramSchedulerConfig.putBoolean("bUseCdn", this.KIg.bUseCdn);
      paramSchedulerConfig.putLong("nTimeToUpdate", this.KIg.KIr);
      paramSchedulerConfig.putInt("version", this.KIg.version);
      paramSchedulerConfig.putInt("nTryCnt", this.KIg.KIt);
      paramSchedulerConfig.putInt("nPatchTargetVersion", this.KIg.nPatchTargetVersion);
      paramSchedulerConfig.putInt("nTryUseSharedCoreCount", this.KIg.KIu);
      paramSchedulerConfig.putString("patchMd5", this.KIg.patchMd5);
      paramSchedulerConfig.putString("strVersionDetail", this.KIg.KIs);
      paramSchedulerConfig.putBoolean("bTryUseSharedCore", this.KIg.bTryUseSharedCore);
      paramSchedulerConfig.putBoolean("skipSubFileMD5Check", this.KIg.KIx);
      paramSchedulerConfig.putString("strAbi", this.KIg.strAbi);
      paramSchedulerConfig.putString("path", this.KIg.path);
      paramSchedulerConfig.putInt("versionId", this.KIg.KHK);
      paramSchedulerConfig.putFloat("timeHourStart", this.KIg.KIv);
      paramSchedulerConfig.putFloat("timeHourEnd", this.KIg.KIw);
      paramSchedulerConfig.commit();
      return;
    }
    finally {}
  }
  
  public abstract String fLH();
  
  public int fLI()
  {
    return 0;
  }
  
  protected String fLJ()
  {
    return a.mx("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  public void fMa()
  {
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
    e(null);
  }
  
  public String fMb()
  {
    if (fMc())
    {
      Date localDate = new Date(fMm().KIr);
      return this.TAG + ":has scheduler for ver = " + fMm().version + " version id = " + fMm().KHK + " update time in " + localDate.toString();
    }
    return this.TAG + ":has no scheduler";
  }
  
  public boolean fMc()
  {
    if (!fMd()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
    return true;
  }
  
  /* Error */
  public boolean fMd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 542	com/tencent/xweb/xwalk/updater/c:fMm	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: invokevirtual 542	com/tencent/xweb/xwalk/updater/c:fMm	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   13: getfield 479	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   16: ifle +28 -> 44
    //   19: aload_0
    //   20: invokevirtual 542	com/tencent/xweb/xwalk/updater/c:fMm	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   23: getfield 568	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHL	Ljava/lang/String;
    //   26: ifnull +18 -> 44
    //   29: aload_0
    //   30: invokevirtual 542	com/tencent/xweb/xwalk/updater/c:fMm	()Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   33: getfield 568	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHL	Ljava/lang/String;
    //   36: invokevirtual 704	java/lang/String:isEmpty	()Z
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
  
  protected boolean fMe()
  {
    return false;
  }
  
  public boolean fMf()
  {
    Object localObject1 = a.mx("free_update_time_zone", "tools");
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
          localObject1 = e.aVl(localObject2[0]);
        } while (!((e.a)localObject1).KDX);
        localObject2 = e.aVl(localObject2[1]);
      } while ((!((e.a)localObject2).KDX) || (!s(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue())));
      d = e.fKD();
    } while ((d < ((e.a)localObject1).doubleValue()) || (d > ((e.a)localObject2).doubleValue()));
    return true;
  }
  
  public void fMg()
  {
    try
    {
      SharedPreferences.Editor localEditor = fMi().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      fMm().KIn = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void fMh()
  {
    try
    {
      SharedPreferences.Editor localEditor = fMi().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      fMm().KIn = 0L;
      fMm().KIr = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void fMj()
  {
    fMm().KIn = System.currentTimeMillis();
    fMm().KIo = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = fMi().edit();
    localEditor.putLong("nLastFetchConfigTime", fMm().KIn);
    localEditor.putString("strLastFetchAbi", fMm().KIo);
    localEditor.commit();
  }
  
  public long fMk()
  {
    long l1 = a.my("force_cmd_period", "tools") * 60000L;
    if (Cp(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkEnvironment.getConfigFetchPeriod();
        l1 = l2;
      } while (Cp(l2));
      l2 = a.fIS();
      l1 = l2;
    } while (Cp(l2));
    return 86400000L;
  }
  
  public boolean fMl()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if ((XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(fMm().KIo)) || (TextUtils.isEmpty(fMm().KIo))) {
          continue;
        }
        boolean bool2 = "true".equalsIgnoreCase(b.mx("disable_abi_switch_reset_config_time", "tools"));
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
        long l1 = System.currentTimeMillis();
        if (!aA(l1, fMm().KIn)) {
          break label160;
        }
        long l2 = fMi().getLong("nLastFetchConfigTime", 0L);
        fMm().KIn = l2;
        if (!aA(l1, l2)) {
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
  public SchedulerConfig fMm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 476	com/tencent/xweb/xwalk/updater/SchedulerConfig
    //   22: dup
    //   23: invokespecial 603	com/tencent/xweb/xwalk/updater/SchedulerConfig:<init>	()V
    //   26: putfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   29: aload_0
    //   30: invokespecial 520	com/tencent/xweb/xwalk/updater/c:fMi	()Landroid/content/SharedPreferences;
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   38: aload_1
    //   39: ldc_w 716
    //   42: lconst_0
    //   43: invokeinterface 763 4 0
    //   48: putfield 719	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIn	J
    //   51: aload_0
    //   52: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   55: aload_1
    //   56: ldc_w 729
    //   59: ldc 234
    //   61: invokeinterface 768 3 0
    //   66: putfield 727	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIo	Ljava/lang/String;
    //   69: aload_1
    //   70: ldc_w 611
    //   73: invokeinterface 770 2 0
    //   78: ifne +11 -> 89
    //   81: aload_0
    //   82: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   85: astore_1
    //   86: goto -72 -> 14
    //   89: aload_0
    //   90: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   93: aload_1
    //   94: ldc_w 605
    //   97: ldc 234
    //   99: invokeinterface 768 3 0
    //   104: putfield 491	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHS	Ljava/lang/String;
    //   107: aload_0
    //   108: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   111: aload_1
    //   112: ldc_w 658
    //   115: iconst_0
    //   116: invokeinterface 528 3 0
    //   121: putfield 502	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHK	I
    //   124: aload_0
    //   125: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   128: aload_1
    //   129: ldc_w 660
    //   132: ldc_w 771
    //   135: invokeinterface 775 3 0
    //   140: putfield 663	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIv	F
    //   143: aload_0
    //   144: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   147: aload_1
    //   148: ldc_w 669
    //   151: ldc_w 771
    //   154: invokeinterface 775 3 0
    //   159: putfield 672	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIw	F
    //   162: aload_0
    //   163: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   166: aload_1
    //   167: ldc_w 611
    //   170: ldc 234
    //   172: invokeinterface 768 3 0
    //   177: putfield 568	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHL	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   184: aload_1
    //   185: ldc_w 613
    //   188: ldc 234
    //   190: invokeinterface 768 3 0
    //   195: putfield 496	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIq	Ljava/lang/String;
    //   198: aload_0
    //   199: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   202: aload_1
    //   203: ldc_w 615
    //   206: ldc 234
    //   208: invokeinterface 768 3 0
    //   213: putfield 618	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHU	Ljava/lang/String;
    //   216: aload_0
    //   217: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   220: aload_1
    //   221: ldc_w 620
    //   224: iconst_0
    //   225: invokeinterface 779 3 0
    //   230: putfield 488	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIp	Z
    //   233: aload_0
    //   234: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   237: aload_1
    //   238: ldc 166
    //   240: lconst_0
    //   241: invokeinterface 763 4 0
    //   246: putfield 631	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIr	J
    //   249: aload_0
    //   250: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   253: aload_1
    //   254: ldc_w 632
    //   257: iconst_0
    //   258: invokeinterface 528 3 0
    //   263: putfield 479	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   266: aload_0
    //   267: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   270: aload_1
    //   271: ldc_w 565
    //   274: iconst_0
    //   275: invokeinterface 528 3 0
    //   280: putfield 583	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIt	I
    //   283: aload_0
    //   284: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   287: aload_1
    //   288: ldc_w 634
    //   291: iconst_0
    //   292: invokeinterface 528 3 0
    //   297: putfield 636	com/tencent/xweb/xwalk/updater/SchedulerConfig:nPatchTargetVersion	I
    //   300: aload_0
    //   301: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   304: aload_1
    //   305: ldc_w 522
    //   308: iconst_0
    //   309: invokeinterface 528 3 0
    //   314: putfield 545	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIu	I
    //   317: aload_0
    //   318: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   321: aload_1
    //   322: ldc_w 637
    //   325: ldc 234
    //   327: invokeinterface 768 3 0
    //   332: putfield 505	com/tencent/xweb/xwalk/updater/SchedulerConfig:patchMd5	Ljava/lang/String;
    //   335: aload_0
    //   336: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   339: aload_1
    //   340: ldc_w 639
    //   343: ldc 234
    //   345: invokeinterface 768 3 0
    //   350: putfield 642	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIs	Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   357: aload_1
    //   358: ldc_w 626
    //   361: iconst_0
    //   362: invokeinterface 779 3 0
    //   367: putfield 482	com/tencent/xweb/xwalk/updater/SchedulerConfig:KHT	Z
    //   370: aload_0
    //   371: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   374: aload_1
    //   375: ldc_w 627
    //   378: iconst_0
    //   379: invokeinterface 779 3 0
    //   384: putfield 485	com/tencent/xweb/xwalk/updater/SchedulerConfig:bUseCdn	Z
    //   387: aload_0
    //   388: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   391: aload_1
    //   392: ldc_w 644
    //   395: iconst_1
    //   396: invokeinterface 779 3 0
    //   401: putfield 646	com/tencent/xweb/xwalk/updater/SchedulerConfig:bTryUseSharedCore	Z
    //   404: aload_0
    //   405: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   408: aload_1
    //   409: ldc_w 648
    //   412: iconst_1
    //   413: invokeinterface 779 3 0
    //   418: putfield 651	com/tencent/xweb/xwalk/updater/SchedulerConfig:KIx	Z
    //   421: aload_0
    //   422: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   425: aload_1
    //   426: ldc_w 652
    //   429: ldc 234
    //   431: invokeinterface 768 3 0
    //   436: putfield 499	com/tencent/xweb/xwalk/updater/SchedulerConfig:strAbi	Ljava/lang/String;
    //   439: aload_0
    //   440: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   443: aload_1
    //   444: ldc_w 654
    //   447: ldc 234
    //   449: invokeinterface 768 3 0
    //   454: putfield 656	com/tencent/xweb/xwalk/updater/SchedulerConfig:path	Ljava/lang/String;
    //   457: aload_0
    //   458: getfield 602	com/tencent/xweb/xwalk/updater/c:KIg	Lcom/tencent/xweb/xwalk/updater/SchedulerConfig;
    //   461: astore_1
    //   462: goto -448 -> 14
    //   465: astore_1
    //   466: aload_0
    //   467: monitorexit
    //   468: aload_1
    //   469: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	c
    //   13	449	1	localObject1	Object
    //   465	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	465	finally
    //   18	86	465	finally
    //   89	462	465	finally
  }
  
  public double fMo()
  {
    KIf = false;
    return aVA(ze(false)) * 3600000.0D;
  }
  
  public double fMp()
  {
    KIf = false;
    return aVA(ze(true)) * 3600000.0D;
  }
  
  public void fMq()
  {
    double d = e.fKD();
    if ((d < fMm().KIv) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = e.fKC())
    {
      l1 = (a(0.0D, H(fMm().KIv), t(fMm().KIv, fMm().KIw)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      fMm().KIr = (l2 + l1);
      e(fMm());
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public boolean fMr()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!u(e.Ce(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.fKC() != e.c((Calendar)localObject))
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
      public final String fLH()
      {
        return "UNITEST";
      }
      
      protected final String fLJ()
      {
        return "18:00-20:00(0.5-0.6-0.7-1)=>0:00-3:00(0-1); 20:00 - 21:00(0.5-0.6-0.7) => 3-5(0-0.5); 15.5-17.5(0.5)=>3.5-5.5";
      }
      
      public final String ze(boolean paramAnonymousBoolean)
      {
        return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
      }
    }.fMn();
    if (((List)localObject).size() != 3)
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 1");
      return false;
    }
    ((b)((List)localObject).get(0)).x(1.5D, 19.0D);
    if (!u(((b)((List)localObject).get(0)).w(1.5D, 19.0D), 0.325D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 2");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3249;
    if (!((b)((List)localObject).get(0)).v(1.5D, 19.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 3");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 3250;
    if (((b)((List)localObject).get(0)).v(1.5D, 19.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 4");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 9899;
    if (!u(((b)((List)localObject).get(0)).w(3.0D, 20.0D), 1.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 5 ");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 5000;
    if (((b)((List)localObject).get(2)).v(3.9D, 17.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 6");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 4998;
    if (!((b)((List)localObject).get(2)).v(3.9D, 17.0D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 7");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (!((b)((List)localObject).get(1)).v(4.0D, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 8");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (((b)((List)localObject).get(1)).v(4.0D, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 9");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1499;
    if (r(4.0D, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 10");
      return false;
    }
    XWalkEnvironment.sNDeviceRd = 1500;
    if (r(4.0D, 20.5D))
    {
      Log.e(this.TAG, "unitTestRangeSchedule error 11");
      return false;
    }
    Log.e(this.TAG, "unitTestRangeSchedule pass");
    return true;
  }
  
  public abstract String ze(boolean paramBoolean);
  
  public boolean zf(boolean paramBoolean)
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
        bool = fMd();
        if (!bool)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        if ((fMe()) || (KIe))
        {
          com.tencent.xweb.util.g.r(903L, fLI() + 157, 1L);
          paramBoolean = true;
          continue;
        }
        Object localObject1 = a.mx("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = e.aVl((String)localObject1);
          if ((((e.a)localObject1).KDX) && (((e.a)localObject1).doubleValue() >= 0.0D) && (((e.a)localObject1).doubleValue() <= 24.0D)) {
            ((e.a)localObject1).doubleValue();
          }
        }
        l2 = System.currentTimeMillis();
        d1 = fMo();
        if (KIf)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
          com.tencent.xweb.util.g.r(903L, fLI() + 163, 1L);
        }
        d2 = fMp();
        if (KIf)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
          com.tencent.xweb.util.g.r(903L, fLI() + 163, 1L);
        }
        l1 = fMm().KIr;
        i = 0;
        if (l1 > 1000L) {
          break label850;
        }
        if (!paramBoolean)
        {
          paramBoolean = true;
          continue;
        }
        l1 = (3600000.0D * Math.random());
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "not have schedule time ,just random a time in one hour");
        com.tencent.xweb.util.g.r(903L, fLI() + 155, 1L);
        l1 = l2 - l1;
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
        l3 = l2 - l1;
        l4 = e.fKC();
        l5 = l4 + l2;
        if (l1 - 180000L >= l5 - 86400000L) {
          break label856;
        }
        j = 1;
      }
      finally {}
      if (j != 0)
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day ");
        fMq();
        com.tencent.xweb.util.g.r(903L, 146L, 1L);
        paramBoolean = false;
      }
      else
      {
        int k;
        if (k != 0)
        {
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now ");
          com.tencent.xweb.util.g.r(903L, 147L, 1L);
          paramBoolean = false;
        }
        else
        {
          int m;
          if (m != 0)
          {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
            com.tencent.xweb.util.g.r(903L, 148L, 1L);
            paramBoolean = false;
          }
          else
          {
            if ((l3 >= 0L) && (l3 <= 3600000L))
            {
              bool = true;
              com.tencent.xweb.util.g.r(903L, fLI() + 154, 1L);
              break label874;
              if ((l3 < 0L) && (-l3 < d2))
              {
                paramBoolean = true;
                com.tencent.xweb.util.g.r(903L, fLI() + 161, 1L);
                if ((bool) && (!paramBoolean)) {
                  com.tencent.xweb.util.g.r(903L, fLI() + 150, 1L);
                }
                if ((!bool) && (paramBoolean)) {
                  com.tencent.xweb.util.g.r(903L, fLI() + 151, 1L);
                }
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
                if (paramBoolean)
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
                  com.tencent.xweb.util.g.r(903L, fLI() + 152, 1L);
                  paramBoolean = true;
                  continue;
                }
                if (fMf())
                {
                  XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
                  com.tencent.xweb.util.g.r(903L, fLI() + 153, 1L);
                  paramBoolean = true;
                  continue;
                }
                if ((d1 >= 3600000.0D) && (Co(l1)))
                {
                  com.tencent.xweb.util.g.r(903L, fLI() + 162, 1L);
                  paramBoolean = true;
                  continue;
                }
                if ((i != 0) && ((l2 - fMm().KIr > 0L) || (Math.abs(l2 - fMm().KIr) > 7776000000L)))
                {
                  fMq();
                  com.tencent.xweb.util.g.r(903L, fLI() + 156, 1L);
                  break label894;
                }
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
                break label894;
              }
            }
            label807:
            label850:
            label856:
            label868:
            label874:
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
                  break label868;
                }
                m = 1;
                break label347;
                i = 1;
                break;
                j = 0;
                break label807;
              }
              m = 0;
              break label347;
            }
            paramBoolean = true;
            continue;
            label894:
            paramBoolean = false;
          }
        }
      }
    }
  }
  
  static final class a
  {
    public double CVW;
    public double KIi;
    public double KIj;
    public double[] KIk;
    
    a()
    {
      AppMethodBeat.i(208955);
      this.KIk = new double[0];
      this.CVW = 1.0D;
      AppMethodBeat.o(208955);
    }
    
    public final double I(double paramDouble)
    {
      int i = 0;
      if ((this.KIk == null) || (this.KIk.length == 0)) {
        return this.CVW;
      }
      if (this.KIk.length == 1) {
        return this.KIk[0];
      }
      int j = this.KIk.length - 1;
      double d1 = (this.KIj - this.KIi) / j;
      paramDouble -= this.KIi;
      while (i < j)
      {
        double d3 = i + 1;
        double d2 = i;
        if (paramDouble < d3 * d1)
        {
          d3 = this.KIk[i];
          return (this.KIk[(i + 1)] - this.KIk[i]) * (paramDouble - d2 * d1) / d1 + d3;
        }
        i += 1;
      }
      c.KIf = true;
      return 1.0D;
    }
  }
  
  static final class b
  {
    public c.a KIl;
    public c.a KIm;
    
    b()
    {
      AppMethodBeat.i(208956);
      this.KIl = new c.a();
      this.KIm = new c.a();
      AppMethodBeat.o(208956);
    }
    
    public final boolean v(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(208957);
      if ((paramDouble2 > this.KIl.KIj) || (paramDouble2 < this.KIl.KIi))
      {
        AppMethodBeat.o(208957);
        return false;
      }
      if ((paramDouble1 > this.KIm.KIj) || (paramDouble1 < this.KIm.KIi))
      {
        AppMethodBeat.o(208957);
        return false;
      }
      if (XWalkEnvironment.getDeviceRd() <= w(paramDouble1, paramDouble2) * 10000.0D)
      {
        AppMethodBeat.o(208957);
        return true;
      }
      AppMethodBeat.o(208957);
      return false;
    }
    
    public final double w(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(208958);
      paramDouble2 = this.KIl.I(paramDouble2);
      paramDouble1 = this.KIm.I(paramDouble1);
      AppMethodBeat.o(208958);
      return paramDouble2 * paramDouble1;
    }
    
    public final String x(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(208959);
      String str = "[ " + this.KIl.KIi + "," + this.KIl.KIj + "] => [" + this.KIm.KIi + "," + this.KIm.KIj + "],scale=" + w(paramDouble1, paramDouble2);
      AppMethodBeat.o(208959);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.c
 * JD-Core Version:    0.7.0.1
 */