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
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Keep
public final class ExtStorageMigrateRoutine
{
  static final String AUXUI_ACTION_DO_MIGRATE_ROUTINE = "auxui_action_do_migrate_routine";
  static final String AUXUI_PARAM_IS_MIGRAION_END = "auxui_param_is_migration_end";
  static final ExtStorageMigrateConfig DEFAULT_CONFIG = ExtStorageMigrateConfig.Gns;
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
    AppMethodBeat.i(195839);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    boolean bool = paramContext.bindService(localIntent, paramServiceConnection, 0);
    AppMethodBeat.o(195839);
    return bool;
  }
  
  static void cancelMigration(Context paramContext)
  {
    AppMethodBeat.i(195841);
    if (isMigrateServiceRunning(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
      localIntent.setAction("service_action_cancel_migrate");
      paramContext.startService(localIntent);
    }
    AppMethodBeat.o(195841);
  }
  
  private static boolean isDeviceChangedUnexpectly()
  {
    AppMethodBeat.i(195833);
    aw localaw = aw.aKT("extstg_migrate_preconditions");
    String str = localaw.getString("last_fingerprint", "");
    if ((str == null) || (!str.equals(Build.FINGERPRINT)))
    {
      localaw.encode("last_fingerprint", Build.FINGERPRINT);
      AppMethodBeat.o(195833);
      return true;
    }
    AppMethodBeat.o(195833);
    return false;
  }
  
  private static boolean isMainProcess(String paramString)
  {
    AppMethodBeat.i(195843);
    if (paramString.indexOf(':') < 0)
    {
      AppMethodBeat.o(195843);
      return true;
    }
    AppMethodBeat.o(195843);
    return false;
  }
  
  private static boolean isMigrateServiceProcess(String paramString)
  {
    AppMethodBeat.i(195844);
    boolean bool = paramString.endsWith(":extmig");
    AppMethodBeat.o(195844);
    return bool;
  }
  
  private static boolean isMigrateServiceRunning(Context paramContext)
  {
    AppMethodBeat.i(195836);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
        if ((localRunningServiceInfo.uid == Process.myUid()) && (localRunningServiceInfo.service.getClassName().equals("com.tencent.mm.sdcard_migrate.ExtStorageMigrateService")))
        {
          AppMethodBeat.o(195836);
          return true;
        }
      }
    }
    AppMethodBeat.o(195836);
    return false;
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(195837);
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
            AppMethodBeat.o(195837);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(195837);
    return false;
  }
  
  static boolean needsToDoMigrate(Context paramContext)
  {
    AppMethodBeat.i(195832);
    if (!b.eTZ())
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Sync migrate switch is off, do not trigger questionnaire.", new Object[0]);
      ExtStorageMigrateMonitor.as(1315L, 101L);
      AppMethodBeat.o(195832);
      return false;
    }
    ExtStorageMigrateMonitor.as(1315L, 102L);
    if (b.aKl(DEFAULT_CONFIG.sourceDir))
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Already migrated, do not need to migrate", new Object[0]);
      AppMethodBeat.o(195832);
      return false;
    }
    if (!new File(DEFAULT_CONFIG.sourceDir).exists())
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Old external storage directory does not exist, do not need to migrate.", new Object[0]);
      AppMethodBeat.o(195832);
      return false;
    }
    if (isDeviceChangedUnexpectly())
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] External tools may move us into a new device or OTA happened, skip migrate this time.", new Object[0]);
      AppMethodBeat.o(195832);
      return false;
    }
    ExtStorageMigrateMonitor.as(1315L, 100L);
    AppMethodBeat.o(195832);
    return true;
  }
  
  private static void startMigrateQuestionnaire(Context paramContext)
  {
    AppMethodBeat.i(195834);
    Object localObject = new Intent(paramContext, ExtStorageMigrateAuxActivity.class);
    ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
    ((Intent)localObject).addFlags(268435456);
    localObject = PendingIntent.getActivity(paramContext, 3841, (Intent)localObject, 268435456);
    try
    {
      ((PendingIntent)localObject).send();
      AppMethodBeat.o(195834);
      return;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startMigrateQuestionnaire failed, just do normal startup next.", new Object[0]);
      startWeChat(paramContext);
      AppMethodBeat.o(195834);
    }
  }
  
  static void startMigration(Context paramContext, final ExtStorageMigrateConfig paramExtStorageMigrateConfig, MigrateResultCallback paramMigrateResultCallback)
  {
    AppMethodBeat.i(195840);
    startupMigrationService(paramContext);
    bindMigrationService(paramContext, new ServiceConnection()
    {
      private IBinder GnG;
      private IBinder.DeathRecipient GnH;
      
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(195829);
        this.GnG = paramAnonymousIBinder;
        paramAnonymousComponentName = e.a.M(paramAnonymousIBinder);
        try
        {
          paramAnonymousIBinder.linkToDeath(this.GnH, 0);
        }
        catch (RemoteException paramAnonymousIBinder)
        {
          for (;;)
          {
            try
            {
              paramAnonymousComponentName.a(this.GnI);
              paramAnonymousComponentName.a(paramExtStorageMigrateConfig);
              AppMethodBeat.o(195829);
              return;
            }
            catch (RemoteException paramAnonymousComponentName)
            {
              ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousComponentName, "[-] Exception occurred.", new Object[0]);
              try
              {
                this.GnI.b(5, new ExtStorageMigrateException(paramAnonymousComponentName));
                AppMethodBeat.o(195829);
                return;
              }
              catch (RemoteException paramAnonymousComponentName)
              {
                AppMethodBeat.o(195829);
              }
            }
            paramAnonymousIBinder = paramAnonymousIBinder;
            ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", paramAnonymousIBinder, "[-] Exception occurred.", new Object[0]);
            try
            {
              this.GnI.b(6, null);
            }
            catch (RemoteException paramAnonymousIBinder) {}
          }
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(195830);
        ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateRoutine", "[!] Service [%s] disconnected.", new Object[] { paramAnonymousComponentName });
        AppMethodBeat.o(195830);
      }
    });
    AppMethodBeat.o(195840);
  }
  
  @SuppressLint({"NewApi"})
  static void startWeChat(Context paramContext)
  {
    AppMethodBeat.i(195835);
    b.eTS();
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
        AppMethodBeat.o(195835);
        return;
      }
      catch (Throwable localThrowable)
      {
        ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateRoutine", localThrowable, "[-] startWeChat failed, retry with normal way.", new Object[0]);
        if (!(paramContext instanceof Activity)) {
          break label152;
        }
        ((Intent)localObject1).removeFlags(268435456);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateRoutine", "startWeChat", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(195835);
      }
      paramContext = paramContext;
      paramContext = new IllegalStateException("Should not be here.");
      AppMethodBeat.o(195835);
      throw paramContext;
    }
  }
  
  static void startupMigrationService(Context paramContext)
  {
    AppMethodBeat.i(195838);
    Intent localIntent = new Intent("service_action_startup");
    localIntent.setClassName(paramContext, "com.tencent.mm.sdcard_migrate.ExtStorageMigrateService");
    paramContext.startService(localIntent);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] startupMigrationService called.", new Object[0]);
    AppMethodBeat.o(195838);
  }
  
  private static void suicide()
  {
    AppMethodBeat.i(195845);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(195845);
  }
  
  public static void triggerMediaRescanOnDemand()
  {
    AppMethodBeat.i(195842);
    Application localApplication = d.cIg.getApplication();
    String str = d.csT;
    if (!localApplication.getPackageName().equals(str))
    {
      AppMethodBeat.o(195842);
      return;
    }
    if (!b.eTW())
    {
      AppMethodBeat.o(195842);
      return;
    }
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.apq(), localApplication);
    com.tencent.mm.sdk.f.b.o(com.tencent.mm.loader.j.b.apr(), localApplication);
    b.eTY();
    AppMethodBeat.o(195842);
  }
  
  @Keep
  static boolean triggerOnDemand(Context paramContext)
  {
    AppMethodBeat.i(195831);
    String str = d.csT;
    if (isMigrateServiceProcess(str))
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate Service Process, skip rest logic in appLike.", new Object[0]);
      AppMethodBeat.o(195831);
      return true;
    }
    if (!isMainProcess(str))
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Not in main process, startup normally.", new Object[0]);
      AppMethodBeat.o(195831);
      return false;
    }
    if (b.eTR())
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Last migrate routine indicates that we should startup normally this time.", new Object[0]);
      b.eTT();
      AppMethodBeat.o(195831);
      return false;
    }
    if (!isMigrateServiceRunning(paramContext))
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is not running, check if we have external storage permission next.", new Object[0]);
      if (com.tencent.mm.pluginsdk.permission.b.e(paramContext, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }))
      {
        ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] We have external storage permission, do not need to migrate.", new Object[0]);
        AppMethodBeat.o(195831);
        return false;
      }
    }
    else
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Migrate service is running, check if we are doing migrating next.", new Object[0]);
    }
    if (!isStartWithActivity(paramContext))
    {
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateRoutine", "[+] Start up without any activities, let it continue normally.", new Object[0]);
      AppMethodBeat.o(195831);
      return false;
    }
    if (!needsToDoMigrate(paramContext))
    {
      AppMethodBeat.o(195831);
      return false;
    }
    startMigrateQuestionnaire(paramContext);
    ExtStorageMigrateMonitor.eTF();
    suicide();
    AppMethodBeat.o(195831);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine
 * JD-Core Version:    0.7.0.1
 */