package com.tencent.mm.plugin.performance.jectl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class JeVersion
{
  private static MultiProcessMMKV AUP;
  private static final long AUQ;
  private static final IListener<ps> AUR;
  
  static
  {
    AppMethodBeat.i(201116);
    AUP = MultiProcessMMKV.getMMKV("diagnostic_storage");
    AUQ = TimeUnit.DAYS.toMillis(1L);
    AUR = new IListener()
    {
      private long AUS;
      
      private boolean bet()
      {
        AppMethodBeat.i(201102);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.AUS;
        Log.i("MicroMsg.JeVersion", "currentMillis - mLastReportTimeMillis = %s", new Object[] { Long.valueOf(l2) });
        if (l2 < JeVersion.AUQ)
        {
          Log.i("MicroMsg.JeVersion", "not report");
          AppMethodBeat.o(201102);
          return false;
        }
        this.AUS = l1;
        JeVersion.ayo().encode("JV_KEY_LAST_REPORT_TIME_MILLIS_LONG", this.AUS);
        try
        {
          JeVersion.eCw();
          AppMethodBeat.o(201102);
          return false;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JeVersion", localThrowable, "", new Object[0]);
          }
        }
      }
    };
    AppMethodBeat.o(201116);
  }
  
  private static void aJY(String paramString)
  {
    AppMethodBeat.i(201113);
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
      com.tencent.mm.plugin.report.service.h.CyF.b(localArrayList, false);
      Log.i("MicroMsg.JeVersion", "report done");
      AppMethodBeat.o(201113);
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
  
  public static void eCv()
  {
    AppMethodBeat.i(201111);
    if (BuildInfo.IS_ARM64)
    {
      Log.i("MicroMsg.JeVersion", "it's none of arm64's business");
      AppMethodBeat.o(201111);
      return;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (((b)g.af(b.class)).a(b.a.smR, false))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.JeVersion", "not enabled");
      AppMethodBeat.o(201111);
      return;
    }
    AUR.alive();
    CrashReportFactory.addCrashReportExtraMessageGetter(new ICrashReporter.ICrashReportExtraMessageGetter()
    {
      public final String getCrashReportExtraMessage()
      {
        AppMethodBeat.i(201104);
        String str = JeVersion.ayo().decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
        if (TextUtils.isEmpty(str))
        {
          AppMethodBeat.o(201104);
          return "";
        }
        str = "jemalloc:".concat(String.valueOf(str));
        AppMethodBeat.o(201104);
        return str;
      }
    });
    AppMethodBeat.o(201111);
  }
  
  public static void eCw()
  {
    AppMethodBeat.i(201112);
    String str = AUP.decodeString("JV_KEY_LAST_FINGERPRINT_STRING", "");
    if (Build.FINGERPRINT.equalsIgnoreCase(str))
    {
      str = AUP.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.JeVersion", "lastVersion is empty");
        eCx();
        AppMethodBeat.o(201112);
        return;
      }
      aJY(str);
      AppMethodBeat.o(201112);
      return;
    }
    Log.i("MicroMsg.JeVersion", "finger print changed");
    eCx();
    AppMethodBeat.o(201112);
  }
  
  private static void eCx()
  {
    AppMethodBeat.i(201114);
    Log.i("MicroMsg.JeVersion", "reportJeVersionHard");
    MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeService.class));
    AppMethodBeat.o(201114);
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
      AppMethodBeat.i(201109);
      super.onDestroy();
      Log.d("MicroMsg.JeVersion", "onDestroy");
      com.tencent.f.h.RTc.o(new JeVersion.JeService.3(this), 60000L);
      AppMethodBeat.o(201109);
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201108);
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201105);
          JeVersion.JeService.a(JeVersion.JeService.this);
          JeVersion.access$300();
          JeVersion.JeService.this.stopSelf();
          AppMethodBeat.o(201105);
        }
      });
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(201108);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.jectl.JeVersion
 * JD-Core Version:    0.7.0.1
 */