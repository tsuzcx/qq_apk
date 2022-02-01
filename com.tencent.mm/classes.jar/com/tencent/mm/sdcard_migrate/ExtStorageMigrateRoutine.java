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
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Keep
public final class ExtStorageMigrateRoutine
{
  static final String AUXUI_ACTION_DO_MIGRATE_ROUTINE = "auxui_action_do_migrate_routine";
  static final String AUXUI_PARAM_IS_MIGRAION_END = "auxui_param_is_migration_end";
  static final ExtStorageMigrateConfig DEFAULT_CONFIG = ExtStorageMigrateConfig.HZf;
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
    AppMethodBeat.i(211074);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    boolean bool = paramContext.bindService(localIntent, paramServiceConnection, 0);
    AppMethodBeat.o(211074);
    return bool;
  }
  
  static void cancelMigration(Context paramContext)
  {
    AppMethodBeat.i(211076);
    if (isMigrateServiceRunning(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
      localIntent.setAction("service_action_cancel_migrate");
      paramContext.startService(localIntent);
    }
    AppMethodBeat.o(211076);
  }
  
  private static boolean isDeviceChangedUnexpectly()
  {
    AppMethodBeat.i(211068);
    ax localax = ax.aQz("extstg_migrate_preconditions");
    ??? = localax.getString("last_fingerprint", "");
    if ((??? == null) || (!((String)???).equals(Build.FINGERPRINT))) {
      synchronized (IS_ACCOUNT_INIT_CALLBACK_ADDED)
      {
        if (IS_ACCOUNT_INIT_CALLBACK_ADDED[0] == 0)
        {
          com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
          IS_ACCOUNT_INIT_CALLBACK_ADDED[0] = true;
        }
        AppMethodBeat.o(211068);
        return true;
      }
    }
    AppMethodBeat.o(211068);
    return false;
  }
  
  private static boolean isMainProcess(String paramString)
  {
    AppMethodBeat.i(211078);
    if (paramString.indexOf(':') < 0)
    {
      AppMethodBeat.o(211078);
      return true;
    }
    AppMethodBeat.o(211078);
    return false;
  }
  
  private static boolean isMigrateServiceProcess(String paramString)
  {
    AppMethodBeat.i(211079);
    boolean bool = paramString.endsWith(":extmig");
    AppMethodBeat.o(211079);
    return bool;
  }
  
  private static boolean isMigrateServiceRunning(Context paramContext)
  {
    AppMethodBeat.i(211071);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
        if ((localRunningServiceInfo.uid == Process.myUid()) && (localRunningServiceInfo.service.getClassName().equals("com.tencent.mm.sdcard_migrate.ExtStorageMigrateService")))
        {
          AppMethodBeat.o(211071);
          return true;
        }
      }
    }
    AppMethodBeat.o(211071);
    return false;
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(211072);
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
            AppMethodBeat.o(211072);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(211072);
    return false;
  }
  
  static boolean needsToDoMigrate(Context paramContext)
  {
    AppMethodBeat.i(211067);
    b.fjC();
    ExtStorageMigrateMonitor.CQ(102L);
    if (b.fjt())
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Newly installed, existed old data is ignored, do not need to migrate.", new Object[0]);
      ExtStorageMigrateMonitor.CQ(190L);
      AppMethodBeat.o(211067);
      return false;
    }
    if (b.aPQ(DEFAULT_CONFIG.sourceDir))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Already migrated, do not need to migrate", new Object[0]);
      AppMethodBeat.o(211067);
      return false;
    }
    if (!new File(DEFAULT_CONFIG.sourceDir).exists())
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Old external storage directory does not exist, do not need to migrate.", new Object[0]);
      AppMethodBeat.o(211067);
      return false;
    }
    ExtStorageMigrateMonitor.CQ(100L);
    AppMethodBeat.o(211067);
    return true;
  }
  
  private static void startMigrateQuestionnaire(Context paramContext)
  {
    AppMethodBeat.i(211069);
    Object localObject = new Intent(paramContext, ExtStorageMigrateAuxActivity.class);
    ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
    ((Intent)localObject).addFlags(268435456);
    localObject = PendingIntent.getActivity(paramContext, 3841, (Intent)localObject, 268435456);
    try
    {
      ((PendingIntent)localObject).send();
      AppMethodBeat.o(211069);
      return;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startMigrateQuestionnaire failed, just do normal startup next.", new Object[0]);
      startWeChat(paramContext);
      AppMethodBeat.o(211069);
    }
  }
  
  static void startMigration(Context paramContext, final ExtStorageMigrateConfig paramExtStorageMigrateConfig, MigrateResultCallback paramMigrateResultCallback)
  {
    AppMethodBeat.i(211075);
    startupMigrationService(paramContext);
    bindMigrationService(paramContext, new ServiceConnection()
    {
      private IBinder HZt;
      private IBinder.DeathRecipient HZu;
      
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(211064);
        this.HZt = paramAnonymousIBinder;
        paramAnonymousComponentName = e.a.M(paramAnonymousIBinder);
        try
        {
          paramAnonymousIBinder.linkToDeath(this.HZu, 0);
        }
        catch (RemoteException paramAnonymousIBinder)
        {
          for (;;)
          {
            try
            {
              paramAnonymousComponentName.a(this.HZv);
              paramAnonymousComponentName.a(paramExtStorageMigrateConfig);
              AppMethodBeat.o(211064);
              return;
            }
            catch (RemoteException paramAnonymousComponentName)
            {
              ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousComponentName, "[-] Exception occurred.", new Object[0]);
              try
              {
                this.HZv.b(5, new ExtStorageMigrateException(paramAnonymousComponentName));
                AppMethodBeat.o(211064);
                return;
              }
              catch (RemoteException paramAnonymousComponentName)
              {
                AppMethodBeat.o(211064);
              }
            }
            paramAnonymousIBinder = paramAnonymousIBinder;
            ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousIBinder, "[-] Exception occurred.", new Object[0]);
            try
            {
              this.HZv.b(6, null);
            }
            catch (RemoteException paramAnonymousIBinder) {}
          }
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(211065);
        ExtStorageMigrateMonitor.fjf().w("MicroMsg.ExtStorageMigrateRoutine", "[!] Service [%s] disconnected.", new Object[] { paramAnonymousComponentName });
        AppMethodBeat.o(211065);
      }
    });
    AppMethodBeat.o(211075);
  }
  
  @SuppressLint({"NewApi"})
  static void startWeChat(Context paramContext)
  {
    AppMethodBeat.i(211070);
    b.fjv();
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
        AppMethodBeat.o(211070);
        return;
      }
      catch (Throwable localThrowable)
      {
        ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startWeChat failed, retry with normal way.", new Object[0]);
        if (!(paramContext instanceof Activity)) {
          break label152;
        }
        ((Intent)localObject1).removeFlags(268435456);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(211070);
      }
      paramContext = paramContext;
      paramContext = new IllegalStateException("Should not be here.");
      AppMethodBeat.o(211070);
      throw paramContext;
    }
  }
  
  static void startupMigrationService(Context paramContext)
  {
    AppMethodBeat.i(211073);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    paramContext.startService(localIntent);
    ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] startupMigrationService called.", new Object[0]);
    AppMethodBeat.o(211073);
  }
  
  private static void suicide()
  {
    AppMethodBeat.i(211080);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(211080);
  }
  
  public static void triggerMediaRescanOnDemand()
  {
    AppMethodBeat.i(211077);
    Application localApplication = d.cTo.getApplication();
    String str = d.cDP;
    if (!localApplication.getPackageName().equals(str))
    {
      AppMethodBeat.o(211077);
      return;
    }
    if (!b.fjz())
    {
      AppMethodBeat.o(211077);
      return;
    }
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.ase(), localApplication);
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.asf(), localApplication);
    b.fjB();
    AppMethodBeat.o(211077);
  }
  
  @Keep
  static boolean triggerOnDemand(Application paramApplication)
  {
    AppMethodBeat.i(211066);
    b.iv(paramApplication);
    String str = d.cDP;
    if (isMigrateServiceProcess(str))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate Service Process, skip rest logic in appLike.", new Object[0]);
      ac.initLanguage(paramApplication);
      aj.h(com.tencent.mm.cd.b.a(paramApplication.getResources(), paramApplication));
      AppMethodBeat.o(211066);
      return true;
    }
    if (!isMainProcess(str))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Not in main process, startup normally.", new Object[0]);
      AppMethodBeat.o(211066);
      return false;
    }
    if (b.fju())
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Last migrate routine indicates that we should startup normally this time.", new Object[0]);
      b.fjw();
      AppMethodBeat.o(211066);
      return false;
    }
    if (!isMigrateServiceRunning(paramApplication))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is not running, check if we have external storage permission next.", new Object[0]);
      if (com.tencent.mm.pluginsdk.permission.b.e(paramApplication, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }))
      {
        ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] We have external storage permission, do not need to migrate.", new Object[0]);
        AppMethodBeat.o(211066);
        return false;
      }
    }
    else
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is running, check if we are doing migrating next.", new Object[0]);
    }
    if (!isStartWithActivity(paramApplication))
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Start up without any activities, let it continue normally.", new Object[0]);
      AppMethodBeat.o(211066);
      return false;
    }
    if (isDeviceChangedUnexpectly())
    {
      ExtStorageMigrateMonitor.fjf().i("MicroMsg.ExtStorageMigrateRoutine", "[+] External tools may move us into a new device or OTA happened, skip migrate this time.", new Object[0]);
      AppMethodBeat.o(211066);
      return false;
    }
    if (!needsToDoMigrate(paramApplication))
    {
      AppMethodBeat.o(211066);
      return false;
    }
    startMigrateQuestionnaire(paramApplication);
    ExtStorageMigrateMonitor.fji();
    suicide();
    AppMethodBeat.o(211066);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine
 * JD-Core Version:    0.7.0.1
 */