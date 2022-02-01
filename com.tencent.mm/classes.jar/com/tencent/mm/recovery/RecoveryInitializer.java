package com.tencent.mm.recovery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.Keep;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cj.b;
import com.tencent.mm.model.cs;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.recoveryv2.b.c;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.entry.ApplicationLike;
import com.tinkerboots.sdk.a;
import com.tinkerboots.sdk.a.a;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"LongLogTag"})
@Keep
public class RecoveryInitializer
{
  private static final int RECOVERY_SETTING_DEBUG = 30000;
  private static final String TAG = "MicroMsg.recovery.initializer";
  
  @Keep
  public static boolean init(Context paramContext)
  {
    AppMethodBeat.i(202584);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(202584);
        return true;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.initializer", "check isStartWithActivity error", localThrowable1);
        boolean bool = false;
      }
      if (l.jX(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(202413);
            com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            com.tencent.mm.recoveryv2.g.jO(this.val$context);
            AppMethodBeat.o(202413);
          }
        });
        for (;;)
        {
          try
          {
            MMApplicationContext.setContext(paramContext);
          }
          catch (Throwable localThrowable3)
          {
            com.tencent.mm.kernel.b.h localh;
            com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable3);
            com.tencent.mm.recoveryv2.g.jO(paramContext);
            continue;
          }
          try
          {
            MMApplicationContext.setResources(b.a(paramContext.getResources(), paramContext, true));
            LocaleUtil.initLanguage(paramContext);
            localh = new com.tencent.mm.kernel.b.h(l.hqU(), com.tencent.mm.app.d.fcb.getApplication(), com.tencent.mm.app.d.fcb);
            localh.iQW = com.tencent.mm.booter.d.cc(localh.Zw);
            com.tencent.mm.kernel.h.a(localh);
            com.tencent.mm.vfs.h.setContext(paramContext);
            com.tencent.e.g.a(localh.Zw, new aa());
            PlatformComm.init(MMApplicationContext.getContext(), new MMHandler(Looper.getMainLooper()));
            cs.bfO();
            a.a(new a.a(com.tencent.mm.app.d.fcb).a(new b.1(paramContext)).izX());
            l.hqR().a("diagnostic_mmkv_reset", new a.1("diagnostic_storage"));
            l.hqR().a("jectl_mmkv_reset", new a.2("jectl_config"));
            AppMethodBeat.o(202584);
            return false;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.initializer", "init MMResources fail", localThrowable2);
          }
        }
      }
      if (!l.jW(paramContext))
      {
        AppMethodBeat.o(202584);
        return true;
      }
      i.jP(paramContext).hqt().arg();
      l.hqR().jV(paramContext).b(new b.c()
      {
        public final Class<? extends Activity> hpU()
        {
          return RecoveryUI.class;
        }
        
        public final Class<? extends Service> hpV()
        {
          return WXRecoveryUploadService.class;
        }
      }).b(1, new com.tencent.mm.recoveryv2.d()
      {
        public final void arF(int paramAnonymousInt)
        {
          AppMethodBeat.i(202248);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(202248);
        }
      }).b(2, new com.tencent.mm.recoveryv2.d()
      {
        public final void arF(int paramAnonymousInt)
        {
          AppMethodBeat.i(201867);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(201867);
        }
      }).OO();
      AppMethodBeat.o(202584);
    }
    return true;
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(202586);
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject1 != null)
    {
      localObject1 = ((ActivityManager)localObject1).getRunningTasks(2147483647);
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
              AppMethodBeat.o(202586);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(202586);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */