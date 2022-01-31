package com.tencent.tinker.lib.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.e;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TinkerPatchService
{
  private static int ada;
  private static a ajN = null;
  private static Class<? extends AbstractResultService> ajO;
  private static AtomicBoolean ajP = new AtomicBoolean(false);
  private static Handler mHandler;
  
  static
  {
    ada = -1119860829;
    ajO = null;
    mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String h(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return e.a(paramIntent, "patch_path_extra");
  }
  
  public static Class<? extends Service> nX()
  {
    if (Build.VERSION.SDK_INT < 26) {
      return TinkerPatchService.IntentServiceRunner.class;
    }
    return TinkerPatchService.JobServiceRunner.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */