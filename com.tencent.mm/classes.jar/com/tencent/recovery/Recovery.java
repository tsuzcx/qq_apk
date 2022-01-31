package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;

public class Recovery
{
  private static Application application;
  private static Context context;
  private static long wKA;
  private static String wKB;
  private static boolean wKC = false;
  private static boolean wKD = false;
  private static int wKE = 0;
  private static Application.ActivityLifecycleCallbacks wKF = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      if (Recovery.wKD) {}
      while (Recovery.cOw().hasMessages(3)) {
        return;
      }
      Recovery.cOw().removeCallbacksAndMessages(null);
      paramAnonymousActivity = Util.ht(Recovery.cOx());
      paramAnonymousBundle = Recovery.cOx().getSharedPreferences(Recovery.wKB, 0).edit();
      paramAnonymousBundle.putInt("KeyComponentOnCreateForeground", 1);
      paramAnonymousBundle.putInt("KeyComponentOnCreateExceptionType", 4096);
      paramAnonymousBundle.apply();
      paramAnonymousBundle = OptionFactory.dS(paramAnonymousActivity, 1);
      Recovery.cOw().sendEmptyMessageDelayed(3, paramAnonymousBundle.dEk);
      RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", new Object[] { paramAnonymousActivity, Long.valueOf(System.currentTimeMillis() - Recovery.auo()) });
    }
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public final void onActivityPaused(Activity paramAnonymousActivity) {}
    
    public final void onActivityResumed(Activity paramAnonymousActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      Recovery.cOy();
    }
    
    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      Recovery.cOz();
      if (Recovery.su() == 0)
      {
        RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", new Object[] { Util.ht(Recovery.cOx()) });
        Recovery.Jh(16);
      }
    }
  };
  private static RecoveryMessageHandler wKz;
  
  public static void Jh(int paramInt)
  {
    if (context == null) {}
    while (wKD) {
      return;
    }
    cOv();
    Object localObject = Util.ht(context);
    SharedPreferences localSharedPreferences = context.getSharedPreferences(wKB, 0);
    RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", new Object[] { localObject, Integer.toHexString(paramInt), Long.valueOf(System.currentTimeMillis() - wKA) });
    wKz.removeCallbacksAndMessages(null);
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove("KeyComponentOnCreateExceptionType");
    ((SharedPreferences.Editor)localObject).putInt("KeyComponentOnCreateNormalType", paramInt);
    ((SharedPreferences.Editor)localObject).apply();
    destroy();
  }
  
  public static void cOs()
  {
    if (wKD) {}
    while (wKC) {
      return;
    }
    wKC = true;
    Object localObject = Util.ht(context);
    int i = RecoveryLogic.bI(context, (String)localObject);
    RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - wKA) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wKB, 0).edit();
    localEditor.remove("KeyAppOnCreateExceptionType");
    localEditor.putInt("KeyAppOnCreateNormalType", 256);
    if (RecoveryLogic.bI(context, (String)localObject) == 16)
    {
      localEditor.putInt("KeyComponentOnCreateForeground", i);
      localEditor.putInt("KeyComponentOnCreateExceptionType", 4096);
      localObject = OptionFactory.dS((String)localObject, i);
      wKz.sendEmptyMessageDelayed(2, ((ProcessOptions)localObject).dEk);
    }
    localEditor.apply();
  }
  
  public static void cOt()
  {
    if (context == null) {}
    while (wKD) {
      return;
    }
    cOv();
    RecoveryLog.i("Recovery", "%s Recovery.crash %d", new Object[] { Util.ht(context), Long.valueOf(System.currentTimeMillis() - wKA) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wKB, 0).edit();
    if (wKC) {
      localEditor.putInt("KeyComponentOnCreateExceptionType", 65536);
    }
    for (;;)
    {
      localEditor.apply();
      destroy();
      return;
      localEditor.putInt("KeyAppOnCreateExceptionType", 65536);
    }
  }
  
  public static void cOu()
  {
    if (context == null) {}
    while (wKD) {
      return;
    }
    cOv();
    RecoveryLog.i("Recovery", "%s Recovery.anr %d", new Object[] { Util.ht(context), Long.valueOf(System.currentTimeMillis() - wKA) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wKB, 0).edit();
    if (wKC) {
      localEditor.putInt("KeyComponentOnCreateExceptionType", 1048576);
    }
    for (;;)
    {
      localEditor.apply();
      destroy();
      return;
      localEditor.putInt("KeyAppOnCreateExceptionType", 1048576);
    }
  }
  
  private static void cOv()
  {
    if (context == null) {}
    while (wKD) {
      return;
    }
    RecoveryLog.i("Recovery", "%s markFinalStatus", new Object[] { Util.ht(context) });
    wKD = true;
  }
  
  private static void destroy()
  {
    if (application != null) {
      application.unregisterActivityLifecycleCallbacks(wKF);
    }
  }
  
  public static Context getContext()
  {
    return context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.Recovery
 * JD-Core Version:    0.7.0.1
 */