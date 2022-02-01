package com.tencent.mm.plugin.performance.jectl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class JeVersion
{
  private static final long MLA;
  private static final IListener<se> MLB;
  private static MultiProcessMMKV MLz;
  
  static
  {
    AppMethodBeat.i(300852);
    MLz = MultiProcessMMKV.getMMKV("diagnostic_storage");
    MLA = TimeUnit.DAYS.toMillis(1L);
    MLB = new IListener(f.hfK)
    {
      private long MLC;
      
      private boolean bLF()
      {
        AppMethodBeat.i(300798);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.MLC;
        Log.i("MicroMsg.JeVersion", "currentMillis - mLastReportTimeMillis = %s", new Object[] { Long.valueOf(l2) });
        if (l2 < JeVersion.MLA)
        {
          Log.i("MicroMsg.JeVersion", "not report");
          AppMethodBeat.o(300798);
          return false;
        }
        this.MLC = l1;
        JeVersion.aYH().encode("JV_KEY_LAST_REPORT_TIME_MILLIS_LONG", this.MLC);
        try
        {
          JeVersion.gzd();
          AppMethodBeat.o(300798);
          return false;
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JeVersion", localThrowable, "", new Object[0]);
          }
        }
      }
    };
    AppMethodBeat.o(300852);
  }
  
  private static void aRC(String paramString)
  {
    AppMethodBeat.i(300839);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1446, 20, 1));
    int i;
    if (paramString.startsWith("5.1.0")) {
      i = 21;
    }
    for (;;)
    {
      Log.i("MicroMsg.JeVersion", "je version = %s", new Object[] { paramString });
      localArrayList.add(new IDKey(1446, i, 1));
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, false);
      Log.i("MicroMsg.JeVersion", "report done");
      AppMethodBeat.o(300839);
      return;
      if (paramString.startsWith("5.0.1")) {
        i = 22;
      } else if (paramString.startsWith("4.4.0")) {
        i = 23;
      } else if (paramString.startsWith("4.")) {
        i = 24;
      } else if (paramString.startsWith("3.")) {
        i = 25;
      } else if (paramString.startsWith("64-bit")) {
        i = 26;
      } else if (paramString.startsWith("Error")) {
        i = 27;
      } else if (paramString.startsWith("Exception")) {
        i = 28;
      } else if (paramString.startsWith("CrashTooManyTimes")) {
        i = 29;
      } else {
        i = 30;
      }
    }
  }
  
  public static void gza()
  {
    AppMethodBeat.i(300807);
    if (BuildInfo.IS_ARM64)
    {
      Log.i("MicroMsg.JeVersion", "it's none of arm64's business");
      AppMethodBeat.o(300807);
      return;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqG, true))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.JeVersion", "not enabled");
      AppMethodBeat.o(300807);
      return;
    }
    MLB.alive();
    CrashReportFactory.addCrashReportExtraMessageGetter(new ICrashReporter.ICrashReportExtraMessageGetter()
    {
      public final String getCrashReportExtraMessage()
      {
        AppMethodBeat.i(300802);
        String str = JeVersion.gzb();
        if (TextUtils.isEmpty(str))
        {
          AppMethodBeat.o(300802);
          return "";
        }
        str = "jemalloc:".concat(String.valueOf(str));
        AppMethodBeat.o(300802);
        return str;
      }
    });
    AppMethodBeat.o(300807);
  }
  
  public static String gzb()
  {
    AppMethodBeat.i(300814);
    String str = MLz.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
    AppMethodBeat.o(300814);
    return str;
  }
  
  public static boolean gzc()
  {
    AppMethodBeat.i(300824);
    String str = gzb();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(300824);
      return false;
    }
    boolean bool = str.startsWith("5.");
    AppMethodBeat.o(300824);
    return bool;
  }
  
  public static void gzd()
  {
    AppMethodBeat.i(300833);
    String str = MLz.decodeString("JV_KEY_LAST_FINGERPRINT_STRING", "");
    if (Build.FINGERPRINT.equalsIgnoreCase(str))
    {
      str = MLz.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.JeVersion", "lastVersion is empty");
        gze();
        AppMethodBeat.o(300833);
        return;
      }
      aRC(str);
      AppMethodBeat.o(300833);
      return;
    }
    Log.i("MicroMsg.JeVersion", "finger print changed");
    gze();
    AppMethodBeat.o(300833);
  }
  
  private static void gze()
  {
    AppMethodBeat.i(300846);
    Log.i("MicroMsg.JeVersion", "reportJeVersionHard");
    MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeService.class));
    AppMethodBeat.o(300846);
  }
  
  public static class JeService
    extends Service
  {
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(300811);
      super.onDestroy();
      Log.d("MicroMsg.JeVersion", "onDestroy");
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300815);
          Log.i("MicroMsg.JeVersion", "onDestroy: kill self");
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(300815);
        }
      }, 60000L);
      AppMethodBeat.o(300811);
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(300808);
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300804);
          JeVersion.JeService.a(JeVersion.JeService.this);
          JeVersion.access$300();
          JeVersion.JeService.this.stopSelf();
          AppMethodBeat.o(300804);
        }
      });
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(300808);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.jectl.JeVersion
 * JD-Core Version:    0.7.0.1
 */