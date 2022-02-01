package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Keep
public final class ExtStorageMigrateRoutine
{
  static final String AUXUI_ACTION_DO_MIGRATE_ROUTINE = "auxui_action_do_migrate_routine";
  static final String AUXUI_PARAM_IS_MIGRAION_END = "auxui_param_is_migration_end";
  static final ExtStorageMigrateConfig DEFAULT_CONFIG = ExtStorageMigrateConfig.EQf;
  private static final String LAUNCHER_UI_CLASS_NAME = "com.tencent.mm.ui.LauncherUI";
  static final int NOTIFICATION_TASK_ID = 1027;
  static final int PENDING_INTENT_REQUEST_CANCEL_MIGRATION = 3843;
  static final int PENDING_INTENT_REQUEST_LAUNCH_QUESTIONNAIRE = 3841;
  static final int PENDING_INTENT_REQUEST_LAUNCH_WECHAT = 3842;
  public static final int RESULT_CANCEL_REASON_CANCEL_BEFORE_PROCESSING = 2;
  public static final int RESULT_CANCEL_REASON_CANCEL_ON_PROCESSING = 3;
  public static final int RESULT_CANCEL_REASON_UNNECESSARY = 1;
  public static final int RESULT_FAIL_REASON_DEST_PATH_UNAVAILABLE = 8;
  public static final int RESULT_FAIL_REASON_EXCEPTION_OCCURRED = 5;
  public static final int RESULT_FAIL_REASON_SERVICE_IS_BUSY = 4;
  public static final int RESULT_FAIL_REASON_SERVICE_IS_KILLED = 6;
  public static final int RESULT_FAIL_REASON_SRC_PATH_UNAVAILABLE = 7;
  static final String SERVICE_ACTION_CANCEL_MIGRATE = "service_action_cancel_migrate";
  static final String SERVICE_ACTION_STARTUP = "service_action_startup";
  private static final String SERVICE_CLASS_NAME = "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService";
  private static final String SERVICE_PROCESS_SUFFIX = ":extmig";
  private static final String TAG = "MicroMsg.ExtStorageMigrateRoutine";
  private byte _hellAccFlag_;
  
