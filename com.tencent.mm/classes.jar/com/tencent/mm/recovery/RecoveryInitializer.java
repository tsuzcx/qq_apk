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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.e;
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
    AppMethodBeat.i(186143);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        f.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(186143);
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
      if (k.ia(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(186140);
            f.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            f.hS(this.val$context);
            AppMethodBeat.o(186140);
          }
        });
        for (;;)
        {
          try
          {
            ak.setContext(paramContext);
          }
          catch (Throwable localThrowable3)
          {
            h localh;
            f.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable3);
            f.hS(paramContext);
            continue;
          }
          try
          {
            ak.h(com.tencent.mm.cc.b.a(paramContext.getResources(), paramContext, true));
            ad.initLanguage(paramContext);
            localh = new h(k.flo(), com.tencent.mm.app.d.cTZ.getApplication(), com.tencent.mm.app.d.cTZ);
            localh.fHC = com.tencent.mm.booter.d.bL(localh.ca);
            com.tencent.mm.kernel.g.a(localh);
            e.setContext(paramContext);
            com.tencent.e.g.a(localh.ca, new aa());
            PlatformComm.init(ak.getContext(), new aq(Looper.getMainLooper()));
            b.hO(paramContext);
            k.flm().a("diagnostic_mmkv_reset", new a.1("diagnostic_storage"));
            k.flm().a("jectl_mmkv_reset", new a.2("jectl_config"));
            AppMethodBeat.o(186143);
            return false;
          }
          catch (Throwable localThrowable2)
          {
            f.w("MicroMsg.recovery.initializer", "init MMResources fail", localThrowable2);
          }
        }
      }
      if (!k.hZ(paramContext))
      {
        AppMethodBeat.o(186143);
        return true;
      }
      k localk = k.flm();
      if (paramContext != null) {
        localk.mContext = paramContext;
      }
      paramContext = new b.c()
      {
        public final Class<? extends Activity> fkK()
        {
          return RecoveryUI.class;
        }
        
        public final Class<? extends Service> fkL()
        {
          return WXRecoveryUploadService.class;
        }
      };
      if (localk.IoV == null) {
        localk.fln();
      }
      localk.IoV.a(paramContext);
      paramContext = localk.b(1, new com.tencent.mm.recoveryv2.d()
      {
        public final void aaB(int paramAnonymousInt)
        {
          AppMethodBeat.i(186142);
          ae.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(186142);
        }
      }).b(2, new com.tencent.mm.recoveryv2.d()
      {
        public final void aaB(int paramAnonymousInt)
        {
          AppMethodBeat.i(186141);
          ae.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(186141);
        }
      });
      if (k.hZ(paramContext.getContext())) {
        break label329;
      }
    }
    a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(186143);
      return true;
      label329:
      if (!h.a.hU(paramContext.getContext()).mEnabled)
      {
        a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.IoV == null) {
          paramContext.fln();
        }
        paramContext.IoV.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(186144);
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
              AppMethodBeat.o(186144);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(186144);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */