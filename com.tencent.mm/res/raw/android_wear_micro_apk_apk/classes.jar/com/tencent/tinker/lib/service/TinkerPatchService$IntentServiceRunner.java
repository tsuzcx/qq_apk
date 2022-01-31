package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.lib.e.a;

public class TinkerPatchService$IntentServiceRunner
  extends IntentService
{
  public TinkerPatchService$IntentServiceRunner()
  {
    super("TinkerPatchService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      a.c("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    for (;;)
    {
      TinkerPatchService.a(getApplicationContext(), paramIntent);
      return;
      if ("ZUK".equals(Build.MANUFACTURER))
      {
        a.c("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
      }
      else
      {
        a.c("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try
        {
          Notification localNotification = new Notification();
          if (Build.VERSION.SDK_INT >= 18) {
            break label120;
          }
          startForeground(TinkerPatchService.ng(), localNotification);
        }
        catch (Throwable localThrowable)
        {
          a.c("Tinker.TinkerPatchService", "try to increase patch process priority error:" + localThrowable, new Object[0]);
        }
        continue;
        label120:
        startForeground(TinkerPatchService.ng(), localThrowable);
        startService(new Intent(this, TinkerPatchService.IntentServiceRunner.InnerService.class));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.IntentServiceRunner
 * JD-Core Version:    0.7.0.1
 */