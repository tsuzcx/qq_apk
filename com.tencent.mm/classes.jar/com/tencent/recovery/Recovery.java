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
  private static RecoveryMessageHandler Bia;
  private static long Bib;
  private static String Bic;
  private static boolean Bid = false;
  private static boolean Bie = false;
  private static int Bif = 0;
  private static Application.ActivityLifecycleCallbacks Big = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      if (Recovery.Bie) {}
      while (Recovery.dUl().hasMessages(3)) {
        return;
      }
      Recovery.dUl().removeCallbacksAndMessages(null);
      paramAnonymousActivity = Util.iU(Recovery.dUm());
      paramAnonymousBundle = Recovery.dUm().getSharedPreferences(Recovery.Bic, 0).edit();
      paramAnonymousBundle.putInt("KeyComponentOnCreateForeground", 1);
      paramAnonymousBundle.putInt("KeyComponentOnCreateExceptionType", 4096);
      paramAnonymousBundle.apply();
      paramAnonymousBundle = OptionFactory.fc(paramAnonymousActivity, 1);
      Recovery.dUl().sendEmptyMessageDelayed(3, paramAnonymousBundle.eBM);
      RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", new Object[] { paramAnonymousActivity, Long.valueOf(System.currentTimeMillis() - Recovery.aTO()) });
    }
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public final void onActivityPaused(Activity paramAnonymousActivity) {}
    
    public final void onActivityResumed(Activity paramAnonymousActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      Recovery.dUn();
    }
    
    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      Recovery.dUo();
      if (Recovery.AL() == 0)
      {
        RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", new Object[] { Util.iU(Recovery.dUm()) });
        Recovery.Sd(16);
      }
    }
  };
  private static Application application;
  private static Context context;
  
  public static void Sd(int paramInt)
  {
    if (context == null) {}
    while (Bie) {
      return;
    }
    dUk();
    Object localObject = Util.iU(context);
    SharedPreferences localSharedPreferences = context.getSharedPreferences(Bic, 0);
    RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", new Object[] { localObject, Integer.toHexString(paramInt), Long.valueOf(System.currentTimeMillis() - Bib) });
    Bia.removeCallbacksAndMessages(null);
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove("KeyComponentOnCreateExceptionType");
    ((SharedPreferences.Editor)localObject).putInt("KeyComponentOnCreateNormalType", paramInt);
    ((SharedPreferences.Editor)localObject).apply();
    destroy();
  }
  
  public static void dUh()
  {
    if (Bie) {}
    while (Bid) {
      return;
    }
    Bid = true;
    Object localObject = Util.iU(context);
    int i = RecoveryLogic.bV(context, (String)localObject);
    RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - Bib) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(Bic, 0).edit();
    localEditor.remove("KeyAppOnCreateExceptionType");
    localEditor.putInt("KeyAppOnCreateNormalType", 256);
    if (RecoveryLogic.bV(context, (String)localObject) == 16)
    {
      localEditor.putInt("KeyComponentOnCreateForeground", i);
      localEditor.putInt("KeyComponentOnCreateExceptionType", 4096);
      localObject = OptionFactory.fc((String)localObject, i);
      Bia.sendEmptyMessageDelayed(2, ((ProcessOptions)localObject).eBM);
    }
    localEditor.apply();
  }
  
  public static void dUi()
  {
    if (context == null) {}
    while (Bie) {
      return;
    }
    dUk();
    RecoveryLog.i("Recovery", "%s Recovery.crash %d", new Object[] { Util.iU(context), Long.valueOf(System.currentTimeMillis() - Bib) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(Bic, 0).edit();
    if (Bid) {
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
  
  public static void dUj()
  {
    if (context == null) {}
    while (Bie) {
      return;
    }
    dUk();
    RecoveryLog.i("Recovery", "%s Recovery.anr %d", new Object[] { Util.iU(context), Long.valueOf(System.currentTimeMillis() - Bib) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(Bic, 0).edit();
    if (Bid) {
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
  
  private static void dUk()
  {
    if (context == null) {}
    while (Bie) {
      return;
    }
    RecoveryLog.i("Recovery", "%s markFinalStatus", new Object[] { Util.iU(context) });
    Bie = true;
  }
  
  private static void destroy()
  {
    if (application != null) {
      application.unregisterActivityLifecycleCallbacks(Big);
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