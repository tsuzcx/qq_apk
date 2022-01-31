package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.lib.f.a;

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
      a.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    for (;;)
    {
      TinkerPatchService.E(getApplicationContext(), paramIntent);
      return;
      if ("ZUK".equals(Build.MANUFACTURER))
      {
        a.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
      }
      else
      {
        a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try
        {
          Notification localNotification = new Notification();
          if (Build.VERSION.SDK_INT >= 18) {
            break label120;
          }
          startForeground(TinkerPatchService.access$200(), localNotification);
        }
        catch (Throwable localThrowable)
        {
          a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:" + localThrowable, new Object[0]);
        }
        continue;
        label120:
        startForeground(TinkerPatchService.access$200(), localThrowable);
        startService(new Intent(this, TinkerPatchService.IntentServiceRunner.InnerService.class));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.IntentServiceRunner
 * JD-Core Version:    0.7.0.1
 */