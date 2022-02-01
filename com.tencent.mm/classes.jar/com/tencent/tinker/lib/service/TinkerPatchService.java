package com.tencent.tinker.lib.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService
  extends IntentService
{
  private static com.tencent.tinker.lib.c.a ahRB = null;
  private static Class<? extends AbstractResultService> ahRC = null;
  private static AtomicBoolean ahRD = new AtomicBoolean(false);
  private static int notificationId = -1119860829;
  
  public TinkerPatchService()
  {
    super("TinkerPatchService");
    setIntentRedelivery(true);
  }
  
  public static void a(com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass)
  {
    ahRB = parama;
    ahRC = paramClass;
    try
    {
      Class.forName(paramClass.getName());
      return;
    }
    catch (ClassNotFoundException parama)
    {
      ShareTinkerLog.printErrStackTrace("Tinker.TinkerPatchService", parama, "patch processor class not found.", new Object[0]);
    }
  }
  
  public static String ct(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return ShareIntentUtil.getStringExtra(paramIntent, "patch_path_extra");
  }
  
  public static void dr(Context paramContext, String paramString)
  {
    ShareTinkerLog.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
    Intent localIntent = new Intent(paramContext, TinkerPatchService.class);
    localIntent.putExtra("patch_path_extra", paramString);
    localIntent.putExtra("patch_result_class", ahRC.getName());
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
  }
  
  public static boolean ov(Context paramContext)
  {
    int i;
    label140:
    do
    {
      try
      {
        String str = c.oB(paramContext);
        if (str == null) {
          return false;
        }
        Object localObject = (ActivityManager)paramContext.getSystemService("activity");
        if (localObject == null) {
          return false;
        }
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          break label140;
        }
        localObject = ((List)localObject).iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        } while (!localRunningAppProcessInfo.processName.equals(str));
        i = localRunningAppProcessInfo.pid;
      }
      finally
      {
        boolean bool;
        return false;
      }
      bool = new File(SharePatchFileUtil.getPatchDirectory(paramContext), "patch_service_status/running_".concat(String.valueOf(i))).exists();
      return bool;
      i = 0;
      continue;
      return false;
    } while (i != 0);
    return false;
  }
  
  private static void ow(Context paramContext)
  {
    paramContext = new File(SharePatchFileUtil.getPatchDirectory(paramContext), "patch_service_status/running_" + Process.myPid());
    if (paramContext.exists()) {}
    for (;;)
    {
      return;
      Object localObject = paramContext.getParentFile();
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      else
      {
        ((File)localObject).mkdirs();
      }
      try
      {
        if (!paramContext.createNewFile()) {
          throw new IllegalStateException();
        }
      }
      finally {}
    }
  }
  
  private static void ox(Context paramContext)
  {
    paramContext = new File(SharePatchFileUtil.getPatchDirectory(paramContext), "patch_service_status/running_" + Process.myPid());
    if (paramContext.exists()) {
      paramContext.delete();
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    boolean bool1 = false;
    if (Build.VERSION.SDK_INT >= 26) {
      ShareTinkerLog.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    while (!ahRD.compareAndSet(false, true))
    {
      ShareTinkerLog.w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
      return;
      if ("ZUK".equals(Build.MANUFACTURER))
      {
        ShareTinkerLog.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
      }
      else
      {
        ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try
        {
          Notification localNotification = new Notification();
          if (Build.VERSION.SDK_INT >= 18) {
            break label137;
          }
          startForeground(notificationId, localNotification);
          continue;
        }
        finally
        {
          ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(localObject1)), new Object[0]);
        }
        continue;
        label137:
        startForeground(notificationId, localObject1);
        startService(new Intent(this, InnerService.class));
      }
    }
    a locala1;
    for (;;)
    {
      String str;
      try
      {
        ow(this);
        com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.oy(this);
        locala.ahRI.aW(paramIntent);
        if (paramIntent == null)
        {
          ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
          return;
        }
        str = ct(paramIntent);
        if (str == null)
        {
          ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
          return;
        }
        File localFile = new File(str);
        long l = SystemClock.elapsedRealtime();
        Object localObject2 = null;
        locala1 = new a();
        try
        {
          if (ahRB != null) {
            break label378;
          }
          throw new TinkerRuntimeException("upgradePatchProcessor is null.");
        }
        finally
        {
          locala.ahRI.a(localFile, localThrowable);
          l = SystemClock.elapsedRealtime() - l;
          locala.ahRI.a(localFile, bool1, l);
          locala1.isSuccess = bool1;
          locala1.ahRw = str;
          locala1.costTime = l;
          locala1.e = localThrowable;
          ox(this);
          ahRD.set(false);
          if (paramIntent != null) {
            break;
          }
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
      }
      finally
      {
        ox(this);
      }
      label378:
      boolean bool2 = ahRB.a(this, str, locala1);
      bool1 = bool2;
    }
    AbstractResultService.a(this, locala1, ShareIntentUtil.getStringExtra(paramIntent, "patch_result_class"));
    ox(this);
  }
  
  public static class InnerService
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      try
      {
        startForeground(TinkerPatchService.notificationId, new Notification());
        stopSelf();
        return;
      }
      finally
      {
        for (;;)
        {
          ShareTinkerLog.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[] { localObject });
        }
      }
    }
    
    public void onDestroy()
    {
      stopForeground(true);
      super.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */