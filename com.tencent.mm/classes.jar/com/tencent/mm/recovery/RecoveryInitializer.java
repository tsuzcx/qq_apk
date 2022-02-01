package com.tencent.mm.recovery;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.model.ct;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.recoveryv2.a.c;
import com.tencent.mm.recoveryv2.c;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.recoveryv2.k.b.a;
import com.tencent.mm.recoveryv2.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.k;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.entry.ApplicationLike;
import com.tinkerboots.sdk.a;
import com.tinkerboots.sdk.a.a;

public class RecoveryInitializer
{
  private static final int RECOVERY_SETTING_DEBUG = 30000;
  private static final String TAG = "MicroMsg.recovery.initializer";
  
  public static boolean init(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(242787);
    if (l.ma(paramContext))
    {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(242757);
          com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.initializer", "recovery process crash, thread = " + paramAnonymousThread.getName(), paramAnonymousThrowable);
          com.tencent.mm.recoveryv2.e.lO(RecoveryInitializer.this);
          AppMethodBeat.o(242757);
        }
      });
      for (;;)
      {
        try
        {
          MMApplicationContext.setContext(paramContext);
        }
        finally
        {
          com.tencent.mm.kernel.b.h localh;
          com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.initializer", "recovery process init error", localThrowable2);
          com.tencent.mm.recoveryv2.e.lO(paramContext);
          continue;
        }
        try
        {
          MMApplicationContext.setResources(com.tencent.mm.ce.d.a(paramContext.getResources(), paramContext, true));
          LocaleUtil.initLanguage(paramContext);
          localh = new com.tencent.mm.kernel.b.h(l.iRe(), com.tencent.mm.app.e.hfI.getApplication(), com.tencent.mm.app.e.hfI);
          localh.lsS = com.tencent.mm.booter.d.cO(localh.bGP);
          com.tencent.mm.kernel.h.a(localh);
          k.setContext(paramContext);
          com.tencent.threadpool.g.a(localh.bGP, new aa());
          PlatformComm.init(MMApplicationContext.getContext(), new MMHandler(Looper.getMainLooper()));
          ct.bDF();
          a.a(new a.a(com.tencent.mm.app.e.hfI).a(new b.1(paramContext)).kks());
          l.iRc().a("diagnostic_mmkv_reset", new a.1("diagnostic_storage"));
          l.iRc().a("jectl_mmkv_reset", new a.2("jectl_config"));
          AppMethodBeat.o(242787);
          return false;
        }
        finally
        {
          com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.initializer", "init MMResources fail", localThrowable1);
        }
      }
    }
    if (!l.lZ(paramContext))
    {
      AppMethodBeat.o(242787);
      return true;
    }
    try
    {
      boolean bool = isStartWithActivity(paramContext);
      i = bool;
    }
    finally
    {
      for (;;)
      {
        com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.initializer", "check isStartWithActivity error", localThrowable3);
      }
      Object localObject = com.tencent.mm.recoveryv2.h.lR(paramContext);
      ((com.tencent.mm.recoveryv2.h)localObject).ackh = 0L;
      ((com.tencent.mm.recoveryv2.h)localObject).sz();
      localObject = l.iRc();
      if (paramContext == null) {
        break label293;
      }
      ((l)localObject).mContext = paramContext;
      paramContext = new a.c()
      {
        public final Class<? extends Activity> iQy()
        {
          return RecoveryUI.class;
        }
        
        public final Class<? extends Service> iQz()
        {
          return WXRecoveryUploadService.class;
        }
      };
      if (((l)localObject).ackR != null) {
        break label312;
      }
      ((l)localObject).iRd();
      ((l)localObject).ackR.a(paramContext);
      paramContext = ((l)localObject).b(1, new c()
      {
        public final void axN(int paramAnonymousInt)
        {
          AppMethodBeat.i(242759);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(242759);
        }
      }).b(2, new c()
      {
        public final void axN(int paramAnonymousInt)
        {
          AppMethodBeat.i(242755);
          Log.e("MicroMsg.recovery.initializer", "onRecovery, level = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(242755);
        }
      });
      if (l.lZ(paramContext.getContext())) {
        break label374;
      }
    }
    if (i == 0)
    {
      com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.initializer", "isStartWithActivity = false, skip recovery detect");
      AppMethodBeat.o(242787);
      return true;
    }
    label293:
    label312:
    k.b.a.log(4, "MicroMsg.recovery", "not main proc, skip");
    for (;;)
    {
      AppMethodBeat.o(242787);
      return true;
      label374:
      if (!h.a.lS(paramContext.getContext()).mEnabled)
      {
        k.b.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      }
      else
      {
        if (paramContext.ackR == null) {
          paramContext.iRd();
        }
        paramContext.ackR.begin();
      }
    }
  }
  
  private static boolean isStartWithActivity(Context paramContext)
  {
    AppMethodBeat.i(242788);
    boolean bool = l.mb(paramContext);
    AppMethodBeat.o(242788);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recovery.RecoveryInitializer
 * JD-Core Version:    0.7.0.1
 */