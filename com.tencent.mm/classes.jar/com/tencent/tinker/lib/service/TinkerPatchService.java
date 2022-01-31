package com.tencent.tinker.lib.service;

import android.app.Service;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TinkerPatchService
{
  private static int djM;
  private static Handler mHandler = new Handler(Looper.getMainLooper());
  private static com.tencent.tinker.lib.c.a wWc = null;
  private static Class<? extends AbstractResultService> wWd;
  private static AtomicBoolean wWe = new AtomicBoolean(false);
  
  static
  {
    djM = -1119860829;
    wWd = null;
  }
  
  public static void a(com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass)
  {
    wWc = parama;
    wWd = paramClass;
    try
    {
      Class.forName(paramClass.getName());
      return;
    }
    catch (ClassNotFoundException parama) {}
  }
  
  public static String ax(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return ShareIntentUtil.j(paramIntent, "patch_path_extra");
  }
  
  public static void bO(Context paramContext, String paramString)
  {
    for (;;)
    {
      JobInfo.Builder localBuilder;
      Object localObject;
      try
      {
        if (Build.VERSION.SDK_INT < 26)
        {
          bP(paramContext, paramString);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "start patch service fail, exception:" + paramContext, new Object[0]);
        return;
      }
      try
      {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "run patch service by job scheduler.", new Object[0]);
        localBuilder = new JobInfo.Builder(1, new ComponentName(paramContext, TinkerPatchService.JobServiceRunner.class));
        localObject = new PersistableBundle();
        ((PersistableBundle)localObject).putString("patch_path_extra", paramString);
        ((PersistableBundle)localObject).putString("patch_result_class", wWd.getName());
        localBuilder.setExtras((PersistableBundle)localObject);
        localBuilder.setOverrideDeadline(5L);
        localObject = (JobScheduler)paramContext.getSystemService("jobscheduler");
        if (localObject != null) {
          break label164;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "jobScheduler is null.", new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        label164:
        continue;
      }
      mHandler.postDelayed(new TinkerPatchService.1(paramContext, paramString), TimeUnit.SECONDS.toMillis(5L));
      return;
      ((JobScheduler)localObject).schedule(localBuilder.build());
    }
  }
  
  private static void bP(Context paramContext, String paramString)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "run patch service by intent service.", new Object[0]);
    Intent localIntent = new Intent(paramContext, TinkerPatchService.IntentServiceRunner.class);
    localIntent.putExtra("patch_path_extra", paramString);
    localIntent.putExtra("patch_result_class", wWd.getName());
    paramContext.startService(localIntent);
  }
  
  public static Class<? extends Service> cQH()
  {
    if (Build.VERSION.SDK_INT < 26) {
      return TinkerPatchService.IntentServiceRunner.class;
    }
    return TinkerPatchService.JobServiceRunner.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */