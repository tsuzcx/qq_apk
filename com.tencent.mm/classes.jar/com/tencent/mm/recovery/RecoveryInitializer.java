package com.tencent.mm.recovery;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.bz.a.a;
import com.tencent.mm.bz.e;
import com.tencent.mm.bz.g.a;
import com.tencent.mm.bz.i;
import com.tencent.mm.bz.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
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
    AppMethodBeat.i(194716);
    try
    {
      bool = isStartWithActivity(paramContext);
      if (!bool)
      {
        e.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
        AppMethodBeat.o(194716);
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
      if (j.hL(paramContext))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(194712);
            e.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
            e.hF(this.val$context);
            AppMethodBeat.o(194712);
          }
        });
        try
        {
          ai.setContext(paramContext);
          h localh = new h(j.eSd(), com.tencent.mm.app.d.cIg.getApplication(), com.tencent.mm.app.d.cIg);
          localh.fnq = com.tencent.mm.booter.d.bK(localh.ca);
          localh.fnq.rq("RECOVERY");
          com.tencent.mm.kernel.g.a(localh);
          com.tencent.mm.vfs.a.setContext(paramContext);
          com.tencent.e.g.a(localh.ca, new aa());
          PlatformComm.init(ai.getContext(), new ao(Looper.getMainLooper()));
          a.hD(paramContext);
          AppMethodBeat.o(194716);
          return false;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            e.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable2);
            e.hF(paramContext);
          }
        }
      }
      if (!j.hK(paramContext))
      {
        AppMethodBeat.o(194716);
        return true;
      }
      j localj = j.eSb();
      if (paramContext != null) {
        localj.mContext = paramContext;
      }
      paramContext = new RecoveryInitializer.4();
      if (localj.Gjb == null) {
        localj.eSc();
      }
      localj.Gjb.a(paramContext);
      paramContext = localj.b(1, new RecoveryInitializer.3()).b(2, new RecoveryInitializer.2());
      if (j.hK(paramContext.getContext())) {
        break label275;
      }
    }
    a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(194716);
      return true;
      label275:
      if (!g.a.hH(paramContext.getContext()).mEnabled)
      {
        a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.Gjb == null) {
          paramContext.eSc();
        }
        paramContext.Gjb.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(194717);
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
            AppMethodBeat.o(194717);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(194717);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */