package com.tencent.soter.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.soter.core.c.d;

public final class c
{
  static void freeze(Context paramContext)
  {
    setCurrentFailTime(paramContext, 6);
    setLastFreezeTime(paramContext, System.currentTimeMillis());
  }
  
  static int getCurrentFailTime(Context paramContext)
  {
    paramContext = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_fail_times", 0));
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: " + paramContext, new Object[0]);
    return paramContext.intValue();
  }
  
  public static boolean isCurrentFailTimeAvailable(Context paramContext)
  {
    boolean bool = false;
    if (getCurrentFailTime(paramContext) < 5)
    {
      d.i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  public static boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    paramContext = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("key_last_freeze_time", -1L));
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: " + paramContext, new Object[0]);
    int i = (int)((l - paramContext.longValue()) / 1000L);
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: " + i, new Object[0]);
    if (i > 30)
    {
      d.d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  static boolean isSystemHasAntiBruteForce()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  static void setCurrentFailTime(Context paramContext, int paramInt)
  {
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: " + paramInt, new Object[0]);
    if (paramInt < 0)
    {
      d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("key_fail_times", paramInt);
    paramContext.apply();
  }
  
  private static void setLastFreezeTime(Context paramContext, long paramLong)
  {
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: " + paramLong, new Object[0]);
    if (paramLong < -1L)
    {
      d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.a.c
 * JD-Core Version:    0.7.0.1
 */