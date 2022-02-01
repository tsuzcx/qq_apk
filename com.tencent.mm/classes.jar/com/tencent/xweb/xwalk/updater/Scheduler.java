package com.tencent.xweb.xwalk.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ag;
import com.tencent.xweb.b;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.g;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class Scheduler
{
  static Scheduler IVH;
  static SchedulerConfig IVI;
  
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
    AppMethodBeat.i(194717);
    if ((paramDouble1 > paramDouble3) || (paramDouble3 < paramDouble2))
    {
      Log.e("Scheduler", "srandTime cur hour is bigger than endhour ");
      AppMethodBeat.o(194717);
      return 0.0D;
    }
    if (paramDouble2 < paramDouble1) {}
    for (;;)
    {
      paramDouble2 = Math.random();
      AppMethodBeat.o(194717);
      return paramDouble2 * (paramDouble3 - paramDouble1) + paramDouble1;
      paramDouble1 = paramDouble2;
    }
  }
  
  private static void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      AppMethodBeat.i(154550);
      long l1 = System.currentTimeMillis();
      long l2 = paramInt;
      XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + paramInt * 7200000L / 60000L + " minute");
      paramEditor.putLong("nTimeToUpdate", l1 + l2 * 7200000L);
      AppMethodBeat.o(154550);
      return;
    }
    finally {}
  }
  
  public static void a(SchedulerConfig paramSchedulerConfig)
  {
    try
    {
      AppMethodBeat.i(154556);
      IVI = paramSchedulerConfig;
      if (paramSchedulerConfig == null) {
        IVI = new SchedulerConfig();
      }
      paramSchedulerConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      paramSchedulerConfig.putString("strMd5", IVI.IVm);
      paramSchedulerConfig.putString("strUrl", IVI.IVr);
      paramSchedulerConfig.putString("strFullPackageUrl", IVI.IVM);
      paramSchedulerConfig.putString("strConfigVer", IVI.IVn);
      paramSchedulerConfig.putBoolean("bIsPatchUpdate", IVI.IVL);
      paramSchedulerConfig.putBoolean("bCanUseCellular", IVI.IVs);
      paramSchedulerConfig.putBoolean("bUseCdn", IVI.bUseCdn);
      paramSchedulerConfig.putLong("nTimeToUpdate", IVI.IVN);
      paramSchedulerConfig.putInt("nApkVer", IVI.IVy);
      paramSchedulerConfig.putInt("nTryCnt", IVI.IVP);
      paramSchedulerConfig.putInt("nPatchTargetVersion", IVI.nPatchTargetVersion);
      paramSchedulerConfig.putInt("nTryUseSharedCoreCount", IVI.IVQ);
      paramSchedulerConfig.putString("strPatchMd5", IVI.patchMd5);
      paramSchedulerConfig.putString("strVersionDetail", IVI.IVO);
      paramSchedulerConfig.putBoolean("bTryUseSharedCore", IVI.bTryUseSharedCore);
      paramSchedulerConfig.putString("strAbi", IVI.strAbi);
      paramSchedulerConfig.putInt("versionId", IVI.IVA);
      paramSchedulerConfig.putFloat("timeHourStart", IVI.IVR);
      paramSchedulerConfig.putFloat("timeHourEnd", IVI.IVS);
      paramSchedulerConfig.commit();
      AppMethodBeat.o(154556);
      return;
    }
    finally {}
  }
  
  private static boolean aA(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(154559);
    long l = ftA();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2))
    {
      AppMethodBeat.o(154559);
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
    AppMethodBeat.o(154559);
    return false;
  }
  
  private static double aPG(String paramString)
  {
    AppMethodBeat.i(194716);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194716);
      return -1.0D;
    }
    Object localObject = paramString.split(":");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(194716);
      return -1.0D;
    }
    paramString = e.aPt(localObject[0]);
    if (!paramString.IRB)
    {
      AppMethodBeat.o(194716);
      return -1.0D;
    }
    double d2 = paramString.intValue();
    double d1 = d2;
    if (localObject.length == 2)
    {
      localObject = e.aPt(localObject[1]);
      if (!paramString.IRB)
      {
        AppMethodBeat.o(194716);
        return -1.0D;
      }
      int i = ((e.a)localObject).intValue();
      if ((i < 0) || (i >= 60))
      {
        AppMethodBeat.o(194716);
        return -1.0D;
      }
      d1 = d2 + i * 1.0D / 60.0D;
    }
    if ((d1 < 0.0D) || (d1 > 24.0D))
    {
      AppMethodBeat.o(194716);
      return -1.0D;
    }
    AppMethodBeat.o(194716);
    return d1;
  }
  
  public static void adu(int paramInt) {}
  
  public static void adv(int paramInt)
  {
    AppMethodBeat.i(154549);
    if (paramInt == -10)
    {
      localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog("onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      ftC().IVQ = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(154549);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      AppMethodBeat.o(154549);
      return;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      ftC().IVL = false;
      ftC().IVr = ftC().IVM;
      ftC().IVs = false;
      a(ftC());
      XWalkInitializer.addXWalkInitializeLog("switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
      ftt();
      AppMethodBeat.o(154549);
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
    ftC().IVP = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(154549);
  }
  
  public static long ftA()
  {
    AppMethodBeat.i(154558);
    long l = a.lX("force_cmd_period", "tools") * 60000L;
    if (xB(l))
    {
      AppMethodBeat.o(154558);
      return l;
    }
    l = XWalkEnvironment.getConfigFetchPeriod();
    if (xB(l))
    {
      AppMethodBeat.o(154558);
      return l;
    }
    l = a.fqx();
    if (xB(l))
    {
      AppMethodBeat.o(154558);
      return l;
    }
    AppMethodBeat.o(154558);
    return 86400000L;
  }
  
  public static boolean ftB()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(154560);
        long l1;
        try
        {
          if ((!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(ftC().IVK)) && (!TextUtils.isEmpty(ftC().IVK)))
          {
            boolean bool2 = "true".equalsIgnoreCase(b.lW("disable_abi_switch_reset_config_time", "tools"));
            if (!bool2)
            {
              AppMethodBeat.o(154560);
              return bool1;
            }
          }
        }
        catch (Exception localException)
        {
          XWalkEnvironment.addXWalkInitializeLog("isNeedFecthConfig:identyfy abi switch failed " + localException.getMessage());
          l1 = System.currentTimeMillis();
          if (!aA(l1, ftC().IVJ)) {
            break label166;
          }
        }
        long l2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0L);
        ftC().IVJ = l2;
        if (aA(l1, l2))
        {
          XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
          AppMethodBeat.o(154560);
          continue;
        }
        bool1 = false;
      }
      finally {}
      label166:
      AppMethodBeat.o(154560);
    }
  }
  
  public static SchedulerConfig ftC()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(154561);
        if (IVI != null)
        {
          localObject1 = IVI;
          AppMethodBeat.o(154561);
          return localObject1;
        }
        IVI = new SchedulerConfig();
        Object localObject1 = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        IVI.IVJ = ((SharedPreferences)localObject1).getLong("nLastFetchConfigTime", 0L);
        IVI.IVK = ((SharedPreferences)localObject1).getString("strLastFetchAbi", "");
        if (!((SharedPreferences)localObject1).contains("strUrl"))
        {
          localObject1 = IVI;
          AppMethodBeat.o(154561);
          continue;
        }
        IVI.IVm = localObject2.getString("strMd5", null);
      }
      finally {}
      IVI.IVA = localObject2.getInt("versionId", 0);
      IVI.IVR = localObject2.getFloat("timeHourStart", -1.0F);
      IVI.IVS = localObject2.getFloat("timeHourEnd", -1.0F);
      IVI.IVr = localObject2.getString("strUrl", null);
      IVI.IVM = localObject2.getString("strFullPackageUrl", null);
      IVI.IVn = localObject2.getString("strConfigVer", null);
      IVI.IVL = localObject2.getBoolean("bIsPatchUpdate", false);
      IVI.IVN = localObject2.getLong("nTimeToUpdate", 0L);
      IVI.IVy = localObject2.getInt("nApkVer", 0);
      IVI.IVP = localObject2.getInt("nTryCnt", 0);
      IVI.nPatchTargetVersion = localObject2.getInt("nPatchTargetVersion", 0);
      IVI.IVQ = localObject2.getInt("nTryUseSharedCoreCount", 0);
      IVI.patchMd5 = localObject2.getString("strPatchMd5", null);
      IVI.IVO = localObject2.getString("strVersionDetail", null);
      IVI.IVs = localObject2.getBoolean("bCanUseCellular", false);
      IVI.bUseCdn = localObject2.getBoolean("bUseCdn", false);
      IVI.bTryUseSharedCore = localObject2.getBoolean("bTryUseSharedCore", true);
      IVI.strAbi = localObject2.getString("strAbi", "");
      SchedulerConfig localSchedulerConfig = IVI;
      AppMethodBeat.o(154561);
    }
  }
  
  public static double ftD()
  {
    AppMethodBeat.i(194713);
    double d = xN(false);
    AppMethodBeat.o(194713);
    return d * 3600000.0D;
  }
  
  public static double ftE()
  {
    AppMethodBeat.i(194714);
    double d = xN(true);
    AppMethodBeat.o(194714);
    return d * 3600000.0D;
  }
  
  public static void ftF()
  {
    AppMethodBeat.i(194718);
    double d = e.fsa();
    if ((d < ftC().IVR) || (d < 6.0D)) {
      XWalkInitializer.addXWalkInitializeLog("rescheduleToNextDay: cur hour is " + d + ", so still schedule in today");
    }
    for (long l1 = -d * 3600000L;; l1 = e.frZ())
    {
      l1 = (a(0.0D, I(ftC().IVR), s(ftC().IVR, ftC().IVS)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      ftC().IVN = (l2 + l1);
      a(ftC());
      XWalkInitializer.addXWalkInitializeLog("rescheduleToNextDay: " + l1 / 60000L + " minutes later");
      AppMethodBeat.o(194718);
      return;
    }
  }
  
  public static Scheduler fts()
  {
    try
    {
      AppMethodBeat.i(154548);
      if (IVH == null) {
        IVH = new Scheduler();
      }
      Scheduler localScheduler = IVH;
      AppMethodBeat.o(154548);
      return localScheduler;
    }
    finally {}
  }
  
  public static void ftt()
  {
    AppMethodBeat.i(175921);
    XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
    a(null);
    AppMethodBeat.o(175921);
  }
  
  public static boolean ftv()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(154553);
        if ((ftC() == null) || (ftC().IVr == null) || (ftC().IVr.isEmpty()))
        {
          AppMethodBeat.o(154553);
          return bool;
        }
        if (ftC().IVy <= XWalkEnvironment.getInstalledNewstVersion(ftC().strAbi))
        {
          AppMethodBeat.o(154553);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(154553);
    }
  }
  
  public static boolean ftw()
  {
    AppMethodBeat.i(194711);
    Object localObject1 = a.lW("free_update_time_zone", "tools");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(194711);
      return false;
    }
    if (!((String)localObject1).contains("-"))
    {
      AppMethodBeat.o(194711);
      return false;
    }
    Object localObject2 = ((String)localObject1).split("-");
    if ((localObject2 == null) || (localObject2.length != 2))
    {
      AppMethodBeat.o(194711);
      return false;
    }
    localObject1 = e.aPs(localObject2[0]);
    if (!((e.a)localObject1).IRB)
    {
      AppMethodBeat.o(194711);
      return false;
    }
    localObject2 = e.aPs(localObject2[1]);
    if (!((e.a)localObject2).IRB)
    {
      AppMethodBeat.o(194711);
      return false;
    }
    if (!r(((e.a)localObject1).doubleValue(), ((e.a)localObject2).doubleValue()))
    {
      AppMethodBeat.o(194711);
      return false;
    }
    double d = e.fsa();
    if (d < ((e.a)localObject1).doubleValue())
    {
      AppMethodBeat.o(194711);
      return false;
    }
    if (d > ((e.a)localObject2).doubleValue())
    {
      AppMethodBeat.o(194711);
      return false;
    }
    AppMethodBeat.o(194711);
    return true;
  }
  
  public static void ftx()
  {
    try
    {
      AppMethodBeat.i(194712);
      SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      ftC().IVJ = 0L;
      AppMethodBeat.o(194712);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void ftz()
  {
    AppMethodBeat.i(154557);
    ftC().IVJ = System.currentTimeMillis();
    ftC().IVK = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", ftC().IVJ);
    localEditor.putString("strLastFetchAbi", ftC().IVK);
    localEditor.commit();
    AppMethodBeat.o(154557);
  }
  
  private static boolean mm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154551);
    if (paramString1 == null)
    {
      if (paramString1 == paramString2)
      {
        AppMethodBeat.o(154551);
        return true;
      }
      AppMethodBeat.o(154551);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(154551);
    return bool;
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
      paramDouble1 = 32.0D;
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
  
  private static boolean xB(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static double xN(boolean paramBoolean)
  {
    AppMethodBeat.i(194715);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = a.lW("UPDATE_SPEED_CONFIG", "tools");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label65;
      }
    }
    label65:
    for (String[] arrayOfString = null;; arrayOfString = ((String)localObject).split(";"))
    {
      if ((arrayOfString != null) && (arrayOfString.length != 0)) {
        break label78;
      }
      AppMethodBeat.o(194715);
      return 1.0D;
      localObject = a.lW("UPDATE_FORWARD_SPEED_CONFIG", "tools");
      break;
    }
    label78:
    double d1 = e.fsa();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localObject = null;
        }
        while ((localObject != null) && (localObject.length == 3) && (d1 >= localObject[0]) && (d1 <= localObject[1]))
        {
          d1 = localObject[2];
          AppMethodBeat.o(194715);
          return d1;
          localObject = ((String)localObject).trim().split("-");
          if ((localObject == null) || (localObject.length != 3))
          {
            localObject = null;
          }
          else
          {
            double d2 = aPG(localObject[0]);
            if ((d2 < 0.0D) || (d2 > 24.0D))
            {
              localObject = null;
            }
            else
            {
              double d3 = aPG(localObject[1]);
              if ((d3 < 0.0D) || (d3 > 24.0D))
              {
                localObject = null;
              }
              else
              {
                localObject = e.aPs(localObject[2]);
                if (!((e.a)localObject).IRB)
                {
                  localObject = null;
                }
                else
                {
                  double d4 = ((e.a)localObject).doubleValue();
                  if (d4 < 0.0D)
                  {
                    localObject = null;
                  }
                  else
                  {
                    localObject = new double[3];
                    localObject[0] = d2;
                    localObject[1] = d3;
                    localObject[2] = d4;
                  }
                }
              }
            }
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(194715);
    return 1.0D;
  }
  
  public SchedulerConfig a(a.a parama)
  {
    AppMethodBeat.i(175922);
    if (parama == null)
    {
      AppMethodBeat.o(175922);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + parama.IVn);
    if ((ag.frt()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog("it's gp version , dont down load any runtime version");
      AppMethodBeat.o(175922);
      return null;
    }
    SchedulerConfig localSchedulerConfig2 = ftC();
    SchedulerConfig localSchedulerConfig1;
    if ((localSchedulerConfig2 != null) && (!TextUtils.isEmpty(parama.IVn)) && (!parama.IVn.equals(localSchedulerConfig2.IVn)))
    {
      localSchedulerConfig1 = c.a(parama, XWalkEnvironment.getRuntimeAbi());
      String str = a.lW("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog("Scheduler", "predown load abi is ".concat(String.valueOf(str)));
      if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label582;
      }
      parama = c.a(parama, str);
      if (parama != null) {
        g.r(577L, 240L, 1L);
      }
    }
    for (;;)
    {
      int i;
      if (localSchedulerConfig1 != null)
      {
        XWalkInitializer.addXWalkInitializeLog("Scheduler", "use cur abi schedule:" + localSchedulerConfig1.IVy);
        i = 0;
        parama = localSchedulerConfig1;
      }
      for (;;)
      {
        if (parama == null)
        {
          XWalkInitializer.addXWalkInitializeLog("Scheduler", "got no schedule need download");
          if (ftv())
          {
            if (localSchedulerConfig2 != null) {
              XWalkInitializer.addXWalkInitializeLog("Scheduler", "clear current scheduler version = " + localSchedulerConfig2.IVy);
            }
            a(parama);
          }
          AppMethodBeat.o(175922);
          return null;
          if (parama != null)
          {
            XWalkInitializer.addXWalkInitializeLog("Scheduler", "use pre down load abi schedule:" + parama.IVy);
            i = 1;
          }
        }
        else
        {
          int j;
          if ((parama.IVy != localSchedulerConfig2.IVy) || (parama.IVs != localSchedulerConfig2.IVs) || (parama.bUseCdn != localSchedulerConfig2.bUseCdn) || (parama.IVL != localSchedulerConfig2.IVL) || (!mm(parama.IVm, localSchedulerConfig2.IVm)) || (!mm(parama.IVM, localSchedulerConfig2.IVM)) || (!mm(parama.strAbi, localSchedulerConfig2.strAbi)) || (parama.IVA != localSchedulerConfig2.IVA)) {
            j = 0;
          }
          while (j != 0)
          {
            XWalkInitializer.addXWalkInitializeLog("got same version to scheduler, use last version ");
            AppMethodBeat.o(175922);
            return localSchedulerConfig2;
            if ((parama.IVL) && (!mm(parama.patchMd5, localSchedulerConfig2.patchMd5))) {
              j = 0;
            } else {
              j = 1;
            }
          }
          if (ftv()) {
            XWalkInitializer.addXWalkInitializeLog("got new scheduler replace current , version is " + parama.IVy);
          }
          if (parama != null)
          {
            a(parama);
            if (i != 0)
            {
              if (!"armeabi-v7a".equalsIgnoreCase(parama.strAbi)) {
                break label541;
              }
              g.r(577L, 236L, 1L);
            }
            for (;;)
            {
              AppMethodBeat.o(175922);
              return parama;
              label541:
              if ("arm64-v8a".equalsIgnoreCase(parama.strAbi)) {
                g.r(577L, 237L, 1L);
              }
            }
          }
          AppMethodBeat.o(175922);
          return null;
        }
        parama = null;
        i = 0;
      }
      label582:
      parama = null;
    }
  }
  
  public boolean ftu()
  {
    AppMethodBeat.i(154552);
    if (!ftv())
    {
      AppMethodBeat.o(154552);
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
    AppMethodBeat.o(154552);
    return true;
  }
  
  public void fty()
  {
    try
    {
      AppMethodBeat.i(154555);
      SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      ftC().IVJ = 0L;
      ftC().IVN = 0L;
      AppMethodBeat.o(154555);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean xM(boolean paramBoolean)
  {
    long l2;
    double d1;
    double d2;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(194710);
        if (!ftv())
        {
          paramBoolean = false;
          AppMethodBeat.o(194710);
          return paramBoolean;
        }
        if (!XWalkEnvironment.hasInstalledAvailableVersion())
        {
          g.r(903L, 157L, 1L);
          if (!"true".equalsIgnoreCase(a.lW("dis_update_immediately_when_no_xweb", "tools")))
          {
            XWalkInitializer.addXWalkInitializeLog("isTimeToUpdate no availableversion installed, do start download ");
            paramBoolean = true;
            AppMethodBeat.o(194710);
            continue;
          }
          XWalkEnvironment.addXWalkInitializeLog(" no availableversion but dis_update_immediately_when_no_xweb == true");
        }
      }
      finally {}
      Object localObject2 = a.lW("DELAY_UPDATE_TIME", "tools");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = e.aPs((String)localObject2);
        if ((((e.a)localObject2).IRB) && (((e.a)localObject2).doubleValue() >= 0.0D) && (((e.a)localObject2).doubleValue() <= 24.0D)) {
          ((e.a)localObject2).doubleValue();
        }
      }
      l2 = System.currentTimeMillis();
      d1 = ftD();
      d2 = ftE();
      l1 = ftC().IVN;
      i = 0;
      if (l1 > 1000L) {
        break label571;
      }
      if (paramBoolean) {
        break;
      }
      paramBoolean = true;
      AppMethodBeat.o(194710);
    }
    long l1 = (3600000.0D * Math.random());
    XWalkInitializer.addXWalkInitializeLog("not have schedule time ,just random a time in one hour");
    g.r(903L, 155L, 1L);
    l1 = l2 - l1;
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
      l1 = l2 - l1;
      boolean bool;
      if ((l1 >= 0L) && (l1 <= 3600000L))
      {
        bool = true;
        g.r(903L, 154L, 1L);
      }
      for (;;)
      {
        if ((l1 < 0L) && (-l1 < d2))
        {
          paramBoolean = true;
          g.r(903L, 161L, 1L);
        }
        for (;;)
        {
          if ((bool) && (!paramBoolean)) {
            g.r(903L, 150L, 1L);
          }
          if ((!bool) && (paramBoolean)) {
            g.r(903L, 151L, 1L);
          }
          XWalkInitializer.addXWalkInitializeLog("shouldUpdateDefault = " + bool + "shouldUpdateFromConfig = " + paramBoolean);
          if (paramBoolean)
          {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            g.r(903L, 152L, 1L);
            paramBoolean = true;
            AppMethodBeat.o(194710);
            break;
          }
          if (ftw())
          {
            XWalkInitializer.addXWalkInitializeLog("time to update because of in free update time zone");
            g.r(903L, 153L, 1L);
            paramBoolean = true;
            AppMethodBeat.o(194710);
            break;
          }
          if ((i != 0) && ((l2 - ftC().IVN > 0L) || (Math.abs(l2 - ftC().IVN) > 7776000000L)))
          {
            ftF();
            g.r(903L, 156L, 1L);
          }
          for (;;)
          {
            paramBoolean = false;
            AppMethodBeat.o(194710);
            break;
            XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
          }
        }
        do
        {
          paramBoolean = false;
          break;
          bool = false;
        } while ((l1 < 0L) || (l1 >= d1));
        paramBoolean = true;
      }
      label571:
      i = 1;
    }
  }
  
  public static class SchedulerConfig
  {
    public int IVA;
    public long IVJ;
    public String IVK;
    public boolean IVL;
    public String IVM;
    public long IVN;
    public String IVO;
    public int IVP;
    public int IVQ;
    public float IVR = -1.0F;
    public float IVS = -1.0F;
    public String IVm;
    public String IVn;
    public String IVr;
    public boolean IVs;
    public int IVy;
    public boolean bTryUseSharedCore;
    public boolean bUseCdn;
    public int nPatchTargetVersion;
    public String patchMd5;
    public String strAbi;
    
    static
    {
      AppMethodBeat.i(154547);
      if (!Scheduler.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(154547);
        return;
      }
    }
    
    public final XWalkUpdater.UpdateConfig ftG()
    {
      AppMethodBeat.i(154546);
      try
      {
        if (this.IVL) {
          break label158;
        }
        if ((this.IVm != null) && (!this.IVm.isEmpty())) {
          break label125;
        }
        if (!$assertionsDisabled)
        {
          AssertionError localAssertionError = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(154546);
          throw localAssertionError;
        }
      }
      catch (Exception localException)
      {
        XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
        Scheduler.a(null);
        AppMethodBeat.o(154546);
        return null;
      }
      Object localObject = new XWalkUpdater.UpdateConfig(this.IVr, false, this.IVy, this.strAbi, this.nPatchTargetVersion);
      for (;;)
      {
        ((XWalkUpdater.UpdateConfig)localObject).versionDetail = this.IVO;
        ((XWalkUpdater.UpdateConfig)localObject).bUseCdn = this.bUseCdn;
        ((XWalkUpdater.UpdateConfig)localObject).bTryUseSharedCore = this.bTryUseSharedCore;
        AppMethodBeat.o(154546);
        return localObject;
        label125:
        localObject = new XWalkUpdater.UpdateConfig(this.IVm, false, null, this.IVr, this.IVy, this.strAbi, this.nPatchTargetVersion);
        continue;
        label158:
        if ((this.IVm == null) || (this.IVm.isEmpty()) || (this.patchMd5 == null) || (this.patchMd5.isEmpty()))
        {
          if (!$assertionsDisabled)
          {
            localObject = new AssertionError("royle:no md5 info, maybe something wrong");
            AppMethodBeat.o(154546);
            throw ((Throwable)localObject);
          }
          localObject = new XWalkUpdater.UpdateConfig(this.IVr, true, this.IVy, this.strAbi, this.nPatchTargetVersion);
        }
        else
        {
          localObject = new XWalkUpdater.UpdateConfig(this.patchMd5, true, this.IVm, this.IVr, this.IVy, this.strAbi, this.nPatchTargetVersion);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.Scheduler
 * JD-Core Version:    0.7.0.1
 */