package com.tencent.mm.recovery;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.z;
import com.tencent.mm.ca.a.a;
import com.tencent.mm.ca.b;
import com.tencent.mm.ca.c;
import com.tencent.mm.ca.e;
import com.tencent.mm.ca.g.a;
import com.tencent.mm.ca.i;
import com.tencent.mm.ca.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
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
    AppMethodBeat.i(190206);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        e.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(190206);
        return true;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        e.w("MicroMsg.recovery.initializer", "check isStartWithActivity error", localThrowable1);
        boolean bool = false;
      }
      if (j.hA(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(190202);
            e.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            e.hu(this.val$context);
            AppMethodBeat.o(190202);
          }
        });
        try
        {
          aj.setContext(paramContext);
          h localh = new h(j.eCJ(), com.tencent.mm.app.d.cKY.getApplication(), com.tencent.mm.app.d.cKY);
          localh.fjW = com.tencent.mm.booter.d.bH(localh.ca);
          localh.fjW.ok("RECOVERY");
          com.tencent.mm.kernel.g.a(localh);
          com.tencent.mm.vfs.a.setContext(paramContext);
          com.tencent.e.g.a(localh.ca, new z());
          PlatformComm.init(aj.getContext(), new ap(Looper.getMainLooper()));
          a.hs(paramContext);
          AppMethodBeat.o(190206);
          return false;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            e.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable2);
            e.hu(paramContext);
          }
        }
      }
      if (!j.hz(paramContext))
      {
        AppMethodBeat.o(190206);
        return true;
      }
      j localj = j.eCH();
      if (paramContext != null) {
        localj.mContext = paramContext;
      }
      paramContext = new b()
      {
        public final void a(Context paramAnonymousContext, c paramAnonymousc)
        {
          AppMethodBeat.i(190205);
          Intent localIntent = new Intent();
          localIntent.putExtra("extra_crash_count", paramAnonymousc.ELm);
          localIntent.setClass(paramAnonymousContext, RecoveryUI.class);
          localIntent.addFlags(276824064);
          paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, paramAnonymousc.adn(), "com/tencent/mm/recovery/RecoveryInitializer$4", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousContext.startActivity((Intent)paramAnonymousc.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, "com/tencent/mm/recovery/RecoveryInitializer$4", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(190205);
        }
      };
      if (localj.ELP == null) {
        localj.eCI();
      }
      localj.ELP.a(paramContext);
      paramContext = localj.b(1, new com.tencent.mm.ca.d()
      {
        public final void VQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(190204);
          ad.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(190204);
        }
      }).b(2, new com.tencent.mm.ca.d()
      {
        public final void VQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(190203);
          ad.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(190203);
        }
      });
      if (j.hz(paramContext.getContext())) {
        break label275;
      }
    }
    a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(190206);
      return true;
      label275:
      if (!g.a.hw(paramContext.getContext()).mEnabled)
      {
        a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.ELP == null) {
          paramContext.eCI();
        }
        paramContext.ELP.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(190207);
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
            AppMethodBeat.o(190207);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(190207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */