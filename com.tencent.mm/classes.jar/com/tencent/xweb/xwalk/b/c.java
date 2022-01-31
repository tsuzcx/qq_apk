package com.tencent.xweb.xwalk.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class c
{
  static c BKY;
  static c.a BKZ;
  
  public static void TN(int paramInt)
  {
    AppMethodBeat.i(85457);
    if (paramInt == -10)
    {
      localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog("onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(paramInt)));
      paramInt += 1;
      eaD().BLg = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(85457);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      AppMethodBeat.o(85457);
      return;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      eaD().BLb = false;
      eaD().BKO = eaD().BLc;
      eaD().BKP = false;
      a(eaD());
      XWalkInitializer.addXWalkInitializeLog("switch to full package update");
      i = j;
    }
    while (i > 3)
    {
      XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
      XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
      a(null);
      AppMethodBeat.o(85457);
      return;
      i = j;
      if (paramInt <= -2)
      {
        i = j;
        if (paramInt >= -5) {
          i = j + 3;
        }
      }
    }
    eaD().BLf = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(85457);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      AppMethodBeat.i(85458);
      long l1 = System.currentTimeMillis();
      long l2 = 7200000 * paramInt;
      XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + 7200000 * paramInt / 60000 + " minute");
      paramEditor.putLong("nTimeToUpdate", l1 + l2);
      AppMethodBeat.o(85458);
      return;
    }
    finally {}
  }
  
  public static void a(c.a parama)
  {
    try
    {
      AppMethodBeat.i(85464);
      BKZ = parama;
      if (parama == null) {
        BKZ = new c.a();
      }
      parama = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      parama.putString("strMd5", BKZ.BKJ);
      parama.putString("strUrl", BKZ.BKO);
      parama.putString("strFullPackageUrl", BKZ.BLc);
      parama.putString("strConfigVer", BKZ.BKK);
      parama.putBoolean("bIsPatchUpdate", BKZ.BLb);
      parama.putBoolean("bCanUseCellular", BKZ.BKP);
      parama.putBoolean("bUseCdn", BKZ.bUseCdn);
      parama.putLong("nTimeToUpdate", BKZ.BLd);
      parama.putInt("nApkVer", BKZ.BKV);
      parama.putInt("nTryCnt", BKZ.BLf);
      parama.putInt("nTryUseSharedCoreCount", BKZ.BLg);
      parama.putString("strPatchMd5", BKZ.bWN);
      parama.putString("strVersionDetail", BKZ.BLe);
      parama.putBoolean("bTryUseSharedCore", BKZ.bTryUseSharedCore);
      parama.commit();
      AppMethodBeat.o(85464);
      return;
    }
    finally {}
  }
  
  private static boolean aj(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(85467);
    long l = eaB();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2))
    {
      AppMethodBeat.o(85467);
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
    AppMethodBeat.o(85467);
    return false;
  }
  
  public static void eaA()
  {
    AppMethodBeat.i(85465);
    eaD().BLa = System.currentTimeMillis();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", eaD().BLa);
    localEditor.commit();
    AppMethodBeat.o(85465);
  }
  
  public static long eaB()
  {
    AppMethodBeat.i(85466);
    long l2 = a.dYd();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 86400000L;
    }
    AppMethodBeat.o(85466);
    return l1;
  }
  
  public static boolean eaC()
  {
    AppMethodBeat.i(85468);
    long l1 = System.currentTimeMillis();
    if (aj(l1, eaD().BLa))
    {
      long l2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0L);
      eaD().BLa = l2;
      if (aj(l1, l2))
      {
        XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
        AppMethodBeat.o(85468);
        return true;
      }
    }
    AppMethodBeat.o(85468);
    return false;
  }
  
  public static c.a eaD()
  {
    AppMethodBeat.i(85469);
    if (BKZ != null)
    {
      localObject = BKZ;
      AppMethodBeat.o(85469);
      return localObject;
    }
    BKZ = new c.a();
    Object localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    BKZ.BLa = ((SharedPreferences)localObject).getLong("nLastFetchConfigTime", 0L);
    if (!((SharedPreferences)localObject).contains("strUrl"))
    {
      localObject = BKZ;
      AppMethodBeat.o(85469);
      return localObject;
    }
    BKZ.BKJ = ((SharedPreferences)localObject).getString("strMd5", null);
    BKZ.BKO = ((SharedPreferences)localObject).getString("strUrl", null);
    BKZ.BLc = ((SharedPreferences)localObject).getString("strFullPackageUrl", null);
    BKZ.BKK = ((SharedPreferences)localObject).getString("strConfigVer", null);
    BKZ.BLb = ((SharedPreferences)localObject).getBoolean("bIsPatchUpdate", false);
    BKZ.BLd = ((SharedPreferences)localObject).getLong("nTimeToUpdate", 0L);
    BKZ.BKV = ((SharedPreferences)localObject).getInt("nApkVer", 0);
    BKZ.BLf = ((SharedPreferences)localObject).getInt("nTryCnt", 0);
    BKZ.BLg = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
    BKZ.bWN = ((SharedPreferences)localObject).getString("strPatchMd5", null);
    BKZ.BLe = ((SharedPreferences)localObject).getString("strVersionDetail", null);
    BKZ.BKP = ((SharedPreferences)localObject).getBoolean("bCanUseCellular", false);
    BKZ.bUseCdn = ((SharedPreferences)localObject).getBoolean("bUseCdn", false);
    BKZ.bTryUseSharedCore = ((SharedPreferences)localObject).getBoolean("bTryUseSharedCore", true);
    localObject = BKZ;
    AppMethodBeat.o(85469);
    return localObject;
  }
  
  public static c eav()
  {
    try
    {
      AppMethodBeat.i(85456);
      if (BKY == null) {
        BKY = new c();
      }
      c localc = BKY;
      AppMethodBeat.o(85456);
      return localc;
    }
    finally {}
  }
  
  public static boolean eaw()
  {
    AppMethodBeat.i(85460);
    if (!eax())
    {
      AppMethodBeat.o(85460);
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
    AppMethodBeat.o(85460);
    return true;
  }
  
  public static boolean eax()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(85461);
        if ((eaD() == null) || (eaD().BKO == null) || (eaD().BKO.isEmpty()))
        {
          AppMethodBeat.o(85461);
          return bool;
        }
        if (eaD().BKV <= XWalkEnvironment.getInstalledNewstVersion())
        {
          AppMethodBeat.o(85461);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(85461);
    }
  }
  
  static boolean jh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85459);
    if (paramString1 == null)
    {
      if (paramString1 == paramString2)
      {
        AppMethodBeat.o(85459);
        return true;
      }
      AppMethodBeat.o(85459);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(85459);
    return bool;
  }
  
  public final boolean eay()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(85462);
        if (!eax())
        {
          AppMethodBeat.o(85462);
          return bool;
        }
        if (System.currentTimeMillis() >= eaD().BLd)
        {
          XWalkInitializer.addXWalkInitializeLog("time to update");
          bool = true;
          AppMethodBeat.o(85462);
          continue;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
      }
      finally {}
      AppMethodBeat.o(85462);
    }
  }
  
  public final void eaz()
  {
    try
    {
      AppMethodBeat.i(85463);
      SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      eaD().BLa = 0L;
      eaD().BLd = 0L;
      AppMethodBeat.o(85463);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.c
 * JD-Core Version:    0.7.0.1
 */