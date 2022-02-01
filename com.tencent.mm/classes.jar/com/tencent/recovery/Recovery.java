package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.config.Express;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.util.Util;

public class Recovery
{
  private static final String TAG = "Recovery";
  private static int activityForegroundCount = 0;
  private static Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      if (Recovery.markFinalStatus) {}
      while (Recovery.recoveryMessageHandler.hasMessages(3)) {
        return;
      }
      Recovery.recoveryMessageHandler.removeCallbacksAndMessages(null);
      paramAnonymousActivity = Util.getMyProcessName(Recovery.context);
      paramAnonymousBundle = Recovery.context.getSharedPreferences(Recovery.spName, 0).edit();
      paramAnonymousBundle.putInt("KeyComponentOnCreateForeground", 1);
      paramAnonymousBundle.putInt("KeyComponentOnCreateExceptionType", 4096);
      paramAnonymousBundle.apply();
      paramAnonymousBundle = OptionFactory.getProcessOptions(paramAnonymousActivity, 1);
      Recovery.recoveryMessageHandler.sendEmptyMessageDelayed(3, paramAnonymousBundle.getTimeout());
      RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", new Object[] { paramAnonymousActivity, Long.valueOf(System.currentTimeMillis() - Recovery.startRecoveryTime) });
    }
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public final void onActivityPaused(Activity paramAnonymousActivity) {}
    
    public final void onActivityResumed(Activity paramAnonymousActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      Recovery.access$508();
    }
    
    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      Recovery.access$510();
      if (Recovery.activityForegroundCount == 0)
      {
        RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", new Object[] { Util.getMyProcessName(Recovery.context) });
        Recovery.normal(16);
      }
    }
  };
  private static Application application;
  private static CommonOptions commonOptions;
  private static Context context;
  private static boolean markAppOnCreateEnd = false;
  private static boolean markFinalStatus = false;
  private static RecoveryMessageHandler recoveryMessageHandler;
  private static String spName;
  private static long startRecoveryTime;
  
  public static void anr()
  {
    if (context == null) {}
    while (markFinalStatus) {
      return;
    }
    markFinalStatus();
    RecoveryLog.i("Recovery", "%s Recovery.anr %d", new Object[] { Util.getMyProcessName(context), Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(spName, 0).edit();
    if (markAppOnCreateEnd) {
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
  
  public static void attachBaseContext(Application paramApplication, Context paramContext, String paramString)
  {
    OptionFactory.initOptionCreator(paramString);
    application = paramApplication;
    context = paramContext;
    commonOptions = OptionFactory.getCommonOptions(paramContext);
    if (application != null) {
      application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
    String str = Util.getMyProcessName(paramContext);
    if (RecoveryLogic.isRecoveryProcess(paramContext))
    {
      if (commonOptions.isDebugMode()) {
        RecoveryLog.setDebugMode();
      }
      RecoveryLog.setLogImpl(new RecoveryFileLog(getContext()));
      markFinalStatus();
      RecoveryLog.i("Recovery", "recovery process, no need to do any thing", new Object[0]);
      return;
    }
    RecoveryLog.i("Recovery", "%s attachBaseContext start ============================== %d", new Object[] { str, Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
    spName = "recovery-".concat(String.valueOf(str));
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(spName, 0);
    Object localObject = localSharedPreferences.getString("KeyRecoveryVersion", "");
    paramString = localSharedPreferences.edit();
    paramApplication = paramString;
    if (!((String)localObject).equals(commonOptions.getClientVersion()))
    {
      paramString.clear();
      paramString.putString("KeyRecoveryVersion", commonOptions.getClientVersion());
      paramString.apply();
      RecoveryLog.i("Recovery", "recovery sp version not equal lastVersion %s currentVersion %s", new Object[] { localObject, commonOptions.getClientVersion() });
      paramApplication = localSharedPreferences.edit();
    }
    paramString = new RecoveryContext();
    paramString.readFromSp(localSharedPreferences);
    localObject = new RecoveryStatusItem();
    ((RecoveryStatusItem)localObject).processName = str;
    ((RecoveryStatusItem)localObject).clientVersion = commonOptions.getClientVersion();
    ((RecoveryStatusItem)localObject).uuid = commonOptions.getUUID();
    ((RecoveryStatusItem)localObject).timestamp = System.currentTimeMillis();
    int i;
    if (localSharedPreferences.contains("KeyAppOnCreateExceptionType"))
    {
      RecoveryLog.i("Recovery", "contains KeyAppOnCreateExceptionType", new Object[0]);
      ((RecoveryStatusItem)localObject).processStartFlag = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
      ((RecoveryStatusItem)localObject).processStatus = localSharedPreferences.getInt("KeyAppOnCreateExceptionType", 4096);
      ((RecoveryStatusItem)localObject).processStage = 1;
      if (((RecoveryStatusItem)localObject).isException())
      {
        paramString.addExceptionItem((RecoveryStatusItem)localObject);
        RecoveryLogic.startReportService(paramContext, (RecoveryStatusItem)localObject, RecoveryReportService.class.getName());
      }
      paramApplication.remove("KeyAppOnCreateForeground");
      paramApplication.remove("KeyAppOnCreateExceptionType");
      paramApplication.remove("KeyAppOnCreateNormalType");
      paramApplication.remove("KeyComponentOnCreateForeground");
      paramApplication.remove("KeyComponentOnCreateExceptionType");
      paramApplication.remove("KeyComponentOnCreateNormalType");
      i = RecoveryLogic.getProcessStartFlag(paramContext, str);
      RecoveryLog.i("Recovery", "processStartFlag %s %s", new Object[] { str, Integer.toHexString(i) });
      if (!OptionFactory.getProcessOptions(str, i).getExpress().getResult(paramString.exceptionItemList)) {
        break label794;
      }
      RecoveryLogic.startHandleService(paramContext, commonOptions, paramString);
      paramString.clear();
      markFinalStatus();
    }
    for (;;)
    {
      paramString.saveToSp(paramApplication);
      paramApplication.apply();
      RecoveryLog.i("Recovery", "%s attachBaseContext end ============================== %d", new Object[] { str, Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
      return;
      if (localSharedPreferences.contains("KeyComponentOnCreateExceptionType"))
      {
        RecoveryLog.i("Recovery", "contains KeyComponentOnCreateExceptionType", new Object[0]);
        ((RecoveryStatusItem)localObject).processStartFlag = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
        ((RecoveryStatusItem)localObject).processStatus = localSharedPreferences.getInt("KeyComponentOnCreateExceptionType", 4096);
        ((RecoveryStatusItem)localObject).processStage = 16;
        break;
      }
      paramString.clear();
      if (localSharedPreferences.contains("KeyAppOnCreateNormalType"))
      {
        if (localSharedPreferences.contains("KeyComponentOnCreateNormalType"))
        {
          RecoveryLog.i("Recovery", "contains KeyComponentOnCreateNormalType", new Object[0]);
          ((RecoveryStatusItem)localObject).processStartFlag = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
          ((RecoveryStatusItem)localObject).processStatus = localSharedPreferences.getInt("KeyComponentOnCreateNormalType", 273);
          ((RecoveryStatusItem)localObject).processStage = 16;
          break;
        }
        RecoveryLog.i("Recovery", "contains KeyAppOnCreateNormalType", new Object[0]);
        ((RecoveryStatusItem)localObject).processStartFlag = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
        ((RecoveryStatusItem)localObject).processStatus = localSharedPreferences.getInt("KeyAppOnCreateNormalType", 273);
        ((RecoveryStatusItem)localObject).processStage = 1;
        break;
      }
      RecoveryLog.i("Recovery", "DefaultNormal", new Object[0]);
      ((RecoveryStatusItem)localObject).processStartFlag = 17;
      ((RecoveryStatusItem)localObject).processStatus = 273;
      ((RecoveryStatusItem)localObject).processStage = 1;
      break;
      label794:
      paramApplication.putInt("KeyAppOnCreateForeground", i);
      paramApplication.putInt("KeyComponentOnCreateForeground", i);
      paramApplication.putInt("KeyAppOnCreateExceptionType", 4096);
    }
  }
  
  public static void crash()
  {
    if (context == null) {}
    while (markFinalStatus) {
      return;
    }
    markFinalStatus();
    RecoveryLog.i("Recovery", "%s Recovery.crash %d", new Object[] { Util.getMyProcessName(context), Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(spName, 0).edit();
    if (markAppOnCreateEnd) {
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
  
  private static void destroy()
  {
    if (application != null) {
      application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
  }
  
  public static CommonOptions getCommonOptions()
  {
    if (commonOptions == null) {
      commonOptions = ConstantsRecovery.DefaultCommonOptions.DefaultOptions;
    }
    return commonOptions;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static void initStatic()
  {
    RecoveryLog.i("Recovery", "initStatic Run", new Object[0]);
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
    try
    {
      System.loadLibrary("recovery");
      startRecoveryTime = System.currentTimeMillis();
      recoveryMessageHandler = new RecoveryMessageHandler();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RecoveryLog.printErrStackTrace("Recovery", localException, "load recovery library", new Object[0]);
      }
    }
  }
  
  public static void markApplicationOnCreateNormal()
  {
    if (markFinalStatus) {}
    while (markAppOnCreateEnd) {
      return;
    }
    markAppOnCreateEnd = true;
    Object localObject = Util.getMyProcessName(context);
    int i = RecoveryLogic.getProcessStartFlag(context, (String)localObject);
    RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(spName, 0).edit();
    localEditor.remove("KeyAppOnCreateExceptionType");
    localEditor.putInt("KeyAppOnCreateNormalType", 256);
    if (RecoveryLogic.getProcessStartFlag(context, (String)localObject) == 16)
    {
      localEditor.putInt("KeyComponentOnCreateForeground", i);
      localEditor.putInt("KeyComponentOnCreateExceptionType", 4096);
      localObject = OptionFactory.getProcessOptions((String)localObject, i);
      recoveryMessageHandler.sendEmptyMessageDelayed(2, ((ProcessOptions)localObject).getTimeout());
    }
    localEditor.apply();
  }
  
  private static void markFinalStatus()
  {
    if (context == null) {}
    while (markFinalStatus) {
      return;
    }
    RecoveryLog.i("Recovery", "%s markFinalStatus", new Object[] { Util.getMyProcessName(context) });
    markFinalStatus = true;
  }
  
  public static void normal(int paramInt)
  {
    if (context == null) {}
    while (markFinalStatus) {
      return;
    }
    markFinalStatus();
    Object localObject = Util.getMyProcessName(context);
    SharedPreferences localSharedPreferences = context.getSharedPreferences(spName, 0);
    RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", new Object[] { localObject, Integer.toHexString(paramInt), Long.valueOf(System.currentTimeMillis() - startRecoveryTime) });
    recoveryMessageHandler.removeCallbacksAndMessages(null);
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove("KeyComponentOnCreateExceptionType");
    ((SharedPreferences.Editor)localObject).putInt("KeyComponentOnCreateNormalType", paramInt);
    ((SharedPreferences.Editor)localObject).apply();
    destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.Recovery
 * JD-Core Version:    0.7.0.1
 */