package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

class SoterBiometricAntiBruteForceStrategy
{
  private static final long DEFAULT_FREEZE_TIME = -1L;
  private static final int FREEZE_SECOND = 30;
  private static final String KEY_FAIL_TIMES = "key_fail_times";
  private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
  private static final int MAX_FAIL_NUM = 5;
  private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";
  
  static void addFailTime(Context paramContext)
  {
    AppMethodBeat.i(88595);
    setCurrentFailTime(paramContext, Integer.valueOf(getCurrentFailTime(paramContext)).intValue() + 1);
    AppMethodBeat.o(88595);
  }
  
  static void freeze(Context paramContext)
  {
    AppMethodBeat.i(88593);
    setCurrentFailTime(paramContext, 6);
    setLastFreezeTime(paramContext, System.currentTimeMillis());
    AppMethodBeat.o(88593);
  }
  
  private static int getCurrentFailTime(Context paramContext)
  {
    AppMethodBeat.i(88589);
    paramContext = Integer.valueOf(getCurrentFailTimeInDB(paramContext));
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current retry time: ".concat(String.valueOf(paramContext)), new Object[0]);
    int i = paramContext.intValue();
    AppMethodBeat.o(88589);
    return i;
  }
  
  private static int getCurrentFailTimeInDB(Context paramContext)
  {
    AppMethodBeat.i(88599);
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_fail_times", 0);
    AppMethodBeat.o(88599);
    return i;
  }
  
  private static long getLastFreezeTime(Context paramContext)
  {
    AppMethodBeat.i(88591);
    paramContext = Long.valueOf(getLastFreezeTimeInDB(paramContext));
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current last freeze time: ".concat(String.valueOf(paramContext)), new Object[0]);
    long l = paramContext.longValue();
    AppMethodBeat.o(88591);
    return l;
  }
  
  private static long getLastFreezeTimeInDB(Context paramContext)
  {
    AppMethodBeat.i(88600);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("key_last_freeze_time", -1L);
    AppMethodBeat.o(88600);
    return l;
  }
  
  static boolean isCurrentFailTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(88597);
    if (getCurrentFailTime(paramContext) < 5)
    {
      d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
      AppMethodBeat.o(88597);
      return true;
    }
    AppMethodBeat.o(88597);
    return false;
  }
  
  static boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(88596);
    int i = (int)((System.currentTimeMillis() - getLastFreezeTime(paramContext)) / 1000L);
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: tween sec after last freeze: ".concat(String.valueOf(i)), new Object[0]);
    if (i > 30)
    {
      d.d("Soter.SoterBiometricAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
      AppMethodBeat.o(88596);
      return true;
    }
    AppMethodBeat.o(88596);
    return false;
  }
  
  static boolean isSystemHasAntiBruteForce()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private static void setCurrentFailTime(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88590);
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting to time: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (paramInt < 0)
    {
      d.w("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
      AppMethodBeat.o(88590);
      return;
    }
    setCurrentFailTimeInDB(paramContext, paramInt);
    AppMethodBeat.o(88590);
  }
  
  private static void setCurrentFailTimeInDB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88598);
    if (paramContext == null)
    {
      d.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88598);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("key_fail_times", paramInt);
    paramContext.apply();
    AppMethodBeat.o(88598);
  }
  
  private static void setLastFreezeTime(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(88592);
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting last freeze time: ".concat(String.valueOf(paramLong)), new Object[0]);
    if (paramLong < -1L)
    {
      d.w("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
      AppMethodBeat.o(88592);
      return;
    }
    setLastFreezeTimeInDB(paramContext, paramLong);
    AppMethodBeat.o(88592);
  }
  
  private static void setLastFreezeTimeInDB(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(88601);
    if (paramContext == null)
    {
      d.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      AppMethodBeat.o(88601);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("key_last_freeze_time", paramLong);
    paramContext.apply();
    AppMethodBeat.o(88601);
  }
  
  static void unFreeze(Context paramContext)
  {
    AppMethodBeat.i(88594);
    setLastFreezeTime(paramContext, -1L);
    setCurrentFailTime(paramContext, 0);
    AppMethodBeat.o(88594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.SoterBiometricAntiBruteForceStrategy
 * JD-Core Version:    0.7.0.1
 */