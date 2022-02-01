package com.tencent.mm.recovery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.recoveryv2.a.a;
import com.tencent.mm.recoveryv2.b.c;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.a;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.entry.ApplicationLike;
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
    AppMethodBeat.i(192820);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        f.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(192820);
        return true;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        f.w("MicroMsg.recovery.initializer", "check isStartWithActivity error", localThrowable1);
        boolean bool = false;
      }
      if (k.hU(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(192817);
            f.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            f.hM(this.val$context);
            AppMethodBeat.o(192817);
          }
        });
        try
        {
          aj.setContext(paramContext);
          h localh = new h(k.fhw(), com.tencent.mm.app.d.cTo.getApplication(), com.tencent.mm.app.d.cTo);
          localh.fFy = com.tencent.mm.booter.d.bJ(localh.ca);
          localh.fFy.uc("RECOVERY");
          com.tencent.mm.kernel.g.a(localh);
          a.setContext(paramContext);
          com.tencent.e.g.a(localh.ca, new aa());
          PlatformComm.init(aj.getContext(), new ap(Looper.getMainLooper()));
          b.hI(paramContext);
          k.fhu().a("diagnostic_mmkv_reset", new a.1("diagnostic_storage"));
          k.fhu().a("jectl_mmkv_reset", new a.2("jectl_config"));
          AppMethodBeat.o(192820);
          return false;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            f.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable2);
            f.hM(paramContext);
          }
        }
      }
      if (!k.hT(paramContext))
      {
        AppMethodBeat.o(192820);
        return true;
      }
      k localk = k.fhu();
      if (paramContext != null) {
        localk.mContext = paramContext;
      }
      paramContext = new b.c()
      {
        public final Class<? extends Activity> fgS()
        {
          return RecoveryUI.class;
        }
        
        public final Class<? extends Service> fgT()
        {
          return WXRecoveryUploadService.class;
        }
      };
      if (localk.HUN == null) {
        localk.fhv();
      }
      localk.HUN.a(paramContext);
      paramContext = localk.b(1, new com.tencent.mm.recoveryv2.d()
      {
        public final void ZV(int paramAnonymousInt)
        {
          AppMethodBeat.i(192819);
          ad.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(192819);
        }
      }).b(2, new com.tencent.mm.recoveryv2.d()
      {
        public final void ZV(int paramAnonymousInt)
        {
          AppMethodBeat.i(192818);
          ad.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(192818);
        }
      });
      if (k.hT(paramContext.getContext())) {
        break label309;
      }
    }
    a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(192820);
      return true;
      label309:
      if (!h.a.hO(paramContext.getContext()).mEnabled)
      {
        a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.HUN == null) {
          paramContext.fhv();
        }
        paramContext.HUN.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(192821);
    Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(2147483647);
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
            AppMethodBeat.o(192821);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(192821);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */