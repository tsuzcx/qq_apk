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
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.cr;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.recoveryv2.b.c;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.entry.ApplicationLike;
import com.tinkerboots.sdk.a;
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
    AppMethodBeat.i(193894);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        f.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(193894);
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
      if (k.iT(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(193891);
            f.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            f.iL(this.val$context);
            AppMethodBeat.o(193891);
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
            h localh;
            f.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable3);
            f.iL(paramContext);
            continue;
          }
          try
          {
            MMApplicationContext.setResources(b.a(paramContext.getResources(), paramContext, true));
            LocaleUtil.initLanguage(paramContext);
            localh = new h(k.guZ(), com.tencent.mm.app.d.dks.getApplication(), com.tencent.mm.app.d.dks);
            localh.gmN = com.tencent.mm.booter.d.cg(localh.ca);
            com.tencent.mm.kernel.g.a(localh);
            com.tencent.mm.vfs.g.setContext(paramContext);
            com.tencent.f.g.a(localh.ca, new aa());
            PlatformComm.init(MMApplicationContext.getContext(), new MMHandler(Looper.getMainLooper()));
            cr.aWI();
            a.a(new com.tinkerboots.sdk.a.a(com.tencent.mm.app.d.dks).a(new b.1(paramContext)).hvY());
            k.guX().a("diagnostic_mmkv_reset", new a.1("diagnostic_storage"));
            k.guX().a("jectl_mmkv_reset", new a.2("jectl_config"));
            AppMethodBeat.o(193894);
            return false;
          }
          catch (Throwable localThrowable2)
          {
            f.w("MicroMsg.recovery.initializer", "init MMResources fail", localThrowable2);
          }
        }
      }
      if (!k.iS(paramContext))
      {
        AppMethodBeat.o(193894);
        return true;
      }
      k localk = k.guX();
      if (paramContext != null) {
        localk.mContext = paramContext;
      }
      paramContext = new b.c()
      {
        public final Class<? extends Activity> guw()
        {
          return RecoveryUI.class;
        }
        
        public final Class<? extends Service> gux()
        {
          return WXRecoveryUploadService.class;
        }
      };
      if (localk.NCs == null) {
        localk.guY();
      }
      localk.NCs.a(paramContext);
      paramContext = localk.b(1, new com.tencent.mm.recoveryv2.d()
      {
        public final void ajq(int paramAnonymousInt)
        {
          AppMethodBeat.i(193893);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(193893);
        }
      }).b(2, new com.tencent.mm.recoveryv2.d()
      {
        public final void ajq(int paramAnonymousInt)
        {
          AppMethodBeat.i(193892);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(193892);
        }
      });
      if (k.iS(paramContext.getContext())) {
        break label358;
      }
    }
    com.tencent.mm.recoveryv2.a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(193894);
      return true;
      label358:
      if (!h.a.iN(paramContext.getContext()).mEnabled)
      {
        com.tencent.mm.recoveryv2.a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.NCs == null) {
          paramContext.guY();
        }
        paramContext.NCs.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(193895);
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
              AppMethodBeat.o(193895);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(193895);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */