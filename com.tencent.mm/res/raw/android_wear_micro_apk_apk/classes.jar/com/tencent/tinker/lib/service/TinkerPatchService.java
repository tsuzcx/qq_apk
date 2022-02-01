package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.e;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService
  extends IntentService
{
  private static int agB = -1119860829;
  private static com.tencent.tinker.lib.b.a ano = null;
  private static Class<? extends AbstractResultService> anp = null;
  private static AtomicBoolean anq = new AtomicBoolean(false);
  
  public TinkerPatchService()
  {
    super("TinkerPatchService");
  }
  
  public static String j(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return e.b(paramIntent, "patch_path_extra");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      com.tencent.tinker.lib.e.a.c("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    while (!anq.compareAndSet(false, true))
    {
      com.tencent.tinker.lib.e.a.b("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
      return;
      if ("ZUK".equals(Build.MANUFACTURER))
      {
        com.tencent.tinker.lib.e.a.c("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
      }
      else
      {
        com.tencent.tinker.lib.e.a.c("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try
        {
          Notification localNotification = new Notification();
          if (Build.VERSION.SDK_INT >= 18) {
            break label131;
          }
          startForeground(agB, localNotification);
        }
        catch (Throwable localThrowable1)
        {
          com.tencent.tinker.lib.e.a.c("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(localThrowable1)), new Object[0]);
        }
        continue;
        label131:
        startForeground(agB, localThrowable1);
        startService(new Intent(this, TinkerPatchService.InnerService.class));
      }
    }
    com.tencent.tinker.lib.d.a locala = com.tencent.tinker.lib.d.a.E(this);
    locala.oN().i(paramIntent);
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
      return;
    }
    String str = j(paramIntent);
    if (str == null)
    {
      com.tencent.tinker.lib.e.a.a("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
      return;
    }
    File localFile = new File(str);
    long l = SystemClock.elapsedRealtime();
    Object localObject = null;
    a locala1 = new a();
    try
    {
      if (ano == null) {
        throw new TinkerRuntimeException("upgradePatchProcessor is null.");
      }
    }
    catch (Throwable localThrowable2)
    {
      locala.oN().a(localFile, localThrowable2);
      for (boolean bool = false;; bool = ano.oK())
      {
        l = SystemClock.elapsedRealtime() - l;
        locala.oN().a(localFile, bool, l);
        locala1.anl = bool;
        locala1.anm = str;
        locala1.aaN = l;
        locala1.amz = localThrowable2;
        if (paramIntent != null) {
          break;
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
      }
      AbstractResultService.a(this, locala1, e.b(paramIntent, "patch_result_class"));
      anq.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */