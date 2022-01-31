package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.soter.core.c.d;

public class SoterBiometricAntiBruteForceStrategy
{
  private static final long DEFAULT_FREEZE_TIME = -1L;
  private static final int FREEZE_SECOND = 30;
  private static final String KEY_FAIL_TIMES = "key_fail_times";
  private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
  private static final int MAX_FAIL_NUM = 5;
  private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";
  
  static void addFailTime(Context paramContext)
  {
    setCurrentFailTime(paramContext, Integer.valueOf(Integer.valueOf(getCurrentFailTime(paramContext)).intValue() + 1).intValue());
  }
  
  static void freeze(Context paramContext)
  {
    setCurrentFailTime(paramContext, 6);
    setLastFreezeTime(paramContext, System.currentTimeMillis());
  }
  
  private static int getCurrentFailTime(Context paramContext)
  {
    paramContext = Integer.valueOf(getCurrentFailTimeInDB(paramContext));
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current retry time: " + paramContext, new Object[0]);
    return paramContext.intValue();
  }
  
  private static int getCurrentFailTimeInDB(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_fail_times", 0);
  }
  
  private static long getLastFreezeTime(Context paramContext)
  {
    paramContext = Long.valueOf(getLastFreezeTimeInDB(paramContext));
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: current last freeze time: " + paramContext, new Object[0]);
    return paramContext.longValue();
  }
  
  private static long getLastFreezeTimeInDB(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("key_last_freeze_time", -1L);
  }
  
  static boolean isCurrentFailTimeAvailable(Context paramContext)
  {
    boolean bool = false;
    if (getCurrentFailTime(paramContext) < 5)
    {
      d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  static boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    boolean bool = false;
    int i = (int)((System.currentTimeMillis() - getLastFreezeTime(paramContext)) / 1000L);
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: tween sec after last freeze: " + i, new Object[0]);
    if (i > 30)
    {
      d.d("Soter.SoterBiometricAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  static boolean isSystemHasAntiBruteForce()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private static void setCurrentFailTime(Context paramContext, int paramInt)
  {
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting to time: " + paramInt, new Object[0]);
    if (paramInt < 0)
    {
      d.w("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
      return;
    }
    setCurrentFailTimeInDB(paramContext, paramInt);
  }
  
  private static void setCurrentFailTimeInDB(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      d.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("key_fail_times", paramInt);
    paramContext.apply();
  }
  
  private static void setLastFreezeTime(Context paramContext, long paramLong)
  {
    d.i("Soter.SoterBiometricAntiBruteForceStrategy", "soter: setting last freeze time: " + paramLong, new Object[0]);
    if (paramLong < -1L)
    {
      d.w("Soter.SoterBiometricAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
      return;
    }
    setLastFreezeTimeInDB(paramContext, paramLong);
  }
  
  private static void setLastFreezeTimeInDB(Context paramContext, long paramLong)
  {
    if (paramContext == null)
    {
      d.e("Soter.SoterBiometricAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("key_last_freeze_time", paramLong);
    paramContext.apply();
  }
  
  static void unFreeze(Context paramContext)
  {
    setLastFreezeTime(paramContext, -1L);
    setCurrentFailTime(paramContext, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.biometric.SoterBiometricAntiBruteForceStrategy
 * JD-Core Version:    0.7.0.1
 */