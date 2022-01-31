package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class TinkerPatchService
  extends IntentService
{
  private static com.tencent.tinker.lib.c.a BsH = null;
  private static Class<? extends AbstractResultService> BsI = null;
  private static AtomicBoolean BsJ = new AtomicBoolean(false);
  private static int ebg = -1119860829;
  
  public TinkerPatchService()
  {
    super("TinkerPatchService");
  }
  
  public static void a(com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass)
  {
    BsH = parama;
    BsI = paramClass;
    try
    {
      Class.forName(paramClass.getName());
      return;
    }
    catch (ClassNotFoundException parama)
    {
      com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.TinkerPatchService", parama, "patch processor class not found.", new Object[0]);
    }
  }
  
  public static String aZ(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }
    return ShareIntentUtil.n(paramIntent, "patch_path_extra");
  }
  
  public static void cd(Context paramContext, String paramString)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "run patch service...", new Object[0]);
    Intent localIntent = new Intent(paramContext, TinkerPatchService.class);
    localIntent.putExtra("patch_path_extra", paramString);
    localIntent.putExtra("patch_result_class", BsI.getName());
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "run patch service fail, exception:".concat(String.valueOf(paramContext)), new Object[0]);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
    }
    while (!BsJ.compareAndSet(false, true))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchService", "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
      return;
      if ("ZUK".equals(Build.MANUFACTURER))
      {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
      }
      else
      {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
        try
        {
          Notification localNotification = new Notification();
          if (Build.VERSION.SDK_INT >= 18) {
            break label131;
          }
          startForeground(ebg, localNotification);
        }
        catch (Throwable localThrowable1)
        {
          com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:".concat(String.valueOf(localThrowable1)), new Object[0]);
        }
        continue;
        label131:
        startForeground(ebg, localThrowable1);
        startService(new Intent(this, TinkerPatchService.InnerService.class));
      }
    }
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.jo(this);
    locala.BsP.ac(paramIntent);
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[0]);
      return;
    }
    String str = aZ(paramIntent);
    if (str == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
      return;
    }
    File localFile = new File(str);
    long l = SystemClock.elapsedRealtime();
    Object localObject = null;
    a locala1 = new a();
    try
    {
      if (BsH == null) {
        throw new TinkerRuntimeException("upgradePatchProcessor is null.");
      }
    }
    catch (Throwable localThrowable2)
    {
      locala.BsP.a(localFile, localThrowable2);
      for (boolean bool = false;; bool = BsH.a(this, str, locala1))
      {
        l = SystemClock.elapsedRealtime() - l;
        locala.BsP.a(localFile, bool, l);
        locala1.csk = bool;
        locala1.BsF = str;
        locala1.iHc = l;
        locala1.Biq = localThrowable2;
        if (paramIntent != null) {
          break;
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
      }
      AbstractResultService.a(this, locala1, ShareIntentUtil.n(paramIntent, "patch_result_class"));
      BsJ.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService
 * JD-Core Version:    0.7.0.1
 */