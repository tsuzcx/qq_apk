package com.tencent.tinker.lib.service;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.b;

final class TinkerPatchService$1
  implements Runnable
{
  TinkerPatchService$1(Context paramContext, String paramString) {}
  
  public final void run()
  {
    a.i("Tinker.TinkerPatchService", "check if patch service is running.", new Object[0]);
    if (!b.hP(this.val$context)) {
      a.w("Tinker.TinkerPatchService", "patch service is not running, retry with IntentService.", new Object[0]);
    }
    try
    {
      TinkerPatchService.bQ(this.val$context, this.dlh);
      a.i("Tinker.TinkerPatchService", "successfully start patch service with IntentService.", new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      a.e("Tinker.TinkerPatchService", "failure to start patch service with IntentService. osver: %s, manu: %s, msg: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, localThrowable.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.1
 * JD-Core Version:    0.7.0.1
 */