package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService
  extends IntentService
{
  private static com.tencent.tinker.lib.c.a MDM = null;
  private static Class<? extends AbstractResultService> MDN = null;
  private static AtomicBoolean MDO = new AtomicBoolean(false);
  private static int notificationId = -1119860829;
  
  public TinkerPatchService()
  {
    super("TinkerPatchService");
  }
  
  public static void a(com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass)
  {
    MDM = parama;
    MDN = paramClass;
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
  
  public static String bA(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return ShareIntentUtil.getStringExtra(paramIntent, "patch_path_extra");
  }
  
  public static void cD(Context paramContext, String paramString)
  {
    ShareTinkerLog.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
    Intent localIntent = new Intent(paramContext, TinkerPatchService.class);
    localIntent.putExtra("patch_path_extra", paramString);
    localIntent.putExtra("patch_result_class", MDN.getName());
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      ShareTinkerLog.e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      ShareTinkerLog.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    while (!MDO.compareAndSet(false, true))
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
            break label131;
          }
          startForeground(notificationId, localNotification);
        }
        catch (Throwable localThrowable1)
        {
          ShareTinkerLog.i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(localThrowable1)), new Object[0]);
        }
        continue;
        label131:
        startForeground(notificationId, localThrowable1);
        startService(new Intent(this, InnerService.class));
      }
    }
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lq(this);
    locala.MDT.ax(paramIntent);
    if (paramIntent == null)
    {
      ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
      return;
    }
    String str = bA(paramIntent);
    if (str == null)
    {
      ShareTinkerLog.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
      return;
    }
    File localFile = new File(str);
    long l = SystemClock.elapsedRealtime();
    Object localObject = null;
    a locala1 = new a();
    try
    {
      if (MDM == null) {
        throw new TinkerRuntimeException("upgradePatchProcessor is null.");
      }
    }
    catch (Throwable localThrowable2)
    {
      locala.MDT.a(localFile, localThrowable2);
      for (boolean bool = false;; bool = MDM.a(this, str, locala1))
      {
        l = SystemClock.elapsedRealtime() - l;
        locala.MDT.a(localFile, bool, l);
        locala1.drc = bool;
        locala1.MDH = str;
        locala1.mxN = l;
        locala1.e = localThrowable2;
        if (paramIntent != null) {
          break;
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
      }
      AbstractResultService.a(this, locala1, ShareIntentUtil.getStringExtra(paramIntent, "patch_result_class"));
      MDO.set(false);
    }
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
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ShareTinkerLog.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[] { localThrowable });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */