package com.tencent.soter.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

@Deprecated
public final class c
{
  static void freeze(Context paramContext)
  {
    AppMethodBeat.i(73000);
    setCurrentFailTime(paramContext, 6);
    setLastFreezeTime(paramContext, System.currentTimeMillis());
    AppMethodBeat.o(73000);
  }
  
  static int getCurrentFailTime(Context paramContext)
  {
    AppMethodBeat.i(72996);
    paramContext = Integer.valueOf(getCurrentFailTimeInDB(paramContext));
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: current retry time: ".concat(String.valueOf(paramContext)), new Object[0]);
    int i = paramContext.intValue();
    AppMethodBeat.o(72996);
    return i;
  }
  
  private static int getCurrentFailTimeInDB(Context paramContext)
  {
    AppMethodBeat.i(73005);
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("key_fail_times", 0);
    AppMethodBeat.o(73005);
    return i;
  }
  
  private static long getLastFreezeTime(Context paramContext)
  {
    AppMethodBeat.i(72998);
    paramContext = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("key_last_freeze_time", -1L));
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: current last freeze time: ".concat(String.valueOf(paramContext)), new Object[0]);
    long l = paramContext.longValue();
    AppMethodBeat.o(72998);
    return l;
  }
  
  public static boolean isCurrentFailTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(73003);
    if (getCurrentFailTime(paramContext) < 5)
    {
      d.i("Soter.SoterAntiBruteForceStrategy", "soter: fail time available", new Object[0]);
      AppMethodBeat.o(73003);
      return true;
    }
    AppMethodBeat.o(73003);
    return false;
  }
  
  public static boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(73002);
    int i = (int)((System.currentTimeMillis() - getLastFreezeTime(paramContext)) / 1000L);
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: tween sec after last freeze: ".concat(String.valueOf(i)), new Object[0]);
    if (i > 30)
    {
      d.d("Soter.SoterAntiBruteForceStrategy", "soter: after last freeze", new Object[0]);
      AppMethodBeat.o(73002);
      return true;
    }
    AppMethodBeat.o(73002);
    return false;
  }
  
  static boolean isSystemHasAntiBruteForce()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  static void setCurrentFailTime(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(72997);
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting to time: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (paramInt < 0)
    {
      d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal fail time", new Object[0]);
      AppMethodBeat.o(72997);
      return;
    }
    setCurrentFailTimeInDB(paramContext, paramInt);
    AppMethodBeat.o(72997);
  }
  
  private static void setCurrentFailTimeInDB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(73004);
    if (paramContext == null)
    {
      d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      AppMethodBeat.o(73004);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("key_fail_times", paramInt);
    paramContext.apply();
    AppMethodBeat.o(73004);
  }
  
  private static void setLastFreezeTime(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(72999);
    d.i("Soter.SoterAntiBruteForceStrategy", "soter: setting last freeze time: ".concat(String.valueOf(paramLong)), new Object[0]);
    if (paramLong < -1L)
    {
      d.w("Soter.SoterAntiBruteForceStrategy", "soter: illegal setLastFreezeTime", new Object[0]);
      AppMethodBeat.o(72999);
      return;
    }
    if (paramContext == null)
    {
      d.e("Soter.SoterAntiBruteForceStrategy", "soter: context is null", new Object[0]);
      AppMethodBeat.o(72999);
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("key_last_freeze_time", paramLong);
    paramContext.apply();
    AppMethodBeat.o(72999);
  }
  
  static void unFreeze(Context paramContext)
  {
    AppMethodBeat.i(73001);
    setLastFreezeTime(paramContext, -1L);
    setCurrentFailTime(paramContext, 0);
    AppMethodBeat.o(73001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.a.c
 * JD-Core Version:    0.7.0.1
 */