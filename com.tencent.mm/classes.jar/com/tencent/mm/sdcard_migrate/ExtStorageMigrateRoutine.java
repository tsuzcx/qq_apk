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
import android.os.Build;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Keep
public final class ExtStorageMigrateRoutine
{
  static final String AUXUI_ACTION_DO_MIGRATE_ROUTINE = "auxui_action_do_migrate_routine";
  static final String AUXUI_PARAM_IS_MIGRAION_END = "auxui_param_is_migration_end";
  static final ExtStorageMigrateConfig DEFAULT_CONFIG = ExtStorageMigrateConfig.UUm;
  private static final boolean[] IS_ACCOUNT_INIT_CALLBACK_ADDED = { false };
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
    AppMethodBeat.i(191742);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    boolean bool = paramContext.bindService(localIntent, paramServiceConnection, 0);
    AppMethodBeat.o(191742);
    return bool;
  }
  
  static void cancelMigration(Context paramContext)
  {
    AppMethodBeat.i(191747);
    if (isMigrateServiceRunning(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
      localIntent.setAction("service_action_cancel_migrate");
      paramContext.startService(localIntent);
    }
    AppMethodBeat.o(191747);
  }
  
  private static boolean isDeviceChangedUnexpectly()
  {
    AppMethodBeat.i(191724);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("extstg_migrate_preconditions");
    ??? = localMultiProcessMMKV.getString("last_fingerprint", "");
    if ((??? == null) || (!((String)???).equals(Build.FINGERPRINT))) {
      synchronized (IS_ACCOUNT_INIT_CALLBACK_ADDED)
      {
        if (IS_ACCOUNT_INIT_CALLBACK_ADDED[0] == 0)
        {
          EventCenter.instance.add(new IListener() {});
          IS_ACCOUNT_INIT_CALLBACK_ADDED[0] = true;
        }
        AppMethodBeat.o(191724);
        return true;
      }
    }
    AppMethodBeat.o(191724);
    return false;
  }
  
  private static boolean isMainProcess(String paramString)
  {
    AppMethodBeat.i(191753);
    if (paramString.indexOf(':') < 0)
    {
      AppMethodBeat.o(191753);
      return true;
    }
    AppMethodBeat.o(191753);
    return false;
  }
  
  private static boolean isMigrateServiceProcess(String paramString)
  {
    AppMethodBeat.i(191754);
    boolean bool = paramString.endsWith(":extmig");
    AppMethodBeat.o(191754);
    return bool;
  }
  
  private static boolean isMigrateServiceRunning(Context paramContext)
  {
    AppMethodBeat.i(191734);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
        if ((localRunningServiceInfo.uid == Process.myUid()) && (localRunningServiceInfo.service.getClassName().equals("com.tencent.mm.sdcard_migrate.ExtStorageMigrateService")))
        {
          AppMethodBeat.o(191734);
          return true;
        }
      }
    }
    AppMethodBeat.o(191734);
    return false;
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(191737);
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
            AppMethodBeat.o(191737);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(191737);
    return false;
  }
  
  static boolean needsToDoMigrate(Context paramContext)
  {
    AppMethodBeat.i(191722);
    ExtStorageMigrateMonitor.Um(102L);
    if (b.hsX())
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Newly installed, existed old data is ignored, do not need to migrate.", new Object[0]);
      ExtStorageMigrateMonitor.Um(190L);
      AppMethodBeat.o(191722);
      return false;
    }
    if (b.buj(DEFAULT_CONFIG.UUi))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Already migrated, do not need to migrate", new Object[0]);
      AppMethodBeat.o(191722);
      return false;
    }
    if (!new File(DEFAULT_CONFIG.UUi).exists())
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Old external storage directory does not exist, do not need to migrate.", new Object[0]);
      AppMethodBeat.o(191722);
      return false;
    }
    ExtStorageMigrateMonitor.Um(100L);
    AppMethodBeat.o(191722);
    return true;
  }
  
  private static void startMigrateQuestionnaire(Context paramContext)
  {
    AppMethodBeat.i(191726);
    Object localObject = new Intent(paramContext, ExtStorageMigrateAuxActivity.class);
    ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
    ((Intent)localObject).addFlags(268435456);
    localObject = PendingIntent.getActivity(paramContext, 3841, (Intent)localObject, 268435456);
    try
    {
      ((PendingIntent)localObject).send();
      AppMethodBeat.o(191726);
      return;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.hsJ().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startMigrateQuestionnaire failed, just do normal startup next.", new Object[0]);
      startWeChat(paramContext);
      AppMethodBeat.o(191726);
    }
  }
  
  static void startMigration(Context paramContext, final ExtStorageMigrateConfig paramExtStorageMigrateConfig, MigrateResultCallback paramMigrateResultCallback)
  {
    AppMethodBeat.i(191744);
    startupMigrationService(paramContext);
    bindMigrationService(paramContext, new ServiceConnection()
    {
      private IBinder.DeathRecipient UUA;
      private IBinder UUz;
      
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(192287);
        this.UUz = paramAnonymousIBinder;
        paramAnonymousComponentName = e.a.R(paramAnonymousIBinder);
        try
        {
          paramAnonymousIBinder.linkToDeath(this.UUA, 0);
        }
        catch (RemoteException paramAnonymousIBinder)
        {
          for (;;)
          {
            try
            {
              paramAnonymousComponentName.a(this.UUB);
              paramAnonymousComponentName.a(paramExtStorageMigrateConfig);
              AppMethodBeat.o(192287);
              return;
            }
            catch (RemoteException paramAnonymousComponentName)
            {
              ExtStorageMigrateMonitor.hsJ().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousComponentName, "[-] Exception occurred.", new Object[0]);
              try
              {
                this.UUB.b(5, new ExtStorageMigrateException(paramAnonymousComponentName));
                AppMethodBeat.o(192287);
                return;
              }
              catch (RemoteException paramAnonymousComponentName)
              {
                AppMethodBeat.o(192287);
              }
            }
            paramAnonymousIBinder = paramAnonymousIBinder;
            ExtStorageMigrateMonitor.hsJ().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousIBinder, "[-] Exception occurred.", new Object[0]);
            try
            {
              this.UUB.b(6, null);
            }
            catch (RemoteException paramAnonymousIBinder) {}
          }
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(192291);
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateRoutine", "[!] Service [%s] disconnected.", new Object[] { paramAnonymousComponentName });
        AppMethodBeat.o(192291);
      }
    });
    AppMethodBeat.o(191744);
  }
  
  @SuppressLint({"NewApi"})
  static void startWeChat(Context paramContext)
  {
    AppMethodBeat.i(191730);
    b.hsZ();
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
        AppMethodBeat.o(191730);
        return;
      }
      catch (Throwable localThrowable)
      {
        ExtStorageMigrateMonitor.hsJ().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startWeChat failed, retry with normal way.", new Object[0]);
        if (!(paramContext instanceof Activity)) {
          break label152;
        }
        ((Intent)localObject1).removeFlags(268435456);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(191730);
      }
      paramContext = paramContext;
      paramContext = new IllegalStateException("Should not be here.");
      AppMethodBeat.o(191730);
      throw paramContext;
    }
  }
  
  static void startupMigrationService(Context paramContext)
  {
    AppMethodBeat.i(191738);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    paramContext.startService(localIntent);
    ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] startupMigrationService called.", new Object[0]);
    AppMethodBeat.o(191738);
  }
  
  private static void suicide()
  {
    AppMethodBeat.i(191757);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(191757);
  }
  
  public static void triggerMediaRescanOnDemand()
  {
    AppMethodBeat.i(191751);
    Application localApplication = d.fcb.getApplication();
    String str = d.cQP;
    if (!localApplication.getPackageName().equals(str))
    {
      AppMethodBeat.o(191751);
      return;
    }
    if (!b.htd())
    {
      AppMethodBeat.o(191751);
      return;
    }
    AndroidMediaUtil.refreshMediaScannerWithoutVFSRemapAsync(com.tencent.mm.loader.j.b.aSV(), localApplication);
    AndroidMediaUtil.refreshMediaScannerWithoutVFSRemapAsync(com.tencent.mm.loader.j.b.aSW(), localApplication);
    b.htf();
    AppMethodBeat.o(191751);
  }
  
  @Keep
  public static boolean triggerOnDemand(Application paramApplication)
  {
    AppMethodBeat.i(191721);
    b.ky(paramApplication);
    String str = d.cQP;
    if (isMigrateServiceProcess(str))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate Service Process, skip rest logic in appLike.", new Object[0]);
      LocaleUtil.initLanguage(paramApplication);
      MMApplicationContext.setResources(com.tencent.mm.cj.b.a(paramApplication.getResources(), paramApplication));
      AppMethodBeat.o(191721);
      return true;
    }
    if (!isMainProcess(str))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Not in main process, startup normally.", new Object[0]);
      AppMethodBeat.o(191721);
      return false;
    }
    if (b.hsY())
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Last migrate routine indicates that we should startup normally this time.", new Object[0]);
      b.hta();
      AppMethodBeat.o(191721);
      return false;
    }
    if (!isMigrateServiceRunning(paramApplication))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is not running, check if we have external storage permission next.", new Object[0]);
      boolean bool2 = com.tencent.mm.pluginsdk.permission.b.f(paramApplication, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      boolean bool1 = bool2;
      if (!bool2)
      {
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateRoutine", "[!] No WRITE_EXTERNAL_STORAGE permission, check READ_EXTERNAL_STORAGE permission next.", new Object[0]);
        bool1 = com.tencent.mm.pluginsdk.permission.b.f(paramApplication, new String[] { "android.permission.READ_EXTERNAL_STORAGE" });
      }
      bool2 = bool1;
      if (!bool1)
      {
        ExtStorageMigrateMonitor.hsJ().w("MicroMsg.ExtStorageMigrateRoutine", "[!] No READ_EXTERNAL_STORAGE permission, check if old sdcard path can read next.", new Object[0]);
        bool2 = new File(com.tencent.mm.loader.j.b.aSK()).canRead();
      }
      if (bool2)
      {
        ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] We have external storage permission, do not need to migrate.", new Object[0]);
        AppMethodBeat.o(191721);
        return false;
      }
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] We have no external storage permission, do further check next.", new Object[0]);
    }
    while (!isStartWithActivity(paramApplication))
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Start up without any activities, let it continue normally.", new Object[0]);
      AppMethodBeat.o(191721);
      return false;
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is running, check if we are doing migrating next.", new Object[0]);
    }
    if (isDeviceChangedUnexpectly())
    {
      ExtStorageMigrateMonitor.hsJ().i("MicroMsg.ExtStorageMigrateRoutine", "[+] External tools may move us into a new device or OTA happened, skip migrate this time.", new Object[0]);
      AppMethodBeat.o(191721);
      return false;
    }
    if (!needsToDoMigrate(paramApplication))
    {
      AppMethodBeat.o(191721);
      return false;
    }
    startMigrateQuestionnaire(paramApplication);
    ExtStorageMigrateMonitor.hsM();
    suicide();
    AppMethodBeat.o(191721);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine
 * JD-Core Version:    0.7.0.1
 */