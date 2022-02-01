package com.tencent.mm.plugin.performance.jectl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
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
  private static MultiProcessMMKV GOk;
  private static final long GOl;
  private static final IListener<qq> GOm;
  
  static
  {
    AppMethodBeat.i(200783);
    GOk = MultiProcessMMKV.getMMKV("diagnostic_storage");
    GOl = TimeUnit.DAYS.toMillis(1L);
    GOm = new IListener()
    {
      private long GOn;
      
      private boolean bnS()
      {
        AppMethodBeat.i(201352);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.GOn;
        Log.i("MicroMsg.JeVersion", "currentMillis - mLastReportTimeMillis = %s", new Object[] { Long.valueOf(l2) });
        if (l2 < JeVersion.GOl)
        {
          Log.i("MicroMsg.JeVersion", "not report");
          AppMethodBeat.o(201352);
          return false;
        }
        this.GOn = l1;
        JeVersion.aFH().encode("JV_KEY_LAST_REPORT_TIME_MILLIS_LONG", this.GOn);
        try
        {
          JeVersion.foi();
          AppMethodBeat.o(201352);
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
    AppMethodBeat.o(200783);
  }
  
  private static void aUu(String paramString)
  {
    AppMethodBeat.i(200778);
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
      com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, false);
      Log.i("MicroMsg.JeVersion", "report done");
      AppMethodBeat.o(200778);
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
  
  public static void fof()
  {
    AppMethodBeat.i(200768);
    if (BuildInfo.IS_ARM64)
    {
      Log.i("MicroMsg.JeVersion", "it's none of arm64's business");
      AppMethodBeat.o(200768);
      return;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vXR, true))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.JeVersion", "not enabled");
      AppMethodBeat.o(200768);
      return;
    }
    GOm.alive();
    CrashReportFactory.addCrashReportExtraMessageGetter(new ICrashReporter.ICrashReportExtraMessageGetter()
    {
      public final String getCrashReportExtraMessage()
      {
        AppMethodBeat.i(200737);
        String str = JeVersion.fog();
        if (TextUtils.isEmpty(str))
        {
          AppMethodBeat.o(200737);
          return "";
        }
        str = "jemalloc:".concat(String.valueOf(str));
        AppMethodBeat.o(200737);
        return str;
      }
    });
    AppMethodBeat.o(200768);
  }
  
  public static String fog()
  {
    AppMethodBeat.i(200769);
    String str = GOk.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
    AppMethodBeat.o(200769);
    return str;
  }
  
  public static boolean foh()
  {
    AppMethodBeat.i(200772);
    String str = fog();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(200772);
      return false;
    }
    boolean bool = str.startsWith("5.");
    AppMethodBeat.o(200772);
    return bool;
  }
  
  public static void foi()
  {
    AppMethodBeat.i(200774);
    String str = GOk.decodeString("JV_KEY_LAST_FINGERPRINT_STRING", "");
    if (Build.FINGERPRINT.equalsIgnoreCase(str))
    {
      str = GOk.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.JeVersion", "lastVersion is empty");
        foj();
        AppMethodBeat.o(200774);
        return;
      }
      aUu(str);
      AppMethodBeat.o(200774);
      return;
    }
    Log.i("MicroMsg.JeVersion", "finger print changed");
    foj();
    AppMethodBeat.o(200774);
  }
  
  private static void foj()
  {
    AppMethodBeat.i(200780);
    Log.i("MicroMsg.JeVersion", "reportJeVersionHard");
    MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeService.class));
    AppMethodBeat.o(200780);
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
      AppMethodBeat.i(200866);
      super.onDestroy();
      Log.d("MicroMsg.JeVersion", "onDestroy");
      com.tencent.e.h.ZvG.o(new JeVersion.JeService.3(this), 60000L);
      AppMethodBeat.o(200866);
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200864);
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200567);
          JeVersion.JeService.a(JeVersion.JeService.this);
          JeVersion.access$300();
          JeVersion.JeService.this.stopSelf();
          AppMethodBeat.o(200567);
        }
      });
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(200864);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.jectl.JeVersion
 * JD-Core Version:    0.7.0.1
 */