  static boolean bindMigrationService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(196819);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    boolean bool = paramContext.bindService(localIntent, paramServiceConnection, 0);
    AppMethodBeat.o(196819);
    return bool;
  }
  
  static void cancelMigration(Context paramContext)
  {
    AppMethodBeat.i(196821);
    if (isMigrateServiceRunning(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
      localIntent.setAction("service_action_cancel_migrate");
      paramContext.startService(localIntent);
    }
    AppMethodBeat.o(196821);
  }
  
  private static boolean isMainProcess(String paramString)
  {
    AppMethodBeat.i(196823);
    if (paramString.indexOf(':') < 0)
    {
      AppMethodBeat.o(196823);
      return true;
    }
    AppMethodBeat.o(196823);
    return false;
  }
  
  private static boolean isMigrateServiceProcess(String paramString)
  {
    AppMethodBeat.i(196824);
    boolean bool = paramString.endsWith(":extmig");
    AppMethodBeat.o(196824);
    return bool;
  }
  
  private static boolean isMigrateServiceRunning(Context paramContext)
  {
    AppMethodBeat.i(196816);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
        if ((localRunningServiceInfo.uid == Process.myUid()) && (localRunningServiceInfo.service.getClassName().equals("com.tencent.mm.sdcard_migrate.ExtStorageMigrateService")))
        {
          AppMethodBeat.o(196816);
          return true;
        }
      }
    }
    AppMethodBeat.o(196816);
    return false;
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(196817);
    Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(2147483647);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ActivityManager.RunningTaskInfo)((Iterator)localObject1).next();
        if (((ActivityManager.RunningTaskInfo)localObject2).numActivities > 0)
        {
          String str = paramContext.getPackageName();
          localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).topActivity;
          if ((localObject2 != null) && (str.equals(((ComponentName)localObject2).getPackageName())))
          {
            AppMethodBeat.o(196817);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(196817);
    return false;
  }
  
  static boolean needsToDoMigrate(Context paramContext)
  {
    AppMethodBeat.i(196813);
    if (!b.eEF())
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Sync migrate switch is off, do not trigger questionnaire.", new Object[0]);
      ExtStorageMigrateMonitor.at(1315L, 101L);
      AppMethodBeat.o(196813);
      return false;
    }
    ExtStorageMigrateMonitor.at(1315L, 102L);
    if (b.aEU(DEFAULT_CONFIG.sourceDir))
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Already migrated, do not need to migrate", new Object[0]);
      AppMethodBeat.o(196813);
      return false;
    }
    if (!new File(DEFAULT_CONFIG.sourceDir).exists())
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Old external storage directory does not exist, do not need to migrate.", new Object[0]);
      AppMethodBeat.o(196813);
      return false;
    }
    ExtStorageMigrateMonitor.at(1315L, 100L);
    AppMethodBeat.o(196813);
    return true;
  }
  
  private static void startMigrateQuestionnaire(Context paramContext)
  {
    AppMethodBeat.i(196814);
    Object localObject = new Intent(paramContext, ExtStorageMigrateAuxActivity.class);
    ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
    ((Intent)localObject).addFlags(268435456);
    localObject = PendingIntent.getActivity(paramContext, 3841, (Intent)localObject, 268435456);
    try
    {
      ((PendingIntent)localObject).send();
      AppMethodBeat.o(196814);
      return;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startMigrateQuestionnaire failed, just do normal startup next.", new Object[0]);
      startWeChat(paramContext);
      AppMethodBeat.o(196814);
    }
  }
  
  static void startMigration(Context paramContext, final ExtStorageMigrateConfig paramExtStorageMigrateConfig, MigrateResultCallback paramMigrateResultCallback)
  {
    AppMethodBeat.i(196820);
    startupMigrationService(paramContext);
    bindMigrationService(paramContext, new ServiceConnection()
    {
      private IBinder EQt;
      private IBinder.DeathRecipient EQu;
      
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(196810);
        this.EQt = paramAnonymousIBinder;
        paramAnonymousComponentName = e.a.M(paramAnonymousIBinder);
        try
        {
          paramAnonymousIBinder.linkToDeath(this.EQu, 0);
        }
        catch (RemoteException paramAnonymousIBinder)
        {
          for (;;)
          {
            try
            {
              paramAnonymousComponentName.a(this.EQv);
              paramAnonymousComponentName.a(paramExtStorageMigrateConfig);
              AppMethodBeat.o(196810);
              return;
            }
            catch (RemoteException paramAnonymousComponentName)
            {
              ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousComponentName, "[-] Exception occurred.", new Object[0]);
              try
              {
                this.EQv.b(5, new ExtStorageMigrateException(paramAnonymousComponentName));
                AppMethodBeat.o(196810);
                return;
              }
              catch (RemoteException paramAnonymousComponentName)
              {
                AppMethodBeat.o(196810);
              }
            }
            paramAnonymousIBinder = paramAnonymousIBinder;
            ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousIBinder, "[-] Exception occurred.", new Object[0]);
            try
            {
              this.EQv.b(6, null);
            }
            catch (RemoteException paramAnonymousIBinder) {}
          }
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(196811);
        ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateRoutine", "[!] Service [%s] disconnected.", new Object[] { paramAnonymousComponentName });
        AppMethodBeat.o(196811);
      }
    });
    AppMethodBeat.o(196820);
  }
  
  @SuppressLint({"NewApi"})
  static void startWeChat(Context paramContext)
  {
    AppMethodBeat.i(196815);
    b.eEy();
    Object localObject2 = paramContext.getApplicationContext().getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = new Intent(paramContext, Class.forName("com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject1).setAction("android.intent.action.MAIN");
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject1).addFlags(268435456);
      localObject2 = PendingIntent.getActivity(paramContext, 3842, (Intent)localObject1, 268435456);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      try
      {
        ((PendingIntent)localObject2).send();
        AppMethodBeat.o(196815);
        return;
      }
      catch (Throwable localThrowable)
      {
        ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startWeChat failed, retry with normal way.", new Object[0]);
        if (!(paramContext instanceof Activity)) {
          break label152;
        }
        ((Intent)localObject1).removeFlags(268435456);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(196815);
      }
      paramContext = paramContext;
      paramContext = new IllegalStateException("Should not be here.");
      AppMethodBeat.o(196815);
      throw paramContext;
    }
  }
  
  static void startupMigrationService(Context paramContext)
  {
    AppMethodBeat.i(196818);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    paramContext.startService(localIntent);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] startupMigrationService called.", new Object[0]);
    AppMethodBeat.o(196818);
  }
  
  private static void suicide()
  {
    AppMethodBeat.i(196825);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(196825);
  }
  
  public static void triggerMediaRescanOnDemand()
  {
    AppMethodBeat.i(196822);
    Application localApplication = d.cKY.getApplication();
    String str = d.cvL;
    if (!localApplication.getPackageName().equals(str))
    {
      AppMethodBeat.o(196822);
      return;
    }
    if (!b.eEC())
    {
      AppMethodBeat.o(196822);
      return;
    }
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.aiq(), localApplication);
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.air(), localApplication);
    b.eEE();
    AppMethodBeat.o(196822);
  }
  
  @Keep
  static boolean triggerOnDemand(Context paramContext)
  {
    AppMethodBeat.i(196812);
    String str = d.cvL;
    if (isMigrateServiceProcess(str))
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate Service Process, skip rest logic in appLike.", new Object[0]);
      AppMethodBeat.o(196812);
      return true;
    }
    if (!isMainProcess(str))
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Not in main process, startup normally.", new Object[0]);
      AppMethodBeat.o(196812);
      return false;
    }
    if (b.eEx())
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Last migrate routine indicates that we should startup normally this time.", new Object[0]);
      b.eEz();
      AppMethodBeat.o(196812);
      return false;
    }
    if (!isMigrateServiceRunning(paramContext))
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is not running, check if we have external storage permission next.", new Object[0]);
      if (com.tencent.mm.pluginsdk.permission.b.e(paramContext, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }))
      {
        ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] We have external storage permission, do not need to migrate.", new Object[0]);
        AppMethodBeat.o(196812);
        return false;
      }
    }
    else
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is running, check if we are doing migrating next.", new Object[0]);
    }
    if (!isStartWithActivity(paramContext))
    {
      ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Start up without any activities, let it continue normally.", new Object[0]);
      AppMethodBeat.o(196812);
      return false;
    }
    if (!needsToDoMigrate(paramContext))
    {
      AppMethodBeat.o(196812);
      return false;
    }
    startMigrateQuestionnaire(paramContext);
    ExtStorageMigrateMonitor.eEl();
    suicide();
    AppMethodBeat.o(196812);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine
 * JD-Core Version:    0.7.0.1
 */